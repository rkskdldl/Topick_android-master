package com.rkskdldl.topick;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.support.annotation.RequiresPermission;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileActivity extends AppCompatActivity {
    private static final String TODO = "";
    SharedPreferences prefs;
    EditText nickname;
    Button register;
    public static boolean first_open = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        prefs = getSharedPreferences("pref", Context.MODE_PRIVATE);
        initView();

        if (first_open == false) {
            SharedPreferences.Editor editor = prefs.edit();
            editor.putString("nickname", "");
            editor.commit();
            first_open = true;
        } else {

        }
    }

    void initView() {
        nickname = (EditText) findViewById(R.id.nickname);
        register = (Button) findViewById(R.id.register);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nickname.getText().length() >= 4) {
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putString("nickname", nickname.getText().toString());
                    editor.commit();
                    //네트워크 통신 부분 시작
                    ApiInterface apiService = APIclient.getClient().create(ApiInterface.class);
                    Call<Object> call = apiService.registerAPI(new User(nickname.getText().toString(), GetPhoneNumber(getApplicationContext()), GetDeviceId(getApplicationContext()), 0, 0));
                    call.enqueue(new Callback<Object>() {
                        @Override
                        public void onResponse(Call<Object> call, Response<Object> response) {
                            Log.d("success", response.body().toString());
                            Toast.makeText(getApplicationContext(), response.body().toString(), Toast.LENGTH_SHORT).show();
                            Toast.makeText(getApplicationContext(), "응답 다음", Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onFailure(Call<Object> call, Throwable t) {
                            Log.e("error", t.toString());
                        }
                    });
                } else {
                    Toast.makeText(getApplicationContext(), "아이디를 4글자 이상 해주세요", Toast.LENGTH_SHORT).show();
                }


            }
        });
    }

    String GetPhoneNumber(Context context) {
        try {


            TelephonyManager telManager = (TelephonyManager) context.getSystemService(context.TELEPHONY_SERVICE);
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_SMS) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_NUMBERS) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return TODO;
            }
            String PhoneNum = telManager.getLine1Number();
            if (PhoneNum.startsWith("+82")) {
                PhoneNum = PhoneNum.replace("+82", "0");
            }
            return PhoneNum;
        } catch (Exception e) {
            Log.e("error",e.toString());
            return null;
        }


    }

    String GetDeviceId(Context context) {
        TelephonyManager mgr = (TelephonyManager) context.getSystemService(context.TELEPHONY_SERVICE);
        try {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return TODO;
            }
            String idByTelephonyManager = mgr.getDeviceId();
           return idByTelephonyManager;
       }catch (Exception e){
            Log.e("error",e.toString());
           return  null;
       }


    }
}
