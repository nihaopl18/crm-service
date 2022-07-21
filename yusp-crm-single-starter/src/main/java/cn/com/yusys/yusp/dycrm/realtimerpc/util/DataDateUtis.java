package cn.com.yusys.yusp.dycrm.realtimerpc.util;

import cn.com.yusys.yusp.dycrm.complaintfeedback.service.CSRSheetQueryRpcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DataDateUtis {

    private static final Logger log = LoggerFactory.getLogger(DataDateUtis.class);
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
     * @describtion: 得到当前时间 格式yyyyMMdd
     * @return yyyyMMdd字符串
     */
    public static String getCurrentDate(){
        Date date = new Date();
        DateFormat df = new SimpleDateFormat("yyyyMMdd");
        df.setLenient(false);
        return df.format(date);
    }

    /**
     * @describtion: 得到当前时间 格式yyyy-MM-dd HH:mm:ss
     * @return yyyy-MM-dd HH:mm:ss字符串
     */
    public static String getCurrentDateTimeF(){
        Date date = new Date();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        df.setLenient(false);
        return df.format(date);
    }

    /**
     * @describtion: 得到当前时间 格式yyyy-MM-dd
     * @return yyyy-MM-dd字符串
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
     * 取当前日期前一天
     * @return
     */
    public static String getBefDate(){

        Calendar calendar = Calendar.getInstance();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

        calendar.add(Calendar.DAY_OF_YEAR, -1);

        Date date = calendar.getTime();

        return sdf.format(date);

    }

    /**
     * 获取当前月第一天
     *
     * @return
     */
    public static String getFirstDate() {
        Calendar calendar = Calendar.getInstance();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

        calendar.add(Calendar.MONTH, 0);

        calendar.set(Calendar.DAY_OF_MONTH, 1);

        Date date = calendar.getTime();

        return sdf.format(date);

    }

    /**
     * 获取当前月最后一天
     *
     * @return
     */
    public static String getLastDate() {
        Calendar calendar = Calendar.getInstance();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

        calendar.set(Calendar.DAY_OF_MONTH,
                calendar.getActualMaximum(Calendar.DAY_OF_MONTH));

        Date date = calendar.getTime();

        return sdf.format(date);
    }
}
