package com.bw.movie.xuchenxi_20191111xiangmu.model;

import com.bawei.library.utils.CommonObserver;
import com.bawei.library.utils.CommonSchedulers;
import com.bawei.library.utils.RetrofitManager;
import com.bw.movie.xuchenxi_20191111xiangmu.IApi;
import com.bw.movie.xuchenxi_20191111xiangmu.bean.FilmReviewBean;
import com.bw.movie.xuchenxi_20191111xiangmu.contract.FilmReviewContract;

/**
 * <p>文件描述：<p>
 * <p>作者：徐晨曦<p>
 * <p>创建时间：2019/11/20<p>
 * <p>更改时间：2019/11/20<p>
 */
public class FilmReviewModel implements FilmReviewContract.IModel {
    @Override
    public void getFilmReviewModel(int movieId, String page, String count, IModelCallback callback) {
        RetrofitManager.getInstance().create(IApi.class)
                .getFilmReview(movieId,page,count)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<FilmReviewBean>() {
                    @Override
                    public void onNext(FilmReviewBean filmReviewBean) {
                        callback.onFilmReviewSuccess(filmReviewBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        callback.onFilmReviewFailure(e);
                    }
                });
    }
}
