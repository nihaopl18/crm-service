package cn.com.yusys.yusp.uimp.business.pma.scheme.dimension.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.uimp.business.pma.scheme.dimension.domain.PmaFIndexEvlObjInfo;
import cn.com.yusys.yusp.uimp.business.pma.scheme.dimension.service.PmaFEvlobjDimService;

/**
 * @项目名称: uimp-business-pma-scheme-core模块
 * @类名称: PmaFEvlobjDimResource
 * @类描述: #资源类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2020-01-03 14:12:40
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/pmafevlobjdim")
public class PmaFEvlobjDimResource extends CommonResource<PmaFIndexEvlObjInfo, String> {
    @Autowired
    private PmaFEvlobjDimService pmaFEvlobjDimService;

    @Override
    protected CommonService getCommonService() {
        return pmaFEvlobjDimService;
    }

}
