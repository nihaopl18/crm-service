package cn.com.yusys.yusp.cm.market.domain;

import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;


/**
 * @项目名称: yscimc-app-cm模块
 * @类名称: CimpCmMarketPositCt
 * @类描述: CIMP_CM_MARKET_POSIT_CT数据实体类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2019-06-11 15:33:32
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "CIMP_CM_MARKET_POSIT_CT")
public class CimpCmMarketPositCt extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** 主键ID **/
	@Id
	@Column(name = "CONTENT_ID")
	@Generated(GenerationType.UUID)
	private String contentId;
	
	/** 活动ID **/
	@Column(name = "ACTIVITY_ID", unique = false, nullable = true, length = 32)
	private String activityId;
	
	/** 组件ID **/
	@Column(name = "ASSAMLY_ID", unique = false, nullable = true, length = 32)
	private String assamlyId;
	
	/** 渠道组件的节点ID **/
	@Column(name = "CHANNEL_NODE_ID", unique = false, nullable = true, length = 32)
	private String channelNodeId;
	
	/** 活动节点id、素材ID **/
	@Column(name = "CT_NODE_ID", unique = false, nullable = true, length = 32)
	private String ctNodeId;
	
	/** 营销位标识 **/
	@Column(name = "MKT_POSIT_CODE", unique = false, nullable = true, length = 32)
	private String mktPositCode;
	
	/** 有效开始时间 **/
	@Column(name = "VS_START_DATE", unique = false, nullable = true, length = 10)
	private String vsStartDate;
	
	/** 有效结束时间 **/
	@Column(name = "VS_END_DATE", unique = false, nullable = true, length = 10)
	private String vsEndDate;
	
	/** 最近更新人 **/
	@Column(name = "LAST_CHG_USR", unique = false, nullable = true, length = 32)
	private String lastChgUsr;
	
	/** 最近更新人机构 **/
	@Column(name = "LAST_CHG_ORG", unique = false, nullable = true, length = 32)
	private String lastChgOrg;
	
	/** 最近更新时间 **/
	@Column(name = "LAST_CHG_DT", unique = false, nullable = true, length = 7)
	private Date lastChgDt;
	
	/** 创建人 **/
	@Column(name = "CRAT_USR", unique = false, nullable = true, length = 32)
	private String cratUsr;
	
	/** 创建人机构 **/
	@Column(name = "CRAT_ORG", unique = false, nullable = true, length = 32)
	private String cratOrg;
	
	/** 创建时间 **/
	@Column(name = "CRAT_DT", unique = false, nullable = true, length = 7)
	private Date cratDt;
	

	@Column(name = "DISPLAY_TYPE", unique = false, nullable = true, length = 32)
	private String displayType;
	

	@Column(name = "ACTIVITY_START_PIC", unique = false, nullable = true, length = 32)
	private String activityStartPic;

	@Column(name = "MARKET_TYPE_ID", unique = false, nullable = true, length = 32)
	private String marketTypeId;

	public String getMarketTypeId() {
		return marketTypeId;
	}

	public void setMarketTypeId(String marketTypeId) {
		this.marketTypeId = marketTypeId;
	}

	public String getDisplayType() {
		return displayType;
	}

	public void setDisplayType(String displayType) {
		this.displayType = displayType;
	}

	public String getActivityStartPic() {
		return activityStartPic;
	}

	public void setActivityStartPic(String activityStartPic) {
		this.activityStartPic = activityStartPic;
	}

	/**
	 * @param contentId
	 */
	public void setContentId(String contentId) {
		this.contentId = contentId == null ? null : contentId.trim();
	}
	
    /**
     * @return ContentId
     */	
	public String getContentId() {
		return this.contentId;
	}
	
	/**
	 * @param activityId
	 */
	public void setActivityId(String activityId) {
		this.activityId = activityId == null ? null : activityId.trim();
	}
	
    /**
     * @return ActivityId
     */	
	public String getActivityId() {
		return this.activityId;
	}
	
	/**
	 * @param assamlyId
	 */
	public void setAssamlyId(String assamlyId) {
		this.assamlyId = assamlyId == null ? null : assamlyId.trim();
	}
	
    /**
     * @return AssamlyId
     */	
	public String getAssamlyId() {
		return this.assamlyId;
	}
	
	/**
	 * @param channelNodeId
	 */
	public void setChannelNodeId(String channelNodeId) {
		this.channelNodeId = channelNodeId == null ? null : channelNodeId.trim();
	}
	
    /**
     * @return ChannelNodeId
     */	
	public String getChannelNodeId() {
		return this.channelNodeId;
	}
	
	/**
	 * @param ctNodeId
	 */
	public void setCtNodeId(String ctNodeId) {
		this.ctNodeId = ctNodeId == null ? null : ctNodeId.trim();
	}
	
    /**
     * @return CtNodeId
     */	
	public String getCtNodeId() {
		return this.ctNodeId;
	}
	
	/**
	 * @param mktPositCode
	 */
	public void setMktPositCode(String mktPositCode) {
		this.mktPositCode = mktPositCode == null ? null : mktPositCode.trim();
	}
	
    /**
     * @return MktPositCode
     */	
	public String getMktPositCode() {
		return this.mktPositCode;
	}
	
	/**
	 * @param vsStartDate
	 */
	public void setVsStartDate(String vsStartDate) {
		this.vsStartDate = vsStartDate;
	}
	
    /**
     * @return VsStartDate
     */	
	public String getVsStartDate() {
		return this.vsStartDate;
	}
	
	/**
	 * @param vsEndDate
	 */
	public void setVsEndDate(String vsEndDate) {
		this.vsEndDate = vsEndDate;
	}
	
    /**
     * @return VsEndDate
     */	
	public String getVsEndDate() {
		return this.vsEndDate;
	}
	
	/**
	 * @param lastChgUsr
	 */
	public void setLastChgUsr(String lastChgUsr) {
		this.lastChgUsr = lastChgUsr == null ? null : lastChgUsr.trim();
	}
	
    /**
     * @return LastChgUsr
     */	
	public String getLastChgUsr() {
		return this.lastChgUsr;
	}
	
	/**
	 * @param lastChgOrg
	 */
	public void setLastChgOrg(String lastChgOrg) {
		this.lastChgOrg = lastChgOrg == null ? null : lastChgOrg.trim();
	}
	
    /**
     * @return LastChgOrg
     */	
	public String getLastChgOrg() {
		return this.lastChgOrg;
	}
	
	/**
	 * @param lastChgDt
	 */
	public void setLastChgDt(Date lastChgDt) {
		this.lastChgDt = lastChgDt;
	}
	
    /**
     * @return LastChgDt
     */	
	public Date getLastChgDt() {
		return this.lastChgDt;
	}
	
	/**
	 * @param cratUsr
	 */
	public void setCratUsr(String cratUsr) {
		this.cratUsr = cratUsr == null ? null : cratUsr.trim();
	}
	
    /**
     * @return CratUsr
     */	
	public String getCratUsr() {
		return this.cratUsr;
	}
	
	/**
	 * @param cratOrg
	 */
	public void setCratOrg(String cratOrg) {
		this.cratOrg = cratOrg == null ? null : cratOrg.trim();
	}
	
    /**
     * @return CratOrg
     */	
	public String getCratOrg() {
		return this.cratOrg;
	}
	
	/**
	 * @param cratDt
	 */
	public void setCratDt(Date cratDt) {
		this.cratDt = cratDt;
	}
	
    /**
     * @return CratDt
     */	
	public Date getCratDt() {
		return this.cratDt;
	}


}