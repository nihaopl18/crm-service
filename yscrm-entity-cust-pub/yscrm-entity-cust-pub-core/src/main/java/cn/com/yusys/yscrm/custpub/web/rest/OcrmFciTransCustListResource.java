package cn.com.yusys.yscrm.custpub.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yscrm.custpub.domain.OcrmFciTransCustList;
import cn.com.yusys.yscrm.custpub.service.OcrmFciTransCustListService;

/**
 * @项目名称: yscrm-entity-cust-pub-core模块
 * @类名称: OcrmFciTransCustListResource
 * @类描述: #资源类
 * @功能描述: 
 * @创建人: hyx
 * @创建时间: 2019-02-15 10:38:36
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/ocrmfcitranscustlist")
public class OcrmFciTransCustListResource extends CommonResource<OcrmFciTransCustList, String> {
    @Autowired
    private OcrmFciTransCustListService ocrmFciTransCustListService;

    @Override
    protected CommonService getCommonService() {
        return ocrmFciTransCustListService;
    }

}
