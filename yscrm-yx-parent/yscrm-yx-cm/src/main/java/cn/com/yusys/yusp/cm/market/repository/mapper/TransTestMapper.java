package cn.com.yusys.yusp.cm.market.repository.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;
@Mapper
public interface TransTestMapper{

	List<Map<String, Object>> queryTrans(String transCode);

	void insertTrans(List<Map<String, String>> translist);

	void delTrans(String trcd);

}
