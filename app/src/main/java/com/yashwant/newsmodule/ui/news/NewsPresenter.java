package com.yashwant.newsmodule.ui.news;

/**
 * Created by yashwant on 16/10/17.
 */

public interface NewsPresenter {
    void setView(NewsView view);

    void getNews(String query);
}
