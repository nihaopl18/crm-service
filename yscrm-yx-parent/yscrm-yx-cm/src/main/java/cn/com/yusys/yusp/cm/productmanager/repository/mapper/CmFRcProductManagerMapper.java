package cn.com.yusys.yusp.cm.productmanager.repository.mapper;

import cn.com.yusys.yusp.cm.productmanager.domain.CmFRcProductManagerInfo;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 
 * @项目名称: yusp-app-cm
 * @类名称: CmFRcProductManagerMapper
 * @类描述: 产品管理接口
 * @功能描述: 
 * @创建人: yangxiao2@yusys.com.cn
 * @创建时间: 2018-11-08 
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2018宇信科技-版权所有
 */
public interface CmFRcProductManagerMapper extends CommonMapper<CmFRcProductManagerInfo>{
	// 查询产品信息表
	List<CmFRcProductManagerInfo> getList(QueryModel model);
	// 新增产品检验重复id
	String getSameId(String id);
	// 新增产品检验重复名称
	String getSameName(String name);
	// 更新产品检验重复名称
	String getSameUpdateName(CmFRcProductManagerInfo record);
	// 组件返回产品信息输入
	List<CmFRcProductManagerInfo>getProdById(CmFRcProductManagerInfo record);
	// 组件返回产品信息输出
	List<Map<String,Object>>getOutputProd(QueryModel model);
	// 产品目标客户
	List<Map<String,Object>>getProdCust(QueryModel model);
	List<CmFRcProductManagerInfo> getProByIds(List<String> listids);
	List<CmFRcProductManagerInfo> getPro();
	CmFRcProductManagerInfo getProInfo(String productId);
	int checkPro(String productid);

	List<CmFRcProductManagerInfo> selectByIdList(@Param("productIdList") List<String> productIdList);
}
