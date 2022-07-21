package cn.com.yusys.yusp.cm.sysKeyWord.web.rest;

import cn.com.yusys.yusp.cm.sysKeyWord.domain.CmFRcMarketPosition;
import cn.com.yusys.yusp.cm.sysKeyWord.service.CmFRcMarketPositionService;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
/**
 * @项目名称: yusp-app-cm
 * @类名称: CmFRcMarketPositionResource
 * @类描述: 营销位管理
 * @功能描述: 
 * @创建人: yangxiao2@yusys.com.cn
 * @创建时间: 2019-04-25 
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2018宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/mktposition")
public class CmFRcMarketPositionResource extends CommonResource<CmFRcMarketPosition, Serializable>{

	@Autowired
	private CmFRcMarketPositionService service;
	@Override
	protected CommonService getCommonService() {
		return service;
	}
	@GetMapping("/setlist")
	public ResultDto<List<Map<String,Object>>>setPositionList(@RequestParam(required = false) String channelId) {
		return new ResultDto<List<Map<String,Object>>>(this.service.setPositionList(channelId));
	}
	@PostMapping("/setinsert")
	public ResultDto<Integer>setInsert(@RequestBody CmFRcMarketPosition record) {
		return service.setInsert(record);
	}
	@PostMapping("/setupdate")
	public ResultDto<Integer>setUpdate(@RequestBody CmFRcMarketPosition record) {
		return service.setUpdate(record);
	}
	@PostMapping("/setdel")
	public ResultDto<Integer> setDel(@RequestBody Map<String,Object> map) {
		return service.setDel(map.get("id").toString());
	}
}
