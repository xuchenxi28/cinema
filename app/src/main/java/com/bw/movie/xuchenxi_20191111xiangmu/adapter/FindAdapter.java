package com.bw.movie.xuchenxi_20191111xiangmu.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bw.movie.xuchenxi_20191111xiangmu.R;
import com.bw.movie.xuchenxi_20191111xiangmu.bean.FindBean;

import java.util.List;

/**
 * <p>文件描述：<p>
 * <p>作者：徐晨曦<p>
 * <p>创建时间：2019/11/19<p>
 * <p>更改时间：2019/11/19<p>
 */
public class FindAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private setChangListenter setChangListenter;
    FragmentActivity activity;
    List<FindBean.ResultBean> result;

    public FindAdapter(FragmentActivity activity, List<FindBean.ResultBean> result) {
        this.activity = activity;
        this.result = result;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(activity).inflate(R.layout.haidian_item, parent, false);
        return new MyHoder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof FindAdapter.MyHoder){
            ((MyHoder) holder).find_name.setText(result.get(position).getRegionName());
            String regionId = result.get(position).getRegionId();
            holder.itemView.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                   setChangListenter.getChang(regionId);
               }
           });
        }
    }

    @Override
    public int getItemCount() {
        return result.size();
    }
    public class MyHoder extends RecyclerView.ViewHolder{

        private final TextView find_name;

        public MyHoder(@NonNull View itemView) {
            super(itemView);
            find_name = itemView.findViewById(R.id.find_name);
        }
    }
    public void setOnClickListenter(setChangListenter setChangListenter){
        this.setChangListenter = setChangListenter;
    }
    public interface setChangListenter{
        void getChang(String id);
    }
}
