package com.bw.movie.xuchenxi_20191111xiangmu.contract;

import com.bawei.library.base.BaseView;
import com.bw.movie.xuchenxi_20191111xiangmu.bean.CaeBean;
import com.bw.movie.xuchenxi_20191111xiangmu.bean.ComingsoonBean;
import com.bw.movie.xuchenxi_20191111xiangmu.bean.NowshowingBean;
import com.bw.movie.xuchenxi_20191111xiangmu.bean.PopularBean;
import com.bw.movie.xuchenxi_20191111xiangmu.bean.XiangBean;

/**
 * <p>文件描述：<p>
 * <p>作者：徐晨曦<p>
 * <p>创建时间：2019/11/18<p>
 * <p>更改时间：2019/11/18<p>
 */
public interface XiangContract {
    interface iView extends BaseView {
        void onXiangSuccess(XiangBean xiangBean);
        void onXiangFailure(Throwable e);

    }
    interface iModel{
        void getXiangData(int movieId,iXiangCallBack iXiangCallBack);
        interface iXiangCallBack{
            void onXiangSuccess(XiangBean xiangBean);
            void onXiangFailure(Throwable failure);
        }
    }
    interface iPresenter{
        void getXiangPresenter(int movieId);
    }
}
