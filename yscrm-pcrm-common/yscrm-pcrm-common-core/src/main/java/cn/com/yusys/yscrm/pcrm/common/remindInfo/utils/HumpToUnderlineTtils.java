package cn.com.yusys.yscrm.pcrm.common.remindInfo.utils;

import org.apache.commons.lang.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HumpToUnderlineTtils {
    /**
     * 驼峰转下划线
     * @param humpString
     * created JSH
     * @return
     */
    public static String humpToUnderline(String humpString) {
        if(StringUtils.isEmpty(humpString)) return "";
        StringBuilder result = new StringBuilder();
        if (humpString != null && humpString.length() > 0) {
            // 将第一个字符处理成大写
            result.append(humpString.substring(0, 1).toUpperCase());
            // 循环处理其余字符
            for (int i = 1; i < humpString.length(); i++) {
                String s = humpString.substring(i, i + 1);
                // 在大写字母前添加下划线
                if (s.equals(s.toUpperCase()) && !Character.isDigit(s.charAt(0))) {
                    result.append("_");
                }
                //在数字前添加下划线
                Pattern pattern = Pattern.compile("[0-9]*");
                Matcher isNum = pattern.matcher(s);
                if(isNum.matches() ){
                    result.append("_");
                }
                // 转成大写
                result.append(s.toUpperCase());
            }
        }
        return result.toString();
    }
}
