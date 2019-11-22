package com.bw.movie.xuchenxi_20191111xiangmu.model;

import com.bawei.library.utils.CommonObserver;
import com.bawei.library.utils.CommonSchedulers;
import com.bawei.library.utils.RetrofitManager;
import com.bw.movie.xuchenxi_20191111xiangmu.IApi;
import com.bw.movie.xuchenxi_20191111xiangmu.bean.CinemaBean;
import com.bw.movie.xuchenxi_20191111xiangmu.bean.FindBean;
import com.bw.movie.xuchenxi_20191111xiangmu.bean.FjYyBean;
import com.bw.movie.xuchenxi_20191111xiangmu.bean.TjyyBean;
import com.bw.movie.xuchenxi_20191111xiangmu.contract.YingContract;

public class YingModel implements YingContract.TjyyContreact.IModel ,YingContract.FjyyContreact.IModel,YingContract.FindContreact.IModel{
    @Override
    public void getTjyyDataModel(String userId, String sessionId, Integer page, String count, YingContract.TjyyContreact.IModel.IModelCallback callback) {
        RetrofitManager.getInstance().create(IApi.class)
                .getTjyy(userId,sessionId,page,count)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<TjyyBean>() {
                    @Override
                    public void onNext(TjyyBean tjyyBean) {
                        callback.onTjyySuccess(tjyyBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onTjyyFailure(e);
                    }
                });
    }

    @Override
    public void getFjyyDataModel(String userId, String sessionId, String longitude, String latitude, Integer page, String count, YingContract.FjyyContreact.IModel.IModelCallback callback) {
            RetrofitManager.getInstance().create(IApi.class)
                    .getFjyy(userId, sessionId, longitude, latitude, page, count)
                    .compose(CommonSchedulers.io2main())
                    .subscribe(new CommonObserver<FjYyBean>() {
                        @Override
                        public void onNext(FjYyBean fjYyBean) {
                            callback.onFjyySuccess(fjYyBean);
                        }

                        @Override
                        public void onError(Throwable e) {
                            callback.onFjyyFailure(e);
                        }
                    });
    }

    @Override
    public void getFindDataModel(YingContract.FindContreact.IModel.IModelCallback callback) {
        RetrofitManager.getInstance().create(IApi.class)
                .getfind()
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<FindBean>() {
                    @Override
                    public void onNext(FindBean findBean) {
                        callback.onFindSuccess(findBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onFindFailure(e);
                    }
                });

    }

    @Override
    public void getCinemaDataModel(String regionId, ICinemaModelCallback callback) {
            RetrofitManager.getInstance().create(IApi.class)
                    .getcinema(regionId)
                    .compose(CommonSchedulers.io2main())
                    .subscribe(new CommonObserver<CinemaBean>() {
                        @Override
                        public void onNext(CinemaBean cinemaBean) {
                            callback.onCinemaSuccess(cinemaBean);
                        }

                        @Override
                        public void onError(Throwable e) {
                            callback.onCinemaFailure(e);
                        }
                    });

    }
}
