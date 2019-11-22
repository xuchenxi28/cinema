package com.bw.movie.xuchenxi_20191111xiangmu.fragment;

import android.content.Intent;
import android.util.Log;

import androidx.recyclerview.widget.LinearLayoutManager;

import com.bawei.library.base.BaseFragment;
import com.bw.movie.xuchenxi_20191111xiangmu.R;
import com.bw.movie.xuchenxi_20191111xiangmu.adapter.FjyyAdapter;
import com.bw.movie.xuchenxi_20191111xiangmu.bean.FjYyBean;
import com.bw.movie.xuchenxi_20191111xiangmu.contract.YingContract;
import com.bw.movie.xuchenxi_20191111xiangmu.presenter.NearbyPresenter;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

import butterknife.BindView;


public class NearbyFragment extends BaseFragment<NearbyPresenter> implements YingContract.FjyyContreact.IView {
    int a=1;
    String b="10";
    private static final String TAG = "NearbyFragment";

    @BindView(R.id.fjyy_xrecy)
    XRecyclerView fjyyXrecy;
    private LinearLayoutManager linearLayoutManager;
    private FjyyAdapter fjyyAdapter;
    private String userId;
    private String sessionId;

    @Override
    protected NearbyPresenter providePresenter() {
        return new NearbyPresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.fragment_nearby;
    }

    @Override
    protected void initView() {
        mPresenter.getFjyyPresenter(userId,sessionId,"116.30551391385724","40.04571807462411",a,b);
    }

    @Override
    protected void initData() {
        Intent intent = getActivity().getIntent();
        userId = intent.getStringExtra("userId");
        sessionId = intent.getStringExtra("sessionId");
    }

    @Override
    public void onFjyySuccess(FjYyBean data) {
        Log.d(TAG, "onFjyySuccess: "+data.getMessage());
        List<FjYyBean.ResultBean> result = data.getResult();

        linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        fjyyXrecy.setLayoutManager(linearLayoutManager);

        fjyyAdapter = new FjyyAdapter(getActivity(),result);
        fjyyXrecy.setAdapter(fjyyAdapter);
    }

    @Override
    public void onFjyyFailure(Throwable e) {

    }
}
