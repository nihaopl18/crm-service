package cn.com.yusys.yusp.dycrm.realtimerpc.util;

public class rpcUtil {
    /**
     * 避免出现"null"
     * @param obj
     * @return
     */
    public static String notNull(Object obj) {
        if (obj == null)
            return "";
        return obj.toString();

    }
    /**
     * 避免出现"null"
     * @param var
     * @return
     */
    public static boolean intNotNull(int var) {
        boolean result = true;
        if ("".equals(var + "")){
            result = false;
        }
        return result;
    }
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
