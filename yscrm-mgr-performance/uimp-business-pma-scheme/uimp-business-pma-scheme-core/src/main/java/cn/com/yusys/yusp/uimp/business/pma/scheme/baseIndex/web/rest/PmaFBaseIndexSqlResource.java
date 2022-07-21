package cn.com.yusys.yusp.uimp.business.pma.scheme.baseIndex.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.uimp.business.pma.scheme.baseIndex.domain.PmaFBaseIndexSql;
import cn.com.yusys.yusp.uimp.business.pma.scheme.baseIndex.service.PmaFBaseIndexSqlService;

/**
 * @项目名称: uimp-business-pma-scheme-core模块
 * @类名称: PmaFBaseIndexSqlResource
 * @类描述: #资源类
 * @功能描述: 
 * @创建人: asus
 * @创建时间: 2020-01-06 15:54:10
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/pmafbaseindexsql")
public class PmaFBaseIndexSqlResource extends CommonResource<PmaFBaseIndexSql, String> {
    @Autowired
    private PmaFBaseIndexSqlService pmaFBaseIndexSqlService;

    @Override
    protected CommonService getCommonService() {
        return pmaFBaseIndexSqlService;
    }

}
