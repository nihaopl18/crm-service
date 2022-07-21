package cn.com.yusys.yusp.uimp.bonus.repository.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.uimp.bonus.domain.PmaFsedBonusAltList;

/**
 * @项目名称: uimp-business-pma-dstr-core模块
 * @类名称: PmaFsedBonusAltListMapper
 * @类描述: #员工奖金二次分配明细表 Dao类
 * @功能描述: 
 * @创建人: lixt1
 * @创建时间: 2020-08-06 10:25:09
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public interface PmaFsedBonusAltListMapper extends CommonMapper<PmaFsedBonusAltList> {
	
	/**
     * @方法名称: queryBonusAltList
     * @方法描述: 查询-分配明细数据
     * @参数与返回说明:
     * @算法描述:
     */
	List<Map<String, Object>> queryBonusAltList(@Param("statDate") String statDate, @Param("orgId") String orgId);
	
    /**
     * @方法名称: deleteBonusAltByIds
     * @方法描述: 根据id 批量删除分配明细表数据
     * @参数与返回说明:
     * @算法描述:
     */
	Integer deleteBonusAltByIds(@Param("idArr") String[] idArr);
	
	/**
     * @方法名称: deleteBonusAltListByStatDateAndOrgId
     * @方法描述: 根据数据日期、机构ID-删除奖金池分配明细数据
     * @参数与返回说明:
     * @算法描述:
     */
	Integer deleteBonusAltListByStatDateAndOrgId(@Param("statDate") String statDate, @Param("orgId") String orgId);

	/**
     * @方法名称: batchInsert
     * @方法描述: 批量新增奖金池分配明细数据
     * @参数与返回说明:
     * @算法描述:
     */
	Integer batchInsert(@Param("statDate") String statDate, @Param("orgId") String orgId, 
			@Param("loginCode") String loginCode, @Param("operTime") String operTime,
			@Param("dataList") List<PmaFsedBonusAltList> dataList);
}