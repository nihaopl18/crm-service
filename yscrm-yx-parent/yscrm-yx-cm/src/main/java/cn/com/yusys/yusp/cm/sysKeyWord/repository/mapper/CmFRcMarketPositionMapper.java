package cn.com.yusys.yusp.cm.sysKeyWord.repository.mapper;

import cn.com.yusys.yusp.cm.sysKeyWord.domain.CmFRcMarketPosition;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;

import java.util.List;
import java.util.Map;
/**
 * @项目名称: yusp-app-cm
 * @类名称: CmFRcMarketPositionMapper
 * @类描述: 营销位管理
 * @功能描述: 
 * @创建人: yangxiao2@yusys.com.cn
 * @创建时间: 2019-04-25 
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2018宇信科技-版权所有
 */
public interface CmFRcMarketPositionMapper extends CommonMapper<CmFRcMarketPosition>{
	public List<Map<String,Object>>setPositionList(String channelId);
}
