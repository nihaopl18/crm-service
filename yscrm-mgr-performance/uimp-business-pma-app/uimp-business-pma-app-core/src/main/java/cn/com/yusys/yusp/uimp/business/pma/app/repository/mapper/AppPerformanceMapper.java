package cn.com.yusys.yusp.uimp.business.pma.app.repository.mapper;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.uimp.business.pma.app.domain.PmaAppNews;
import cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.domain.PmaFScheme;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface AppPerformanceMapper  extends CommonMapper<PmaAppNews>{
	List<Map<String, Object>> queryEtlDate();
	List<Map<String, Object>> queryIndexId(@Param("indexType") String indexType, @Param("type") String type);
	List<Map<String, Object>> queryIndexMonth(QueryModel model);
	List<Map<String, Object>> queryScheme(QueryModel model);
	List<Map<String, Object>> queryAllIndex();
	List<PmaFScheme> selectDrawSchemeInfo(String schemeId);
}
