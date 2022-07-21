package cn.com.yusys.yscrm.custpub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yscrm.custpub.domain.OcrmFnetworkCiRela;
import cn.com.yusys.yscrm.custpub.repository.mapper.OcrmFnetworkCiRelaMapper;
/**
 * @项目名称: yscrm-entity-cust-pub-core模块
 * @类名称: OcrmFnetworkCiRelaService
 * @类描述: #服务类
 * @功能描述: 
 * @创建人: hyx
 * @创建时间: 2019-02-18 16:28:38
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class OcrmFnetworkCiRelaService extends CommonService {
    @Autowired
    private OcrmFnetworkCiRelaMapper ocrmFnetworkCiRelaMapper;

    @Override
    protected CommonMapper<?> getMapper() {
        return ocrmFnetworkCiRelaMapper;
    }

}
