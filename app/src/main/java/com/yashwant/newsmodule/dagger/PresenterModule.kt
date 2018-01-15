package com.yashwant.newsmodule.dagger

import android.content.Context


import com.yashwant.newsmodule.ui.news.NewsPresenter
import com.yashwant.newsmodule.ui.news.NewsPresenterImpl

import javax.inject.Singleton

import dagger.Module
import dagger.Provides

/**
 * Created by yashwant on 16/10/17.
 */
@Module
class PresenterModule {
    @Provides
    @Singleton
    internal fun provideNewsPresenter(context: Context): NewsPresenter {
        return NewsPresenterImpl(context)
    }

}
