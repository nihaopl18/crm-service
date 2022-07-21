//package cn.com.yusys.yusp.uimp.base.app.uaa.web.rest;
//
//import java.util.List;
//import java.util.Map;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestHeader;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import cn.com.yusys.yusp.commons.service.CommonService;
//import cn.com.yusys.yusp.commons.util.StringUtil;
//import cn.com.yusys.yusp.commons.web.rest.CommonResource;
//import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
//import cn.com.yusys.yusp.uimp.base.app.uaa.domain.APPUserModel;
//import cn.com.yusys.yusp.uimp.base.app.uaa.service.AppLoginService;
//import cn.com.yusys.yusp.uimp.base.app.uaa.service.AppRegisterService;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//
///**
// * @项目名称: yscrm-base-core模块
// * @类名称: AppResource
// * @类描述: # APP用户登录/实名认证 资源类
// * @功能描述: 
// * @创建人: lixt1
// * @创建时间: 2019-05-13 09:49:01
// * @修改备注: 
// * @修改记录: 修改时间    修改人员    修改原因
// * -------------------------------------------------------------
// * @version 1.0.0
// * @Copyright (c) 2017宇信科技-版权所有
// */
//@Api(tags = "移动端用户登录")
//@RestController
//@RequestMapping("/api/app/user")
//public class AppResource extends CommonResource<Object, String> {
//	
//	private final String AUTH_STR = "Basic d2ViX2FwcDo="; // 查询设备信息，header中Authorization固定值 web_app:
//
//	@Autowired
//    private AppLoginService appLoginService;
//	
//	@Autowired
//	private AppRegisterService appRegisterService;
//
//    @Override
//    protected CommonService getCommonService() {
//        return appLoginService;
//    }
//    
//    @ApiOperation(value = "获取验证码")
//    @PostMapping("/getCheckCode")
//    protected ResultDto<List<Map<String, Object>>> getCheckCode() {
//    	ResultDto<List<Map<String, Object>>> result = new ResultDto<List<Map<String, Object>>>();
//    	return result;
//    }
//    /**
//     * @函数名称: login
//     * @函数描述: APP登录
//     * @param param: 
//     *   deviceCode: 设备标识码
//     *   userInfo: 用户登录信息（工号/身份证号/护照号/手机号）
//     *   password: APP登录密码
//     * @参数与返回说明:
//     * @算法描述:
//     */
////    @ApiOperation(value = "用户登录")
////    @PostMapping("/login")
////    protected ResultDto<Map<String, Object>> login(@RequestBody Map<?, ?> param) {
////    	ResultDto<Map<String, Object>> result = new ResultDto<Map<String, Object>>();
////    	//@RequestHeader(value = "Authorization") String auth,
////		if(StringUtil.isNotBlank(param.get("Authorization").toString())&&AUTH_STR.equals(param.get("Authorization").toString()) && StringUtil.isNotBlank(param.get("username").toString())) {
////			result=appLoginService.loginVerify(param);
////    	} else {
////    		result.setCode(-1);
////   		  	result.setMessage("请求参数错误! ");
////    	}
////    	return result;
////    }
//    /**
//     * @函数名称: checkByUserInfoDevice
//     * @函数描述: APP登录前，校验用户是否已注册、是否换设备登录
//     * @param param: 
//     *   deviceCode: 设备标识码
//     *   userInfo: 用户登录信息（工号/身份证号/护照号/手机号）
//     *   password: APP登录密码
//     * @参数与返回说明:
//     * @算法描述:
//     */
//    @PostMapping("/checkbyuserinfodevice")
//    protected ResultDto<List<Map<String, Object>>> checkByUserInfoDevice(@RequestHeader("Authorization") String auth, @RequestBody Map<?, ?> param) {
//    	ResultDto<List<Map<String, Object>>> result = new ResultDto<List<Map<String, Object>>>();
//    	Map<String, Object> resultMap = null;
//    	Integer code = 0;
//    	// 校验必输项 && param.get("deviceCode") != null && !StringUtil.isEmpty(param.get("deviceCode") + "") 
//		if(AUTH_STR.equals(auth) && 
//				param.get("userInfo") != null && !StringUtil.isEmpty(param.get("userInfo") + "") && 
//				param.get("password") != null && !StringUtil.isEmpty(param.get("password") + "")) {
//    		resultMap = appRegisterService.checkByUserInfoDevice(param);
//    		code = Integer.parseInt(resultMap.get("code") + "");
//    		if(code == 0) {
//    			result.setCode(0);
//       		  	result.setMessage("操作成功！");
//       		  	result.setData((List<Map<String, Object>>) resultMap.get("data"));
//        	} else {
//        		if(code == -2) {
//        			result.setCode(-2);
//        			result.setMessage("服务器忙，请稍后重试！");
//        		} else if(code == -3) {
//        			result.setCode(-3);
//        			result.setMessage("用户信息不存在或密码错误");
//        		} else if(code == -4) {
//        			result.setCode(-4);
//        			result.setMessage("首次登录，请去pc端设置登录密码");
//        		//	result.setMessage("用户未注册");  by wangcq
//        		} else if(code == -5) {
//        			result.setCode(-5);
//        			result.setMessage("用户换设备登录");
//        			result.setData((List<Map<String, Object>>) resultMap.get("data"));
//        		} else if(code == -9) {
//        			result.setCode(-9);
//        			result.setMessage("请求参数错误! ");
//        		}
//        	}
//    	} else {
//    		result.setCode(-9);
//   		  	result.setMessage("请求参数错误! ");
//    	}
//    	return result;
//    }
//    
//    /**
//     * @函数名称: register
//     * @函数描述: 实名认证接口
//     * @param param: 
//     *   userId: 用户编号
//     *   userModel<T>: 注册用户数据模型:
//     *     userModel.deviceInfo 设备信息数据
//     *     userModel.passwordInfo 密码信息数据
//     * @参数与返回说明:
//     * @算法描述:
//     */
//    @PostMapping("/register")
//    protected ResultDto<APPUserModel> register(@RequestBody Map<?, ?> param) {
//    	ResultDto<APPUserModel> result = new ResultDto<APPUserModel>();
//    	Map<String, Object> resultMap = null;
//    	Integer code = 0;
//    	// 校验必输项
//		if(param.get("userId") != null && !StringUtil.isEmpty(param.get("userId") + "") &&
//				param.get("userModel") != null) {
//    		resultMap = appRegisterService.register(param);
//    		code = Integer.parseInt(resultMap.get("code") + "");
//    		if(code == 0) {
//    			result.setCode(0);
//       		  	result.setMessage("操作成功！");
//       		  	result.setData((APPUserModel) resultMap.get("userModel"));
//        	} else {
//        		if(code == -2) {
//        			result.setCode(-2);
//        			result.setMessage("服务器忙，请稍后重试！");
//        		} else if(code == -3) {
//        			result.setCode(-3);
//        			result.setMessage(resultMap.get("message") + "");
//        		} else if(code == -9) {
//        			result.setCode(-9);
//        			result.setMessage("请求参数错误! ");
//        		}
//        	}
//    	} else {
//    		result.setCode(-9);
//   		  	result.setMessage("请求参数错误! ");
//    	}
//    	return result;
//    }
//    
//    /**
//     * @函数名称: updatePassword
//     * @函数描述: APP用户密码修改接口
//     * @param param: 
//     *   userId: 用户编号  必输
//     *   password: 登录密码
//     *   patternLock: 手势密码
//     * @参数与返回说明:
//     * @算法描述:
//     */
//    @PostMapping("/updatepassword")
//    protected ResultDto<String> updatePassword(@RequestBody Map<?, ?> param) {
//    	ResultDto<String> result = new ResultDto<String>();
//    	Map<String, Object> resultMap = null;
//    	Integer code = 0;
//    	// 校验必输项
//		if(param.get("userId") != null && !StringUtil.isEmpty(param.get("userId") + "")) {
//    		resultMap = appRegisterService.updatePassword(param);
//    		code = Integer.parseInt(resultMap.get("code") + "");
//    		if(code == 0) {
//    			result.setCode(0);
//       		  	result.setMessage("操作成功！");
//        	} else {
//        		if(code == -2) {
//        			result.setCode(-2);
//        			result.setMessage("服务器忙，请稍后重试！");
//        		} else if(code == -3) {
//        			result.setCode(-3);
//        			result.setMessage("无对应用户！");
//        		} else if(code == -9) {
//        			result.setCode(-9);
//        			result.setMessage("请求参数错误! ");
//        		}
//        	}
//    	} else {
//    		result.setCode(-9);
//   		  	result.setMessage("请求参数错误! ");
//    	}
//    	return result;
//    }
//    
//    /**
//     * @函数名称: queryPatternLock
//     * @函数描述: APP查询 手势密码
//     * @param param: 
//     *   userId: 用户编号
//     * @参数与返回说明:
//     * @算法描述:
//     */
//    @PostMapping("/querypatternlock")
//    protected ResultDto<Map<String, Object>> queryPatternLock(@RequestBody Map<?, ?> param) {
//    	ResultDto<Map<String, Object>> result = new ResultDto<Map<String, Object>>();
//    	Map<String, Object> resultMap = null;
//    	Integer code = 0;
//    	// 校验必输项
//		if(param.get("userId") != null && !StringUtil.isEmpty(param.get("userId") + "")) {
//    		resultMap = appLoginService.queryPatternLock(param);
//    		code = Integer.parseInt(resultMap.get("code") + "");
//    		if(code == 0) {
//    			result.setCode(0);
//       		  	result.setMessage("操作成功！");
//       		  	result.setData((Map<String, Object>) resultMap.get("data"));
//        	} else {
//        		if(code == -2) {
//        			result.setCode(-2);
//        			result.setMessage("服务器忙，请稍后重试！");
//        		} else if(code == -3) {
//        			result.setCode(-3);
//        			result.setMessage("数据为空");
//        		} else if(code == -9) {
//        			result.setCode(-9);
//        			result.setMessage("请求参数错误! ");
//        		}
//        	}
//    	} else {
//    		result.setCode(-9);
//   		  	result.setMessage("请求参数错误! ");
//    	}
//    	return result;
//    }
//}
