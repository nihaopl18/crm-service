package cn.com.yusys.yusp.cim.model.service;

import cn.com.yusys.yusp.cim.model.domain.LoyAcEquCatalog;
import cn.com.yusys.yusp.cim.model.repository.mapper.LoyAcEquCatalogMapper;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @version 1.0.0
 * @项目名称: yscimc-cust-group模块
 * @类名称: LoyAcEquAccountService
 * @类描述: #服务类
 * @功能描述:
 * @创建人: hyx
 * @创建时间: 2019-05-27 18:17:31
 * @修改备注:
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class LoyAcEquCatalogService  extends CommonService {

    @Autowired
    private LoyAcEquCatalogMapper mapper;
    @Override
    protected CommonMapper getMapper() {
        return mapper;
    }

    public LoyAcEquCatalog list(QueryModel model) {
        return mapper.list(model);
    }
}
