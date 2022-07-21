package cn.com.yusys.yscrm.custflexEs.service;

import cn.com.yusys.yscrm.custflexEs.repository.mapper.CrmFCiFqObjMapper;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @项目名称: cmss-cust-mgt-core模块
 * @类名称: CrmFCiFqObjService
 * @类描述: #数据集—对象 服务类
 * @功能描述: 
 * @创建人: lixt1
 * @创建时间: 2020-12-29 11:24:16
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@Service
public class CrmFCiFqObjService extends CommonService {
    @Autowired
    private CrmFCiFqObjMapper crmFCiFqObjMapper;

    @Override
    protected CommonMapper<?> getMapper() {
        return crmFCiFqObjMapper;
    }

}
