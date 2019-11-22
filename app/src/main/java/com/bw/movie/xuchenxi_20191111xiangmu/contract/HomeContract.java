package com.bw.movie.xuchenxi_20191111xiangmu.contract;

import com.bawei.library.base.BaseView;
import com.bw.movie.xuchenxi_20191111xiangmu.bean.CaeBean;
import com.bw.movie.xuchenxi_20191111xiangmu.bean.ComingsoonBean;
import com.bw.movie.xuchenxi_20191111xiangmu.bean.LoginBean;
import com.bw.movie.xuchenxi_20191111xiangmu.bean.NowshowingBean;
import com.bw.movie.xuchenxi_20191111xiangmu.bean.PopularBean;
import com.bw.movie.xuchenxi_20191111xiangmu.bean.RegisterBean;

public interface HomeContract {
    interface iView extends BaseView {
        void onBannerSuccess(CaeBean caeBean);
        void onBannerFailure(Throwable e);

        void onNowshowSuccess(NowshowingBean nowshowingBean);
        void onNowshowFailure(Throwable e);

        void onComingsonnSuccess(ComingsoonBean comingsoonBean);
        void onComingsonnFailure(Throwable e);

        void onPopularSuccess(PopularBean popularBean);
        void onPopularFailure(Throwable e);
    }
    interface iModel{
        void getBannerData(iHomeCallBack iHomeCallBack);
        void getNowshowData(String page,String count,iHomeCallBack iHomeCallBack);
        void getComingsonnData(String page,String count,iHomeCallBack iHomeCallBack);
        void getPopularData(String page,String count,iHomeCallBack iHomeCallBack);
        interface iHomeCallBack{
            void onBannerSuccess(CaeBean caeBean);
            void onBannerFailure(Throwable failure);

            void onNowshowSuccess(NowshowingBean nowshowingBean);
            void onNowshowFailure(Throwable e);

            void onComingsonnSuccess(ComingsoonBean comingsoonBean);
            void onComingsonnFailure(Throwable e);

            void onPopularSuccess(PopularBean popularBean);
            void onPopularFailure(Throwable e);
        }
    }
    interface iPresenter{
        void getBannerPresenter();
        void getNowshowPresenter(String page,String count);
        void getComingsonnPresenter(String page,String count);
        void getPopularPresenter(String page,String count);
    }
}
