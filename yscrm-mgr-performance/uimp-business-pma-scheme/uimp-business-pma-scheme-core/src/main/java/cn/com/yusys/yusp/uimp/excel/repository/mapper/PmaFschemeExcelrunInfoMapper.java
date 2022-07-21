package cn.com.yusys.yusp.uimp.excel.repository.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.uimp.excel.domain.PmaFschemeExcelrunInfo;

/**
 * @项目名称: uimp-business-pma-scheme-core模块
 * @类名称: PmaFschemeExcelrunInfoMapper
 * @类描述: #考核方案报表运行信息表 Dao类
 * @功能描述: 
 * @创建人: lixt1
 * @创建时间: 2020-05-25 14:49:29
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public interface PmaFschemeExcelrunInfoMapper extends CommonMapper<PmaFschemeExcelrunInfo> {
	
	/**
     * @函数名称:getRunInfoBySchemeIdAndEtlDate
     * @函数描述:根据考核方案ID、数据日期，查询考核方案报表运行信息表数据
     * @参数与返回说明:
     * @算法描述:
     */
	PmaFschemeExcelrunInfo getRunInfoBySchemeIdAndEtlDate(@Param("schemeId") String schemeId, @Param("etlDate") String etlDate);
	
	/**
     * @函数名称:getSchemeRunInfoList
     * @函数描述:考核方案运行状态信息列表查询接口
     * @参数与返回说明:
     * @param QueryModel 分页查询类
     * @算法描述:
     */
	List<Map<String,Object>> getSchemeRunInfoList(QueryModel queryModel);
	
	/**
     * @函数名称:getMySchemeInfoList
     * @函数描述:获取我的考核方案列表数据
     * @参数与返回说明:
     * @param QueryModel 分页查询类
     * @算法描述:
     */
	List<Map<String,Object>> getMySchemeInfoList(QueryModel queryModel);
	
	/**
     * @函数名称:getOrgStaffSchemeInfoList
     * @函数描述:获取机构辖内员工考核方案列表数据
     * @参数与返回说明:
     * @param QueryModel 分页查询类
     * @算法描述:
     */
	List<Map<String,Object>> getOrgStaffSchemeInfoList(QueryModel queryModel);
}