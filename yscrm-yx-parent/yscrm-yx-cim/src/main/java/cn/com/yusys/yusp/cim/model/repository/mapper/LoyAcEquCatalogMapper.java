package cn.com.yusys.yusp.cim.model.repository.mapper;

import cn.com.yusys.yusp.cim.model.domain.LoyAcEquCatalog;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;

public interface LoyAcEquCatalogMapper extends CommonMapper<LoyAcEquCatalog> {
    LoyAcEquCatalog list(QueryModel model);
}
