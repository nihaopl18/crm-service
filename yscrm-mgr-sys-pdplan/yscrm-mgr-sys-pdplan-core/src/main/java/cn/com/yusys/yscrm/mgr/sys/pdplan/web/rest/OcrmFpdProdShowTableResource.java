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
import cn.com.yusys.yscrm.mgr.sys.pdplan.domain.OcrmFpdProdShowTable;
import cn.com.yusys.yscrm.mgr.sys.pdplan.service.OcrmFpdProdShowTableService;

/**
 * @项目名称: yscrm-mgr-sys-pdplan-core模块
 * @类名称: OcrmFpdProdShowTableResource
 * @类描述: 展示方案关联数据表
 * @功能描述: 
 * @创建人: hyx
 * @创建时间: 2019-01-24 19:39:56
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/ocrmfpdprodshowtable")
public class OcrmFpdProdShowTableResource extends CommonResource<OcrmFpdProdShowTable, String> {
    @Autowired
    private OcrmFpdProdShowTableService ocrmFpdProdShowTableService;

    @Override
    protected CommonService getCommonService() {
        return ocrmFpdProdShowTableService;
    }
    
    /**
   	* @方法名称: getListByModel
   	* @方法描述: 通过展示方案关联数据表查询相关联表信息
   	* @参数与返回说明: 
   	* @算法描述: 
   	*/
    @GetMapping("/list")
    public ResultDto<List<Map<String, String>>> getListByPlanId(QueryModel model){
		return new ResultDto<List<Map<String, String>>>(ocrmFpdProdShowTableService.getListByPlanId(model));
    	
    }
    /**
   	* @方法名称: getListByPlanIdNo
   	* @方法描述: 通过展示方案关联数据表查询未关联表信息
   	* @参数与返回说明: 
   	* @算法描述: 
   	*/
    @GetMapping("/listno")
    public ResultDto<List<Map<String, String>>> getListByPlanIdNo(QueryModel model){
		return new ResultDto<List<Map<String, String>>>(ocrmFpdProdShowTableService.getListByPlanIdNo(model));
    	
    }
    
    /**
   	* @方法名称: save
   	* @方法描述: 保存展示方案和方案表的关系
   	* @参数与返回说明: 
   	* @算法描述: 
   	*/
    @PostMapping("/save")
    public ResultDto<Integer> save(@RequestBody QueryModel model){
    	ResultDto<Integer> resultDto = new ResultDto<>(ocrmFpdProdShowTableService.save(model));
    	resultDto.setCode(0);
    	resultDto.setMessage("保存成功");
		return resultDto;
    	
    }
    /**
   	* @方法名称: del
   	* @方法描述: 删除展示方案和方案表的关系
   	* @参数与返回说明: 
   	* @算法描述: 
   	*/
    @PostMapping("/del")
    public ResultDto<Integer> del(@RequestBody QueryModel model){
    	String ids = (String) model.getCondition().get("ids");
    	ResultDto<Integer> resultDto = new ResultDto<>(ocrmFpdProdShowTableService.deleteByIds(ids));
    	resultDto.setCode(0);
    	resultDto.setMessage("删除成功");
		return resultDto;
    	
    }

}
