package com.bw.movie.xuchenxi_20191111xiangmu.fragment;

import android.content.Intent;
import android.util.Log;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.library.base.BaseFragment;
import com.bw.movie.xuchenxi_20191111xiangmu.R;
import com.bw.movie.xuchenxi_20191111xiangmu.adapter.FilmReviewAdapter;
import com.bw.movie.xuchenxi_20191111xiangmu.bean.FilmReviewBean;
import com.bw.movie.xuchenxi_20191111xiangmu.contract.FilmReviewContract;
import com.bw.movie.xuchenxi_20191111xiangmu.presenter.FilmReviewPresenter;

import java.util.List;

import butterknife.BindView;


public class Film_reviewFragment extends BaseFragment<FilmReviewPresenter> implements FilmReviewContract.IView {
    private static final String TAG = "Film_reviewFragment";

    @BindView(R.id.FilmReview_recycler)
    RecyclerView FilmReviewRecycler;

    @Override
    protected FilmReviewPresenter providePresenter() {
        return new FilmReviewPresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.fragment_film_review;
    }

    @Override
    protected void initView() {
        Intent intent = getActivity().getIntent();
        int movieId = intent.getIntExtra("movieId", 0);
        mPresenter.getFilmReviewPresenter(movieId, "1", "10");

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        FilmReviewRecycler.setLayoutManager(linearLayoutManager);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onFilmReviewSuccess(FilmReviewBean data) {
        Log.d(TAG, "onFilmReviewSuccess: "+data.getMessage());
        List<FilmReviewBean.ResultBean> result = data.getResult();

        FilmReviewAdapter filmReviewAdapter = new FilmReviewAdapter(getActivity(),result);
        FilmReviewRecycler.setAdapter(filmReviewAdapter);

    }

    @Override
    public void onFilmReviewFailure(Throwable e) {

    }
}
