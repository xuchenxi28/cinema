package com.bw.movie.xuchenxi_20191111xiangmu.presenter;

import com.bawei.library.app.Constant;
import com.bawei.library.base.BasePresenter;
import com.bw.movie.xuchenxi_20191111xiangmu.bean.FjYyBean;
import com.bw.movie.xuchenxi_20191111xiangmu.contract.YingContract;
import com.bw.movie.xuchenxi_20191111xiangmu.model.YingModel;

/**
 * <p>文件描述：<p>
 * <p>作者：徐晨曦<p>
 * <p>创建时间：2019/11/15<p>
 * <p>更改时间：2019/11/15<p>
 */
public class NearbyPresenter extends BasePresenter<YingContract.FjyyContreact.IView> implements YingContract.FjyyContreact.IPresenter {

    private YingModel yingModel;

    @Override
    protected void initModel() {
        yingModel = new YingModel();
    }

    @Override
    public void getFjyyPresenter(String userId, String sessionId, String longitude, String latitude, Integer page, String count) {
        yingModel.getFjyyDataModel(userId, sessionId, longitude, latitude, page, count, new YingContract.FjyyContreact.IModel.IModelCallback() {
            @Override
            public void onFjyySuccess(FjYyBean data) {
                if (isViewAttached()) {
                    if (data != null && Constant.SUCCESS_CODE.equals(data.getStatus())) {
                        getView().onFjyySuccess(data);
                    }else {
                        getView().onFjyyFailure(new Exception("服务异常"));
                    }
                }
            }

            @Override
            public void onFjyyFailure(Throwable e) {
                getView().onFjyyFailure(e);
            }
        });
    }
}
