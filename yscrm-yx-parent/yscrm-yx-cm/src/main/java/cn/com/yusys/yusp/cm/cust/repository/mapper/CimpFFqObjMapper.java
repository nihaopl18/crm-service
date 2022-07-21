package cn.com.yusys.yusp.cm.cust.repository.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cn.com.yusys.yusp.cm.cust.domain.CimpFFqObj;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;

@Mapper
public interface CimpFFqObjMapper extends CommonMapper<CimpFFqObj>{
	List<CimpFFqObj> queryLeftTab(String SQL);
	List<CimpFFqObj> getObj(QueryModel model);
}
