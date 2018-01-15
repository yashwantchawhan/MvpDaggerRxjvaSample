package com.yashwant.newsmodule.ui.news

import android.content.Context


import com.yashwant.newsmodule.model.Hit

/**
 * Created by yashwant on 16/10/17.
 */

interface NewsView {

    val context: Context
    fun showLoading()

    fun hideLoading()

    fun showNews(newsList: List<Hit>)

    fun showErrorMessage()

    fun launchNewsDetail(news: Hit)
}
