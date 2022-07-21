package cn.com.yusys.yscimc.operation.support;

import org.springframework.util.Assert;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * 日期工具类
 * @author chenyx7
 * @date 2021-02-04 20:45:43
 * @version 1.0.0
 */

public class DateUtil {
    public static final String YYYY_MM_DD_MM_HH_SS_BACKSLASH = "yyyy/MM/dd HH:mm:ss";

    public static final String YYYY_MM_DD_MM_HH_SS = "yyyy-MM-dd HH:mm:ss";
    
    public static final String YYYY_MM_DD = "yyyy-MM-dd";
    
    public static final String YYYYMMDD = "yyyyMMdd";

    public static final String HHMMSS = "HHmmss";
    
    public static final String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";
    
    public static final String YYYYMMDDMMHHSSSSS = "yyyyMMddHHmmssSSS";

    public static final String YYYY_MM = "yyyy-MM";

    public static final String YYYYMM = "yyyyMM";

    public static final String YYYY_MM_DD_HH_MM_SS_S = "yyyy-MM-dd HH:mm:ss S";

    public static final String YYYY_MM_DD_HH_MM_SS_SSS = "yyyy-MM-dd HH:mm:ss.SSS";

    public static final String CHINA_DATE = "yyyy年MM月dd日";

    public static final String CHINA_DATE_TIME = "yyyy年MM月dd日HH时mm分ss秒";

    /**
     * 获取日期加上天数后的日期.
     * @author chenyx7
     * @date 2019年9月15日 下午4:24:03
     * @param date 日期
     * @param day 天数
     * @return 加上天数后的日期
     */
    public static Date dateAddDay(Date date, int day) {
        return toDate(toLocalDateTime(date).plusDays(day));
    }

    /**
     * 获取日期加上天数后的日期.
     * @author chenyx7
     * @date 2021年2月26日 下午4:24:03
     * @param dateStr 日期
     * @param day 天数
     * @return 加上天数后的日期
     */
    public static String dateAddDay(String dateStr, int day) {
        Date date = strParseDate(dateStr);
        return toLocalDateTime(date).plusDays(day).format(DateTimeFormatter.ISO_LOCAL_DATE);
    }


    /**
     * 获取日期加上月数后的日期.
     * @author chenyx7
     * @date 2019年9月15日 下午4:25:58
     * @param date 日期
     * @param month 月数
     * @return 日期加上月数后的日期
     */
    public static Date dateAddMonth(Date date, int month) {
        return toDate(toLocalDateTime(date).plusMonths(month));
    }
    
    /**
     * 获取日期加上年数后的日期.
     * @author chenyx7
     * @date 2019年9月15日 下午4:26:52
     * @param date 日期
     * @param year 年数
     * @return 日期加上年数后的日期
     */
    public static Date dateAddYear(Date date, int year) {
        return toDate(toLocalDateTime(date).plusYears(year));
    }
    
    /**
     * 日期转换为yyyy-MM-dd格式的字符串.
     * @author chenyx7
     * @date 2019年9月15日 下午4:28:49
     * @param date 日期
     * @return 格式化后的日期
     */
    public static String dateToString(Date date) {
        return toLocalDateTime(date).format(DateTimeFormatter.ISO_LOCAL_DATE);
    }
    
    /**
     * 将日期使用指定DateTimeFormatter格式化为字符串
     * @param date Date日期
     * @param formatter DateTimeFormatter格式化模板
     * @return 格式化后日期字符串
     */
    public static String dateToString(Date date, DateTimeFormatter formatter) {
        return toLocalDateTime(date).format(formatter);
    }

    /**
     * 将日期按指定转成字符串.
     * @author chenyx7
     * @date 2019年9月15日 下午4:29:54
     * @param date 日期
     * @param pattern 格式
     * @return 指定格式化后的日期
     */
    public static String dateToString(Date date, String pattern) {
        return toLocalDateTime(date).format(DateTimeFormatter.ofPattern(pattern));
    }

    /**
     * 将日期转换为中文.
     * @author chenyx7
     * @date 2019年9月15日 下午4:32:10
     * @param date 日期
     * @return 中文日期
     */
    public static String dateToChineseString(Date date) {
        return dateToString(date, CHINA_DATE);
    }
    
    /**
     * 获取当前日期的前n天.
     * @author chenyx7
     * @date 2019年9月15日 下午4:34:53
     * @param days 天数
     * @return 格式化为yyyy-MM-dd的前n天日期
     */
    public static String getPreviousDayString(int days) {
        return LocalDateTime.now().minusDays(days).format(DateTimeFormatter.ISO_LOCAL_DATE);
    }

    /**
     * 获取当前日期的前n天日期
     * @param days 向前天数
     * @return 当前日期的前n天Date时间
     */
    public static Date getPreviousDay(int days) {
        return toDate(LocalDateTime.now().minusDays(days));
    }

    /**
     * 获取Date类型的日期.
     * @author chenyx7
     * @date 2019年9月15日 下午4:48:29
     * @param strDate 字符串格式的日期 (yyyy-MM-dd)
     * @return Date类型的日期
     */
    public static Date strToDate(String strDate,String format) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat(format);//设置日期格式
        return df.parse(strDate);
    }
    /**
     * 获取Date类型的日期.
     * @author chenyx7
     * @date 2019年9月15日 下午4:48:29
     * @param strDate 字符串格式的日期 (yyyy-MM-dd)
     * @return Date类型的日期
     */
    public static Date strParseDate(String strDate) {
        return toDate(LocalDateTime.of(LocalDate.parse(strDate), LocalTime.MIN));
    }
    /**
     * 获取系统日期.
     * @author chenyx7
     * @date 2019年9月15日 下午4:39:54
     * @return 系统日期(yyyy-MM-dd)
     */
    public static String getSystemDate() {
        return LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE);
    }

    /**
     * 获取系统时间.
     * @author chenyx7
     * @date 2021年3月3日 下午4:39:54
     * @return 系统时间(yyyy-MM-dd HH:mm:ss)
     */
    public static String getSystemDatetime() {
        SimpleDateFormat df = new SimpleDateFormat(YYYY_MM_DD_MM_HH_SS);//设置日期格式
        String datetime = df.format(new Date());// new Date()为获取当前系统时间
        return datetime;
    }

    /**
     * 获取本周的第一天
     * @author chenyx7
     * @date 2021年02月07日 下午2:54:40
     * @return 本周第一天
     */
    public static String getFirstDayOfWeek() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.WEEK_OF_MONTH, 0);
        cal.set(Calendar.DAY_OF_WEEK, 2);
        Date time = cal.getTime();
        return dateToString(time, YYYY_MM_DD);
    }

    /**
     * 获取本周的最后一天
     * @author chenyx7
     * @date 2021年02月07日 下午4:41:40
     * @return 本周最后一天
     */
    public static String getLastDayOfWeek() {
        Calendar cal=Calendar.getInstance();
        cal.set(Calendar.DAY_OF_WEEK, cal.getActualMaximum(Calendar.DAY_OF_WEEK));
        cal.add(Calendar.DAY_OF_WEEK, 1);
        Date time=cal.getTime();
        return dateToString(time, YYYY_MM_DD);
    }

    /**
     * 获取本月第一天.
     * @author chenyx7
     * @date 2021年02月07日 下午14:04:40
     * @return 本月第一天
     */
    public static String getFirstDayOfMonth() {
        String currentDate = getSystemDate();
        return getFirstDayOfMonth(currentDate);
    }

    /**
     * 获取本月最后一天.
     * @author chenyx7
     * @date 2021年02月07日 下午14:19:40
     * @return 本月最后一天
     */
    public static String getLastDayOfMonth() {
        String currentDate = getSystemDate();
        return getLastDayOfMonth(currentDate);
    }

    
    /**
     * 获取日期所在月份的第一天.
     * @author chenyx7
     * @date 2019年9月15日 下午4:41:40
     * @param date 日期
     * @return 日期所在月份第一天
     */
    public static Date getFirstDayOfMonth(Date date) {
        return toDate(toLocalDateTime(date).withDayOfMonth(1));
    }
    
    /**
     * 获取YYYY-MM-DD格式的字符串日期所在月份的第一天.
     * @author chenyx7
     * @date 2019年9月15日 下午4:51:34
     * @param ymd YYYY-MM-DD格式字符串
     * @return 日期所在月份第一天
     */
    public static String getFirstDayOfMonth(String ymd) {
        return LocalDate.parse(ymd).with(TemporalAdjusters.firstDayOfMonth()).format(DateTimeFormatter.ISO_LOCAL_DATE);
    }
    
    /**
     * 获取YYYY-MM-DD格式的字符串日期所在月份的上月月份.
     * @author chenyx7
     * @date 2019年9月15日 下午4:52:55
     * @param ymd YYYY-MM-DD格式字符串
     * @return 日期所在上月月份
     */
    public static String getBeforeMonth(String ymd) {
        return LocalDate.parse(ymd).minusMonths(1).format(DateTimeFormatter.ofPattern(YYYY_MM));
    }
    
    /**
     * 获取日期所在月份的最后一天.
     * @author chenyx7
     * @date 2019年9月15日 下午4:56:33
     * @param date 日期
     * @return 日期所在月份的最后一天
     */
    public static Date getLastDayOfMonth(Date date) {
        return toDate(toLocalDateTime(date).with(TemporalAdjusters.lastDayOfMonth()));
    }
    
    /**
     * 获取YYYY-MM-DD格式的字符串日期所在月份的最后一天.
     * @author chenyx7
     * @date 2019年9月15日 下午4:59:25
     * @param ymd YYYY-MM-DD格式字符串
     * @return 日期所在月份的最后一天
     */
    public static String getLastDayOfMonth(String ymd) {
        return LocalDate.parse(ymd).with(TemporalAdjusters.lastDayOfMonth()).format(DateTimeFormatter.ISO_LOCAL_DATE);
    }

    /**
     * 获取昨天所在的月份.
     * @author chenyx7
     * @date 2019年9月15日 下午5:03:28
     * @return 昨天所在的月份(yyy-MM)
     */
    public static String getYesterdayMonth() {
        return LocalDate.now().minusDays(1).format(DateTimeFormatter.ofPattern(YYYY_MM));
    }
    
    /**
     * 获取所在年份第一天日期.
     * @author chenyx7
     * @date 2019年9月15日 下午5:05:02
     * @param year 年份
     * @return 所在年份第一天日期
     */
    public static Date getYearFirstDay(int year) {
        return toDate(LocalDateTime.of(year, 1, 1, 0, 0 ,0));
    }

    /**
     * 将日期格式化为指定格式.
     * @author chenyx7
     * @date 2019年9月15日 下午5:06:34
     * @param date 日期
     * @param dtFormat 格式字符串
     * @return 格式化后的日期
     */
    public static String fmtDateToStr(Date date, String dtFormat) {
        Assert.notNull(date, "日期不能为空！");
        return toLocalDateTime(date).format(DateTimeFormatter.ofPattern(dtFormat));
    }
    
    /**
     * 获取当前日期.
     * @author chenyx7
     * @date 2019年9月15日 下午5:08:47
     * @param dtFormat 格式
     * @return 格式化的当前日期
     */
    public static String getCurrentDate(String dtFormat) {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(dtFormat));
    }

    /**
     * 将Date转为系统默认时区LocalDateTime
     * @param date Date时间
     * @return 转换后的LocalDateTime时间
     */
    public static LocalDateTime toLocalDateTime(Date date) {
        return toLocalDateTime(date, ZoneId.systemDefault());
    }

    /**
     * 将Date装换为指定时区的LocalDateTime
     * @param date Date时间
     * @param zoneId 时区
     * @return 转换后的LocalDateTime时间
     */
    public static LocalDateTime toLocalDateTime(Date date, ZoneId zoneId) {
        return LocalDateTime.ofInstant(date.toInstant(), zoneId);
    }

    /**
     * 将LocalDateTime转为系统默认时区的Date
     * @param localDateTime LocalDateTime时间
     * @return 转换后的Date时间
     */
    public static Date toDate(LocalDateTime localDateTime) {
        return toDate(localDateTime, ZoneId.systemDefault());
    }

    /**
     * 将LocalDateTime转为指定时区的Date
     * @param localDateTime LocalDateTime时间
     * @param zoneId 时区
     * @return 转换后的Date时间
     */
    public static Date toDate(LocalDateTime localDateTime, ZoneId zoneId) {
        ZonedDateTime zdt = localDateTime.atZone(zoneId);
        return Date.from(zdt.toInstant());
    }

    /**
     * 将传入格式的 日期字符串(包含时分秒)转为指定输出格式
     * @author zhangchi
     * @date 2020年3月27日 10:31:53
     * @param dateStr
     * @param datePattern
     * @param toPattern 
     * @return java.lang.String 
     */
    public static String dateTimeStrConvert(String dateStr, String datePattern, String toPattern) {
        LocalDateTime localDateTime = LocalDateTime.parse(dateStr, DateTimeFormatter.ofPattern(datePattern, Locale.CHINESE));
        return localDateTime.format(DateTimeFormatter.ofPattern(toPattern, Locale.CHINESE));
    }

    /**
     * 将传入格式的 日期字符串转为指定输出格式
     * @author zhangchi
     * @date 2020年3月27日 10:31:53
     * @param dateStr
     * @param datePattern
     * @param toPattern
     * @return java.lang.String
     */
    public static String dateStrConvert(String dateStr, String datePattern, String toPattern) {
        LocalDate localDate = LocalDate.parse(dateStr, DateTimeFormatter.ofPattern(datePattern, Locale.CHINESE));
        return localDate.format(DateTimeFormatter.ofPattern(toPattern, Locale.CHINESE));
    }

    /**
     * 获取和当前日期的日期差对象
     * @author zhangchi
     * @date 2020年7月23日 13:59:33
     * @param startDateTime
     * @param pattern
     * @return java.time.Duration
     */
    public static Duration dateTimeDuration(String startDateTime, String pattern) {
        LocalDateTime start = LocalDateTime.parse(startDateTime, DateTimeFormatter.ofPattern(pattern, Locale.CHINESE));
        return Duration.between(start, LocalDateTime.now());
    }

    /**
     * 日期与当前时间差毫秒数
     * @author zhangchi
     * @date 2020年7月23日 14:06:38
     * @param startDateTime
     * @param pattern
     * @return java.lang.Long
     */
    public static Long dateTimeBetweenMillis(String startDateTime, String pattern) {
        return dateTimeDuration(startDateTime, pattern).toMillis();
    }

    /**
     * 日期与当前时间差秒数
     * @author zhangchi
     * @date 2020年7月23日 14:06:23
     * @param startDateTime
     * @param pattern
     * @return java.lang.Long
     */
    public static Long dateTimeBetweenSeconds(String startDateTime, String pattern) {
        return dateTimeDuration(startDateTime, pattern).getSeconds();
    }
    
    /**
     * 获取日期时间差
     * @author zhangchi
     * @date 2020年7月23日 13:59:38
     * @param startDateTime
     * @param endDateTime
     * @param pattern
     * @return java.time.Duration 
     */
    public static Duration dateTimeDuration(String startDateTime, String endDateTime, String pattern) {
        LocalDateTime start = LocalDateTime.parse(startDateTime, DateTimeFormatter.ofPattern(pattern, Locale.CHINESE));
        LocalDateTime end = LocalDateTime.parse(endDateTime, DateTimeFormatter.ofPattern(pattern, Locale.CHINESE));
        return Duration.between(start, end);
    }

    /**
     * 日期差毫秒数
     * @author zhangchi
     * @date 2020年7月23日 14:06:38
     * @param startDateTime
     * @param endDateTime
     * @param pattern
     * @return java.lang.Long
     */
    public static Long dateTimeBetweenMillis(String startDateTime, String endDateTime, String pattern) {
        return dateTimeDuration(startDateTime, endDateTime, pattern).toMillis();
    }

    /**
     * 日期差秒数
     * @author zhangchi
     * @date 2020年7月23日 14:06:23
     * @param startDateTime
     * @param endDateTime
     * @param pattern
     * @return java.lang.Long
     */
    public static Long dateTimeBetweenSeconds(String startDateTime, String endDateTime, String pattern) {
        return dateTimeDuration(startDateTime, endDateTime, pattern).getSeconds();
    }

    /**
     * 判断反斜杠日期时间格式是否正确
     * @author chenyuanxian
     * @date 2021年6月18日 14:06:23
     * @param datetime 日期时间字符串
     * @return true or false
     */
    public static boolean isBackslashValidDate(String datetime) {
        boolean convertSuccess = false;
        // 指定日期格式为四位年/两位月份/两位日期，注意yyyy/MM/dd区分大小写；
        SimpleDateFormat format = new SimpleDateFormat(DateUtil.YYYY_MM_DD_MM_HH_SS_BACKSLASH);
        try {
            // 设置lenient为false. 否则SimpleDateFormat会比较宽松地验证日期，比如2007/02/29会被接受，并转换成2007/03/01
            format.setLenient(false);
            format.parse(datetime);
            convertSuccess = true;
        } catch (ParseException e) {
            convertSuccess = false;
        }

        return convertSuccess;
    }

    /**
     * 判断中横线日期时间格式是否正确
     * @author chenyuanxian
     * @date 2021年6月18日 14:15:23
     * @param datetime 日期时间字符串
     * @return true or false
     */
    public static boolean isMiddleLineValidDate(String datetime) {
        boolean convertSuccess = false;
        // 指定日期格式为四位年/两位月份/两位日期，注意yyyy/MM/dd区分大小写；
        SimpleDateFormat format = new SimpleDateFormat(DateUtil.YYYY_MM_DD_MM_HH_SS);
        try {
            // 设置lenient为false. 否则SimpleDateFormat会比较宽松地验证日期，比如2007/02/29会被接受，并转换成2007/03/01
            format.setLenient(false);
            format.parse(datetime);
            convertSuccess = true;
        } catch (ParseException e) {
            convertSuccess = false;
        }

        return convertSuccess;
    }

    /**
     * 判断日期时间格式是否正确
     * @author chenyuanxian
     * @date 2021年6月18日 16:15:23
     * @param str 日期时间字符串
     * @return true or false
     */
    public static boolean isValidDate(String str) {
        boolean convertSuccess = isBackslashValidDate(str) || isMiddleLineValidDate(str);

        return convertSuccess;
    }



    private DateUtil() {
        throw new IllegalStateException();
    }

}
