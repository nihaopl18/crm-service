package cn.com.yusys.yusp.uimp.business.pma.app.domain;

import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;


/**
 * @项目名称: uimp-business-pma-app-core模块
 * @类名称: PmaAppMarketActivityInfo
 * @类描述: PMA_APP_MARKET_ACTIVITY_INFO数据实体类
 * @功能描述: 
 * @创建人: 13842
 * @创建时间: 2020-07-08 14:20:35
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@Entity
@Table(name = "PMA_APP_MARKET_ACTIVITY_INFO")
public class PmaAppMarketActivityInfo extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** 营销活动编号(主键, 32位uuid) **/
	@Id
	@Generated(GenerationType.UUID)
	@Column(name = "INFO_ID")
	private String infoId;

	/** 营销活动名称 **/
	@Column(name = "MARKET_NAME", unique = false, nullable = true, length = 100)
	private String marketName;
	
	/** 营销展示图片 **/
	@Column(name = "FILE_PATH", unique = false, nullable = true, length = 500)
	private String filePath;
	
	/** 状态：1-有效，0-无效 **/
	@Column(name = "STATE", unique = false, nullable = true, length = 2)
	private String state;
	
	/** 创建人 **/
	@Column(name = "CRAT_USE", unique = false, nullable = true, length = 32)
	private String cratUse;
	
	/** 创建机构 **/
	@Column(name = "CRAT_ORG", unique = false, nullable = true, length = 32)
	private String cratOrg;
	
	/** 创建时间 **/
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss" , timezone = "GMT+8")
	@Column(name = "CRAT_DT", unique = false, nullable = true, length = 7)
	private Date cratDt;
	
	/** 维护时间 **/
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss" , timezone = "GMT+8")
	@Column(name = "LAST_CHG_DT", unique = false, nullable = true, length = 7)
	private Date lastChgDt;
	
	/** 维护人 **/
	@Column(name = "LAST_CHG_USE", unique = false, nullable = true, length = 32)
	private String lastChgUse;
	
	/** 维护机构 **/
	@Column(name = "LAST_CHG_ORG", unique = false, nullable = true, length = 32)
	private String lastChgOrg;
	
	/** 删除标志0--删除1正常 **/
	@Column(name = "IS_DEL", unique = false, nullable = true, length = 2)
	private String isDel;
	
	/** 营销活动简介 **/
	@Column(name = "MARKET_DETAIL", unique = false, nullable = true, length = 500)
	private String marketDetail;
	
	/** 关联考核方案 **/
	@Column(name = "SCHEME_ID", unique = false, nullable = true, length = 32)
	private String schemeId;
	
	
	/**
	 * @param infoId
	 */
	public void setInfoId(String infoId) {
		this.infoId = infoId == null ? null : infoId.trim();
	}
	
    /**
     * @return InfoId
     */	
	public String getInfoId() {
		return this.infoId;
	}
	
	/**
	 * @param marketName
	 */
	public void setMarketName(String marketName) {
		this.marketName = marketName == null ? null : marketName.trim();
	}
	
    /**
     * @return MarketName
     */	
	public String getMarketName() {
		return this.marketName;
	}
	
	/**
	 * @param filePath
	 */
	public void setFilePath(String filePath) {
		this.filePath = filePath == null ? null : filePath.trim();
	}
	
    /**
     * @return FilePath
     */	
	public String getFilePath() {
		return this.filePath;
	}
	
	/**
	 * @param state
	 */
	public void setState(String state) {
		this.state = state == null ? null : state.trim();
	}
	
    /**
     * @return State
     */	
	public String getState() {
		return this.state;
	}
	
	/**
	 * @param cratUse
	 */
	public void setCratUse(String cratUse) {
		this.cratUse = cratUse == null ? null : cratUse.trim();
	}
	
    /**
     * @return CratUse
     */	
	public String getCratUse() {
		return this.cratUse;
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
	 * @param lastChgUse
	 */
	public void setLastChgUse(String lastChgUse) {
		this.lastChgUse = lastChgUse == null ? null : lastChgUse.trim();
	}
	
    /**
     * @return LastChgUse
     */	
	public String getLastChgUse() {
		return this.lastChgUse;
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
	 * @param isDel
	 */
	public void setIsDel(String isDel) {
		this.isDel = isDel == null ? null : isDel.trim();
	}
	
    /**
     * @return IsDel
     */	
	public String getIsDel() {
		return this.isDel;
	}
	
	/**
	 * @param marketDetail
	 */
	public void setMarketDetail(String marketDetail) {
		this.marketDetail = marketDetail == null ? null : marketDetail.trim();
	}
	
    /**
     * @return MarketDetail
     */	
	public String getMarketDetail() {
		return this.marketDetail;
	}
	
	/**
	 * @param schemeId
	 */
	public void setSchemeId(String schemeId) {
		this.schemeId = schemeId == null ? null : schemeId.trim();
	}
	
    /**
     * @return SchemeId
     */	
	public String getSchemeId() {
		return this.schemeId;
	}


}