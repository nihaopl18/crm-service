package cn.com.yusys.yscrm.custservice.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DateUtils {
	/** �?��的毫秒数 */
	private final static Long DAY_MILLISECOND = 86400000L;
	@SuppressWarnings("unused")
	private static final Log log = LogFactory.getLog(DateUtils.class);

	/**
	 * 日期转字符串yyyy-mm-dd
	 * 
	 * @param date
	 * @return
	 */
	public static String date2str(Date date) {
		String format = "yyyy-MM-dd";
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}

	/**
	 * 将日期字段格式化为yyyy-MM-dd格式的数值型字段
	 * 
	 * @param date
	 * @return
	 */
	public static String getFmtDateStrWithDash(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if (date != null) {
			return sdf.format(date);
		} else {
			return "";
		}
	}

	/**
	 * 将日期字段格式化为yyyy-MM-dd hh:mm:ss格式的数值型字段
	 * 
	 * @param date
	 * @return
	 */
	public static String getFmtDateStrWithSecond(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		if (date != null) {
			return sdf.format(date);
		} else {
			return "";
		}
	}

	/**
	 * 返回当月最后一天的日期
	 * 
	 * @param sDate1
	 * @return
	 */
	public static String getLastDayOfMonth(Date sDate1) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(sDate1);
		int value = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		cal.set(Calendar.DAY_OF_MONTH, value);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(cal.getTime());
	}

	/**
	 * 将字符串型日期增加几天
	 * 
	 * @param date
	 *            String
	 * @param days
	 *            int
	 * @param format
	 *            String
	 * @return String
	 */
	public static String addDate(String date, int days) {
		try {
			String format = "yyyy-MM-dd";
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			Date newDate = sdf.parse(date);
			GregorianCalendar curGc = new GregorianCalendar();
			if (newDate != null)
				curGc.setTime(newDate);
			curGc.add(Calendar.DATE, days);
			String rtnDate = sdf.format(curGc.getTime());
			return rtnDate;
		} catch (ParseException ex) {
			return null;
		}

	}

	/**
	 * 获得几天之后的日期
	 * @param date 当前日期
	 * @param days 天数
	 * @return 几天之后的日期
	 */
	public static String addDate(Date date, int days) {

		String format = "yyyy-MM-dd";
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		GregorianCalendar curGc = new GregorianCalendar();
		if (date != null)
			curGc.setTime(date);
		curGc.add(Calendar.DATE, days);
		String rtnDate = sdf.format(curGc.getTime());
		return rtnDate;

	}

	/**
	 * 字符串转换为日期类型 yyyy-mm-dd
	 * 
	 * @param date
	 * @return
	 */
	public static Date str2date(String date) {
		try {
			String format = "yyyy-MM-dd";
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			Date newDate = sdf.parse(date);
			return newDate;
		} catch (ParseException ex) {
			return null;
		}

	}

	/**
	 * 字符串转换为日期类型
	 * 
	 * @param date
	 * @return
	 */
	public static Date str2date(String date, String formatPattern) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(formatPattern);
			Date newDate = sdf.parse(date);
			return newDate;
		} catch (ParseException ex) {
			return null;
		}

	}

	/**
	 * 字符串转换为日期类型
	 * 
	 * @param date
	 * @return
	 */
	public static Date str2dateNoDash(String date) {
		try {
			String format = "yyyyMMdd";
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			Date newDate = sdf.parse(date);
			return newDate;
		} catch (ParseException ex) {
			return null;
		}

	}

	/**
	 * 计算两个日期的相隔天数
	 * 
	 * @param strDate1
	 *            起始日期
	 * @param strDate2
	 *            截止日期
	 * @return 天数
	 */
	public static int getDaysByStr(String strDate1, String strDate2) {

		try {
			Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(strDate1);
			Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse(strDate2);
			// long time = date2.getTime()-date1.getTime();
			long day = (date2.getTime() - date1.getTime())
					/ (24 * 60 * 60 * 1000);
			int rtnDay = (int) day + 1;
			return rtnDay;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}

	}

	/**
	 * 计算两个日期的相隔天数
	 * 
	 * @param strDate1
	 *            起始日期
	 * @param strDate2
	 *            截止日期
	 * @return 天数
	 */
	public static int getDaysByDate(Date date1, Date date2) {

		long day = (date2.getTime() - date1.getTime()) / (24 * 60 * 60 * 1000);
		int rtnDay = (int) day + 1;
		return rtnDay;

	}

	/**
	 * 获取当前日期及时间带毫秒
	 * 
	 * @return
	 */
	public static String getCurrentDateWithMS() {
		Date now = new Date(System.currentTimeMillis());
		// SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		return sdf.format(now);
	}

	/**
	 * 获取当前日期及时间带毫秒无分隔符
	 * 
	 * @return
	 */
	public static String getCurrentDateTimeWithMS() {
		Date now = new Date(System.currentTimeMillis());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		return sdf.format(now);
	}

	/**
	 * 获取当前日期,无分隔符
	 * 
	 * @return
	 */
	public static String getCurrentDateWithoutSplit() {
		Date now = new Date(System.currentTimeMillis());
		// SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		return sdf.format(now);
	}

	/**
	 * 获取当前日期 yyyy-mm-dd
	 * 
	 * @return
	 */
	public static String getCurrentDate() {
		Date now = new Date(System.currentTimeMillis());
		// SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(now);
	}

	/**
	 * 获取带时间的当前日期yyyy-mm-dd HH:mm:ss
	 * 
	 * @return
	 */
	public static String getCurrentDateTime() {
		Date now = new Date(System.currentTimeMillis());
		// SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(now);
	}

	/**
	 * 根据两个 Calendar （日历） 对象返回它们之间相差（day）天 数差
	 * 
	 * @param calendar1
	 *            日历1 减数
	 * @param calendar2
	 *            日历2 被减数
	 * @return day（天数差值）
	 */
	public static Long getDaysByCalendar(Calendar calendar1, Calendar calendar2) {
		// 得到从1970年1月1日到 calendar1日期过的天数
		long time1 = calendar1.getTime().getTime() / DAY_MILLISECOND;
		// 得到从1970年1月1日到 calendar2日期过的天数
		long time2 = calendar2.getTime().getTime() / DAY_MILLISECOND;
		// 将两个经过的时间减出来就得到了它们之间的时间差
		return time1 - time2;
	}

	/**
	 * 获取n个月后的当天日期 当n为负数时，表示n个月前的当天日期
	 * 
	 * @param date
	 * @param n
	 *            前或后几个月
	 * @return
	 */
	public static Calendar getDateOfNextMonth(Calendar date, int n) {
		Calendar lastDate = (Calendar) date.clone();
		lastDate.add(Calendar.MONTH, n);
		return lastDate;
	}

	/**
	 * 获取n个月后的当天日期 当n为负数时，表示n个月前的当天日期
	 * 
	 * @param dateStr
	 * @param n
	 *            前或后几个月
	 * @return
	 */
	public static String getDateOfNextMonth(String dateStr, int n) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date = sdf.parse(dateStr);
			Calendar c = Calendar.getInstance();
			c.setTime(date);
			return sdf.format(getDateOfNextMonth(c, n).getTime());
		} catch (ParseException e) {
			throw new IllegalArgumentException(
					"Invalid date format(yyyyMMdd): " + dateStr);
		}
	}

	/**
	 * 获取n个月后的当天日期 当n为负数时，表示n个月前的当天日期
	 * 
	 * @param date
	 * @param n
	 *            前或后几个月
	 * @return
	 */
	public static Calendar getDateOfNextDate(Calendar date, int n) {
		Calendar lastDate = (Calendar) date.clone();
		lastDate.add(Calendar.DATE, n);
		return lastDate;
	}

	/**
	 * 获取n个月后的当天日期 当n为负数时，表示n个月前的当天日期
	 * 
	 * @param dateStr
	 * @param n
	 *            前或后几个月
	 * @return
	 */
	public static String getDateOfNextDate(String dateStr, int n) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date = sdf.parse(dateStr);
			Calendar c = Calendar.getInstance();
			c.setTime(date);
			return sdf.format(getDateOfNextMonth(c, n).getTime());
		} catch (ParseException e) {
			throw new IllegalArgumentException(
					"Invalid date format(yyyyMMdd): " + dateStr);
		}
	}

	/**
	 * 两个日期直接相差几个月
	 * 
	 * @param begin
	 * @param end
	 * @return
	 * @throws Exception
	 */
	public static int getDiffer(String begin, String end) throws Exception {

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Calendar beginDate = Calendar.getInstance();
		beginDate.setTime(df.parse(begin));
		Calendar endDate = Calendar.getInstance();
		endDate.setTime(df.parse(end));

		return getDiffer(beginDate, endDate);

	}

	/**
	 * 两个日期直接相差几个月
	 * 
	 * @param begin
	 * @param end
	 * @return
	 * @throws Exception
	 */
	public static int getDiffer(Calendar begin, Calendar end) throws Exception {

		int beginYear = begin.get(Calendar.YEAR);
		int beginMonth = begin.get(Calendar.MONTH);

		int endYear = end.get(Calendar.YEAR);
		int endMonth = end.get(Calendar.MONTH);

		int difMonth = (endYear - beginYear) * 12 + (endMonth - beginMonth) + 1;

		return difMonth;

	}

	/**
	 * 计算两个日期之间相差的天数
	 * 
	 * @param smdate
	 *            较小的时间
	 * @param bdate
	 *            较大的时间
	 * @return 相差天数
	 * @throws ParseException
	 */
	public static int daysBetween(Date smdate, Date bdate)
			throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		smdate = sdf.parse(sdf.format(smdate));
		bdate = sdf.parse(sdf.format(bdate));
		Calendar cal = Calendar.getInstance();
		cal.setTime(smdate);
		long time1 = cal.getTimeInMillis();
		cal.setTime(bdate);
		long time2 = cal.getTimeInMillis();
		long between_days = (time2 - time1) / (1000 * 3600 * 24);

		return Integer.parseInt(String.valueOf(between_days));
	}

	/**
	 * 将日期字段格式化为yyyyMMddhhmm格式的数值型字段
	 * 
	 * @param date
	 * @return
	 */
	public static String getFmtDateNoSecond(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm");
		return sdf.format(date);
	}

	/**
	 * 将日期字段格式化为yyyyMMdd格式的数值型字段
	 * 
	 * @param date
	 * @return
	 */
	public static int getFmtDate(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		return Integer.parseInt(sdf.format(date));
	}

	/**
	 * 将日期字段格式化为yyyyMMdd格式的数值型字段
	 * 
	 * @param date
	 * @return
	 */
	public static String getFmtDateStr(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		return sdf.format(date);
	}

	public static void main(String args[]) {
//		try {
//			System.out.println(getDiffer("1995-01-01", "2014-07-24"));
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		System.out.println(getCurrentDateTimeWithMS());
	}
}
