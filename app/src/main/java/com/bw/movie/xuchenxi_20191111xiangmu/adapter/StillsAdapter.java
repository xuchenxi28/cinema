package com.bw.movie.xuchenxi_20191111xiangmu.adapter;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.xuchenxi_20191111xiangmu.R;
import com.bw.movie.xuchenxi_20191111xiangmu.bean.XiangBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * <p>文件描述：<p>
 * <p>作者：徐晨曦<p>
 * <p>创建时间：2019/11/19<p>
 * <p>更改时间：2019/11/19<p>
 */
public class StillsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    FragmentActivity activity;
    List<String> posterList;

    public StillsAdapter(FragmentActivity activity, List<String> posterList) {
        this.activity = activity;
        this.posterList = posterList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(activity).inflate(R.layout.juzhao_item, parent, false);
        return new myViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof StillsAdapter.myViewHolder) {

            Uri parse = Uri.parse(posterList.get(position));
            ((myViewHolder) holder).juzhao_simple.setImageURI(parse);
        }
    }

    @Override
    public int getItemCount() {
        return posterList.size();
    }
    class myViewHolder extends RecyclerView.ViewHolder {

        private final SimpleDraweeView juzhao_simple;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            juzhao_simple = itemView.findViewById(R.id.juzhao_simple);
        }
    }
}
