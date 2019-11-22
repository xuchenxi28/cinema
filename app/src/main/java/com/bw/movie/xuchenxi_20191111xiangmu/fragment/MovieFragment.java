package com.bw.movie.xuchenxi_20191111xiangmu.fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bawei.library.base.BaseFragment;
import com.bw.movie.xuchenxi_20191111xiangmu.R;
import com.bw.movie.xuchenxi_20191111xiangmu.adapter.AMyRecyAdapter;
import com.bw.movie.xuchenxi_20191111xiangmu.adapter.BMyRecyAdapter;
import com.bw.movie.xuchenxi_20191111xiangmu.adapter.CMyRecyAdapter;
import com.bw.movie.xuchenxi_20191111xiangmu.bean.CaeBean;
import com.bw.movie.xuchenxi_20191111xiangmu.bean.ComingsoonBean;
import com.bw.movie.xuchenxi_20191111xiangmu.bean.NowshowingBean;
import com.bw.movie.xuchenxi_20191111xiangmu.bean.PopularBean;
import com.bw.movie.xuchenxi_20191111xiangmu.contract.HomeContract;
import com.bw.movie.xuchenxi_20191111xiangmu.presenter.HomePresenter;
import com.bw.movie.xuchenxi_20191111xiangmu.view.XiangActivity;
import com.facebook.drawee.view.SimpleDraweeView;
import com.stx.xhb.androidx.XBanner;
import com.stx.xhb.androidx.entity.SimpleBannerInfo;
import com.xuezj.cardbanner.ImageData;
import com.xuezj.cardbanner.imageloader.CardImageLoader;

import org.greenrobot.eventbus.EventBus;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


public class MovieFragment extends BaseFragment<HomePresenter> implements HomeContract.iView {
    private static final String TAG = "MovieFragment";

    @BindView(R.id.more)
    TextView more;
    @BindView(R.id.rexyclerview1)
    RecyclerView rexyclerview1;
    @BindView(R.id.more2)
    TextView more2;
    @BindView(R.id.rexyclerview2)
    RecyclerView rexyclerview2;
    @BindView(R.id.more3)
    TextView more3;
    @BindView(R.id.rexyclerview3)
    RecyclerView rexyclerview3;
    @BindView(R.id.popular_img)
    SimpleDraweeView popularImg;
    @BindView(R.id.ban)
    XBanner ban;
    private LinearLayoutManager linearLayoutManager;
    private AMyRecyAdapter aMyRecyAdapter;
    private BMyRecyAdapter bMyRecyAdapter;
    private CMyRecyAdapter cMyRecyAdapter;

    @Override
    protected HomePresenter providePresenter() {
        return new HomePresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.fragment_movie;
    }

    @Override
    protected void initView() {
        mPresenter.getBannerPresenter();
        mPresenter.getNowshowPresenter("1", "5");
        mPresenter.getComingsonnPresenter("1", "5");
        mPresenter.getPopularPresenter("1", "5");
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onBannerSuccess(CaeBean caeBean) {
        Log.d(TAG, "onBannerSuccess: " + caeBean.getMessage());
        List<CaeBean.ResultBean> result = caeBean.getResult();

        ban.setBannerData(R.layout.image_fresco, new AbstractList<SimpleBannerInfo>() {
            @Override
            public SimpleBannerInfo get(int index) {
                return null;
            }

            @Override
            public int size() {
                return result.size();
            }
        });

        ban.loadImage(new XBanner.XBannerAdapter() {
            @Override
            public void loadBanner(XBanner banner, Object model, View view, int position) {
                SimpleDraweeView my_image_view = view.findViewById(R.id.my_image_view);
                Uri parse = Uri.parse(result.get(position).getImageUrl());
                my_image_view.setImageURI(parse);
            }
        });


    }

    @Override
    public void onBannerFailure(Throwable e) {

    }

    @Override
    public void onNowshowSuccess(NowshowingBean nowshowingBean) {
        Log.d(TAG, "onNowshowSuccess: " + nowshowingBean.getMessage());
        List<NowshowingBean.ResultBean> result = nowshowingBean.getResult();

        linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        rexyclerview1.setLayoutManager(linearLayoutManager);

        aMyRecyAdapter = new AMyRecyAdapter(getActivity(), result);
        rexyclerview1.setAdapter(aMyRecyAdapter);
        aMyRecyAdapter.onItemClickListener(new AMyRecyAdapter.onItemClickListener() {
            @Override
            public void onclick(int movieId) {
                Intent intent = new Intent(getActivity(), XiangActivity.class);
                intent.putExtra("movieId",movieId);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onNowshowFailure(Throwable e) {

    }

    @Override
    public void onComingsonnSuccess(ComingsoonBean comingsoonBean) {
        Log.d(TAG, "onComingsonnSuccess: " + comingsoonBean.getMessage());
        List<ComingsoonBean.ResultBean> result = comingsoonBean.getResult();

        linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rexyclerview2.setLayoutManager(linearLayoutManager);

        bMyRecyAdapter = new BMyRecyAdapter(getActivity(), result);
        rexyclerview2.setAdapter(bMyRecyAdapter);
        bMyRecyAdapter.onItemClickListener(new BMyRecyAdapter.onItemClickListener() {
            @Override
            public void onclick(int movieId) {
                Intent intent = new Intent(getActivity(), XiangActivity.class);
                intent.putExtra("movieId",movieId);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onComingsonnFailure(Throwable e) {

    }

    @Override
    public void onPopularSuccess(PopularBean popularBean) {
        Log.d(TAG, "onPopularSuccess: " + popularBean.getMessage());
        List<PopularBean.ResultBean> result = popularBean.getResult();
//        Glide.with(getActivity()).load(result.get(0).getHorizontalImage()).into(popularImg);
        Uri parse = Uri.parse(result.get(0).getImageUrl());
        popularImg.setImageURI(parse);


        linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        rexyclerview3.setLayoutManager(linearLayoutManager);

        cMyRecyAdapter = new CMyRecyAdapter(getActivity(), result);
        rexyclerview3.setAdapter(cMyRecyAdapter);
        cMyRecyAdapter.onItemClickListener(new CMyRecyAdapter.onItemClickListener() {
            @Override
            public void onclick(int movieId) {
                Intent intent = new Intent(getActivity(), XiangActivity.class);
                intent.putExtra("movieId",movieId);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onPopularFailure(Throwable e) {

    }
}
