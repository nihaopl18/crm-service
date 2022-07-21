package cn.com.yusys.yusp.cm.cust.repository.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cn.com.yusys.yusp.cm.cust.domain.CimpFFqGroup;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;

@Mapper
public interface CimpFFqGroupMapper extends CommonMapper<CimpFFqGroup>{
	void insertfgroup(CimpFFqGroup record);
	List<CimpFFqGroup> getGroup(String objId);
}
