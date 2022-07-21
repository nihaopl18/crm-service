package cn.com.yusys.yscimc.operation.constant;

/**
 * @describtion: 交易接口涉及的常量定义类
 *
 * @author : 
 * @date : 2016年3月16日 下午2:51:59
 */
public class InterfaceConstants {
	//请求/返回报文,报文结构
	public static final String SIGN = "sign";
	public static final String DATA = "data";
	
	public static final String HEAD_TRANSCODE = "transCode";
	public static final String HEAD_REQ_TIME = "reqTime";
	public static final String HEAD_CHNL_CODE = "chnlCode";
	
	public static final String HEAD_BACK_TIME = "backTime";
	public static final String HEAD_ERROR_CODE = "errorCode";
	public static final String HEAD_ERROR_INFO = "errorInfo";
	
	public static final String SIGN_TYPE = "signType";
	public static final String SIGN_VALUE = "signValue";
	
	/**
	 * 是否校验时间有效误差
	 */
	public static final boolean IS_CHK_TIME = false;
	/**
	 * 时间有效误差,单位(秒)
	 */
	public static final long SMALL_SECONDS = 120;
	/**
	 * 默认渠道代码
	 */
	public static final String DEFAULT_CHNL_CODE = "0000";

}
