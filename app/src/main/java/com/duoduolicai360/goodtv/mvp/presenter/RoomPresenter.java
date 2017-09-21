package com.duoduolicai360.goodtv.mvp.presenter;

import com.duoduolicai360.goodtv.App;
import com.duoduolicai360.goodtv.bean.Room;
import com.duoduolicai360.goodtv.bean.RoomLine;
import com.duoduolicai360.goodtv.mvp.base.BasePresenter;
import com.duoduolicai360.goodtv.mvp.view.IRoomView;
import com.king.base.util.LogUtils;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by swg on 2017/9/19.
 */

public class RoomPresenter extends BasePresenter<IRoomView> {

    public RoomPresenter(App app) {
        super(app);
    }

    public void enterRoom(String uid){
        enterRoom(uid,false);
    }

    public void enterRoom(String uid,final boolean isShowing){
        if(isViewAttached())
            getView().showProgress();
        getAppComponent().getAPIService()
                .enterRoom(uid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Room>() {
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
                    public void onNext(Room room) {
                        LogUtils.d("Response:" + room);
                        if(isViewAttached())
                            getView().enterRoom(room);

                        if(room!= null){
                            String url =null;
//                            RoomLine roomLine = room.getRoom_lines().get(0);
                            RoomLine roomLine = room.getLive().getWs();

                            RoomLine.FlvBean flv = roomLine.getFlv();
                            LogUtils.d("flv:" + flv);
                            if(flv!=null){
                                url = flv.getValue(isShowing).getSrc();
                            }else{
                                url = roomLine.getHls().getValue(isShowing).getSrc();
                            }
                            if(isViewAttached())
                                getView().playUrl(url);
                        }

                    }
                });
    }

}
