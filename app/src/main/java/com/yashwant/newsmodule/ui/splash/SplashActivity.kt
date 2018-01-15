package com.yashwant.newsmodule.ui.splash

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

import com.mvpdaggerrxjvasample.R
import com.yashwant.newsmodule.ui.news.NewsActivity


class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)


        val intent = Intent(this@SplashActivity, NewsActivity::class.java)
        startActivity(intent)
        finish()
    }
}

