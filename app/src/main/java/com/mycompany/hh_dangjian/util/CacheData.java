package com.mycompany.hh_dangjian.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * 项目名： HH_Dangjian
 * 包名：com.mycompany.hh_dangjian.util
 * 文件名:CacheData
 * 创建者：zhuli
 * 创建时间: 2018/1/24  18:22
 * 描述:  TODO
 */
public class CacheData {

    public static final String CACHE_DATA_BY_SHAREPREFERENCE = "cache_data_by_sharepreference";

    public static void putString(Context context, String key, String value) {
        SharedPreferences sp=context.getSharedPreferences(CACHE_DATA_BY_SHAREPREFERENCE,Context.MODE_PRIVATE);
        sp.edit().putString(key,value);
    }

    public static String getString(Context context, String key) {
        SharedPreferences sp=context.getSharedPreferences(CACHE_DATA_BY_SHAREPREFERENCE,Context.MODE_PRIVATE);
        return sp.getString(key,"");
    }
}
