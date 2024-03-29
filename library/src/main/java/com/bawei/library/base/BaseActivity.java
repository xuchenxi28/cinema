package com.bawei.library.base;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

import com.bawei.library.utils.NetUtil;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity <P extends  BasePresenter> extends AppCompatActivity implements  BaseView {

    private Unbinder unbinder;
    protected P mpresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(provideLayoutId());
        unbinder = ButterKnife.bind(this);
        mpresenter = providePresenter();
        if (mpresenter!=null){
            mpresenter.attachView(this);
        }
        initView();
        initData();
    }

    @Override
    public Context context() {
        return this;
    }

    protected  abstract  P providePresenter();
    protected  abstract  int provideLayoutId();
    protected abstract void  initView();
    protected  abstract void  initData();


    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mpresenter!=null){
            mpresenter.detachView();
        }
    }
    //判断是否有网
    public boolean hasNetwork(){
        return NetUtil.hasNetwork(this);
    }
    //无网提醒
    public  void  showNoNetTip(){
        Toast.makeText(this, "无网，请检查网络", Toast.LENGTH_SHORT).show();
    }

}
