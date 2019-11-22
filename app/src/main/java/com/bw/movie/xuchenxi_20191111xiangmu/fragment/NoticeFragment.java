package com.bw.movie.xuchenxi_20191111xiangmu.fragment;

import android.content.Intent;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.library.base.BaseFragment;
import com.bw.movie.xuchenxi_20191111xiangmu.R;
import com.bw.movie.xuchenxi_20191111xiangmu.adapter.VideoAdapter;
import com.bw.movie.xuchenxi_20191111xiangmu.bean.XiangBean;
import com.bw.movie.xuchenxi_20191111xiangmu.contract.XiangContract;
import com.bw.movie.xuchenxi_20191111xiangmu.presenter.XiangPresenter;

import java.util.List;

import butterknife.BindView;


public class NoticeFragment extends BaseFragment<XiangPresenter> implements XiangContract.iView {


    @BindView(R.id.noice_recy)
    RecyclerView noiceRecy;
    private List<XiangBean.ResultBean.ShortFilmListBean> shortFilmList;

    @Override
    protected XiangPresenter providePresenter() {
        return new XiangPresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.fragment_notice;
    }

    @Override
    protected void initView() {
        Intent intent = getActivity().getIntent();
        int movieId = intent.getIntExtra("movieId", 0);
        mPresenter.getXiangPresenter(movieId);

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        noiceRecy.setLayoutManager(linearLayoutManager);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onXiangSuccess(XiangBean xiangBean) {
        shortFilmList = xiangBean.getResult().getShortFilmList();
        VideoAdapter videoAdapter = new VideoAdapter(getActivity(), shortFilmList);
        noiceRecy.setAdapter(videoAdapter);

    }

    @Override
    public void onXiangFailure(Throwable e) {

    }

}
