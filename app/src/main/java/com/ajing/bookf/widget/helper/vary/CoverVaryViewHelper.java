package com.ajing.bookf.widget.helper.vary;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.view.ViewGroup.LayoutParams;

/**
 * 用于切换布局,用一个新的布局覆盖在原布局之上
 */
public class CoverVaryViewHelper implements IVaryViewHelper {
    private IVaryViewHelper mHelper;
    private View mView;  //保存客户端的内容View


    public CoverVaryViewHelper(View view){
        super();
        mView = view;
        ViewGroup group = (ViewGroup) view.getParent();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        FrameLayout frameLayout = new FrameLayout(view.getContext());
        group.removeView(view);
        group.addView(frameLayout,layoutParams);

        LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        View floatView = new View(view.getContext());
        frameLayout.addView(view, params);
        frameLayout.addView(floatView, params);
        mHelper = new ReplaceVaryViewHelper(floatView);
    }

    @Override
    public View getCurrentLayout() {
        return mHelper.getCurrentLayout();
    }

    @Override
    public void restoreView() {
        mHelper.restoreView();
    }

    @Override
    public void showLayout(View view) {
        mHelper.showLayout(view);
    }

    @Override
    public void showLayout(int layoutId) {
        showLayout(inflate(layoutId));
    }

    @Override
    public View inflate(int layoutId) {
        return mHelper.inflate(layoutId);
    }

    @Override
    public Context getContext() {
        return mHelper.getContext();
    }

    @Override
    public View getView() {
        return mView;
    }
}
