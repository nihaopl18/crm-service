package cn.com.yusys.yusp.uimp.excel.service;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.uimp.base.service.UserInfoService;
import cn.com.yusys.yusp.uimp.excel.domain.PmaFschemeExcelgrantInf;
import cn.com.yusys.yusp.uimp.excel.repository.mapper.PmaFschemeExcelgrantInfMapper;
import tk.mybatis.mapper.util.StringUtil;
/**
 * @项目名称: uimp-business-pma-scheme-core模块
 * @类名称: PmaFschemeExcelgrantInfService
 * @类描述: #考核方案授权信息表 服务类
 * @功能描述: 
 * @创建人: lixt1
 * @创建时间: 2020-06-28 14:05:48
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class PmaFschemeExcelgrantInfService extends CommonService {
	
	private static final Logger logger = LoggerFactory.getLogger(PmaFschemeExcelgrantInfService.class);
	
    @Autowired
    private PmaFschemeExcelgrantInfMapper pmaFschemeExcelgrantInfMapper;
    
	@Autowired
	private UserInfoService userInfo; 

    @Override
    protected CommonMapper<?> getMapper() {
        return pmaFschemeExcelgrantInfMapper;
    }
    
    /**
     * @方法名称: getGrantInfBySchemeId
     * @方法描述: 根据考核方案ID，查询-方案授权信息
     * @参数与返回说明: 
     * @算法描述:
     */
    @Transactional(readOnly = true)
    public List<PmaFschemeExcelgrantInf> getGrantInfBySchemeId(QueryModel queryModel) {
    	if(queryModel.getCondition() != null && queryModel.getCondition().containsKey("schemeId")) {
    		PageHelper.startPage(queryModel.getPage(), queryModel.getSize());
    		List<PmaFschemeExcelgrantInf> list = pmaFschemeExcelgrantInfMapper.getGrantInfBySchemeId(queryModel);
    		PageHelper.clearPage();
    		return list;
    	} else {
    		logger.warn("schemeId is null, can not getGrantInfo");
			return null;
    	}
    }

    /**
     * @方法名称: addData
     * @方法描述: 新增授权数据
     * @参数与返回说明: 
     * @算法描述:
     */
    @Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
    public String addData(PmaFschemeExcelgrantInf record) throws Exception {
    	try {
    		if(record != null) {
    			if(pmaFschemeExcelgrantInfMapper.checkData(record) > 0) {
    				return "-3";
    			} else {
    				record.setCreateTime(new Date());
    				pmaFschemeExcelgrantInfMapper.insert(record);
    				return record.getId();
    			}
    		} else {
    			logger.warn("record is null, can not addData");
    			return "-9";
    		}
    	} catch (Exception e) {
    		e.printStackTrace();
    		throw e;
    	}
    }
    
    /**
     * @方法名称: deleteData
     * @方法描述: 删除授权数据
     * @参数与返回说明: 
     * @算法描述:
     */
    @Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
    public Integer deleteData(String ids) throws Exception {
    	try {
    		if(StringUtil.isNotEmpty(ids)) {
	        	return pmaFschemeExcelgrantInfMapper.deleteData(ids.split(","));
    		} else {
    			logger.warn("ids is null, can not deleteData");
    			return -9;
    		}
    	} catch (Exception e) {
    		e.printStackTrace();
    		throw e;
    	}
    }
    
    /**
     * @方法名称: getQuoteSchemeInf
     * @方法描述: 查询-可以引用的考核方案信息
     * @参数与返回说明: 
     * @算法描述:
     */
    @Transactional(readOnly = true)
    public List<PmaFschemeExcelgrantInf> getQuoteSchemeInf(QueryModel queryModel) {
    	queryModel.getCondition().put("orgCode", userInfo.getOrgCode());
    	PageHelper.startPage(queryModel.getPage(), queryModel.getSize());
		List<PmaFschemeExcelgrantInf> list = pmaFschemeExcelgrantInfMapper.getQuoteSchemeInf(queryModel);
		PageHelper.clearPage();
		return list;
    }
    
}
