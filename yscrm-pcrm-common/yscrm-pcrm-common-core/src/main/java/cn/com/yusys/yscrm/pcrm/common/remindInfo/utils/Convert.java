package cn.com.yusys.yscrm.pcrm.common.remindInfo.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Convert {
    public Convert() {
    }
    /**
     * 转成亿元
     * @param parameter
     * @return
     */
    public static String getUnit(String parameter){
       String formatNum=null;
        if(parameter==null || parameter==""){
            formatNum ="0.00";
        }else{
        BigDecimal bigDecimal = new BigDecimal(parameter);
        // 转换为亿元（100000000）
        BigDecimal decimal = bigDecimal.divide(new BigDecimal("100000000"));
        // 保留两位小数
        DecimalFormat formater = new DecimalFormat("0.00");
        // 四舍五入
        formater.setRoundingMode(RoundingMode.HALF_UP);
        // 格式化完成之后得出结果
         formatNum = formater.format(decimal);}

        return formatNum;
    }
    /**
     * 转成万元
     * @param parameter
     * @return
     */
    public static String getMany(String parameter){
        String formatNum=null;
        if(parameter==null || parameter==""){
            formatNum ="0.00";
        }else {
            BigDecimal bigDecimal = new BigDecimal(parameter);
            // 转换为万元（10000）
            BigDecimal decimal = bigDecimal.divide(new BigDecimal("10000"));
            // 保留两位小数
            DecimalFormat formater = new DecimalFormat("0.00");
            // 四舍五入
            formater.setRoundingMode(RoundingMode.HALF_UP);
            // 格式化完成之后得出结果
            formatNum = formater.format(decimal);
        } return formatNum;
    }

    /**
     * 获取比例（百分比）
     * @param parameter
     * @return
     */
    public static String getPercent(String parameter){
        String formatNum=null;
        if(parameter==null || parameter=="" ){
            formatNum ="0.00";
        }else {
            BigDecimal bigDecimal = new BigDecimal(parameter);
            // 转换为100%
            BigDecimal decimal = bigDecimal.multiply(new BigDecimal("100"));
            // 保留两位小数
            DecimalFormat formater = new DecimalFormat("0.00");
            // 四舍五入
            formater.setRoundingMode(RoundingMode.HALF_UP);
            // 格式化完成之后得出结果
            formatNum = formater.format(decimal);
        } return formatNum;
    }
    /**
     * 四舍五入
     * @param parameter
     * @return
     */
    public static String getFour(String parameter){
        String formatNum=null;
        if(parameter==null || parameter=="" || "NaN".equals(parameter)){
            formatNum ="0.00";
        }else {
            BigDecimal resst=new BigDecimal(parameter);
            // 保留两位小数
            DecimalFormat formater = new DecimalFormat("0.00");
            // 四舍五入
            formater.setRoundingMode(RoundingMode.HALF_UP);
            // 格式化完成之后得出结果
            formatNum = formater.format(resst);
        }
        return formatNum;
    }
    /**
     * 保留小数点后i位，四舍五入
     * @param
     * @return
     */
    public static BigDecimal getBigDecimalScale(BigDecimal bg,int i){
    	BigDecimal f = bg.setScale(i, BigDecimal.ROUND_HALF_UP);
    	return f;
    }
    
    /**
     * 获取比例（百分比）
     * @param
     * @return
     */
    public static BigDecimal getDoublePercent(BigDecimal bg){
        // 转换为100%
        BigDecimal decimal = bg.multiply(new BigDecimal("100"));
        // 保留两位小数
        BigDecimal f = decimal.setScale(2, BigDecimal.ROUND_HALF_UP);
        return f;
    }
    /**
     * 四舍五入
     * @param parameter
     * @return
     */
    public static String getThenUnit(String parameter){
        String formatNum=null;
        if(parameter==null || parameter=="" ){
            formatNum ="0.00";
        }else {
            BigDecimal resst=new BigDecimal(parameter);
            // 保留两位小数
            DecimalFormat formater = new DecimalFormat("0");
            // 四舍五入
            formater.setRoundingMode(RoundingMode.HALF_UP);
            // 格式化完成之后得出结果
            formatNum = formater.format(resst);
        }
        return formatNum;
    }

    /**
     * 2数相除求百分比
     * @param fenzi 分子
     * @param fenmu 分母
     * @return
     */
    public static String getBaifenbi(String fenzi,String fenmu) {
    	
    	if(fenzi==null || fenzi=="" ){
    		fenzi ="0.00";
        }
    	if(fenmu==null || fenmu=="" ){
    		fenmu ="0.00";
    	}
    	
    	BigDecimal bgFenzi = new BigDecimal(fenzi);
    	BigDecimal bgFenmu = new BigDecimal(fenmu);
    	
    	BigDecimal nRate = bgFenmu.compareTo(BigDecimal.ZERO) == 0 ? new BigDecimal("0.00") : bgFenzi.multiply(new BigDecimal("100")).divide(bgFenmu, 2, RoundingMode.HALF_UP);
    	
    	return nRate.toString();
    }
    /**
     * 计算a-b的值
     * @param a
     * @param b
     * @return
     */
    public static String getSubtract(String a,String b) {
    	if(a==null || a=="" ){
    		a ="0.00";
        }
    	if(b==null || b=="" ){
    		b ="0.00";
    	}
    	
    	BigDecimal bgA = new BigDecimal(a);
    	BigDecimal bgB = new BigDecimal(b);
    	return bgA.subtract(bgB).toString();
    }
}
