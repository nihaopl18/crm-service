package cn.com.yusys.yusp.uimp.business.pma.baseIndexUpdate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yusp.uimp.business.pma.baseIndexUpdate.domain.PmaFSchemeIndexAdjust;
import cn.com.yusys.yusp.uimp.business.pma.baseIndexUpdate.repository.mapper.PmaFSchemeIndexAdjustMapper;
/**
 * @项目名称: uimp-business-pma-scheme-core模块
 * @类名称: PmaFSchemeIndexAdjustService
 * @类描述: #服务类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2020-01-06 14:06:42
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@Service
public class PmaFSchemeIndexAdjustService extends CommonService {
    @Autowired
    private PmaFSchemeIndexAdjustMapper pmaFSchemeIndexAdjustMapper;

    @Override
    protected CommonMapper<?> getMapper() {
        return pmaFSchemeIndexAdjustMapper;
    }
}
