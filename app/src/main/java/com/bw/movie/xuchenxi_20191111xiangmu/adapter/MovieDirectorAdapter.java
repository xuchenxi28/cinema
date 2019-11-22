package com.bw.movie.xuchenxi_20191111xiangmu.adapter;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

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
public class MovieDirectorAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    FragmentActivity activity;
    List<XiangBean.ResultBean.MovieDirectorBean> movieDirector;

    public MovieDirectorAdapter(FragmentActivity activity, List<XiangBean.ResultBean.MovieDirectorBean> movieDirector) {
        this.activity = activity;
        this.movieDirector = movieDirector;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(activity).inflate(R.layout.moviedirector, parent, false);
        return new myViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MovieDirectorAdapter.myViewHolder) {
            ((myViewHolder) holder).introduce_name.setText(movieDirector.get(position).getName());
            Uri parse = Uri.parse(movieDirector.get(position).getPhoto());
            ((myViewHolder) holder).introduce_photo.setImageURI(parse);
        }
    }

    @Override
    public int getItemCount() {
        return movieDirector.size();
    }
    class myViewHolder extends RecyclerView.ViewHolder {
        private final SimpleDraweeView introduce_photo;
        private final TextView introduce_name;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            introduce_photo = itemView.findViewById(R.id.introduce_photo);
            introduce_name = itemView.findViewById(R.id.introduce_name);
        }
    }
}
