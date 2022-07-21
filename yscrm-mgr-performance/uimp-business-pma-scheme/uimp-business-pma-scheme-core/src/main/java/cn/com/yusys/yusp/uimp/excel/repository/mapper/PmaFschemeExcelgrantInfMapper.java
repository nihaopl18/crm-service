package cn.com.yusys.yusp.uimp.excel.repository.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.uimp.excel.domain.PmaFschemeExcelgrantInf;

/**
 * @项目名称: uimp-business-pma-scheme-core模块
 * @类名称: PmaFschemeExcelgrantInfMapper
 * @类描述: #考核方案授权信息表 Dao类
 * @功能描述: 
 * @创建人: lixt1
 * @创建时间: 2020-06-28 14:05:48
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public interface PmaFschemeExcelgrantInfMapper extends CommonMapper<PmaFschemeExcelgrantInf> {

	/**
     * @方法名称: getGrantInfBySchemeId
     * @方法描述: 根据考核方案ID，查询-方案授权信息
     * @参数与返回说明: 
     * @算法描述:
     */
	List<PmaFschemeExcelgrantInf> getGrantInfBySchemeId(QueryModel queryModel);

	/**
     * @方法名称: deleteData
     * @方法描述: 删除授权数据
     * @参数与返回说明: 
     * @算法描述:
     */
	Integer deleteData(@Param("ids") String[] ids);
	
	/**
     * @方法名称: checkData
     * @方法描述: 校验授权数据是否重复
     * @参数与返回说明: 
     * @算法描述:
     */
	Integer checkData(PmaFschemeExcelgrantInf record);

	/**
     * @方法名称: getQuoteSchemeInf
     * @方法描述: 根据机构号，查询可以引用的考核方案信息
     * @参数与返回说明: 
     * @算法描述:
     */
	List<PmaFschemeExcelgrantInf> getQuoteSchemeInf(QueryModel queryModel);
	
}