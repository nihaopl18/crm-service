package cn.com.yusys.yscimc.cards.repository.mapper;

import java.util.List;
import java.util.Map;

import cn.com.yusys.yscimc.cards.domain.CimpAppCardInfo;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
/**
 * @项目名称: yscimc-app-mobile模块
 * @类名称: CimpAppCardInfoMapper
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
public interface CimpAppCardInfoMapper extends CommonMapper<CimpAppCardInfo>{
	/**
	 * 卡片查询接口
	 * */
	List<Map<String,Object>> getCards(String actyId);
	/**
	 * 卡片删除接口
	 * */
	int delCards(String id);
	/**
	 * 获取卡片父节点
	 * */
	String getParentCard(String cardId);
	/**
	 * 根据活动id删除卡片
	 * */
	int delByActyId(String actyId);
	/**
	 * 获取活动合成卡信息
	 * */
	CimpAppCardInfo getActyParentCard (String id);
}
