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
import cn.com.yusys.yusp.uimp.excel.domain.PmaFschemeExcelObjInfo;
import cn.com.yusys.yusp.uimp.excel.repository.mapper.PmaFschemeExcelObjInfoMapper;
import cn.com.yusys.yusp.uimp.excel.util.CommonExcelUtil;
import tk.mybatis.mapper.util.StringUtil;
/**
 * @项目名称: uimp-business-pma-scheme-core模块
 * @类名称: PmaFschemeExcelObjInfoService
 * @类描述: #考核方案报表考核对象信息表 服务类
 * @功能描述: 
 * @创建人: lixt1
 * @创建时间: 2020-04-22 21:03:53
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class PmaFschemeExcelObjInfoService extends CommonService {
	
	private static final Logger logger = LoggerFactory.getLogger(PmaFschemeExcelObjInfoService.class);
	
    @Autowired
    private PmaFschemeExcelObjInfoMapper pmaFschemeExcelObjInfoMapper;
    
	@Autowired
	private UserInfoService userInfo; 

    @Override
    protected CommonMapper<?> getMapper() {
        return pmaFschemeExcelObjInfoMapper;
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
    		code = pmaFschemeExcelObjInfoMapper.deleteByTemplateId(templateId);
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
    public Integer batchInsert(List<PmaFschemeExcelObjInfo> dataList) throws Exception {
    	try {
    		if(dataList != null && dataList.size() > 0) {
    			int resultCount = 0;
    			// 分批次保存
    			int index = dataList.size() / 1000;
		        int remainder = dataList.size() % 1000;
		        for(int i = 0; i < (remainder == 0 ? index : index + 1); ++i) {
		        	resultCount += pmaFschemeExcelObjInfoMapper.batchInsert(dataList.stream().skip(i*1000).limit(1000).collect(Collectors.toList()));
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
     * @方法描述: 根据模板ID，查询-考核对象单元格数据
     * @参数与返回说明: 
     * @算法描述:
     */
    @Transactional(readOnly = true)
	public List<Map<String, Object>> getCellInfoByTemplateId(String templateId) {
    	if(StringUtil.isNotEmpty(templateId)) {
    		return pmaFschemeExcelObjInfoMapper.getCellInfoByTemplateId(templateId);
    	} else {
    		logger.warn("templateId is null, can not getCellInfo");
			return null;
    	}
	}
    
    /**
     * @方法名称: updateBackupTableData
     * @方法描述: 更新考核对象信息表(备份表)-数据
     * @参数与返回说明: 
     * @算法描述:
     */
    @Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
    public void updateBackupTableData(String etlDate, String templateId, List<Map<String, Object>> objCellInfoList) throws Exception {
    	try {
    		if(StringUtil.isNotEmpty(templateId) && StringUtil.isNotEmpty(etlDate) && 
    				CommonExcelUtil.verifyDateStrByFormat(etlDate, "yyyyMMdd")) {
				// 根据模板ID、数据日期删除备份表中对应数据
				pmaFschemeExcelObjInfoMapper.deleteBackupTableDataByTemplateIdAndEtlDate(templateId, etlDate);
    			// 保存考核对象信息表数据
    			if(objCellInfoList != null && objCellInfoList.size() > 0) {
        			// 分批次保存
        			int index = objCellInfoList.size() / 1000;
    		        int remainder = objCellInfoList.size() % 1000;
    		        for(int i = 0; i < (remainder == 0 ? index : index + 1); ++i) {
    		        	pmaFschemeExcelObjInfoMapper.batchInsertBackupTableData(etlDate, objCellInfoList.stream().skip(i*1000).limit(1000).collect(Collectors.toList()));
    		        }
        		}
    		}
    	} catch (Exception e) {
    		e.printStackTrace();
    		throw e;
    	}
    }

    /**
     * @方法名称: getCellInfoFromBackupTableByTemplateIdAndEtlDate
     * @方法描述: 根据模板ID、数据日期，查询-考核对象单元格数据(备份表)
     * @参数与返回说明: 
     * @算法描述:
     */
    @Transactional(readOnly = true)
    public List<Map<String, Object>> getCellInfoFromBackupTableByTemplateIdAndEtlDate(String templateId, String etlDate) {
    	if(StringUtil.isNotEmpty(templateId) && StringUtil.isNotEmpty(etlDate)) {
    		return pmaFschemeExcelObjInfoMapper.getCellInfoFromBackupTableByTemplateIdAndEtlDate(templateId, etlDate);
    	} else {
    		logger.warn("templateId or etlDate is null, can not getCellInfoFromBackupTable");
			return null;
    	}
	}
    
    /**
     * @方法名称: getMySchemeCellInfoFromBackupTable
     * @方法描述: 根据模板ID、数据日期、考核对象编号，查询-我的考核方案考核对象单元格数据(备份表)
     * @参数与返回说明: 
     * @算法描述:
     * 1、根据 方案类型/考核对象类型，查询对应权限数据
     * 2、根据hideRows、hideCols，排除对应行/列数据
     */
    @Transactional(readOnly = true)
    public List<Map<String, Object>> getMySchemeCellInfoFromBackupTable(String templateId, String etlDate, String evlObjId, 
    		String templateType, String evlObjType, String hideRows, String hideCols) {
    	if(StringUtil.isNotEmpty(templateId) && StringUtil.isNotEmpty(etlDate) && StringUtil.isNotEmpty(evlObjId)) {
    		return pmaFschemeExcelObjInfoMapper.getMySchemeCellInfoFromBackupTable(templateId, etlDate, evlObjId, templateType, evlObjType,
    				StringUtil.isEmpty(hideRows) ? null : hideRows.split("\\$"),
					StringUtil.isEmpty(hideCols) ? null : hideCols.split("\\$"));
    	} else {
    		logger.warn("templateId etlDate or evlObjId is null, can not getMySchemeCellInfoFromBackupTable");
			return null;
    	}
	}
    
    /**
     * @方法名称: getOrgStaffSchemeCellInfoFromBackupTable
     * @方法描述: 根据模板ID、数据日期、考核对象编号，查询-机构辖内员工对象的考核方案考核对象单元格数据(备份表)
     * @参数与返回说明: 
     * @算法描述:
     * 1、根据 方案类型/考核对象类型，查询对应权限数据
     * 2、根据hideRows、hideCols，排除对应行/列数据
     */
    @Transactional(readOnly = true)
    public List<Map<String, Object>> getOrgStaffSchemeCellInfoFromBackupTable(String templateId, String etlDate, String evlObjId, 
    		String templateType, String evlObjType, String hideRows, String hideCols) {
    	if(StringUtil.isNotEmpty(templateId) && StringUtil.isNotEmpty(etlDate)) {
    		return pmaFschemeExcelObjInfoMapper.getOrgStaffSchemeCellInfoFromBackupTable(templateId, etlDate, evlObjId, 
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
	 * @函数描述: 复制考核方案信息-考核方案报表考核对象信息表
	 * @参数与返回说明:
	 * @param templateId 被复制的模板ID
	 * @param newTemplateId 新的模板ID
	 * @算法描述:
	 */
	@Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
	public void copySchemeInf(String templateId, String newTemplateId) throws Exception {
	    try {
	    	pmaFschemeExcelObjInfoMapper.copySchemeInf(templateId, newTemplateId);
	    } catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}
