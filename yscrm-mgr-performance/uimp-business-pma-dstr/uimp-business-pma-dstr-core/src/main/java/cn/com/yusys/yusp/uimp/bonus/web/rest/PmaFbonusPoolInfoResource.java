package cn.com.yusys.yusp.uimp.bonus.web.rest;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yusp.uimp.bonus.domain.PmaFbonusPoolInfo;
import cn.com.yusys.yusp.uimp.bonus.model.BonusAltListModel;
import cn.com.yusys.yusp.uimp.bonus.service.PmaFbonusPoolInfoService;
import cn.com.yusys.yusp.uimp.bonus.service.PmaFsedBonusAltListService;

/**
 * @项目名称: uimp-business-pma-dstr-core模块
 * @类名称: PmaFbonusPoolInfoResource
 * @类描述: #二次分配奖金池信息表 资源类
 * @功能描述: 
 * @创建人: lixt1
 * @创建时间: 2020-08-06 10:24:27
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/pmafbonuspoolinfo")
public class PmaFbonusPoolInfoResource extends CommonResource<PmaFbonusPoolInfo, String> {
	
	private static final Logger logger = LoggerFactory.getLogger(PmaFbonusPoolInfoResource.class);
	
    @Autowired
    private PmaFbonusPoolInfoService pmaFbonusPoolInfoService;
    
    @Autowired
    private PmaFsedBonusAltListService pmaFsedBonusAltListService;

    @Override
    protected CommonService getCommonService() {
        return pmaFbonusPoolInfoService;
    }

    /**
     * @方法名称: queryBonusPoolInfo
     * @方法描述: 分页查询-二次分配奖金池信息数据
     * @参数与返回说明:
     * @算法描述:
     */
    @GetMapping("/querybonuspoolinfo")
    public ResultDto<List<Map<String, Object>>> queryBonusPoolInfo(QueryModel queryModel) {
    	ResultDto<List<Map<String, Object>>> result = new ResultDto<List<Map<String, Object>>>();
    	try {
    		List<Map<String, Object>> list = pmaFbonusPoolInfoService.queryBonusPoolInfo(queryModel);
    		return new ResultDto<List<Map<String, Object>>>(list);
    	} catch (Exception e) {
    		logger.error("resource queryBonusPoolInfo error !");
			result.setCode(-2);
			result.setMessage("系统异常");
    		e.printStackTrace();
    	}
    	return result;
    }
    
    /**
     * @方法名称: queryBonusAltList
     * @方法描述: 查询-分配明细数据
     * @参数与返回说明:
     * @算法描述:
     */
    @GetMapping("/querybonusaltlist")
    public ResultDto<List<Map<String, Object>>> queryBonusAltList(QueryModel model) {
    	ResultDto<List<Map<String, Object>>> result = new ResultDto<List<Map<String, Object>>>();
    	try {
    		if(model.getCondition() != null && StringUtils.isNotEmpty(model.getCondition().get("statDate") + "") && 
    				StringUtils.isNotEmpty(model.getCondition().get("orgId") + "")) {
    			List<Map<String, Object>> list = pmaFsedBonusAltListService.queryBonusAltList(model.getCondition().get("statDate") + "", 
    					model.getCondition().get("orgId") + "");
    			return new ResultDto<List<Map<String, Object>>>(list);
    		} else {
    			result.setCode(-9);
    			result.setMessage("参数错误");
    		}
    	} catch (Exception e) {
    		logger.error("resource queryBonusAltList error !");
			result.setCode(-2);
			result.setMessage("系统异常");
    		e.printStackTrace();
    	}
    	return result;
    }
    
    /**
     * @方法名称: deleteBonusAltByIds
     * @方法描述: 根据id 批量删除分配明细表数据
     * @参数与返回说明:
     * @算法描述:
     */
    @PostMapping("/deletebonusaltbyids")
    public ResultDto<String> deleteBonusAltByIds(@RequestBody String ids) {
    	ResultDto<String> result = new ResultDto<String>();
    	try {
    		Integer code = pmaFsedBonusAltListService.deleteBonusAltByIds(ids);
    		result.setCode(code);
    		if(code == -9) {
    			result.setMessage("参数为空");
    		} else if(code == 0) {
    			result.setMessage("删除成功");
    		}
    	} catch (Exception e) {
    		logger.error("resource queryBonusAltList error !");
			result.setCode(-2);
			result.setMessage("系统异常");
    		e.printStackTrace();
    	}
    	return result;
    }
    
    /**
     * @方法名称: saveBonusAltList
     * @方法描述: 更新奖金池分配明细表数据
     * @参数与返回说明:
     * @算法描述:
     */
    @PostMapping("/savebonusaltlist")
    public ResultDto<String> saveBonusAltList(@RequestBody BonusAltListModel model) {
    	ResultDto<String> result = new ResultDto<String>();
    	try {
    		if(StringUtils.isNotEmpty(model.getStatDate()) && StringUtils.isNotEmpty(model.getOrgId()) && 
    				model.getDataList() != null && model.getDataList().size() > 0) {
    			PmaFbonusPoolInfo poolInfo = pmaFbonusPoolInfoService.queryBonusPoolInfoByStatDateAndOrgId(model.getStatDate(), model.getOrgId());
    			if(poolInfo == null) {
    				result.setCode(-1);
    				result.setMessage("参数错误");
    				logger.warn("cannot find poolinfo by statDate and orgId, won't saveBonusAltList");
    			} else {
    				Integer code = pmaFsedBonusAltListService.saveBonusAltList(poolInfo, model.getDataList());
    				result.setCode(code);
    				if(code == -3) {
    					result.setMessage("分配金额总和不能大于奖金池金额");
    				} else {
    					result.setMessage("保存成功");
    				}
    			}
    		} else {	// 参数错误
    			result.setCode(-9);
    			result.setMessage("参数为空");
    		}
    	} catch (Exception e) {
    		logger.error("resource saveBonusAltList error !");
			result.setCode(-2);
			result.setMessage("系统异常");
    		e.printStackTrace();
    	}
    	return result;
    }
}
