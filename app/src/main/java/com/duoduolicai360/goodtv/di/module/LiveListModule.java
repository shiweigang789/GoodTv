package com.duoduolicai360.goodtv.di.module;

import com.duoduolicai360.goodtv.App;
import com.duoduolicai360.goodtv.di.scope.FragmentScope;
import com.duoduolicai360.goodtv.mvp.presenter.LiveListPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by swg on 2017/9/18.
 */
@Module
public class LiveListModule {

    private App app;

    public LiveListModule(App app){
        this.app = app;
    }

    @FragmentScope
    @Provides
    public LiveListPresenter provideLiveListPresenter(){
        return new LiveListPresenter(app);
    }

}
