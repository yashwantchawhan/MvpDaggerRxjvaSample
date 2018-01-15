package com.yashwant.newsmodule.ui.news;

import android.content.Context;


import com.yashwant.newsmodule.app.NewsApplication;
import com.yashwant.newsmodule.app.Utility;
import com.yashwant.newsmodule.model.HNews;
import com.yashwant.newsmodule.network.NewsApi;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by yashwant on 16/10/17.
 */

public class NewsPresenterImpl implements NewsPresenter {

    private NewsView view;
    @Inject
    NewsApi newsApi;


    public NewsPresenterImpl(Context context) {
        ((NewsApplication) context).getAppComponent().inject(this);
    }

    @Override
    public void setView(NewsView view) {
        this.view = view;

    }

    @Override
    public void getNews(String query) {
        if (Utility.isNetworkAvailable(view.getContext())) {
            view.showLoading();

            newsApi.getNews(query)
                    .subscribeOn(Schedulers.io())
                    .map(HNews::getHits)
                    .flatMapIterable(hits -> hits)
                    .filter(hit -> hit.getTitle()!=null)
                    .toList()
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(hits -> {
                        if(view!=null){
                            view.hideLoading();
                            view.showNews(hits);
                        }

                    }, throwable -> {
                        if(view!=null){
                            view.hideLoading();
                            showError();
                        }
                    });
        } else {
            showError();
        }

    }
    /*
   * Private
   */

    private void showError() {
        view.showErrorMessage();
    }

}
