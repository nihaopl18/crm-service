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
import cn.com.yusys.yscrm.mgr.sys.pdplan.domain.OcrmFpdProdTable;
import cn.com.yusys.yscrm.mgr.sys.pdplan.service.OcrmFpdProdTableService;

/**
 * @项目名称: yscrm-mgr-sys-pdplan-core模块
 * @类名称: OcrmFpdProdTableResource
 * @类描述: 产品展示表定义Resource类
 * @功能描述: 
 * @创建人: hyx
 * @创建时间: 2019-01-23 19:28:07
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/ocrmfpdprodtable")
public class OcrmFpdProdTableResource extends CommonResource<OcrmFpdProdTable, String> {
    @Autowired
    private OcrmFpdProdTableService ocrmFpdProdTableService;

    @Override
    protected CommonService getCommonService() {
        return this.ocrmFpdProdTableService;
    }
    /**
   	* @方法名称: getTableName
   	* @方法描述: 获取数据当前用户表所有表名称
   	* @参数与返回说明: 
   	* @算法描述: 
   	*/
    @GetMapping("/gettablename")
    public ResultDto<List<Map<String, String>>> getTableName(QueryModel model){
		return new ResultDto<List<Map<String, String>>>(ocrmFpdProdTableService.getTableName());
    	
    }
    /**
   	* @方法名称: getProdTableByModel
   	* @方法描述: 获取产品展示表定义列表信息
   	* @参数与返回说明: 
   	* @算法描述: 
   	*/
    @GetMapping("/getprodtable")
    public ResultDto<List<Map<String, String>>> getProdTableByModel(QueryModel model){
		return new ResultDto<List<Map<String, String>>>(ocrmFpdProdTableService.getListByModel(model));
    	
    }
    
    /**
   	* @方法名称: checkTableName
   	* @方法描述: 检查所选名称是否存在
   	* @参数与返回说明: 0表示不存在，可以新增，1表示存在数据库不能新增
   	* @算法描述: 
   	*/
    @PostMapping("/checktablename")
    public ResultDto<Integer> checkTableName(@RequestBody QueryModel model){
    	String tableName = (String) model.getCondition().get("tableName");
		return new ResultDto<Integer>(ocrmFpdProdTableService.checkTableName(tableName));
    }
    
    /**
   	* @方法名称: checkTableName
   	* @方法描述: 检查所选名称是否存在
   	* @参数与返回说明: 0表示不存在，可以新增，1表示存在数据库不能新增
   	* @算法描述: 
   	*/
    @PostMapping("/checktableothname")
    public ResultDto<Integer> checkTableOthName(@RequestBody QueryModel model){
    	String tableOthName = (String) model.getCondition().get("tableOthName");
		return new ResultDto<Integer>(ocrmFpdProdTableService.checkTableOthName(tableOthName));
    }
    
    /**
   	* @方法名称: add
   	* @方法描述: 添加产品展示表定义列表信息，必须表名和表别名都不存在于数据库表时可以新增
   	* @参数与返回说明: 
   	* @算法描述: 
   	*/
    @PostMapping("/add")
    public ResultDto<OcrmFpdProdTable> add(@RequestBody OcrmFpdProdTable ocrmFpdProdTable){
    	ResultDto<OcrmFpdProdTable> resultDto = null;
    	if ((ocrmFpdProdTableService.checkTableOthName(ocrmFpdProdTable.getTableOthName()) == 0)  &&
    			(ocrmFpdProdTableService.checkTableName(ocrmFpdProdTable.getTableName()) == 0) 	) {
    		ocrmFpdProdTable = ocrmFpdProdTableService.add(ocrmFpdProdTable);
        	if (ocrmFpdProdTable != null) {
    			resultDto = new ResultDto<OcrmFpdProdTable>(ocrmFpdProdTable);
    			resultDto.setCode(0);
    			resultDto.setMessage("新增成功");
    			return resultDto;
    		}
		}
    	resultDto = new ResultDto<OcrmFpdProdTable>(null);
		resultDto.setCode(-1);
		resultDto.setMessage("新增失败");
		return resultDto;
    	
    }
    /**
   	* @方法名称: del
   	* @方法描述: 删除产品展示表定义列表信息
   	* @参数与返回说明: 如果传参没有所需值，直接返回失败
   	* @算法描述: 
   	*/
    @PostMapping("/del")
    public ResultDto<Integer> del(@RequestBody QueryModel model){
    	String ids = (String) model.getCondition().get("ids");
    	ResultDto<Integer> resultDto = null;
    	if (ids == null ) {
    		resultDto = new ResultDto<>(0);
    		resultDto.setCode(-1);
    		resultDto.setMessage("删除失败");
    		return resultDto;
		}
    	int num = ocrmFpdProdTableService.del(ids);
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
   	* @方法描述:修改产品展示表定义列表信息
   	* @参数与返回说明: 
   	* @算法描述: 
   	*/
    @PostMapping("/updatefun")
    public ResultDto<Integer> updateFun(@RequestBody OcrmFpdProdTable ocrmFpdProdTable){
    	ResultDto<Integer> resultDto = null;
    	int num = ocrmFpdProdTableService.updateFun(ocrmFpdProdTable);
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
    
    /**
   	* @方法名称: getTableInfo
   	* @方法描述:获取表信息
   	* @参数与返回说明: 
   	* @算法描述: 
   	*/
    @GetMapping("/gettableinfo")
    public ResultDto<List<Map<String, String>>> getTableInfo(QueryModel model){
    	String tableName = (String) model.getCondition().get("tableName");
    	if (tableName != null) {
    		return new ResultDto<List<Map<String, String>>>(ocrmFpdProdTableService.getTableInfo(model));
		}
		return new ResultDto<List<Map<String, String>>>();
    }
}
