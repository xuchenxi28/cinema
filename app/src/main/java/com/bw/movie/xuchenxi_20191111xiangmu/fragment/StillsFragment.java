package com.bw.movie.xuchenxi_20191111xiangmu.fragment;

import android.content.Intent;
import android.util.Log;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.library.base.BaseFragment;
import com.bw.movie.xuchenxi_20191111xiangmu.R;
import com.bw.movie.xuchenxi_20191111xiangmu.adapter.StillsAdapter;
import com.bw.movie.xuchenxi_20191111xiangmu.bean.XiangBean;
import com.bw.movie.xuchenxi_20191111xiangmu.contract.XiangContract;
import com.bw.movie.xuchenxi_20191111xiangmu.presenter.XiangPresenter;

import java.util.List;

import butterknife.BindView;


public class StillsFragment extends BaseFragment<XiangPresenter> implements XiangContract.iView {
    private static final String TAG = "StillsFragment";
    @BindView(R.id.jz_recycler)
    RecyclerView jzRecycler;

    @Override
    protected XiangPresenter providePresenter() {
        return new XiangPresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.fragment_stills;
    }

    @Override
    protected void initView() {
        Intent intent = getActivity().getIntent();
        int movieId = intent.getIntExtra("movieId", 0);
        mPresenter.getXiangPresenter(movieId);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 3);
        gridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        jzRecycler.setLayoutManager(gridLayoutManager);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onXiangSuccess(XiangBean xiangBean) {
        Log.d(TAG, "onXiangSuccess: "+xiangBean.getMessage());
        List<String> posterList = xiangBean.getResult().getPosterList();
        StillsAdapter stillsAdapter = new StillsAdapter(getActivity(),posterList);
        jzRecycler.setAdapter(stillsAdapter);
    }

    @Override
    public void onXiangFailure(Throwable e) {

    }
}
