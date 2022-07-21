package cn.com.yusys.yusp.uimp.business.pma.app.repository.mapper;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.uimp.business.pma.app.domain.PmaAppNews;

import java.util.List;
import java.util.Map;

public interface AppGuessMapper extends CommonMapper<PmaAppNews>{
	List<Map<String, Object>> queryBusTypeSub(QueryModel model);
	List<Map<String, Object>> queryParamByList(QueryModel model);
	List<Map<String, Object>> queryParamByInfo(QueryModel model);
	List<Map<String, Object>> queryFun();
}
