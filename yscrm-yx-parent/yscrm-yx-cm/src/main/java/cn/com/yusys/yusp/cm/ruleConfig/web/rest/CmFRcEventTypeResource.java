package cn.com.yusys.yusp.cm.ruleConfig.web.rest;

import cn.com.yusys.yusp.cm.ruleConfig.domain.CmFRcEventType;
import cn.com.yusys.yusp.cm.ruleConfig.service.CmFRcEventTypeService;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 
 * @项目名称: yusp-app-cm
 * @类名称: CmFRcEventTypeResource
 * @类描述: 事件类型控制类
 * @功能描述: 
 * @创建人: chenlin2@yusys.com.cn
 * @创建时间: 2018-10-23 10:50
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2018宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/cmfrceventtype")
public class CmFRcEventTypeResource extends CommonResource<CmFRcEventType, Serializable>{

	@Autowired
	private CmFRcEventTypeService service;
	
	@Override
	protected CommonService getCommonService() {
		// TODO Auto-generated method stub
		return this.service;
	}
	/**
	 * 查询事件类型树
	 * @param queryModel
	 * @return
	 */
	@GetMapping("/list")
	public ResultDto<List<CmFRcEventType>> getEventType(
			QueryModel queryModel) {
		List<CmFRcEventType> list = service.getEventType(queryModel);
		return new ResultDto<List<CmFRcEventType>>(list);
	}
	/**
	 * 事件类型刪除
	 * @param ids
	 * @return
	 */
	@PostMapping("/deletebatch")
    public ResultDto<Integer> deleteBatch(@RequestBody Map<?,?> ids) {
    	String[] idStr=ids.get("id").toString().split(",");
        return new ResultDto<Integer>(this.service.deleteBatch(idStr));
    }
}
