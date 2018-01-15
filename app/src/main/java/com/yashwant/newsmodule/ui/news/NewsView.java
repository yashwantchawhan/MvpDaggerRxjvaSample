package com.yashwant.newsmodule.ui.news;

import android.content.Context;


import com.yashwant.newsmodule.model.Hit;

import java.util.List;

/**
 * Created by yashwant on 16/10/17.
 */

public interface NewsView {
    void showLoading();

    void hideLoading();

    void showNews(List<Hit> newsList);

    void showErrorMessage();

    void launchNewsDetail(Hit news);

    Context getContext();
}
