package com.duoduolicai360.goodtv.di.component;

import com.duoduolicai360.goodtv.di.module.CateroyModule;
import com.duoduolicai360.goodtv.di.module.LiveListModule;
import com.duoduolicai360.goodtv.di.scope.FragmentScope;
import com.duoduolicai360.goodtv.mvp.fragment.HomeFragment;
import com.duoduolicai360.goodtv.mvp.fragment.LiveListFragment;
import com.duoduolicai360.goodtv.mvp.presenter.CategoryPresenter;
import com.duoduolicai360.goodtv.mvp.presenter.LiveListPresenter;

import dagger.Component;

/**
 * Created by Administrator on 2017/9/21.
 */
@FragmentScope
@Component(modules = {CateroyModule.class, LiveListModule.class}, dependencies = AppComponent.class)
public interface HomeComponent {

    void inject(HomeFragment homeFragment);
    void inject(LiveListFragment liveListFragment);

    CategoryPresenter getCateroyPresenter();

    LiveListPresenter getLiveListPresenter();

}
