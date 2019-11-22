package com.bw.movie.xuchenxi_20191111xiangmu.contract;

import com.bawei.library.base.BaseView;
import com.bw.movie.xuchenxi_20191111xiangmu.bean.FilmReviewBean;
import com.bw.movie.xuchenxi_20191111xiangmu.bean.FindBean;
import com.bw.movie.xuchenxi_20191111xiangmu.bean.SchduBean;
import com.bw.movie.xuchenxi_20191111xiangmu.bean.TjyyBean;

/**
 * <p>文件描述：<p>
 * <p>作者：徐晨曦<p>
 * <p>创建时间：2019/11/20<p>
 * <p>更改时间：2019/11/20<p>
 */
public interface FilmReviewContract {

    //根据电影的id查询电影评论
        interface IModel {
            void getFilmReviewModel(int movieId,String page,String count,IModelCallback callback);
            //model层中的接口回调
            interface IModelCallback {
                void onFilmReviewSuccess(FilmReviewBean data);
                void onFilmReviewFailure(Throwable e);
            }

        }
        //view层  命名必须是IView
        interface IView extends BaseView {
            void onFilmReviewSuccess(FilmReviewBean data);
            void onFilmReviewFailure(Throwable e);

        }
        //presenter层   命名必须是IPresenter
        interface IPresenter {
            void getFilmReviewPresenter(int movieId,String page, String count);

        }

}
