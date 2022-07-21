package cn.com.yusys.yscimc.operation.support;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.security.SecureRandom;
import java.security.Security;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @describtion: 请求报文校验工具类
 *
 * @author : 
 * @date : 2016年3月14日 下午8:04:06
 */
@Component
public class SignValueUtils {

	private static final Logger log = LoggerFactory.getLogger(SignValueUtils.class);

	//sign加密密钥
//	@Value("${info.sign.AES_PWD}")
	public  String aesPwd = "IOSystem";

	//token加密密钥
//	@Value("${info.sign.APP_TOKEN}")
	public  String appToken;

	//系统配置语言标识
//	@Value("${info.application.language}")
	public  String language;

	//session user过期时间毫秒
	private static final Long TOKEN_TIMEOUT = 30 * 60 * 1000L;


	// optional value AES/DES/DESede
    public static String CIPHER_ALGORITHM = "AES/ECB/PKCS7Padding";
    
	/**
	 * 加密/校验流程如下：
	 *  0.首先判断请求时间是否有效误差范围内,若不是则直接校验不通过
	 *  1.将 TOKEN、transcode、channelCode、reqTime四个参数进行字典序排序；
	 *  2.将四个参数字符串拼接成一个字符串进行signType对应的签名方式 进行加密 ；
	 *  3.开发者获得加密后的字符串可与signValue对比，标识该请求是否来源于相应的请求渠道。
	 * 
	 * signType 签名方式，1:MD5-AES 对称加密算法，2:SHA1-AES 对称加密算法
	 * signValue 签名值，signValue 结合了各渠道 TOKEN 参数和请求中的 transcode 参数、ChnlCode 参数、
	 * reqTime参数,先进行 MD5 加密，然后再根据各渠道对应的 TOKEN 值进行 AES 加密。
	 * transcode 交易码
	 * reqTime 请求时间：格式 YYYY-MM-DD HH24:mm:ss
	 * @return true表示来源可信, false表示来源不可信
	 */
    /*
     * 解决对称加密在不同平台下密钥初始化不同的情况
     */
    public Key getKey(String strKey) throws Exception {
		if (strKey == null) {
			strKey = "";
		}
		KeyGenerator generator = KeyGenerator.getInstance("AES");
		SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
		secureRandom.setSeed(strKey.getBytes("UTF-8"));
		generator.init(128, secureRandom);
		SecretKey secretKey=generator.generateKey();
		byte[] enCodeFormat = secretKey.getEncoded();
		SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
		log.debug("SecretKeySpec:"+key);
		return key;
    }
    /*
     * 对称加密生成签名
     * 输入：报文明文
     */
    public String encrypt(String data) throws Exception {
		Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
		SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
		Key secureKey = getKey(aesPwd);
		Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
		cipher.init(Cipher.ENCRYPT_MODE, secureKey, sr);
		byte[] bt = cipher.doFinal(data.getBytes("UTF-8"));
		String strS = new BASE64Encoder().encode(bt);
		strS=strS.replaceAll("\r|\n", "");
		return strS;
    }

    /*
     * 对称加密解密
     * 输入：签名
     */
    public String decrypt(String message) throws Exception {
		SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
		Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
		Key secureKey = getKey(aesPwd);
		cipher.init(Cipher.DECRYPT_MODE, secureKey, sr);
		byte[] res = new BASE64Decoder().decodeBuffer(message);
		res = cipher.doFinal(res);
		return new String(res);
    }

	/**
	 * 获取签名值
	 * @author chenyx7
	 * @date 2021年4月28日 16:16:07
	 * @param data 加密字符串
	 * @return 签名值
	 */
	public String getSignValue(String data) throws Exception {
		log.info("====>加密报文：{}", data);
		//1、生成MD5值
		String md5Data = DigestUtils.md5Hex(data);
		//2、将生成的MD5值进行加密
		String signValue = encrypt(md5Data);
		log.info("====>签名结果：{}", signValue);
		return signValue;
	}

	/**
	 * 签名验证
	 * @author chenyx7
	 * @date 2021年4月28日 16:25:07
	 * @param data 签名字符串
	 * @return 签名值
	 */
	public  Boolean checkSignValue(String originalSignValue,String data) throws Exception {
		if (StringUtils.isBlank(originalSignValue) || StringUtils.isBlank(data)) {
			return false;
		}
		String localSignValue = getSignValue(data);
		log.info("原始签名长度:{},原始签名值：{}", originalSignValue.length(), originalSignValue);
		log.info("本地签名长度:{},本地签名值：{}", localSignValue.length(), localSignValue);
		return localSignValue != null ? localSignValue.equals(originalSignValue) : false;
	}

	/**
	 * 校验请求时间是否在有效差值范围内
	 * @param reqTime
	 * @return
	 */
	public  boolean checkReqTime(String reqTime, long timeout) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		boolean flag = false;
		Date reqDate = null;
		try {
			reqDate = sdf.parse(reqTime);
		} catch (ParseException e) {
			log.error("请求时间格式错误！----"+reqTime);
		}
		if (reqDate == null){
			return flag;
		}
		long seconds = Math.abs(System.currentTimeMillis() - reqDate.getTime()) / 1000;
		if(seconds <= timeout) {
			flag = true;
		}
		return flag;
	}

	/**
	 * 生成token信息
	 * @param userId 用户ID
	 * @param userType 用户类型
	 * @return
	 */
	public  String createTokenValue(String userId, String userType,String reqTime) throws Exception {
		//1. 将userId、userType、flag三个参数进行字典序排序
		String flag=appToken;
		String[] arr = new String[] { flag, userId, userType,reqTime};
		//Arrays.sort(arr); // 1. 将三个参数进行字典序排序
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < arr.length; i++) {
			if(i==0) {
				sb.append(arr[i]);
			}else {
				sb.append("&&"+arr[i]);
			}

		}
		String tokenValue = "";
		tokenValue = encrypt(sb.toString());

		return tokenValue;
	}

	public String getAesPwd() {
		return aesPwd;
	}

	public void setAesPwd(String aesPwd) {
		this.aesPwd = aesPwd;
	}

	public String getAppToken() {
		return appToken;
	}

	public void setAppToken(String appToken) {
		this.appToken = appToken;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public static Long getTokenTimeout() {
		return TOKEN_TIMEOUT;
	}

	public static String getCipherAlgorithm() {
		return CIPHER_ALGORITHM;
	}

	public static void setCipherAlgorithm(String cipherAlgorithm) {
		CIPHER_ALGORITHM = cipherAlgorithm;
	}
}
