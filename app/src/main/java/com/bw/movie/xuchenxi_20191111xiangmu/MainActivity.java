package com.bw.movie.xuchenxi_20191111xiangmu;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.library.base.BaseActivity;
import com.bw.movie.xuchenxi_20191111xiangmu.bean.LoginBean;
import com.bw.movie.xuchenxi_20191111xiangmu.bean.RegisterBean;
import com.bw.movie.xuchenxi_20191111xiangmu.contract.UserContract;
import com.bw.movie.xuchenxi_20191111xiangmu.md5.EncryptUtil;
import com.bw.movie.xuchenxi_20191111xiangmu.presenter.UserPresenter;
import com.bw.movie.xuchenxi_20191111xiangmu.view.ZActivity;
import com.bw.movie.xuchenxi_20191111xiangmu.view.ZhuCeActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public  class MainActivity extends BaseActivity<UserPresenter> implements UserContract.iView {
    private static final String TAG = "MainActivity";
    @BindView(R.id.name)
    EditText name;
    @BindView(R.id.pass)
    EditText pass;
    @BindView(R.id.zhuce)
    TextView zhuce;
    @BindView(R.id.deng)
    Button deng;
    @BindView(R.id.wei)
    Button wei;
    private String mima;
    private String name11;

    @Override
    protected UserPresenter providePresenter() {
        return new UserPresenter();
    }

    @Override
    protected int provideLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    public void onLoginSuccess(LoginBean loginBean) {
        Log.d(TAG, "登陆成功: " + loginBean.toString());
        if (loginBean.getMessage().contains("登陆成功")) {
            Toast.makeText(this, "登陆成功", Toast.LENGTH_SHORT).show();
            LoginBean.ResultBean result = loginBean.getResult();
            String userId = result.getUserId();
            String sessionId = result.getSessionId();
            Intent intent = new Intent();
            intent.setClass(MainActivity.this, ZActivity.class);
            intent.putExtra("userId",userId);
            intent.putExtra("sessionId",sessionId);
            startActivity(intent);
        }
    }

    @Override
    public void onLoginFailure(Throwable e) {

    }

    @Override
    public void onRegisterSuccess(RegisterBean registerBean) {

    }

    @Override
    public void onRegisterFailure(Throwable e) {

    }

    @OnClick({R.id.zhuce, R.id.deng, R.id.wei})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.zhuce:
                startActivity(new Intent(MainActivity.this, ZhuCeActivity.class));
                break;
            case R.id.deng:
                name11 = name.getText().toString();
                mima = pass.getText().toString();
                if (!name11.isEmpty() && !mima.isEmpty()) {
                    String encrypt = EncryptUtil.encrypt(mima);
                    mpresenter.getLoginPresenter(name11,encrypt);
                }
                break;
            case R.id.wei:
                break;
        }
    }
}
