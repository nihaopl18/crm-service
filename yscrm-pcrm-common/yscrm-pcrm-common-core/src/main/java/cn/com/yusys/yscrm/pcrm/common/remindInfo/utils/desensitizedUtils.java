package cn.com.yusys.yscrm.pcrm.common.remindInfo.utils;


import org.apache.commons.lang.StringUtils;

public class desensitizedUtils {
    public static String desensitizedName(Object fullName){
            String name = StringUtils.left(String.valueOf(fullName), 1);
            return StringUtils.rightPad(name, StringUtils.length((String) fullName), "*");
    }
}
