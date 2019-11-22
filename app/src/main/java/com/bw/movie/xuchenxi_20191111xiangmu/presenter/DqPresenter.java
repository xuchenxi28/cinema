package com.bw.movie.xuchenxi_20191111xiangmu.presenter;

import com.bawei.library.app.Constant;
import com.bawei.library.base.BasePresenter;
import com.bw.movie.xuchenxi_20191111xiangmu.bean.CinemaBean;
import com.bw.movie.xuchenxi_20191111xiangmu.bean.FindBean;
import com.bw.movie.xuchenxi_20191111xiangmu.contract.YingContract;
import com.bw.movie.xuchenxi_20191111xiangmu.model.YingModel;

/**
 * <p>文件描述：<p>
 * <p>作者：徐晨曦<p>
 * <p>创建时间：2019/11/19<p>
 * <p>更改时间：2019/11/19<p>
 */
public class DqPresenter extends BasePresenter<YingContract.FindContreact.IView>implements YingContract.FindContreact.IPresenter{

    private YingModel yingModel;

    @Override
    protected void initModel() {
        yingModel = new YingModel();
    }

    @Override
    public void getFindPresenter() {
        yingModel.getFindDataModel(new YingContract.FindContreact.IModel.IModelCallback() {
            @Override
            public void onFindSuccess(FindBean data) {
                if (isViewAttached()) {
                    if (data != null && Constant.SUCCESS_CODE.equals(data.getStatus())) {
                        getView().onFindSuccess(data);
                    }else {
                        getView().onFindFailure(new Exception("服务异常"));
                    }
                }
            }

            @Override
            public void onFindFailure(Throwable e) {
                if (isViewAttached()) {
                    getView().onFindFailure(e);
                }
            }
        });
    }

    @Override
    public void getCinemaPresenter(String regionId) {
        yingModel.getCinemaDataModel(regionId, new YingContract.FindContreact.IModel.ICinemaModelCallback() {
            @Override
            public void onCinemaSuccess(CinemaBean data) {
                if (isViewAttached()) {
                    if (data != null && Constant.SUCCESS_CODE.equals(data.getStatus())) {
                        getView().onCinemaSuccess(data);
                    }else {
                        getView().onCinemaFailure(new Exception("服务器异常"));
                    }
                }
            }

            @Override
            public void onCinemaFailure(Throwable e) {
                if (isViewAttached()) {
                    getView().onCinemaFailure(e);
                }
            }
        });
    }
}
