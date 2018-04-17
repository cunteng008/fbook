package com.ajing.bookf.ui.main_fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ajing.bookf.R;

/**
 * 书房
 */
public class StudyFragment extends Fragment {


    public static StudyFragment newInstance() {
        StudyFragment studyFragment = new StudyFragment();
        return studyFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_study, container, false);
    }

}
