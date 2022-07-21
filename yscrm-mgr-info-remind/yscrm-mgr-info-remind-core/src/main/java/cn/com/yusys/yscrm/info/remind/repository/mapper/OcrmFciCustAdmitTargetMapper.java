package cn.com.yusys.yscrm.info.remind.repository.mapper;

import java.util.List;
import java.util.Map;

import cn.com.yusys.yscrm.info.remind.domain.OcrmFciCustAdmitTarget;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;

public interface OcrmFciCustAdmitTargetMapper extends CommonMapper<OcrmFciCustAdmitTarget> {
	List<Map<String, Object>> queryList();
	int update(OcrmFciCustAdmitTarget admit);
}
