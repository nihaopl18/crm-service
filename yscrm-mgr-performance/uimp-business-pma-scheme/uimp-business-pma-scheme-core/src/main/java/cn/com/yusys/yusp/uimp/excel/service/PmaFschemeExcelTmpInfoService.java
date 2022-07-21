package cn.com.yusys.yusp.uimp.excel.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.uimp.excel.domain.PmaFschemeExcelTmpInfo;
import cn.com.yusys.yusp.uimp.excel.repository.mapper.PmaFschemeExcelTmpInfoMapper;
import cn.com.yusys.yusp.uimp.excel.util.CommonExcelUtil;
import tk.mybatis.mapper.util.StringUtil;
/**
 * @项目名称: uimp-business-pma-scheme-core模块
 * @类名称: PmaFschemeExcelTmpInfoService
 * @类描述: #考核方案报表模板信息表 服务类
 * @功能描述: 
 * @创建人: lixt1
 * @创建时间: 2020-04-22 21:01:38
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class PmaFschemeExcelTmpInfoService extends CommonService {
	
	private static final Logger logger = LoggerFactory.getLogger(PmaFschemeExcelTmpInfoService.class);
	
    @Autowired
    private PmaFschemeExcelTmpInfoMapper pmaFschemeExcelTmpInfoMapper;

    @Override
    protected CommonMapper<?> getMapper() {
        return pmaFschemeExcelTmpInfoMapper;
    }
    
    /**
	 * @方法名称: indexSelectorQuerylist
	 * @方法描述: 考核方案-指标放大镜-查询列表数据(分页)
	 * @参数与返回说明: 
	 * @param model: condition-type: 1基础指标  2派生指标  0基础/派生都查询
	 * @算法描述: 
	 *   支持查询基础指标、派生指标数据
	 *   返回数据包含指标维度信息
	 */
    @Transactional(readOnly = true)
    public List<Map<String, Object>> indexSelectorQuerylist(QueryModel model) {
		List<Map<String, Object>> list = pmaFschemeExcelTmpInfoMapper.indexSelectorQuerylist(model);
		return list;
	}
    
    /**
	 * @方法名称: queryIndexNameByIndexId
	 * @方法描述: 根据指标编号，查询指标名称，包括基础指标/派生指标
	 * @参数与返回说明: 
	 * @算法描述: 
	 */
    @Transactional(readOnly = true)
    public String queryIndexNameByIndexId(String indexIds) {
    	String result = "";
    	List<String> resultList = new ArrayList<String>();
    	try {
    		if(!StringUtil.isEmpty(indexIds)) {
    			String[] ids = indexIds.split(",");
    			resultList = pmaFschemeExcelTmpInfoMapper.queryIndexNameByIndexId(ids);
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
     * @函数名称:getTmpInfoBySchemeId
     * @函数描述:根据考核方案ID，查询考核方案报表模板信息表数据
     * @参数与返回说明:
     * @算法描述:
     */
    @Transactional(readOnly = true)
    public PmaFschemeExcelTmpInfo getTmpInfoBySchemeId(String schemeId) {
    	if(StringUtil.isNotEmpty(schemeId)) {
    		return pmaFschemeExcelTmpInfoMapper.getTmpInfoBySchemeId(schemeId);
    	} else {
    		logger.warn("schemeId is null, can not getTmpInfo");
    		return null;
    	}
    }
    
    /**
     * @方法名称: updateBackupTableData
     * @方法描述: 更新模板信息表(备份表)-数据
     * @参数与返回说明: 
     * @算法描述:
     */
    @Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
    public Integer updateBackupTableData(PmaFschemeExcelTmpInfo tmpInfo, String etlDate) throws Exception {
    	try {
    		Integer deleteDataCount = 0; 
    		if(tmpInfo != null && StringUtil.isNotEmpty(etlDate) && 
				CommonExcelUtil.verifyDateStrByFormat(etlDate, "yyyyMMdd")) {
				// 根据考核方案ID、数据日期删除备份表中对应数据
				deleteDataCount = pmaFschemeExcelTmpInfoMapper.deleteBackupTableDataBySchemeIdAndEtlDate(tmpInfo.getSchemeId(), etlDate);
    			pmaFschemeExcelTmpInfoMapper.insertBackupTableData(tmpInfo, etlDate);
    		} else {
    			logger.warn("tmpInfo is null or etlDate format error, can not updateBackupTableData");
    		}
    		return deleteDataCount;
    	} catch (Exception e) {
    		e.printStackTrace();
    		throw e;
    	}
    }
    
    /**
     * @方法名称: getBackupTableDataCount
     * @方法描述: 根据考核方案ID，获取模板信息表(备份表)数据数量
     * @参数与返回说明: 
     *   0 未查到数据
     *   1 存在数据
     *   -9 请求参数错误
     * @算法描述:
     */
    @Transactional(readOnly = true)
    public Integer getBackupTableDataCount(String schemeId, String etlDate) throws Exception {
    	try {
    		if(StringUtil.isNotEmpty(schemeId) && StringUtil.isNotEmpty(etlDate)) {
				// 根据考核方案ID、数据日期查询备份表中对应数据条数
				PmaFschemeExcelTmpInfo tmpInfo = pmaFschemeExcelTmpInfoMapper.getTmpInfoFromBackupTableBySchemeIdAndEtlDate(schemeId, etlDate);
				return tmpInfo == null ? 0 : 1;
    		} else {
    			logger.warn("schemeId or etlDate is null, can not getBackupTableDataCount");
    			return -9;
    		}
    	} catch (Exception e) {
    		e.printStackTrace();
    		throw e;
    	}
    }
    
    /**
     * @函数名称:getTmpInfoFromBackupTableBySchemeIdAndEtlDate
     * @函数描述:根据考核方案ID、数据日期，查询考核方案报表模板信息表(备份表)数据
     * @参数与返回说明:
     * @算法描述:
     */
    @Transactional(readOnly = true)
    public PmaFschemeExcelTmpInfo getTmpInfoFromBackupTableBySchemeIdAndEtlDate(String schemeId, String etlDate) {
    	if(StringUtil.isNotEmpty(schemeId) && StringUtil.isNotEmpty(etlDate)) {
    		return pmaFschemeExcelTmpInfoMapper.getTmpInfoFromBackupTableBySchemeIdAndEtlDate(schemeId, etlDate);
    	} else {
    		logger.warn("schemeId or etlDate is null, can not getTmpInfo");
    		return null;
    	}
    }
    
    /**
	 * @函数名称: copySchemeInf
	 * @函数描述: 复制考核方案信息-考核方案报表模板信息表
	 * @参数与返回说明:
	 * @param schemeId 被复制的考核方案编号
	 * @param newSchemeId 新的考核方案编号
	 * @return 新生成的模板ID
	 * @算法描述:
	 */
	@Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
	public String copySchemeInf(String schemeId, String newSchemeId) throws Exception {
	    try {
	    	String templateId = UUID.randomUUID().toString().replaceAll("-","");
	    	pmaFschemeExcelTmpInfoMapper.copySchemeInf(templateId, schemeId, newSchemeId);
	    	return templateId;
	    } catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
    /**
     * @方法名称: getAppOrgSchemeEvlObjInfo
     * @方法描述: 根据考核方案编号、数据日期、考核对象编号，查询-APP机构考核方案-考核对象信息(备份表)
     * @参数与返回说明: 
     * @算法描述:
     */
    @Transactional(readOnly = true)
    public List<Map<String, Object>> getAppOrgSchemeEvlObjInfo(String schemeId, String etlDate, String evlObjId) {
    	if(StringUtil.isNotEmpty(schemeId) && StringUtil.isNotEmpty(etlDate) && StringUtil.isNotEmpty(evlObjId)) {
    		return pmaFschemeExcelTmpInfoMapper.getAppOrgSchemeEvlObjInfo(schemeId, etlDate, evlObjId);
    	} else {
    		logger.warn("schemeId etlDate or evlObjId is null, can not getAppOrgSchemeEvlObjInfo");
			return null;
    	}
	}
}
