package cn.com.yusys.yusp.cim.model.web.rest;

import cn.com.yusys.yusp.cim.model.domain.LoyAcEquCatalog;
import cn.com.yusys.yusp.cim.model.service.LoyAcEquCatalogService;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @version 1.0.0
 * @项目名称: yscimc-cust-group模块
 * @类名称: LoyAcEquAccountResource
 * @类描述: #资源类
 * @功能描述:
 * @创建人: hyx
 * @创建时间: 2019-05-27 18:17:31
 * @修改备注:
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/loyacequcatalog")
public class LoyAcEquCatalogResource extends CommonResource<LoyAcEquCatalog, String> {

    @Autowired
    private LoyAcEquCatalogService service;
    @Override
    protected CommonService getCommonService() {
        return service;
    }

    /**
     * 查询权益账户目录
     */
    @GetMapping("/list")
    public ResultDto<LoyAcEquCatalog> list(QueryModel model) {
        return new ResultDto<>(service.list(model));
    }
}
