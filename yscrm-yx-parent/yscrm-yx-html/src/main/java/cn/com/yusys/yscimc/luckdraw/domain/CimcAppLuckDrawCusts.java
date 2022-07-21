package cn.com.yusys.yscimc.luckdraw.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;
/**
 * @项目名称: yscimc-app-mobile模块
 * @类名称: CimcAppLuckDrawCusts
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: zhanghan2
 * @创建时间: 2019-06-19 20:24:36
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "CMIC_APP_LUCK_CUSTS")
public class CimcAppLuckDrawCusts extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** 编号 **/
	@Id
	@Column(name = "ID")
	@Generated(GenerationType.UUID)
	private String id;
	
	/** 产品ID **/
	@Column(name = "ACTIVITY_ID")
	private String activityId;
	
	/** FORM_ID **/
	@Column(name = "FORM_ID")
	private String formId;
	
	/** 客户ID **/
	@Column(name = "CUST_ID")
	private String custId;
	
	/** 推荐人ID  **/
	@Column(name = "RECOMMENDER_ID")
	private String recommenderId;
	
	/** 推荐人名称 **/
	@Column(name = "RECOMMENDER_NAME", unique = false, nullable = true, length = 100)
	private String recommenderName;
	
	/** 渠道 **/
	@Column(name = "CHANNEL", unique = false, nullable = true, length = 100)
	private String channel;
	
	/** 栏位 **/
	@Column(name = "HURDLES", unique = false, nullable = true, length = 100)
	private String hurdles;
	
	/** 创建日期 **/
	@Column(name = "CRAT_DT", unique = false, nullable = true, length = 20)
	private Date cratDt;
	
	/** 最近修改时间 **/
	@Column(name = "LAST_CHG_DT", unique = false, nullable = true, length = 20)
	private Date lastChgDt;
	
	/** 抽奖次数 **/
	@Column(name = "LUCK_DRAW_NUM", unique = false, nullable = true, length = 100)
	private BigDecimal luckDrawNum;
	
	/** 当日抽奖次数 **/
	@Column(name = "TODAY_NUM", unique = false, nullable = true, length = 100)
	private BigDecimal todayNum;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getActivityId() {
		return activityId;
	}

	public void setActivityId(String activityId) {
		this.activityId = activityId;
	}

	public String getFormId() {
		return formId;
	}

	public void setFormId(String formId) {
		this.formId = formId;
	}

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public String getRecommenderId() {
		return recommenderId;
	}

	public void setRecommenderId(String recommenderId) {
		this.recommenderId = recommenderId;
	}

	public String getRecommenderName() {
		return recommenderName;
	}

	public void setRecommenderName(String recommenderName) {
		this.recommenderName = recommenderName;
	}

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public String getHurdles() {
		return hurdles;
	}

	public void setHurdles(String hurdles) {
		this.hurdles = hurdles;
	}

	public Date getCratDt() {
		return cratDt;
	}

	public void setCratDt(Date cratDt) {
		this.cratDt = cratDt;
	}

	public Date getLastChgDt() {
		return lastChgDt;
	}

	public void setLastChgDt(Date lastChgDt) {
		this.lastChgDt = lastChgDt;
	}

	public BigDecimal getLuckDrawNum() {
		return luckDrawNum;
	}

	public void setLuckDrawNum(BigDecimal luckDrawNum) {
		this.luckDrawNum = luckDrawNum;
	}

	public BigDecimal getTodayNum() {
		return todayNum;
	}

	public void setTodayNum(BigDecimal todayNum) {
		this.todayNum = todayNum;
	}
	
}
