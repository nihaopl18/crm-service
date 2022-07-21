//package cn.com.yusys.yusp.uimp.base.app.uaa.service;
//
//import java.lang.reflect.Field;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import cn.com.yusys.yusp.commons.mapper.CommonMapper;
//import cn.com.yusys.yusp.commons.service.CommonService;
//import cn.com.yusys.yusp.commons.util.StringUtil;
//import cn.com.yusys.yusp.uimp.base.app.uaa.domain.APPUserModel;
//import cn.com.yusys.yusp.uimp.base.app.uaa.domain.PmaFappDeviceInfo;
//import cn.com.yusys.yusp.uimp.base.app.uaa.domain.PmaFappPassword;
//import cn.com.yusys.yusp.uimp.base.app.uaa.repository.mapper.PmaFappAgreementMapper;
//import cn.com.yusys.yusp.uimp.base.app.uaa.repository.mapper.PmaFappDeviceMapper;
//import cn.com.yusys.yusp.uimp.base.app.uaa.repository.mapper.PmaFappPasswordMapper;
//
///**
// * @项目名称: yscrm-base-core模块
// * @类名称: AppRegisterService
// * @类描述: # APP用户实名认证 服务类
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
//public class AppRegisterService extends CommonService {
//	
//	private static Logger logger = LoggerFactory.getLogger(AppLoginService.class);
//
//    @Autowired
//    private PmaFappPasswordMapper pmaFappPasswordMapper;
//
//    @Autowired
//    private PmaFappDeviceMapper pmaFappDeviceInfoMapper;
//    
//    @Autowired
//	private PmaFappAgreementMapper pmaFappAgreementMapper;
//    
//    @Override
//    protected CommonMapper<?> getMapper() {
//        return pmaFappPasswordMapper;
//    }
//    
//    /**
//     * @方法名称: checkByUserInfoDevice
//     * @方法描述: APP登录前，校验用户是否已注册、是否换设备登录
//     * @参数与返回说明: 
//     * @param param: 
//     *   deviceCode: 设备标识码 必输
//     *   userInfo: 用户登录信息（工号/身份证号/护照号/手机号）  必输
//     * @return   0成功  -2异常  -3用户信息不存在或密码错误  -4用户未注册  -5用户换设备登录   -9参数错误
//     * @算法描述: 
//     *   1、在用户表中根据 登录信息查询 用户编号USER_ID
//     *   2、在APP设备表中存在用户编号，但没有对应设备号，即 用户换设备登录
//     *   3、在APP设备表中不存在用户编号，即 用户未注册
//     *   4、在APP设备表中 用户编号、设备号 同时存在，即验证成功，允许直接登录
//     */
//    public Map<String, Object> checkByUserInfoDevice(Map<?, ?> param) {
//    	Map<String, Object> resultMap = new HashMap<String, Object>();
//    	Integer code = 0;
//    	try {
//    		//大连农商行只需要校验是否首次登录
//    		List<String> deviceCodeList = pmaFappDeviceInfoMapper.selectPwdByUserId( param.get("userInfo").toString());
//			if(deviceCodeList.size() == 0) {
//				code = -4;
//			}  else {	// 用户/设备已实名认证  返回关键数据
//				List<Map<String, Object>> resultList = pmaFappDeviceInfoMapper.queryByUserId( param.get("userInfo").toString());
//				resultMap.put("data", resultList);
//			}
//    	}catch (Exception e) {
//    		code = -2;
//    		e.printStackTrace();
//    		
//    	}
////    	try {
////    		String deviceCode = param.get("deviceCode") == null ? "" : param.get("deviceCode") + "";
////    		String userInfo = param.get("userInfo") == null ? "" : param.get("userInfo") + "";
////    		String password = param.get("password") == null ? "" : param.get("password") + "";
////    		if(!StringUtil.isEmpty(deviceCode) && !StringUtil.isEmpty(userInfo) && !StringUtil.isEmpty(password)) {	// 校验必输项
////    			List<String> userIdList = pmaFappDeviceInfoMapper.queryByUserInfo(userInfo);
////    			if(userIdList.size() == 0) {
////    				code = -3;
////    			} else {
////    				String userId = userIdList.get(0);
////    				List<String> deviceCodeList = pmaFappDeviceInfoMapper.selectDeviceCodeByUserId(userId);
////    				if(deviceCodeList.size() == 0) {
////    					code = -4;
////    				} else {
////    					// 校验APP用户登录密码
////    					List<String> userIdList2 = pmaFappDeviceInfoMapper.selectByUserInfo(userInfo, password);
////    					if(userIdList2.size() == 0) {
////    						code = -3;
////    					} else {
////    						if(!deviceCodeList.contains(deviceCode)) {
////    	    					code = -5;
////    	    					List<Map<String, Object>> resultList = pmaFappDeviceInfoMapper.queryByUserId(userId);
////    	    					resultMap.put("data", resultList);
////    	    				} else {	// 用户/设备已实名认证  返回关键数据
////    	    					List<Map<String, Object>> resultList = pmaFappDeviceInfoMapper.queryByDevice(userId, deviceCode);
////    	    					resultMap.put("data", resultList);
////    	    				}
////    					}
////    				}
////    			}
////    		} else {
////    			code = -9;
////    		}
////    	} catch (Exception e) {
////    		code = -2;
////    		e.printStackTrace();
////    	}
//    	resultMap.put("code", code);
//    	return resultMap;
//    }
//    
//    /**
//     * @方法名称: register
//     * @方法描述: 实名认证 接口
//     * @参数与返回说明: 
//     * @param param: 
//     *   userId: 用户编号 必输
//     *   deviceCode: 设备标识码 必输
//     *   userModel<T>: 注册用户数据模型: 必输
//     *     userModel.deviceInfo 设备信息数据
//     *     userModel.passwordInfo 密码信息数据
//     * @return   0成功  -2异常  -3重复实名认证  -9参数错误
//     * @算法描述: 
//	 *     1、根据 userId、deviceCode 查询是否存在数据
//	 *     2、存在 提示不允许重复认证
//	 *     3、不存在 新增 设备信息表、APP登录密码表数据
//	 *	   4、查询并返回用户信息
//     */
//    @Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
//    public Map<String, Object> register(Map<?, ?> param) {
//    	Map<String, Object> resultMap = new HashMap<String, Object>();
//    	Integer code = 0;
//    	try {
//    		String userId = param.get("userId") == null ? "" : param.get("userId") + "";
//    		String deviceCode = param.get("deviceCode") == null ? "" : param.get("deviceCode") + "";
//    		Map<String, Object> userModel = (Map<String, Object>) param.get("userModel");
//    		if(!StringUtil.isEmpty(userId)  && userModel.size() > 0) {	// 校验必输项 && !StringUtil.isEmpty(deviceCode)
//    			// 根据userId 判断是否重复认证
//    			Integer count = pmaFappDeviceInfoMapper.selectByUserDeviceCode(userId, deviceCode, "");
//    			if(count > 0) {
//    				code = -3;
//    				resultMap.put("message", "不允许重复认证!");
//    			} else {
//    				Integer re = this.registerModule(userId, deviceCode, userModel);
//    				if(re != 0) 
//    					code = re;
//    				else {
//    					APPUserModel APPUserModel = pmaFappDeviceInfoMapper.queryAPPUserModel(userId);
//    					List<Map<String, Object>> roleList = pmaFappDeviceInfoMapper.queryUserRoleList(userId);
//    					APPUserModel.setRoleList(roleList);
//    					resultMap.put("userModel", APPUserModel);
//    				}
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
//    /**
//     * 实名认证 模块
//     * @param userId 用户编号
//     * @param userModel 用户数据集
//     * @return
//     */
//    public Integer registerModule(String userId, String deviceCode, Map<String, Object> userModel) {
//    	Integer code = 0; 
//    	try {
//    		Map<String, Object> deviceInfoMap = userModel.get("deviceInfo") == null ? null : (Map<String, Object>) userModel.get("deviceInfo");
//    		Map<String, Object> passwordInfoMap = userModel.get("passwordInfo") == null ? null : (Map<String, Object>) userModel.get("passwordInfo");
//    		deviceInfoMap = null; // by wangcq  大连农商不需要，所以赋空值，以免保存报错
//    		if(deviceInfoMap != null) {
//    			PmaFappDeviceInfo pmaFappDeviceInfo = mapToObject(deviceInfoMap, PmaFappDeviceInfo.class);
//    			pmaFappDeviceInfo.setUserId(userId);
//        		pmaFappDeviceInfo.setDeviceCode(deviceCode);
//        		pmaFappDeviceInfo.setUpdateTime(new Date());
//        		pmaFappDeviceInfo.setEnableFlag("1");
//        		// 查询 APP用户安全保密协议 数据
//        		String agreementContent = pmaFappAgreementMapper.queryList();
//        		pmaFappDeviceInfo.setAgreementContent(agreementContent);
//        		// 新增APP设备信息、APP登录密码数据前，先删除相关数据
//        		pmaFappDeviceInfoMapper.deleteByUserIdDeviceCode(userId, deviceInfoMap.get("deviceCode") == null ? "" : deviceInfoMap.get("deviceCode") + "");
//        		pmaFappDeviceInfoMapper.insertSelective(pmaFappDeviceInfo);
//    		}
//    		if(passwordInfoMap != null) {
//    			PmaFappPassword pmaFappPassword = mapToObject(passwordInfoMap, PmaFappPassword.class);
//    			pmaFappPasswordMapper.deleteByUserId(userId);
//    			pmaFappPassword.setUserId(userId);
//    			pmaFappPassword.setCreateTime(new Date());
//        		pmaFappPasswordMapper.insertSelective(pmaFappPassword);
//    		}
//    	} catch (Exception e) {
//    		code = -2;
//    		e.printStackTrace();
//    	}
//    	return code;
//    }
//    
//    /**
//     * Map 映射 java bean对象
//     * @param map
//     * @param clazz
//     * @return  异常返回null
//     */
//    private static <T> T mapToObject(Map<String, Object> map, Class<T> clazz) {
//    	T cls = null;
//    	try {
//    		cls = clazz.newInstance();
//            for (Map.Entry<String, Object> entry : map.entrySet()) {
//                Field filed = clazz.getDeclaredField(entry.getKey());
//                filed.setAccessible(true);
//                filed.set(cls, entry.getValue() != null ? String.valueOf(entry.getValue()) : "");
//            }
//        } catch (Exception e) {
//        	e.printStackTrace();
//        }
//        return cls;
//    }
//    
//    /**
//     * @方法名称: updatePassword
//     * @方法描述: APP用户密码修改接口
//     * @参数与返回说明: 
//     * @param param: 
//     *   userId: 用户编号  必输
//     *   password: 登录密码
//     *   patternLock: 手势密码
//     * @return   0成功  -2异常  -3无对应用户  -9参数错误
//     * @算法描述: 
//     */
//    @Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
//    public Map<String, Object> updatePassword(Map<?, ?> param) {
//    	Map<String, Object> resultMap = new HashMap<String, Object>();
//    	Integer code = 0;
//    	try {
//    		String userId = param.get("userId") == null ? "" : param.get("userId") + "";
//    		String password = param.get("password") == null ? "" : param.get("password") + "";
//    		String patternLock = param.get("patternLock") == null ? "" : param.get("patternLock") + "";
//    		if(StringUtil.isEmpty(userId) || (StringUtil.isEmpty(password) && StringUtil.isEmpty(patternLock))) {
//    			code = -9;
//    		} else {
//    			Integer count = pmaFappPasswordMapper.selectByParams(userId, "", "", "", "");
//    			if(count == 0) {
//    				logger.warn("userId is not in table OCRM_F_APP_PASSWORD, userId is " + userId);
//    				code = -3;
//    			}
//    			else {
//    				pmaFappPasswordMapper.updatePassword(userId, password, patternLock);
//    			}
//    		}
//    	} catch (Exception e) {
//    		code = -2;
//    		e.printStackTrace();
//    	}
//    	resultMap.put("code", code);
//    	return resultMap;
//    }
//    
//}
