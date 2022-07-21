package cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.service;

import java.util.ArrayList;
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
import cn.com.yusys.yusp.commons.util.StringTools;
import cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.repository.mapper.PmaFSchemeEvlobjRelMapper;
import cn.com.yusys.yusp.uimp.excel.util.CommonExcelUtil;
/**
 * @项目名称: uimp-business-pma-scheme-core模块
 * @类名称: PmaFSchemeEvlobjRelService
 * @类描述: #服务类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2020-02-19 19:28:43
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@Service
public class PmaFSchemeEvlobjRelService extends CommonService {
	
	private static final Logger logger = LoggerFactory.getLogger(PmaFSchemeEvlobjRelService.class);
	
    @Autowired
    private PmaFSchemeEvlobjRelMapper pmaFSchemeEvlobjRelMapper;

    @Override
    protected CommonMapper<?> getMapper() {
        return pmaFSchemeEvlobjRelMapper;
    }
    
    @Transactional(readOnly = true)
	public List<Map<String, Object>> querylist(QueryModel model) {
		PageHelper.startPage(model.getPage(), model.getSize());
		List<Map<String, Object>> list = pmaFSchemeEvlobjRelMapper.listByModel(model);
		PageHelper.clearPage();
		return list;
    }
	
	@Transactional(readOnly = true)
	public String queryNames(String objId) {
    	String result = "";
    	List<String> resultList = new ArrayList<String>();
    	try {
    		if(!StringTools.isEmpty(objId)) {
    			String[] ids = objId.split(",");
    			resultList = this.pmaFSchemeEvlobjRelMapper.queryNames(ids);
    			if(resultList.size() > 0) {
    				for(String s : resultList) {
    					result += s + ",";
    				}
    				result = result.substring(0, result.length() - 1);
    			}
    		}
    	} catch (Exception e) {
    		result = "-1";
    		e.printStackTrace();
    	}
    	return result;
    }

    /**
     * @方法名称: updateBackupTableData
     * @方法描述: 更新考核方案评价对象表(备份表)-数据
     * @参数与返回说明: 
     * @算法描述:
     */
    @Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
    public void updateBackupTableData(String schemeId, String etlDate) throws Exception {
    	try {
    		if(!StringTools.isEmpty(schemeId) && !StringTools.isEmpty(etlDate) &&
    				CommonExcelUtil.verifyDateStrByFormat(etlDate, "yyyyMMdd")) {
    			pmaFSchemeEvlobjRelMapper.deleteBackupTableDataBySchemeIdAndEtlDate(schemeId, etlDate);
    			pmaFSchemeEvlobjRelMapper.insertBackupTableData(schemeId, etlDate);
    		} else {
    			logger.warn("schemeId is null or etlDate format error, can not updateBackupTableData");
    		}
    	} catch (Exception e) {
    		e.printStackTrace();
    		throw e;
    	}
    }
    
    /**
	 * @函数名称: copySchemeInf
	 * @函数描述: 复制考核方案信息-考核方案评价对象表
	 * @参数与返回说明:
	 * @param schemeId 被复制的考核方案编号
	 * @param newSchemeId 新的考核方案编号
	 * @算法描述:
	 */
	@Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
	public void copySchemeInf(String schemeId, String newSchemeId) throws Exception {
	    try {
	    	pmaFSchemeEvlobjRelMapper.copySchemeInf(schemeId, newSchemeId);
	    } catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}
