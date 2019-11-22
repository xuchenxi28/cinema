package com.bw.movie.xuchenxi_20191111xiangmu.contract;

import com.bawei.library.base.BaseView;
import com.bw.movie.xuchenxi_20191111xiangmu.bean.LoginBean;
import com.bw.movie.xuchenxi_20191111xiangmu.bean.RegisterBean;

public interface UserContract {
    interface iView extends BaseView {
        void onLoginSuccess(LoginBean loginBean);
        void onLoginFailure(Throwable e);

        void onRegisterSuccess(RegisterBean registerBean);
        void onRegisterFailure(Throwable e);
    }
    interface iModel{
        void getLoginData(String email, String pwd, iUserCallBack iUserCallBack);
        void getRegisterData(String nickName, String pwd, String email, String code, iUserCallBack iUserCallBack);
        interface iUserCallBack{
            void onLoginSuccess(LoginBean loginBean);
            void onLoginFailure(Throwable failure);

            void onRegisterSuccess(RegisterBean registerBean);
            void onRegisterFailure(Throwable failure);
        }
    }
    interface iPresenter{
        void getLoginPresenter(String email, String pwd);
        void getRegisterPresenter(String nickName, String pwd, String email, String code);
    }
}
