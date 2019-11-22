package com.bw.movie.xuchenxi_20191111xiangmu.contract;

import com.bawei.library.base.BaseView;
import com.bw.movie.xuchenxi_20191111xiangmu.bean.CinemaBean;
import com.bw.movie.xuchenxi_20191111xiangmu.bean.FindBean;
import com.bw.movie.xuchenxi_20191111xiangmu.bean.FjYyBean;
import com.bw.movie.xuchenxi_20191111xiangmu.bean.TjyyBean;

public interface YingContract {
    //查询推荐影院信息
    interface TjyyContreact {
        interface IModel {
            void getTjyyDataModel(String userId, String sessionId, Integer page, String count,IModelCallback callback);

            //model层中的接口回调
            interface IModelCallback {
                void onTjyySuccess(TjyyBean data);

                void onTjyyFailure(Throwable e);
            }

        }

        //view层  命名必须是IView
        interface IView extends BaseView {
            void onTjyySuccess(TjyyBean data);

            void onTjyyFailure(Throwable e);


        }

        //presenter层   命名必须是IPresenter
        interface IPresenter {

            void getTjyyPresenter(String userId, String sessionId, Integer page, String count);

        }
    }

    interface FjyyContreact {
        interface IModel {
            void getFjyyDataModel(String userId, String sessionId, String longitude,String latitude, Integer page,String count,IModelCallback callback);

            //model层中的接口回调
            interface IModelCallback {
                void onFjyySuccess(FjYyBean data);

                void onFjyyFailure(Throwable e);
            }

        }

        //view层  命名必须是IView
        interface IView extends BaseView {
            void onFjyySuccess(FjYyBean data);

            void onFjyyFailure(Throwable e);


        }

        //presenter层   命名必须是IPresenter
        interface IPresenter {

            void getFjyyPresenter(String userId, String sessionId,String longitude,String latitude, Integer page,String count);

        }
    }

    //查询地区
    interface FindContreact {
        interface IModel {
            void getFindDataModel(IModelCallback callback);
            //model层中的接口回调
            interface IModelCallback {
                void onFindSuccess(FindBean data);
                void onFindFailure(Throwable e);
            }

            void getCinemaDataModel(String regionId, ICinemaModelCallback callback);
            //model层中的接口回调
            interface ICinemaModelCallback {
                void onCinemaSuccess(CinemaBean data);
                void onCinemaFailure(Throwable e);
            }
        }

        //view层  命名必须是IView
        interface IView extends BaseView {
            void onFindSuccess(FindBean data);
            void onFindFailure(Throwable e);
            void onCinemaSuccess(CinemaBean data);
            void onCinemaFailure(Throwable e);
        }

        //presenter层   命名必须是IPresenter
        interface IPresenter {
            void getFindPresenter();

            void getCinemaPresenter(String regionId);
        }
    }

}
