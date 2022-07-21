package cn.com.yusys.yusp.uimp.distribution.service;

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
import cn.com.yusys.yusp.uimp.distribution.domain.PmaFperformanceTobatchInf;
import cn.com.yusys.yusp.uimp.distribution.repository.mapper.PmaFperformanceTobatchInfMapper;
import tk.mybatis.mapper.util.StringUtil;
/**
 * @项目名称: uimp-business-pma-dstr-core模块
 * @类名称: PmaFperformanceTobatchInfService
 * @类描述: #业绩批量导入待执行批次数据信息表 服务类
 * @功能描述: 
 * @创建人: lixt1
 * @创建时间: 2020-10-25 11:51:48
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class PmaFperformanceTobatchInfService extends CommonService {
	
	private static final Logger log = LoggerFactory.getLogger(PmaFperformanceTobatchInfService.class);
	
    @Autowired
    private PmaFperformanceTobatchInfMapper pmaFperformanceTobatchInfMapper;

    @Override
    protected CommonMapper<?> getMapper() {
        return pmaFperformanceTobatchInfMapper;
    }
    
	/**
	 * @方法名称: queryList
	 * @参数与返回说明:
	 * @算法描述: 无
	 */
	public List<Map<String, Object>> queryList(QueryModel model) {
		PageHelper.startPage(model.getPage(), model.getSize());
		List<Map<String, Object>> list = pmaFperformanceTobatchInfMapper.queryList(model);
		PageHelper.clearPage();
		return list;
	}
    
    /**
     * @方法名称: addToBatchInf
     * @方法描述: 新增 业绩批量导入待执行批次数据信息表-数据
     * @参数与返回说明: 
     * @算法描述:
     */
    @Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
	public Integer addToBatchInf(String batchId, String funCode, String userId, String role, String unitLevel, String unitId, 
			String grantOrgCode, String buss) {
    	try {
			if(StringUtil.isNotEmpty(batchId) && StringUtil.isNotEmpty(funCode)) {
				PmaFperformanceTobatchInf obj = new PmaFperformanceTobatchInf();
				obj.setBatchId(batchId);
				obj.setFunCode(funCode);
				obj.setUserId(userId);
				obj.setRole(role);
				obj.setUnitLevel(unitLevel);
				obj.setUnitId(unitId);
				obj.setGrantOrgCode(grantOrgCode);
				obj.setBuss(buss);
				obj.setStatus("0");
				obj.setCreateTime(new Date());
				return pmaFperformanceTobatchInfMapper.insert(obj);
	    	} else {
	    		log.warn("batchId or funCode is null, can not addToBatchInf");
	    	}
    	} catch(Exception e) {
    		log.error("addToBatchInf error, batchId:" + batchId + "; funCode:" + funCode, e); 
    	}
    	return 0;
	}
    
    /**
     * @方法名称: getBatchIdsByStatus
     * @方法描述: 根据执行状态STATUS字段值，获取 业绩批量导入待执行批次数据信息表-批次编号BATCH_ID数据
     * @参数与返回说明: 
     * @算法描述:
     */
    @Transactional(readOnly = true)
	public List<String> getBatchIdsByStatus(String status) {
		if(StringUtil.isNotEmpty(status)) {
    		return pmaFperformanceTobatchInfMapper.getBatchIdsByStatus(status);
    	} else {
    		log.warn("status is null, can not getBatchIdsByStatus");
			return null;
    	}
	}
    
    /**
     * @方法名称: getEarlyBatchInfByCount
     * @方法描述: 获取 业绩批量导入待执行批次数据信息表-数据
     * @参数与返回说明: 
     * @算法描述:
     */
    @Transactional(readOnly = true)
	public List<PmaFperformanceTobatchInf> getEarlyBatchInfByCount(Integer count) {
		if(count != null && count > 0) {
    		return pmaFperformanceTobatchInfMapper.getEarlyBatchInfByCount(count);
    	} else {
    		log.warn("count is null or is zero, can not getEarlyBatchInfByCount");
			return null;
    	}
	}
    
    /**
     * @方法名称: deleteByBatchId
     * @方法描述: 根据批次编号 删除业绩批量导入待执行批次数据信息表数据
     * @参数与返回说明: 
     * @算法描述:
     */
    @Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
    public Integer deleteByBatchId(String batchId) throws Exception {
    	Integer code = 0;
    	try {
    		if(StringUtil.isEmpty(batchId)) {
    			log.warn("batchId is null, can not delete");
    			return -9;
    		}
    		code = pmaFperformanceTobatchInfMapper.deleteByBatchId(batchId);
    	} catch (Exception e) {
    		log.error("batchId:" + batchId + "; deleteByBatchId error: ", e);
    		throw e;
    	}
    	return code;
    }
    
    /**
     * @方法名称: updateStatusByBatchId
     * @方法描述: 根据batchId 更新业绩批量导入待执行批次数据信息表-执行状态字段值为-status
     * @参数与返回说明: 
     * @算法描述:
     */
    @Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
    public Integer updateStatusByBatchId(String status, List<PmaFperformanceTobatchInf> batchInfList) {
    	Integer code = 0;
    	String batchIds = "";
    	try {
    		if(batchInfList == null || batchInfList.size() == 0) {
    			log.warn("infos is null, can not updateExecuteStatusByApplyIds");
    			return -9;
    		}
    		for(PmaFperformanceTobatchInf item: batchInfList) {
    			batchIds += item.getBatchId();
    			code += pmaFperformanceTobatchInfMapper.updateStatusByBatchId(item.getBatchId(), status);
    		}
    	} catch (Exception e) {
    		log.error("updateStatusByBatchId error, status:" + status + "; batchIds:" + batchIds, e);
    	}
    	return code;
    }
    
    /**
     * @方法名称: updateStatusByBatchId2
     * @方法描述: 根据batchId 更新业绩批量导入待执行批次数据信息表-执行状态字段值为-status
     * @参数与返回说明: 
     * @算法描述:
     */
    @Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
    public Integer updateStatusByBatchId2(String status, String batchId) {
    	Integer code = 0;
    	try {
			pmaFperformanceTobatchInfMapper.updateStatusByBatchId(batchId, status);
    	} catch (Exception e) {
    		log.error("updateStatusByBatchId2 error, status:" + status + "; batchId:" + batchId, e);
    	}
    	return code;
    }
}
