package com.yashwant.newsmodule.app

import android.app.Application

import com.yashwant.newsmodule.dagger.AppComponent
import com.yashwant.newsmodule.dagger.AppModule
import com.yashwant.newsmodule.dagger.DaggerAppComponent


/**
 * Created by yashwant on 16/10/17.
 */

class NewsApplication : Application() {

    var appComponent: AppComponent? = null
        private set

    override fun onCreate() {
        super.onCreate()
        appComponent = initDagger(this)

    }

    protected fun initDagger(application: NewsApplication): AppComponent {
        return DaggerAppComponent.builder()
                .appModule(AppModule(application))
                .build()
    }
}
