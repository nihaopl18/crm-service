package cn.com.yusys.yusp.uimp.base.app.uaa.repository.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.uimp.base.app.uaa.domain.APPUserModel;
import cn.com.yusys.yusp.uimp.base.app.uaa.domain.PmaFappDeviceInfo;

/**
 * @项目名称: yscrm-base-core模块
 * @类名称: PmaFappDeviceInfoMapper
 * @类描述: # APP设备信息表 Dao类
 * @功能描述: 
 * @创建人: lixt1
 * @创建时间: 2019-05-13 15:43:04
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public interface PmaFappDeviceMapper extends CommonMapper<PmaFappDeviceInfo> {
	
	/**
	 * @方法名称: queryByDevice
	 * @方法描述: 根据 设备标识码 查询 用户信息数据
	 * @参数与返回说明: 
	 * @param deviceCode 设备标识码
	 * @param userId 用户编号
	 * @算法描述: 无
	 */
	List<Map<String, Object>> queryByDevice(@Param("userId") String userId, @Param("deviceCode") String deviceCode);
	
	/**
	 * @方法名称: queryByUserId
	 * @方法描述: 根据 用户编号 查询 用户信息数据
	 * @参数与返回说明: 
	 * @param userId 用户编号
	 * @算法描述: 无
	 */
	List<Map<String, Object>> queryByUserId(@Param("userId") String userId);
	
	/**
	 * @方法名称: queryByUserInfo
	 * @方法描述: 根据 身份信息，查询对应用户编号
	 * ps: 其中身份信息代表如下业务数据的一种：
	 *    工号、身份证号、护照号、手机号
	 * @算法描述: 无
	 */
	List<String> queryByUserInfo(@Param("userInfo") String userInfo);
	
	/**
	 * @方法名称: selectByUserDeviceCode
	 * @方法描述: 根据 用户编号、设备标识码 查询启用的数据数量
	 * @参数与返回说明: 
	 * @param userId 用户编号
	 * @param deviceCode 设备标识码
	 * @param enableFlag 是否启用     1启用  0不启用
	 * @算法描述: 无
	 */
	Integer selectByUserDeviceCode(@Param("userId") String userId, @Param("deviceCode") String deviceCode, @Param("enableFlag") String enableFlag);

	/**
	 * @方法名称: queryByUserIdDeviceCode
	 * @方法描述: 根据 用户编号、设备标识码 查询 APP设备信息数据
	 * @参数与返回说明: 
	 * @param userId 用户编号
	 * @param deviceCode 设备标识码
	 * @算法描述: 无
	 */
	List<PmaFappDeviceInfo> queryByUserIdDeviceCode(@Param("userId") String userId, @Param("deviceCode") String deviceCode);
	
	/**
	 * @方法名称: deleteByUserIdDeviceCode
	 * @方法描述: 删除对应用户对应设备的数据
	 * @参数与返回说明: 
	 * @算法描述: 无
	 */
	Integer deleteByUserIdDeviceCode(@Param("userId") String userId, @Param("deviceCode") String deviceCode);
	
	/**
	 * @方法名称: selectByUserInfo
	 * @方法描述: 根据 身份信息及登录密码，查询对应用户编号
	 * ps: 其中身份信息代表如下业务数据的一种：
	 *    工号、身份证号、护照号、手机号
	 * @参数与返回说明: 
	 * @算法描述: 无
	 */
	List<String> selectByUserInfo(@Param("userInfo") String userInfo, @Param("password") String password);
	
	/**
     * @方法名称: updateFlag
     * @方法描述: 更新启用状态  - 根据 用户编号、设备号查询
     * @参数与返回说明: 
     * @算法描述: 无
     */
    int updateFlag(@Param("enableFlag") String enableFlag, @Param("userId") String userId, @Param("deviceCode") String deviceCode);
    
    
    /**
	 * @方法名称: selectDeviceCodeByUserId
	 * @方法描述: 根据 用户编号 查询设备号
	 * @参数与返回说明: 
	 * @算法描述: 无
	 */
    List<String> selectDeviceCodeByUserId(@Param("userId") String userId);
	
    /**
  	 * @方法名称: selectPwdByUserId
  	 * @方法描述: 根据 用户编号 查询是否设置登录密码
  	 * @参数与返回说明: 
  	 * @算法描述: 无
  	 */
    List<String> selectPwdByUserId(@Param("userId") String userId);
    
    /**
	 * @方法名称: queryAPPUserModel
	 * @方法描述: 根据 用户编号 查询用户信息
	 * @参数与返回说明: 
	 * @算法描述: 无
	 */
    APPUserModel queryAPPUserModel(@Param("userId") String userId);
    
    /**
	 * @方法名称: queryUserRoleList
	 * @方法描述: 根据 用户编号 查询用户角色信息
	 * @参数与返回说明: 
	 * @算法描述: 无
	 */
    List<Map<String, Object>> queryUserRoleList(@Param("userId") String userId);
}