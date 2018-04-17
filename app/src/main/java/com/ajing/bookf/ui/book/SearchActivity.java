package com.ajing.bookf.ui.book;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.ajing.bookf.R;
import com.ajing.bookf.adapter.TagAdapter;
import com.ajing.bookf.base.ui.BaseActivity;

public class SearchActivity extends BaseActivity {

    private RecyclerView mRvTag;
    private TagAdapter mTagAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        initView();
    }

    private void initView(){
        mRvTag = (RecyclerView) findViewById(R.id.rv_main_tag);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
        mRvTag.setLayoutManager(layoutManager);
        mTagAdapter = new TagAdapter(this);
        mRvTag.setAdapter(mTagAdapter);
    }
}
