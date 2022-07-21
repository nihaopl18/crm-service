package cn.com.yusys.yscimc.marketmethod.domain;

import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;
import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * @项目名称: yscimc-cust-group模块
 * @类名称: CmicAppClickInfo
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: hyx
 * @创建时间: 2019-06-15 16:19:27
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "CMIC_APP_CLICK_INFO")
public class CmicAppClickInfo extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** 编号 **/
	@Id
	@Column(name = "ID")
	@Generated(GenerationType.UUID)
	private String id;
	
	/** 活动ID **/
	@Column(name = "ACTY_ID", unique = false, nullable = true, length = 32)
	private String actyId;
	
	/** 推荐人ID **/
	@Column(name = "RECOMMENDER_ID", unique = false, nullable = true, length = 32)
	private String recommenderId;
	
	/** 推荐人 **/
	@Column(name = "RECOMMENDER", unique = false, nullable = true, length = 40)
	private String recommender;
	
	/** 客户ID **/
	@Column(name = "CUST_ID", unique = false, nullable = true, length = 32)
	private String custId;
	
	/** 渠道 **/
	@Column(name = "CHANNEL", unique = false, nullable = true, length = 20)
	private String channel;
	
	/** 栏位 **/
	@Column(name = "HURDLES", unique = false, nullable = true, length = 20)
	private String hurdles;

	/** 栏位 **/
	@Column(name = "DATA", unique = false, nullable = true, length = 2000)
	private String data;

	
	/**
	 * @param id
	 */
	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}
	
    /**
     * @return Id
     */	
	public String getId() {
		return this.id;
	}
	
	/**
	 * @param actyId
	 */
	public void setActyId(String actyId) {
		this.actyId = actyId == null ? null : actyId.trim();
	}
	
    /**
     * @return ActyId
     */	
	public String getActyId() {
		return this.actyId;
	}
	
	/**
	 * @param recommenderId
	 */
	public void setRecommenderId(String recommenderId) {
		this.recommenderId = recommenderId == null ? null : recommenderId.trim();
	}
	
    /**
     * @return RecommenderId
     */	
	public String getRecommenderId() {
		return this.recommenderId;
	}
	
	/**
	 * @param recommender
	 */
	public void setRecommender(String recommender) {
		this.recommender = recommender == null ? null : recommender.trim();
	}
	
    /**
     * @return Recommender
     */	
	public String getRecommender() {
		return this.recommender;
	}
	
	/**
	 * @param custId
	 */
	public void setCustId(String custId) {
		this.custId = custId == null ? null : custId.trim();
	}
	
    /**
     * @return CustId
     */	
	public String getCustId() {
		return this.custId;
	}
	
	/**
	 * @param channel
	 */
	public void setChannel(String channel) {
		this.channel = channel == null ? null : channel.trim();
	}
	
    /**
     * @return Channel
     */	
	public String getChannel() {
		return this.channel;
	}
	
	/**
	 * @param hurdles
	 */
	public void setHurdles(String hurdles) {
		this.hurdles = hurdles == null ? null : hurdles.trim();
	}
	
    /**
     * @return Hurdles
     */	
	public String getHurdles() {
		return this.hurdles;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	@Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        CmicAppClickInfo other = (CmicAppClickInfo) that;
		return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
        	&& (this.getActyId() == null ? other.getActyId() == null : this.getActyId().equals(other.getActyId()))
        	&& (this.getRecommenderId() == null ? other.getRecommenderId() == null : this.getRecommenderId().equals(other.getRecommenderId()))
        	&& (this.getRecommender() == null ? other.getRecommender() == null : this.getRecommender().equals(other.getRecommender()))
        	&& (this.getCustId() == null ? other.getCustId() == null : this.getCustId().equals(other.getCustId()))
        	&& (this.getChannel() == null ? other.getChannel() == null : this.getChannel().equals(other.getChannel()))
        	&& (this.getHurdles() == null ? other.getHurdles() == null : this.getHurdles().equals(other.getHurdles()))
			&& (this.getData() == null ? other.getData() == null : this.getData().equals(other.getData()))
        ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getActyId() == null) ? 0 : getActyId().hashCode());
        result = prime * result + ((getRecommenderId() == null) ? 0 : getRecommenderId().hashCode());
        result = prime * result + ((getRecommender() == null) ? 0 : getRecommender().hashCode());
        result = prime * result + ((getCustId() == null) ? 0 : getCustId().hashCode());
        result = prime * result + ((getChannel() == null) ? 0 : getChannel().hashCode());
        result = prime * result + ((getHurdles() == null) ? 0 : getHurdles().hashCode());
		result = prime * result + ((getData() == null) ? 0 : getData().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", actyId=").append(actyId);
		sb.append(", recommenderId=").append(recommenderId);
		sb.append(", recommender=").append(recommender);
		sb.append(", custId=").append(custId);
		sb.append(", channel=").append(channel);
		sb.append(", hurdles=").append(hurdles);
		sb.append(", data=").append(data);
        sb.append("]");
        return sb.toString();
    }
}