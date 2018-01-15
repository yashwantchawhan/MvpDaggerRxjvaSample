package com.yashwant.newsmodule.dagger;

import android.content.Context;


import com.yashwant.newsmodule.ui.news.NewsPresenter;
import com.yashwant.newsmodule.ui.news.NewsPresenterImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by yashwant on 16/10/17.
 */
@Module
public class PresenterModule {
    @Provides
    @Singleton
    NewsPresenter provideNewsPresenter(Context context) {
        return new NewsPresenterImpl(context);
    }

}
