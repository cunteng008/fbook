package com.ajing.bookf.base;

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

public class GlobalInfo {
    private static GlobalInfo mInstance = new GlobalInfo();

    private Context mContext;

    private GlobalInfo(){
        //私有构造
    }

    public static GlobalInfo getInstance(){
       return mInstance;
    }

    public void init(Context context){
        mContext = context;
    }

    public Context getContext() {
        return mContext;
    }

    //===================http参数=======================
    public String getDomain(){
        return "http://192.168.191.1:8080";
    }

    //========================屏幕有关参数==============================
    public int getScreenWidth(){
        return mContext.getResources().getDisplayMetrics().widthPixels;
    }
    public int getScreenHeight(){
        return mContext.getResources().getDisplayMetrics().heightPixels;
    }



}
