package com.ajing.bookf.base.http;

import com.android.volley.AuthFailureError;
import com.android.volley.toolbox.JsonObjectRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 *     author : Chen Mingjing
 *     e-mail : 2595400537@qq.com
 *     time   : 2018-04-04
 *     desc   : xxxx 描述
 *     version: 1.0
 * </pre>
 */

public class HeaderJsonObjectRequest extends JsonObjectRequest {

    public HeaderJsonObjectRequest(HttpRequestHelper.Builder builder){
        super(builder.getUrl(),builder.getJsonParam(),builder.getResponseListner(),builder.getErrorListener());
    }


    public void setHeader(){

    }

    @Override
    public Map<String, String> getHeaders() throws AuthFailureError {
        HashMap<String, String> headers = new HashMap<String, String>();
        headers.put("Cookie", "xxxxxxxxxxxx");
        return headers;
    }


}
