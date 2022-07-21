package cn.com.yusys.yusp.uimp.excel.service;

import java.util.ArrayList;
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
import cn.com.yusys.yusp.uimp.excel.domain.PmaFschemeExcelCellInfo;
import cn.com.yusys.yusp.uimp.excel.repository.mapper.PmaFschemeExcelCellInfoMapper;
import cn.com.yusys.yusp.uimp.excel.util.CommonExcelUtil;
import tk.mybatis.mapper.util.StringUtil;
/**
 * @项目名称: uimp-business-pma-scheme-core模块
 * @类名称: PmaFschemeExcelCellInfoService
 * @类描述: #考核方案报表单元格信息表 服务类
 * @功能描述: 
 * @创建人: lixt1
 * @创建时间: 2020-04-22 21:03:07
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class PmaFschemeExcelCellInfoService extends CommonService {
	
	private static final Logger logger = LoggerFactory.getLogger(PmaFschemeExcelCellInfoService.class);
	
    @Autowired
    private PmaFschemeExcelCellInfoMapper pmaFschemeExcelCellInfoMapper;

    @Override
    protected CommonMapper<?> getMapper() {
        return pmaFschemeExcelCellInfoMapper;
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
    		code = pmaFschemeExcelCellInfoMapper.deleteByTemplateId(templateId);
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
    public Integer batchInsert(List<PmaFschemeExcelCellInfo> dataList) throws Exception {
    	try {
    		if(dataList != null && dataList.size() > 0) {
    			int resultCount = 0;
    			// 分批次保存
    			int index = dataList.size() / 1000;
		        int remainder = dataList.size() % 1000;
		        for(int i = 0; i < (remainder == 0 ? index : index + 1); ++i) {
		        	resultCount += pmaFschemeExcelCellInfoMapper.batchInsert(dataList.stream().skip(i*1000).limit(1000).collect(Collectors.toList()));
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
     * @方法描述: 根据模板ID，查询考核方案报表单元格信息表-一般单元格数据
     * @参数与返回说明: 
     * @算法描述:
     */
    @Transactional(readOnly = true)
    public List<PmaFschemeExcelCellInfo> getCellInfoByTemplateId(String templateId) {
    	if(StringUtil.isNotEmpty(templateId)) {
    		String cellType = "01";	// 一般单元格
    		return pmaFschemeExcelCellInfoMapper.getCellInfoByTemplateIdAndCellType(templateId, cellType);
    	} else {
    		logger.warn("templateId is null, can not getCellInfo");
			return null;
    	}
    }
    
    /**
     * @方法名称: updateBackupTableData
     * @方法描述: 更新单元格信息表(备份表)-数据
     * @参数与返回说明: 
     * @算法描述:
     */
    @Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
    public void updateBackupTableData(String etlDate, String templateId, List<PmaFschemeExcelCellInfo> commonCellInfoList, 
    		List<Map<String, Object>> objCellInfoList, List<Map<String, Object>> indexCellInfoList, 
    		List<Map<String, Object>> evlindexCellInfoList, List<Map<String, Object>> formulaCellInfoList,
    		List<Map<String, Object>> orgparamCellInfoList, List<Map<String, Object>> pstparamCellInfoList,
    		List<Map<String, Object>> svwCellInfoList, List<Map<String, Object>> dutyCellInfoList,
    		List<Map<String, Object>> orgCellInfoList, List<Map<String, Object>> objIdCellInfoList) throws Exception {
    	try {
    		if(StringUtil.isNotEmpty(templateId) && StringUtil.isNotEmpty(etlDate) && 
    				CommonExcelUtil.verifyDateStrByFormat(etlDate, "yyyyMMdd")) {
				// 根据模板ID、数据日期删除备份表中对应数据
				pmaFschemeExcelCellInfoMapper.deleteBackupTableDataByTemplateIdAndEtlDate(templateId, etlDate);
    			// 保存一般单元格数据
    			if(commonCellInfoList != null && commonCellInfoList.size() > 0) {
        			// 分批次保存
        			int index = commonCellInfoList.size() / 1000;
    		        int remainder = commonCellInfoList.size() % 1000;
    		        for(int i = 0; i < (remainder == 0 ? index : index + 1); ++i) {
    		        	pmaFschemeExcelCellInfoMapper.batchInsertBackupTableCommonCellData(etlDate, commonCellInfoList.stream().skip(i*1000).limit(1000).collect(Collectors.toList()));
    		        }
        		}
    			// 合并其他单元格数据，并保存
    			List<Map<String, Object>> otherCellInfoList = new ArrayList<Map<String, Object>>();
    			if(objCellInfoList != null) {
    				otherCellInfoList.addAll(objCellInfoList);
    			}
    			if(indexCellInfoList != null) {
    				otherCellInfoList.addAll(indexCellInfoList);
    			}
    			if(evlindexCellInfoList != null) {
    				otherCellInfoList.addAll(evlindexCellInfoList);
    			}
    			if(formulaCellInfoList != null) {
    				otherCellInfoList.addAll(formulaCellInfoList);
    			}
    			if(orgparamCellInfoList != null) {
    				otherCellInfoList.addAll(orgparamCellInfoList);
    			}
    			if(pstparamCellInfoList != null) {
    				otherCellInfoList.addAll(pstparamCellInfoList);
    			}
    			if(svwCellInfoList != null) {
    				otherCellInfoList.addAll(svwCellInfoList);
    			}
    			if(dutyCellInfoList != null) {
    				otherCellInfoList.addAll(dutyCellInfoList);
    			}
    			if(orgCellInfoList != null) {
    				otherCellInfoList.addAll(orgCellInfoList);
    			}
    			if(objIdCellInfoList != null) {
    				otherCellInfoList.addAll(objIdCellInfoList);
    			}
    			if(otherCellInfoList != null && otherCellInfoList.size() > 0) {
        			// 分批次保存
        			int index = otherCellInfoList.size() / 1000;
    		        int remainder = otherCellInfoList.size() % 1000;
    		        for(int i = 0; i < (remainder == 0 ? index : index + 1); ++i) {
    		        	pmaFschemeExcelCellInfoMapper.batchInsertBackupTableOtherCellData(etlDate, otherCellInfoList.stream().skip(i*1000).limit(1000).collect(Collectors.toList()));
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
     * @方法名称: getCellInfoFromBackupTableByTemplateIdAndEtlDate
     * @方法描述: 根据模板ID、数据日期，查询考核方案报表单元格信息表(备份表)-一般单元格数据
     * @参数与返回说明: 
     * @算法描述:
     */
    @Transactional(readOnly = true)
	public List<PmaFschemeExcelCellInfo> getCellInfoFromBackupTableByTemplateIdAndEtlDate(String templateId, String etlDate) {
		if(StringUtil.isNotEmpty(templateId) && StringUtil.isNotEmpty(etlDate)) {
    		String cellType = "01";	// 一般单元格
    		return pmaFschemeExcelCellInfoMapper.getCellInfoFromBackupTableByTemplateIdAndEtlDateAndCellType(templateId, etlDate, cellType);
    	} else {
    		logger.warn("templateId or etlDate is null, can not getCellInfoFromBackupTable");
			return null;
    	}
	}
    
    /**
     * @方法名称: getMySchemeCellInfoFromBackupTable
     * @方法描述: 根据模板ID、数据日期，查询我的考核方案报表单元格信息表(备份表)-一般单元格数据
     * @参数与返回说明: 
     * @算法描述:
     * 需要排除隐藏行/列数据
     */
    @Transactional(readOnly = true)
	public List<PmaFschemeExcelCellInfo> getMySchemeCellInfoFromBackupTable(String templateId, String etlDate, String hideRows, String hideCols) {
		if(StringUtil.isNotEmpty(templateId) && StringUtil.isNotEmpty(etlDate)) {
    		String cellType = "01";	// 一般单元格
			return pmaFschemeExcelCellInfoMapper.getMySchemeCellInfoFromBackupTable(templateId, etlDate, cellType,
					StringUtil.isEmpty(hideRows) ? null : hideRows.split("\\$"),
					StringUtil.isEmpty(hideCols) ? null : hideCols.split("\\$"));
    	} else {
    		logger.warn("templateId or etlDate is null, can not getMySchemeCellInfoFromBackupTable");
			return null;
    	}
	}
    
    /**
	 * @函数名称: copySchemeInf
	 * @函数描述: 复制考核方案信息-考核方案报表单元格信息表
	 * @参数与返回说明:
	 * @param templateId 被复制的模板ID
	 * @param newTemplateId 新的模板ID
	 * @算法描述:
	 */
	@Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
	public void copySchemeInf(String templateId, String newTemplateId) throws Exception {
	    try {
	    	pmaFschemeExcelCellInfoMapper.copySchemeInf(templateId, newTemplateId);
	    } catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}
