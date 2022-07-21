package cn.com.yusys.yusp.uimp.business.pma.scheme.indexImp.utils;


import org.apache.log4j.Logger;

public  class PmaCommonUtil {
	/**
	 * <pre>
	 * Title:PMA工具包
	 * 
	 * @author  zh_haining zhaohn3@yuchengtech.com
	 * 所在文件:com.yuchengtech.pma.common.PmaCommonUtil.java
	 * 修改时间:2014-5-26 下午08:55:44 修改人：          修改后版本:@version 1.00.00
	 *  </pre>
	 * */
	
	/**
	 * <pre>
	 * Title:将日期字符串转换为规定的字符创格式(eg:2014-5-1 转化为  20140501)
	 * 
	 * @author  zh_haining zhaohn3@yuchengtech.com
	 * ParamList:
	 *     @param dateStr 2014-5-1
	 *     @return  2014050
	 * ReturnType: String
	 * 所在文件:com.yuchengtech.pma.common.PmaCommonUtil.java
	 * 修改时间:2014-5-26 下午08:57:20 修改人：          修改后版本:@version 1.00.00
	 *  </pre>
	 * */
	public static String transDateStrToStr (String dateStr){
		String retStr = "";
		if (null != dateStr && !"".equals(dateStr.trim())) {
			String [] array = dateStr.split("-");//存放年 月 日
			if(array[1].length() == 1){
				array[1] = "0" + array[1] ;//如果月份位数为1则其前补0
			}
			if(array[2].length() == 1){//如果日 位数为1则其前补0
				array[2] = "0" + array[2] ;
			}
			retStr = array[0]+array[1] + array[2];
		}else {
			try {
				throw new Exception( "日期串格式转化失败");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return retStr;
	}
	/**
	 * <pre>
	 * Title:将字符串转换为规定的日期字符创格式(eg:20140501  转化为  2014-5-1)
	 * 
	 * @author  zh_haining zhaohn3@yuchengtech.com
	 * ParamList:
	 *     @param str 20140501 
	 *     @return  2014-05-01
	 * ReturnType: String
	 * 所在文件:com.yuchengtech.pma.common.PmaCommonUtil.java
	 * 修改时间:2014-5-27 上午08:52:41 修改人：          修改后版本:@version 1.00.00
	 *  </pre>
	 * */
	public static String transStrToDateStr(String str){
		String retStr = "";
		if (null != str && !"".equals(str.trim()) && str.length() == 8) {
			retStr =  str.substring(0, 4 ) + "-" + str.substring(4,6) + "-" + str.substring(6,8);
		}else {
			try {
				throw new Exception( "日期串格式转化失败");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return retStr;
	}
	/**
	 * <pre>
	 *  解析指标维度串（包含维度ID串和维度名称串）
	 * @author  zh_haining@yuchengtech.com
	 * 参数列表：
	 *     @param indexDimStr
	 *     		格式：B0000046[05.AA.00]
	 *			           四年期（含）以下个人贷款[月利润.折人民币.员工.指标]
	 *     @return
	 * ReturnType: String['指标ID','余额类型','币种','考核对象类型','应用类型']
	 * 所在文件:com.yuchengtech.pma.aditionalrecordmanage.service.DataImportManageService.java
	 * 修改时间:2014-6-27 下午03:31:51 修改人：          修改后版本:@version 1.00.00
	 *  </pre>
	 * */
	public static String[]analysisIndexDim(String indexDimStr){
		//B0000046[05.AA.01.00]
		//四年期（含）以下个人贷款[月利润.折人民币.员工.指标]
		String[]retIndexDimArra = new String[6];
		if (null != indexDimStr && !"".equals(indexDimStr)) {
			retIndexDimArra[0] = indexDimStr.substring(0, indexDimStr.indexOf('['));//第一位指标编号
			String dimArra = indexDimStr.substring(indexDimStr.indexOf('[')+1,indexDimStr.length()-1);
			retIndexDimArra[1] = dimArra.substring(0,2);//余额类型
			retIndexDimArra[2] =dimArra.substring(3,5);//币种
			retIndexDimArra[3] = dimArra.substring(6,8);//应用类型
			retIndexDimArra[4] = dimArra.substring(9,11);//应用类型
			retIndexDimArra[5] = dimArra.substring(12,14);//应用类型
		}
		return retIndexDimArra;
	}
}
