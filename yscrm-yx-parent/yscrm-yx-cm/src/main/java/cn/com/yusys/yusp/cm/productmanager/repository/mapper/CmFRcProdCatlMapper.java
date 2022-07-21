package cn.com.yusys.yusp.cm.productmanager.repository.mapper;

import cn.com.yusys.yusp.cm.productmanager.domain.CmFRcProdCatlInfo;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;

import java.util.List;
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
public interface CmFRcProdCatlMapper extends CommonMapper<CmFRcProdCatlInfo>{
	// 查询产品信息表
	List<CmFRcProdCatlInfo> getList();
	// 获取自增序列
	String getSeq();
	// 产品类别检验重复名称
	String getSameName(CmFRcProdCatlInfo record);
	// 获取子节点
	String getSonNode(long catlCode);
	// 获取子产品
	int getSonProd(long catlCode);
	// 删除产品类别
	int deleteList(CmFRcProdCatlInfo record);
	// 更新产品数据
	int updateList(CmFRcProdCatlInfo record);
	// 获取产品树级别
	int getNodeLevel(long catlCode);
}
