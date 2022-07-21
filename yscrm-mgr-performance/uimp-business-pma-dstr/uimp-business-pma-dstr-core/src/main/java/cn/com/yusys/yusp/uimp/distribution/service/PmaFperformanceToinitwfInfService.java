package cn.com.yusys.yusp.uimp.distribution.service;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.uimp.distribution.domain.PmaFperformanceToinitwfInf;
import cn.com.yusys.yusp.uimp.distribution.repository.mapper.PmaFperformanceToinitwfInfMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.util.StringUtil;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
/**
 * @项目名称: uimp-business-pma-dstr-core模块
 * @类名称: PmaFperformanceToinitwfInfService
 * @类描述: #业绩批量导入工作流待发起信息表 服务类
 * @功能描述: 
 * @创建人: lixt1
 * @创建时间: 2020-10-22 01:14:15
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class PmaFperformanceToinitwfInfService extends CommonService {
	
	private static final Logger log = LoggerFactory.getLogger(PmaFperformanceToinitwfInfService.class);
	
    @Autowired
    private PmaFperformanceToinitwfInfMapper pmaFperformanceToinitwfInfMapper;

    @Override
    protected CommonMapper<?> getMapper() {
        return pmaFperformanceToinitwfInfMapper;
    }
    
    /**
     * @方法名称: batchInsertToinitwfInf
	 * @方法描述: 批量保存  业绩批量导入工作流待发起信息表数据
	 * @参数与返回说明: 
	 * @param instanceList 数据集
	 * @param funCode 业绩类型
	 * @param batchId  批次号
	 * @param periodHisTableName  分配区间历史表表名
	 * @param dtlTableName  批量导入明细表表名
	 * @param isReStartWf  是否重新发起审批
	 * @param workFlow  流程标识
     * @算法描述:
     */
    @Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
    public Integer batchInsertToinitwfInf(List<Map<String, Object>> instanceList, 
    		String funCode, String batchId, String periodHisTableName,
    		String dtlTableName, String isReStartWf, String workFlow, String userId) throws Exception {
    	try {
    		if(instanceList != null && instanceList.size() > 0 && StringUtil.isNotEmpty(batchId)) {
    			int resultCount = 0;
    			// 分批次保存
    			int index = instanceList.size() / 1000;
		        int remainder = instanceList.size() % 1000;
		        for(int i = 0; i < (remainder == 0 ? index : index + 1); ++i) {
		        	resultCount += pmaFperformanceToinitwfInfMapper.batchInsertToinitwfInf(instanceList.stream().skip(i*1000).limit(1000).collect(Collectors.toList()),
		        			funCode, batchId, periodHisTableName,
		        			dtlTableName, isReStartWf, workFlow, 
		        			userId, "0");
		        }
		        return resultCount;
    		} else {
    			log.warn("instanceList or batchId is null, can not batchInsertToinitwfInf");
    			return -9;
    		}
    	} catch (Exception e) {
    		log.error("batchId: " + batchId + "; batchInsertToinitwfInf error: ", e);
    		throw e;
    	}
    }
    
    /**
     * @方法名称: getEarlyApplyIdsByCount
     * @方法描述: 获取 业绩批量导入工作流待发起信息表-审批编号字段值
     * @参数与返回说明: 
     * @算法描述:
     */
    @Transactional(readOnly = true)
	public List<String> getEarlyApplyIdsByCount(Integer count) {
		if(count != null && count > 0) {
    		return pmaFperformanceToinitwfInfMapper.getEarlyApplyIdsByCount(count);
    	} else {
    		log.warn("count is null or is zero, can not getEarlyApplyIdsByCount");
			return null;
    	}
	}
    
    /**
     * @方法名称: deleteByApplyId
     * @方法描述: 根据审批编号 删除业绩批量导入工作流待发起信息表数据
     * @参数与返回说明: 
     * @算法描述:
     */
    @Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
    public Integer deleteByApplyId(String applyId) throws Exception {
    	Integer code = 0;
    	try {
    		if(StringUtil.isEmpty(applyId)) {
    			log.warn("applyId is null, can not delete");
    			return -9;
    		}
    		code = pmaFperformanceToinitwfInfMapper.deleteByApplyId(applyId);
    	} catch (Exception e) {
    		log.error("applyId:" + applyId + "; deleteByApplyId error: ", e);
    		throw e;
    	}
    	return code;
    }
    
    /**
     * @方法名称: getToinitwfInfByApplyIds
     * @方法描述: 根据applyIds获取 业绩批量导入工作流待发起信息表数据
     * @参数与返回说明: 
     * @算法描述:
     */
    @Transactional(readOnly = true)
	public List<PmaFperformanceToinitwfInf> getToinitwfInfByApplyIds(List<String> applyIds) {
		if(applyIds != null && applyIds.size() > 0) {
    		return pmaFperformanceToinitwfInfMapper.getToinitwfInfByApplyIds(applyIds);
    	} else {
    		log.warn("applyIds is null or is zero, can not getToinitwfInfByApplyIds");
			return null;
    	}
	}
    
    /**
     * @方法名称: updateExecuteStatusByApplyIds
     * @方法描述: 根据applyIds 更新业绩批量导入工作流待发起信息表-执行状态字段值为-executeStatus
     * @参数与返回说明: 
     * @算法描述:
     */
    @Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
    public Integer updateExecuteStatusByApplyIds(String executeStatus, List<String> applyIds) {
    	Integer code = 0;
    	try {
    		if(applyIds == null || applyIds.size() == 0) {
    			log.warn("applyIds is null, can not updateExecuteStatusByApplyIds");
    			return -9;
    		}
    		// 分批次更新
    		int index = applyIds.size() / 100;
	        int remainder = applyIds.size() % 100;
	        for(int i = 0; i < (remainder == 0 ? index : index + 1); ++i) {
	        	code += pmaFperformanceToinitwfInfMapper.updateExecuteStatusByApplyIds(executeStatus, 
	        			applyIds.stream().skip(i*100).limit(100).collect(Collectors.toList()));
	        }
    	} catch (Exception e) {
    		log.error("updateExecuteStatusByApplyIds error, executeStatus:" + executeStatus + "; applyIds:" + String.join(",", applyIds), e);
    	}
    	return code;
    }
}
