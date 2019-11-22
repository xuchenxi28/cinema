package com.bw.movie.xuchenxi_20191111xiangmu.presenter;

import com.bawei.library.app.Constant;
import com.bawei.library.base.BasePresenter;
import com.bw.movie.xuchenxi_20191111xiangmu.bean.FindBean;
import com.bw.movie.xuchenxi_20191111xiangmu.bean.InformationBean;
import com.bw.movie.xuchenxi_20191111xiangmu.bean.SchduBean;
import com.bw.movie.xuchenxi_20191111xiangmu.bean.TimetheaterBean;
import com.bw.movie.xuchenxi_20191111xiangmu.contract.InformationContract;
import com.bw.movie.xuchenxi_20191111xiangmu.model.InformationModel;

/**
 * <p>文件描述：<p>
 * <p>作者：徐晨曦<p>
 * <p>创建时间：2019/11/20<p>
 * <p>更改时间：2019/11/20<p>
 */
public class InformationPresenter extends BasePresenter<InformationContract.IView> implements InformationContract.IPresenter {

    private InformationModel informationModel;

    @Override
    protected void initModel() {
        informationModel = new InformationModel();
    }

    @Override
    public void getQueryareaPresenter() {
        informationModel.getQueryareaModel(new InformationContract.IModel.IModelCallback() {
            @Override
            public void onQueryareaSuccess(FindBean data) {
                if (isViewAttached()) {
                    if (data != null && Constant.SUCCESS_CODE.equals(data.getStatus())) {
                        getView().onQueryareaSuccess(data);
                    }else {
                        getView().onQueryareaFailure(new Exception("服务器异常"));
                    }
                }
            }

            @Override
            public void onQueryareaFailure(Throwable e) {
                if (isViewAttached()) {
                    getView().onQueryareaFailure(e);
                }
            }

            @Override
            public void onSchduSuccess(SchduBean data) {

            }

            @Override
            public void onSchduFailure(Throwable e) {

            }

            @Override
            public void onInformationSuccess(InformationBean data) {

            }

            @Override
            public void onInformationFailure(Throwable e) {

            }

            @Override
            public void onTimetheaterSuccess(TimetheaterBean data) {

            }

            @Override
            public void onTimetheaterFailure(Throwable e) {

            }
        });
    }

    @Override
    public void getSchduPresenter() {
        informationModel.getSchduModel(new InformationContract.IModel.IModelCallback() {
            @Override
            public void onQueryareaSuccess(FindBean data) {

            }

            @Override
            public void onQueryareaFailure(Throwable e) {

            }

            @Override
            public void onSchduSuccess(SchduBean data) {
                if (isViewAttached()) {
                    if (data != null && Constant.SUCCESS_CODE.equals(data.getStatus())) {
                        getView().onSchduSuccess(data);
                    }else {
                        getView().onSchduFailure(new Exception("服务器异常"));
                    }
                }
            }

            @Override
            public void onSchduFailure(Throwable e) {
                if (isViewAttached()) {
                    getView().onSchduFailure(e);
                }
            }

            @Override
            public void onInformationSuccess(InformationBean data) {

            }

            @Override
            public void onInformationFailure(Throwable e) {

            }

            @Override
            public void onTimetheaterSuccess(TimetheaterBean data) {

            }

            @Override
            public void onTimetheaterFailure(Throwable e) {

            }
        });
    }

    @Override
    public void getgetInformation(int movieId, String regionId, String page, String count) {
        informationModel.getInformationModel(movieId, regionId, page, count, new InformationContract.IModel.IModelCallback() {
            @Override
            public void onQueryareaSuccess(FindBean data) {

            }

            @Override
            public void onQueryareaFailure(Throwable e) {

            }

            @Override
            public void onSchduSuccess(SchduBean data) {

            }

            @Override
            public void onSchduFailure(Throwable e) {

            }

            @Override
            public void onInformationSuccess(InformationBean data) {
                if (isViewAttached()) {
                    if (data != null && Constant.SUCCESS_CODE.equals(data.getStatus())) {
                        getView().onInformationSuccess(data);
                    }else {
                        getView().onInformationFailure(new Exception("服务器异常"));
                    }
                }
            }

            @Override
            public void onInformationFailure(Throwable e) {
                if (isViewAttached()) {
                    getView().onInformationFailure(e);
                }
            }

            @Override
            public void onTimetheaterSuccess(TimetheaterBean data) {

            }

            @Override
            public void onTimetheaterFailure(Throwable e) {

            }
        });
    }

    @Override
    public void getTimetheater(int movieId, String date, String page, String count) {
        informationModel.getTimetheaterModel(movieId, date, page, count, new InformationContract.IModel.IModelCallback() {
            @Override
            public void onQueryareaSuccess(FindBean data) {

            }

            @Override
            public void onQueryareaFailure(Throwable e) {

            }

            @Override
            public void onSchduSuccess(SchduBean data) {

            }

            @Override
            public void onSchduFailure(Throwable e) {

            }

            @Override
            public void onInformationSuccess(InformationBean data) {

            }

            @Override
            public void onInformationFailure(Throwable e) {

            }

            @Override
            public void onTimetheaterSuccess(TimetheaterBean data) {
                if (isViewAttached()) {
                    if (data != null && Constant.SUCCESS_CODE.equals(data.getStatus())) {
                        getView().onTimetheaterSuccess(data);
                    }else {
                        getView().onTimetheaterFailure(new Exception("服务器异常"));
                    }
                }
            }

            @Override
            public void onTimetheaterFailure(Throwable e) {
                if (isViewAttached()) {
                    getView().onTimetheaterFailure(e);
                }
            }
        });
    }
}
