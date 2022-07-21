package cn.com.yusys.yscrm.product.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.com.yusys.yscrm.product.domain.OcrmFpdProdQaReply;
import cn.com.yusys.yscrm.product.service.OcrmFpdProdQaReplyService;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;

/**
 * @项目名称: yusp-crm-single-starter模块
 * @类名称: OcrmFpdProdQaReplyResource
 * @类描述: #资源类
 * @功能描述: 
 * @创建人: yantianyi
 * @创建时间: 2019-02-12 09:32:23
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/ocrmfpdprodqareply")
public class OcrmFpdProdQaReplyResource extends CommonResource<OcrmFpdProdQaReply, String> {
    @Autowired
    private OcrmFpdProdQaReplyService ocrmFpdProdQaReplyService;

    @Override
    protected CommonService getCommonService() {
        return ocrmFpdProdQaReplyService;
    }

}
