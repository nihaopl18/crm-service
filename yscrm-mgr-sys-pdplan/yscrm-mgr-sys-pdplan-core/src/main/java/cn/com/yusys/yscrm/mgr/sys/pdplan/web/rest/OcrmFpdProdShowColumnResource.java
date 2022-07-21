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
import cn.com.yusys.yscrm.mgr.sys.pdplan.domain.OcrmFpdProdShowColumn;
import cn.com.yusys.yscrm.mgr.sys.pdplan.service.OcrmFpdProdShowColumnService;

/**
 * @项目名称: yscrm-mgr-sys-pdplan-core模块
 * @类名称: OcrmFpdProdShowColumnResource
 * @类描述: 展示方案关联属性
 * @功能描述: 配置展示方案关联属性信息
 * @创建人: hyx
 * @创建时间: 2019-01-24 19:40:30
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/ocrmfpdprodshowcolumn")
public class OcrmFpdProdShowColumnResource extends CommonResource<OcrmFpdProdShowColumn, String> {
    @Autowired
    private OcrmFpdProdShowColumnService ocrmFpdProdShowColumnService;

    @Override
    protected CommonService getCommonService() {
        return this.ocrmFpdProdShowColumnService;
    }
    
    /**
   	* @方法名称: getList
   	* @方法描述: 通过当前方案ID获取相关联的表属性
   	* @参数与返回说明: 
   	* @算法描述: 
   	*/
    @GetMapping("list")
    public ResultDto<List<Map<String, String>>> getList(QueryModel model){
    	return new ResultDto<List<Map<String, String>>>(ocrmFpdProdShowColumnService.getList(model));
    }
    /**
   	* @方法名称: getListNo
   	* @方法描述: 通过当前方案ID获取未相关联的表属性
   	* @参数与返回说明: 
   	* @算法描述: 
   	*/
    @GetMapping("listno")
    public ResultDto<List<Map<String, String>>> getListNo(QueryModel model){
    	return new ResultDto<List<Map<String, String>>>(ocrmFpdProdShowColumnService.getListNo(model));
    }
    
    /**
   	* @方法名称: join
   	* @方法描述: 将未相关联的属性添加关联信息
   	* @参数与返回说明: 
   	* @算法描述: 
   	*/
    @PostMapping("/join")
    public ResultDto<Integer> join(@RequestBody List<OcrmFpdProdShowColumn> lists){
    	ResultDto<Integer> resultDto =new ResultDto<>(ocrmFpdProdShowColumnService.join(lists));
    	resultDto.setCode(0);
    	resultDto.setMessage("加入成功");
		return resultDto;
    	
    }
    /**
   	* @方法名称: out
   	* @方法描述: 将相关联的属性信息删除
   	* @参数与返回说明: 
   	* @算法描述: 
   	*/
    @PostMapping("/out")
    public ResultDto<Integer> out(@RequestBody QueryModel model){
    	String ids = (String) model.getCondition().get("rCloumnIds");
    	ResultDto<Integer> resultDto =new ResultDto<>(ocrmFpdProdShowColumnService.deleteByIds(ids));
    	resultDto.setCode(0);
    	resultDto.setMessage("删除成功");
		return resultDto;
    }
    
    /**
   	* @方法名称: save
   	* @方法描述: 对相关联的属性信息进行维护
   	* @参数与返回说明: 
   	* @算法描述: 
   	*/
    @PostMapping("/save")
    public ResultDto<Integer> save(@RequestBody List<OcrmFpdProdShowColumn> lists){
    	ResultDto<Integer> resultDto = null;
    	if (lists != null) {
			resultDto = new ResultDto<>(ocrmFpdProdShowColumnService.save(lists));
			resultDto.setCode(0);
			resultDto.setMessage("保存成功");
			return resultDto;
		}
    	resultDto = new ResultDto<>(0);
		resultDto.setCode(-1);
		resultDto.setMessage("保存失败");
		return resultDto;
    }
    @GetMapping("/getProdTree")
    public ResultDto<List<Map<String, String>>> getProdTree(QueryModel model){
    	List<Map<String, String>> list = ocrmFpdProdShowColumnService.getProdTree(model);
		return new ResultDto<>(list);
    	
    }
    @GetMapping("/prodInfo")
    public ResultDto<List<Map<String, String>>> getprodInfo(QueryModel model){
    	List<Map<String, String>> list = ocrmFpdProdShowColumnService.getprodInfo(model);
    	return new ResultDto<>(list);
    	}
    
    /**
   	* @方法名称: gettopName
   	* @方法描述: 通过当前方案ID获取相关联的表属性
   	* @参数与返回说明: 
   	* @算法描述: 
   	*/
    @PostMapping("/topname")
    public ResultDto<List<Map<String, String>>> gettopName(@RequestBody QueryModel model){
    	String catlCode = (String) model.getCondition().get("catlCode");
    	return new ResultDto<List<Map<String, String>>>(ocrmFpdProdShowColumnService.gettopName(catlCode));
    }
}
