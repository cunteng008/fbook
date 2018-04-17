package com.ajing.bookf.base;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

public class ActivityManager {
    private static ActivityManager mActivityManager = new ActivityManager();
    private List<Activity> mActivities = new ArrayList<>();

    private ActivityManager(){

    }

    public static ActivityManager getInstance() {
        return mActivityManager;
    }

    public void addActivity(Activity activity){
        if( !mActivities.contains(activity) ){
            mActivities.add(activity);
        }
    }

    public void closeApp(){
        for(Activity activity : mActivities){
            activity.finish();
        }
    }


}
