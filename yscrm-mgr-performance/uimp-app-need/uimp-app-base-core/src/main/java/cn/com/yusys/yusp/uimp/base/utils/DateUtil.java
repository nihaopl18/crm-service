package cn.com.yusys.yusp.uimp.base.utils;

import org.apache.commons.lang.time.FastDateFormat;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @项目名称: uimp-app-base-core模块
 * @类名称: DateUtil
 * @类描述: # 日期 工具类
 * @功能描述: 
 * @创建人: lixt1
 * @创建时间: 2020-02-13 15:59:02
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public class DateUtil {
	/** 格式：年月日 */
	public static final String DEF_SHORT_T = "yyyyMMdd";
	/** 格式：年-月-日 */
	public static final String DEF_SHORT = "yyyy-MM-dd";
	/** 格式：年-月-日 小时:分钟:秒 */
	public static final String DEF_FULL_NO_MILS = "yyyy-MM-dd HH:mm:ss";
	/** 格式：年-月-日 小时:分钟:秒 毫秒 */
	public static final String DEF_FULL = "yyyy-MM-dd HH:mm:ss SSS";
	/** 格式：年-月-日 小时:分钟:秒 毫秒 */
	public static final String DEF_FULL_TIME_NO_SYMBOL = "yyyyMMddHHmmssSSS";
	/** 格式：年月日 */
	public static final String DEF_SHORT_NO_SYMBOL = "yyyyMMdd";
	/** 格式：小时:分钟:秒 */
	public static final String DEF_TIME = "HH:mm:ss";
	
	private static final Log log = LogFactory.getLog(DateUtil.class);
	
	private final static Object obj = new Object();	
	
	/**
	 * @return 返回 yyyy-MM-dd格式日期字符串
	 */
	public static String getShortDate(){
		return format(DEF_SHORT);
	}
	
	/**
	 * @return 返回 yyyy-MM-dd HH:mm:ss格式日期字符串
	 */
	public static String getFullDateNoMils(){
		return format(DEF_FULL_NO_MILS);
	}
	
	/**
	 * @return 返回 yyyy-MM-dd HH:mm:ss格式日期字符串
	 */
	public static String getFullDateNoMils(Date date){
		return format(DEF_FULL_NO_MILS, date);
	}
	
	public static String getShortDate(Date date,String pattern){
		return format(pattern,date);
	}
	
	/**
	 * @return 返回 yyyyMMdd格式日期字符串
	 */
	public static String getShortNoSymbol(){
		return format(DEF_SHORT_NO_SYMBOL);
	}
	
	/**
	 * @return 返回 yyyyMMddHHmmssSSS格式日期字符串
	 */
	public static String getFullTimeNoSymbol(){
		return format(DEF_FULL_TIME_NO_SYMBOL);
	}
	
	/**
	 * @return 返回 HH:mm:ss格式时间字符串
	 */
	public static String getTime(){
		return format(DEF_TIME);
	}
	
	/**
	 * @return 返回 指定格式模式的日期字符串
	 */
	public static String getDate(String pattern){
		return format(pattern);
	}
	
	/**
	 * @return 返回 yyyy-MM-dd HH:mm:ss SSS格式的日期字符串
	 */
	public static String getFullDate(){
		return format(DEF_FULL);
	}
	
	/**
	 * @return 返回 yyyy-MM-dd HH:mm:ss SSS格式的日期字符串
	 */
	public static String getFullDate(Date date){
		return format(DEF_FULL, date);
	}
	
	private static String format(String pattern){
		return format(pattern, new Date(System.currentTimeMillis()));
	}

	public static String format(String pattern, Date date){
		return FastDateFormat.getInstance(pattern).format(date);
	}
	
	
	/**
	 * @return 返回 yyyyMMdd格式日期
	 */
	public static Date getShortDateTime(String date){
		return parse(DEF_SHORT_T, date);
	}
	
	/**
	 * @return 返回 yyyy-MM-dd格式日期
	 */
	public static Date getShortDate(String date){
		return parse(DEF_SHORT, date);
	}
	
	/**
	 * @return 返回 yyyy-MM-dd HH:mm:ss格式的日期
	 */
	public static Date getFullDateNoMils(String date){
		return parse(DEF_FULL_NO_MILS, date);
	}
	
	/**
	 * @return 返回 yyyy-MM-dd HH:mm:ss SSS格式的日期
	 */
	public static Date getFullDate(String date){
		return parse(DEF_FULL, date);
	}
	/**
	 * 使用指定日期格式解析文本日期，转换成日期对象，添加指定天数
	 * @param pattern
	 * @param date
	 * @param dayOfMonth
	 * @return 添加指定天数后的日期对象
	 * @throws ParseException 指定日期格式解析文本日期出现异常
	 */
	public static Date addDayOfMonth(String pattern, String date, int dayOfMonth) throws ParseException{
		DateFormat fmt = new SimpleDateFormat(pattern);
		fmt.parse(date);
		Calendar calendar = fmt.getCalendar();
		calendar.add(Calendar.DAY_OF_MONTH, dayOfMonth);
		return calendar.getTime();
	}
	/**
	 * 使用指定日期格式解析文本日期，转换成日期对象，添加指定小时数
	 * @param pattern
	 * @param date
	 * @param hourOfDay
	 * @return 添加指定小时数后的日期对象
	 * @throws ParseException 指定日期格式解析文本日期出现异常
	 */
	public static Date addHourOfDay(String pattern, String date, int hourOfDay) throws ParseException{
		DateFormat fmt = new SimpleDateFormat(pattern);
		fmt.parse(date);
		Calendar calendar = fmt.getCalendar();
		calendar.add(Calendar.HOUR_OF_DAY, hourOfDay);
		return calendar.getTime();
	}
	/**
	 * 计算日期差值
	 * @param date1 被减数 日期
	 * @param date2 减数 日期
	 * @return 差(单位：天）可能含负数
	 */
	public static int diff(Date date1, Date date2){
		long diff = date1.getTime()-date2.getTime();
		return (int)diff/(24*60*60*1000);
	}
	/**
	 * 计算日期差值，返回分钟数
	 * @param endDtNoMils 被减数 日期，不带毫秒
	 * @param startDtNoMils 减数 日期，不带毫秒
	 * @return 差(单位：分钟） 小数点保留一位
	 */
	public static String diffMinute(String endDtNoMils, String startDtNoMils){
		if(endDtNoMils==null || startDtNoMils==null) return "0";
		Date d1 = getFullDateNoMils(endDtNoMils);
		Date d2 = getFullDateNoMils(startDtNoMils);
		long diff = d1.getTime()-d2.getTime();
		if(diff<=0) return "0";
		BigDecimal bd = new BigDecimal(diff/(1000*60));
		bd = bd.setScale(1, BigDecimal.ROUND_HALF_UP);
		return bd.toString();
	}
	
	/**
	 * 根据间隔天数，计算指定日期的间隔日期。如：可计算20101001的前一天为20100930
	 * @author 冯镇宇
	 * @param day：间隔天数
	 * @param appointDate：指定日期
	 * @return 计算结果
	 */
	public static String getIntervalDate(int day,String appointDate){
		Calendar ca = Calendar.getInstance();
		ca.setTime(parse(DEF_SHORT_T,appointDate));
		ca.add(Calendar.DAY_OF_MONTH, day);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String result = sdf.format(ca.getTime());
		return result;
	}
	
	/**
	 * 比较两个日期的大小
	 * @author 冯镇宇
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static String compareDate(String date1,String date2){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		try {
			Date d1 = sdf.parse(date1);
			Date d2 = sdf.parse(date2);
			if(d1.getTime() > d2.getTime()){
				return "1";
			}else if(d1.getTime() < d2.getTime()){
				return "-1";
			}else{
				return "0";
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return "0";
	}
	
	/**
     * 比较两个日期的大小
     * @author 陈华鑫
     * @param date1
     * @param date2
     * @param format 自定义格式
     * @return
     */
	public static String compareDate(String date1,String date2,String format){
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        try {
            Date d1 = sdf.parse(date1);
            Date d2 = sdf.parse(date2);
            if(d1.getTime() > d2.getTime()){
                return "1";
            }else if(d1.getTime() < d2.getTime()){
                return "-1";
            }else{
                return "0";
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "0";
    }
	
	private static Date parse(String pattern, String date){
		synchronized(obj){
			SimpleDateFormat df = new SimpleDateFormat(pattern);
			try {
				return df.parse(date);
			} catch (ParseException e) {
				log.error(e.getMessage(), e);
				return new Date(System.currentTimeMillis());
			}
		}
	}
	/**
	 * 把字串转换为日期
	 * 
	 * @param sDate
	 *            字串形式的日期
	 * @param format
	 *            字串格式
	 * @return 转换为日期类型
	 * 
	 * @throws ParseException
	 */
	public static Date str2Date(String sDate, String format) {
		try {
			return (new SimpleDateFormat(format)).parse(sDate);
		} catch (ParseException ex) {
			log.error("", ex);
			return null;
		}
	}
	/**
	 * 获得季度的开始或结束日期 （1- 开始日期  ,2- 结束日期）
	 * @param date
	 * @return
	 */
	public static String requireDateOfQuarter(String date,int type){
		String rtnStr = "";
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(str2Date(date, "yyyyMMdd"));
		int month = calendar.get(Calendar.MONTH);
		int year = calendar.get(Calendar.YEAR);
		if(month>=0&&month<=2){
			if(type==2){
				rtnStr = year+"0331";	
			}else{
				rtnStr = year+"0101";
			}
		}else if(month>=3&&month<=5){
			if(type==2){
				rtnStr = year+"0630";	
			}else{
				rtnStr = year+"0401";
			}
		}else if(month>=6&&month<=8){
			if(type==2){
				rtnStr = year+"0930";
			}else{
				rtnStr = year+"0701";
			}
		}else if(month>=9&&month<=11){
			if(type==2){
				rtnStr = year+"1231";
			}else{
				rtnStr = year+"1001";
			}
		}
		return rtnStr;
	}
	/**
	 * 获取当前月的前一个月的第一天的日期
	 */
	public static String getPeriousMonthFirst(){
		Calendar ca = Calendar.getInstance();
		ca.set(Calendar.DAY_OF_MONTH,1);//设置为1号,当前日期既为本月第一天 
		ca.add(Calendar.MONTH, -1);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String result = sdf.format(ca.getTime());
		return result;
	}
	

	/**
	 * @describtion: 返回当前时间，格式 pattern
	 * @return
	 */
	public static String getCurrentTime(String pattern){
		Date date = new Date();
		DateFormat df = new SimpleDateFormat(pattern);
		df.setLenient(false);
		return df.format(date);
	}
	
	/**
	 * @describtion: 得到当前时间	格式yyyyMMdd
	 * @return	yyyyMMdd字符串
	 */
	public static String getCurrentDate(){
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("yyyyMMdd");
        df.setLenient(false);
        return df.format(date);
	}
	
	/**
	 * @describtion: 得到当前时间	格式yyyy-MM-dd HH:mm:ss
	 * @return	yyyy-MM-dd HH:mm:ss字符串
	 */
	public static String getCurrentDateTimeF(){
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		df.setLenient(false);
		return df.format(date);
	}
	
	/**
	 * @describtion: 得到当前时间	格式yyyy-MM-dd
	 * @return	yyyy-MM-dd字符串
	 */
	public static String getCurrentDateF(){
		Date date = new Date();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		df.setLenient(false);
		return df.format(date);
	}
	
	/**
	 * @describtion: 将字符串转换为日期
	 * @param dateS 日期格式 yyyy-MM-dd
	 * @return
	 */
	public static Date parseDate(String dateS){
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		df.setLenient(false);
    	try {
			return df.parse(dateS);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
    }
	
	/**
	 * @describtion: 将字符串转换为日期
	 * @param dateS 日期
	 * @param format 格式
	 * @return
	 */
	public static Date parseDate(String dateS,String format){
		DateFormat df = new SimpleDateFormat(format);
		df.setLenient(false);
    	try {
			return df.parse(dateS);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
    }
	
	/**
	 * @describtion: 将格式'yyyy-MM-dd'转换为日期类型
	 * @param date  传入日期
	 * @return
	 */
	public static String formatDate(Date date){
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		df.setLenient(false);
		return df.format(date);
	}
	
	/**
	 * @describtion: 将字符串转换为日期类型
	 * @param date 传入日期
	 * @param format 格式参数
	 * @return
	 */
	public static String formatDate(Date date,String format){
		DateFormat df = new SimpleDateFormat(format);
		df.setLenient(false);
		return df.format(date);
	}
	/**
	 * @describtion: 获取日期的前一天
	 * @param date 传入日期
	 * @return
	 */
	public static String getPreviousDate(String dateStr){
		Date date = parseDate(dateStr,"yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
	    c.setTime(date);
	    c.add(Calendar.DATE, -1);
	    return formatDate(c.getTime());
	}
	/**
	 * @describtion: 获取日期的前一天
	 * @param date 传入日期
	 * @return
	 */
	public static String getPreviousDateShort(String dateStr){
		Date date = parseDate(dateStr,"yyyyMMdd");
		Calendar c = Calendar.getInstance();
	    c.setTime(date);
	    c.add(Calendar.DATE, -1);
	    return formatDate(c.getTime());
	}
	/**
	 * @describtion: 获取日期的后一天
	 * @param date 传入日期
	 * @return
	 */
	public static String getAfterDate(String dateStr){
		Date date = parseDate(dateStr,"yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
	    c.setTime(date);
	    c.add(Calendar.DATE, 1);
	    return formatDate(c.getTime());
	}
	/**
	 * 返回当前毫秒,同步,唯一
	 * @return
	 */
	public static synchronized String currentTimeMillis(){
		long t = new Date().getTime();
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return String.valueOf(t);
	}
}