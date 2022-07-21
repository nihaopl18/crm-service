package cn.com.yusys.yusp.cm.productmanager.repository.mapper;

import cn.com.yusys.yusp.cm.productmanager.domain.CmFRcProdMarketTargetInfo;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;

import java.util.List;
/**
 * 
 * @项目名称: yusp-app-cm
 * @类名称: CmFRcProdMarketTargetMapper
 * @类描述: 营销成效指标维护接口
 * @功能描述: 
 * @创建人: yangxiao2@yusys.com.cn
 * @创建时间: 2018-11-18
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2018宇信科技-版权所有
 */
public interface CmFRcProdMarketTargetMapper extends CommonMapper<CmFRcProdMarketTargetInfo>{
	// 查询营销成效指标
	List<CmFRcProdMarketTargetInfo> getList(QueryModel model);
	// 删除营销成效指标
	int deleteList(CmFRcProdMarketTargetInfo record);
	// 返回重复营销成效指标id
	String getSameId(CmFRcProdMarketTargetInfo record);
	// 返回重复营销成效指标名称
	String getSameName(CmFRcProdMarketTargetInfo record);
	// 营销成效指标启用
	int upList(CmFRcProdMarketTargetInfo record);
	// 营销成效指标停用
	int downList(CmFRcProdMarketTargetInfo record);
	// 删除指标归属表
	int delTargetProd (String targetId);
	// 新增指标归属表
	int addTargetProd (CmFRcProdMarketTargetInfo record);

    List<CmFRcProdMarketTargetInfo> getListAll(QueryModel model);

	List<CmFRcProdMarketTargetInfo> getListByTargetId(QueryModel model);

    List<CmFRcProdMarketTargetInfo> getListByTargetName(List<String> listids);

	List<CmFRcProdMarketTargetInfo> queryByTargetName(QueryModel model);

	//void deleteargetProd(CmFRcProdMarketTargetInfo record);
}
