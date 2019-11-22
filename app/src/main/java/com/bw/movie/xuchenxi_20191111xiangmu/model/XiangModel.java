package com.bw.movie.xuchenxi_20191111xiangmu.model;

import android.util.Log;

import com.bawei.library.utils.CommonObserver;
import com.bawei.library.utils.CommonSchedulers;
import com.bawei.library.utils.RetrofitManager;
import com.bw.movie.xuchenxi_20191111xiangmu.IApi;
import com.bw.movie.xuchenxi_20191111xiangmu.bean.XiangBean;
import com.bw.movie.xuchenxi_20191111xiangmu.contract.XiangContract;

/**
 * <p>文件描述：<p>
 * <p>作者：徐晨曦<p>
 * <p>创建时间：2019/11/18<p>
 * <p>更改时间：2019/11/18<p>
 */
public class XiangModel implements XiangContract.iModel {
    private static final String TAG = "XiangModel";
    @Override
    public void getXiangData(int movieId, iXiangCallBack iXiangCallBack) {
        RetrofitManager.getInstance().create(IApi.class)
                .getXiang(movieId)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<XiangBean>() {
                    @Override
                    public void onNext(XiangBean xiangBean) {
                        iXiangCallBack.onXiangSuccess(xiangBean);
                        Log.d(TAG, "onNext: "+xiangBean.getStatus());
                    }

                    @Override
                    public void onError(Throwable e) {
                        iXiangCallBack.onXiangFailure(e);
                    }
                });
    }
}
