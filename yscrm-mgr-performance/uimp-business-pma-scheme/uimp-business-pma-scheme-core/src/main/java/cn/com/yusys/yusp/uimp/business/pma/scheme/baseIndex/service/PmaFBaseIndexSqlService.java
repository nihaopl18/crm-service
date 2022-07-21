package cn.com.yusys.yusp.uimp.business.pma.scheme.baseIndex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.uimp.business.pma.scheme.baseIndex.repository.mapper.PmaFBaseIndexSqlMapper;
/**
 * @项目名称: uimp-business-pma-scheme-core模块
 * @类名称: PmaFBaseIndexSqlService
 * @类描述: #服务类
 * @功能描述: 
 * @创建人: asus
 * @创建时间: 2020-01-06 15:54:10
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@Service
public class PmaFBaseIndexSqlService extends CommonService {
    @Autowired
    private PmaFBaseIndexSqlMapper pmaFBaseIndexSqlMapper;

    @Override
    protected CommonMapper<?> getMapper() {
        return pmaFBaseIndexSqlMapper;
    }

}
