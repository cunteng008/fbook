package com.ajing.bookf.util;

import android.content.Context;
import android.widget.Toast;

/**
 * <pre>
 *     author : Chen Mingjing
 *     e-mail : 2595400537@qq.com
 *     time   : 2018-04-04
 *     desc   : xxxx 描述
 *     version: 1.0
 * </pre>
 */

public class ToastUtil {

    private ToastUtil(){}

    public static void  showToastShort(Context context,String message){
        Toast.makeText(context,message,Toast.LENGTH_SHORT).show();
    }

    public static void showToastLong(Context context,String message){
        Toast.makeText(context,message,Toast.LENGTH_LONG).show();
    }
}
