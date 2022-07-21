package cn.com.yusys.yusp.cm.cust.repository.mapper;

import cn.com.yusys.yusp.cm.cust.domain.CimpCmMkTplBasicinfo;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CimpCmMkTplBasicinfoMapper extends CommonMapper<CimpCmMkTplBasicinfo>{

	List<CimpCmMkTplBasicinfo> getListByModel(QueryModel model);
	
	String getSeq();

	int checkName(String name);

	String getNameById(String id);

	int updateFun(CimpCmMkTplBasicinfo c);

}
