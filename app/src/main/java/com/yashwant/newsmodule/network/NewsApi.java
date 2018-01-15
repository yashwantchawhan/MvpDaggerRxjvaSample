package com.yashwant.newsmodule.network;


import com.yashwant.newsmodule.model.HNews;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by yashwant on 16/10/17.
 */

public interface NewsApi {
    @GET("search")
    Observable<HNews> getNews(@Query("query") String query);
}
