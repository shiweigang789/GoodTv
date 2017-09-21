package com.duoduolicai360.goodtv.mvp.view;

import com.duoduolicai360.goodtv.bean.LiveInfo;
import com.duoduolicai360.goodtv.mvp.base.BaseView;

import java.util.List;

/**
 * Created by swg on 2017/9/19.
 */

public interface ILiveListView extends BaseView {

    void onGetLiveList(List<LiveInfo> list);
    void onGetMoreLiveList(List<LiveInfo> list);

}
