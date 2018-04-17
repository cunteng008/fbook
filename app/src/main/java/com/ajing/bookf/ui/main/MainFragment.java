package com.ajing.bookf.ui.main;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ajing.bookf.R;
import com.ajing.bookf.adapter.TitleFragmentPagerAdapter;
import com.ajing.bookf.ui.main_fragment.MainMainFragment;
import com.ajing.bookf.ui.main_fragment.StudyFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {

    private View mRootView;

    private TitleFragmentPagerAdapter mTitleFragmentPagerAdapter;
    private ViewPager mViewPager;
    private TabLayout mTabLayout;

    public static MainFragment newInstance() {
        MainFragment fragment = new MainFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mRootView = inflater.inflate(R.layout.fragment_main, container, false);
        initView();
        return mRootView;
    }

    private void initView(){
        mTitleFragmentPagerAdapter = new TitleFragmentPagerAdapter(getChildFragmentManager());
        mTitleFragmentPagerAdapter.addFragment(MainMainFragment.newInstance(),"首页");
        mTitleFragmentPagerAdapter.addFragment(StudyFragment.newInstance(),"书房");
        mViewPager = (ViewPager) mRootView.findViewById(R.id.main_fragment_viewPager);
        mViewPager.setAdapter(mTitleFragmentPagerAdapter);

        mTabLayout = (TabLayout) mRootView.findViewById(R.id.main_fragment_tabLayout);
        mTabLayout.setupWithViewPager(mViewPager);
    }

}
