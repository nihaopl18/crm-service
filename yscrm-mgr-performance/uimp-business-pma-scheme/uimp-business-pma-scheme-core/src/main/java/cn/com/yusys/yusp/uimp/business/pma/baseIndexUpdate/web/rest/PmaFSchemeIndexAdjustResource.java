package cn.com.yusys.yusp.uimp.business.pma.baseIndexUpdate.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.uimp.business.pma.baseIndexUpdate.domain.PmaFSchemeIndexAdjust;
import cn.com.yusys.yusp.uimp.business.pma.baseIndexUpdate.service.PmaFSchemeIndexAdjustService;
import io.swagger.annotations.Api;

/**
 * @项目名称: uimp-business-pma-scheme-core模块
 * @类名称: PmaFSchemeIndexAdjustResource
 * @类描述: #资源类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2020-01-06 14:06:42
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@RestController
@Api(tags = "基础指标调整记录")
@RequestMapping("/api/pmafschemeindexadjust")
public class PmaFSchemeIndexAdjustResource extends CommonResource<PmaFSchemeIndexAdjust, String> {
    @Autowired
    private PmaFSchemeIndexAdjustService pmaFSchemeIndexAdjustService;

    @Override
    protected CommonService getCommonService() {
        return pmaFSchemeIndexAdjustService;
    }

}
