package com.yashwant.newsmodule.dagger


import com.yashwant.newsmodule.ui.news.NewsActivity
import com.yashwant.newsmodule.ui.news.NewsPresenterImpl

import javax.inject.Singleton

import dagger.Component

/**
 * Created by yashwant on 16/10/17.
 */

@Singleton
@Component(modules = arrayOf(AppModule::class, PresenterModule::class, NetworkModule::class))
interface AppComponent {
    fun inject(target: NewsActivity)
    fun inject(target: NewsPresenterImpl)
}
