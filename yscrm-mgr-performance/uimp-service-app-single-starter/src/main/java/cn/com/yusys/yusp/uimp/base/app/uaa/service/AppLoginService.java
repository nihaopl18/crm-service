//package cn.com.yusys.yusp.uimp.base.app.uaa.service;
//
//import java.lang.reflect.Field;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import org.apache.commons.beanutils.BeanMap;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import cn.com.yusys.yusp.admin.domain.AdminSmUser;
//import cn.com.yusys.yusp.admin.repository.mapper.AdminSmUserMapper;
//import cn.com.yusys.yusp.commons.mapper.CommonMapper;
//import cn.com.yusys.yusp.commons.mapper.QueryModel;
//import cn.com.yusys.yusp.commons.service.CommonService;
//import cn.com.yusys.yusp.commons.util.StringUtil;
//import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
//import cn.com.yusys.yusp.uaa.service.PasswordStrategyService;
//import cn.com.yusys.yusp.uimp.base.app.uaa.repository.mapper.PmaFappDeviceMapper;
//import cn.com.yusys.yusp.uimp.base.app.uaa.repository.mapper.PmaFappPasswordMapper;
//import cn.com.yusys.yusp.uimp.base.app.uaa.util.CommonUtils;
//import cn.com.yusys.yusp.uimp.base.service.UserInfoService;
//
///**
// * @项目名称: yscrm-base-core模块
// * @类名称: AppLoginService
// * @类描述: # APP用户登录 服务类
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
//public class AppLoginService extends CommonService {
//	
//    @Autowired
//    private PmaFappPasswordMapper pmaFappPasswordMapper;
//	@Autowired
//	private UserInfoService userInfoService;
//	@Autowired
//	private AdminSmUserMapper adminSmUserMapper;
//	@Autowired
//    private PasswordStrategyService passwordStrategyService;
//    @Autowired
//    private PmaFappDeviceMapper pmaFappDeviceInfoMapper;
//    /**
//     * @属性名称: SUCCESSFULLY_CHECKED
//     * @属性描述: 校验通过
//     * @since 1.0.0
//     */
//    private static final String SUCCESSFULLY_CHECKED = "1001";
//    @Override
//    protected CommonMapper<?> getMapper() {
//        return pmaFappPasswordMapper;
//    }
//    
//    /**
//     * @方法名称: loginAuthVerify
//     * @方法描述: 校验 登录密码、手势密码 接口
//     * @参数与返回说明: 
//     * @param param: 
//     *   type: patternLock/accountLock 校验手势密码/校验登录密码  必输
//     *   userId: 用户编号
//     *   patternLock: 手势密码 
//     *   deviceCode: 设备标识码
//     *   userInfo: 身份证号后6位/护照号/工号
//     *   passWd: 登录密码
//     * @return   0成功  -1密码错误  -2异常   -9参数错误
//     * @算法描述: 
//     *   patternLock:
//     *     1、根据 userId、patternLock，判断是否存在该用户
//     *     2、不存在，提示 '手势密码不正确'
//     *     3、存在，验证 userId、deviceCode 是否启用
//     *     4、无数据或不启用，更改用户对应启用设备
//     *   accountLock:
//     *     1、根据 userInfo、password，判断是否存在该用户
//	 *     2、不存在，提示 '用户名或密码不正确'
//	 *     3、存在，验证 userId、deviceCode 是否启用
//	 *     4、无数据或不启用，更改用户对应启用设备
//     */
//    public Map<String, Object> loginAuthVerify(Map<?, ?> param) {
//    	Map<String, Object> resultMap = new HashMap<String, Object>();
//    	Integer code = 0;
//    	try {
//    		String type = param.get("type") + "";
//    		if("patternLock".equals(type)) {	// 手势密码登录
//    			String userId = param.get("userId") == null ? "" : param.get("userId") + "";
//    			String patternLock = param.get("patternLock") == null ? "" : param.get("patternLock") + "";
//    			String deviceCode = param.get("deviceCode") == null ? "" : param.get("deviceCode") + "";
//    			Integer count = pmaFappPasswordMapper.selectByParams(userId, "", patternLock, "", "");
//    			if(count != 1) {
//    				code = -1;
//    				resultMap.put("message", "手势密码不正确!");
//    			} else {
//    				count = pmaFappDeviceInfoMapper.selectByUserDeviceCode(userId, deviceCode, "1");
//    				if(count != 1) {	// 没有对应启用设备的数据，需要更改启用设备
//    					pmaFappDeviceInfoMapper.updateFlag("0", userId, "");
//    					pmaFappDeviceInfoMapper.updateFlag("1", userId, deviceCode);
//    				} else {
//    					// 暂时不做操作
//    				}
//    			}
//    		} else if("accountLock".equals(type)) {	// 登录密码登录
//    			String userInfo = param.get("userInfo") == null ? "" : param.get("userInfo") + "";
//    			String passWd = param.get("passWd") == null ? "" : param.get("passWd") + "";
//    			String deviceCode = param.get("deviceCode") == null ? "" : param.get("deviceCode") + "";
//    			List<String> userIdList = pmaFappDeviceInfoMapper.selectByUserInfo(userInfo, passWd);
//    			if(userIdList.size() == 0) {
//    				code = -1;
//    				resultMap.put("message", "用户名或密码不正确!");
//    			} else {
//    				String userId = userIdList.get(0);
//    				Integer count = pmaFappDeviceInfoMapper.selectByUserDeviceCode(userId, deviceCode, "1");
//    				if(count != 1) {	// 没有对应启用设备的数据，需要更改启用设备
//    					pmaFappDeviceInfoMapper.updateFlag("0", userId, "");
//    					pmaFappDeviceInfoMapper.updateFlag("1", userId, deviceCode);
//    				} else {
//    					// 暂时不做操作
//    				}
//    			}
//    		} else {
//    			code = -9;
//    			resultMap.put("message", "请求失败");
//    		}
//	    } catch (Exception e) {
//			code = -2;
//			resultMap.put("message", "登录失败");
//			e.printStackTrace();
//		}
//    	resultMap.put("code", code);
//    	return resultMap;
//    }
//    
//    /**
//     * @方法名称: queryPatternLock
//     * @方法描述: APP查询 手势密码
//     * @参数与返回说明: 
//     * @param param: 
//     *   userId: 用户编号 必输
//     * @return   0成功  -2异常  -3数据为空  -9参数错误
//     * @算法描述: 
//	 *     1、根据 deviceCode 查询用户数据
//     */
//    public Map<String, Object> queryPatternLock(Map<?, ?> param) {
//    	Map<String, Object> resultMap = new HashMap<String, Object>();
//    	Integer code = 0;
//    	try {
//    		String userId = param.get("userId") == null ? "" : param.get("userId") + "";
//    		if(!StringUtil.isEmpty(userId)) {	// 校验必输项
//    			List<Map<String, Object>> resultList = pmaFappPasswordMapper.queryPatternLock(userId);
//    			if(resultList == null || resultList.size() == 0) {
//    				code = -3;
//    			} else {
//    				resultMap.put("data", resultList.get(0));
//    			}
//    		} else {
//    			code = -9;
//    		}
//    	} catch (Exception e) {
//    		code = -2;
//    		e.printStackTrace();
//    	}
//    	resultMap.put("code", code);
//    	return resultMap;
//    }
//
//	public ResultDto<Map<String, Object>> loginVerify(Map<?, ?> param) {
//		ResultDto<Map<String, Object>> result = new ResultDto<Map<String, Object>>();
//		String username =  param.get("username") == null ? "" : param.get("username").toString();
//		String password =  param.get("password") == null ? "" : param.get("password").toString();
//		String patternLock =  param.get("patternLock") == null ? "" : param.get("patternLock").toString();
//		String fingerLock =  param.get("fingerLock") == null ? "" : param.get("fingerLock").toString();
//		String faceLock =  param.get("faceLock") == null ? "" : param.get("faceLock").toString();
//		
//		String msg = "{}不正确!";
//		QueryModel qm = new QueryModel();
//		qm.addCondition("loginCode", username);
//		if(passwordStrategyService.checkPwd(null, password, username).getCode().equals(SUCCESSFULLY_CHECKED)) {
//			result.setCode(0);
//			AdminSmUser asu = adminSmUserMapper.selectByModel(qm).get(0);
//			asu.setUserPassword("");
//			result.setData(CommonUtils.convertToMap(asu));
//		}else {
//			Integer count = pmaFappPasswordMapper.selectByParams(username, null, patternLock, fingerLock, faceLock);
//			if(count==0) {
//				if(!password.isEmpty()) {
//					msg=msg.replace("{}", "登录密码");
//				}else if(!patternLock.isEmpty()) {
//					msg=msg.replace("{}", "手势密码");
//				}else if(!fingerLock.isEmpty()) {
//					msg=msg.replace("{}", "指纹密码");
//				}else if(!faceLock.isEmpty()) {
//					msg=msg.replace("{}", "人脸识别");
//				}
//				result.setCode(-1);
//				result.setMessage(msg);
//			} else {
//				result.setCode(0);
//				AdminSmUser asu = adminSmUserMapper.selectByModel(qm).get(0);
//				asu.setUserPassword("");
//				result.setData(CommonUtils.convertToMap(asu));
//			}
//		}
//		
//		return result;
//		
//		
//	}
//}
