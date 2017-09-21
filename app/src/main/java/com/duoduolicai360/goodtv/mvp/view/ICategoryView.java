package com.duoduolicai360.goodtv.mvp.view;

import com.duoduolicai360.goodtv.bean.LiveCategory;
import com.duoduolicai360.goodtv.mvp.base.BaseView;

import java.util.List;

/**
 * Created by swg on 2017/9/19.
 */

public interface ICategoryView extends BaseView {

    void onGetLiveCategory(List<LiveCategory> list);

}
