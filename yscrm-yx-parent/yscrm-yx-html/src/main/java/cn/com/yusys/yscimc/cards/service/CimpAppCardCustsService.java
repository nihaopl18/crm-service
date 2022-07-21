package cn.com.yusys.yscimc.cards.service;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.yusys.yscimc.cards.domain.CimpAppCardCusts;
import cn.com.yusys.yscimc.cards.domain.CimpAppCardInfo;
import cn.com.yusys.yscimc.cards.repository.mapper.CimpAppCardCustsMapper;
import cn.com.yusys.yscimc.cards.repository.mapper.CimpAppCardInfoMapper;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;

/**
 * @项目名称: yscimc-app-mobile模块
 * @类名称: CimpAppCardCustsService
 * @类描述: #用户集卡服务类
 * @功能描述: 用户集卡操作逻辑
 * @创建人: yangxiao2
 * @创建时间: 2019-06-11 20:24:36
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class CimpAppCardCustsService extends CommonService{
	@Autowired
	private CimpAppCardCustsMapper mapperCust;
	
	@Autowired
	private CimpAppCardInfoMapper mapperInfo;
	
	@Override
	protected CommonMapper<?> getMapper() {
		return mapperCust;
	}
	
	public static final int ZERO_TIMES = 0;
	public static final int SUCCESS_STAT = 0;
	public static final int FAILED_STAT = -1;
	public static final String ONE_CARD_NUM = "1";
	
	/**
	 * 获取集卡活动配置
	 * */
	public List<Map<String,Object>>getActyConfig(String formId) {
		return mapperCust.getActyConfig(formId);
	}
	
	/**
	 * 参与集卡活动用户统计接口
	 * */
	public Map<String,Object>getActyMembers(String actyId){
		return mapperCust.getActyMembers(actyId);
	}
	
	/**
	 * 参与集卡活动用户排序查询
	 * */
	public List<Map<String,Object>>getMembersOrder(String actyId){
		return mapperCust.getMembersOrder(actyId);
	}
	
	/**
	 * 用户集卡信息接口
	 * */
	public List<Map<String,Object>>getCustCards(Map<String,Object> map){
		return mapperCust.getCustCards(map);
	}
	
	/**
	 * 用户集卡翻卡次数接口
	 * */
	public int getTurnCardTimes(Map<String,Object> map) {
		return mapperCust.getTurnCardTimes(map);
	}
	
	/**
	 * 获取活动id接口
	 * */
	public Map<String,Object> getActyId(String nodeId) {
		return mapperCust.getActyId(nodeId);
	}
	
	/**
	 * @方法描述：判断活动结束
	 * @param： actyId 活动id custId 用户id
	 * */
	public int isActyEnd(Map<String,Object> map) {
		// 获取卡片对应活动id
		String activityId = mapperCust.nodeIdToActyId(map.get("actyId").toString());
		map.put("activityId", activityId);
		if (map.get("custId") == null || map.get("activityId") == null) {
			return FAILED_STAT;
		} else {
			if (mapperCust.getCustParentCard(map) != 0) {
				// 用户已拥有合成卡不再进行合成
				return FAILED_STAT;
			} else {
				return SUCCESS_STAT;
			}
		}
		
	}
	
	/**
	 * @方法描述：翻卡接口
	 * @param： actyId 活动id custId 用户id channel 渠道  hurdles 营销位 recommenderId 推荐人id
	 * @return: bonus 合成卡信息
	 * */
	public ResultDto<Map<String,Object>> turnCard(Map<String,Object> map) {
		ResultDto<Map<String,Object>> dto = new ResultDto<Map<String,Object>>();
		CimpAppCardCusts card = new CimpAppCardCusts();
		// 获取卡片对应活动id
		String activityId = mapperCust.nodeIdToActyId(map.get("actyId").toString());
		map.put("activityId", activityId);
		int times = mapperCust.getTurnCardTimes(map);
		if (times == ZERO_TIMES) {
			dto.setCode(FAILED_STAT);
			dto.setMessage("没有抽卡次数了");
		} else if (mapperCust.getCustParentCard(map) != 0) {
			dto.setCode(FAILED_STAT);
			dto.setMessage("活动已结束");
		} else {
			List<Map<String,Object>> cards = mapperInfo.getCards(map.get("actyId").toString());
			// 抽卡
			Random r = new Random();
			// 随机数取值范围
			int n = r.nextInt(cards.size());
			Map<String,Object> bonus = cards.get(n);
			// 新增卡片
			map.put("cardId", bonus.get("id"));
			if (mapperCust.getCustCardNum(map) != 0) {
				// 卡片重复
				mapperCust.addCardNum(map);
				// 减少用户翻卡次数
				mapperCust.reduceTurnCardNum(map);
			} else {
				// 新卡片
				card.setActyId(map.get("activityId").toString());
				card.setCustId(map.get("custId").toString());
				card.setChannel(map.get("channel").toString());
				card.setHurdles(map.get("hurdles").toString());
				card.setCardId(bonus.get("id").toString());
				card.setCardNum(1);
				card.setTurnCardNum(times);
				// 推荐人id
				if (map.get("recommenderId") != null) {
					card.setRecommenderId(map.get("recommenderId").toString());
				}
				mapperCust.insertSelective(card);
				// 减少用户翻卡次数
				mapperCust.reduceTurnCardNum(map);
			}
			dto.setCode(SUCCESS_STAT);
			dto.setData(bonus);
			dto.setMessage("抽卡成功");
		}
		return dto;
	}
	
	/**
	 * @方法描述：卡片合成接口
	 * @param： actyId 活动id custId 用户id channel 渠道  hurdles 营销位
	 * @return: bonus 合成卡信息
	 * */
	@Transactional(readOnly = false, rollbackFor = {Exception.class, RuntimeException.class})
	public ResultDto<CimpAppCardInfo> composeCard(Map<String,Object> map) {
		ResultDto<CimpAppCardInfo> dto = new ResultDto<CimpAppCardInfo>();
		// 获取卡片对应活动id
		String activityId = mapperCust.nodeIdToActyId(map.get("actyId").toString());
		map.put("activityId", activityId);
		List<Map<String,Object>> cards = mapperCust.getCustCards(map);
		Iterator<Map<String,Object>> it = cards.iterator();
		// 合成卡片消耗
		while(it.hasNext()) {
			Map<String,Object>card = it.next();
			if (ONE_CARD_NUM.equals(card.get("cardNum").toString())) {
				// 删除卡片
				mapperCust.deleteByPrimaryKey(card.get("id").toString());
			} else {
				// 卡片数量减一
				map.put("cardId", card.get("id"));
				mapperCust.reduceCardNum(map);
			}
		}
		// 加入合成卡片
		CimpAppCardCusts tcard = new CimpAppCardCusts();
		tcard.setActyId(map.get("activityId").toString());
		tcard.setCardId(mapperInfo.getParentCard(cards.get(0).get("cardId").toString()));
		tcard.setChannel(map.get("channel").toString());
		tcard.setCustId(map.get("custId").toString());
		tcard.setHurdles(map.get("hurdles").toString());
		// 合成卡片后不再参与活动
		tcard.setTurnCardNum(0); 
		tcard.setCardNum(1);
		mapperCust.insertSelective(tcard);
		
		// 返回合成卡信息
		CimpAppCardInfo comCard =  mapperInfo.getActyParentCard(tcard.getCardId());
		dto.setCode(SUCCESS_STAT);
		dto.setMessage("集卡成功");
		dto.setData(comCard);
		return dto;
	}
	
	/**
	 * @方法描述: 裂变返回奖励接口
	 * @param: custId bonus nodeId
	 * */
	public int getShareBonus(Map<String,Object> params) {
		String actyId = mapperCust.nodeIdToActyId(params.get("nodeId").toString());
		if (params.get("custId") == null || params.get("bonus") == null || params.get("nodeId") == null) {
			return FAILED_STAT;
		} else if ("".equals(actyId) || actyId == null) {
			return FAILED_STAT;
		} else {
			params.put("actyId", actyId);
			mapperCust.getShareBonus(params);
			return SUCCESS_STAT;
		}
	}
}
