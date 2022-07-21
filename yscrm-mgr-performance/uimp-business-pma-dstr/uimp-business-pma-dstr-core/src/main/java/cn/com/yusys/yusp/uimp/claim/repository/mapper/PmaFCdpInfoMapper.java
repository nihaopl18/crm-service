package cn.com.yusys.yusp.uimp.claim.repository.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

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
public interface PmaFCdpInfoMapper extends CommonMapper<PmaFCdpInfo> {

	List<Map<String, Object>> querylist(QueryModel model);

	void executeInsertSql(@Param("sqlStr")String sqlStr);

	List<Map<String, Object>> executeQuerySql(@Param("sqlStr")String sqlStr);
	
}