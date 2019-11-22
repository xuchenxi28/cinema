package com.bw.movie.xuchenxi_20191111xiangmu.view;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.library.base.BaseActivity;
import com.bumptech.glide.Glide;
import com.bw.movie.xuchenxi_20191111xiangmu.R;
import com.bw.movie.xuchenxi_20191111xiangmu.adapter.InformationAdapter;
import com.bw.movie.xuchenxi_20191111xiangmu.adapter.QueryareaAdapter;
import com.bw.movie.xuchenxi_20191111xiangmu.adapter.TimetheaterAdapter;
import com.bw.movie.xuchenxi_20191111xiangmu.bean.FindBean;
import com.bw.movie.xuchenxi_20191111xiangmu.bean.InformationBean;
import com.bw.movie.xuchenxi_20191111xiangmu.bean.SchduBean;
import com.bw.movie.xuchenxi_20191111xiangmu.bean.TimetheaterBean;
import com.bw.movie.xuchenxi_20191111xiangmu.bean.XiangBean;
import com.bw.movie.xuchenxi_20191111xiangmu.contract.InformationContract;
import com.bw.movie.xuchenxi_20191111xiangmu.presenter.InformationPresenter;
import com.stx.xhb.androidx.OnDoubleClickListener;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

public class ChooseatheaterActivity extends BaseActivity<InformationPresenter> implements InformationContract.IView {
    private static final String TAG = "ChooseatheaterActivity";
    @BindView(R.id.jcvideoplayer_Chooseatheater)
    JCVideoPlayer jcvideoplayerChooseatheater;
    @BindView(R.id.Chooseatheater_name)
    TextView ChooseatheaterName;
    @BindView(R.id.Chooseatheater_shichang)
    TextView ChooseatheaterShichang;
    @BindView(R.id.Chooseatheater_pingfen)
    TextView ChooseatheaterPingfen;
    @BindView(R.id.Chooseatheater_daoyan)
    TextView ChooseatheaterDaoyan;
    @BindView(R.id.Chooseatheater_diqu)
    TextView ChooseatheaterDiqu;
    @BindView(R.id.Chooseatheater_paiqi)
    TextView ChooseatheaterPaiqi;
    @BindView(R.id.Chooseatheater_jiage)
    TextView ChooseatheaterJiage;
    @BindView(R.id.chooseatheater_sousuo)
    ImageView chooseatheaterSousuo;
    @BindView(R.id.chooseatheater_recycler)
    RecyclerView chooseatheaterRecycler;
    private RecyclerView rv_buy_movie_region;
    private int movieId;
    private List<TimetheaterBean.ResultBean> time;
    private List<InformationBean.ResultBean> dyresult;

    @Override
    protected InformationPresenter providePresenter() {
        return new InformationPresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_chooseatheater;
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    public void aa(XiangBean.ResultBean result) {
        String videoUrl = result.getShortFilmList().get(0).getVideoUrl();
        jcvideoplayerChooseatheater.setUp(videoUrl,null);
        Glide.with(this).load(result.getShortFilmList().get(0).getImageUrl()).into(jcvideoplayerChooseatheater.ivThumb);

        List<XiangBean.ResultBean.MovieDirectorBean> movieDirector = result.getMovieDirector();
        for (int i = 0; i < movieDirector.size(); i++) {
            ChooseatheaterDaoyan.setText(movieDirector.get(i).getName());
        }
        ChooseatheaterName.setText(result.getName());
        ChooseatheaterShichang.setText(result.getDuration());
        ChooseatheaterPingfen.setText(result.getScore()+"");


    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        ChooseatheaterDiqu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mpresenter.getQueryareaPresenter();
            }
        });
        ChooseatheaterPaiqi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mpresenter.getSchduPresenter();
            }
        });
    }
    //查找地区
    @Override
    public void onQueryareaSuccess(FindBean data) {
        Log.d(TAG, "onQueryareaSuccess: " + data.getMessage());
        List<FindBean.ResultBean> result = data.getResult();

        View regionView = LayoutInflater.from(ChooseatheaterActivity.this).inflate(R.layout.buy_movie_region_item_layout, null);
        final PopupWindow mPopupWindow = new PopupWindow(regionView,
                RecyclerView.LayoutParams.MATCH_PARENT,
                RecyclerView.LayoutParams.WRAP_CONTENT, true);
        mPopupWindow.setOutsideTouchable(true);
        mPopupWindow.setTouchable(true);
        mPopupWindow.setContentView(regionView);
        mPopupWindow.showAsDropDown(ChooseatheaterDiqu, -20, 0);

        rv_buy_movie_region = regionView.findViewById(R.id.rv_buy_movie_region);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rv_buy_movie_region.setLayoutManager(linearLayoutManager);

        QueryareaAdapter queryareaAdapter = new QueryareaAdapter(R.layout.buy_area_pop,result);
        rv_buy_movie_region.setAdapter(queryareaAdapter);

        queryareaAdapter.setOnClickListenter(new QueryareaAdapter.setChangListenter() {
            @Override
            public void getChang(String regionId,String regionName) {
                ChooseatheaterDiqu.setText(regionName);
                Intent intent = getIntent();
                movieId = intent.getIntExtra("movieId", 0);
                mpresenter.getgetInformation(movieId, regionId, "1", "10");
                mPopupWindow.dismiss();
            }
        });
    }

    @Override
    public void onQueryareaFailure(Throwable e) {

    }
    //排期
    @Override
    public void onSchduSuccess(SchduBean data) {
        Log.d(TAG, "onSchduSuccess: " + data.getMessage());
        List<String> result = data.getResult();

        View regionView = LayoutInflater.from(ChooseatheaterActivity.this).inflate(R.layout.buy_schdu, null);
        final PopupWindow mPopupWindow = new PopupWindow(regionView, RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT, true);
        mPopupWindow.setOutsideTouchable(true);
        mPopupWindow.setTouchable(true);
        mPopupWindow.setContentView(regionView);
        mPopupWindow.showAsDropDown(ChooseatheaterPaiqi, -20, 0);

        //周一
        final TextView schdu_Mond = regionView.findViewById(R.id.schdu_Mond);
        schdu_Mond.setText(result.get(0));
        schdu_Mond.setOnClickListener(new OnDoubleClickListener() {
            @Override
            public void onNoDoubleClick(View v) {
                ChooseatheaterPaiqi.setText("今天" + result.get(0));
                mPopupWindow.dismiss();
                Intent intent = getIntent();
                movieId = intent.getIntExtra("movieId", 0);
                mpresenter.getTimetheater(movieId,schdu_Mond.getText().toString(),"1","10");
            }
        });
        //周二
        final TextView schdu_Tues = regionView.findViewById(R.id.schdu_Tues);
        schdu_Tues.setText(result.get(1));
        schdu_Tues.setOnClickListener(new OnDoubleClickListener() {
            @Override
            public void onNoDoubleClick(View v) {
                ChooseatheaterPaiqi.setText("明天" + result.get(1));
                mPopupWindow.dismiss();
                Intent intent = getIntent();
                movieId = intent.getIntExtra("movieId", 0);
                mpresenter.getTimetheater(movieId,schdu_Tues.getText().toString(),"1","10");

            }
        });
        //周三
        final TextView schdu_Wednes = regionView.findViewById(R.id.schdu_Wednes);
        schdu_Wednes.setText(result.get(2));
        schdu_Wednes.setOnClickListener(new OnDoubleClickListener() {
            @Override
            public void onNoDoubleClick(View v) {
                ChooseatheaterPaiqi.setText("后天" + result.get(2));
                mPopupWindow.dismiss();
                Intent intent = getIntent();
                movieId = intent.getIntExtra("movieId", 0);
                mpresenter.getTimetheater(movieId,schdu_Wednes.getText().toString(),"1","10");
            }
        });
        //周四
        final TextView schdu_Thurs = regionView.findViewById(R.id.schdu_Thurs);
        schdu_Thurs.setText(result.get(3));
        schdu_Thurs.setOnClickListener(new OnDoubleClickListener() {
            @Override
            public void onNoDoubleClick(View v) {
                ChooseatheaterPaiqi.setText(result.get(3));
                mPopupWindow.dismiss();
                Intent intent = getIntent();
                movieId = intent.getIntExtra("movieId", 0);
                mpresenter.getTimetheater(movieId,schdu_Thurs.getText().toString(),"1","10");
            }
        });
        //周五
        final TextView schdu_Fri = regionView.findViewById(R.id.schdu_Fri);
        schdu_Fri.setText(result.get(4));
        schdu_Fri.setOnClickListener(new OnDoubleClickListener() {
            @Override
            public void onNoDoubleClick(View v) {
                ChooseatheaterPaiqi.setText(result.get(4));
                mPopupWindow.dismiss();
                Intent intent = getIntent();
                movieId = intent.getIntExtra("movieId", 0);
                mpresenter.getTimetheater(movieId,schdu_Fri.getText().toString(),"1","10");
            }
        });
        //周六
        final TextView schdu_Sat = regionView.findViewById(R.id.schdu_Sat);
        schdu_Sat.setText(result.get(5));
        schdu_Sat.setOnClickListener(new OnDoubleClickListener() {
            @Override
            public void onNoDoubleClick(View v) {
                ChooseatheaterPaiqi.setText(result.get(5));
                mPopupWindow.dismiss();
                Intent intent = getIntent();
                movieId = intent.getIntExtra("movieId", 0);
                mpresenter.getTimetheater(movieId,schdu_Sat.getText().toString(),"1","10");

            }
        });
        //周日
        final TextView schdu_Week = regionView.findViewById(R.id.schdu_Week);
        schdu_Week.setText(result.get(6));
        schdu_Week.setOnClickListener(new OnDoubleClickListener() {
            @Override
            public void onNoDoubleClick(View v) {
                ChooseatheaterPaiqi.setText(result.get(6));
                mPopupWindow.dismiss();
                Intent intent = getIntent();
                movieId = intent.getIntExtra("movieId", 0);
                mpresenter.getTimetheater(movieId,schdu_Week.getText().toString(),"1","10");

            }
        });
    }

    @Override
    public void onSchduFailure(Throwable e) {

    }
    //根据电影id查找影院
    @Override
    public void onInformationSuccess(InformationBean data) {
        Log.d(TAG, "onInformationSuccess: " + data.getMessage());
        dyresult = data.getResult();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        chooseatheaterRecycler.setLayoutManager(linearLayoutManager);
        InformationAdapter informationAdapter = new InformationAdapter(this, dyresult);
        chooseatheaterRecycler.setAdapter(informationAdapter);
    }

    @Override
    public void onInformationFailure(Throwable e) {

    }
    //根据时间id查找影院
    @Override
    public void onTimetheaterSuccess(TimetheaterBean data) {
        Log.d(TAG, "onTimetheaterSuccess: "+data.getMessage());
        time = data.getResult();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        chooseatheaterRecycler.setLayoutManager(linearLayoutManager);
        TimetheaterAdapter timetheaterAdapter = new TimetheaterAdapter(ChooseatheaterActivity.this,time);
        chooseatheaterRecycler.setAdapter(timetheaterAdapter);

    }

    @Override
    public void onTimetheaterFailure(Throwable e) {

    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

}
