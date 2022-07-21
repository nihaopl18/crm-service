package cn.com.yusys.climp.qypool.repository.mapper;

import cn.com.yusys.climp.qypool.domain.LoyQyMaterialList;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;

import java.util.List;
import java.util.Map;

public interface LoyQyMaterialListMapper extends CommonMapper<LoyQyMaterialList>{
	List<Map<String,Object>>materialQuery(QueryModel model);
	int getSameName (String materialName);
	int getSameNameEdit (Map<String,Object> map);
	int setMaterialSts(Map<String,Object> map);
	Map<String,Object>getFileId(String id);
	
	List<Map<String,Object>>getDptByOrgId(String orgId);

	@Override
	int updateByPrimaryKeySelective(LoyQyMaterialList loyQyMaterialList);
	/**
	 *
	 * @方法名称: getfieldsChannel
	 * @方法描述: 查询所有渠道的栏位信息
	 * @参数与返回说明:
	 * @算法描述:
	 */
	List<Map<String,Object>> getfieldsChannel();
}
