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
import cn.com.yusys.yscimc.cards.domain.CimpAppCardCusts;
import cn.com.yusys.yscimc.cards.domain.CimpAppCardInfo;
import cn.com.yusys.yscimc.cards.service.CimpAppCardCustsService;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;

/**
 * @项目名称: yscimc-app-mobile模块
 * @类名称: CimpAppCardCustsResource
 * @类描述: #用户集卡资源类
 * @功能描述: 提供用户集卡相关的接口
 * @创建人: yangxiao2
 * @创建时间: 2019-06-11 20:24:36
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/cimpappcardcusts")
public class CimpAppCardCustsResource extends CommonResource<CimpAppCardCusts, String>{
	@Autowired
	private CimpAppCardCustsService service;
	
	@Override
	protected CommonService getCommonService() {
		return service;
	}
	
	/**
	 * 获取活动配置
	 * */
	@GetMapping("/getactyconfig")
	public ResultDto<List<Map<String,Object>>>getActyConfig(@RequestParam(required = false)String nodeId) {
		return new ResultDto<List<Map<String,Object>>>(service.getActyConfig(nodeId));
	}
	
	/**
	 * 参与集卡活动用户统计接口
	 * */
	@GetMapping("/getactymembers")
	public ResultDto<Map<String,Object>>getActyMembers(@RequestParam(required = false)String actyId) {
		return new ResultDto<Map<String,Object>>(service.getActyMembers(actyId));
	}
	
	/**
	 * 参与集卡活动用户排序查询
	 * */
	@GetMapping("/getmembersorder")
	public ResultDto<List<Map<String,Object>>>getMembersOrder(@RequestParam(required = false)String actyId){
		return new ResultDto<List<Map<String,Object>>>(service.getMembersOrder(actyId));
	}
	
	/**
	 * 用户集卡信息接口
	 * */
	@GetMapping("/getcustcards")
	public ResultDto<List<Map<String,Object>>>getCustCards(@RequestParam(required = false) Map<String,Object> map){
		return new ResultDto<List<Map<String,Object>>>(service.getCustCards(map));
	}
	
	/**
	 * 用户集卡翻卡次数接口
	 * */
	@GetMapping("/getturncardtimes")
	public ResultDto<Integer> getTurnCardTimes(@RequestParam(required = false) Map<String,Object> map) {
		return new ResultDto<Integer>(service.getTurnCardTimes(map));
	}
	
	/**
	 * @方法描述：获取活动id接口
	 * @param：nodeId
	 * @return: actyId hurdles
	 * */
	@GetMapping("/getactyid")
	public ResultDto<Map<String,Object>> getActyId(@RequestParam(required = false) String nodeId) {
		return new ResultDto<Map<String,Object>>(service.getActyId(nodeId));
	}
	
	/**
	 * @方法描述：判断活动结束
	 * @param： actyId 活动id custId 用户id
	 * */
	@GetMapping("/isactyend")
	public ResultDto<Integer> isActyEnd (@RequestParam(required = true) Map<String,Object> map) {
		return new ResultDto<Integer>(service.isActyEnd(map));
	}
	
	/**
	 * @方法描述：翻卡接口
	 * @param： actyId 活动id custId 用户id channel 渠道  hurdles 营销位
	 * @return: bonus 合成卡信息
	 * */
	@PostMapping("/turncard")
	public ResultDto<Map<String,Object>> turnCard(@RequestBody Map<String,Object> map) {
		return service.turnCard(map);
	}
	
	/**
	 * @方法描述：卡片合成接口
	 * @param： actyId 活动id custId 用户id channel 渠道  hurdles 营销位
	 * @return: bonus 合成卡信息
	 * */
	@PostMapping("/composecard")
	public ResultDto<CimpAppCardInfo> composeCard(@RequestBody Map<String,Object> map) {
		return service.composeCard(map);
	}
	
	/**
	 * @方法描述: 裂变返回奖励接口
	 * @param: custId bonus nodeId
	 * */
	@PostMapping("/getsharebonus")
	public ResultDto<Integer> getShareBonus(@RequestBody Map<String,Object> params) {
		return new ResultDto<Integer>(service.getShareBonus(params));
	}
}
