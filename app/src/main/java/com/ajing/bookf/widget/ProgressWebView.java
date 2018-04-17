package com.ajing.bookf.widget;

import android.content.Context;
import android.os.Environment;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.ajing.bookf.widget.load.ProgressView;

/**
 * Created by mingj_000 on 2018/4/6.
 */

public class ProgressWebView extends WebView {

    private ProgressView mProgressView;
    private Context mContext;

    /**
     * 网页缓存目录
     */
    private static final String cacheDirPath = Environment
            .getExternalStorageDirectory() + "/LoadingWebViewDome/webCache/";

    public ProgressWebView(Context context) {
        this(context,null);
    }

    public ProgressWebView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public ProgressWebView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        init();
    }

    private void init(){
        requestFocus();
        setInitialScale(39);
        getSettings().setJavaScriptCanOpenWindowsAutomatically(true);//支持通过Javascript打开新窗口
        getSettings().setJavaScriptEnabled(true);//设置WebView属性，能够执行Javascript脚本
        getSettings().setUseWideViewPort(true);//将图片调整到适合webview的大小
        getSettings().setLoadWithOverviewMode(true);// 缩放至屏幕的大小
        getSettings().setDomStorageEnabled(true);//设置是否启用了DOM Storage API
        getSettings().setDatabaseEnabled(true);//开启database storage API功能
        getSettings().setDatabasePath(cacheDirPath); //设置数据库缓存路径
        getSettings().setAppCachePath(cacheDirPath);//设置Application Caches缓存目录
        getSettings().setAppCacheEnabled(true);//开启Application Caches功能

        addProgressView();

    }

    private void addProgressView(){
        mProgressView = new ProgressView(mContext);
        mProgressView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT
                ,dp2px(mContext, 4)));
        //把进度条加到Webview中
        addView(mProgressView);
        setWebChromeClient(new MyWebChromeClient());
        setWebViewClient(new android.webkit.WebViewClient());
    }

    private class MyWebChromeClient extends android.webkit.WebChromeClient {
        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            if (newProgress == 100) {
                mProgressView.setVisibility(GONE);
            } else {
                if (mProgressView.getVisibility() == GONE)
                    mProgressView.setVisibility(VISIBLE);
                mProgressView.setProgress(newProgress);
            }
            super.onProgressChanged(view, newProgress);
        }
    }
//    private class MyWebViewClient extends android.webkit.WebViewClient{
//        //
//    }

    private int dp2px(Context context, float dp) {
        float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dp * scale + 0.5f);
    }

    /**
     * 回收webview
     */
    public void destroyWebView() {
        clearCache(true);
        clearHistory();
    }
}
