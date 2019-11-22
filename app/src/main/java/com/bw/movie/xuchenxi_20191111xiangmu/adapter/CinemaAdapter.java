package com.bw.movie.xuchenxi_20191111xiangmu.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.xuchenxi_20191111xiangmu.R;
import com.bw.movie.xuchenxi_20191111xiangmu.bean.CinemaBean;

import java.util.List;

/**
 * <p>文件描述：<p>
 * <p>作者：徐晨曦<p>
 * <p>创建时间：2019/11/19<p>
 * <p>更改时间：2019/11/19<p>
 */
public class CinemaAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    FragmentActivity activity;
    List<CinemaBean.ResultBean> result;

    public CinemaAdapter(FragmentActivity activity, List<CinemaBean.ResultBean> result) {
        this.activity = activity;
        this.result = result;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(activity).inflate(R.layout.cinema_layout, parent, false);
        return new MyHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof  MyHolder){
            ((MyHolder) holder).cinema_name.setText(result.get(position).getName());
        }
    }

    @Override
    public int getItemCount() {
        return result.size();
    }
    public class MyHolder extends RecyclerView.ViewHolder {
        private final TextView cinema_name;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            cinema_name = itemView.findViewById(R.id.cinema_name);
        }
    }
}

