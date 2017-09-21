package com.duoduolicai360.goodtv.mvp.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.duoduolicai360.goodtv.R;
import com.duoduolicai360.goodtv.bean.LiveInfo;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import java.util.List;

/**
 * Created by swg on 2017/9/21.
 */

public class EasyLiveAdapter extends RecyclerArrayAdapter<LiveInfo> {

    private boolean isShowStatus;

    public EasyLiveAdapter(Context context, List<LiveInfo> objects, boolean isShowStatus) {
        super(context, objects);
        this.isShowStatus = isShowStatus;
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new LiveViewHolder(parent);
    }

    public class LiveViewHolder extends BaseViewHolder<LiveInfo>{

        ImageView iv;
        TextView tvTitle;
        TextView tvStatus;
        TextView tvName;
        TextView tvViewer;

        public LiveViewHolder(ViewGroup parent) {
            super(parent, R.layout.list_live_item);

            iv = $(R.id.iv);
            tvTitle = $(R.id.tvTitle);
            tvStatus = $(R.id.tvStatus);
            tvName = $(R.id.tvName);
            tvViewer = $(R.id.tvViewer);
        }

        @Override
        public void setData(LiveInfo data) {
            super.setData(data);

            Glide.with(getContext()).load(data.getThumb()).placeholder(R.mipmap.live_default).error(R.mipmap.live_default).crossFade().centerCrop().diskCacheStrategy(DiskCacheStrategy.SOURCE).into(iv);

            tvTitle.setText(data.getTitle());
            tvName.setText(data.getNick());
            tvViewer.setText(data.getViews());

            if(isShowStatus){
                if(data.getPlay_status()){
                    tvStatus.setVisibility(View.VISIBLE);
                }else{
                    tvStatus.setVisibility(View.GONE);
                }
            }

        }
    }

}
