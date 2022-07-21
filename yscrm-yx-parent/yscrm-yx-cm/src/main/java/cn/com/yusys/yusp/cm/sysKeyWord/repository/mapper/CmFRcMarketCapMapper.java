package cn.com.yusys.yusp.cm.sysKeyWord.repository.mapper;

import cn.com.yusys.yusp.cm.sysKeyWord.domain.CmFRcMarketCapInfo;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;

import java.util.List;
/**
 * @项目名称: yusp-app-cm
 * @类名称: CmFRcMarketCapMapper
 * @类描述: 营销封顶接口
 * @功能描述: 
 * @创建人: yangxiao2@yusys.com.cn
 * @创建时间: 2018-12-17 
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2018宇信科技-版权所有
 */
public interface CmFRcMarketCapMapper extends CommonMapper<CmFRcMarketCapInfo>{
	// 查询
	List<CmFRcMarketCapInfo>getList(QueryModel model);
	// 删除
	int deleteList(CmFRcMarketCapInfo record);
}
