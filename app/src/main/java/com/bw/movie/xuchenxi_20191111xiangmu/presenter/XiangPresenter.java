package com.bw.movie.xuchenxi_20191111xiangmu.presenter;

import com.bawei.library.app.Constant;
import com.bawei.library.base.BasePresenter;
import com.bw.movie.xuchenxi_20191111xiangmu.bean.XiangBean;
import com.bw.movie.xuchenxi_20191111xiangmu.contract.XiangContract;
import com.bw.movie.xuchenxi_20191111xiangmu.model.XiangModel;
import com.bw.movie.xuchenxi_20191111xiangmu.model.YingModel;

/**
 * <p>文件描述：<p>
 * <p>作者：徐晨曦<p>
 * <p>创建时间：2019/11/18<p>
 * <p>更改时间：2019/11/18<p>
 */
public class XiangPresenter extends BasePresenter<XiangContract.iView> implements XiangContract.iPresenter{

    private XiangModel xiangModel;

    @Override
    protected void initModel() {
        xiangModel = new XiangModel();
    }

    @Override
    public void getXiangPresenter(int movieId) {
        xiangModel.getXiangData(movieId, new XiangContract.iModel.iXiangCallBack() {
            @Override
            public void onXiangSuccess(XiangBean xiangBean) {
                if (isViewAttached()) {
                    if (xiangBean != null && Constant.SUCCESS_CODE.equals(xiangBean.getStatus())) {
                        getView().onXiangSuccess(xiangBean);
                    }else {
                        getView().onXiangFailure(new Exception("服务器异常"));
                    }
                }
            }

            @Override
            public void onXiangFailure(Throwable failure) {
                if (isViewAttached()) {
                    getView().onXiangFailure(failure);
                }
            }
        });
    }
}
