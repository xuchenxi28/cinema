package com.bw.movie.xuchenxi_20191111xiangmu.presenter;

import com.bawei.library.app.Constant;
import com.bawei.library.base.BasePresenter;
import com.bw.movie.xuchenxi_20191111xiangmu.bean.CaeBean;
import com.bw.movie.xuchenxi_20191111xiangmu.bean.ComingsoonBean;
import com.bw.movie.xuchenxi_20191111xiangmu.bean.NowshowingBean;
import com.bw.movie.xuchenxi_20191111xiangmu.bean.PopularBean;
import com.bw.movie.xuchenxi_20191111xiangmu.contract.HomeContract;
import com.bw.movie.xuchenxi_20191111xiangmu.model.HomeModel;

public class HomePresenter extends BasePresenter<HomeContract.iView> implements HomeContract.iPresenter {

    private HomeModel homeModel;

    @Override
    protected void initModel() {
        homeModel = new HomeModel();
    }

    @Override
    public void getBannerPresenter() {
        homeModel.getBannerData(new HomeContract.iModel.iHomeCallBack() {
            @Override
            public void onBannerSuccess(CaeBean caeBean) {
                if (isViewAttached()) {
                    if (caeBean != null && Constant.SUCCESS_CODE.equals(caeBean.getStatus())) {
                        getView().onBannerSuccess(caeBean);
                    }else {
                        getView().onBannerFailure(new Exception("服务器异常"));
                    }
                }
            }

            @Override
            public void onBannerFailure(Throwable failure) {
                if (isViewAttached()) {
                    getView().onBannerFailure(failure);
                }
            }

            @Override
            public void onNowshowSuccess(NowshowingBean nowshowingBean) {

            }

            @Override
            public void onNowshowFailure(Throwable e) {

            }

            @Override
            public void onComingsonnSuccess(ComingsoonBean comingsoonBean) {

            }

            @Override
            public void onComingsonnFailure(Throwable e) {

            }

            @Override
            public void onPopularSuccess(PopularBean popularBean) {

            }

            @Override
            public void onPopularFailure(Throwable e) {

            }
        });
    }

    @Override
    public void getNowshowPresenter(String page, String count) {
        homeModel.getNowshowData(page, count, new HomeContract.iModel.iHomeCallBack() {
            @Override
            public void onBannerSuccess(CaeBean caeBean) {

            }

            @Override
            public void onBannerFailure(Throwable failure) {

            }

            @Override
            public void onNowshowSuccess(NowshowingBean nowshowingBean) {
                if (isViewAttached()) {
                    if (nowshowingBean != null && Constant.SUCCESS_CODE.equals(nowshowingBean.getStatus())) {
                        getView().onNowshowSuccess(nowshowingBean);
                    }else {
                        getView().onNowshowFailure(new Exception("服务器异常"));
                    }
                }
            }

            @Override
            public void onNowshowFailure(Throwable e) {
                if (isViewAttached()) {
                    getView().onNowshowFailure(e);
                }
            }

            @Override
            public void onComingsonnSuccess(ComingsoonBean comingsoonBean) {

            }

            @Override
            public void onComingsonnFailure(Throwable e) {

            }

            @Override
            public void onPopularSuccess(PopularBean popularBean) {

            }

            @Override
            public void onPopularFailure(Throwable e) {

            }
        });
    }

    @Override
    public void getComingsonnPresenter(String page, String count) {
        homeModel.getComingsonnData(page, count, new HomeContract.iModel.iHomeCallBack() {
            @Override
            public void onBannerSuccess(CaeBean caeBean) {

            }

            @Override
            public void onBannerFailure(Throwable failure) {

            }

            @Override
            public void onNowshowSuccess(NowshowingBean nowshowingBean) {

            }

            @Override
            public void onNowshowFailure(Throwable e) {

            }

            @Override
            public void onComingsonnSuccess(ComingsoonBean comingsoonBean) {
                if (isViewAttached()) {
                    if (comingsoonBean != null && Constant.SUCCESS_CODE.equals(comingsoonBean.getStatus())) {
                        getView().onComingsonnSuccess(comingsoonBean);
                    }else {
                        getView().onComingsonnFailure(new Exception("服务器异常"));
                    }
                }
            }

            @Override
            public void onComingsonnFailure(Throwable e) {
                if (isViewAttached()) {
                    getView().onComingsonnFailure(e);
                }
            }

            @Override
            public void onPopularSuccess(PopularBean popularBean) {

            }

            @Override
            public void onPopularFailure(Throwable e) {

            }
        });
    }

    @Override
    public void getPopularPresenter(String page, String count) {
        homeModel.getPopularData(page, count, new HomeContract.iModel.iHomeCallBack() {
            @Override
            public void onBannerSuccess(CaeBean caeBean) {

            }

            @Override
            public void onBannerFailure(Throwable failure) {

            }

            @Override
            public void onNowshowSuccess(NowshowingBean nowshowingBean) {

            }

            @Override
            public void onNowshowFailure(Throwable e) {

            }

            @Override
            public void onComingsonnSuccess(ComingsoonBean comingsoonBean) {

            }

            @Override
            public void onComingsonnFailure(Throwable e) {

            }

            @Override
            public void onPopularSuccess(PopularBean popularBean) {
                if (isViewAttached()) {
                    if (popularBean != null && Constant.SUCCESS_CODE.equals(popularBean.getStatus())) {
                        getView().onPopularSuccess(popularBean);
                    }else {
                        getView().onPopularFailure(new Exception("服务器异常"));
                    }
                }
            }

            @Override
            public void onPopularFailure(Throwable e) {
                getView().onPopularFailure(e);
            }
        });
    }
}
