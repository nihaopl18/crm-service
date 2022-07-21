package cn.com.yusys.yusp.cm.sysKeyWord.repository.mapper;

import cn.com.yusys.yusp.cm.sysKeyWord.domain.CmFRcCareInfo;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;

import java.util.List;
/**
 * 
 * @项目名称: yusp-app-cm
 * @类名称: CmFRcCareMapper
 * @类描述: 客户关怀配置接口
 * @功能描述: 
 * @创建人: yangxiao2@yusys.com.cn
 * @创建时间: 2018-11-067
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2018宇信科技-版权所有
 */
public interface CmFRcCareMapper extends CommonMapper<CmFRcCareInfo>{
	// 查询客户关怀表
	List<CmFRcCareInfo> getList(QueryModel model);
	// 删除客户关怀表数据
	int deleteList(CmFRcCareInfo record);
	// 获取自增序列 
	String getSeq();
}
