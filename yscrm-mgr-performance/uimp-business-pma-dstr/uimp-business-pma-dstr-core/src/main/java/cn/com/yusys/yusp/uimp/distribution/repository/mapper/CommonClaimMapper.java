package cn.com.yusys.yusp.uimp.distribution.repository.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.github.pagehelper.Page;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.uimp.claim.domain.PmaFCdpInfo;

/**
 * @项目名称: uimp-business-pma-dstr-core模块
 * @类名称: PmaFCdpInfoMapper
 * @类描述: #Dao类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2020-06-30 16:02:45
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
public interface CommonClaimMapper extends CommonMapper<PmaFCdpInfo> {

	void executeInsertSql(@Param("sqlStr")String sqlStr);

	List<Map<String, Object>> executeQuerySql(@Param("sqlStr")String sqlStr);

	/**
	 * @方法名称: queryList
	 * @方法描述: 列表查询
	 * @参数与返回说明: 
	 * @算法描述: 
	 */
	Page<Map<String, Object>> queryList (@Param("sqlStr") String sqlStr, QueryModel queryModel);
	
}