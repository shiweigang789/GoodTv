package com.duoduolicai360.goodtv.utils;

import java.text.DecimalFormat;

/**
 * Created by swg on 2017/9/14.
 */

public class DecimalFormatUtil {

    private static final DecimalFormat format = new DecimalFormat();

    public static String formatW(int value){
        if (value >= 10000){
            float l = value/10000.0f;
            return format(l, "#.#'W'");
        }
        return String.valueOf(value);
    }

    private static String format(float value, String pattern) {
        format.applyPattern(pattern);
        return format.format(value);
    }

}
