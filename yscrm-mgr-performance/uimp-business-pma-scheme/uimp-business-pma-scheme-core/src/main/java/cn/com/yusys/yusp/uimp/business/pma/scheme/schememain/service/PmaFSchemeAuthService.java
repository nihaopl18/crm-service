package cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yusp.uimp.base.service.UserInfoService;
import cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.domain.PmaFSchemeAuth;
import cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.repository.mapper.PmaFSchemeAuthMapper;
import cn.com.yusys.yusp.uimp.excel.domain.PmaFschemeExcelgrantInf;
import cn.com.yusys.yusp.uimp.excel.service.CommonExcelService;
import tk.mybatis.mapper.util.StringUtil;
/**
 * @项目名称: uimp-business-pma-scheme-core模块
 * @类名称: PmaFSchemeAuthService
 * @类描述: #服务类
 * @功能描述: 
 * @创建人: 13842
 * @创建时间: 2020-04-26 15:05:00
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@Service
public class PmaFSchemeAuthService extends CommonService {
	
	private static final Logger logger = LoggerFactory.getLogger(PmaFSchemeAuthService.class);
    @Autowired
    private PmaFSchemeAuthMapper pmaFSchemeAuthMapper;
    @Autowired
    private UserInfoService userInfoService;
    @Override
    protected CommonMapper<?> getMapper() {
        return pmaFSchemeAuthMapper;
    }

    @Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
    public ResultDto<String> addInfo(List<PmaFSchemeAuth> list){
    	ResultDto<String> result = new ResultDto<String>();
    	if(list.size() > 0) {
    		String shemeId = list.get(0).getSchemeId();
        	pmaFSchemeAuthMapper.deleteByScheme(shemeId);
    		for(int i=0;i<list.size();i++) {
    			PmaFSchemeAuth pmaFSchemeAuth = list.get(i);
    			pmaFSchemeAuthMapper.insertSelective(pmaFSchemeAuth);
    		}
    	}
    	result.setCode(0);
    	result.setMessage("新增成功");
    	return result;
    }
    
    @Transactional(readOnly = true)
	public List<Map<String, Object>> queryList(QueryModel model) {
		List<Map<String, Object>> list = pmaFSchemeAuthMapper.listByModel(model);
		return list;
    }
    
    @Transactional(readOnly = true)
  	public List<Map<String, Object>> queryListByModel(QueryModel model) {
    	PageHelper.startPage(model.getPage(), model.getSize());
    	model.getCondition().put("orgCode", userInfoService.getGrantOrgCode());
  		List<Map<String, Object>> list = pmaFSchemeAuthMapper.listByModel(model);
  		PageHelper.clearPage();
  		return list;
    }

    /**
     * @函数名称: addGrantInf
     * @函数描述: 新增  考核方案授权信息
     * @参数与返回说明:
     * @算法描述:
     */
    @Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
    public String addGrantInf(PmaFSchemeAuth record) throws Exception {
    	try {
    		if(record != null) {
    			if(pmaFSchemeAuthMapper.checkData(record) > 0) {
    				return "-3";
    			} else {
    				record.setCreateTime(new Date());
    				pmaFSchemeAuthMapper.insert(record);
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
     * @函数名称: deleteGrantInf
     * @函数描述: 批量删除授权信息 
     * @参数与返回说明:
     * @算法描述:
     */
    @Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
    public Integer deleteGrantInf(String ids) throws Exception {
    	try {
    		if(StringUtil.isNotEmpty(ids)) {
	        	return pmaFSchemeAuthMapper.deleteData(ids.split(","));
    		} else {
    			logger.warn("ids is null, can not deleteData");
    			return -9;
    		}
    	} catch (Exception e) {
    		e.printStackTrace();
    		throw e;
    	}
    }
    

}
