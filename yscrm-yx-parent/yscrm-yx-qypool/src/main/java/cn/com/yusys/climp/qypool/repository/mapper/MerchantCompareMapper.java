package cn.com.yusys.climp.qypool.repository.mapper;

import java.util.List;
import java.util.Map;

import cn.com.yusys.climp.qypool.domain.LoyQyMaterialList;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;

public interface MerchantCompareMapper extends CommonMapper<LoyQyMaterialList>{
	//商户对账主查询
	List<Map<String,Object>>getCompareList(QueryModel model);
//	int getSameName (String materialName);
//	int getSameNameEdit (Map<String,Object> map);
//	int setMaterialSts(Map<String,Object> map);
	//商户对账详情查询
	List<Map<String,Object>>merchantDetail(QueryModel model);
}
