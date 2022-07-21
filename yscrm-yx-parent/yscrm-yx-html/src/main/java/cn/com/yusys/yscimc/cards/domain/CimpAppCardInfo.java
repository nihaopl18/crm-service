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
 * @类名称: CimpAppCardInfo
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: yangxiao2
 * @创建时间: 2019-06-10 20:24:36
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "CIMP_APP_CARD_INFO")
public class CimpAppCardInfo extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** 编号 **/
	@Id
	@Column(name = "ID")
	@Generated(GenerationType.UUID)
	private String id;
	
	public String getId() { return id; }
	public void setId(String id) { this.id=id; }
	
	/** 父编号 **/
	@Column(name = "PARENT_ID")
	private String parentId;
	
	public String getParentId() { return parentId; }
	public void setParentId(String parentId) { this.parentId=parentId; }
	
	/** 卡名称 **/
	@Column(name = "CARD_NAME")
	private String cardName;
	
	public String getCardName() { return cardName; }
	public void setCardName(String cardName) { this.cardName=cardName; }
	
	/** 卡类型 **/
	@Column(name = "CARD_TYPE")
	private String cardType;
	
	public String getCardType() { return cardType; }
	public void setCardType(String cardType) { this.cardType=cardType; }
	
	/** 卡图片  **/
	@Column(name = "CARD_PIC")
	private String cardPic;
	
	public String getCardPic() { return cardPic; }
	public void setCardPic(String cardPic) { this.cardPic=cardPic; }
	
	/** 活动id **/
	@Column(name = "ACTY_ID")
	private String actyId;
	
	public String getActyId() { return actyId; }
	public void setActyId(String actyId) { this.actyId=actyId; }
}
