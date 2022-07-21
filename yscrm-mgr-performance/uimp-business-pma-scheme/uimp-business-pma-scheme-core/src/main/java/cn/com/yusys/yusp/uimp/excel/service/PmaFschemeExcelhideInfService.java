package cn.com.yusys.yusp.uimp.excel.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.uimp.excel.domain.PmaFschemeExcelhideInf;
import cn.com.yusys.yusp.uimp.excel.repository.mapper.PmaFschemeExcelhideInfMapper;
import tk.mybatis.mapper.util.StringUtil;
/**
 * @项目名称: uimp-business-pma-scheme-core模块
 * @类名称: PmaFschemeExcelhideInfService
 * @类描述: #考核方案发布隐藏行列信息表 服务类
 * @功能描述: 
 * @创建人: lixt1
 * @创建时间: 2020-05-27 15:17:46
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class PmaFschemeExcelhideInfService extends CommonService {
	
	private static final Logger logger = LoggerFactory.getLogger(PmaFschemeExcelhideInfService.class);
	
    @Autowired
    private PmaFschemeExcelhideInfMapper pmaFschemeExcelhideInfMapper;

    @Override
    protected CommonMapper<?> getMapper() {
        return pmaFschemeExcelhideInfMapper;
    }

    /**
     * @函数名称:getHideInfoBySchemeIdAndEtlDate
     * @函数描述:根据考核方案ID、数据日期，查询考核方案报表发布隐藏行列信息表数据
     * @参数与返回说明:
     * @算法描述:
     */
    @Transactional(readOnly = true)
    public PmaFschemeExcelhideInf getHideInfoBySchemeIdAndEtlDate(String schemeId, String etlDate) {
    	if(StringUtil.isNotEmpty(schemeId) && StringUtil.isNotEmpty(etlDate)) {
    		return pmaFschemeExcelhideInfMapper.getHideInfoBySchemeIdAndEtlDate(schemeId, etlDate);
    	} else {
    		logger.warn("schemeId or etlDate is null, can not getHideInfo");
    		return null;
    	}
    }
}
