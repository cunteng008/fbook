package com.ajing.bookf.ui.fragment.mine;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ajing.bookf.R;
import com.ajing.bookf.base.GlobalInfo;
import com.ajing.bookf.base.ui.BaseActivity;
import com.ajing.bookf.widget.ProgressWebView;

public class AboutActivity extends BaseActivity {
    private ProgressWebView mProgressWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abount);
        initView();
    }

    private void initView(){
        mProgressWebView = (ProgressWebView) findViewById(R.id.wv_progress);
        mProgressWebView.loadUrl(GlobalInfo.getInstance().getDomain()+"/about.html");
    }
}
