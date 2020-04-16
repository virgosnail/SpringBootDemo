package com.skd.mybatis.util;

import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.Date;


/**
 * @Describe:
 * @Author: chenfan
 * @Date: 2019/4/28 16:42
 */
@Slf4j
public class DateFormatUtils {

    public static final String FORMAT_FULL_TIME_NO_ZONE = "yyyy-MM-dd HH:mm:ss";

    public static final DateTimeFormatter FORMATTER = DateTimeFormat.forPattern(FORMAT_FULL_TIME_NO_ZONE);

    public static Date parse(String date) {
        return DateTime.parse(date, FORMATTER).toDate();

    }

    public static String toFormatString(Date date) {

        return new DateTime(date).toString(FORMAT_FULL_TIME_NO_ZONE);
    }

    public static Date toFormatDate(Date date) {
        String string = new DateTime(date).toString(FORMAT_FULL_TIME_NO_ZONE);
        return  DateTime.parse(string, FORMATTER).toDate();
    }
    public static String toFormatString(Date date, String pattern) {
        return new DateTime(date).toString(pattern);
    }
}
