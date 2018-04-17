package com.ajing.bookf.base;

import android.app.Application;
import android.content.Context;

/**
 * <pre>
 *     author : Chen Mingjing
 *     e-mail : 2595400537@qq.com
 *     time   : 2018-04-03
 *     desc   : xxxx 描述
 *     version: 1.0
 * </pre>
 */

public class BookFApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        GlobalInfo.getInstance().init(getApplicationContext());
    }

    @Override
    public void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        //you must install multiDex whatever tinker is installed!
    }
}
