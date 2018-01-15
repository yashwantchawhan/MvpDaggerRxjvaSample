package com.yashwant.newsmodule.app;

import android.app.Application;

import com.yashwant.newsmodule.dagger.AppComponent;
import com.yashwant.newsmodule.dagger.AppModule;
import com.yashwant.newsmodule.dagger.DaggerAppComponent;


/**
 * Created by yashwant on 16/10/17.
 */

public class NewsApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = initDagger(this);

    }

    private AppComponent appComponent;

    public AppComponent getAppComponent() {
        return appComponent;
    }

    protected AppComponent initDagger(NewsApplication application) {
        return DaggerAppComponent.builder()
                .appModule(new AppModule(application))
                .build();
    }
}
