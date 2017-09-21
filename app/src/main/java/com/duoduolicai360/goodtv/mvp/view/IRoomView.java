package com.duoduolicai360.goodtv.mvp.view;

import com.duoduolicai360.goodtv.bean.Room;
import com.duoduolicai360.goodtv.mvp.base.BaseView;

/**
 * Created by swg on 2017/9/19.
 */

public interface IRoomView extends BaseView {

    void enterRoom(Room room);
    void playUrl(String url);

}
