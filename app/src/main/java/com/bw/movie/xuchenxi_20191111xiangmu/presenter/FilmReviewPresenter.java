package com.bw.movie.xuchenxi_20191111xiangmu.presenter;

import com.bawei.library.app.Constant;
import com.bawei.library.base.BasePresenter;
import com.bw.movie.xuchenxi_20191111xiangmu.bean.FilmReviewBean;
import com.bw.movie.xuchenxi_20191111xiangmu.contract.FilmReviewContract;
import com.bw.movie.xuchenxi_20191111xiangmu.model.FilmReviewModel;

/**
 * <p>文件描述：<p>
 * <p>作者：徐晨曦<p>
 * <p>创建时间：2019/11/20<p>
 * <p>更改时间：2019/11/20<p>
 */
public class FilmReviewPresenter extends BasePresenter<FilmReviewContract.IView> implements FilmReviewContract.IPresenter {

    private FilmReviewModel filmReviewModel;

    @Override
    protected void initModel() {
        filmReviewModel = new FilmReviewModel();
    }

    @Override
    public void getFilmReviewPresenter(int movieId, String page, String count) {
        filmReviewModel.getFilmReviewModel(movieId, page, count, new FilmReviewContract.IModel.IModelCallback() {
            @Override
            public void onFilmReviewSuccess(FilmReviewBean data) {
                if (isViewAttached()) {
                    if (data != null && Constant.SUCCESS_CODE.equals(data.getStatus())) {
                        getView().onFilmReviewSuccess(data);
                    }else {
                        getView().onFilmReviewFailure(new Exception("服务器异常"));
                    }
                }
            }

            @Override
            public void onFilmReviewFailure(Throwable e) {
                if (isViewAttached()) {
                    getView().onFilmReviewFailure(e);
                }
            }
        });
    }
}
