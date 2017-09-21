package com.duoduolicai360.goodtv.di.module;

import com.duoduolicai360.goodtv.App;
import com.duoduolicai360.goodtv.di.scope.FragmentScope;
import com.duoduolicai360.goodtv.mvp.presenter.CategoryPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by swg on 2017/9/18.
 */
@Module
public class CateroyModule {

    private App app;

    public CateroyModule(App app){
        this.app = app;
    }


    @FragmentScope
    @Provides
    public CategoryPresenter provideCateroyPresenter(){
        return new CategoryPresenter(app);
    }

}
