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
import com.bw.movie.xuchenxi_20191111xiangmu.bean.PopularBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class CMyRecyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    FragmentActivity activity;
    List<PopularBean.ResultBean> result;

    public CMyRecyAdapter(FragmentActivity activity, List<PopularBean.ResultBean> result) {
        this.activity = activity;
        this.result = result;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(activity).inflate(R.layout.popularitem, parent, false);
        return new myViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof CMyRecyAdapter.myViewHolder) {
            ((myViewHolder) holder).recy3_text1.setText(result.get(position).getScore()+"");
            ((myViewHolder) holder).recy3_text2.setText(result.get(position).getName());
            Uri parse = Uri.parse(result.get(position).getImageUrl());
            ((myViewHolder) holder).recy3_image2.setImageURI(parse);
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

        private final TextView recy3_text1,recy3_text2;
        private final SimpleDraweeView recy3_image2;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            recy3_image2 = itemView.findViewById(R.id.recy3_image2);
            recy3_text1 = itemView.findViewById(R.id.recy3_text1);
            recy3_text2 = itemView.findViewById(R.id.recy3_text2);
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
