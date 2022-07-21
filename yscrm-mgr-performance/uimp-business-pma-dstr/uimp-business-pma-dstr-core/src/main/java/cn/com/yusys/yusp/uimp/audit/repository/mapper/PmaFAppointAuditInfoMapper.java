package cn.com.yusys.yusp.uimp.audit.repository.mapper;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.uimp.audit.domain.PmaFAppointAuditInfo;

/**
 * @项目名称: uimp-business-pma-dstr-core模块
 * @类名称: PmaFAppointAuditInfoMapper
 * @类描述: #Dao类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2020-01-02 14:45:33
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
public interface PmaFAppointAuditInfoMapper extends CommonMapper<PmaFAppointAuditInfo> {
	
	List<Map<String, Object>> listByModel(QueryModel model);
	
	String selectCount(QueryModel model);
	
	int queryByOrg(String orgCode);
}