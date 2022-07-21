//package cn.com.yusys.yusp.uimp.base.app.uaa.service;
//
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//
//import javax.sql.DataSource;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import cn.com.yusys.yusp.commons.mapper.CommonMapper;
//import cn.com.yusys.yusp.commons.service.CommonService;
//import cn.com.yusys.yusp.commons.util.StringUtil;
//import cn.com.yusys.yusp.uimp.base.app.config.MessageContants;
//import cn.com.yusys.yusp.uimp.base.app.uaa.domain.PmaFappUserCaptcha;
//import cn.com.yusys.yusp.uimp.base.app.uaa.repository.mapper.PmaFappUserCaptchaMapper;
//
///**
// * @项目名称: yscrm-base-core模块
// * @类名称: AppMessageService
// * @类描述: # APP用户验证码 服务类
// * @功能描述:
// * @创建人: lixt1
// * @创建时间: 2019-05-13 09:49:01
// * @修改备注:
// * @修改记录: 修改时间    修改人员    修改原因
// * -------------------------------------------------------------
// * @version 1.0.0
// * @Copyright (c) 2017宇信科技-版权所有
// */
//@Service
//public class AppMessageService extends CommonService {
//
//    @Autowired
//    private PmaFappUserCaptchaMapper pmaFappUserCaptchaMapper;
//
//	@Autowired
//	DataSource dataSource;
//
//    @Override
//    protected CommonMapper<?> getMapper() {
//        return pmaFappUserCaptchaMapper;
//    }
//
//    /**
//     * @方法名称: sendMessage
//     * @方法描述: 发送短信验证码
//     * @参数与返回说明:
//     * @param param:
//     *   type: register/forget/replace 注册前发送/忘记密码/更换手机号  必输
//     *   userInfo: 身份证号/护照号/工号
//     *   userId: 用户编号
//     *   mobilephone: 手机号 必输
//     * @return  0发送成功  -1短信发送失败  -2异常  -3无对应用户  -9参数错误
//     * @算法描述:
//     * register: 注册前发送
//     *    1、根据 身份信息、手机号，从sm_user中找到对应的用户编号userId
//     *    2、不存在userId，返回 '身份证号/护照号/工号有误，请联系管理员修改您的信息'
//     *    3、存在userId，生成4位短信验证码，调用短信发送接口
//     *    4、短信发送失败，返回 '短信发送失败，请稍后重试'
//     *    5、短息发送成功，向APP用户短信验证码表中插入数据，并返回 用户编号、验证码数据
//     * forget: 忘记密码
//     *    1、根据 手机号，从sm_user中查找是否存在对应用户
//     *    2、不存在，返回  '未找到对应用户'
//     *    3、存在userId，生成4位短信验证码，调用短信发送接口
//     *    4、短信发送失败，返回 '短信发送失败，请稍后重试'
//     *    5、短息发送成功，向APP用户短信验证码表中插入数据，并返回 用户编号、验证码数据
//     * replace: 更换手机号
//     *    1、存在userId，生成4位短信验证码，调用短信发送接口
//     *    2、短信发送失败，返回 '短信发送失败，请稍后重试'
//     *    3、短息发送成功，向APP用户短信验证码表中插入数据，并返回 用户编号、验证码数据
//     */
////    public Map<String, String> sendCaptcha(Map<?, ?> param) {
////    	Map<String, String> resultMap = new HashMap<String, String>();
////    	Integer code = 0;
////    	String type = param.get("type") + "";
////    	String userId = param.get("userId") == null ? "" : param.get("userId") + "";
////    	String userInfo = param.get("userInfo") == null ? "" : param.get("userInfo") + "";
////    	String mobilephone = param.get("mobilephone") == null ? "" : param.get("mobilephone") + "";
////    	String captcha = makeCaptchaCode();	// 验证码
////    	if(StringUtil.isEmpty(mobilephone))
////    		code = -9;
////    	if("register".equals(type) && !StringUtil.isEmpty(userInfo)) {	// 注册前发送验证码
////    		userId = pmaFappUserCaptchaMapper.selectByUserInfo("", userInfo, mobilephone);
////    		if(StringUtil.isEmpty(userId)) {
////    			code = -3;
////    		} else {
////    			Boolean hasValid = false;
////    	    	String temp = pmaFappUserCaptchaMapper.selectValCaptcha(userId, MessageContants.EXPIRES_IN);
////    	    	if(StringUtil.isNotEmpty(temp)) {	// 如果存在 有效的验证码，直接使用该验证码发送短信，不更新 APP用户短信验证码表 数据
////    	    		hasValid = true;
////    	    		captcha = temp;
////    	    	}
////    			code = this.captchaModule(captcha, userId, mobilephone, hasValid);
////    		}
////    	} else if("forget".equals(type)) {	// 忘记密码
////    		String userIdTemp = pmaFappUserCaptchaMapper.selectByUserInfo("", "", mobilephone);
////    		if(StringUtil.isEmpty(userIdTemp)) {
////    			code = -3;
////    		} else {
////    			userId = userIdTemp;
////    			Boolean hasValid = false;
////    	    	String temp = pmaFappUserCaptchaMapper.selectValCaptcha(userId, MessageContants.EXPIRES_IN);
////    	    	if(StringUtil.isNotEmpty(temp)) {	// 如果存在 有效的验证码，直接使用该验证码发送短信，不更新 APP用户短信验证码表 数据
////    	    		hasValid = true;
////    	    		captcha = temp;
////    	    	}
////    			code = this.captchaModule(captcha, userIdTemp, mobilephone, hasValid);
////    		}
////    	} else if("replace".equals(type) && !StringUtil.isEmpty(userId)) {	// 更换手机号
////    		Boolean hasValid = false;
////        	String temp = pmaFappUserCaptchaMapper.selectValCaptcha(userId, MessageContants.EXPIRES_IN);
////        	if(StringUtil.isNotEmpty(temp)) {	// 如果存在 有效的验证码，直接使用该验证码发送短信，不更新 APP用户短信验证码表 数据
////        		hasValid = true;
////        		captcha = temp;
////        	}
////    		code = this.captchaModule(captcha, userId, mobilephone, hasValid);
////    	} else {
////    		code = -9;
////    	}
////    	resultMap.put("code", code + "");
////    	if(code == 0) {
////    		resultMap.put("userId", userId);
////    		resultMap.put("captcha", captcha);
////    		resultMap.put("expiresIn", MessageContants.EXPIRES_IN + "");
////    	}
////    	return resultMap;
////    }
//
//    /**
//     * 短信模块
//     *   1、根据userId查询 APP用户短信验证码表 中是否存在有效期内的数据?
//     *      如果存在，使用原验证码发送短信后，不更新该表数据；
//     *      如果不存在，使用新验证码发送短信后，更新该表数据。
//     *   2、根据验证码，生成短信内容
//     *   3、调用MessageSendUtil 发送短信
//     *   4、如果发送不成功，返回错误码
//     *   5、如果发送成功，判断验证码校验状态hasValid：如果不存在有效验证码，则向APP用户短信验证码表中插入数据；如果存在，不需要更新APP用户短信验证码表数据
//     * @param captcha 验证码
//     * @param userId  用户编号
//     * @param mobilephone  手机号
//     * @param hasValid 是否存在有效验证码数据
//     * @return  0发送成功  -1短信发送失败  -2异常
//     */
//    public Integer captchaModule(String captcha, String userId, String mobilephone, Boolean hasValid) {
////    	String content = this.makeMessageContent(captcha);
////    	Integer result = MessageSendUtil.sendMessage(dataSource, mobilephone, content);
////    	if(result != 0) {
////    		return result;
////    	}
////    	TODO 目前不能调短信接口，配合测试，加入如下代码； 以后放开上面注释，下面删掉
//    	Integer result = 0;
//
//    	if(!hasValid) {
//	    	try {
//	    		pmaFappUserCaptchaMapper.deleteByUserId(userId);
//	    		PmaFappUserCaptcha pmaFappUserCaptcha = new PmaFappUserCaptcha();
//	    		pmaFappUserCaptcha.setUserId(userId);
//	    		pmaFappUserCaptcha.setCaptcha(captcha);
//	    		pmaFappUserCaptcha.setSendTime(new Date());
//	    		pmaFappUserCaptchaMapper.insertSelective(pmaFappUserCaptcha);
//	    		result = 0;
//	    	} catch (Exception e) {
//	    		result = -2;
//	    		e.printStackTrace();
//	    	}
//    	}
//    	return result;
//    }
//
//    /**
//     * 生成 验证码-短信内容
//     * @param captchaCode
//     * @return 短信内容
//     */
//    public String makeMessageContent(String captchaCode) {
//    	// TODO 可以从数据库中获取验证码-短信模板内容
//    	return "验证码：" + captchaCode + ", 有效时间***";
//    }
//
//    /**
//     * 生成4位验证码
//     * @return 验证码
//     */
////    public static String makeCaptchaCode() {
////    	return Math.round(Math.random() * (9999-1000) +1000) + "";
////    }
//
//}
