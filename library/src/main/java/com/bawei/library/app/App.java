package com.bawei.library.app;
/*
 *@auther:张安恒
 *@Date: 2019/11/5
 *@Time:18:47
 *@Description:${DESCRIPTION}
 **/

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

public class App extends Application {
    private static  App sContext;
    @Override
    public void onCreate() {
        super.onCreate();
        sContext=this;
        Fresco.initialize(this);
    }
    public  static  App getAppContext(){
        return sContext;
    }
}
