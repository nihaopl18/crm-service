package cn.com.yusys.yusp.cm.market.repository.mapper;

import cn.com.yusys.yusp.cm.market.domain.FrRuleTabfieldinfo;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface FrRuleTabfieldinfoMapper extends CommonMapper<FrRuleTabfieldinfo> {
	
	List<Map<String, Object>> list(@Param("tabName") String tabName);

	int createTable(Map<String, Object> map);

	int addConstraints(Map<String, Object> map);
	
	//修改表的创建标志
	int updateCreateFlag(String tabName);
	
	int updateFlag(String tabName);
	
	int dropTable(Map<String, Object> map);
	
	int selectByfield(String id);
	int selecttransByfield(String id);
	
	int deleteField(String tabName);
}
