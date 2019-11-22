package com.bw.movie.xuchenxi_20191111xiangmu.contract;

import com.bawei.library.base.BaseView;
import com.bw.movie.xuchenxi_20191111xiangmu.bean.FilmReviewBean;
import com.bw.movie.xuchenxi_20191111xiangmu.bean.FindBean;
import com.bw.movie.xuchenxi_20191111xiangmu.bean.InformationBean;
import com.bw.movie.xuchenxi_20191111xiangmu.bean.SchduBean;
import com.bw.movie.xuchenxi_20191111xiangmu.bean.TimetheaterBean;

/**
 * <p>文件描述：<p>
 * <p>作者：徐晨曦<p>
 * <p>创建时间：2019/11/20<p>
 * <p>更改时间：2019/11/20<p>
 */
public interface InformationContract {
    interface IModel {
        void getQueryareaModel(IModelCallback callback);
        void getSchduModel(IModelCallback callback);
        void getInformationModel(int movieId,String regionId,String page,String count,IModelCallback callback);
        void getTimetheaterModel(int movieId,String date,String page,String count,IModelCallback callback);
        //model层中的接口回调
        interface IModelCallback {
            void onQueryareaSuccess(FindBean data);
            void onQueryareaFailure(Throwable e);

            void onSchduSuccess(SchduBean data);
            void onSchduFailure(Throwable e);

            void onInformationSuccess(InformationBean data);
            void onInformationFailure(Throwable e);

            void onTimetheaterSuccess(TimetheaterBean data);
            void onTimetheaterFailure(Throwable e);
        }

    }
    //view层  命名必须是IView
    interface IView extends BaseView {
        void onQueryareaSuccess(FindBean data);
        void onQueryareaFailure(Throwable e);

        void onSchduSuccess(SchduBean data);
        void onSchduFailure(Throwable e);

        void onInformationSuccess(InformationBean data);
        void onInformationFailure(Throwable e);

        void onTimetheaterSuccess(TimetheaterBean data);
        void onTimetheaterFailure(Throwable e);
    }
    //presenter层   命名必须是IPresenter
    interface IPresenter {
        void getQueryareaPresenter();
        void getSchduPresenter();
        void getgetInformation(int movieId,String regionId,String page,String count);
        void getTimetheater(int movieId,String date,String page,String count);
    }
}
