package com.duoduolicai360.goodtv.utils;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.TypedValue;

/**
 * Created by swg on 2017/9/14.
 */

public class DensityUtil {

    private DensityUtil(){
        throw new AssertionError();
    }

    public static int dp2px(Context context, float dpVal){
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dpVal, getDisplayMetrics(context));
    }

    public static int sp2px(Context context, float spVal){
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, spVal, getDisplayMetrics(context));
    }

    public static int px2dp(Context context, float pxVal){
        return (int) (pxVal/getDisplayMetrics(context).density + 0.5f);
    }

    public static int px2sp(Context context, float pxVal){
        return (int) (pxVal/getDisplayMetrics(context).scaledDensity + 0.5f);
    }

    public static DisplayMetrics getDisplayMetrics(Context context){
        return context.getResources().getDisplayMetrics();
    }

}
