package com.ajing.bookf.entity;

public class MineFunction {
    private Class mActivityClass;
    private String mName;

    public MineFunction(Class activityClass,String name){
        mActivityClass = activityClass;
        mName = name;
    }

    public Class getmActivityClass() {
        return mActivityClass;
    }

    public String getmName() {
        return mName;
    }
}
