package com.bw.movie.xuchenxi_20191111xiangmu.view;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bawei.library.base.BaseActivity;
import com.bawei.library.base.BasePresenter;
import com.bw.movie.xuchenxi_20191111xiangmu.MainActivity;
import com.bw.movie.xuchenxi_20191111xiangmu.R;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class YinDaoActivity extends AppCompatActivity implements View.OnClickListener {
    Timer timer = new Timer();
    @BindView(R.id.tv)
    TextView tv;
    private int relan = 2;//倒计时
    private Handler handler;
    private Runnable runnable;

//    final SharedPreferences sharedPreferences = getSharedPreferences("config", Context.MODE_PRIVATE);
//
//    //发送一个颜色的消息
//      new Handler(){
//        public void handleMessage(android.os.Message msg) {
//            //接受到消息后的处理
//            boolean b = sharedPreferences.getBoolean("is_first",true);
//
//            if(b){
//                //第一次进入应用，进入导航界面
//                sharedPreferences.edit().putBoolean("is_first", false).commit();
//                Intent intent = new Intent(MainActivity.this,GuideActivity.class);
//                startActivity(intent);
//                Log.i(tag, "是第一次进入");
//            }else{
//                //不是第一次进入应用,直接跳转到主界面
//                Log.i(tag, "是第二次进入");
//                Intent intent = new Intent(MainActivity.this,HomeActivity.class);
//                startActivity(intent);
//            }
//
//            finish();
//        };
//    }.sendEmptyMessageDelayed(0, 3000);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yin_dao);

        int flag = WindowManager.LayoutParams.FLAG_FULLSCREEN;
        getWindow().setFlags(flag, flag);
        initView();
        timer.schedule(task, 1000, 1000);

        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(YinDaoActivity.this, MainActivity.class));
                finish();
            }
        }, 5000);
    }

    private void initView() {
        tv = findViewById(R.id.tv);//跳过
        tv.setOnClickListener(this);//跳过监听
    }

    TimerTask task =new TimerTask() {
        @Override
        public void run() {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    relan--;
                    tv.setText("跳过"+relan);
                    if (relan < 0) {
                        timer.cancel();
                        tv.setVisibility(View.GONE);
                    }
                }
            });
        }
    };

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv:
                startActivity(new Intent(YinDaoActivity.this, MainActivity.class));
                finish();
                if (runnable != null) {
                    handler.removeCallbacks(runnable);
                }
                break;
                default:
                    break;
        }
    }
}
