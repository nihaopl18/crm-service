package cn.com.yusys.yscrm.mgr.sys.pdplan.web.rest;

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
import cn.com.yusys.yscrm.mgr.sys.pdplan.domain.OcrmFpdProdShowR;
import cn.com.yusys.yscrm.mgr.sys.pdplan.service.OcrmFpdProdShowRService;

/**
 * @项目名称: yscrm-mgr-sys-pdplan-core模块
 * @类名称: OcrmFpdProdShowRResource
 * @类描述: 展示方案表关系
 * @功能描述: 
 * @创建人: hyx
 * @创建时间: 2019-01-24 19:39:26
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/ocrmfpdprodshowr")
public class OcrmFpdProdShowRResource extends CommonResource<OcrmFpdProdShowR, String> {
    @Autowired
    private OcrmFpdProdShowRService ocrmFpdProdShowRService;

    @Override
    protected CommonService getCommonService() {
        return ocrmFpdProdShowRService;
    }
    
    /**
	* @方法名称: getEntityByPlanId
	* @方法描述: 通过方案ID获取方案配置信息
	* @参数与返回说明: 
	* @算法描述: 
	*/
    @GetMapping("/list")
    public ResultDto<OcrmFpdProdShowR> getEntityByPlanId(QueryModel model){
    	String planId = (String) model.getCondition().get("planId");
    	ResultDto<OcrmFpdProdShowR> resultDto = null;
    	if (planId != null) {
			resultDto = new ResultDto<>(ocrmFpdProdShowRService.getEntityByPlanId(planId));
			resultDto.setCode(0);
			resultDto.setMessage("查询成功");
			return resultDto;
		}
    	resultDto = new ResultDto<>();
    	resultDto.setCode(-1);
    	resultDto.setMessage("查询失败");
		return resultDto;
    }
    /**
   	* @方法名称: save
   	* @方法描述: 保存方案配置信息
   	* @参数与返回说明: 
   	* @算法描述: 
   	*/
    @PostMapping("/save")
    public ResultDto<Integer> save(@RequestBody OcrmFpdProdShowR ocrmFpdProdShowR){
    	int num = ocrmFpdProdShowRService.save(ocrmFpdProdShowR);
    	ResultDto<Integer> resultDto = null;
    	if (num == 1) {
			resultDto = new ResultDto<>(num);
			resultDto.setCode(0);
			resultDto.setMessage("保存成功");
			return resultDto;
		}
    	resultDto = new ResultDto<>();
    	resultDto.setCode(-1);
    	resultDto.setMessage("保存失败");
		return resultDto;
    	
    }
    /**
   	* @方法名称: trialQuery
   	* @方法描述: 保存方案配置信息
   	* @参数与返回说明: 
   	* @算法描述: 
   	*/
    @PostMapping("/trialquery")
    public ResultDto<Integer> trialQuery(@RequestBody OcrmFpdProdShowR ocrmFpdProdShowR){
    	int num = ocrmFpdProdShowRService.trialQuery(ocrmFpdProdShowR);
    	ResultDto<Integer> resultDto = null;
    	if (num == -1) {
    		resultDto = new ResultDto<>();
        	resultDto.setCode(-1);
        	resultDto.setMessage("查询失败");
    		return resultDto;
			
		}
    	resultDto = new ResultDto<>(num);
		resultDto.setCode(0);
		resultDto.setMessage("查询成功");
		return resultDto;
    	
    }

}
