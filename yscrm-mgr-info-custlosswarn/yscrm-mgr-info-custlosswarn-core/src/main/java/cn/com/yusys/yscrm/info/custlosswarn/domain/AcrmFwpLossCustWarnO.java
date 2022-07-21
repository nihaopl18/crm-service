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
 * @类名称: AcrmFwpLossCustWarnO
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: lixt1
 * @创建时间: 2019-03-12 10:19:05
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "ACRM_F_WP_LOSS_CUST_WARN_O")
public class AcrmFwpLossCustWarnO extends BaseDomain implements Serializable{
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
	
	/** 存款月均余额-连续三月变化率 **/
	@Column(name = "DEP_M_BAL_SYB", unique = false, nullable = true, length = 10)
	private String depMbalSyb;
	
	/** 存款月均余额-期末较期初 **/
	@Column(name = "DEP_M_BAL_MJC", unique = false, nullable = true, length = 10)
	private String depMbalMjc;
	
	/** 存款月均余额-期末较同期 **/
	@Column(name = "DEP_M_BAL_MJT", unique = false, nullable = true, length = 10)
	private String depMbalMjt;
	
	/** 贷款月均余额-连续三月变化率 **/
	@Column(name = "LOA_M_BAL_SYB", unique = false, nullable = true, length = 10)
	private String loaMbalSyb;
	
	/** 贷款月均余额-期末较期初 **/
	@Column(name = "LOA_M_BAL_MJC", unique = false, nullable = true, length = 10)
	private String loaMbalMjc;
	
	/** 贷款月均余额-期末较同期 **/
	@Column(name = "LOA_M_BAL_MJT", unique = false, nullable = true, length = 10)
	private String loaMbalMjt;
	
	/** 持有产品数-连续三月变化率 **/
	@Column(name = "HOL_PRO_SYB", unique = false, nullable = true, length = 10)
	private String holProSyb;
	
	/** 持有产品数-期末较期初 **/
	@Column(name = "HOL_PRO_MJC", unique = false, nullable = true, length = 10)
	private String holProMjc;
	
	/** 持有产品数-期末较同期 **/
	@Column(name = "HOL_PRO_MJT", unique = false, nullable = true, length = 10)
	private String holProMjt;
	
	/** 月结算量-连续三月变化率 **/
	@Column(name = "MON_STA_SYB", unique = false, nullable = true, length = 10)
	private String monStaSyb;
	
	/** 月结算量-期末较期初 **/
	@Column(name = "MON_STA_MJC", unique = false, nullable = true, length = 10)
	private String monStaMjc;
	
	/** 月结算量-期末较同期 **/
	@Column(name = "MON_STA_MJT", unique = false, nullable = true, length = 10)
	private String monStaMjt;
	
	/** 存贷比-连续三月变化率 **/
	@Column(name = "LOA_TO_DEP_SYB", unique = false, nullable = true, length = 10)
	private String loaToDepSyb;
	
	/** 存贷比-期末较期初 **/
	@Column(name = "LOA_TO_DEP_MJC", unique = false, nullable = true, length = 10)
	private String loaToDepMjc;
	
	/** 存贷比-期末较同期 **/
	@Column(name = "LOA_TO_DEP_MJT", unique = false, nullable = true, length = 10)
	private String loaToDepMjt;
	
	/** 交易额（统计口径：跨行同名账户转出交易额）-连续三月变化率 **/
	@Column(name = "DEA_SUM_SYB", unique = false, nullable = true, length = 10)
	private String deaSumSyb;
	
	/** 交易额（统计口径：跨行同名账户转出交易额）-期末较期初 **/
	@Column(name = "DEA_SUM_MJC", unique = false, nullable = true, length = 10)
	private String deaSumMjc;
	
	/** 交易额（统计口径：跨行同名账户转出交易额）-期末较同期 **/
	@Column(name = "DEA_SUM_MJT", unique = false, nullable = true, length = 10)
	private String deaSumMjt;
	
	/** 国际业务交易额-连续三月变化率 **/
	@Column(name = "INT_BUS_SUM_SYB", unique = false, nullable = true, length = 10)
	private String intBusSumSyb;
	
	/** 国际业务交易额-期末较期初 **/
	@Column(name = "INT_BUS_SUM_MJC", unique = false, nullable = true, length = 10)
	private String intBusSumMjc;
	
	/** 国际业务交易额-期末较同期 **/
	@Column(name = "INT_BUS_SUM_MJT", unique = false, nullable = true, length = 10)
	private String intBusSumMjt;
	
	/** 国际业务交易量-连续三月变化率 **/
	@Column(name = "INT_BUS_NUM_SYB", unique = false, nullable = true, length = 10)
	private String intBusNumSyb;
	
	/** 国际业务交易量-期末较期初 **/
	@Column(name = "INT_BUS_NUM_MJC", unique = false, nullable = true, length = 10)
	private String intBusNumMjc;
	
	/** 国际业务交易量-期末较同期 **/
	@Column(name = "INT_BUS_NUM_MJT", unique = false, nullable = true, length = 10)
	private String intBusNumMjt;
	
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
	 * @param depMbalSyb
	 */
	public void setDepMbalSyb(String depMbalSyb) {
		this.depMbalSyb = depMbalSyb == null ? null : depMbalSyb.trim();
	}
	
    /**
     * @return DepMbalSyb
     */	
	public String getDepMbalSyb() {
		return this.depMbalSyb;
	}
	
	/**
	 * @param depMbalMjc
	 */
	public void setDepMbalMjc(String depMbalMjc) {
		this.depMbalMjc = depMbalMjc == null ? null : depMbalMjc.trim();
	}
	
    /**
     * @return DepMbalMjc
     */	
	public String getDepMbalMjc() {
		return this.depMbalMjc;
	}
	
	/**
	 * @param depMbalMjt
	 */
	public void setDepMbalMjt(String depMbalMjt) {
		this.depMbalMjt = depMbalMjt == null ? null : depMbalMjt.trim();
	}
	
    /**
     * @return DepMbalMjt
     */	
	public String getDepMbalMjt() {
		return this.depMbalMjt;
	}
	
	/**
	 * @param loaMbalSyb
	 */
	public void setLoaMbalSyb(String loaMbalSyb) {
		this.loaMbalSyb = loaMbalSyb == null ? null : loaMbalSyb.trim();
	}
	
    /**
     * @return LoaMbalSyb
     */	
	public String getLoaMbalSyb() {
		return this.loaMbalSyb;
	}
	
	/**
	 * @param loaMbalMjc
	 */
	public void setLoaMbalMjc(String loaMbalMjc) {
		this.loaMbalMjc = loaMbalMjc == null ? null : loaMbalMjc.trim();
	}
	
    /**
     * @return LoaMbalMjc
     */	
	public String getLoaMbalMjc() {
		return this.loaMbalMjc;
	}
	
	/**
	 * @param loaMbalMjt
	 */
	public void setLoaMbalMjt(String loaMbalMjt) {
		this.loaMbalMjt = loaMbalMjt == null ? null : loaMbalMjt.trim();
	}
	
    /**
     * @return LoaMbalMjt
     */	
	public String getLoaMbalMjt() {
		return this.loaMbalMjt;
	}
	
	/**
	 * @param holProSyb
	 */
	public void setHolProSyb(String holProSyb) {
		this.holProSyb = holProSyb == null ? null : holProSyb.trim();
	}
	
    /**
     * @return HolProSyb
     */	
	public String getHolProSyb() {
		return this.holProSyb;
	}
	
	/**
	 * @param holProMjc
	 */
	public void setHolProMjc(String holProMjc) {
		this.holProMjc = holProMjc == null ? null : holProMjc.trim();
	}
	
    /**
     * @return HolProMjc
     */	
	public String getHolProMjc() {
		return this.holProMjc;
	}
	
	/**
	 * @param holProMjt
	 */
	public void setHolProMjt(String holProMjt) {
		this.holProMjt = holProMjt == null ? null : holProMjt.trim();
	}
	
    /**
     * @return HolProMjt
     */	
	public String getHolProMjt() {
		return this.holProMjt;
	}
	
	/**
	 * @param monStaSyb
	 */
	public void setMonStaSyb(String monStaSyb) {
		this.monStaSyb = monStaSyb == null ? null : monStaSyb.trim();
	}
	
    /**
     * @return MonStaSyb
     */	
	public String getMonStaSyb() {
		return this.monStaSyb;
	}
	
	/**
	 * @param monStaMjc
	 */
	public void setMonStaMjc(String monStaMjc) {
		this.monStaMjc = monStaMjc == null ? null : monStaMjc.trim();
	}
	
    /**
     * @return MonStaMjc
     */	
	public String getMonStaMjc() {
		return this.monStaMjc;
	}
	
	/**
	 * @param monStaMjt
	 */
	public void setMonStaMjt(String monStaMjt) {
		this.monStaMjt = monStaMjt == null ? null : monStaMjt.trim();
	}
	
    /**
     * @return MonStaMjt
     */	
	public String getMonStaMjt() {
		return this.monStaMjt;
	}
	
	/**
	 * @param loaToDepSyb
	 */
	public void setLoaToDepSyb(String loaToDepSyb) {
		this.loaToDepSyb = loaToDepSyb == null ? null : loaToDepSyb.trim();
	}
	
    /**
     * @return LoaToDepSyb
     */	
	public String getLoaToDepSyb() {
		return this.loaToDepSyb;
	}
	
	/**
	 * @param loaToDepMjc
	 */
	public void setLoaToDepMjc(String loaToDepMjc) {
		this.loaToDepMjc = loaToDepMjc == null ? null : loaToDepMjc.trim();
	}
	
    /**
     * @return LoaToDepMjc
     */	
	public String getLoaToDepMjc() {
		return this.loaToDepMjc;
	}
	
	/**
	 * @param loaToDepMjt
	 */
	public void setLoaToDepMjt(String loaToDepMjt) {
		this.loaToDepMjt = loaToDepMjt == null ? null : loaToDepMjt.trim();
	}
	
    /**
     * @return LoaToDepMjt
     */	
	public String getLoaToDepMjt() {
		return this.loaToDepMjt;
	}
	
	/**
	 * @param deaSumSyb
	 */
	public void setDeaSumSyb(String deaSumSyb) {
		this.deaSumSyb = deaSumSyb == null ? null : deaSumSyb.trim();
	}
	
    /**
     * @return DeaSumSyb
     */	
	public String getDeaSumSyb() {
		return this.deaSumSyb;
	}
	
	/**
	 * @param deaSumMjc
	 */
	public void setDeaSumMjc(String deaSumMjc) {
		this.deaSumMjc = deaSumMjc == null ? null : deaSumMjc.trim();
	}
	
    /**
     * @return DeaSumMjc
     */	
	public String getDeaSumMjc() {
		return this.deaSumMjc;
	}
	
	/**
	 * @param deaSumMjt
	 */
	public void setDeaSumMjt(String deaSumMjt) {
		this.deaSumMjt = deaSumMjt == null ? null : deaSumMjt.trim();
	}
	
    /**
     * @return DeaSumMjt
     */	
	public String getDeaSumMjt() {
		return this.deaSumMjt;
	}
	
	/**
	 * @param intBusSumSyb
	 */
	public void setIntBusSumSyb(String intBusSumSyb) {
		this.intBusSumSyb = intBusSumSyb == null ? null : intBusSumSyb.trim();
	}
	
    /**
     * @return IntBusSumSyb
     */	
	public String getIntBusSumSyb() {
		return this.intBusSumSyb;
	}
	
	/**
	 * @param intBusSumMjc
	 */
	public void setIntBusSumMjc(String intBusSumMjc) {
		this.intBusSumMjc = intBusSumMjc == null ? null : intBusSumMjc.trim();
	}
	
    /**
     * @return IntBusSumMjc
     */	
	public String getIntBusSumMjc() {
		return this.intBusSumMjc;
	}
	
	/**
	 * @param intBusSumMjt
	 */
	public void setIntBusSumMjt(String intBusSumMjt) {
		this.intBusSumMjt = intBusSumMjt == null ? null : intBusSumMjt.trim();
	}
	
    /**
     * @return IntBusSumMjt
     */	
	public String getIntBusSumMjt() {
		return this.intBusSumMjt;
	}
	
	/**
	 * @param intBusNumSyb
	 */
	public void setIntBusNumSyb(String intBusNumSyb) {
		this.intBusNumSyb = intBusNumSyb == null ? null : intBusNumSyb.trim();
	}
	
    /**
     * @return IntBusNumSyb
     */	
	public String getIntBusNumSyb() {
		return this.intBusNumSyb;
	}
	
	/**
	 * @param intBusNumMjc
	 */
	public void setIntBusNumMjc(String intBusNumMjc) {
		this.intBusNumMjc = intBusNumMjc == null ? null : intBusNumMjc.trim();
	}
	
    /**
     * @return IntBusNumMjc
     */	
	public String getIntBusNumMjc() {
		return this.intBusNumMjc;
	}
	
	/**
	 * @param intBusNumMjt
	 */
	public void setIntBusNumMjt(String intBusNumMjt) {
		this.intBusNumMjt = intBusNumMjt == null ? null : intBusNumMjt.trim();
	}
	
    /**
     * @return IntBusNumMjt
     */	
	public String getIntBusNumMjt() {
		return this.intBusNumMjt;
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
        AcrmFwpLossCustWarnO other = (AcrmFwpLossCustWarnO) that;
		return (this.getLossId() == null ? other.getLossId() == null : this.getLossId().equals(other.getLossId()))
                	&& (this.getCustId() == null ? other.getCustId() == null : this.getCustId().equals(other.getCustId()))
        	&& (this.getCustName() == null ? other.getCustName() == null : this.getCustName().equals(other.getCustName()))
        	&& (this.getLossWarnLev() == null ? other.getLossWarnLev() == null : this.getLossWarnLev().equals(other.getLossWarnLev()))
        	&& (this.getIfDetention() == null ? other.getIfDetention() == null : this.getIfDetention().equals(other.getIfDetention()))
        	&& (this.getDetentionResult() == null ? other.getDetentionResult() == null : this.getDetentionResult().equals(other.getDetentionResult()))
        	&& (this.getDepMbalSyb() == null ? other.getDepMbalSyb() == null : this.getDepMbalSyb().equals(other.getDepMbalSyb()))
        	&& (this.getDepMbalMjc() == null ? other.getDepMbalMjc() == null : this.getDepMbalMjc().equals(other.getDepMbalMjc()))
        	&& (this.getDepMbalMjt() == null ? other.getDepMbalMjt() == null : this.getDepMbalMjt().equals(other.getDepMbalMjt()))
        	&& (this.getLoaMbalSyb() == null ? other.getLoaMbalSyb() == null : this.getLoaMbalSyb().equals(other.getLoaMbalSyb()))
        	&& (this.getLoaMbalMjc() == null ? other.getLoaMbalMjc() == null : this.getLoaMbalMjc().equals(other.getLoaMbalMjc()))
        	&& (this.getLoaMbalMjt() == null ? other.getLoaMbalMjt() == null : this.getLoaMbalMjt().equals(other.getLoaMbalMjt()))
        	&& (this.getHolProSyb() == null ? other.getHolProSyb() == null : this.getHolProSyb().equals(other.getHolProSyb()))
        	&& (this.getHolProMjc() == null ? other.getHolProMjc() == null : this.getHolProMjc().equals(other.getHolProMjc()))
        	&& (this.getHolProMjt() == null ? other.getHolProMjt() == null : this.getHolProMjt().equals(other.getHolProMjt()))
        	&& (this.getMonStaSyb() == null ? other.getMonStaSyb() == null : this.getMonStaSyb().equals(other.getMonStaSyb()))
        	&& (this.getMonStaMjc() == null ? other.getMonStaMjc() == null : this.getMonStaMjc().equals(other.getMonStaMjc()))
        	&& (this.getMonStaMjt() == null ? other.getMonStaMjt() == null : this.getMonStaMjt().equals(other.getMonStaMjt()))
        	&& (this.getLoaToDepSyb() == null ? other.getLoaToDepSyb() == null : this.getLoaToDepSyb().equals(other.getLoaToDepSyb()))
        	&& (this.getLoaToDepMjc() == null ? other.getLoaToDepMjc() == null : this.getLoaToDepMjc().equals(other.getLoaToDepMjc()))
        	&& (this.getLoaToDepMjt() == null ? other.getLoaToDepMjt() == null : this.getLoaToDepMjt().equals(other.getLoaToDepMjt()))
        	&& (this.getDeaSumSyb() == null ? other.getDeaSumSyb() == null : this.getDeaSumSyb().equals(other.getDeaSumSyb()))
        	&& (this.getDeaSumMjc() == null ? other.getDeaSumMjc() == null : this.getDeaSumMjc().equals(other.getDeaSumMjc()))
        	&& (this.getDeaSumMjt() == null ? other.getDeaSumMjt() == null : this.getDeaSumMjt().equals(other.getDeaSumMjt()))
        	&& (this.getIntBusSumSyb() == null ? other.getIntBusSumSyb() == null : this.getIntBusSumSyb().equals(other.getIntBusSumSyb()))
        	&& (this.getIntBusSumMjc() == null ? other.getIntBusSumMjc() == null : this.getIntBusSumMjc().equals(other.getIntBusSumMjc()))
        	&& (this.getIntBusSumMjt() == null ? other.getIntBusSumMjt() == null : this.getIntBusSumMjt().equals(other.getIntBusSumMjt()))
        	&& (this.getIntBusNumSyb() == null ? other.getIntBusNumSyb() == null : this.getIntBusNumSyb().equals(other.getIntBusNumSyb()))
        	&& (this.getIntBusNumMjc() == null ? other.getIntBusNumMjc() == null : this.getIntBusNumMjc().equals(other.getIntBusNumMjc()))
        	&& (this.getIntBusNumMjt() == null ? other.getIntBusNumMjt() == null : this.getIntBusNumMjt().equals(other.getIntBusNumMjt()))
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
        result = prime * result + ((getDepMbalSyb() == null) ? 0 : getDepMbalSyb().hashCode());
        result = prime * result + ((getDepMbalMjc() == null) ? 0 : getDepMbalMjc().hashCode());
        result = prime * result + ((getDepMbalMjt() == null) ? 0 : getDepMbalMjt().hashCode());
        result = prime * result + ((getLoaMbalSyb() == null) ? 0 : getLoaMbalSyb().hashCode());
        result = prime * result + ((getLoaMbalMjc() == null) ? 0 : getLoaMbalMjc().hashCode());
        result = prime * result + ((getLoaMbalMjt() == null) ? 0 : getLoaMbalMjt().hashCode());
        result = prime * result + ((getHolProSyb() == null) ? 0 : getHolProSyb().hashCode());
        result = prime * result + ((getHolProMjc() == null) ? 0 : getHolProMjc().hashCode());
        result = prime * result + ((getHolProMjt() == null) ? 0 : getHolProMjt().hashCode());
        result = prime * result + ((getMonStaSyb() == null) ? 0 : getMonStaSyb().hashCode());
        result = prime * result + ((getMonStaMjc() == null) ? 0 : getMonStaMjc().hashCode());
        result = prime * result + ((getMonStaMjt() == null) ? 0 : getMonStaMjt().hashCode());
        result = prime * result + ((getLoaToDepSyb() == null) ? 0 : getLoaToDepSyb().hashCode());
        result = prime * result + ((getLoaToDepMjc() == null) ? 0 : getLoaToDepMjc().hashCode());
        result = prime * result + ((getLoaToDepMjt() == null) ? 0 : getLoaToDepMjt().hashCode());
        result = prime * result + ((getDeaSumSyb() == null) ? 0 : getDeaSumSyb().hashCode());
        result = prime * result + ((getDeaSumMjc() == null) ? 0 : getDeaSumMjc().hashCode());
        result = prime * result + ((getDeaSumMjt() == null) ? 0 : getDeaSumMjt().hashCode());
        result = prime * result + ((getIntBusSumSyb() == null) ? 0 : getIntBusSumSyb().hashCode());
        result = prime * result + ((getIntBusSumMjc() == null) ? 0 : getIntBusSumMjc().hashCode());
        result = prime * result + ((getIntBusSumMjt() == null) ? 0 : getIntBusSumMjt().hashCode());
        result = prime * result + ((getIntBusNumSyb() == null) ? 0 : getIntBusNumSyb().hashCode());
        result = prime * result + ((getIntBusNumMjc() == null) ? 0 : getIntBusNumMjc().hashCode());
        result = prime * result + ((getIntBusNumMjt() == null) ? 0 : getIntBusNumMjt().hashCode());
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
		sb.append(", depMbalSyb=").append(depMbalSyb);
		sb.append(", depMbalMjc=").append(depMbalMjc);
		sb.append(", depMbalMjt=").append(depMbalMjt);
		sb.append(", loaMbalSyb=").append(loaMbalSyb);
		sb.append(", loaMbalMjc=").append(loaMbalMjc);
		sb.append(", loaMbalMjt=").append(loaMbalMjt);
		sb.append(", holProSyb=").append(holProSyb);
		sb.append(", holProMjc=").append(holProMjc);
		sb.append(", holProMjt=").append(holProMjt);
		sb.append(", monStaSyb=").append(monStaSyb);
		sb.append(", monStaMjc=").append(monStaMjc);
		sb.append(", monStaMjt=").append(monStaMjt);
		sb.append(", loaToDepSyb=").append(loaToDepSyb);
		sb.append(", loaToDepMjc=").append(loaToDepMjc);
		sb.append(", loaToDepMjt=").append(loaToDepMjt);
		sb.append(", deaSumSyb=").append(deaSumSyb);
		sb.append(", deaSumMjc=").append(deaSumMjc);
		sb.append(", deaSumMjt=").append(deaSumMjt);
		sb.append(", intBusSumSyb=").append(intBusSumSyb);
		sb.append(", intBusSumMjc=").append(intBusSumMjc);
		sb.append(", intBusSumMjt=").append(intBusSumMjt);
		sb.append(", intBusNumSyb=").append(intBusNumSyb);
		sb.append(", intBusNumMjc=").append(intBusNumMjc);
		sb.append(", intBusNumMjt=").append(intBusNumMjt);
		sb.append(", corpOrgCode=").append(corpOrgCode);
        sb.append("]");
        return sb.toString();
    }
}