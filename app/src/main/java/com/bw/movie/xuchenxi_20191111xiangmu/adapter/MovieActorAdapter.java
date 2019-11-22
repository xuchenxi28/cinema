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
public class MovieActorAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    FragmentActivity activity;
    List<XiangBean.ResultBean.MovieActorBean> movieActor;

    public MovieActorAdapter(FragmentActivity activity, List<XiangBean.ResultBean.MovieActorBean> movieActor) {
        this.activity = activity;
        this.movieActor = movieActor;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(activity).inflate(R.layout.movieactor, parent, false);
        return new myViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MovieActorAdapter.myViewHolder) {
            ((myViewHolder) holder).movieactor_name.setText(movieActor.get(position).getName());
            Uri parse = Uri.parse(movieActor.get(position).getPhoto());
            ((myViewHolder) holder).movieactor_photo.setImageURI(parse);
        }
    }

    @Override
    public int getItemCount() {
        return movieActor.size();
    }
    class myViewHolder extends RecyclerView.ViewHolder {
        private final SimpleDraweeView movieactor_photo;
        private final TextView movieactor_name;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            movieactor_photo = itemView.findViewById(R.id.movieactor_photo);
            movieactor_name = itemView.findViewById(R.id.movieactor_name);
        }
    }
}
