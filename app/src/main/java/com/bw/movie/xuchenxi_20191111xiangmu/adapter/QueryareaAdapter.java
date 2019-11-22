package com.bw.movie.xuchenxi_20191111xiangmu.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.library.app.App;
import com.bw.movie.xuchenxi_20191111xiangmu.R;
import com.bw.movie.xuchenxi_20191111xiangmu.bean.FindBean;
import com.bw.movie.xuchenxi_20191111xiangmu.view.ChooseatheaterActivity;

import java.util.List;

/**
 * <p>文件描述：<p>
 * <p>作者：徐晨曦<p>
 * <p>创建时间：2019/11/20<p>
 * <p>更改时间：2019/11/20<p>
 */
public class QueryareaAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final String TAG = "QueryareaAdapter";
    private setChangListenter setChangListenter;
    int buy_area_pop;
    List<FindBean.ResultBean> result;

    public QueryareaAdapter(int buy_area_pop, List<FindBean.ResultBean> result) {
        this.buy_area_pop = buy_area_pop;
        this.result = result;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(App.getAppContext()).inflate(R.layout.buy_area_pop, parent, false);
        return new myViewholder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof QueryareaAdapter.myViewholder){
            ((myViewholder) holder).pop_name.setText(result.get(position).getRegionName());
            String regionId = result.get(position).getRegionId();
            String regionName = result.get(position).getRegionName();

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    setChangListenter.getChang(regionId,regionName);

                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return result.size();
    }
    class myViewholder extends RecyclerView.ViewHolder {

        private final TextView pop_name;

        public myViewholder(@NonNull View itemView) {
            super(itemView);
            pop_name = itemView.findViewById(R.id.pop_name);
        }
    }
    public void setOnClickListenter(setChangListenter setChangListenter){
        this.setChangListenter = setChangListenter;
    }
    public interface setChangListenter{
        void getChang(String regionId,String regionName);
    }
}
