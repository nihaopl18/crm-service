package cn.com.yusys.yusp.uimp.base.app.uaa.repository.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.uimp.base.app.uaa.domain.PmaFappPassword;

/**
 * @项目名称: yscrm-base-core模块
 * @类名称: PmaFappPasswordMapper
 * @类描述: # APP登录密码表 Dao类
 * @功能描述: 
 * @创建人: lixt1
 * @创建时间: 2019-05-13 15:43:26
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public interface PmaFappPasswordMapper extends CommonMapper<PmaFappPassword> {
	
	/**
	 * @方法名称: selectByParams
	 * @方法描述: 根据 用户编号、登录密码、手势密码、指纹密码、人脸密码查询
	 * @参数与返回说明: 
	 * @param userId 用户编号
	 * @param password 登录密码
	 * @param patternLock 手势密码
	 * @param fingerLock 指纹密码
	 * @param faceLock 人脸密码
	 * @算法描述: 无
	 */
	Integer selectByParams(@Param("userId") String userId, @Param("password") String password, 
			@Param("patternLock") String patternLock, @Param("fingerLock") String fingerLock, @Param("faceLock") String faceLock);

	/**
	 * @方法名称: deleteByUserId
	 * @方法描述: 删除对应用户对应APP登录密码数据
	 * @参数与返回说明: 
	 * @算法描述: 无
	 */
	Integer deleteByUserId(@Param("userId") String userId);
	
	/**
	 * @方法名称: updatePassword
	 * @方法描述: APP用户密码修改接口
	 * @参数与返回说明: 
	 * @算法描述: 无
	 */
	Integer updatePassword(@Param("userId") String userId, @Param("password") String password, @Param("patternLock") String patternLock);
	
	/**
	 * @方法名称: queryPatternLock
	 * @方法描述: 根据 用户编号 查询手势密码
	 * @参数与返回说明: 
	 * @param userId 用户编号
	 * @算法描述: 无
	 */
	List<Map<String, Object>> queryPatternLock(@Param("userId") String userId);

}