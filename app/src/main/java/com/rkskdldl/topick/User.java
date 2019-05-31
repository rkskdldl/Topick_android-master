package com.rkskdldl.topick;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("nickname")
    @Expose
    public String nickname;
    @SerializedName("phonenumber")
    @Expose
    public String phonenumber;
    @SerializedName("deviceid")
    @Expose
    public String deviceid;
    @SerializedName("_point")
    @Expose
    public int  _point;
    @SerializedName("_key")
    @Expose
    public int _key;

    public User(String nickname, String phonenumber, String deviceId, int _point, int _key) {

        this.nickname = nickname;
        this.phonenumber = phonenumber;
        deviceid = deviceId;
        this._point = _point;
        this._key = _key;
    }



    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getDeviceId() {
        return deviceid;
    }

    public void setDeviceId(String deviceId) {
        deviceid = deviceId;
    }

    public int get_point() {
        return _point;
    }

    public void set_point(int _point) {
        this._point = _point;
    }

    public int get_key() {
        return _key;
    }

    public void set_key(int _key) {
        this._key = _key;
    }
}
