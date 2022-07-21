package cn.com.yusys.yscrm.cust.person.domain;



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
 * @项目名称: yscrm-entity-cust-person-core模块
 * @类名称: AcrmFciPerPreferInfo
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2019-02-11 20:34:06
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "ACRM_F_CI_PER_PREFER_INFO")
public class AcrmFciPerPreferInfo extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	/** ID主键 **/
	@Id
	@Column(name = "CUST_ID", unique = false, nullable = true, length = 40)
	@Generated(GenerationType.UUID)
	private String custId;
	
	/** 数据日期
 **/
	@Column(name = "DATA_DATE", unique = false, nullable = true, length = 8)
	private String dataDate;
	
	/** 最近更新系统
 **/
	@Column(name = "LAST_CHG_SYS", unique = false, nullable = true, length = 20)
	private String lastChgSys;
	
	/** 最近更新人
 **/
	@Column(name = "LAST_CHG_USR", unique = false, nullable = true, length = 20)
	private String lastChgUsr;
	
	/** 最近更新时间
 **/
	
	@Column(name = "LAST_CHG_DT", unique = false, nullable = true, length = 11)
	private Date lastChgDt;
	
	/** 法人
 **/
	@Column(name = "CORP_ORG_CODE", unique = false, nullable = true, length = 20)
	private String corpOrgCode;
	
	
	/** 电子渠道
 **/
	@Column(name = "CHN_CD", unique = false, nullable = true, length = 60)
	private String chnCd;
	
	/** 其他
 **/
	@Column(name = "CHN_OTH", unique = false, nullable = true, length = 200)
	private String chnOth;
	
	/** 投资喜好
 **/
	@Column(name = "INV_CD", unique = false, nullable = true, length = 60)
	private String invCd;
	
	/** 其他
 **/
	@Column(name = "INV_OTH", unique = false, nullable = true, length = 200)
	private String invOth;
	
	/** 理财服务和理财咨询
 **/
	@Column(name = "FIN_ADVI_CD", unique = false, nullable = true, length = 60)
	private String finAdviCd;
	
	/** 其他
 **/
	@Column(name = "FIN_OTH", unique = false, nullable = true, length = 200)
	private String finOth;
	
	/** 希望理财经理的联系方式
 **/
	@Column(name = "CONT_CD", unique = false, nullable = true, length = 60)
	private String contCd;
	
	/** 其他
 **/
	@Column(name = "CONT_OTH", unique = false, nullable = true, length = 200)
	private String contOth;
	
	/** 沙龙活动
 **/
	@Column(name = "SALO_CD", unique = false, nullable = true, length = 60)
	private String saloCd;
	
	/** 其他
 **/
	@Column(name = "SALO_OTH", unique = false, nullable = true, length = 200)
	private String saloOth;
	
	/** 兴趣爱好
 **/
	@Column(name = "HOBB_CD", unique = false, nullable = true, length = 60)
	private String hobbCd;
	
	/** 其他
 **/
	@Column(name = "HOBB_OTH", unique = false, nullable = true, length = 200)
	private String hobbOth;
	
	/** 联系时间
 **/
	@Column(name = "CONT_TIME_CD", unique = false, nullable = true, length = 60)
	private String contTimeCd;
	
	/** 投资周期
 **/
	@Column(name = "INV_TERM_CD", unique = false, nullable = true, length = 60)
	private String invTermCd;
	
	/** 宗教信仰(其他信息)
 **/
	@Column(name = "FAITH_CD", unique = false, nullable = true, length = 200)
	private String faithCd;
	
	/** 忌讳(其他信息)
 **/
	@Column(name = "TABOO", unique = false, nullable = true, length = 200)
	private String taboo;
	
	/** 特别需求(其他信息)
 **/
	@Column(name = "SPEC_NEED", unique = false, nullable = true, length = 200)
	private String specNeed;
	
	/** 备注(其他信息)
 **/
	@Column(name = "REMARKS", unique = false, nullable = true, length = 200)
	private String remarks;
	
	/** 金融业务
 **/
	@Column(name = "FIN_BUSI_CD", unique = false, nullable = true, length = 60)
	private String finBusiCd;
	
	/** 其他
 **/
	@Column(name = "FIN_BUSI_OTH", unique = false, nullable = true, length = 200)
	private String finBusiOth;
	
	/** 休闲类型
 **/
	@Column(name = "ARDER_CD", unique = false, nullable = true, length = 60)
	private String arderCd;
	
	/** 其他
 **/
	@Column(name = "ARDER_OTH", unique = false, nullable = true, length = 200)
	private String arderOth;
	
	/** 媒体类型
 **/
	@Column(name = "MEDIA_CD", unique = false, nullable = true, length = 60)
	private String mediaCd;
	
	/** 其他
 **/
	@Column(name = "MEDIA_OTH", unique = false, nullable = true, length = 200)
	private String mediaOth;
	
	/** 运动类型
 **/
	@Column(name = "SPORT_CD", unique = false, nullable = true, length = 60)
	private String sportCd;
	
	/** 其他
 **/
	@Column(name = "SPORT_OTH", unique = false, nullable = true, length = 200)
	private String sportOth;
	
	/** 杂志类型
 **/
	@Column(name = "MAGAZ_CD", unique = false, nullable = true, length = 60)
	private String magazCd;
	
	/** 其他
 **/
	@Column(name = "MAGAZ_OTH", unique = false, nullable = true, length = 200)
	private String magazOth;
	
	/** 电视节目
 **/
	@Column(name = "TVSHOW_CD", unique = false, nullable = true, length = 60)
	private String tvshowCd;
	
	/** 其他
 **/
	@Column(name = "TVSHOW_OTH", unique = false, nullable = true, length = 200)
	private String tvshowOth;
	
	/** 宠物类型
 **/
	@Column(name = "PET_CD", unique = false, nullable = true, length = 60)
	private String petCd;
	
	/** 其他
 **/
	@Column(name = "PET_OTH", unique = false, nullable = true, length = 200)
	private String petOth;
	
	/** 收藏类型
 **/
	@Column(name = "COLL_CD", unique = false, nullable = true, length = 60)
	private String collCd;
	
	/** 其他
 **/
	@Column(name = "COLL_OTH", unique = false, nullable = true, length = 200)
	private String collOth;
	
	/** 消费习惯
 **/
	@Column(name = "CONS_CD", unique = false, nullable = true, length = 60)
	private String consCd;
	
	/** 消费渠道
 **/
	@Column(name = "CONS_CHN_CD", unique = false, nullable = true, length = 60)
	private String consChnCd;
	
	/** 喜好品牌类型
 **/
	@Column(name = "CONS_BRAND_CD", unique = false, nullable = true, length = 60)
	private String consBrandCd;
	
	/** 其他
 **/
	@Column(name = "CONS_OTH", unique = false, nullable = true, length = 200)
	private String consOth;
	
	/**
	 * @param dataDate
	 */
	public void setDataDate(String dataDate) {
		this.dataDate = dataDate == null ? null : dataDate.trim();
	}
	
    /**
     * @return DataDate
     */	
	public String getDataDate() {
		return this.dataDate;
	}
	
	/**
	 * @param lastChgSys
	 */
	public void setLastChgSys(String lastChgSys) {
		this.lastChgSys = lastChgSys == null ? null : lastChgSys.trim();
	}
	
    /**
     * @return LastChgSys
     */	
	public String getLastChgSys() {
		return this.lastChgSys;
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
	 * @param corpOrgCode
	 */
	public void setCorpOrgCode(String corpOrgCode) {
		this.corpOrgCode = corpOrgCode == null ? null : corpOrgCode.trim();
	}
	
    /**
     * @return CorpOrgCode
     */	
	public String getCorpOrgCode() {
		return this.corpOrgCode;
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
	 * @param chnCd
	 */
	public void setChnCd(String chnCd) {
		this.chnCd = chnCd == null ? null : chnCd.trim();
	}
	
    /**
     * @return ChnCd
     */	
	public String getChnCd() {
		return this.chnCd;
	}
	
	/**
	 * @param chnOth
	 */
	public void setChnOth(String chnOth) {
		this.chnOth = chnOth == null ? null : chnOth.trim();
	}
	
    /**
     * @return ChnOth
     */	
	public String getChnOth() {
		return this.chnOth;
	}
	
	/**
	 * @param invCd
	 */
	public void setInvCd(String invCd) {
		this.invCd = invCd == null ? null : invCd.trim();
	}
	
    /**
     * @return InvCd
     */	
	public String getInvCd() {
		return this.invCd;
	}
	
	/**
	 * @param invOth
	 */
	public void setInvOth(String invOth) {
		this.invOth = invOth == null ? null : invOth.trim();
	}
	
    /**
     * @return InvOth
     */	
	public String getInvOth() {
		return this.invOth;
	}
	
	/**
	 * @param finAdviCd
	 */
	public void setFinAdviCd(String finAdviCd) {
		this.finAdviCd = finAdviCd == null ? null : finAdviCd.trim();
	}
	
    /**
     * @return FinAdviCd
     */	
	public String getFinAdviCd() {
		return this.finAdviCd;
	}
	
	/**
	 * @param finOth
	 */
	public void setFinOth(String finOth) {
		this.finOth = finOth == null ? null : finOth.trim();
	}
	
    /**
     * @return FinOth
     */	
	public String getFinOth() {
		return this.finOth;
	}
	
	/**
	 * @param contCd
	 */
	public void setContCd(String contCd) {
		this.contCd = contCd == null ? null : contCd.trim();
	}
	
    /**
     * @return ContCd
     */	
	public String getContCd() {
		return this.contCd;
	}
	
	/**
	 * @param contOth
	 */
	public void setContOth(String contOth) {
		this.contOth = contOth == null ? null : contOth.trim();
	}
	
    /**
     * @return ContOth
     */	
	public String getContOth() {
		return this.contOth;
	}
	
	/**
	 * @param saloCd
	 */
	public void setSaloCd(String saloCd) {
		this.saloCd = saloCd == null ? null : saloCd.trim();
	}
	
    /**
     * @return SaloCd
     */	
	public String getSaloCd() {
		return this.saloCd;
	}
	
	/**
	 * @param saloOth
	 */
	public void setSaloOth(String saloOth) {
		this.saloOth = saloOth == null ? null : saloOth.trim();
	}
	
    /**
     * @return SaloOth
     */	
	public String getSaloOth() {
		return this.saloOth;
	}
	
	/**
	 * @param hobbCd
	 */
	public void setHobbCd(String hobbCd) {
		this.hobbCd = hobbCd == null ? null : hobbCd.trim();
	}
	
    /**
     * @return HobbCd
     */	
	public String getHobbCd() {
		return this.hobbCd;
	}
	
	/**
	 * @param hobbOth
	 */
	public void setHobbOth(String hobbOth) {
		this.hobbOth = hobbOth == null ? null : hobbOth.trim();
	}
	
    /**
     * @return HobbOth
     */	
	public String getHobbOth() {
		return this.hobbOth;
	}
	
	/**
	 * @param contTimeCd
	 */
	public void setContTimeCd(String contTimeCd) {
		this.contTimeCd = contTimeCd == null ? null : contTimeCd.trim();
	}
	
    /**
     * @return ContTimeCd
     */	
	public String getContTimeCd() {
		return this.contTimeCd;
	}
	
	/**
	 * @param invTermCd
	 */
	public void setInvTermCd(String invTermCd) {
		this.invTermCd = invTermCd == null ? null : invTermCd.trim();
	}
	
    /**
     * @return InvTermCd
     */	
	public String getInvTermCd() {
		return this.invTermCd;
	}
	
	/**
	 * @param faithCd
	 */
	public void setFaithCd(String faithCd) {
		this.faithCd = faithCd == null ? null : faithCd.trim();
	}
	
    /**
     * @return FaithCd
     */	
	public String getFaithCd() {
		return this.faithCd;
	}
	
	/**
	 * @param taboo
	 */
	public void setTaboo(String taboo) {
		this.taboo = taboo == null ? null : taboo.trim();
	}
	
    /**
     * @return Taboo
     */	
	public String getTaboo() {
		return this.taboo;
	}
	
	/**
	 * @param specNeed
	 */
	public void setSpecNeed(String specNeed) {
		this.specNeed = specNeed == null ? null : specNeed.trim();
	}
	
    /**
     * @return SpecNeed
     */	
	public String getSpecNeed() {
		return this.specNeed;
	}
	
	/**
	 * @param remarks
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks == null ? null : remarks.trim();
	}
	
    /**
     * @return Remarks
     */	
	public String getRemarks() {
		return this.remarks;
	}
	
	/**
	 * @param finBusiCd
	 */
	public void setFinBusiCd(String finBusiCd) {
		this.finBusiCd = finBusiCd == null ? null : finBusiCd.trim();
	}
	
    /**
     * @return FinBusiCd
     */	
	public String getFinBusiCd() {
		return this.finBusiCd;
	}
	
	/**
	 * @param finBusiOth
	 */
	public void setFinBusiOth(String finBusiOth) {
		this.finBusiOth = finBusiOth == null ? null : finBusiOth.trim();
	}
	
    /**
     * @return FinBusiOth
     */	
	public String getFinBusiOth() {
		return this.finBusiOth;
	}
	
	/**
	 * @param arderCd
	 */
	public void setArderCd(String arderCd) {
		this.arderCd = arderCd == null ? null : arderCd.trim();
	}
	
    /**
     * @return ArderCd
     */	
	public String getArderCd() {
		return this.arderCd;
	}
	
	/**
	 * @param arderOth
	 */
	public void setArderOth(String arderOth) {
		this.arderOth = arderOth == null ? null : arderOth.trim();
	}
	
    /**
     * @return ArderOth
     */	
	public String getArderOth() {
		return this.arderOth;
	}
	
	/**
	 * @param mediaCd
	 */
	public void setMediaCd(String mediaCd) {
		this.mediaCd = mediaCd == null ? null : mediaCd.trim();
	}
	
    /**
     * @return MediaCd
     */	
	public String getMediaCd() {
		return this.mediaCd;
	}
	
	/**
	 * @param mediaOth
	 */
	public void setMediaOth(String mediaOth) {
		this.mediaOth = mediaOth == null ? null : mediaOth.trim();
	}
	
    /**
     * @return MediaOth
     */	
	public String getMediaOth() {
		return this.mediaOth;
	}
	
	/**
	 * @param sportCd
	 */
	public void setSportCd(String sportCd) {
		this.sportCd = sportCd == null ? null : sportCd.trim();
	}
	
    /**
     * @return SportCd
     */	
	public String getSportCd() {
		return this.sportCd;
	}
	
	/**
	 * @param sportOth
	 */
	public void setSportOth(String sportOth) {
		this.sportOth = sportOth == null ? null : sportOth.trim();
	}
	
    /**
     * @return SportOth
     */	
	public String getSportOth() {
		return this.sportOth;
	}
	
	/**
	 * @param magazCd
	 */
	public void setMagazCd(String magazCd) {
		this.magazCd = magazCd == null ? null : magazCd.trim();
	}
	
    /**
     * @return MagazCd
     */	
	public String getMagazCd() {
		return this.magazCd;
	}
	
	/**
	 * @param magazOth
	 */
	public void setMagazOth(String magazOth) {
		this.magazOth = magazOth == null ? null : magazOth.trim();
	}
	
    /**
     * @return MagazOth
     */	
	public String getMagazOth() {
		return this.magazOth;
	}
	
	/**
	 * @param tvshowCd
	 */
	public void setTvshowCd(String tvshowCd) {
		this.tvshowCd = tvshowCd == null ? null : tvshowCd.trim();
	}
	
    /**
     * @return TvshowCd
     */	
	public String getTvshowCd() {
		return this.tvshowCd;
	}
	
	/**
	 * @param tvshowOth
	 */
	public void setTvshowOth(String tvshowOth) {
		this.tvshowOth = tvshowOth == null ? null : tvshowOth.trim();
	}
	
    /**
     * @return TvshowOth
     */	
	public String getTvshowOth() {
		return this.tvshowOth;
	}
	
	/**
	 * @param petCd
	 */
	public void setPetCd(String petCd) {
		this.petCd = petCd == null ? null : petCd.trim();
	}
	
    /**
     * @return PetCd
     */	
	public String getPetCd() {
		return this.petCd;
	}
	
	/**
	 * @param petOth
	 */
	public void setPetOth(String petOth) {
		this.petOth = petOth == null ? null : petOth.trim();
	}
	
    /**
     * @return PetOth
     */	
	public String getPetOth() {
		return this.petOth;
	}
	
	/**
	 * @param collCd
	 */
	public void setCollCd(String collCd) {
		this.collCd = collCd == null ? null : collCd.trim();
	}
	
    /**
     * @return CollCd
     */	
	public String getCollCd() {
		return this.collCd;
	}
	
	/**
	 * @param collOth
	 */
	public void setCollOth(String collOth) {
		this.collOth = collOth == null ? null : collOth.trim();
	}
	
    /**
     * @return CollOth
     */	
	public String getCollOth() {
		return this.collOth;
	}
	
	/**
	 * @param consCd
	 */
	public void setConsCd(String consCd) {
		this.consCd = consCd == null ? null : consCd.trim();
	}
	
    /**
     * @return ConsCd
     */	
	public String getConsCd() {
		return this.consCd;
	}
	
	/**
	 * @param consChnCd
	 */
	public void setConsChnCd(String consChnCd) {
		this.consChnCd = consChnCd == null ? null : consChnCd.trim();
	}
	
    /**
     * @return ConsChnCd
     */	
	public String getConsChnCd() {
		return this.consChnCd;
	}
	
	/**
	 * @param consBrandCd
	 */
	public void setConsBrandCd(String consBrandCd) {
		this.consBrandCd = consBrandCd == null ? null : consBrandCd.trim();
	}
	
    /**
     * @return ConsBrandCd
     */	
	public String getConsBrandCd() {
		return this.consBrandCd;
	}
	
	/**
	 * @param consOth
	 */
	public void setConsOth(String consOth) {
		this.consOth = consOth == null ? null : consOth.trim();
	}
	
    /**
     * @return ConsOth
     */	
	public String getConsOth() {
		return this.consOth;
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
        AcrmFciPerPreferInfo other = (AcrmFciPerPreferInfo) that;
		return (this.getDataDate() == null ? other.getDataDate() == null : this.getDataDate().equals(other.getDataDate()))
        	&& (this.getLastChgSys() == null ? other.getLastChgSys() == null : this.getLastChgSys().equals(other.getLastChgSys()))
        	&& (this.getLastChgUsr() == null ? other.getLastChgUsr() == null : this.getLastChgUsr().equals(other.getLastChgUsr()))
                	&& (this.getCorpOrgCode() == null ? other.getCorpOrgCode() == null : this.getCorpOrgCode().equals(other.getCorpOrgCode()))
        	&& (this.getCustId() == null ? other.getCustId() == null : this.getCustId().equals(other.getCustId()))
        	&& (this.getChnCd() == null ? other.getChnCd() == null : this.getChnCd().equals(other.getChnCd()))
        	&& (this.getChnOth() == null ? other.getChnOth() == null : this.getChnOth().equals(other.getChnOth()))
        	&& (this.getInvCd() == null ? other.getInvCd() == null : this.getInvCd().equals(other.getInvCd()))
        	&& (this.getInvOth() == null ? other.getInvOth() == null : this.getInvOth().equals(other.getInvOth()))
        	&& (this.getFinAdviCd() == null ? other.getFinAdviCd() == null : this.getFinAdviCd().equals(other.getFinAdviCd()))
        	&& (this.getFinOth() == null ? other.getFinOth() == null : this.getFinOth().equals(other.getFinOth()))
        	&& (this.getContCd() == null ? other.getContCd() == null : this.getContCd().equals(other.getContCd()))
        	&& (this.getContOth() == null ? other.getContOth() == null : this.getContOth().equals(other.getContOth()))
        	&& (this.getSaloCd() == null ? other.getSaloCd() == null : this.getSaloCd().equals(other.getSaloCd()))
        	&& (this.getSaloOth() == null ? other.getSaloOth() == null : this.getSaloOth().equals(other.getSaloOth()))
        	&& (this.getHobbCd() == null ? other.getHobbCd() == null : this.getHobbCd().equals(other.getHobbCd()))
        	&& (this.getHobbOth() == null ? other.getHobbOth() == null : this.getHobbOth().equals(other.getHobbOth()))
        	&& (this.getContTimeCd() == null ? other.getContTimeCd() == null : this.getContTimeCd().equals(other.getContTimeCd()))
        	&& (this.getInvTermCd() == null ? other.getInvTermCd() == null : this.getInvTermCd().equals(other.getInvTermCd()))
        	&& (this.getFaithCd() == null ? other.getFaithCd() == null : this.getFaithCd().equals(other.getFaithCd()))
        	&& (this.getTaboo() == null ? other.getTaboo() == null : this.getTaboo().equals(other.getTaboo()))
        	&& (this.getSpecNeed() == null ? other.getSpecNeed() == null : this.getSpecNeed().equals(other.getSpecNeed()))
        	&& (this.getRemarks() == null ? other.getRemarks() == null : this.getRemarks().equals(other.getRemarks()))
        	&& (this.getFinBusiCd() == null ? other.getFinBusiCd() == null : this.getFinBusiCd().equals(other.getFinBusiCd()))
        	&& (this.getFinBusiOth() == null ? other.getFinBusiOth() == null : this.getFinBusiOth().equals(other.getFinBusiOth()))
        	&& (this.getArderCd() == null ? other.getArderCd() == null : this.getArderCd().equals(other.getArderCd()))
        	&& (this.getArderOth() == null ? other.getArderOth() == null : this.getArderOth().equals(other.getArderOth()))
        	&& (this.getMediaCd() == null ? other.getMediaCd() == null : this.getMediaCd().equals(other.getMediaCd()))
        	&& (this.getMediaOth() == null ? other.getMediaOth() == null : this.getMediaOth().equals(other.getMediaOth()))
        	&& (this.getSportCd() == null ? other.getSportCd() == null : this.getSportCd().equals(other.getSportCd()))
        	&& (this.getSportOth() == null ? other.getSportOth() == null : this.getSportOth().equals(other.getSportOth()))
        	&& (this.getMagazCd() == null ? other.getMagazCd() == null : this.getMagazCd().equals(other.getMagazCd()))
        	&& (this.getMagazOth() == null ? other.getMagazOth() == null : this.getMagazOth().equals(other.getMagazOth()))
        	&& (this.getTvshowCd() == null ? other.getTvshowCd() == null : this.getTvshowCd().equals(other.getTvshowCd()))
        	&& (this.getTvshowOth() == null ? other.getTvshowOth() == null : this.getTvshowOth().equals(other.getTvshowOth()))
        	&& (this.getPetCd() == null ? other.getPetCd() == null : this.getPetCd().equals(other.getPetCd()))
        	&& (this.getPetOth() == null ? other.getPetOth() == null : this.getPetOth().equals(other.getPetOth()))
        	&& (this.getCollCd() == null ? other.getCollCd() == null : this.getCollCd().equals(other.getCollCd()))
        	&& (this.getCollOth() == null ? other.getCollOth() == null : this.getCollOth().equals(other.getCollOth()))
        	&& (this.getConsCd() == null ? other.getConsCd() == null : this.getConsCd().equals(other.getConsCd()))
        	&& (this.getConsChnCd() == null ? other.getConsChnCd() == null : this.getConsChnCd().equals(other.getConsChnCd()))
        	&& (this.getConsBrandCd() == null ? other.getConsBrandCd() == null : this.getConsBrandCd().equals(other.getConsBrandCd()))
        	&& (this.getConsOth() == null ? other.getConsOth() == null : this.getConsOth().equals(other.getConsOth()))
        ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDataDate() == null) ? 0 : getDataDate().hashCode());
        result = prime * result + ((getLastChgSys() == null) ? 0 : getLastChgSys().hashCode());
        result = prime * result + ((getLastChgUsr() == null) ? 0 : getLastChgUsr().hashCode());
        result = prime * result + ((getCorpOrgCode() == null) ? 0 : getCorpOrgCode().hashCode());
        result = prime * result + ((getCustId() == null) ? 0 : getCustId().hashCode());
        result = prime * result + ((getChnCd() == null) ? 0 : getChnCd().hashCode());
        result = prime * result + ((getChnOth() == null) ? 0 : getChnOth().hashCode());
        result = prime * result + ((getInvCd() == null) ? 0 : getInvCd().hashCode());
        result = prime * result + ((getInvOth() == null) ? 0 : getInvOth().hashCode());
        result = prime * result + ((getFinAdviCd() == null) ? 0 : getFinAdviCd().hashCode());
        result = prime * result + ((getFinOth() == null) ? 0 : getFinOth().hashCode());
        result = prime * result + ((getContCd() == null) ? 0 : getContCd().hashCode());
        result = prime * result + ((getContOth() == null) ? 0 : getContOth().hashCode());
        result = prime * result + ((getSaloCd() == null) ? 0 : getSaloCd().hashCode());
        result = prime * result + ((getSaloOth() == null) ? 0 : getSaloOth().hashCode());
        result = prime * result + ((getHobbCd() == null) ? 0 : getHobbCd().hashCode());
        result = prime * result + ((getHobbOth() == null) ? 0 : getHobbOth().hashCode());
        result = prime * result + ((getContTimeCd() == null) ? 0 : getContTimeCd().hashCode());
        result = prime * result + ((getInvTermCd() == null) ? 0 : getInvTermCd().hashCode());
        result = prime * result + ((getFaithCd() == null) ? 0 : getFaithCd().hashCode());
        result = prime * result + ((getTaboo() == null) ? 0 : getTaboo().hashCode());
        result = prime * result + ((getSpecNeed() == null) ? 0 : getSpecNeed().hashCode());
        result = prime * result + ((getRemarks() == null) ? 0 : getRemarks().hashCode());
        result = prime * result + ((getFinBusiCd() == null) ? 0 : getFinBusiCd().hashCode());
        result = prime * result + ((getFinBusiOth() == null) ? 0 : getFinBusiOth().hashCode());
        result = prime * result + ((getArderCd() == null) ? 0 : getArderCd().hashCode());
        result = prime * result + ((getArderOth() == null) ? 0 : getArderOth().hashCode());
        result = prime * result + ((getMediaCd() == null) ? 0 : getMediaCd().hashCode());
        result = prime * result + ((getMediaOth() == null) ? 0 : getMediaOth().hashCode());
        result = prime * result + ((getSportCd() == null) ? 0 : getSportCd().hashCode());
        result = prime * result + ((getSportOth() == null) ? 0 : getSportOth().hashCode());
        result = prime * result + ((getMagazCd() == null) ? 0 : getMagazCd().hashCode());
        result = prime * result + ((getMagazOth() == null) ? 0 : getMagazOth().hashCode());
        result = prime * result + ((getTvshowCd() == null) ? 0 : getTvshowCd().hashCode());
        result = prime * result + ((getTvshowOth() == null) ? 0 : getTvshowOth().hashCode());
        result = prime * result + ((getPetCd() == null) ? 0 : getPetCd().hashCode());
        result = prime * result + ((getPetOth() == null) ? 0 : getPetOth().hashCode());
        result = prime * result + ((getCollCd() == null) ? 0 : getCollCd().hashCode());
        result = prime * result + ((getCollOth() == null) ? 0 : getCollOth().hashCode());
        result = prime * result + ((getConsCd() == null) ? 0 : getConsCd().hashCode());
        result = prime * result + ((getConsChnCd() == null) ? 0 : getConsChnCd().hashCode());
        result = prime * result + ((getConsBrandCd() == null) ? 0 : getConsBrandCd().hashCode());
        result = prime * result + ((getConsOth() == null) ? 0 : getConsOth().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash = ").append(hashCode());
		sb.append(", dataDate=").append(dataDate);
		sb.append(", lastChgSys=").append(lastChgSys);
		sb.append(", lastChgUsr=").append(lastChgUsr);
		sb.append(", lastChgDt=").append(lastChgDt);
		sb.append(", corpOrgCode=").append(corpOrgCode);
		sb.append(", custId=").append(custId);
		sb.append(", chnCd=").append(chnCd);
		sb.append(", chnOth=").append(chnOth);
		sb.append(", invCd=").append(invCd);
		sb.append(", invOth=").append(invOth);
		sb.append(", finAdviCd=").append(finAdviCd);
		sb.append(", finOth=").append(finOth);
		sb.append(", contCd=").append(contCd);
		sb.append(", contOth=").append(contOth);
		sb.append(", saloCd=").append(saloCd);
		sb.append(", saloOth=").append(saloOth);
		sb.append(", hobbCd=").append(hobbCd);
		sb.append(", hobbOth=").append(hobbOth);
		sb.append(", contTimeCd=").append(contTimeCd);
		sb.append(", invTermCd=").append(invTermCd);
		sb.append(", faithCd=").append(faithCd);
		sb.append(", taboo=").append(taboo);
		sb.append(", specNeed=").append(specNeed);
		sb.append(", remarks=").append(remarks);
		sb.append(", finBusiCd=").append(finBusiCd);
		sb.append(", finBusiOth=").append(finBusiOth);
		sb.append(", arderCd=").append(arderCd);
		sb.append(", arderOth=").append(arderOth);
		sb.append(", mediaCd=").append(mediaCd);
		sb.append(", mediaOth=").append(mediaOth);
		sb.append(", sportCd=").append(sportCd);
		sb.append(", sportOth=").append(sportOth);
		sb.append(", magazCd=").append(magazCd);
		sb.append(", magazOth=").append(magazOth);
		sb.append(", tvshowCd=").append(tvshowCd);
		sb.append(", tvshowOth=").append(tvshowOth);
		sb.append(", petCd=").append(petCd);
		sb.append(", petOth=").append(petOth);
		sb.append(", collCd=").append(collCd);
		sb.append(", collOth=").append(collOth);
		sb.append(", consCd=").append(consCd);
		sb.append(", consChnCd=").append(consChnCd);
		sb.append(", consBrandCd=").append(consBrandCd);
		sb.append(", consOth=").append(consOth);
        sb.append("]");
        return sb.toString();
    }
}