package cn.com.yusys.yusp.uimp.base.repository.mapper;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.uimp.base.domain.PmaFSmEtlLog;

import java.util.List;
import java.util.Map;

public interface PmaSqlMapper extends CommonMapper<PmaFSmEtlLog>{
    public List<Map<String, Object>> queryList(QueryModel model);
}
