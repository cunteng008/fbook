package com.ajing.bookf.ui.main;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ajing.bookf.R;
import com.ajing.bookf.adapter.FriendAdapter;
import com.ajing.bookf.entity.Friend;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FriendsFragment extends Fragment {
    private View mRootView;

    private RecyclerView mRvFriend;
    private FriendAdapter mFriendAdapter;

    public static FriendsFragment newInstance() {
        FriendsFragment fragment = new FriendsFragment();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mRootView = inflater.inflate(R.layout.fragment_friends, container, false);
        initView();
        return mRootView;
    }

    private void initView(){
        mRvFriend = (RecyclerView) mRootView.findViewById(R.id.rv_friend);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRvFriend.setLayoutManager(linearLayoutManager);

        List<Friend> friends = new ArrayList<>();
        for(int i =0;i<5;i++){
            friends.add(new Friend());
        }
        mFriendAdapter = new FriendAdapter(getContext(),friends);
        mRvFriend.setAdapter(mFriendAdapter);
    }

}
