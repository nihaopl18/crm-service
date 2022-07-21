package cn.com.yusys.yscimc.cards.repository.mapper;

import java.util.List;
import java.util.Map;

import cn.com.yusys.yscimc.cards.domain.CimpAppCardCusts;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
/**
 * @项目名称: yscimc-app-mobile模块
 * @类名称: CimpAppCardCustsMapper
 * @类描述: #Dao类
 * @功能描述: 
 * @创建人: yangxiao2
 * @创建时间: 2019-06-11 20:24:36
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public interface CimpAppCardCustsMapper extends CommonMapper<CimpAppCardCusts>  {
	
	/**
	 * 集卡活动配置
	 * */
	List<Map<String,Object>>getActyConfig(String formId);
	
	/**
	 * 参与集卡活动用户统计接口
	 * */
	Map<String,Object>getActyMembers(String actyId);
	
	/**
	 * 参与集卡活动用户排序查询
	 * */
	List<Map<String,Object>>getMembersOrder(String actyId);
	
	/**
	 * 用户集卡信息接口
	 * */
	List<Map<String,Object>>getCustCards(Map<String,Object> map);
	
	/**
	 * 用户集卡翻卡次数接口
	 * */
	int getTurnCardTimes(Map<String,Object> map);
	
	/**
	 * 添加用户重复卡
	 * */
	int addCardNum(Map<String,Object> map);
	
	/**
	 * 减少用户重复卡
	 * */
	int reduceCardNum(Map<String,Object> map);
	
	/**
	 * 判断用户抽卡是否重复
	 * */
	int getCustCardNum(Map<String,Object> map);
	
	/**
	 * 获取活动id接口
	 * */
	Map<String,Object> getActyId(String nodeId);
	
	/**
	 * 裂变返回奖励接口
	 * */
	int getShareBonus(Map<String,Object> params);
	
	/**
	 * 节点id转换活动id
	 * */
	String nodeIdToActyId(String nodeId);
	
	/**
	 * 减少用户翻卡次数
	 * */
	int reduceTurnCardNum(Map<String,Object> params);
	
	/**
	 * 获取用户合成卡
	 * */
	int getCustParentCard(Map<String,Object> params);
}
