package cn.com.yusys.yusp.uimp.bonus.repository.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.uimp.bonus.domain.PmaFbonusPoolInfo;

/**
 * @项目名称: uimp-business-pma-dstr-core模块
 * @类名称: PmaFbonusPoolInfoMapper
 * @类描述: #二次分配奖金池信息表 Dao类
 * @功能描述: 
 * @创建人: lixt1
 * @创建时间: 2020-08-06 10:24:27
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public interface PmaFbonusPoolInfoMapper extends CommonMapper<PmaFbonusPoolInfo> {
	
	/**
     * @方法名称: queryBonusPoolInfo
     * @方法描述: 分页查询-二次分配奖金池信息数据
     * @参数与返回说明:
     * @算法描述:
     */
	List<Map<String, Object>> queryBonusPoolInfo(QueryModel queryModel);

    /**
     * @方法名称: queryBonusPoolInfoByStatDateAndOrgId
     * @方法描述: 根据数据日期、机构ID，查询-二次分配奖金池信息数据
     * @参数与返回说明:
     * @算法描述:
     */
	PmaFbonusPoolInfo queryBonusPoolInfoByStatDateAndOrgId(@Param("statDate") String statDate, @Param("orgId") String orgId);
}