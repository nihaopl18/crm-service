package cn.com.yusys.yusp.uimp.business.pma.scheme.dimension.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.uimp.business.pma.scheme.dimension.domain.PmaFIndexBalInfo;
import cn.com.yusys.yusp.uimp.business.pma.scheme.dimension.service.PmaFBalanceTypeDimService;

/**
 * @项目名称: uimp-business-pma-scheme-core模块
 * @类名称: PmaFBalanceTypeDimResource
 * @类描述: #资源类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2020-01-03 14:14:11
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/pmafbalancetypedim")
public class PmaFBalanceTypeDimResource extends CommonResource<PmaFIndexBalInfo, String> {
    @Autowired
    private PmaFBalanceTypeDimService pmaFBalanceTypeDimService;

    @Override
    protected CommonService getCommonService() {
        return pmaFBalanceTypeDimService;
    }

}
