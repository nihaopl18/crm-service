package cn.com.yusys.yusp.admin.repository.mapper;

import cn.com.yusys.yusp.uaa.domain.UaaMenuContrDataConfig;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @项目名称: yusp-admin
 * @类名称: UaaMenuContrDataConfigMapper
 * @类描述: 菜单配置DAO层
 * @功能描述:
 * @创建人: weimei1@yusys.com.cn
 * @创建时间: 2017-12-23 10:25
 * @修改备注:
 * @修改记录: 修改时间 修改人员 修改原因
 *        -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public interface UaaMenuContrDataInfoMapper {

    /**
     * @方法名称:selectMenuTree
     * @方法描述:菜单树初始化查询
     * @参数与返回说明:
     * @算法描述:
     */
    List<UaaMenuContrDataConfig> selectMenuTree(@Param("loginCode") String loginCode, @Param("sysId") String sysId,@Param("roleId") String roleId);

    /**
     * @方法名称:selectMenuTree
     * @方法描述:菜单树初始化查询
     * @参数与返回说明:
     * @算法描述:
     */
    List<UaaMenuContrDataConfig> selectContrList(@Param("loginCode") String loginCode, @Param("sysId") String sysId ,@Param("roleId") String roleId);

    /**
     * @方法名称:selectDataContrList
     * @方法描述:数据权限初始化查询
     * @参数与返回说明:
     * @算法描述:
     */
    List<UaaMenuContrDataConfig> selectDataContrList(@Param("loginCode") String loginCode, @Param("sysId") String sysId, @Param("roleId") String roleId);


}
