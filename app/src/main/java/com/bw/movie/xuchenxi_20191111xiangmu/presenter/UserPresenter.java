package com.bw.movie.xuchenxi_20191111xiangmu.presenter;

import com.bawei.library.app.Constant;
import com.bawei.library.base.BasePresenter;
import com.bw.movie.xuchenxi_20191111xiangmu.bean.LoginBean;
import com.bw.movie.xuchenxi_20191111xiangmu.bean.RegisterBean;
import com.bw.movie.xuchenxi_20191111xiangmu.contract.UserContract;
import com.bw.movie.xuchenxi_20191111xiangmu.model.UserModel;

public class UserPresenter extends BasePresenter<UserContract.iView> implements UserContract.iPresenter {

    private UserModel userModel;

    @Override
    protected void initModel() {
        userModel = new UserModel();
    }

    @Override
    public void getLoginPresenter(String email, String pwd) {
        userModel.getLoginData(email, pwd, new UserContract.iModel.iUserCallBack() {
            @Override
            public void onLoginSuccess(LoginBean loginBean) {
                if (isViewAttached()) {
                    if (loginBean != null && Constant.SUCCESS_CODE.equals(loginBean.getStatus())) {
                        getView().onLoginSuccess(loginBean);
                    }else {
                        getView().onLoginFailure(new Exception("服务器异常"));
                    }
                }
            }

            @Override
            public void onLoginFailure(Throwable failure) {
                if (isViewAttached()) {
                    getView().onLoginFailure(failure);
                }
            }

            @Override
            public void onRegisterSuccess(RegisterBean registerBean) {

            }

            @Override
            public void onRegisterFailure(Throwable failure) {

            }

        });
    }

    @Override
    public void getRegisterPresenter(String nickName, String pwd, String email, String code) {
        userModel.getRegisterData(nickName, pwd, email, code, new UserContract.iModel.iUserCallBack() {
            @Override
            public void onLoginSuccess(LoginBean loginBean) {

            }

            @Override
            public void onLoginFailure(Throwable failure) {

            }

            @Override
            public void onRegisterSuccess(RegisterBean registerBean) {
                if (isViewAttached()) {
                    if (registerBean != null && Constant.SUCCESS_CODE.equals(registerBean.getStatus())) {
                        getView().onRegisterSuccess(registerBean);
                    }else {
                        getView().onRegisterFailure(new Exception("服务器异常"));
                    }
                }
            }

            @Override
            public void onRegisterFailure(Throwable failure) {
                if (isViewAttached()) {
                    getView().onRegisterFailure(failure);
                }
            }
        });
    }
}
