package com.duoduolicai360.goodtv.di.component;

import android.content.Context;

import com.duoduolicai360.goodtv.App;
import com.duoduolicai360.goodtv.di.module.AppModule;
import com.duoduolicai360.goodtv.http.APIService;

import javax.inject.Singleton;

import dagger.Component;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * Created by swg on 2017/9/19.
 */
@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {

    void inject(App app);

    Context getContext();

    Retrofit getRetrofit();

    OkHttpClient getOkHttpClient();

    APIService getAPIService();

}
