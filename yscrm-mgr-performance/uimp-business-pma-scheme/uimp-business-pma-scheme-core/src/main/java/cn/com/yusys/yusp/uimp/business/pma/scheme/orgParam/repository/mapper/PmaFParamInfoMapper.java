package cn.com.yusys.yusp.uimp.business.pma.scheme.orgParam.repository.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.uimp.business.pma.scheme.orgParam.domain.PmaFParamInfo;

/**
 * @项目名称: uimp-business-pma-scheme-core模块
 * @类名称: PmaFParamInfoMapper
 * @类描述: #Dao类
 * @功能描述: 
 * @创建人: asus
 * @创建时间: 2020-01-09 15:32:30
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
public interface PmaFParamInfoMapper extends CommonMapper<PmaFParamInfo> {
	List<Map<String, Object>> querylist(QueryModel model);
	List<Map<String, Object>> queryorglist();
	int deleInfo(String dirId);
	List<Map<String, Object>> queryAuth(String paramId);
	
	String queryNameByParamId(@Param("paramId") String paramId);
}
