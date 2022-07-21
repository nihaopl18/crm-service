package cn.com.yusys.yusp.uimp.business.pma.app.service;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.uimp.base.service.UserInfoService;
import cn.com.yusys.yusp.uimp.business.pma.app.repository.mapper.AppPerformanceMapper;
import cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.domain.PmaFScheme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.util.StringUtil;

import java.util.List;
import java.util.Map;

@Service
public class AppPerformanceService extends CommonService{
	@Autowired
	private AppPerformanceMapper appPerformanceMapper;
	@Autowired
    private UserInfoService userInfoService;

	@Override
	protected CommonMapper<?> getMapper() {
		return appPerformanceMapper;
	}
	
	@Transactional(readOnly = true)
	public List<Map<String, Object>> queryEtlDate() {
		List<Map<String, Object>> list = this.appPerformanceMapper.queryEtlDate();
		return list;
	}
	
	@Transactional(readOnly = true)
	public List<Map<String, Object>> queryIndexId(String indexType, String type) {
		if(StringUtil.isEmpty(type)) {
			type = "";
		}
		List<Map<String, Object>> list = this.appPerformanceMapper.queryIndexId(indexType, type);
		return list;
	}
	
	@Transactional(readOnly = true)
	public List<Map<String, Object>> queryAllIndex() {
		List<Map<String, Object>> list = this.appPerformanceMapper.queryAllIndex();
		return list;
	}
	
	@Transactional(readOnly = true)
	public List<Map<String, Object>> queryIndexMonth(QueryModel model) {
		List<Map<String, Object>> list = this.appPerformanceMapper.queryIndexMonth(model);
		return list;
	}
	

	@Transactional(readOnly = true)
	public List<Map<String, Object>> queryScheme(QueryModel model) {
		List<Map<String, Object>> list = this.appPerformanceMapper.queryScheme(model);
		return list;
	}
	@Transactional(readOnly = true)
	public List<PmaFScheme> selectDrawSchemeInfo(String schemeId) {
		List<PmaFScheme> list = this.appPerformanceMapper.selectDrawSchemeInfo(schemeId);
		return list;
	}
}
