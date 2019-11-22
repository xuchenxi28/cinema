package com.bw.movie.xuchenxi_20191111xiangmu.view;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.bawei.library.base.BaseActivity;
import com.bw.movie.xuchenxi_20191111xiangmu.MainActivity;
import com.bw.movie.xuchenxi_20191111xiangmu.R;
import com.bw.movie.xuchenxi_20191111xiangmu.bean.LoginBean;
import com.bw.movie.xuchenxi_20191111xiangmu.bean.RegisterBean;
import com.bw.movie.xuchenxi_20191111xiangmu.contract.UserContract;
import com.bw.movie.xuchenxi_20191111xiangmu.md5.EncryptUtil;
import com.bw.movie.xuchenxi_20191111xiangmu.presenter.UserPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ZhuCeActivity extends BaseActivity<UserPresenter> implements UserContract.iView {
    private static final String TAG = "ZhuCeActivity";
    @BindView(R.id.register_name)
    EditText registerName;
    @BindView(R.id.register_email)
    EditText registerEmail;
    @BindView(R.id.register_pwd)
    EditText registerPwd;
    @BindView(R.id.register_verification)
    EditText registerVerification;
    @BindView(R.id.register_huoqu)
    Button registerHuoqu;
    @BindView(R.id.jump_login)
    TextView jumpLogin;
    @BindView(R.id.register)
    Button register;
    private String rename;
    private String reEmail;
    private String rePwd;
    private String reHuoqu;

    @Override
    protected UserPresenter providePresenter() {
        return new UserPresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_zhu_ce;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    public void onLoginSuccess(LoginBean loginBean) {

    }

    @Override
    public void onLoginFailure(Throwable e) {

    }

    @Override
    public void onRegisterSuccess(RegisterBean registerBean) {
        Log.d(TAG, "onRegisterSuccess: " + registerBean.toString());
        if (registerBean.getMessage().contains("注册成功")) {
            startActivity(new Intent(ZhuCeActivity.this, MainActivity.class));
        }
    }

    @Override
    public void onRegisterFailure(Throwable e) {

    }

    @OnClick({R.id.register_huoqu, R.id.jump_login, R.id.register})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.register_huoqu:
                break;
            case R.id.jump_login:
                startActivity(new Intent(ZhuCeActivity.this, MainActivity.class));
                break;
            case R.id.register:
                rename = registerName.getText().toString();
                reEmail = registerEmail.getText().toString();
                rePwd = registerPwd.getText().toString();
                reHuoqu = registerHuoqu.getText().toString();
                String encrypt = EncryptUtil.encrypt(rePwd);
                mpresenter.getRegisterPresenter(rename,encrypt,reEmail,reHuoqu);
                break;
        }
    }
}
