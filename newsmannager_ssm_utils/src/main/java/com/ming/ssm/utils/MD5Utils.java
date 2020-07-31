package com.ming.ssm.utils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/**
 *@program: hash
 *@description: MD5算法实现
 *@author: ming
 *@create: 2020-06-03 11:12
 */

public class MD5Utils {
    /**
     * 计算字符串的MD5值
     * @param string 明文
     * @return       字符串的MD5值
     */
    public static String md5(String string) {
        //判断字符串是否为空
        if (string.isEmpty()) {
            return "";
        }
        //为应用程序提供消息摘要算法
        MessageDigest md5 = null;
        try {
            //返回MD5算法的MessageDigest对象。
            md5 = MessageDigest.getInstance("MD5");
            //使用指定的字节数组对摘要执行最终更新，然后完成摘要计算
            byte[] bytes = md5.digest(string.getBytes("UTF-8"));
            String result = "";
            //将byte数组转成字符串形式
            for (byte b : bytes) {
                String temp = Integer.toHexString(b & 0xff);
                if (temp.length() == 1) {
                    temp = "0" + temp;
                }
                result += temp;
            }
            return result;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 计算文件的MD5值
     * @param file 文件File
     * @return     文件的MD5值
     */
    public static String md5(File file) {
        //判断文件是否存在以及是否为空
        if (file == null || !file.isFile() || !file.exists()) {
            return "";
        }
        FileInputStream in = null;
        String result = "";
        byte buffer[] = new byte[0124];
        int len;
        try {
            //返回MD5算法的MessageDigest对象。
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            //读取文档内容
            in = new FileInputStream(file);
            while ((len = in.read(buffer)) != -1) {
                md5.update(buffer, 0, len);
            }
            // //使用指定的字节数组对摘要执行最终更新，然后完成摘要计算
            byte[] bytes = md5.digest();

            //将byte数组转换成字符串
            for (byte b : bytes) {
                String temp = Integer.toHexString(b & 0xff);
                if (temp.length() == 1) {
                    temp = "0" + temp;
                }
                result += temp;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(null!=in){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }
}
