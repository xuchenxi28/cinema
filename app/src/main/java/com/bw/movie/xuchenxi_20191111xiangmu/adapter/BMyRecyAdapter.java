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

import com.bumptech.glide.Glide;
import com.bw.movie.xuchenxi_20191111xiangmu.R;
import com.bw.movie.xuchenxi_20191111xiangmu.bean.ComingsoonBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class BMyRecyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    FragmentActivity activity;
    List<ComingsoonBean.ResultBean> result;

    public BMyRecyAdapter(FragmentActivity activity, List<ComingsoonBean.ResultBean> result) {
        this.activity = activity;
        this.result = result;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(activity).inflate(R.layout.comingsoonitem, parent, false);
        return new myViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof BMyRecyAdapter.myViewHolder) {
            ((myViewHolder) holder).recy2_text1.setText(result.get(position).getName());
            ((myViewHolder) holder).recy2_text2.setText(result.get(position).getReleaseTime()+"");
            ((myViewHolder) holder).recy2_text3.setText(result.get(position).getWantSeeNum()+"");
            Uri parse = Uri.parse(result.get(position).getImageUrl());
            ((myViewHolder) holder).recy2_image.setImageURI(parse);
//            Glide.with(activity).load(result.get(position).getImageUrl()).into(((myViewHolder) holder).recy2_image);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int movieId = result.get(position).getMovieId();
                    onItemClickListener.onclick(movieId);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return result.size();
    }
    class myViewHolder extends RecyclerView.ViewHolder {
        private final TextView recy2_text1,recy2_text2,recy2_text3;
        private final SimpleDraweeView recy2_image;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            recy2_image = itemView.findViewById(R.id.recy2_image);
            recy2_text1 = itemView.findViewById(R.id.recy2_text1);
            recy2_text2 = itemView.findViewById(R.id.recy2_text2);
            recy2_text3 = itemView.findViewById(R.id.recy2_text3);
        }
    }
    private onItemClickListener onItemClickListener;

    public void onItemClickListener(onItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface onItemClickListener{
        void onclick(int movieId);
    }
}
