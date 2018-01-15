package com.yashwant.newsmodule.ui.news

/**
 * Created by yashwant on 16/10/17.
 */

interface NewsPresenter {
    fun setView(view: NewsView)

    fun getNews(query: String)
}
