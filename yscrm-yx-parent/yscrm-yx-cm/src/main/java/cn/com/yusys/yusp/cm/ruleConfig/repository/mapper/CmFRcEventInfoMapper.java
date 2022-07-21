package cn.com.yusys.yusp.cm.ruleConfig.repository.mapper;

import cn.com.yusys.yusp.cm.ruleConfig.domain.CmFRcEventInfo;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;
/**
 * 
 * @项目名称: yusp-app-cm
 * @类名称: CmFRcEventInfoMapper
 * @类描述: 事件信息接口
 * @功能描述: 
 * @创建人: chenlin2@yusys.com.cn
 * @创建时间: 2018-10-23 14:22
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2018宇信科技-版权所有
 */
public interface CmFRcEventInfoMapper extends CommonMapper<CmFRcEventInfo>{
	
	/**查询表事件信息*/
	List<CmFRcEventInfo> getEventInfo(QueryModel model);
	
	List<CmFRcEventInfo> getEventByTrans(@Param(value="transCode") String transCode);
	/**
	 * 逻辑删除事件信息
	 * @param map
	 * @return
	 */
	int updataEventInfoState(Map<String,String> map);
	/**
	 * 
	* @方法名称: updateSts
	* @方法描述: 更新事件状态
	* @参数与返回说明: 
	* @算法描述:
	 */
	int updateSts(Map<?,?> param);
}
