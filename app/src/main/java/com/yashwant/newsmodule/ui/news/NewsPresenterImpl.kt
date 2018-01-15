package com.yashwant.newsmodule.ui.news

import android.content.Context


import com.yashwant.newsmodule.app.NewsApplication
import com.yashwant.newsmodule.app.Utility
import com.yashwant.newsmodule.model.HNews
import com.yashwant.newsmodule.network.NewsApi

import javax.inject.Inject

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by yashwant on 16/10/17.
 */

class NewsPresenterImpl(context: Context) : NewsPresenter {

    private var view: NewsView? = null
    @Inject
    internal var newsApi: NewsApi? = null


    init {
        (context as NewsApplication).appComponent!!.inject(this)
    }

    override fun setView(view: NewsView) {
        this.view = view

    }

    override fun getNews(query: String) {
        if (Utility.isNetworkAvailable(view!!.context)) {
            view!!.showLoading()

            newsApi!!.getNews(query)
                    .subscribeOn(Schedulers.io())
                    .map<List<Hit>>(Function<HNews, List<Hit>> { it.getHits() })
                    .flatMapIterable<Hit> { hits -> hits }
                    .filter { hit -> hit.title != null }
                    .toList()
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({ hits ->
                        if (view != null) {
                            view!!.hideLoading()
                            view!!.showNews(hits)
                        }

                    }) { throwable ->
                        if (view != null) {
                            view!!.hideLoading()
                            showError()
                        }
                    }
        } else {
            showError()
        }

    }
    /*
   * Private
   */

    private fun showError() {
        view!!.showErrorMessage()
    }

}
