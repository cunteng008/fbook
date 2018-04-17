package com.ajing.bookf.ui.main_fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.ajing.bookf.R;
import com.ajing.bookf.adapter.BookAdapter;
import com.ajing.bookf.base.GlobalInfo;
import com.ajing.bookf.base.http.HttpRequestHelper;
import com.ajing.bookf.entity.Book;
import com.ajing.bookf.ui.book.SearchActivity;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.gson.Gson;

import org.json.JSONObject;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainMainFragment extends Fragment {

    private View mRootView;

    private Button mBtnGotoSearch;

    private RecyclerView mRvBook;
    private BookAdapter mBookAdapter;

    public static MainMainFragment newInstance() {
        MainMainFragment mainMainFragment = new MainMainFragment();
        return mainMainFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.fragment_main_main, container, false);
        initView();
        loadData();
        return mRootView;
    }

    private void initView(){
        mBtnGotoSearch = (Button) mRootView.findViewById(R.id.btn_goto_search);
        mBtnGotoSearch.setOnClickListener((v)->{
            Intent intent = new Intent(getContext(),SearchActivity.class);
            getContext().startActivity(intent);
        });

        mRvBook = (RecyclerView) mRootView.findViewById(R.id.rv_book_you_like);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRvBook.setLayoutManager(linearLayoutManager);
        mBookAdapter = new BookAdapter(getContext());
        mRvBook.setAdapter(mBookAdapter);
    }

    private void loadData(){
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET
                        ,GlobalInfo.getInstance().getDomain()+"/passport/get"
                        , null
                        , new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                Gson gson = new Gson();
                                Book book = gson.fromJson(response.toString(),Book.class);
                                mBookAdapter.addBook(book);
                            }
                        }
                        , null);
        HttpRequestHelper.request(jsonObjectRequest);
    }


}
