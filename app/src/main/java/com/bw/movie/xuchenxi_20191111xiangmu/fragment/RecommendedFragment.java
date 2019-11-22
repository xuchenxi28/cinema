package com.bw.movie.xuchenxi_20191111xiangmu.fragment;

import android.content.Intent;
import android.util.Log;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.bawei.library.base.BaseFragment;
import com.bw.movie.xuchenxi_20191111xiangmu.R;
import com.bw.movie.xuchenxi_20191111xiangmu.adapter.TjyyAdapter;
import com.bw.movie.xuchenxi_20191111xiangmu.bean.TjyyBean;
import com.bw.movie.xuchenxi_20191111xiangmu.contract.YingContract;
import com.bw.movie.xuchenxi_20191111xiangmu.presenter.YinPresenter;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

import butterknife.BindView;


public class RecommendedFragment extends BaseFragment<YinPresenter> implements YingContract.TjyyContreact.IView {
    int a=1;
    String b="10";
    private static final String TAG = "RecommendedFragment";
    @BindView(R.id.tjyy_xrecy)
    XRecyclerView tjyyXrecy;
    private LinearLayoutManager linearLayoutManager;
    private TjyyAdapter tjyyAdapter;
    private String userId;
    private String sessionId;

    @Override
    protected YinPresenter providePresenter() {
        return new YinPresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.fragment_recommended;
    }

    @Override
    protected void initView() {
        mPresenter.getTjyyPresenter(userId,sessionId,a,b);
    }

    @Override
    protected void initData() {
        Intent intent = getActivity().getIntent();
        userId = intent.getStringExtra("userId");
        sessionId = intent.getStringExtra("sessionId");
    }

    @Override
    public void onTjyySuccess(TjyyBean data) {
        Log.d(TAG, "onTjyySuccess: "+data.getMessage());
        List<TjyyBean.ResultBean> result = data.getResult();

        linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        tjyyXrecy.setLayoutManager(linearLayoutManager);

        tjyyAdapter = new TjyyAdapter(getActivity(), result);
        tjyyXrecy.setAdapter(tjyyAdapter);
    }

    @Override
    public void onTjyyFailure(Throwable e) {

    }
}
