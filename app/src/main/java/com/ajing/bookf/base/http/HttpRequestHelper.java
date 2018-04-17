package com.ajing.bookf.base.http;

import android.content.Context;

import com.ajing.bookf.base.GlobalInfo;
import com.ajing.bookf.widget.load.ILoadDialog;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

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

public class HttpRequestHelper {
    private static RequestQueue mRequestQueue =
            Volley.newRequestQueue(GlobalInfo.getInstance().getContext());   ;

    public static void request(JsonObjectRequest request){
        mRequestQueue.add(request);
    }
    public static void request(Builder builder){

    }


    public class Builder{
        private String url;
        private int method;
        private Context context;

        private JSONObject jsonParam;

        public Builder(Context context,String url){
            this.url = url;
            this.context = context;
            method = Request.Method.POST;
        }

        public Builder method(int method){
            this.method = method;
            return this;
        }

        public Builder data(JSONObject jsonParam){
            this.jsonParam = jsonParam;
            return this;
        }

        private ILoadDialog loadDialog;
        public Builder dialog(ILoadDialog loadDialog){
            this.loadDialog = loadDialog;
            return this;
        }

        private Response.Listener<JSONObject> responseListner;
        public Builder response(Response.Listener<JSONObject> listener){
            responseListner = listener;
            return this;
        }
        private Response.ErrorListener errorListener;
        public Builder error(Response.ErrorListener listener){
            errorListener = listener;
            return this;
        }


        public String getUrl() {
            return url;
        }

        public int getMethod() {
            return method;
        }

        public Context getContext() {
            return context;
        }

        public JSONObject getJsonParam() {
            return jsonParam;
        }

        public Response.Listener<JSONObject> getResponseListner() {
            return responseListner;
        }

        public Response.ErrorListener getErrorListener() {
            return errorListener;
        }

        public ILoadDialog getLoadDialog() {
            return loadDialog;
        }


    }
}
