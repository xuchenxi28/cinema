package com.bw.movie.xuchenxi_20191111xiangmu.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;

import com.bw.movie.xuchenxi_20191111xiangmu.R;
import com.bw.movie.xuchenxi_20191111xiangmu.bean.TjyyBean;
import com.facebook.drawee.view.SimpleDraweeView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

public class TjyyAdapter extends XRecyclerView.Adapter<XRecyclerView.ViewHolder> {
    private Context context;
    private List<TjyyBean.ResultBean> list;

    public TjyyAdapter(FragmentActivity activity, List<TjyyBean.ResultBean> result) {
        this.context = activity;
        this.list = result;
    }

    @NonNull
    @Override
    public XRecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.tuijian_item, parent, false);
        return new MyHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull XRecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MyHolder) {
            ((MyHolder) holder).tjyy_name.setText(list.get(position).getName());
            ((MyHolder) holder).tjyy_price.setText(list.get(position).getAddress());
            //Glide.with(context).load(list.get(position).getLogo()).into(((MyHolder) holder).tjyy_image);
            Uri parse = Uri.parse(list.get(position).getLogo());
            ((MyHolder) holder).tjyy_image.setImageURI(parse);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyHolder extends XRecyclerView.ViewHolder {
        private final TextView tjyy_price, tjyy_name;
        private final SimpleDraweeView tjyy_image;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            tjyy_price = itemView.findViewById(R.id.tjyy_price);
            tjyy_name = itemView.findViewById(R.id.tjyy_name);
            tjyy_image = itemView.findViewById(R.id.tjyy_image);
        }
    }
}
