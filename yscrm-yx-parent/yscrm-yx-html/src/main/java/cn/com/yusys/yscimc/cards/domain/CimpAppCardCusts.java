package cn.com.yusys.yscimc.cards.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

/**
 * @项目名称: yscimc-app-mobile模块
 * @类名称: CimpAppCardCusts
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: yangxiao2
 * @创建时间: 2019-06-11 20:24:36
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "CIMP_APP_CARD_CUSTS")
public class CimpAppCardCusts extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** 编号 **/
	@Id
	@Column(name = "ID")
	@Generated(GenerationType.UUID)
	private String id;
	
	public String getId() { return id; }
	public void setId(String id) { this.id=id; }
	
	/** 活动id **/
	@Column(name = "ACTY_ID")
	private String actyId;
	
	public String getActyId() { return actyId; }
	public void setActyId(String actyId) { this.actyId=actyId; }
	
	/** 客户id **/
	@Column(name = "CUST_ID")
	private String custId;
	
	public String getCustId() { return custId; }
	public void setCustId(String custId) { this.custId=custId; }
	
	/** 推荐人id **/
	@Column(name = "RECOMMENDER_ID")
	private String recommenderId;
	
	public String getRecommenderId() { return recommenderId; }
	public void setRecommenderId(String recommenderId) { this.recommenderId=recommenderId; }
	
	/** 推荐人 **/
	@Column(name = "RECOMMENDER")
	private String recommender;
	
	public String getRecommender() { return recommender; }
	public void setRecommender(String recommender) { this.recommender=recommender; }
	
	/** 渠道 **/
	@Column(name = "CHANNEL")
	private String channel;
	
	public String getChannel() { return channel; }
	public void setChannel(String channel) { this.channel=channel; }
	
	/** 栏位 **/
	@Column(name = "HURDLES")
	private String hurdles;
	
	public String getHurdles() { return hurdles; }
	public void setHurdles(String hurdles) { this.hurdles=hurdles; }
	
	/** 卡片id **/
	@Column(name = "CARD_ID")
	private String cardId;
	
	public String getCardId() { return cardId; }
	public void setCardId(String cardId) { this.cardId=cardId; }
	
	/** 卡片数量 **/
	@Column(name = "CARD_NUM")
	private long cardNum;
	
	public long getCardNum() { return cardNum; }
	public void setCardNum(long cardNum) { this.cardNum=cardNum; }
	
	/** 可翻卡次数 **/
	@Column(name = "TURN_CARD_NUM")
	private long turnCardNum;
	
	public long getTurnCardNum() { return turnCardNum; }
	public void setTurnCardNum(long turnCardNum) { this.turnCardNum=turnCardNum; }
	
	

}
