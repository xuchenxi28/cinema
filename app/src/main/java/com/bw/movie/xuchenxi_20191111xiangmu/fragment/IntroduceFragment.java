package com.bw.movie.xuchenxi_20191111xiangmu.fragment;

import android.content.Intent;
import android.widget.TextView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.library.base.BaseFragment;
import com.bawei.library.base.BasePresenter;
import com.bw.movie.xuchenxi_20191111xiangmu.R;
import com.bw.movie.xuchenxi_20191111xiangmu.adapter.MovieActorAdapter;
import com.bw.movie.xuchenxi_20191111xiangmu.adapter.MovieDirectorAdapter;
import com.bw.movie.xuchenxi_20191111xiangmu.bean.XiangBean;
import com.bw.movie.xuchenxi_20191111xiangmu.contract.XiangContract;
import com.bw.movie.xuchenxi_20191111xiangmu.presenter.XiangPresenter;

import java.util.List;

import butterknife.BindView;


public class IntroduceFragment extends BaseFragment<XiangPresenter> implements XiangContract.iView {
    private static final String TAG = "IntroduceFragment";
    @BindView(R.id.introduce_summary)
    TextView introduceSummary;
    @BindView(R.id.introduce_count)
    TextView introduceCount;
    @BindView(R.id.moviedirector_recy)
    RecyclerView moviedirectorRecy;
    @BindView(R.id.movieactor_performer)
    TextView movieactorPerformer;
    @BindView(R.id.movieactor_recy)
    RecyclerView movieactorRecy;
    private List<XiangBean.ResultBean.MovieDirectorBean> movieDirector;
    private List<XiangBean.ResultBean.MovieActorBean> movieActor;


    @Override
    protected XiangPresenter providePresenter() {
        return new XiangPresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.fragment_introduce;
    }

    @Override
    protected void initView() {
        Intent intent = getActivity().getIntent();
        int movieId = intent.getIntExtra("movieId", 0);
        mPresenter.getXiangPresenter(movieId);

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        moviedirectorRecy.setLayoutManager(linearLayoutManager);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 4);
        gridLayoutManager.setOrientation(GridLayoutManager.VERTICAL);
        movieactorRecy.setLayoutManager(gridLayoutManager);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onXiangSuccess(XiangBean xiangBean) {
        XiangBean.ResultBean result = xiangBean.getResult();
        movieDirector = result.getMovieDirector();
        movieActor = result.getMovieActor();
        introduceSummary.setText(result.getSummary());
        int size = result.getMovieDirector().size();
        introduceCount.setText("导演（"+size+"）");
        movieactorPerformer.setText("演员("+ movieActor.size()+")");

        MovieDirectorAdapter directorAdapter=new MovieDirectorAdapter(getActivity(),movieDirector);
        moviedirectorRecy.setAdapter(directorAdapter);

        MovieActorAdapter actorAdapter=new MovieActorAdapter(getActivity(),movieActor);
        movieactorRecy.setAdapter(actorAdapter);
    }

    @Override
    public void onXiangFailure(Throwable e) {

    }
}
