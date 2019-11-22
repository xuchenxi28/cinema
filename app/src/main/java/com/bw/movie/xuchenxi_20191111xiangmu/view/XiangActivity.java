package com.bw.movie.xuchenxi_20191111xiangmu.view;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bawei.library.base.BaseActivity;
import com.bumptech.glide.Glide;
import com.bw.movie.xuchenxi_20191111xiangmu.MainActivity;
import com.bw.movie.xuchenxi_20191111xiangmu.R;
import com.bw.movie.xuchenxi_20191111xiangmu.bean.XiangBean;
import com.bw.movie.xuchenxi_20191111xiangmu.contract.XiangContract;
import com.bw.movie.xuchenxi_20191111xiangmu.fragment.Film_reviewFragment;
import com.bw.movie.xuchenxi_20191111xiangmu.fragment.IntroduceFragment;
import com.bw.movie.xuchenxi_20191111xiangmu.fragment.NoticeFragment;
import com.bw.movie.xuchenxi_20191111xiangmu.fragment.StillsFragment;
import com.bw.movie.xuchenxi_20191111xiangmu.presenter.XiangPresenter;
import com.google.android.material.tabs.TabLayout;

import org.greenrobot.eventbus.EventBus;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.annotations.NonNull;

public class XiangActivity extends BaseActivity<XiangPresenter> implements XiangContract.iView {
    private static final String TAG = "XiangActivity";

    @BindView(R.id.details_img)
    ImageView img;
    @BindView(R.id.details_score)
    TextView details_score;
    @BindView(R.id.details_tiao)
    ImageView details_tiao;
    @BindView(R.id.details_commentnum)
    TextView details_commentnum;
    @BindView(R.id.details_name)
    TextView details_name;
    @BindView(R.id.xin)
    ImageView xin;
    @BindView(R.id.details_movietype)
    TextView details_movietype;
    @BindView(R.id.details_duration)
    TextView details_duration;
    @BindView(R.id.guanzhu)
    TextView guanzhu;
    @BindView(R.id.details_releasetime)
    TextView details_releasetime;
    @BindView(R.id.details_placeOrigin)
    TextView details_placeOrigin;
    @BindView(R.id.details_tablayout)
    TabLayout details_tablayout;
    @BindView(R.id.details_vp)
    ViewPager details_vp;
    @BindView(R.id.film_review)
    Button film_review;
    @BindView(R.id.selection)
    Button selection;
    private int movieId;
    private ArrayList<Fragment> list;
    private String msg;

    @Override
    protected XiangPresenter providePresenter() {
        return new XiangPresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_xiang;
    }

    @Override
    protected void initView() {
        Intent intent = getIntent();
        movieId = intent.getIntExtra("movieId", 0);
        mpresenter.getXiangPresenter(movieId);
    }

    @Override
    protected void initData() {
        selection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(XiangActivity.this, ChooseatheaterActivity.class);
                intent.putExtra("movieId",movieId);
                startActivity(intent);
            }
        });


        details_tiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(XiangActivity.this, ZActivity.class));
            }
        });

        list = new ArrayList<>();
        list.add(new IntroduceFragment());
        list.add(new NoticeFragment());
        list.add(new StillsFragment());
        list.add(new Film_reviewFragment());
        details_vp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return list.get(position);
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });

        details_tablayout.setupWithViewPager(details_vp);
        details_tablayout.getTabAt(0).setText("介绍");
        details_tablayout.getTabAt(1).setText("预告");
        details_tablayout.getTabAt(2).setText("剧照");
        details_tablayout.getTabAt(3).setText("影评");
    }

    @Override
    public void onXiangSuccess(XiangBean xiangBean) {
        XiangBean.ResultBean result = xiangBean.getResult();
        String imageUrl = result.getImageUrl();
        Log.d(TAG, "onXiangSuccess: "+result.getImageUrl());
        int movieId = result.getMovieId();
        msg = String.valueOf(movieId);

        Glide.with(this).load(imageUrl).into(img);
        details_name.setText(result.getName());
        details_movietype.setText(result.getMovieType());
        details_duration.setText(result.getDuration());
        details_commentnum.setText("评论  "+ result.getCommentNum()+"万条");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        long releaseTime = result.getReleaseTime();
        String format = simpleDateFormat.format(releaseTime);
        details_releasetime.setText(format);
        details_placeOrigin.setText(result.getPlaceOrigin()+"上映");
        details_score.setText("评分"+ result.getScore()+"分");

        EventBus.getDefault().postSticky(result);
    }

    @Override
    public void onXiangFailure(Throwable e) {

    }

}
