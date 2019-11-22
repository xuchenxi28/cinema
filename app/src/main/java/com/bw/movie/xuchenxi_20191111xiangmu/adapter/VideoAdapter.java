package com.bw.movie.xuchenxi_20191111xiangmu.adapter;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bw.movie.xuchenxi_20191111xiangmu.R;
import com.bw.movie.xuchenxi_20191111xiangmu.bean.XiangBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

/**
 * <p>文件描述：<p>
 * <p>作者：徐晨曦<p>
 * <p>创建时间：2019/11/19<p>
 * <p>更改时间：2019/11/19<p>
 */
public class VideoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    FragmentActivity activity;
    List<XiangBean.ResultBean.ShortFilmListBean> shortFilmList;

    public VideoAdapter(FragmentActivity activity, List<XiangBean.ResultBean.ShortFilmListBean> shortFilmList) {
        this.activity = activity;
        this.shortFilmList = shortFilmList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(activity).inflate(R.layout.video_item, parent, false);
        return new myViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof VideoAdapter.myViewHolder) {
            String videoUrl = shortFilmList.get(position).getVideoUrl();
            ((myViewHolder) holder).videoplayer.setUp(videoUrl,"");

            Glide.with(activity).load(shortFilmList.get(position).getImageUrl()).into(((myViewHolder) holder).videoplayer.ivThumb);
        }
    }

    @Override
    public int getItemCount() {
        return shortFilmList.size();
    }
    class myViewHolder extends RecyclerView.ViewHolder {

        private final JCVideoPlayer videoplayer;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            videoplayer = itemView.findViewById(R.id.videoplayer);
        }
    }
}
