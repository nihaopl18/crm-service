package cn.com.yusys.yusp.cm.cust.repository.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import cn.com.yusys.yusp.cm.cust.domain.CimpCgCustPerContSum;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
@Mapper
public interface CimpCgCustPerContSumMapper extends CommonMapper<CimpCgCustPerContSum>{

	List<CimpCgCustPerContSum> getListByModel(QueryModel queryModel);

	List<Map<String, Object>> getListById(String custId);

	

}
