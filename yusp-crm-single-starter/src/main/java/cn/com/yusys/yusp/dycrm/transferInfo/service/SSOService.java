package cn.com.yusys.yusp.dycrm.transferInfo.service;

import cn.com.yusys.yscrm.cust.person.util.CstRelInfQrySvcSrvBindingQSPortImpl;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.exception.YuspException;
import cn.com.yusys.yusp.dycrm.transferInfo.repository.mapper.AcrmFagTranDetailMapper;

import com.yusys.streaminghub.app.result.BizException;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

/**
 * @version 1.0.0
 * @项目名称: dycrm-transferInfo模块
 * @类名称: AcrmFCustAcctInfoService
 * @类描述: #服务类
 * @功能描述:
 * @创建人: lufl
 * @创建时间: 2021-09-02 16:47:01
 * @修改备注:
 * @修改记录: 修改时间 修改人员 修改原因
 *        -------------------------------------------------------------
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class SSOService extends CommonService {
	private static final Logger logger = Logger.getLogger(SSOService.class.getName());
	
	@Autowired
	private AcrmFagTranDetailMapper acrmFagTranDetailMapper;

	@Autowired
	RedisTemplate<String,String> redisTemplate;

	@Value("${shub.accessTokenManager.expire}")
	String accessTokenManagerExipre;
	@Override
	protected CommonMapper<?> getMapper() {
		return acrmFagTranDetailMapper;
	}

	public void ssologin(Map<String,String> request) {
		//解析参数
		logger.info("单点登录【请求参数】："+request);
		String userName = "admin";
				
		//调用SSO服务的接口验证是否合法
		logger.info("单点登录【token校验结果】："+request);
		
		//判断用户在系统中是否存在
		
		//获取系统token
		//getAccessToken();

		
		//跳转登录页面，并增加SSO登录的标识
		logger.info("单点登录【校验成功，跳转正常登录】："+request);

		
	}
	
	/**
	 * 获取token请求路径
	 * 
	 * @return
	 */
//	private String getUrl(HttpServletRequest request) {
//		String proc = request.getProtocol();
//		String ip = request.getLocalAddr();
//
//		if (proc.toLowerCase().contains("https")) {
//			proc = "https://";
//		}
//		if (proc.toLowerCase().contains("http")) {
//			proc = "http://";
//		}
//		if (StringUtils.isBlank(contextPath)) {
//			contextPath = "";
//		}
//		return proc + ip + ":" + port + contextPath + "/oauth/token";
//	}
	
	public String getAccessToken(String url, String username, String password,String unencodePWD) throws YuspException {
		String key = String.format("streaminghub:tokens:%s", DigestUtils.md5DigestAsHex(String.format("%s%s", username, unencodePWD).getBytes(StandardCharsets.UTF_8)));
		ValueOperations<String,String> operations=redisTemplate.opsForValue();
		String value=operations.get(key);
		if (value!=null) {
			return value;
		}
		CloseableHttpResponse response = null;
		CloseableHttpClient httpClient = null;
		try {
			httpClient = HttpClientBuilder.create().build();

			// 创建Post请求
			HttpPost httpPost = new HttpPost(url);
			httpPost.setHeader("Authorization", "Basic d2ViX2FwcDo=");// 固定值
			httpPost.setHeader("Content-Type", "application/x-www-form-urlencoded");// 固定值

			List<BasicNameValuePair> pair = new ArrayList<BasicNameValuePair>();
			pair.add(new BasicNameValuePair("username", username));// 调用方账号
			pair.add(new BasicNameValuePair("password", password));// 调用方密码
			pair.add(new BasicNameValuePair("grant_type", "password"));// 固定值
			pair.add(new BasicNameValuePair("passwordType", "2"));// 固定值
			pair.add(new BasicNameValuePair("sysId", null));// 所有请求都走相同验证流程：ErmWebLocationAuthVerify
			httpPost.setEntity(new UrlEncodedFormEntity(pair));// post请求是将参数放在请求体里面传过去的;这里将entity放入post请求体中

			response = httpClient.execute(httpPost);// 由客户端执行(发送)Post请求
			HttpEntity responseEntity = response.getEntity();// 从响应模型中获取响应实体

			logger.info("响应状态为:" + response.getStatusLine());
			if (responseEntity != null) {
				JSONObject result = JSONObject.parseObject(EntityUtils.toString(responseEntity));
				String accessToken =  result.getString("access_token");
				logger.info("accessToken:" + accessToken);
				long expire = StringUtils.isEmpty(accessTokenManagerExipre) ? 600000L : Long.valueOf(accessTokenManagerExipre);
				operations.set(key,accessToken,expire, TimeUnit.MILLISECONDS);
				return accessToken;
			}
		} catch (ClientProtocolException e) {
			logger.info("ACCESSTOKEN_FAIL_MSG");
		} catch (IOException e) {
			logger.info("ACCESSTOKEN_FAIL_MSG");
		} finally {
			try {
				// 释放资源
				if (httpClient != null) {
					httpClient.close();
				}
				if (response != null) {
					response.close();
				}
			} catch (IOException e) {
				logger.info("ACCESSTOKEN_FAIL_MSG");
			}
		}
		return null;
	}

}
