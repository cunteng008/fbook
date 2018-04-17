package com.ajing.bookf.widget.helper.vary;

import android.graphics.drawable.AnimationDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ajing.bookf.R;

public class VaryViewHelperController {
    private IVaryViewHelper mHelper;

    private AnimationDrawable mDrawableAnim;

    private ImageView mImageView;

    public VaryViewHelperController(IVaryViewHelper helper){
        super();
        mHelper = helper;
    }
    public VaryViewHelperController(View view){
        this(new ReplaceVaryViewHelper(view));
    }

    public void showNetWorkError(View.OnClickListener onClickListener){
        View networkErrorView = mHelper.inflate(R.layout.view_vary_network_error);
        TextView btnRetry = networkErrorView.findViewById(R.id.btn_vary_network_error_retry);
        if(onClickListener != null ){
            btnRetry.setOnClickListener(onClickListener);
        }
        mHelper.showLayout(networkErrorView);
    }

    public void showEmpty(String emptyMessage){
        View emptyView = mHelper.inflate(R.layout.view_vary_empty);
        TextView tvEmpty = emptyView.findViewById(R.id.tv_vary_empty);
        if( !TextUtils.isEmpty(emptyMessage) ){
            tvEmpty.setText(emptyMessage);
        }
        mHelper.showLayout(emptyView);
    }

    public void restore(){
        mHelper.restoreView();
    }
}
