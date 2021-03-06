package com.duoduolicai360.goodtv.mvp.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.duoduolicai360.goodtv.R;
import com.duoduolicai360.goodtv.bean.Room;
import com.duoduolicai360.goodtv.mvp.base.BaseFragment;
import com.duoduolicai360.goodtv.mvp.presenter.RoomPresenter;
import com.duoduolicai360.goodtv.mvp.view.IRoomView;
import com.king.base.util.LogUtils;
import com.king.view.flutteringlayout.FlutteringLayout;

import butterknife.BindView;
import butterknife.OnClick;
import jp.wasabeef.glide.transformations.BlurTransformation;

/**
 * Created by swg on 2017/9/22.
 */

public class FullRoomFragment extends BaseFragment<IRoomView, RoomPresenter> implements IRoomView {

    @BindView(R.id.rlAnchorInfo)
    View rlAnchorInfo;
    @BindView(R.id.civAvatar)
    ImageView civAvatar;
    @BindView(R.id.tvName)
    TextView tvName;
    @BindView(R.id.tvFans)
    TextView tvFans;

    @BindView(R.id.ivCover)
    ImageView ivCover;
    @BindView(R.id.frameVideo)
    FrameLayout frameVideo;
    @BindView(R.id.ivBack)
    ImageView ivBack;
    @BindView(R.id.tvAccount)
    TextView tvAccount;
    @BindView(R.id.ivInput)
    ImageView ivInput;
    @BindView(R.id.ivFollow)
    ImageView ivFollow;
    @BindView(R.id.ivGift)
    ImageView ivGift;
    @BindView(R.id.ivShare)
    ImageView ivShare;
    @BindView(R.id.ivMessage)
    ImageView ivMessage;
    @BindView(R.id.rlRoomInfo)
    LinearLayout rlRoomInfo;
    @BindView(R.id.videoContent)
    RelativeLayout videoContent;

    @BindView(R.id.flutteringLayout)
    FlutteringLayout flutteringLayout;
    @BindView(R.id.btnHeart)
    Button btnHeart;

    private String uid;

    private String coverUrl;

    private VideoFragment videoFragment;

    public static FullRoomFragment newInstance(String uid,String coverUrl) {

        Bundle args = new Bundle();

        FullRoomFragment fragment = new FullRoomFragment();
        fragment.uid = uid;
        fragment.coverUrl = coverUrl;
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getActivity().getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public int getRootViewId() {
        return R.layout.fragment_full_room;
    }

    @Override
    public void initUI() {
        tvAccount.setText(String.format(getString(R.string.qm_account),uid));

        Glide.with(this).load(coverUrl).centerCrop().bitmapTransform(new BlurTransformation(context,18,3)).diskCacheStrategy(DiskCacheStrategy.SOURCE).into(ivCover);
    }

    @Override
    public void initData() {
        getPresenter().enterRoom(uid,true);
    }

    @Override
    public RoomPresenter createPresenter() {
        return new RoomPresenter(getApp());
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void onCompleted() {

    }


    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void enterRoom(Room room) {
        LogUtils.d("enterRoom:" + room.getUid());
        updateAnchorInfo(room);
    }

    @Override
    public void playUrl(String url) {
        LogUtils.d("playUrl:" + url);
        if (videoFragment == null) {
            videoFragment = VideoFragment.newInstance(url,true);
        }
        replaceChildFragment(R.id.frameVideo, videoFragment);
        clickHeart();
    }

    private void updateAnchorInfo(Room room){
        if(room!=null){
            rlAnchorInfo.setVisibility(View.VISIBLE);
            Glide.with(this).load(room.getAvatar()).placeholder(R.drawable.mine_default_avatar).error(R.drawable.mine_default_avatar).centerCrop().crossFade().diskCacheStrategy(DiskCacheStrategy.SOURCE).into(civAvatar);
            tvName.setText(room.getNick());
            tvFans.setText(String.format(getString(R.string.fans_num),room.getFollow()));

        }
    }

    private void clickInput(){

    }

    private void clickFollow(){
        startLogin();
    }

    private void clickGift(){

    }

    private void clickShare(){

    }

    private void clickMessage(){
        startLogin();
    }

    private void clickHeart(){
        flutteringLayout.addHeart();
    }

    @OnClick({R.id.ivBack, R.id.ivInput, R.id.ivFollow, R.id.ivGift, R.id.ivShare, R.id.ivMessage,R.id.btnHeart})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ivBack:
                finish();
                break;
            case R.id.ivInput:
                clickInput();
                break;
            case R.id.ivFollow:
                clickFollow();
                break;
            case R.id.ivGift:
                clickGift();
                break;
            case R.id.ivShare:
                clickShare();
                break;
            case R.id.ivMessage:
                clickMessage();
                break;
            case R.id.btnHeart:
                clickHeart();
                break;
        }
    }

}
