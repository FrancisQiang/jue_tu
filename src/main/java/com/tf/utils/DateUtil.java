package com.tf.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author lgq
 * @date 2020/1/24
 */
public class DateUtil {

    public static String currentDate() {
        Date startDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(startDate);
    }

}
