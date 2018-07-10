package com.lixin.takeoutfood.rider.util;

import android.util.Log;

import com.lixin.takeoutfood.rider.BuildConfig;


/**
 * 统一Log类
 */
public class LogUtil {

    private static boolean isDebug = !BuildConfig.DEBUG;

    public static final String TAG = "ftd";

    public static void d(String msg) {
        if (isDebug)
            return;
        d(TAG, msg);
    }

    public static void d(String tag, String msg) {
        if (isDebug)
            return;
        Log.d(tag, msg);
    }

    public static void v(String msg) {
        if (isDebug)
            return;
        Log.v(TAG, msg);
    }

    public static void e(String msg) {
        if (isDebug)
            return;
        e(TAG, msg);
    }

    public static void e(String tag, String msg) {
        if (isDebug)
            return;
        Log.e(tag, msg);
    }

    public static void i(String msg) {
        if (isDebug)
            return;
        Log.i(TAG, msg);
    }


}
