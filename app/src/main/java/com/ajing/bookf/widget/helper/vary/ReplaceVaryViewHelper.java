package com.ajing.bookf.widget.helper.vary;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ajing.bookf.R;

/**
 * 用于切换布局,用一个新的布局替换掉原先的布局
 */
public class ReplaceVaryViewHelper implements IVaryViewHelper {
    private View mView; //保存客户端的内容View
    private ViewGroup mParentView;
    private int mViewIndex;
    private ViewGroup.LayoutParams mLayoutParams;
    private View mCurrentView;

    public ReplaceVaryViewHelper(View view){
        super();
        mView = view;
    }

    private void init(){
        mLayoutParams = mView.getLayoutParams();
        if(mView.getParent() != null){
            mParentView = (ViewGroup) mView.getParent();
        } else {
            mParentView = (ViewGroup) mView.getRootView().findViewById(android.R.id.content);
        }
        int count = mParentView.getChildCount();
        for(int i=0;i<count;i++){
            if(mView == mParentView.getChildAt(i)){
                mViewIndex = i;
                break;
            }
        }

        mCurrentView = mView;
    }

    @Override
    public View getCurrentLayout() {
        return mCurrentView;
    }

    @Override
    public void restoreView() {
        showLayout(mView);
    }

    @Override
    public void showLayout(View view) {
        if(mParentView == null){
            init();
        }
        mCurrentView = view;

        if(mParentView.getChildAt(mViewIndex) != view){
            ViewGroup parent = (ViewGroup) view.getParent();
            if(parent != null){
                parent.removeView(view);
            }
            mParentView.removeViewAt(mViewIndex);
            mParentView.addView(view,mViewIndex,mLayoutParams);
        }
    }

    @Override
    public void showLayout(int layoutId) {
        showLayout(inflate(layoutId));
    }

    @Override
    public View inflate(int layoutId) {
        return LayoutInflater.from(mView.getContext()).inflate(layoutId, null);
    }

    @Override
    public Context getContext() {
        return mView.getContext();
    }

    @Override
    public View getView() {
        return mView;
    }
}
