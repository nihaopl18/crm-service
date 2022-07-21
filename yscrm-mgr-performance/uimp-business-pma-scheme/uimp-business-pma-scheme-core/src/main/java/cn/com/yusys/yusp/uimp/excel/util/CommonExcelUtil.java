package cn.com.yusys.yusp.uimp.excel.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @项目名称: uimp-business-pma-scheme-core模块
 * @类名称: CommonExcelUtil
 * @类描述: # 考核方案Excel-工具类
 * @功能描述: 
 * @创建人: lixt1
 * @创建时间: 2020-05-07 14:40:02
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public class CommonExcelUtil {
	
	/**
     * @函数名称:verifyDateStrByFormat
     * @函数描述:校验日期字符串是否符合规定格式
     * @参数与返回说明:
     * @param verifyDateStr 带校验日期字符串
     * @param formatStr 规定格式字符串，如yyyy-MM-dd
     * @算法描述:
     */
	public static boolean verifyDateStrByFormat(String verifyDateStr, String formatStr) {
		boolean result = true;
		SimpleDateFormat format = new SimpleDateFormat(formatStr);
		try {
			// 设置lenient为false.
			// 否则SimpleDateFormat会比较宽松地验证日期，比如2007/02/29会被接受，并转换成2007/03/01
			format.setLenient(false);
			format.parse(verifyDateStr);
		} catch (ParseException e) {
			result = false;
		}
		return result;
	}
}
