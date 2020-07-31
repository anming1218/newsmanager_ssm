package com.ming.ssm.utils;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *@program: product_ssm
 *@description: 时间处理的工具类
 *@author: ming
 *@create: 2020-07-29 16:29
 */
public class DateUtils {
    
    //日期转换成字符串
    public static String dateToString(Date date,String patt){
        SimpleDateFormat sdf = new SimpleDateFormat(patt);
        String format = sdf.format(date);
        return format;
    }

    public static Date StringToDate(String str,String patt) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(patt);
        Date date = sdf.parse(str);
        return date;
    }

}
