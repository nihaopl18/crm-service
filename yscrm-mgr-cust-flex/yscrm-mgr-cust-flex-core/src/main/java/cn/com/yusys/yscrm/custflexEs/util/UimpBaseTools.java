package cn.com.yusys.yscrm.custflexEs.util;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UimpBaseTools {
	
	private static Pattern linePattern = Pattern.compile("_(\\w)");

	/**
	 * 下划线转驼峰
	 */
	public static String lineToHump(String str) {
		str = str.toLowerCase();
		Matcher matcher = linePattern.matcher(str);
		StringBuffer sb = new StringBuffer();
		while (matcher.find()) {
			matcher.appendReplacement(sb, matcher.group(1).toUpperCase());
		}
		matcher.appendTail(sb);
		return sb.toString();
	}

	/**
	 * 驼峰转下划线(简单写法，效率低于{@link #humpToLine2(String)})
	 */
	public static String humpToLine(String str) {
		return str.replaceAll("[A-Z]", "_$0").toLowerCase();
	}

	private static Pattern humpPattern = Pattern.compile("[A-Z]");

	/**
	 * 驼峰转下划线,效率比上面高
	 */
	public static String humpToLine2(String str) {
		Matcher matcher = humpPattern.matcher(str);
		StringBuffer sb = new StringBuffer();
		while (matcher.find()) {
			matcher.appendReplacement(sb, "_" + matcher.group(0).toLowerCase());
		}
		matcher.appendTail(sb);
		return sb.toString();
	}

	  /**
     * @Description: es中转驼峰字段，查询返回前端使用,适用于列表查询
     * @Author: xiaoyp
     * @Date: 2020/8/19 10:54
     * @param list:
     * @return: java.util.List<java.util.Map<java.lang.String,java.lang.Object>>
     **/
    public static List<Map<String, Object>> transList (List<Map<String, Object>> list) {
        List<Map<String, Object>> backList = new ArrayList<>();
        int size = list.size();
        for (int a = 0; a < size; a++) {
            Map<String, Object> map = list.get(a);
            Map<String, Object> tmp = new HashMap<>();
            Set<String> set = map.keySet();
            for (String key: set) {
                tmp.put(lineToHump(key), map.get(key));
            }
            backList.add(tmp);
        }
        return backList.size() == 0 ? list : backList;
    }

    /**
     * @Description: es中转驼峰字段，查询返回前端使用,适用于单条查询
     * @Author: xiaoyp
     * @Date: 2020/8/19 10:54
     * @param map:
     * @return: java.util.List<java.util.Map<java.lang.String,java.lang.Object>>
     **/
    public static Map<String, Object> transMap (Map<String, Object> map) {
            Map<String, Object> tmp = new HashMap<>();
            Set<String> set = map.keySet();
            for (String key: set) {
                tmp.put(lineToHump(key), map.get(key));
            }
        return tmp == null ? map : tmp;
    }
}