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
//import cn.com.yusys.yusp.uimp.base.app.uaa.service.AppMessageService;
//
///**
// * @项目名称: yscrm-base-core模块
// * @类名称: AppMessageResource
// * @类描述: # APP用户验证码 资源类
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
//@RequestMapping("/api/app/msg")
//public class AppMessageResource extends CommonResource<Object, String> {
//
//	@Autowired
//    private AppMessageService appMessageService;
//
//    @Override
//    protected CommonService getCommonService() {
//        return appMessageService;
//    }
//    
//    /**
//     * @函数名称: sendCaptcha
//     * @函数描述: 发送短信验证码
//     * @param param: 
//     *   type: register/forget/replace 注册前发送/忘记密码/更换手机号  必输
//     *   userInfo: 身份证号/护照号/工号
//     *   userId: 用户编号
//     *   mobilephone: 手机号
//     * @参数与返回说明:
//     * @算法描述:
//     */
//    @PostMapping("/sendcaptcha")
//    protected ResultDto<Map<String, String>> sendCaptcha(@RequestBody Map<?, ?> param) {
//    	ResultDto<Map<String, String>> result = new ResultDto<Map<String, String>>();
//    	Map<String, String> resultMap = null;
//    	Integer code = 0;
//    	// 校验必输项
//    	if(param.get("type") != null && !StringUtil.isEmpty(param.get("type") + "")) {
//    		resultMap = appMessageService.sendCaptcha(param);
//    		code = Integer.parseInt(resultMap.get("code"));
//    		if(code == 0) {
//    			result.setCode(0);
//       		  	result.setMessage("发送成功！");
//       		  	result.setData(resultMap);
//        	} else {
//        		if(code == -1) {
//        			result.setCode(-1);
//        			result.setMessage("短信发送失败！");
//        		} else if(code == -2) {
//        			result.setCode(-2);
//        			result.setMessage("服务器忙，请稍后重试！");
//        		} else if(code == -3) {
//        			result.setCode(-3);
//        			result.setMessage("无对应用户绑定该手机号！");
//        		}
//        		if(code == -9) {
//        			result.setCode(-9);
//        			result.setMessage("请求参数错误! ");
//        		}
//        	}
//    	} else {
//    		result.setCode(-9);
//   		  	result.setMessage("param is unvalid in requestBody! ");
//    	}
//    	return result;
//    }
//}
