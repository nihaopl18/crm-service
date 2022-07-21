package cn.com.yusys.yusp.cm.productmanager.repository.mapper;

import cn.com.yusys.yusp.cm.productmanager.domain.CmFRcProdCombinInfo;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;

import java.util.List;
/**
 * 
 * @项目名称: yusp-app-cm
 * @类名称: CmFRcProdCombinMapper
 * @类描述: 组合产品管理接口
 * @功能描述: 
 * @创建人: yangxiao2@yusys.com.cn
 * @创建时间: 2018-11-12 
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2018宇信科技-版权所有
 */
public interface CmFRcProdCombinMapper extends CommonMapper<CmFRcProdCombinInfo>{
	// 查询组合产品管理表
	List<CmFRcProdCombinInfo> getList(QueryModel model);
	// 新增组合子产品
	int insertList(CmFRcProdCombinInfo record);
	// 删除组合子产品
	int deleteList(CmFRcProdCombinInfo record);
	// 删除组合产品
	int deleteListParent(CmFRcProdCombinInfo record);
	// 更新组合产品状态
	int updateList(CmFRcProdCombinInfo record);
	// 返回重复子产品id
	String getSameId(CmFRcProdCombinInfo record);
	// 返回组合产品配比和
	float getWeight(CmFRcProdCombinInfo record);
	// 返回组合产品标识
	String getProdCombin(String productId);
}
