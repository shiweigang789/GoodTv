package com.duoduolicai360.goodtv.mvp.fragment;

import android.os.Bundle;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.duoduolicai360.goodtv.R;
import com.duoduolicai360.goodtv.bean.Room;
import com.duoduolicai360.goodtv.utils.DecimalFormatUtil;

import butterknife.BindView;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by swg on 2017/9/22.
 */

public class AnchorInfoFragment extends SimpleFragment {

    @BindView(R.id.civAvatar)
    CircleImageView civAvatar;
    @BindView(R.id.tvAnchorName)
    TextView tvAnchorName;
    @BindView(R.id.tvAccount)
    TextView tvAccount;
    @BindView(R.id.tvFans)
    TextView tvFans;
    @BindView(R.id.tvWeight)
    TextView tvWeight;
    @BindView(R.id.tvStartLiveTime)
    TextView tvStartLiveTime;
    @BindView(R.id.tvAge)
    TextView tvAge;
    @BindView(R.id.tvEmotionalState)
    TextView tvEmotionalState;
    @BindView(R.id.tvLocation)
    TextView tvLocation;
    @BindView(R.id.tvOccupation)
    TextView tvOccupation;

    private Room room;

    public static AnchorInfoFragment newInstance(Room room) {
        Bundle args = new Bundle();

        AnchorInfoFragment fragment = new AnchorInfoFragment();
        fragment.room = room;
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getRootViewId() {
        return R.layout.fragment_anchor;
    }

    @Override
    public void initUI() {

    }

    public void onUpdateAnchor(Room room){
        this.room = room;
        initData();
    }

    @Override
    public void initData() {
        if (room != null && getRootView()!=null) {
            Glide.with(this).load(room.getAvatar()).error(R.drawable.mine_default_avatar).placeholder(R.drawable.mine_default_avatar).diskCacheStrategy(DiskCacheStrategy.SOURCE).into(civAvatar);
            tvAnchorName.setText(room.getNick());
            tvAccount.setText(String.valueOf(room.getNo()));
            tvFans.setText(String.valueOf(room.getFollow()));
            tvWeight.setText(DecimalFormatUtil.formatW(room.getWeight()/100));
            tvStartLiveTime.setText(room.getAnnouncement());

        }
    }

}
