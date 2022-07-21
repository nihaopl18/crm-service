//package cn.com.yusys.yusp.uimp.base.app.uaa.service;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import cn.com.yusys.yusp.commons.mapper.CommonMapper;
//import cn.com.yusys.yusp.commons.service.CommonService;
//import cn.com.yusys.yusp.uimp.base.app.config.MessageContants;
//import cn.com.yusys.yusp.uimp.base.app.uaa.repository.mapper.PmaFappPasswordMapper;
//import cn.com.yusys.yusp.uimp.base.app.uaa.repository.mapper.PmaFappUserCaptchaMapper;
//
///**
// * @项目名称: yscrm-base-core模块
// * @类名称: AppValidateService
// * @类描述: # APP验证 服务类，包括：用户登录密码、手势密码、短信验证码
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
//public class AppValidateService extends CommonService {
//
//    @Autowired
//    private PmaFappPasswordMapper pmaFappPasswordMapper;
//    
//    @Autowired
//    private PmaFappUserCaptchaMapper pmaFappUserCaptchaMapper;
//	
//    @Override
//    protected CommonMapper<?> getMapper() {
//        return pmaFappPasswordMapper;
//    }
//    
//    /**
//     * @方法名称: validatePassword
//     * @方法描述: 验证 用户登录密码/手势密码
//     * @参数与返回说明: 
//     * @param param: 
//     *   type: 1/2 验证登录密码/验证手势密码
//     *   userId: 用户编号
//     *   password: 密码信息（登录密码或手势密码）
//     * @算法描述: 无
//     */
//    public Integer validatePassword(Map<?, ?> param) {
//    	Integer code = 0;
//    	try {
//	    	String type = param.get("type") + "";
//	    	String userId = param.get("userId") == null ? "" : param.get("userId") + "";
//	    	String password = param.get("password") == null ? "" : param.get("password") + "";
//	    	List<Map<String, Object>> obj = pmaFappPasswordMapper.queryPatternLock(userId);
//	    	if("1".equals(type)) {	// 验证登录密码
//	    		code = pmaFappPasswordMapper.selectByParams(userId, password, "", "", "");
//	    	} else if("2".equals(type)) {	// 验证手势密码
//	    		code = pmaFappPasswordMapper.selectByParams(userId, "", password, "", "");
//	    	} else {
//	    		code = -9;
//	    	}
//    	} catch (Exception e) {
//    		code = -1;
//    		e.printStackTrace();
//    	}
//    	return code;
//    }
//    /**
//     * @方法名称: ifpatternLock
//     * @方法描述: 判断是否设置过手势密码
//     * @参数与返回说明: 
//     * @param param: 
//     *   userId: 用户编号
//     * @算法描述: 无
//     */
//    public Integer ifpatternLock(Map<?, ?> param) {
//    	Integer code = 0;
//    	try {
//	    	String userId = param.get("userId") == null ? "" : param.get("userId") + "";
//	    	List<Map<String, Object>> obj = pmaFappPasswordMapper.queryPatternLock(userId);
//	    	//判断是否为空，如果为空，说明设置过手势密码，返回0 ，如果有值，返回1
//	    	code = obj.get(0).get("patternLock") == null?0:1;
//    	} catch (Exception e) {
//    		code = -1;
//    		e.printStackTrace();
//    	}
//    	return code;
//    }
//    
//    /**
//     * @方法名称: validateCaptcha
//     * @方法描述: 验证 短信验证码
//     * @参数与返回说明: 
//     * @param param: 
//     *   userId: 用户编号  必输
//     *   captcha: 短信验证码 必输
//     * @算法描述: 无
//     */
//    public Map<String, Object> validateCaptcha(Map<?, ?> param) {
//    	Map<String, Object> resultMap = new HashMap<String, Object>();
//    	Integer code = 0;
//    	try {
//	    	String userId = param.get("userId") == null ? "" : param.get("userId") + "";
//	    	String captcha = param.get("captcha") == null ? "" : param.get("captcha") + "";
//    		code = pmaFappUserCaptchaMapper.validateCaptcha(userId, captcha, MessageContants.EXPIRES_IN);
//    		if(code == 1) {
//    			List<Map<String, Object>> list = pmaFappUserCaptchaMapper.validCaptchaRep(userId);
//    			resultMap.put("data", list.get(0));
//    		}
//    	} catch (Exception e) {
//    		code = -1;
//    		e.printStackTrace();
//    	}
//    	resultMap.put("code", code);
//    	return resultMap;
//    }
//}
