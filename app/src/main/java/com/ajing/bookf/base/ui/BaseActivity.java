package com.ajing.bookf.base.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.ajing.bookf.R;
import com.ajing.bookf.base.ActivityManager;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.getInstance().addActivity(this);
    }
}
