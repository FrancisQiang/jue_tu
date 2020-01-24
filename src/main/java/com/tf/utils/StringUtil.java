package com.tf.utils;

/**
 * @author lgq
 * @date 2020/1/24
 */
public class StringUtil {

    public static final String EMPTY_STRING = "";

    public static boolean isNullOrEmpty(String s) {
        return s == null || "".equals(s);
    }

}
