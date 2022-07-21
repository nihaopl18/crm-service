package cn.com.yusys.yusp.cm.sysKeyWord.repository.mapper;

import cn.com.yusys.yusp.cm.sysKeyWord.domain.CmFRcRiskInfo;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;

import java.util.List;
/**
 * 
 * @项目名称: yusp-app-cm
 * @类名称: CmFRcRiskMapper
 * @类描述: 关注风险配置接口
 * @功能描述: 
 * @创建人: yangxiao2@yusys.com.cn
 * @创建时间: 2018-11-06 
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2018宇信科技-版权所有
 */
public interface CmFRcRiskMapper extends CommonMapper<CmFRcRiskInfo>{
	// 查询关注风险表
	List<CmFRcRiskInfo> getList(QueryModel model);
	// 删除关注风险表数据
	int deleteList(CmFRcRiskInfo record);
	// 获取自增序列 
	String getSeq();
}
