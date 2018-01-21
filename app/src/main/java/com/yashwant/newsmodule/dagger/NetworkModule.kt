package com.yashwant.newsmodule.dagger


import com.yashwant.newsmodule.app.Constants
import com.yashwant.newsmodule.network.NewsApi

import javax.inject.Named
import javax.inject.Singleton

import dagger.Module
import dagger.Provides
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by yashwant on 16/10/17.
 */

@Module
class NetworkModule {

    @Provides
    @Named(NAME_BASE_URL)
    internal fun provideBaseUrlString(): String {
        return Constants.BASE_URL
    }

    @Provides
    @Singleton
    internal fun provideGsonConverter(): Converter.Factory {
        return GsonConverterFactory.create()
    }

    @Provides
    @Singleton
    internal fun provideRetrofit(converter: Converter.Factory, @Named(NAME_BASE_URL) baseUrl: String): Retrofit {
        return Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(converter)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
    }

    @Provides
    @Singleton
    internal fun provideUsdaApi(retrofit: Retrofit): NewsApi {
        return retrofit.create(NewsApi::class.java!!)
    }

    companion object {
        private const val NAME_BASE_URL = "NAME_BASE_URL"
    }
}

