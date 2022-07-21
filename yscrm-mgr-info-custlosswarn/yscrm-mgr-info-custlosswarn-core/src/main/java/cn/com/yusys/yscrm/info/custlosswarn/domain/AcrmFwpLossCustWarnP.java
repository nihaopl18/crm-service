package cn.com.yusys.yscrm.info.custlosswarn.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;


/**
 * @项目名称: yscrm-mgr-info-custlosswarn-core模块
 * @类名称: AcrmFwpLossCustWarnP
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: lixt1
 * @创建时间: 2019-03-12 10:19:27
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "ACRM_F_WP_LOSS_CUST_WARN_P")
public class AcrmFwpLossCustWarnP extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** 主键ID **/
	@Id
	@Column(name = "LOSS_ID")
	@Generated(GenerationType.UUID)
	private String lossId;
	
	/** 评级日期 **/
	@Column(name = "LEVEL_DATE", unique = false, nullable = true, length = 8)
	private String levelDate;
	
	/** 客户号 **/
	@Column(name = "CUST_ID", unique = false, nullable = true, length = 30)
	private String custId;
	
	/** 客户名称 **/
	@Column(name = "CUST_NAME", unique = false, nullable = true, length = 60)
	private String custName;
	
	/** 流失预警等级 **/
	@Column(name = "LOSS_WARN_LEV", unique = false, nullable = true, length = 10)
	private String lossWarnLev;
	
	/** 是否发起挽留 **/
	@Column(name = "IF_DETENTION", unique = false, nullable = true, length = 10)
	private String ifDetention;
	
	/** 挽留结果 **/
	@Column(name = "DETENTION_RESULT", unique = false, nullable = true, length = 500)
	private String detentionResult;
	
	/** AUM月均余额-连续三月变化率 **/
	@Column(name = "AUM_M_BAL_SYB", unique = false, nullable = true, length = 10)
	private String aumMbalSyb;
	
	/** AUM月均余额-期末较期初 **/
	@Column(name = "AUM_M_BAL_MJC", unique = false, nullable = true, length = 10)
	private String aumMbalMjc;
	
	/** AUM月均余额-期末较同期 **/
	@Column(name = "AUM_M_BAL_MJT", unique = false, nullable = true, length = 10)
	private String aumMbalMjt;
	
	/** 法人 **/
	@Column(name = "CORP_ORG_CODE", unique = false, nullable = true, length = 20)
	private String corpOrgCode;
	
	
	/**
	 * @param lossId
	 */
	public void setLossId(String lossId) {
		this.lossId = lossId == null ? null : lossId.trim();
	}
	
    /**
     * @return LossId
     */	
	public String getLossId() {
		return this.lossId;
	}
	
	/**
	 * @param levelDate
	 */
	public void setLevelDate(String levelDate) {
		this.levelDate = levelDate;
	}
	
    /**
     * @return LevelDate
     */	
	public String getLevelDate() {
		return this.levelDate;
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
	 * @param custName
	 */
	public void setCustName(String custName) {
		this.custName = custName == null ? null : custName.trim();
	}
	
    /**
     * @return CustName
     */	
	public String getCustName() {
		return this.custName;
	}
	
	/**
	 * @param lossWarnLev
	 */
	public void setLossWarnLev(String lossWarnLev) {
		this.lossWarnLev = lossWarnLev == null ? null : lossWarnLev.trim();
	}
	
    /**
     * @return LossWarnLev
     */	
	public String getLossWarnLev() {
		return this.lossWarnLev;
	}
	
	/**
	 * @param ifDetention
	 */
	public void setIfDetention(String ifDetention) {
		this.ifDetention = ifDetention == null ? null : ifDetention.trim();
	}
	
    /**
     * @return IfDetention
     */	
	public String getIfDetention() {
		return this.ifDetention;
	}
	
	/**
	 * @param detentionResult
	 */
	public void setDetentionResult(String detentionResult) {
		this.detentionResult = detentionResult == null ? null : detentionResult.trim();
	}
	
    /**
     * @return DetentionResult
     */	
	public String getDetentionResult() {
		return this.detentionResult;
	}
	
	/**
	 * @param aumMbalSyb
	 */
	public void setAumMbalSyb(String aumMbalSyb) {
		this.aumMbalSyb = aumMbalSyb == null ? null : aumMbalSyb.trim();
	}
	
    /**
     * @return AumMbalSyb
     */	
	public String getAumMbalSyb() {
		return this.aumMbalSyb;
	}
	
	/**
	 * @param aumMbalMjc
	 */
	public void setAumMbalMjc(String aumMbalMjc) {
		this.aumMbalMjc = aumMbalMjc == null ? null : aumMbalMjc.trim();
	}
	
    /**
     * @return AumMbalMjc
     */	
	public String getAumMbalMjc() {
		return this.aumMbalMjc;
	}
	
	/**
	 * @param aumMbalMjt
	 */
	public void setAumMbalMjt(String aumMbalMjt) {
		this.aumMbalMjt = aumMbalMjt == null ? null : aumMbalMjt.trim();
	}
	
    /**
     * @return AumMbalMjt
     */	
	public String getAumMbalMjt() {
		return this.aumMbalMjt;
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
        AcrmFwpLossCustWarnP other = (AcrmFwpLossCustWarnP) that;
		return (this.getLossId() == null ? other.getLossId() == null : this.getLossId().equals(other.getLossId()))
                	&& (this.getCustId() == null ? other.getCustId() == null : this.getCustId().equals(other.getCustId()))
        	&& (this.getCustName() == null ? other.getCustName() == null : this.getCustName().equals(other.getCustName()))
        	&& (this.getLossWarnLev() == null ? other.getLossWarnLev() == null : this.getLossWarnLev().equals(other.getLossWarnLev()))
        	&& (this.getIfDetention() == null ? other.getIfDetention() == null : this.getIfDetention().equals(other.getIfDetention()))
        	&& (this.getDetentionResult() == null ? other.getDetentionResult() == null : this.getDetentionResult().equals(other.getDetentionResult()))
        	&& (this.getAumMbalSyb() == null ? other.getAumMbalSyb() == null : this.getAumMbalSyb().equals(other.getAumMbalSyb()))
        	&& (this.getAumMbalMjc() == null ? other.getAumMbalMjc() == null : this.getAumMbalMjc().equals(other.getAumMbalMjc()))
        	&& (this.getAumMbalMjt() == null ? other.getAumMbalMjt() == null : this.getAumMbalMjt().equals(other.getAumMbalMjt()))
        	&& (this.getCorpOrgCode() == null ? other.getCorpOrgCode() == null : this.getCorpOrgCode().equals(other.getCorpOrgCode()))
        ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getLossId() == null) ? 0 : getLossId().hashCode());
        result = prime * result + ((getCustId() == null) ? 0 : getCustId().hashCode());
        result = prime * result + ((getCustName() == null) ? 0 : getCustName().hashCode());
        result = prime * result + ((getLossWarnLev() == null) ? 0 : getLossWarnLev().hashCode());
        result = prime * result + ((getIfDetention() == null) ? 0 : getIfDetention().hashCode());
        result = prime * result + ((getDetentionResult() == null) ? 0 : getDetentionResult().hashCode());
        result = prime * result + ((getAumMbalSyb() == null) ? 0 : getAumMbalSyb().hashCode());
        result = prime * result + ((getAumMbalMjc() == null) ? 0 : getAumMbalMjc().hashCode());
        result = prime * result + ((getAumMbalMjt() == null) ? 0 : getAumMbalMjt().hashCode());
        result = prime * result + ((getCorpOrgCode() == null) ? 0 : getCorpOrgCode().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash = ").append(hashCode());
		sb.append(", lossId=").append(lossId);
		sb.append(", levelDate=").append(levelDate);
		sb.append(", custId=").append(custId);
		sb.append(", custName=").append(custName);
		sb.append(", lossWarnLev=").append(lossWarnLev);
		sb.append(", ifDetention=").append(ifDetention);
		sb.append(", detentionResult=").append(detentionResult);
		sb.append(", aumMbalSyb=").append(aumMbalSyb);
		sb.append(", aumMbalMjc=").append(aumMbalMjc);
		sb.append(", aumMbalMjt=").append(aumMbalMjt);
		sb.append(", corpOrgCode=").append(corpOrgCode);
        sb.append("]");
        return sb.toString();
    }
}