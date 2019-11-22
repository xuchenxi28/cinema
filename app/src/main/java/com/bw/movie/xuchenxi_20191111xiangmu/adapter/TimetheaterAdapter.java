package com.bw.movie.xuchenxi_20191111xiangmu.adapter;

import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.library.app.App;
import com.bw.movie.xuchenxi_20191111xiangmu.R;
import com.bw.movie.xuchenxi_20191111xiangmu.bean.TimetheaterBean;
import com.bw.movie.xuchenxi_20191111xiangmu.view.ChooseatheaterActivity;
import com.bw.movie.xuchenxi_20191111xiangmu.view.SelectionActivity;
import com.facebook.drawee.view.SimpleDraweeView;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

/**
 * <p>文件描述：<p>
 * <p>作者：徐晨曦<p>
 * <p>创建时间：2019/11/21<p>
 * <p>更改时间：2019/11/21<p>
 */
public class TimetheaterAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    ChooseatheaterActivity activity;
    List<TimetheaterBean.ResultBean> time;

    public TimetheaterAdapter(ChooseatheaterActivity chooseatheaterActivity, List<TimetheaterBean.ResultBean> time) {
        this.activity=chooseatheaterActivity;
        this.time = time;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(App.getAppContext()).inflate(R.layout.tuijian_item, parent, false);
        return new myViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof TimetheaterAdapter.myViewHolder) {
            if (time != null) {
                ((myViewHolder) holder).tjyy_name.setText(time.get(position).getName());
                ((myViewHolder) holder).tjyy_price.setText(time.get(position).getAddress());
                Uri parse = Uri.parse(time.get(position).getLogo());
                ((myViewHolder) holder).tjyy_image.setImageURI(parse);
                int cinemaId = time.get(position).getCinemaId();
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        activity.startActivity(new Intent(activity, SelectionActivity.class));
                        EventBus.getDefault().postSticky(cinemaId);
                    }
                });
            }
        }
    }

    @Override
    public int getItemCount() {
        return time.size();
    }
    class myViewHolder extends RecyclerView.ViewHolder {
        private final TextView tjyy_price, tjyy_name;
        private final SimpleDraweeView tjyy_image;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            tjyy_price = itemView.findViewById(R.id.tjyy_price);
            tjyy_name = itemView.findViewById(R.id.tjyy_name);
            tjyy_image = itemView.findViewById(R.id.tjyy_image);
        }
    }

}
