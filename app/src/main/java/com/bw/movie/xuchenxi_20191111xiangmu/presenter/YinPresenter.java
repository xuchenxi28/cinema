package com.bw.movie.xuchenxi_20191111xiangmu.presenter;

import com.bawei.library.app.Constant;
import com.bawei.library.base.BasePresenter;
import com.bw.movie.xuchenxi_20191111xiangmu.bean.TjyyBean;
import com.bw.movie.xuchenxi_20191111xiangmu.contract.YingContract;
import com.bw.movie.xuchenxi_20191111xiangmu.model.YingModel;

public class YinPresenter extends BasePresenter<YingContract.TjyyContreact.IView> implements YingContract.TjyyContreact.IPresenter {

    private YingModel yingModel;

    @Override
    protected void initModel() {
        yingModel = new YingModel();
    }

    @Override
    public void getTjyyPresenter(String userId, String sessionId, Integer page, String count) {
        yingModel.getTjyyDataModel(userId, sessionId, page, count, new YingContract.TjyyContreact.IModel.IModelCallback() {
            @Override
            public void onTjyySuccess(TjyyBean data) {
                if (isViewAttached()) {
                    if (data != null && Constant.SUCCESS_CODE.equals(data.getStatus())) {
                        getView().onTjyySuccess(data);
                    }else {
                        getView().onTjyyFailure(new Exception("服务器异常"));
                    }
                }
            }

            @Override
            public void onTjyyFailure(Throwable e) {
                if (isViewAttached()) {
                    getView().onTjyyFailure(e);
                }
            }
        });
    }
}
