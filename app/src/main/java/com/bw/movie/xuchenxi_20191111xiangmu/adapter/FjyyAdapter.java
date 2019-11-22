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
import com.bw.movie.xuchenxi_20191111xiangmu.bean.FjYyBean;
import com.facebook.drawee.view.SimpleDraweeView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

/**
 * <p>文件描述：<p>
 * <p>作者：徐晨曦<p>
 * <p>创建时间：2019/11/15<p>
 * <p>更改时间：2019/11/15<p>
 */
public class FjyyAdapter  extends XRecyclerView.Adapter<XRecyclerView.ViewHolder> {
    private Context context;
    List<FjYyBean.ResultBean> list;
    public FjyyAdapter(FragmentActivity activity, List<FjYyBean.ResultBean> result) {
        this.context = activity;
        this.list = result;
    }

    @NonNull
    @Override
    public XRecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.fuji_item, parent, false);
        return new MyHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull XRecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MyHolder){
            if (list!=null){
                ((MyHolder) holder).tjyy_name.setText(list.get(position).getName());
                ((MyHolder) holder).tjyy_price.setText(list.get(position).getAddress());
                ((MyHolder) holder).fjyy_mi.setText(list.get(position).getCommentTotal()+"km");
                Uri parse = Uri.parse(list.get(position).getLogo());
                ((MyHolder) holder).tjyy_image.setImageURI(parse);
            }
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public class MyHolder extends XRecyclerView.ViewHolder{
        private final TextView tjyy_price, tjyy_name,fjyy_mi;
        private final SimpleDraweeView tjyy_image;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            tjyy_price = itemView.findViewById(R.id.fjyy_price);
            tjyy_name = itemView.findViewById(R.id.fjyy_name);
            tjyy_image = itemView.findViewById(R.id.fjyy_image);
            fjyy_mi = itemView.findViewById(R.id.fjyy_mi);
        }
    }
}
