package com.duoduolicai360.goodtv.mvp.presenter;

import com.duoduolicai360.goodtv.App;
import com.duoduolicai360.goodtv.bean.AppStart;
import com.duoduolicai360.goodtv.bean.Recommend;
import com.duoduolicai360.goodtv.mvp.base.BasePresenter;
import com.duoduolicai360.goodtv.mvp.view.IRecommendView;
import com.king.base.util.LogUtils;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by swg on 2017/9/19.
 */

public class RecommendPresenter extends BasePresenter<IRecommendView> {

    public RecommendPresenter(App app) {
        super(app);
    }

    public void getRecommend(){
        if(isViewAttached()){
            getView().showProgress();
        }
        getAppComponent().getAPIService()
                .getRecommend()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Recommend>() {
                    @Override
                    public void onCompleted() {
                        if(isViewAttached())
                            getView().onCompleted();
                    }

                    @Override
                    public void onError(Throwable e) {
                        if(isViewAttached())
                            getView().onError(e);
                    }

                    @Override
                    public void onNext(Recommend recommend) {
                        LogUtils.d("Response:"+ recommend);
                        if(isViewAttached())
                            getView().onGetRecommend(recommend);

                        if(recommend!=null){
                            if(isViewAttached())
                                getView().onGetRooms(recommend.getRoom());
                        }
                    }
                });
    }

    public void getBanner(){
        getAppComponent().getAPIService()
                .getAppStartInfo()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<AppStart>() {
                    @Override
                    public void onCompleted() {
                        if(isViewAttached())
                            getView().onCompleted();
                    }

                    @Override
                    public void onError(Throwable e) {
                        if(isViewAttached())
                            getView().onError(e);
                    }

                    @Override
                    public void onNext(AppStart appStart) {
                        if(appStart!=null){
                            if(isViewAttached())
                                getView().onGetBanner(appStart.getBanners());
                        }
                    }

                });
    }

}
