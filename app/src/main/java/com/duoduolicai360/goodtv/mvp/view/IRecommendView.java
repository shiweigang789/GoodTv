package com.duoduolicai360.goodtv.mvp.view;

import com.duoduolicai360.goodtv.bean.Banner;
import com.duoduolicai360.goodtv.bean.Recommend;
import com.duoduolicai360.goodtv.mvp.base.BaseView;

import java.util.List;

/**
 * Created by swg on 2017/9/19.
 */

public interface IRecommendView extends BaseView {

    void onGetRecommend(Recommend recommend);
    void onGetRooms(List<Recommend.RoomBean> list);
    void onGetBanner(List<Banner> list);

}
