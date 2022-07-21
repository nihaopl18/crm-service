package cn.com.yusys.yusp.cm.processparam.repository.mapper;

import cn.com.yusys.yusp.cm.processparam.domain.CmFRcNodeOutputInfo;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;

import java.util.List;
import java.util.Map;
/**
 * 
 * @项目名称: yusp-app-cm
 * @类名称: CmFRcNodeOutputMapper
 * @类描述: 组件输出参数接口
 * @功能描述: 
 * @创建人: yangxiao2@yusys.com.cn
 * @创建时间: 2018-11-15
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2018宇信科技-版权所有
 */
public interface CmFRcNodeOutputMapper extends CommonMapper<CmFRcNodeOutputInfo>{
	// 查询组件输出参数表
	List<CmFRcNodeOutputInfo> getList(QueryModel model);
	// 删除组件输出参数表数据
	int deleteList(CmFRcNodeOutputInfo record);
	// 插入节点数据
	int addNodes(CmFRcNodeOutputInfo record);
	// 删除该节点下已有的数据
	int delSameNodeData(String nodeId);
	int upd(CmFRcNodeOutputInfo record);
	int checkBe(String nodeId);
	Map<String, Object> checknodeid(String string);
}
