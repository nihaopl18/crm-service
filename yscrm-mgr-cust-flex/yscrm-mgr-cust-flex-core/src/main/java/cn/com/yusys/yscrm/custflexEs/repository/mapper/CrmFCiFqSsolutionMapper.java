package cn.com.yusys.yscrm.custflexEs.repository.mapper;

import java.util.List;
import java.util.Map;

import cn.com.yusys.yscrm.custflexEs.domain.CrmFCiFqSsolution;
import org.apache.ibatis.annotations.Param;


import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;

/**
 * @项目名称: cmss-cust-mgt-core模块
 * @类名称: CrmFCiFqSsolutionMapper
 * @类描述: #数据集-查询方案 Dao类
 * @功能描述: 
 * @创建人: lixt1
 * @创建时间: 2021-01-02 13:04:37
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
public interface CrmFCiFqSsolutionMapper extends CommonMapper<CrmFCiFqSsolution> {

	List<Map<String, Object>> querySolutionList(QueryModel model);
/**
 *     通过创建人 加方案名称判断 当前方案是否存在 
 * @param ssName
 * @param loginCode
 * @return
 */
	List<CrmFCiFqSsolution> queryBySsName(@Param("ssName") String ssName,@Param("loginCode") String loginCode);

	Integer deleteBySsIds(@Param("ids") String[] ids);
	
}