package cn.com.yusys.yusp.uimp.base.app.uaa.repository.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.uimp.base.app.uaa.domain.PmaFappUserCaptcha;

/**
 * @项目名称: yscrm-base-core模块
 * @类名称: PmaFappUserCaptchaMapper
 * @类描述: # APP用户短信验证码表 Dao类
 * @功能描述: 
 * @创建人: lixt1
 * @创建时间: 2019-05-13 15:43:55
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public interface PmaFappUserCaptchaMapper extends CommonMapper<PmaFappUserCaptcha> {
	
	/**
	 * @方法名称: validateCaptcha
	 * @方法描述: 根据用户编号，验证短信验证码
	 * @参数与返回说明: 
	 * @算法描述: 无
	 */
	Integer validateCaptcha(@Param("userId") String userId, @Param("captcha") String captcha, @Param("expiresIn") Integer expiresIn);
	
	/**
	 * @方法名称: selectByUserInfo
	 * @方法描述: 根据 用户编号、身份信息及手机号，查询对应用户编号
	 * ps: 其中身份信息代表如下业务数据的一种：
	 *    员工号、身份证号、护照号
	 * @参数与返回说明: 
	 * @算法描述: 无
	 */
	String selectByUserInfo(@Param("userId") String userId, @Param("userInfo") String userInfo, @Param("mobilephone") String mobilephone);
	
	/**
	 * @方法名称: deleteByUserId
	 * @方法描述: 删除对应用户的验证码信息数据
	 * @参数与返回说明: 
	 * @算法描述: 无
	 */
	Integer deleteByUserId(@Param("userId") String userId);
	
	/**
	 * @方法名称: selectValCaptcha
	 * @方法描述: 查询 有效期内 验证码 ，根据用户编号userId、有效期expiresIn
	 * @参数与返回说明: 
	 * @算法描述: 无
	 */
	String selectValCaptcha(@Param("userId") String userId, @Param("expiresIn") Integer expiresIn);
	
	/**
	 * @方法名称: validCaptchaRep
	 * @方法描述: 验证码验证成功后，查询用户数据返回
	 * @参数与返回说明: 
	 * @算法描述: 无
	 */
	List<Map<String, Object>> validCaptchaRep(@Param("userId") String userId);
}