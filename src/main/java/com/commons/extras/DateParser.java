package com.commons.extras;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateParser {
    public static String millsToDate(long mills) {
        String pattern;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        Date resultDate = new Date(mills);
        return sdf.format(resultDate);
    }
}
