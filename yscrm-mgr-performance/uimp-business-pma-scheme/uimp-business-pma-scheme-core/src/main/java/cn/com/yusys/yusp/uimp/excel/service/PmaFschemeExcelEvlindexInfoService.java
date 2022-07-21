package cn.com.yusys.yusp.uimp.excel.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.uimp.base.service.UserInfoService;
import cn.com.yusys.yusp.uimp.excel.domain.PmaFschemeExcelEvlindexInfo;
import cn.com.yusys.yusp.uimp.excel.repository.mapper.PmaFschemeExcelEvlindexInfoMapper;
import cn.com.yusys.yusp.uimp.excel.util.CommonExcelUtil;
import tk.mybatis.mapper.util.StringUtil;
/**
 * @项目名称: uimp-business-pma-scheme-core模块
 * @类名称: PmaFschemeExcelEvlindexInfoService
 * @类描述: #考核方案报表派生指标信息表 服务类
 * @功能描述: 
 * @创建人: lixt1
 * @创建时间: 2020-05-11 16:48:14
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class PmaFschemeExcelEvlindexInfoService extends CommonService {
	
	private static final Logger logger = LoggerFactory.getLogger(PmaFschemeExcelEvlindexInfoService.class);
	
    @Autowired
    private PmaFschemeExcelEvlindexInfoMapper pmaFschemeExcelEvlindexInfoMapper;
    
	@Autowired
	private UserInfoService userInfo; 

    @Override
    protected CommonMapper<?> getMapper() {
        return pmaFschemeExcelEvlindexInfoMapper;
    }

    /**
     * @方法名称: deleteByTemplateId
     * @方法描述: 根据 模板ID，删除数据
     * @参数与返回说明: 
     * @算法描述:
     */
    @Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
    public Integer deleteByTemplateId(String templateId) throws Exception {
    	Integer code = 0;
    	try {
    		if(StringUtil.isEmpty(templateId)) {
    			logger.warn("templateId is null, can not delete");
    			return -9;
    		}
    		code = pmaFschemeExcelEvlindexInfoMapper.deleteByTemplateId(templateId);
    	} catch (Exception e) {
    		logger.error("service deleteByTemplateId error !");
    		logger.error("error templateId is " + templateId);
    		e.printStackTrace();
    		throw e;
    	}
    	return code;
    }
    
    /**
     * @方法名称: batchInsert
     * @方法描述: 批量新增数据
     * @参数与返回说明: 
     * @算法描述:
     */
    @Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
    public Integer batchInsert(List<PmaFschemeExcelEvlindexInfo> dataList) throws Exception {
    	try {
    		if(dataList != null && dataList.size() > 0) {
    			int resultCount = 0;
    			// 分批次保存
    			int index = dataList.size() / 1000;
		        int remainder = dataList.size() % 1000;
		        for(int i = 0; i < (remainder == 0 ? index : index + 1); ++i) {
		        	resultCount += pmaFschemeExcelEvlindexInfoMapper.batchInsert(dataList.stream().skip(i*1000).limit(1000).collect(Collectors.toList()));
		        }
		        return resultCount;
    		} else {
    			logger.warn("dataList is null, can not batchInsert");
    			return -9;
    		}
    	} catch (Exception e) {
    		e.printStackTrace();
    		throw e;
    	}
    }
    
    /**
     * @方法名称: getCellInfoByTemplateId
     * @方法描述: 根据模板ID，查询-派生指标单元格数据
     * @参数与返回说明: 
     * @算法描述:
     */
    @Transactional(readOnly = true)
	public List<Map<String, Object>> getCellInfoByTemplateId(String templateId) {
    	if(StringUtil.isNotEmpty(templateId)) {
    		return pmaFschemeExcelEvlindexInfoMapper.getCellInfoByTemplateId(templateId);
    	} else {
    		logger.warn("templateId is null, can not getCellInfo");
			return null;
    	}
	}
    
	/**
     * @方法名称: getPreviewInfo
     * @方法描述: 根据模板ID、数据日期、考核对象编号，查询-派生指标单元格预览数据
     * @参数与返回说明: 
     * @算法描述:
     */
    @Transactional(readOnly = true)
	public List<Map<String, Object>> getPreviewInfo(String templateId, String etlDate, String evlObjId, String templateType) {
		if(StringUtil.isNotEmpty(templateId) && StringUtil.isNotEmpty(etlDate)) {
			return pmaFschemeExcelEvlindexInfoMapper.getPreviewInfo(templateId, etlDate, evlObjId, templateType);
		} else {
			logger.warn("templateId or etlDate is null, can not getPreviewInfo");
			return null;
		}
	}
    
    /**
     * @方法名称: updateBackupTableData
     * @方法描述: 更新派生指标信息表(备份表)-数据
     * @参数与返回说明: 
     * @算法描述:
     */
    @Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
    public void updateBackupTableData(String etlDate, String templateId, String templateType, String evlObjId,
    		List<Map<String, Object>> evlindexCellInfoList) throws Exception {
    	try {
    		if(StringUtil.isNotEmpty(templateId) && StringUtil.isNotEmpty(etlDate) && 
    				CommonExcelUtil.verifyDateStrByFormat(etlDate, "yyyyMMdd")) {
				// 根据模板ID、数据日期、考核对象编号删除备份表中对应数据
				if("02".equals(templateType)) {	// 单元格类型考核方案
					pmaFschemeExcelEvlindexInfoMapper.deleteBackupTableDataByTemplateIdAndEtlDateAndEvlObjId(templateId, etlDate, evlObjId);
				} else {	// 横/纵类型考核方案
					pmaFschemeExcelEvlindexInfoMapper.deleteBackupTableDataByTemplateIdAndEtlDateAndEvlObjId(templateId, etlDate, "");
				}
    			// 保存派生指标数据
    			if(evlindexCellInfoList != null && evlindexCellInfoList.size() > 0) {
        			// 分批次保存
        			int index = evlindexCellInfoList.size() / 1000;
    		        int remainder = evlindexCellInfoList.size() % 1000;
    		        for(int i = 0; i < (remainder == 0 ? index : index + 1); ++i) {
    		        	pmaFschemeExcelEvlindexInfoMapper.batchInsertBackupTableData(etlDate, evlindexCellInfoList.stream().skip(i*1000).limit(1000).collect(Collectors.toList()));
    		        }
        		}
    		} else {
    			logger.warn("templateId is null or etlDate format error, can not updateBackupTableData");
    		}
    	} catch (Exception e) {
    		e.printStackTrace();
    		throw e;
    	}    			
    }
    
    /**
     * @方法名称: getCellInfoFromBackupTableByTemplateIdAndEtlDateAndEvlObjId
     * @方法描述: 根据模板ID、数据日期、考核对象编号，查询-派生指标单元格数据(备份表)
     * @参数与返回说明: 
     * @算法描述:
     */
    @Transactional(readOnly = true)
    public List<Map<String, Object>> getCellInfoFromBackupTableByTemplateIdAndEtlDateAndEvlObjId(String templateId, String etlDate, String evlObjId) {
    	if(StringUtil.isNotEmpty(templateId) && StringUtil.isNotEmpty(etlDate)) {
    		return pmaFschemeExcelEvlindexInfoMapper.getCellInfoFromBackupTableByTemplateIdAndEtlDateAndEvlObjId(templateId, etlDate, evlObjId);
    	} else {
    		logger.warn("templateId or etlDate is null, can not getCellInfoFromBackupTable");
			return null;
    	}
	}
    
    /**
     * @方法名称: getMySchemeCellInfoFromBackupTable
     * @方法描述: 根据模板ID、数据日期、考核对象编号，查询-我的考核方案派生指标单元格数据(备份表)
     * @参数与返回说明: 
     * @算法描述:
     * 1、根据 方案类型/考核对象类型，查询对应权限数据
     * 2、根据hideRows、hideCols，排除对应行/列数据
     */
    @Transactional(readOnly = true)
    public List<Map<String, Object>> getMySchemeCellInfoFromBackupTable(String templateId, String etlDate, String evlObjId, 
    		String templateType, String evlObjType, String hideRows, String hideCols) {
    	if(StringUtil.isNotEmpty(templateId) && StringUtil.isNotEmpty(etlDate) && StringUtil.isNotEmpty(evlObjId)) {
    		return pmaFschemeExcelEvlindexInfoMapper.getMySchemeCellInfoFromBackupTable(templateId, etlDate, evlObjId, templateType, evlObjType,
    				StringUtil.isEmpty(hideRows) ? null : hideRows.split("\\$"),
					StringUtil.isEmpty(hideCols) ? null : hideCols.split("\\$"));
    	} else {
    		logger.warn("templateId etlDate or evlObjId is null, can not getMySchemeCellInfoFromBackupTable");
			return null;
    	}
	}
    
    /**
     * @方法名称: getOrgStaffSchemeCellInfoFromBackupTable
     * @方法描述: 根据模板ID、数据日期、考核对象编号，查询-机构辖内员工对象的考核方案派生指标单元格数据(备份表)
     * @参数与返回说明: 
     * @算法描述:
     * 1、根据 方案类型/考核对象类型，查询对应权限数据
     * 2、根据hideRows、hideCols，排除对应行/列数据
     */
    @Transactional(readOnly = true)
    public List<Map<String, Object>> getOrgStaffSchemeCellInfoFromBackupTable(String templateId, String etlDate, String evlObjId, 
    		String templateType, String evlObjType, String hideRows, String hideCols) {
    	if(StringUtil.isNotEmpty(templateId) && StringUtil.isNotEmpty(etlDate)) {
    		return pmaFschemeExcelEvlindexInfoMapper.getOrgStaffSchemeCellInfoFromBackupTable(templateId, etlDate, evlObjId, 
    				userInfo.getUserInfo().getOrg().getCode(), templateType, evlObjType,
    				StringUtil.isEmpty(hideRows) ? null : hideRows.split("\\$"),
					StringUtil.isEmpty(hideCols) ? null : hideCols.split("\\$"));
    	} else {
    		logger.warn("templateId or etlDate is null, can not getOrgStaffSchemeCellInfoFromBackupTable");
			return null;
    	}
	}
    
    /**
	 * @函数名称: copySchemeInf
	 * @函数描述: 复制考核方案信息-考核方案报表派生指标信息表
	 * @参数与返回说明:
	 * @param templateId 被复制的模板ID
	 * @param newTemplateId 新的模板ID
	 * @算法描述:
	 */
	@Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
	public void copySchemeInf(String templateId, String newTemplateId) throws Exception {
	    try {
	    	pmaFschemeExcelEvlindexInfoMapper.copySchemeInf(templateId, newTemplateId);
	    } catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
    /**
     * @方法名称: getAppMySchemeResultInfoFromBackupTable
     * @方法描述: 根据模板ID、数据日期、考核对象编号，查询-APP员工考核方案派生指标单元格数据(备份表)
     * @参数与返回说明: 
     * @算法描述:
     * 1、根据 方案类型/考核对象类型，查询对应权限数据
     * 2、根据hideRows、hideCols，排除对应行/列数据
     */
    @Transactional(readOnly = true)
    public List<Map<String, Object>> getAppMySchemeResultInfoFromBackupTable(String templateId, String etlDate, String evlObjId, 
    		String templateType, String evlObjType, String hideRows, String hideCols) {
    	if(StringUtil.isNotEmpty(templateId) && StringUtil.isNotEmpty(etlDate) && StringUtil.isNotEmpty(evlObjId)) {
    		return pmaFschemeExcelEvlindexInfoMapper.getAppMySchemeResultInfoFromBackupTable(templateId, etlDate, evlObjId, templateType, evlObjType,
    				StringUtil.isEmpty(hideRows) ? null : hideRows.split("\\$"),
					StringUtil.isEmpty(hideCols) ? null : hideCols.split("\\$"));
    	} else {
    		logger.warn("templateId etlDate or evlObjId is null, can not getAppMySchemeResultInfoFromBackupTable");
			return null;
    	}
	}
    
    /**
     * @方法名称: getAppOrgSchemeResultInfoFromBackupTable
     * @方法描述: 根据模板ID、数据日期、考核对象编号，查询-APP机构考核方案派生指标单元格数据(备份表)
     * @参数与返回说明: 
     * @算法描述:
     * 1、根据 方案类型/考核对象类型，查询对应权限数据
     * 2、根据hideRows、hideCols，排除对应行/列数据
     */
    @Transactional(readOnly = true)
    public List<Map<String, Object>> getAppOrgSchemeResultInfoFromBackupTable(String templateId, String etlDate, String evlObjId, 
    		String templateType, String evlObjType, String hideRows, String hideCols) {
    	if(StringUtil.isNotEmpty(templateId) && StringUtil.isNotEmpty(etlDate) && StringUtil.isNotEmpty(evlObjId)) {
    		return pmaFschemeExcelEvlindexInfoMapper.getAppOrgSchemeResultInfoFromBackupTable(templateId, etlDate, evlObjId, templateType, evlObjType,
    				StringUtil.isEmpty(hideRows) ? null : hideRows.split("\\$"),
					StringUtil.isEmpty(hideCols) ? null : hideCols.split("\\$"));
    	} else {
    		logger.warn("templateId etlDate or evlObjId is null, can not getAppOrgSchemeResultInfoFromBackupTable");
			return null;
    	}
	}
}
