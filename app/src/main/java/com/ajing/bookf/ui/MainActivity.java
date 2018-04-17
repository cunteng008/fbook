package com.ajing.bookf.ui;

import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.ajing.bookf.R;
import com.ajing.bookf.adapter.MyFragmentPagerAdapter;
import com.ajing.bookf.base.ui.BaseActivity;
import com.ajing.bookf.ui.main.FriendsFragment;
import com.ajing.bookf.ui.main.MainFragment;
import com.ajing.bookf.ui.main.MineFragment;
import com.ajing.bookf.ui.main.NotificationFragment;
import com.ajing.bookf.widget.helper.BottomNavigationViewHelper;

public class MainActivity extends BaseActivity {


    private Toolbar mToolbar;

    private ViewPager mViewPager;
    private MyFragmentPagerAdapter mFragmentPagerAdapter;

    private BottomNavigationView mBottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView(){
        mToolbar = (Toolbar) findViewById(R.id.main_toolbar);
        setSupportActionBar(mToolbar);

        mViewPager = (ViewPager) findViewById(R.id.main_viewpager);
        mFragmentPagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager());
        mFragmentPagerAdapter.addFragment(MainFragment.newInstance());
        mFragmentPagerAdapter.addFragment(NotificationFragment.newInstance());
        mFragmentPagerAdapter.addFragment(FriendsFragment.newInstance());
        mFragmentPagerAdapter.addFragment(MineFragment.newInstance());
        mViewPager.setAdapter(mFragmentPagerAdapter);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}
            @Override
            public void onPageSelected(int position) {
                mBottomNavigationView.getMenu().getItem(position).setChecked(true);
            }
            @Override
            public void onPageScrollStateChanged(int state) {}
        });


        mBottomNavigationView = (BottomNavigationView) findViewById(R.id.main_bottom_nav_view);
        BottomNavigationViewHelper.disableShiftMode(mBottomNavigationView);
        mBottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.main:
                        mViewPager.setCurrentItem(0);
                        break;
                    case R.id.main_notifications:
                        mViewPager.setCurrentItem(1);
                        break;
                    case R.id.main_friends:
                        mViewPager.setCurrentItem(2);
                        break;
                    case R.id.main_mine:
                        mViewPager.setCurrentItem(3);
                        break;
                }
                return true;
            }
        });
        //获取整个的NavigationView
        BottomNavigationMenuView menuView = (BottomNavigationMenuView) mBottomNavigationView.getChildAt(0);
        //这里就是获取所添加的每一个Tab(或者叫menu)，
        View tab = menuView.getChildAt(1);
        BottomNavigationItemView itemView = (BottomNavigationItemView) tab;
        //加载我们的角标View，新创建的一个布局
        View badge = LayoutInflater.from(this).inflate(R.layout.ic_badge, menuView, false);
        //添加到Tab上
        itemView.addView(badge);
        TextView textView = badge.findViewById(R.id.tv_badge);
        //无消息时可以将它隐藏即可
        textView.setVisibility(View.VISIBLE);

    }
}
