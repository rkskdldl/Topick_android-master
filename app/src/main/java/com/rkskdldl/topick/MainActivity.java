package com.rkskdldl.topick;

import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TableLayout;

public class MainActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar =(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mViewPager =(ViewPager)findViewById(R.id.container);

        TabLayout tabLayout =(TabLayout) findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("홈"));
        tabLayout.addTab(tabLayout.newTab().setText("주제"));
        tabLayout.addTab(tabLayout.newTab().setText("상점"));
        tabLayout.addTab(tabLayout.newTab().setText("포인트 얻기"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager =(ViewPager)findViewById(R.id.pager);
        final PagerAdapter adapter  =new PagerAdapter((getSupportFragmentManager(),tabLayout.getTabCount());

//탭구현 참조 URL
  //      https://coding-factory.tistory.com/206

    }
}
