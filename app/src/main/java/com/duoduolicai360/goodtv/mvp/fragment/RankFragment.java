package com.duoduolicai360.goodtv.mvp.fragment;

import android.os.Bundle;

import com.duoduolicai360.goodtv.R;

/**
 * Created by swg on 2017/9/22.
 */

public class RankFragment extends SimpleFragment {

    public static RankFragment newInstance() {

        Bundle args = new Bundle();
        RankFragment fragment = new RankFragment();
        fragment.setArguments(args);
        return fragment;

    }

    @Override
    public int getRootViewId() {
        return R.layout.fragment_rank;
    }

    @Override
    public void initUI() {

    }

    @Override
    public void initData() {

    }
}
