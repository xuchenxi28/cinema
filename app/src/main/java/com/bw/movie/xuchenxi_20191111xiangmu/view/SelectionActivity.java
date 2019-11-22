package com.bw.movie.xuchenxi_20191111xiangmu.view;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bawei.library.base.BaseActivity;
import com.bawei.library.base.BasePresenter;
import com.bumptech.glide.Glide;
import com.bw.movie.xuchenxi_20191111xiangmu.R;
import com.bw.movie.xuchenxi_20191111xiangmu.bean.XiangBean;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

public class SelectionActivity extends BaseActivity {


    @BindView(R.id.selection_fanhui)
    ImageView selectionFanhui;
    @BindView(R.id.selection_biaoti)
    TextView selectionBiaoti;
    @BindView(R.id.selection_jcvideoplayer)
    JCVideoPlayer selectionJcvideoplayer;
    @BindView(R.id.selection_recyclerxuanzuo)
    RecyclerView selectionRecyclerxuanzuo;
    @BindView(R.id.selection_recyclerxinxi)
    RecyclerView selectionRecyclerxinxi;
    @BindView(R.id.selection_zhifubtn)
    Button selectionZhifubtn;

    @Override
    protected BasePresenter providePresenter() {
        return null;
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_selection;
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    public void Selectionid(int cinemaId) {

    }
    @Subscribe(sticky = true,threadMode = ThreadMode.MAIN)
    public void Selectionjie(XiangBean.ResultBean result){
        selectionBiaoti.setText(result.getName());
        selectionJcvideoplayer.setUp(result.getShortFilmList().get(0).getVideoUrl(),null);
        Glide.with(this).load(result.getShortFilmList().get(0).getImageUrl()).into(selectionJcvideoplayer.ivThumb);

    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }


}
