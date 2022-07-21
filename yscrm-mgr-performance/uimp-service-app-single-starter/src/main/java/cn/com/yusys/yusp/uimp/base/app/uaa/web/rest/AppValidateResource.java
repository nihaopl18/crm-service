//package cn.com.yusys.yusp.uimp.base.app.uaa.web.rest;
//
//import java.util.Map;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import cn.com.yusys.yusp.commons.service.CommonService;
//import cn.com.yusys.yusp.commons.util.StringUtil;
//import cn.com.yusys.yusp.commons.web.rest.CommonResource;
//import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
//import cn.com.yusys.yusp.uimp.base.app.uaa.service.AppValidateService;
//
///**
// * @项目名称: yscrm-base-core模块
// * @类名称: AppValidateResource
// * @类描述: # APP验证 资源类，包括：用户登录密码、手势密码、短信验证码
// * @功能描述: 
// * @创建人: lixt1
// * @创建时间: 2019-05-13 09:49:01
// * @修改备注: 
// * @修改记录: 修改时间    修改人员    修改原因
// * -------------------------------------------------------------
// * @version 1.0.0
// * @Copyright (c) 2017宇信科技-版权所有
// */
//@RestController
//@RequestMapping("/api/app/validate")
//public class AppValidateResource extends CommonResource<Object, String> {
//
//	@Autowired
//    private AppValidateService appValidateService;
//
//    @Override
//    protected CommonService getCommonService() {
//        return appValidateService;
//    }
//
//    /**
//     * @函数名称: validatePassword
//     * @函数描述: 验证 用户登录密码/手势密码
//     * @param param: 
//     *   type: 1/2 验证登录密码/验证手势密码  必输
//     *   userId: 用户编号  必输
//     *   password: 密码信息（登录密码或手势密码）
//     * @参数与返回说明:
//     * @算法描述:
//     */
//    @PostMapping("/password")
//    protected ResultDto<String> validatePassword(@RequestBody Map<?, ?> param) {
//    	ResultDto<String> result = new ResultDto<String>();
//    	Integer code = 0;
//    	// 校验必输项
//    	if(param.get("type") != null && !StringUtil.isEmpty(param.get("type") + "") &&
//    			param.get("userId") != null && !StringUtil.isEmpty(param.get("userId") + "")) {
//    		code = appValidateService.validatePassword(param);
//    		if(code == 1) {
//    			result.setCode(0);
//       		  	result.setMessage("验证成功！");
//        	} else {
//        		if(code == -1) {
//        			result.setCode(-2);
//        			result.setMessage("服务器忙，请稍后重试！");
//        		} else if(code == -9) {
//        			result.setCode(-9);
//        			result.setMessage("请求参数错误! ");
//        		} else {
//        			result.setCode(-1);
//        			result.setMessage("验证失败！");
//        		} 
//        	}
//    	} else {
//    		result.setCode(-9);
//   		  	result.setMessage("not find type in requestBody! ");
//    	}
//    	return result;
//    }
//    
//    /**
//     * @函数名称: ifpatternLock
//     * @函数描述: 判断是否设置过手势密码
//     * @param param: 
//     *   userId: 用户编号  必输
//     * @参数与返回说明:
//     * @算法描述:
//     */
//    @PostMapping("/ifpatternLock")
//    protected ResultDto<String> ifpatternLock(@RequestBody Map<?, ?> param) {
//    	ResultDto<String> result = new ResultDto<String>();
//    	Integer code = 0;
//    	// 校验必输项
//    	if(param.get("userId") != null && !StringUtil.isEmpty(param.get("userId") + "")) {
//    		code = appValidateService.ifpatternLock(param);
//    		if(code == 1) {
//    			result.setCode(1);
//       		  	result.setMessage("验证成功！");
//        	} else if(code == 0){
//        			result.setCode(0);
//        			result.setMessage("您未设置该密码，请设置后用此方式登录! ");
//        	
//        	}
//    	} else {
//    		result.setCode(-9);
//   		  	result.setMessage("not find type in requestBody! ");
//    	}
//    	return result;
//    }
//    
//    /**
//     * @函数名称: validateCaptcha
//     * @函数描述: 验证 短信验证码
//     * @param param: 
//     *   userId: 用户编号  必输
//     *   captcha: 短信验证码 必输
//     * @参数与返回说明:
//     * @算法描述:
//     */
//    @PostMapping("/smsCaptcha")
//    protected ResultDto<Map<String, Object>> validateCaptcha(@RequestBody Map<?, ?> param) {
//    	ResultDto<Map<String, Object>> result = new ResultDto<Map<String, Object>>();
//    	Integer code = 0;
//    	// 校验必输项
//    	if(param.get("userId") != null && !StringUtil.isEmpty(param.get("userId") + "") &&
//    			param.get("captcha") != null && !StringUtil.isEmpty(param.get("captcha") + "")) {
//    		Map<String, Object> resultMap = appValidateService.validateCaptcha(param);
//    		code = Integer.parseInt(resultMap.get("code") + "");
//    		if(code == 1) {
//    			result.setCode(0);
//       		  	result.setMessage("验证成功！");
//       		  	result.setData((Map<String, Object>) resultMap.get("data"));
//        	} else {
//        		if(code == 0) {
//        			result.setCode(-1);
//        			result.setMessage("验证码输入不正确或验证码超时！");
//        		} else if(code == -1) {
//        			result.setCode(-2);
//        			result.setMessage("服务器忙，请稍后重试！");
//        		}
//        	}
//    	} else {
//    		result.setCode(-9);
//   		  	result.setMessage("请求参数错误! ");
//    	}
//    	return result;
//    }
//}
