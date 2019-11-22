package com.bw.movie.xuchenxi_20191111xiangmu.adapter;

import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.xuchenxi_20191111xiangmu.R;
import com.bw.movie.xuchenxi_20191111xiangmu.bean.InformationBean;
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
public class InformationAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    ChooseatheaterActivity activity;
    List<InformationBean.ResultBean> dyresult;

    public InformationAdapter(ChooseatheaterActivity chooseatheaterActivity, List<InformationBean.ResultBean> dyresult) {
        this.activity = chooseatheaterActivity;
        this.dyresult = dyresult;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View inflate = LayoutInflater.from(activity).inflate(R.layout.tuijian_item, parent, false);
            return new myViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof InformationAdapter.myViewHolder) {
            if (dyresult != null) {
                ((myViewHolder) holder).tjyy_name.setText(dyresult.get(position).getName());
                ((myViewHolder) holder).tjyy_price.setText(dyresult.get(position).getAddress());
                Uri parse = Uri.parse(dyresult.get(position).getLogo());
                ((myViewHolder) holder).tjyy_image.setImageURI(parse);
                int cinemaId = dyresult.get(position).getCinemaId();
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
           return dyresult.size();
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
