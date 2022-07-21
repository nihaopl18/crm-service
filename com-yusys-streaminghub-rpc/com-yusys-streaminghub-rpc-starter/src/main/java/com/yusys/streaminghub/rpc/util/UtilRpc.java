package com.yusys.streaminghub.rpc.util;

import java.text.SimpleDateFormat;

public class UtilRpc {
    public static final String ENCODING = "GBK";

    public static final int HDRDESCLEN = 10;
    public static String HEAD_FLAG = "F009";
    //日期格式化 17位
    public static final SimpleDateFormat TIMESTAMPF = new SimpleDateFormat("yyyyMMddHHmmssSSS");
    //日期格式化 14位
    public static final SimpleDateFormat TIMESTAMPF14 = new SimpleDateFormat("yyyyMMddHHmmss");
    //日期格式化 8位
    public static final SimpleDateFormat TIMESTAMPF8 = new SimpleDateFormat("yyyyMMdd");
    public static final byte[] BB_BYTES = {0x01};
    public static final String S_SEPARATION = new String(BB_BYTES);


    /**
     * 判断输入的数字是否等于零或者为空值
     */
    public static boolean intIsNotEmpty(int var){
        if ("".equals(var) || var == 0){
            return false;
        }else {
            return true;
        }
    }

}
