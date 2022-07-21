package cn.com.yusys.yscrm.mgr.sys.pdplan.web.rest;

import java.util.List;
import java.util.Map;

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
import cn.com.yusys.yscrm.mgr.sys.pdplan.domain.OcrmFpdProdShowPlan;
import cn.com.yusys.yscrm.mgr.sys.pdplan.service.OcrmFpdProdShowPlanService;

/**
 * @项目名称: yscrm-mgr-sys-pdplan-core模块
 * @类名称: OcrmFpdProdShowPlanResource
 * @类描述: 产品展示方案
 * @功能描述: 产品展示方案信息的显示和维护
 * @创建人: hyx
 * @创建时间: 2019-01-23 19:29:58
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/ocrmfpdprodshowplan")
public class OcrmFpdProdShowPlanResource extends CommonResource<OcrmFpdProdShowPlan, String> {
    @Autowired
    private OcrmFpdProdShowPlanService ocrmFpdProdShowPlanService;

    @Override
    protected CommonService getCommonService() {
        return ocrmFpdProdShowPlanService;
    }
    
    /**
   	* @方法名称: getListByModel
   	* @方法描述: 获取产品展示方案信息
   	* @参数与返回说明: 
   	* @算法描述: 
   	*/
    @GetMapping("/getprodtable")
    public ResultDto<List<Map<String, String>>> getListByModel(QueryModel model){
		return new ResultDto<List<Map<String, String>>>(ocrmFpdProdShowPlanService.getListByModel(model));
    	
    }
    
    /**
   	* @方法名称: checkPlanName
   	* @方法描述: 检查所选名称是否存在
   	* @参数与返回说明: 0表示不存在，可以新增，1表示存在数据库不能新增
   	* @算法描述: 
   	*/
    @PostMapping("/checkplanname")
    public ResultDto<Integer> checkPlanName(@RequestBody QueryModel model){
    	String planName = (String) model.getCondition().get("planName");
		return new ResultDto<Integer>(ocrmFpdProdShowPlanService.checkPlanName(planName));
    }
    
    /**
   	* @方法名称: checkUpdPlanName
   	* @方法描述: 检查所选名称是否存在
   	* @参数与返回说明: 0表示不存在，可以新增，1表示存在数据库不能新增
   	* @算法描述: 
   	*/
    @PostMapping("/checkupdplanname")
    public ResultDto<Integer> checkUpdPlanName(@RequestBody QueryModel model){
    	String planId = (String) model.getCondition().get("planId");
    	String planName = (String) model.getCondition().get("planName");
		return new ResultDto<Integer>(ocrmFpdProdShowPlanService.checkUpdPlanName(planId,planName));
    }
    
    /**
   	* @方法名称: add
   	* @方法描述: 新增产品展示方案信息
   	* @参数与返回说明: 
   	* @算法描述: 
   	*/
    @PostMapping("/add")
    public ResultDto<OcrmFpdProdShowPlan> add(@RequestBody OcrmFpdProdShowPlan ocrmFpdProdShowPlan){
    	ResultDto<OcrmFpdProdShowPlan> resultDto = null;
    	ocrmFpdProdShowPlan = ocrmFpdProdShowPlanService.add(ocrmFpdProdShowPlan);
    	if (ocrmFpdProdShowPlan != null) {
			resultDto = new ResultDto<OcrmFpdProdShowPlan>(ocrmFpdProdShowPlan);
			resultDto.setCode(0);
			resultDto.setMessage("新增成功");
			return resultDto;
		}
    	resultDto = new ResultDto<OcrmFpdProdShowPlan>(null);
		resultDto.setCode(-1);
		resultDto.setMessage("新增失败");
		return resultDto;
    	
    }
    /**
   	* @方法名称: del
   	* @方法描述: 删除产品展示方案信息
   	* @参数与返回说明: 
   	* @算法描述: 
   	*/
    @PostMapping("/del")
    public ResultDto<Integer> del(@RequestBody QueryModel model){
    	String ids = (String) model.getCondition().get("ids");
    	ResultDto<Integer> resultDto = null;
    	int num = ocrmFpdProdShowPlanService.del(ids);
    	if (num != 0) {
			resultDto = new ResultDto<>(num);
			resultDto.setCode(0);
			resultDto.setMessage("删除成功");
			return resultDto;
		}
    	resultDto = new ResultDto<>(0);
		resultDto.setCode(-1);
		resultDto.setMessage("删除失败");
		return resultDto;
    	
    }
    /**
   	* @方法名称: updateFun
   	* @方法描述: 修改产品展示方案信息
   	* @参数与返回说明: 
   	* @算法描述: 
   	*/
    @PostMapping("/updatefun")
    public ResultDto<Integer> updateFun(@RequestBody OcrmFpdProdShowPlan ocrmFpdProdShowPlan){
    	ResultDto<Integer> resultDto = null;
    	int num = ocrmFpdProdShowPlanService.updateFun(ocrmFpdProdShowPlan);
    	if (num == 1 ) {
    		resultDto = new ResultDto<>(num);
			resultDto.setCode(0);
			resultDto.setMessage("修改成功");
			return resultDto;
		}
    	resultDto = new ResultDto<>(0);
		resultDto.setCode(-1);
		resultDto.setMessage("修改失败");
		return resultDto;
    	
    }

}
