package com.duoduolicai360.goodtv.mvp.base;

import com.hannesdorfmann.mosby.mvp.MvpView;

/**
 * Created by swg on 2017/9/18.
 */

public interface BaseView extends MvpView {

    void showProgress();

    void onCompleted();

    void onError(Throwable e);

}
