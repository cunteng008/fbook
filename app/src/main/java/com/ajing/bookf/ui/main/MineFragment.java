package com.ajing.bookf.ui.main;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ajing.bookf.R;
import com.ajing.bookf.adapter.MineFunctionAdpater;
import com.ajing.bookf.entity.MineFunction;
import com.ajing.bookf.ui.fragment.mine.AboutActivity;
import com.ajing.bookf.ui.fragment.mine.FeedbackActivity;
import com.ajing.bookf.ui.fragment.mine.SettingActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MineFragment extends Fragment {
    private View mRootView;

    private RecyclerView mRvFunction;
    private MineFunctionAdpater mFunctionAdapter;

    public static MineFragment newInstance() {
        MineFragment fragment = new MineFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.fragment_mine, container, false);
        initView();
        return mRootView;
    }

    private void initView(){
        mRvFunction = (RecyclerView) mRootView.findViewById(R.id.rv_function);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRvFunction.setLayoutManager(linearLayoutManager);
        List<MineFunction> functions = new ArrayList<>();
        functions.add(new MineFunction(AboutActivity.class,"关于"));
        functions.add(new MineFunction(FeedbackActivity.class,"反馈"));
        functions.add(new MineFunction(SettingActivity.class,"设置"));
        mFunctionAdapter = new MineFunctionAdpater(getContext(),functions);
        mRvFunction.setAdapter(mFunctionAdapter);
    }
}
