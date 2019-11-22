package com.bw.movie.xuchenxi_20191111xiangmu.model;

import com.bawei.library.utils.CommonObserver;
import com.bawei.library.utils.CommonSchedulers;
import com.bawei.library.utils.RetrofitManager;
import com.bw.movie.xuchenxi_20191111xiangmu.IApi;
import com.bw.movie.xuchenxi_20191111xiangmu.bean.CaeBean;
import com.bw.movie.xuchenxi_20191111xiangmu.bean.ComingsoonBean;
import com.bw.movie.xuchenxi_20191111xiangmu.bean.NowshowingBean;
import com.bw.movie.xuchenxi_20191111xiangmu.bean.PopularBean;
import com.bw.movie.xuchenxi_20191111xiangmu.contract.HomeContract;

public class HomeModel implements HomeContract.iModel {
    @Override
    public void getBannerData(iHomeCallBack iHomeCallBack) {
        RetrofitManager.getInstance().create(IApi.class)
                .CaeData()
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<CaeBean>() {
                    @Override
                    public void onNext(CaeBean caeBean) {
                        iHomeCallBack.onBannerSuccess(caeBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iHomeCallBack.onBannerFailure(e);
                    }
                });
    }

    @Override
    public void getNowshowData(String page, String count, iHomeCallBack iHomeCallBack) {
        RetrofitManager.getInstance().create(IApi.class)
                .NowshowData(page,count)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<NowshowingBean>() {
                    @Override
                    public void onNext(NowshowingBean nowshowingBean) {
                        iHomeCallBack.onNowshowSuccess(nowshowingBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iHomeCallBack.onNowshowFailure(e);
                    }
                });
    }

    @Override
    public void getComingsonnData(String page, String count, iHomeCallBack iHomeCallBack) {
            RetrofitManager.getInstance().create(IApi.class)
                    .ComingsonnData(page,count)
                    .compose(CommonSchedulers.io2main())
                    .subscribe(new CommonObserver<ComingsoonBean>() {
                        @Override
                        public void onNext(ComingsoonBean comingsoonBean) {
                            iHomeCallBack.onComingsonnSuccess(comingsoonBean);
                        }

                        @Override
                        public void onError(Throwable e) {
                            iHomeCallBack.onComingsonnFailure(e);
                        }
                    });
    }

    @Override
    public void getPopularData(String page, String count, iHomeCallBack iHomeCallBack) {
            RetrofitManager.getInstance().create(IApi.class)
                    .PopularData(page,count)
                    .compose(CommonSchedulers.io2main())
                    .subscribe(new CommonObserver<PopularBean>() {
                        @Override
                        public void onNext(PopularBean popularBean) {
                            iHomeCallBack.onPopularSuccess(popularBean);
                        }

                        @Override
                        public void onError(Throwable e) {
                            iHomeCallBack.onPopularFailure(e);
                        }
                    });
    }
}
