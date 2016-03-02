package com.xnyu.pt.Base;

import android.app.Application;
import android.content.Context;
import android.os.Handler;

import com.orhanobut.logger.Logger;


/**
 * Created by xnyu on 2015-10-15.
 */
public class BaseApplication extends Application {
    private static BaseApplication application;
    private static int mainTid;
    private static Handler handler;

    //  在主线程运行的
    @Override
    public void onCreate() {
        super.onCreate();
        application=this;
        mainTid = android.os.Process.myTid();
        handler=new Handler();
        Logger.init("find");
    }
    public static Context getApplication() {
        return application;
    }
    public static int getMainTid() {
        return mainTid;
    }
    public static Handler getHandler() {
        return handler;
    }
}
