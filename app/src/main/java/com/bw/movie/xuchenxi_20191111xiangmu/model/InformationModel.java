package com.bw.movie.xuchenxi_20191111xiangmu.model;

import com.bawei.library.utils.CommonObserver;
import com.bawei.library.utils.CommonSchedulers;
import com.bawei.library.utils.RetrofitManager;
import com.bw.movie.xuchenxi_20191111xiangmu.IApi;
import com.bw.movie.xuchenxi_20191111xiangmu.bean.FindBean;
import com.bw.movie.xuchenxi_20191111xiangmu.bean.InformationBean;
import com.bw.movie.xuchenxi_20191111xiangmu.bean.SchduBean;
import com.bw.movie.xuchenxi_20191111xiangmu.bean.TimetheaterBean;
import com.bw.movie.xuchenxi_20191111xiangmu.contract.InformationContract;

/**
 * <p>文件描述：<p>
 * <p>作者：徐晨曦<p>
 * <p>创建时间：2019/11/20<p>
 * <p>更改时间：2019/11/20<p>
 */
public class InformationModel implements InformationContract.IModel {
    @Override
    public void getQueryareaModel(IModelCallback callback) {
        RetrofitManager.getInstance().create(IApi.class)
                .getQueryarea()
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<FindBean>() {
                    @Override
                    public void onNext(FindBean findBean) {
                        callback.onQueryareaSuccess(findBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onQueryareaFailure(e);
                    }
                });
    }

    @Override
    public void getSchduModel(IModelCallback callback) {
        RetrofitManager.getInstance().create(IApi.class)
                .getschdu()
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<SchduBean>() {
                    @Override
                    public void onNext(SchduBean schduBean) {
                        callback.onSchduSuccess(schduBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onSchduFailure(e);
                    }
                });
    }

    @Override
    public void getInformationModel(int movieId, String regionId, String page, String count, IModelCallback callback) {
        RetrofitManager.getInstance().create(IApi.class)
                .getInformation(movieId,regionId,page,count)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<InformationBean>() {
                    @Override
                    public void onNext(InformationBean informationBean) {
                        callback.onInformationSuccess(informationBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onInformationFailure(e);
                    }
                });
    }

    @Override
    public void getTimetheaterModel(int movieId, String date, String page, String count, IModelCallback callback) {
        RetrofitManager.getInstance().create(IApi.class)
                .getTimetheater(movieId,date,page,count)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<TimetheaterBean>() {
                    @Override
                    public void onNext(TimetheaterBean timetheaterBean) {
                        callback.onTimetheaterSuccess(timetheaterBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onTimetheaterFailure(e);
                    }
                });
    }
}
