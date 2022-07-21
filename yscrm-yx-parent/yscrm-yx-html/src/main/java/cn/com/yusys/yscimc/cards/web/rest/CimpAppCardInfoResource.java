package cn.com.yusys.yscimc.cards.web.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import cn.com.yusys.yscimc.cards.domain.CimpAppCardInfo;
import cn.com.yusys.yscimc.cards.service.CimpAppCardInfoService;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;

/**
 * @项目名称: yscimc-app-mobile模块
 * @类名称: CimpAppCardInfoResource
 * @类描述: #集卡卡片资源类
 * @功能描述: 提供卡片操作相关接口
 * @创建人: yangxiao2
 * @创建时间: 2019-06-11 20:24:36
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/cimpappcardinfo")
public class CimpAppCardInfoResource extends CommonResource<CimpAppCardInfo, String>{

	@Autowired
	private CimpAppCardInfoService service;
	
	@Override
	protected CommonService getCommonService() {
		return service;
	}
	
	/**
    * @方法名称: getActyCards
    * @方法描述: 查找全部活动相关卡片
    * @参数与返回说明: 
    * @算法描述: 
    */
	@GetMapping("/getactycards")
	public ResultDto<List<Map<String,Object>>> getActyCards(@RequestParam(required=false) String actyId){
		return new ResultDto<List<Map<String,Object>>>(service.getActyCards(actyId));
	}
	
	/**
    * @方法名称: insertCard
    * @方法描述: 卡片新增
    * @参数与返回说明: 
    * @算法描述: 
    */
	@PostMapping("/insertcard")
	public ResultDto<Integer> insertCard (@RequestBody Map<String,Object> map) {		
		@SuppressWarnings("unchecked")
		List<Map<String,Object>>list = (List<Map<String,Object>>)map.get("cards");
		return service.insertCard(list);
	}
}
