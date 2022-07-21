package cn.com.yusys.yusp.uimp.base.app.uaa.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.crypto.asymmetric.Sign;
import cn.hutool.crypto.asymmetric.SignAlgorithm;

public class HttpSignUtils {
	private static Logger log = LoggerFactory.getLogger(HttpSignUtils.class);
	
	private String privateKey;
	private String publicKey;
	
	private static final String TAG = "&";
	private static final String TIMESTAMP = "timestamp";
	private static final String NONCE = "nonce";
	private static final String SIGN = "sign";
	private static final long MAX_INTERVAL_TIME = 10 * 60_000;
	
	/**
	 * @param myPriviteKey		本程序自己的私钥
	 * @param targetPublicKey	对方程序的公钥
	 */
	public HttpSignUtils(String myPriviteKey, String targetPublicKey) {
		this.privateKey = myPriviteKey;
		this.publicKey = targetPublicKey;
	}
	
	/**
	 * 对http所有传参或返回数据进行签名
	 * @param params	传参或数据列表
	 * @return
	 */
	private String sign(Map<String, Object> params) {
		TreeMap<String, Object> treeMap = new TreeMap<>(params);
		treeMap.remove(SIGN);
		StringBuilder builder = new StringBuilder();
		if (log.isDebugEnabled()) {
			log.debug("[sign] privateKey: {}...", privateKey.substring(0, 20));
			log.debug("[sign] publicKey: {}...", publicKey.substring(0, 20));
		}
		for (Entry<String, Object> entry : treeMap.entrySet()) {
			if (log.isDebugEnabled()) {
				log.debug("[sign] param: {}={}", entry.getKey(), entry.getValue());
			}
			builder.append(entry.getKey()).append("=").append(entry.getValue()).append(TAG);
		}
		if (builder.length() > 0) {
			builder.deleteCharAt(builder.length() - 1);
		}
		
		Sign sign = new Sign(SignAlgorithm.SHA1withRSA, privateKey, publicKey);
		byte[] signBytes = sign.sign(builder.toString().getBytes());
		
		return Base64.encode(signBytes);
	}
	
	/**
	 * 对http所有传参或返回数据进行验签
	 * @param params	传参或数据列表
	 * @return
	 */
	private boolean isSignVerify(Map<String, Object> params) {
		TreeMap<String, Object> treeMap = new TreeMap<>(params);
		Object signStr = treeMap.remove(SIGN);
		if (signStr == null) {
			return false;
		}
		if (log.isDebugEnabled()) {
			log.debug("[sign-verify] privateKey: {}...", privateKey.substring(0, 20));
			log.debug("[sign-verify] publicKey: {}...", publicKey.substring(0, 20));
		}
		StringBuilder builder = new StringBuilder();
		for (Entry<String, Object> entry : treeMap.entrySet()) {
			if (log.isDebugEnabled()) {
				log.debug("[sign-verify] param: {}={}", entry.getKey(), entry.getValue());
			}
			builder.append(entry.getKey()).append("=").append(entry.getValue()).append(TAG);
		}
		if (builder.length() > 0) {
			builder.deleteCharAt(builder.length() - 1);
		}
		
		Sign sign = new Sign(SignAlgorithm.SHA1withRSA, privateKey, publicKey);
		byte[] signBase64 = Base64.decode(signStr.toString().getBytes());
		boolean verify = sign.verify(builder.toString().getBytes(), signBase64);
		return verify;
	}
	
	/**
	 * 验签
	 * @param request
	 */
	public void checkSign(HttpServletRequest request) {
		if (log.isDebugEnabled()) {
			log.debug("[check-sign] check sign. uri: {}", request.getRequestURI());
		}
		Map<String, String[]> parameterMap = request.getParameterMap();
		Map<String, Object> params = new HashMap<>();
		for (Entry<String, String[]> entry : parameterMap.entrySet()) {
			if (entry.getValue() != null && entry.getValue().length == 1) {
				params.put(entry.getKey(), entry.getValue()[0]);
			} else {
				params.put(entry.getKey(), null);
				log.warn("[check-sign] http parameter value length is {}. parameter name is [{}]", entry.getValue().length, entry.getKey());
			}
		}
		
		checkSign(params);
	}
	
	/**
	 * 验签
	 * @param params
	 */
	public void checkSign(Map<String, Object> params) {
		Object timestamp = params.get(TIMESTAMP);
		if (timestamp == null) {
			throw new HttpSignException("参数[timestamp]数据错误");
		}
		long now = System.currentTimeMillis();
		if (Math.abs(Long.valueOf(timestamp.toString()) - now) > MAX_INTERVAL_TIME) {
			throw new HttpSignException("时间戳校验失败");
		}
		Object nonce = params.get(NONCE);
		if (nonce == null || nonce.equals("")) {
			throw new HttpSignException("参数[nonce]数据错误");
		}
		Object sign = params.get(SIGN);
		if (sign == null || sign.equals("")) {
			throw new HttpSignException("参数[sign]数据错误");
		}
		try {
			if (!isSignVerify(params)) {
				throw new HttpSignException("签名校验失败");
			}
		} catch (HttpSignException e) {
			throw e;
		} catch (Exception e) {
			throw new HttpSignException("签名校验异常");
		}
	}
	
	/**
	 * 对发送的数据添加签名信息
	 * @param sendData
	 */
	public void addSignInfo(Map<String, Object> sendData) {
		sendData.put(TIMESTAMP, System.currentTimeMillis());
		sendData.put(NONCE, RandomUtil.randomInt(100000000, 999999999));
		sendData.remove(SIGN);
		String signStr = sign(sendData);
		sendData.put(SIGN, signStr);
	}
}
