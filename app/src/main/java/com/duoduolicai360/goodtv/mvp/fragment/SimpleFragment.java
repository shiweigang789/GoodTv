package com.duoduolicai360.goodtv.mvp.fragment;

import com.duoduolicai360.goodtv.mvp.base.BaseFragment;
import com.duoduolicai360.goodtv.mvp.base.BasePresenter;
import com.duoduolicai360.goodtv.mvp.base.BaseView;

/**
 * Created by swg on 2017/9/22.
 */

public abstract class SimpleFragment extends BaseFragment<BaseView,BasePresenter<BaseView>> {

    @Override
    public BasePresenter<BaseView> createPresenter() {
        return new BasePresenter<>(getApp());
    }
    
}