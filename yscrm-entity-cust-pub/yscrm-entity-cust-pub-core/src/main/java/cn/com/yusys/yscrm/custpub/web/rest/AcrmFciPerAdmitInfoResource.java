package cn.com.yusys.yscrm.custpub.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yscrm.custpub.domain.AcrmFciPerAdmitInfo;
import cn.com.yusys.yscrm.custpub.service.AcrmFciPerAdmitInfoService;

/**
 * @项目名称: yscrm-entity-cust-pub-core模块
 * @类名称: AcrmFciPerAdmitInfoResource
 * @类描述: #资源类
 * @功能描述: 
 * @创建人: hyx
 * @创建时间: 2019-01-31 16:45:04
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/acrmfciperadmitinfo")
public class AcrmFciPerAdmitInfoResource extends CommonResource<AcrmFciPerAdmitInfo, String> {
    @Autowired
    private AcrmFciPerAdmitInfoService acrmFciPerAdmitInfoService;

    @Override
    protected CommonService getCommonService() {
        return acrmFciPerAdmitInfoService;
    }

}
