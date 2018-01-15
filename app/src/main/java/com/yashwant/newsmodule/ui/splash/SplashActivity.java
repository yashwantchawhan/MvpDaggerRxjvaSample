package com.yashwant.newsmodule.ui.splash;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mvpdaggerrxjvasample.R;
import com.yashwant.newsmodule.ui.news.NewsActivity;


public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        Intent intent=new Intent(SplashActivity.this, NewsActivity.class);
        startActivity(intent);
        finish();
    }
}

