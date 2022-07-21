package cn.com.yusys.climp.acty.repository.mapper;

import java.util.List;
import java.util.Map;

import cn.com.yusys.climp.acty.domain.LoyRLFieldCostList;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
/**
 * @项目名称: yusp-climp-single-starter模块
 * @类名称: LoyRLFieldCostListMapper
 * @类描述: #成本归属类
 * @功能描述: 
 * @创建人: yangxiao2@yusys.com.cn
 * @创建时间: 2019-04-23 15:37:27
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public interface LoyRLFieldCostListMapper extends CommonMapper<LoyRLFieldCostList>{
	List<Map<String,Object>>costList(String tableId);
	List<Map<String,Object>>costField(String tableId);
	int delByTableId(String tableId);
	List<Map<String,Object>>getCostList(String tableId);
}
