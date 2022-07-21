package cn.com.yusys.yusp.uimp.excel.repository.mapper;

import org.apache.ibatis.annotations.Param;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.uimp.excel.domain.PmaFschemeExcelhideInf;

/**
 * @项目名称: uimp-business-pma-scheme-core模块
 * @类名称: PmaFschemeExcelhideInfMapper
 * @类描述: #考核方案发布隐藏行列信息表 Dao类
 * @功能描述: 
 * @创建人: lixt1
 * @创建时间: 2020-05-27 15:17:46
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public interface PmaFschemeExcelhideInfMapper extends CommonMapper<PmaFschemeExcelhideInf> {
	
	/**
     * @函数名称:getHideInfoBySchemeIdAndEtlDate
     * @函数描述:根据考核方案ID、数据日期，查询考核方案报表发布隐藏行列信息表数据
     * @参数与返回说明:
     * @算法描述:
     */
	PmaFschemeExcelhideInf getHideInfoBySchemeIdAndEtlDate(@Param("schemeId") String schemeId, @Param("etlDate") String etlDate);
}