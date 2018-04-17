package com.ajing.bookf.ui.book;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.ajing.bookf.R;
import com.ajing.bookf.base.ui.BaseActivity;

public class ReadActivity extends BaseActivity{
    private TextView mTv;

    public static void gotoReadActivity(){

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);

        mTv = (TextView) findViewById(R.id.tv);

    }
}
