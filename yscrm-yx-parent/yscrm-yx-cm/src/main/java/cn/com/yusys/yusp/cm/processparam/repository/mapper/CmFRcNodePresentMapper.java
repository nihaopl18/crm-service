package cn.com.yusys.yusp.cm.processparam.repository.mapper;

import cn.com.yusys.yusp.cm.processparam.domain.CmFRcNodePresentInfo;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;

import java.util.List;
/**
 * 
 * @项目名称: yusp-app-cm
 * @类名称: CmFRcNodePresentMapper
 * @类描述: 组件操作参数接口
 * @功能描述: 
 * @创建人: yangxiao2@yusys.com.cn
 * @创建时间: 2018-11-15
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2018宇信科技-版权所有
 */
public interface CmFRcNodePresentMapper extends CommonMapper<CmFRcNodePresentInfo>{
	// 查询组件操作参数表
	List<CmFRcNodePresentInfo> getList(QueryModel model);
	// 删除组件操作参数表数据
	int deleteList(CmFRcNodePresentInfo record);
	// 插入节点数据
	int addNodes(CmFRcNodePresentInfo record);
	// 删除该节点下已有的数据
	int delSameNodeData(String nodeId);
	int checkBe(String formInId);
}
