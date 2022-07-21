package cn.com.yusys.yusp.cm.ruleConfig.web.rest;

import cn.com.yusys.yusp.cm.ruleConfig.domain.CmFRcEventInfo;
import cn.com.yusys.yusp.cm.ruleConfig.service.CmFRcEventInfoService;
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
 * @类名称: CmFRcEventInfoResource
 * @类描述: 事件信息控制类
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
@RequestMapping("/api/cmfrceventinfo")
public class CmFRcEventInfoResource extends CommonResource<CmFRcEventInfo, Serializable>{

	@Autowired
	private CmFRcEventInfoService service;
	
	@Override
	protected CommonService getCommonService() {
		// TODO Auto-generated method stub
		return this.service;
	}
	/**
	 * 
	* @方法名称: getEventInfo
	* @方法描述: 查询事件信息
	* @参数与返回说明: 
	* @算法描述:
	 */
	@GetMapping("/list")
	public ResultDto<List<CmFRcEventInfo>> getEventInfo(
			QueryModel queryModel) {
		List<CmFRcEventInfo> list = service.getEventInfo(queryModel);
		return new ResultDto<List<CmFRcEventInfo>>(list);
	}
	
	@GetMapping("/geteventbytrans")
	public ResultDto<List<CmFRcEventInfo>> getEventByTrans(String transCode) {
		List<CmFRcEventInfo> list = service.getEventByTrans(transCode);
		return new ResultDto<List<CmFRcEventInfo>>(list);
	}
	
	/**
	 * 事件信息刪除
	 * @param ids
	 * @return
	 */
	@PostMapping("/deletebatch")
    public ResultDto<Integer> deleteBatch(@RequestBody Map<?,?> ids) {
    	String[] idStr=ids.get("id").toString().split(",");
        return new ResultDto<Integer>(this.service.deleteBatch(idStr));
    }
	
	/**
     * 
    * @方法名称: useBatch
    * @方法描述: 批量启用
    * @参数与返回说明: 
    * @算法描述:
     */
    @PostMapping("/usebatch")
    public ResultDto<Integer> useBatch(@RequestBody Map<?,?> parmas) {
    	String[] idStr=parmas.get("id").toString().split(",");
        return new ResultDto<Integer>(this.service.useIngFn(idStr));
    }

    /**
     * 
    * @方法名称: unUseBatch
    * @方法描述: 批量停用
    * @参数与返回说明: 
    * @算法描述:
     */
    @PostMapping("/unusebatch")
    public ResultDto<Integer> unUseBatch(@RequestBody Map<?,?> parmas) {
        String[] idStr=parmas.get("id").toString().split(",");
        return new ResultDto<Integer>(this.service.unUseIngFn(idStr));
    }
}
