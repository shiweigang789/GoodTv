package com.duoduolicai360.goodtv.mvp.fragment;

import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.duoduolicai360.goodtv.R;
import com.duoduolicai360.goodtv.mvp.base.BaseFragment;
import com.duoduolicai360.goodtv.mvp.presenter.ChatPresenter;
import com.duoduolicai360.goodtv.mvp.view.IChatView;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by swg on 2017/9/22.
 */

public class ChatFragment extends BaseFragment<IChatView, ChatPresenter> {

    @BindView(R.id.tvTips)
    TextView tvTips;
    @BindView(R.id.ivEmoji)
    ImageView ivEmoji;
    @BindView(R.id.etChat)
    EditText etChat;
    @BindView(R.id.ivDanmu)
    ImageView ivDanmu;
    @BindView(R.id.ivGif)
    ImageView ivGif;

    public static ChatFragment newInstance() {

        Bundle args = new Bundle();
        ChatFragment fragment = new ChatFragment();
        fragment.setArguments(args);
        return fragment;

    }

    @Override
    public int getRootViewId() {
        return R.layout.fragment_chat;
    }

    @Override
    public void initUI() {
        SpannableStringBuilder ssb = new SpannableStringBuilder();
        //系统通知图片
        ImageSpan imageSpan = new ImageSpan(context,R.drawable.img_dm_xttz);
        SpannableString spannableString = new SpannableString("tips");
        spannableString.setSpan(imageSpan,0,spannableString.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        ssb.append(spannableString);
        //系统通知内容
        ssb.append(getText(R.string.tips_notice_desc));
        tvTips.setText(ssb);
    }

    @Override
    public void initData() {

    }

    @Override
    public ChatPresenter createPresenter() {
        return new ChatPresenter(getApp());
    }

    @OnClick({R.id.ivEmoji, R.id.ivDanmu, R.id.ivGif})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ivEmoji:
                break;
            case R.id.ivDanmu:
                startLogin();
                break;
            case R.id.ivGif:
                break;
        }
    }

}
