package cn.com.yusys.yusp.cm.processparam.repository.mapper;

import cn.com.yusys.yusp.cm.processparam.domain.CmFRcNodeInputInfo;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;

import java.util.List;
import java.util.Map;
/**
 * 
 * @项目名称: yusp-app-cm
 * @类名称: CmFRcNodeInputMapper
 * @类描述: 组件输入参数接口
 * @功能描述: 
 * @创建人: yangxiao2@yusys.com.cn
 * @创建时间: 2018-11-15
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2018宇信科技-版权所有
 */
public interface CmFRcNodeInputMapper extends CommonMapper<CmFRcNodeInputInfo>{
	// 查询节点下参数
	List<Map<String,Object>> getList(String nodeId);
	// 删除组件输入参数表数据
	int deleteList(CmFRcNodeInputInfo record);
	// 插入节点数据
	int addNodes(CmFRcNodeInputInfo record);
	// 删除该节点下已有的数据
	int delSameNodeData(String nodeId);
	// 删除该节点数据
	int delSameNode(String nodeId);
	int checkBe(String nodeId);
	String getSeq();
	CmFRcNodeInputInfo checknodeid(QueryModel model);
	int upd(CmFRcNodeInputInfo record);
}
