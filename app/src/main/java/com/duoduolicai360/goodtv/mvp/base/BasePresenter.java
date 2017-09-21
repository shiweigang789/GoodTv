package com.duoduolicai360.goodtv.mvp.base;

import com.duoduolicai360.goodtv.App;
import com.duoduolicai360.goodtv.di.component.AppComponent;
import com.duoduolicai360.goodtv.greendao.DaoSession;
import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;
import com.king.base.util.LogUtils;

import javax.inject.Inject;

/**
 * Created by swg on 2017/9/19.
 */

public class BasePresenter<V extends BaseView> extends MvpBasePresenter<V> {

    private App mApp;

    private DaoSession mDaoSession;

    private AppComponent mAppComponent;

    @Inject
    public BasePresenter(App app){
        super();
        mApp = app;
        mDaoSession = app.getDaoSession();
        mAppComponent = app.getAppCommponent();
    }

    public AppComponent getAppComponent(){
        return mAppComponent;
    }

    public DaoSession getDaoSession(){
        return mDaoSession;
    }

    public App getApp(){
        return mApp;
    }

    @Override
    public boolean isViewAttached() {
        LogUtils.d("isViewAttached:" + super.isViewAttached());
        return super.isViewAttached();
    }

}
