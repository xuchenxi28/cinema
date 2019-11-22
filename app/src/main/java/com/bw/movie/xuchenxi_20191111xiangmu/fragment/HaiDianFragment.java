package com.bw.movie.xuchenxi_20191111xiangmu.fragment;

import android.util.Log;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.library.base.BaseFragment;
import com.bw.movie.xuchenxi_20191111xiangmu.R;
import com.bw.movie.xuchenxi_20191111xiangmu.adapter.CinemaAdapter;
import com.bw.movie.xuchenxi_20191111xiangmu.adapter.FindAdapter;
import com.bw.movie.xuchenxi_20191111xiangmu.bean.CinemaBean;
import com.bw.movie.xuchenxi_20191111xiangmu.bean.FindBean;
import com.bw.movie.xuchenxi_20191111xiangmu.contract.YingContract;
import com.bw.movie.xuchenxi_20191111xiangmu.presenter.DqPresenter;

import java.util.List;

import butterknife.BindView;


public class HaiDianFragment extends BaseFragment<DqPresenter> implements YingContract.FindContreact.IView {
    private static final String TAG = "HaiDianFragment";
    @BindView(R.id.dp_dprecy)
    RecyclerView dpDprecy;
    @BindView(R.id.dp_yingyuan)
    RecyclerView dpYingyuan;

    @Override
    protected DqPresenter providePresenter() {
        return new DqPresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.fragment_hai_dian;
    }

    @Override
    protected void initView() {
        mPresenter.getFindPresenter();

    }

    @Override
    protected void initData() {

    }

    @Override
    public void onFindSuccess(FindBean data) {
        Log.d(TAG, "onFindSuccess: "+data.getMessage());
        List<FindBean.ResultBean> result = data.getResult();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        dpDprecy.setLayoutManager(linearLayoutManager);
        FindAdapter findAdapter = new FindAdapter(getActivity(),result);
        dpDprecy.setAdapter(findAdapter);
        findAdapter.setOnClickListenter(new FindAdapter.setChangListenter() {
            @Override
            public void getChang(String id) {
                mPresenter.getCinemaPresenter(id);
            }
        });
    }

    @Override
    public void onFindFailure(Throwable e) {

    }

    @Override
    public void onCinemaSuccess(CinemaBean data) {
        Log.d(TAG, "onCinemaSuccess: "+data.getMessage());
        List<CinemaBean.ResultBean> result = data.getResult();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        dpYingyuan.setLayoutManager(linearLayoutManager);
        CinemaAdapter cinemaAdapter = new CinemaAdapter(getActivity(), result);
        dpYingyuan.setAdapter(cinemaAdapter);
    }

    @Override
    public void onCinemaFailure(Throwable e) {

    }
}
