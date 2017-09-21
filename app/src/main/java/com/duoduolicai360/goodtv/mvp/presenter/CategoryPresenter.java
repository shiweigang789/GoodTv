package com.duoduolicai360.goodtv.mvp.presenter;

import com.duoduolicai360.goodtv.App;
import com.duoduolicai360.goodtv.bean.LiveCategory;
import com.duoduolicai360.goodtv.mvp.base.BasePresenter;
import com.duoduolicai360.goodtv.mvp.view.ICategoryView;
import com.duoduolicai360.goodtv.thread.ThreadPoolManager;
import com.king.base.util.LogUtils;

import java.util.List;

import javax.inject.Inject;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by swg on 2017/9/19.
 */

public class CategoryPresenter extends BasePresenter<ICategoryView> {

    @Inject
    public CategoryPresenter(App app) {
        super(app);
    }

    public void getAllCategories(){
        if(isViewAttached()) {
            getView().showProgress();
        }
        getAppComponent().getAPIService()
                .getAllCategories()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<LiveCategory>>() {
                    @Override
                    public void onCompleted() {
                        if (isViewAttached()){
                            getView().onCompleted();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (isViewAttached()){
                            getView().onError(e);
                        }
                    }

                    @Override
                    public void onNext(final List<LiveCategory> list) {
                        LogUtils.d("Response:" + list);
                        ThreadPoolManager.getInstance().execute(new Runnable() {
                            @Override
                            public void run() {
                                getDaoSession().getLiveCategoryDao().insertOrReplaceInTx(list);
                            }
                        });
                        if (isViewAttached()){
                            getView().onGetLiveCategory(list);
                        }
                    }
                });
    }

}
