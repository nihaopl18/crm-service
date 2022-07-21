package cn.com.yusys.yusp.cm.sysKeyWord.repository.mapper;

import cn.com.yusys.yusp.cm.sysKeyWord.domain.CmFRcSysTypeInfo;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 
 * @项目名称: yusp-app-cm
 * @类名称: CmFRcSysTypeMapper
 * @类描述: 渠道营销模板接口
 * @功能描述: 
 * @创建人: yangxiao2@yusys.com.cn
 * @创建时间: 2018-10-19 
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2018宇信科技-版权所有
 */
public interface CmFRcSysTypeMapper extends CommonMapper<CmFRcSysTypeInfo>{
	// 查询渠道营销模板表
	List<CmFRcSysTypeInfo>getList(QueryModel model);
	//营销动作组件查询模板信息根据节点ID
	List<CmFRcSysTypeInfo>getListByNodeId(Map<String,Object> param);
	// 获取自增序列
	String getSeq();
	// 删除渠道营销模板表
	int deleteList (CmFRcSysTypeInfo record);
	// 获取用户名称
	String getUserName (String loginCode);
	// 获取关键字/别名
	List<Map<String, Object>>getAliasName(QueryModel model);
	// 获取适用对象名称
	String getApplyObjectName(int catlCode);
	String getProdName(String productId);
	// 产品视图查询渠道模型表
	List<CmFRcSysTypeInfo>getListProd(QueryModel model);
	// 模板名称验重
	int getSameName(CmFRcSysTypeInfo record);

	List<CmFRcSysTypeInfo> selectByIdList(@Param("actionIdList") List<String> actionIdList);
}
