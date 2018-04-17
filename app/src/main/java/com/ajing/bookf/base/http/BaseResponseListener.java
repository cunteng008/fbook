package com.ajing.bookf.base.http;

import com.android.volley.Response;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * <pre>
 *     author : Chen Mingjing
 *     e-mail : 2595400537@qq.com
 *     time   : 2018-04-04
 *     desc   : xxxx 描述
 *     version: 1.0
 * </pre>
 */

public abstract class BaseResponseListener implements Response.Listener<JSONObject> {

    @Override
    public void onResponse(JSONObject response) {
        try {
            int code = response.getInt("apiCode");
            if(code==1200){
                //未登录处理
            }

        }catch (JSONException e){

        }
    }

    public abstract void onData();
}
