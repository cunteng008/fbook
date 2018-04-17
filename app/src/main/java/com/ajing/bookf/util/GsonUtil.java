package com.ajing.bookf.util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class GsonUtil {
    private static Gson mGson = new Gson();
    private GsonUtil(){}

    public static <T> List<T> json2List(String jsonListStr, Class<T> clz){
        Type type = new TypeToken<ArrayList<T>>(){}.getType();
        List<T> list = mGson.fromJson(jsonListStr,type);
        return list;
    }

}
