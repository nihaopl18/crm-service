package cn.com.yusys.yscrm.custmgr.domain;



import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author: sxm
 * @time: 2021/9/1 10:37
 */
public class DateUtils {
    public final static String DEFAULT_PATTERN = "yyyy-MM-dd HH:mm:ss";

    public final static String DATE_PATTERN = "yyyy-MM-dd";
    /**
     * 获取上个季度的起始时间
     * @return
     */
    public static String getLastQuarterStartTime() {
        Calendar startCalendar = Calendar.getInstance();
        startCalendar.set(Calendar.MONTH, (startCalendar.get(Calendar.MONTH) / 3 - 1) * 3);
        startCalendar.set(Calendar.DAY_OF_MONTH, 1);
        setMinTime(startCalendar);
        return format(startCalendar.getTime());
    }
    /**
     * 获取上个季度的结束时间
     * @return
     */
    public static String getLastQuarterEndTime() {
        Calendar endCalendar = Calendar.getInstance();
        endCalendar.set(Calendar.MONTH, (endCalendar.get(Calendar.MONTH) / 3 - 1) * 3 + 2);
        endCalendar.set(Calendar.DAY_OF_MONTH, endCalendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        setMaxTime(endCalendar);
        return format(endCalendar.getTime());
    }

    /**
     * 获取近一个月起始时间
     * @return
     */
    public static String getLastMonthStartTime(){
        Calendar startCalendar = Calendar.getInstance();
        startCalendar.add(Calendar.MONTH, -1);
        setMinTime(startCalendar);
        return format(startCalendar.getTime());
    }
    /**
     * 获取当前日期
     * @return
     */
    public static String getCurrentDate(){
        return dateFormat(Calendar.getInstance().getTime());
    }

    public static String getMonthTime(int amount){
        Calendar startCalendar = Calendar.getInstance();
        startCalendar.add(Calendar.MONTH, amount);
        setMinTime(startCalendar);
        return format(startCalendar.getTime());
    }


    /**
     * 获取近一个月结束时间
     * @return
     */
    public static String getLastMonthEndTime(){
        Calendar endCalendar = Calendar.getInstance();
        setMaxTime(endCalendar);
        return format(endCalendar.getTime());
    }

    private static void setMinTime(Calendar calendar){
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
    }

    private static void setMaxTime(Calendar calendar){
        calendar.set(Calendar.HOUR_OF_DAY, calendar.getActualMaximum(Calendar.HOUR_OF_DAY));
        calendar.set(Calendar.MINUTE, calendar.getActualMaximum(Calendar.MINUTE));
        calendar.set(Calendar.SECOND, calendar.getActualMaximum(Calendar.SECOND));
        calendar.set(Calendar.MILLISECOND, calendar.getActualMaximum(Calendar.MILLISECOND));
    }



    public static String format(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat(DEFAULT_PATTERN);
        return sdf.format(date);
    }
    public static String dateFormat(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_PATTERN);
        return sdf.format(date);
    }


}
