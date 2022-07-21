package cn.com.yusys.climp.utils;

public class NullUtil {

    public static boolean isNullString(Object str) {
        if (str instanceof String && "".equals(str)){
            return true;
        }
        return false;
    }

    public static boolean isNull(Object obj) {
        if (obj == null){
            return true;
        }
        return false;
    }
    public static String NullToString(Object obj) {
        if (obj == null){
            return "";
        }
        return obj.toString();
    }
}
