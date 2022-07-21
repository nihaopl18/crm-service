package cn.com.yusys.yusp.uimp.business.pma.scheme.baseIndex.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.uimp.business.pma.scheme.baseIndex.domain.PmaFIndexBussInfo;
import cn.com.yusys.yusp.uimp.business.pma.scheme.baseIndex.service.PmaFIndexBussInfoService;

/**
 * @项目名称: uimp-business-pma-scheme-core模块
 * @类名称: PmaFIndexBussInfoResource
 * @类描述: #资源类
 * @功能描述: 
 * @创建人: asus
 * @创建时间: 2020-03-16 15:20:38
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/pmafindexbussinfo")
public class PmaFIndexBussInfoResource extends CommonResource<PmaFIndexBussInfo, String> {
    @Autowired
    private PmaFIndexBussInfoService pmaFIndexBussInfoService;

    @Override
    protected CommonService getCommonService() {
        return pmaFIndexBussInfoService;
    }

}
