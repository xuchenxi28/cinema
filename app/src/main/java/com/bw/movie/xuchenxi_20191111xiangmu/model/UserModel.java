package com.bw.movie.xuchenxi_20191111xiangmu.model;

import com.bawei.library.utils.CommonObserver;
import com.bawei.library.utils.CommonSchedulers;
import com.bawei.library.utils.RetrofitManager;
import com.bw.movie.xuchenxi_20191111xiangmu.IApi;
import com.bw.movie.xuchenxi_20191111xiangmu.bean.LoginBean;
import com.bw.movie.xuchenxi_20191111xiangmu.bean.RegisterBean;
import com.bw.movie.xuchenxi_20191111xiangmu.contract.UserContract;

public class UserModel implements UserContract.iModel {
    @Override
    public void getLoginData(String email, String pwd, iUserCallBack iUserCallBack) {
        RetrofitManager.getInstance().create(IApi.class)
                .LoginData(email,pwd)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<LoginBean>() {
                    @Override
                    public void onNext(LoginBean loginBean) {
                        iUserCallBack.onLoginSuccess(loginBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iUserCallBack.onLoginFailure(e);
                    }
                });
    }

    @Override
    public void getRegisterData(String nickName, String pwd, String email, String code, iUserCallBack iUserCallBack) {
        RetrofitManager.getInstance().create(IApi.class)
                .RegisterData(nickName, pwd, email, code)
                .compose(CommonSchedulers.io2main())
                .subscribe(new CommonObserver<RegisterBean>() {
                    @Override
                    public void onNext(RegisterBean registerBean) {
                        iUserCallBack.onRegisterSuccess(registerBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        iUserCallBack.onRegisterFailure(e);
                    }
                });
    }
}
