package com.bw.movie.xuchenxi_20191111xiangmu;

import com.bw.movie.xuchenxi_20191111xiangmu.bean.CaeBean;
import com.bw.movie.xuchenxi_20191111xiangmu.bean.CinemaBean;
import com.bw.movie.xuchenxi_20191111xiangmu.bean.ComingsoonBean;
import com.bw.movie.xuchenxi_20191111xiangmu.bean.FilmReviewBean;
import com.bw.movie.xuchenxi_20191111xiangmu.bean.FindBean;
import com.bw.movie.xuchenxi_20191111xiangmu.bean.FjYyBean;
import com.bw.movie.xuchenxi_20191111xiangmu.bean.InformationBean;
import com.bw.movie.xuchenxi_20191111xiangmu.bean.LoginBean;
import com.bw.movie.xuchenxi_20191111xiangmu.bean.NowshowingBean;
import com.bw.movie.xuchenxi_20191111xiangmu.bean.PopularBean;
import com.bw.movie.xuchenxi_20191111xiangmu.bean.RegisterBean;
import com.bw.movie.xuchenxi_20191111xiangmu.bean.SchduBean;
import com.bw.movie.xuchenxi_20191111xiangmu.bean.TimetheaterBean;
import com.bw.movie.xuchenxi_20191111xiangmu.bean.TjyyBean;
import com.bw.movie.xuchenxi_20191111xiangmu.bean.XiangBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface IApi {
    //http://172.17.8.100/movieApi/user/v2/login
    @FormUrlEncoded
    @POST("user/v2/login")
    Observable<LoginBean> LoginData(@Field("email")String email, @Field("pwd")String pwd);
    //http://172.17.8.100/movieApi/user/v2/register
    @FormUrlEncoded
    @POST("user/v2/register")
    Observable<RegisterBean> RegisterData(@Field("nickName")String nickName,
                                          @Field("pwd")String pwd, @Field("email")String email,
                                          @Field("code")String code);
    //http://172.17.8.100/movieApi/tool/v2/banner//轮播
    @GET("tool/v2/banner")
    Observable<CaeBean> CaeData();
    //http://172.17.8.100/movieApi/movie/v2/findReleaseMovieList正在上映
    @GET("movie/v2/findReleaseMovieList")
    Observable<NowshowingBean> NowshowData(@Query("page")String page,@Query("count")String count);
    //http://172.17.8.100/movieApi/movie/v2/findComingSoonMovieList即将上映
    @GET("movie/v2/findComingSoonMovieList")
    Observable<ComingsoonBean> ComingsonnData(@Query("page")String page,@Query("count")String count);
    //http://172.17.8.100/movieApi/movie/v2/findHotMovieList热门上映
    @GET("movie/v2/findHotMovieList")
    Observable<PopularBean> PopularData(@Query("page")String page,@Query("count")String count);

    //http://172.17.8.100/movieApi/cinema/v1/findRecommendCinemas
    //推荐影院
    @GET("cinema/v1/findRecommendCinemas")
    Observable<TjyyBean> getTjyy(@Header("userId") String userId , @Header("sessionId") String sessionId,
                                 @Query("page") Integer page, @Query("count") String count);
    //查询附近影院
    @GET("cinema/v1/findNearbyCinemas")
    Observable<FjYyBean> getFjyy(@Header("userId") String userId,
                                 @Header("sessionId") String sessionId,
                                 @Query("longitude") String longitude,
                                 @Query("latitude") String latitude,
                                 @Query("page") Integer page,
                                 @Query("count") String count);
    //查询地区
    //http://172.17.8.100/movieApi/tool/v2/findRegionList
    @GET("tool/v2/findRegionList")
    Observable<FindBean> getfind();
    //http://172.17.8.100/movieApi/cinema/v1/findNearbyCinemas
    //根据地区查询影院
    @GET("cinema/v2/findCinemaByRegion")
    Observable<CinemaBean> getcinema(@Query("regionId") String regionId);

    //电影详情
    //http://172.17.8.100/movieApi/movie/v2/findMoviesDetail
    @GET("movie/v2/findMoviesDetail")
    Observable<XiangBean> getXiang(@Query("movieId") int movieId);

    //根据电影的id查询电影评论
    //http://172.17.8.100/movieApi/movie/v2/findAllMovieComment
    @GET("movie/v2/findAllMovieComment")
    Observable<FilmReviewBean> getFilmReview(@Query("movieId")int movieId,@Query("page")String page,@Query("count")String count);

    //查询地区
    //http://172.17.8.100/movieApi/tool/v2/findRegionList
    @GET("tool/v2/findRegionList")
    Observable<FindBean> getQueryarea();

    //根据电影id,区域id 查询播放影院信息
    //http://172.17.8.100/movieApi/movie/v2/findCinemasInfoByRegion
    @GET("movie/v2/findCinemasInfoByRegion")
    Observable<InformationBean> getInformation(@Query("movieId")int movieId, @Query("regionId")String regionId,
                                               @Query("page")String page,
                                               @Query("count")String count);
    //查询一周排期的时间
    //http://172.17.8.100/movieApi/tool/v2/findDateList
    @GET("tool/v2/findDateList")
    Observable<SchduBean> getschdu();

    //根据电影id，时间 查询播放影院信息
    //http://172.17.8.100/movieApi/movie/v2/findCinemasInfoByDate
    @GET("movie/v2/findCinemasInfoByDate")
    Observable<TimetheaterBean> getTimetheater(@Query("movieId")int movieId,@Query("date")String date,
                                               @Query("page")String page,@Query("count")String count);
}
