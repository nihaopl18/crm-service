package cn.com.yusys.yusp.uimp.bonus.service;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.LocalDateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.uimp.base.service.UserInfoService;
import cn.com.yusys.yusp.uimp.bonus.domain.PmaFbonusPoolInfo;
import cn.com.yusys.yusp.uimp.bonus.domain.PmaFsedBonusAltList;
import cn.com.yusys.yusp.uimp.bonus.repository.mapper.PmaFsedBonusAltListMapper;
/**
 * @项目名称: uimp-business-pma-dstr-core模块
 * @类名称: PmaFsedBonusAltListService
 * @类描述: #员工奖金二次分配明细表 服务类
 * @功能描述: 
 * @创建人: lixt1
 * @创建时间: 2020-08-06 10:25:09
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class PmaFsedBonusAltListService extends CommonService {
	
	private static final Logger logger = LoggerFactory.getLogger(PmaFsedBonusAltListService.class);
	
    @Autowired
    private PmaFsedBonusAltListMapper pmaFsedBonusAltListMapper;
    
	@Autowired
	private UserInfoService userInfo; 
	
	@Autowired
	private PmaFbonusPoolInfoService pmaFbonusPoolInfoService;

    @Override
    protected CommonMapper<?> getMapper() {
        return pmaFsedBonusAltListMapper;
    }

    /**
     * @方法名称: queryBonusAltList
     * @方法描述: 查询-分配明细数据
     * @参数与返回说明:
     * @算法描述:
     */
	@Transactional(readOnly = true)
	public List<Map<String, Object>> queryBonusAltList(String statDate, String orgId) throws Exception {
		return pmaFsedBonusAltListMapper.queryBonusAltList(statDate, orgId);
	}
	
    /**
     * @方法名称: deleteBonusAltByIds
     * @方法描述: 根据id 批量删除分配明细表数据
     * @参数与返回说明:
     * @算法描述:
     */
    @Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
    public Integer deleteBonusAltByIds(String ids) throws Exception {
    	Integer code = 0;
    	try {
    		if(StringUtils.isEmpty(ids)) {
    			logger.warn("ids is null, can not deleteBonusAltByIds");
    			return -9;
    		}
    		String[] idArr = ids.split(",");
    		pmaFsedBonusAltListMapper.deleteBonusAltByIds(idArr);
    		return code;
    	} catch (Exception e) {
    		logger.error("service deleteBonusAltByIds error !");
    		logger.error("error ids is " + ids);
    		e.printStackTrace();
    		throw e;
    	}
    }
    
    /**
     * @方法名称: saveBonusAltList
     * @方法描述: 更新奖金池分配明细表数据
     * @参数与返回说明:
     * @算法描述:
     */
    @Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
    public Integer saveBonusAltList(PmaFbonusPoolInfo poolInfo, List<PmaFsedBonusAltList> dataList) throws Exception {
    	Integer code = 0;
    	try {
    		Double operBonusSum = 0.0;
    		for(PmaFsedBonusAltList bonusAlt : dataList) {
    			operBonusSum += bonusAlt.getOperBonus();
    		}
    		// 判断 分配的奖金数据是否大于奖金池金额
    		if(operBonusSum > poolInfo.getPoolBonus()) {
    			logger.warn("operBonusSum must be lower than poolBonus");
    			return -3;
    		}
    		// 删除 已分配的明细数据
    		pmaFsedBonusAltListMapper.deleteBonusAltListByStatDateAndOrgId(poolInfo.getStatDate(), poolInfo.getOrgId());
    		// 批量 新增分配明细数据
    		pmaFsedBonusAltListMapper.batchInsert(poolInfo.getStatDate(), poolInfo.getOrgId(), 
    				userInfo.getUserInfo().getLoginCode(), LocalDateTime.now().toString("yyyy-MM-dd HH:mm:ss"),
    				dataList);
    		// 更新 奖金池信息-剩余奖金池金额、已分配奖金池金额字段值
    		poolInfo.setAssignPoolBonus(operBonusSum);
    		poolInfo.setSurPoolBonus(poolInfo.getPoolBonus() - operBonusSum);
    		pmaFbonusPoolInfoService.update(poolInfo);
    		return code;
    	} catch (Exception e) {
    		logger.error("service saveBonusAltList error !");
    		e.printStackTrace();
    		throw e;
    	}
    }
    
}
