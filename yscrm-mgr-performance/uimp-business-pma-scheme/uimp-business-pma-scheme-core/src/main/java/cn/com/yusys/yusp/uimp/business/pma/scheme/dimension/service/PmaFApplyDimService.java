package cn.com.yusys.yusp.uimp.business.pma.scheme.dimension.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.uimp.business.pma.scheme.dimension.repository.mapper.PmaFIndexApplyInfoMapper;
/**
 * @项目名称: uimp-business-pma-scheme-core模块
 * @类名称: PmaFApplyDimService
 * @类描述: #服务类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2020-01-03 14:13:24
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@Service
public class PmaFApplyDimService extends CommonService {
    @Autowired
    private PmaFIndexApplyInfoMapper pmaFIndexApplyInfoMapper;

    @Override
    protected CommonMapper<?> getMapper() {
        return pmaFIndexApplyInfoMapper;
    }

}
