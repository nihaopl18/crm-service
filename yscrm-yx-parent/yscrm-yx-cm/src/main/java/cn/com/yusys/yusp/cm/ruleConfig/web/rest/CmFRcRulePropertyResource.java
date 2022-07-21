package cn.com.yusys.yusp.cm.ruleConfig.web.rest;

import cn.com.yusys.yusp.cm.ruleConfig.domain.CmFRcEventInfo;
import cn.com.yusys.yusp.cm.ruleConfig.domain.CmFRcFieldEcName;
import cn.com.yusys.yusp.cm.ruleConfig.domain.CmFRcTableEcName;
import cn.com.yusys.yusp.cm.ruleConfig.domain.CmFRcTableType;
import cn.com.yusys.yusp.cm.ruleConfig.service.CmFRcRulePropertyService;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 
 * @项目名称: yusp-app-cm
 * @类名称: CmFRcRulePropertyResource
 * @类描述: 规则属性配置控制类
 * @功能描述: 
 * @创建人: chenlin2@yusys.com.cn
 * @创建时间: 2018-10-15 10:50
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2018宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/cmfrcruleproperty")
public class CmFRcRulePropertyResource extends CommonResource<CmFRcTableType, Serializable>{

	@Autowired
	private CmFRcRulePropertyService service;
	
	@Override
	protected CommonService getCommonService() {
		// TODO Auto-generated method stub
		return this.service;
	}
	/**
	 * 
	* @方法名称: getTableType
	* @方法描述: 查询表类别
	* @参数与返回说明: 
	* @算法描述:
	 */
	@GetMapping("/list")
	public ResultDto<List<CmFRcTableType>> getTableType(
			QueryModel queryModel) {
		List<CmFRcTableType> list = service.getTableType(queryModel);
		return new ResultDto<List<CmFRcTableType>>(list);
	}
	/**
	 * 查询表名信息
	 * @param typeId
	 * @param queryModel
	 * @return
	 */
	@GetMapping("/tablelist")
	public ResultDto<List<CmFRcTableEcName>> getTableByTypeId(@RequestParam(required = false) String typeId ,QueryModel queryModel) {
		if(typeId!=null){
			queryModel.getCondition().put("typeId", typeId);
		}
    	List<CmFRcTableEcName> list = service.getTableByTypeId(queryModel);
		return new ResultDto<List<CmFRcTableEcName>>(list);
	}
	/**
	 * 查询所有表
	 * @return
	 */
	@GetMapping("/getalltab")
	public ResultDto<List<CmFRcTableEcName>> getAllTab() {
    	List<CmFRcTableEcName> list = service.getAllTab();
		return new ResultDto<List<CmFRcTableEcName>>(list);
	}
	/**
	 * 查询字段信息
	 * @param tableId
	 * @param queryModel
	 * @return
	 */
	@GetMapping("/fieldlist")
	public ResultDto<List<CmFRcFieldEcName>> getFieldByTableId(@RequestParam(required = false) String tableId ,QueryModel queryModel) {
		if(tableId!=null){
			queryModel.getCondition().put("tableId", tableId);
		}
    	List<CmFRcFieldEcName> list = service.getFieldByTableId(queryModel);
		return new ResultDto<List<CmFRcFieldEcName>>(list);
	}
	/**
	 * 查询表视图信息
	 * @param tableName
	 * @param tv
	 * @param queryModel
	 * @return
	 */
	
	@GetMapping("/searchtable")
	public ResultDto<List<Map<String, Object>>> searchtable(@RequestParam(required = false) String tableName,String tv,QueryModel queryModel) {
		if(tableName!=null){
			queryModel.getCondition().put("tableName", tableName);
		}else if(tv!=null) {
			queryModel.getCondition().put("tv", tv);
		}
    	return new ResultDto<List<Map<String, Object>>>(service.searchtable(queryModel));
	}
	/**
	 * 保存表名汉化
	 * @param t
	 * @return
	 * @throws URISyntaxException
	 */
	
	@PostMapping("/savetabandfield")
    public  ResultDto<Object> saveTabAndField(@RequestBody ArrayList<CmFRcTableEcName> t)
            throws URISyntaxException {
    	 List<CmFRcTableEcName> list = t;
    	 service.saveTabAndField(list);
         return new ResultDto<Object>();
    }
	/**
	 * 保存表字段汉化
	 * @param t
	 * @return
	 * @throws URISyntaxException
	 */
	@PostMapping("/savefield")
    public  ResultDto<Object> saveField(@RequestBody ArrayList<CmFRcFieldEcName> t)
            throws URISyntaxException {
    	 List<CmFRcFieldEcName> list = t;
    	 service.saveField(list);
         return new ResultDto<Object>();
    }
	/**
	 * 表类型刪除
	 * @param ids
	 * @return
	 */
	@PostMapping("/deletebatch")
    public ResultDto<Map<String, Object>> deleteBatch(@RequestBody Map<?,?> ids) {
    	String[] idStr=ids.get("id").toString().split(",");
    	ResultDto<Map<String, Object>> reuslt=new ResultDto<Map<String, Object>>();
		try {
			List<CmFRcEventInfo> list = service.getEventByType(idStr[0]);
	    	if(list.size()>0) {
	    		reuslt.setCode(200001);
				reuslt.setMessage("该类型下的表已被事件使用不能删除！");
	    	}else {
	    		this.service.deleteBatch(idStr);
	    	}
		}catch (Exception e) {
			reuslt.setCode(100001);
			reuslt.setMessage("fail");
		}
		return reuslt;
    }
	/**
	 * 删除表汉化
	 * @param ids
	 * @return
	 */
	@PostMapping("/deletetab")
	public ResultDto<Integer> deleteTab(@RequestBody Map<?,?> ids) {
		String[] idStr=ids.get("id").toString().split(",");
		return new ResultDto<Integer>(this.service.deletetab(idStr));
	}
	
	/**
	 * 查询交易码
	 * @return
	 */
	@GetMapping("/searchtranscode")
	public ResultDto<List<Map<String, Object>>> searchTransCode(@RequestParam(required = false) String transType) {
    	return new ResultDto<List<Map<String, Object>>>(service.searchTransCode(transType));
	}
	/***根据表类型查询表是否 被实时事件所引用**/
	@GetMapping("/geteventbytype")
	public ResultDto<List<CmFRcEventInfo>> getEventByType(String typeId) {
		List<CmFRcEventInfo> list = service.getEventByType(typeId);
		return new ResultDto<List<CmFRcEventInfo>>(list);
	}
}
