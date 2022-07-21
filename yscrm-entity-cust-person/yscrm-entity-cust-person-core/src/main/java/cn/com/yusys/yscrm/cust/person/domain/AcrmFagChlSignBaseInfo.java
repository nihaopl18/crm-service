package cn.com.yusys.yscrm.cust.person.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;


/**
 * @项目名称: demo-app-single-starter模块
 * @类名称: AcrmFagChlSignBaseInfo
 * @类描述: #数据实体类
 * @功能描述: 签约信息
 * @创建人: 15104
 * @创建时间: 2019-02-12 14:49:25
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "ACRM_F_AG_CHL_SIGN_BASE_INFO")
public class AcrmFagChlSignBaseInfo extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** 客户编号
 **/
	@Id
	@Column(name = "CUST_ID")
	@Generated(GenerationType.UUID)
	private String custId;
	
	/** 法人
 **/
	@Column(name = "CORP_ORG_CODE", unique = false, nullable = true, length = 10)
	private String corpOrgCode;
	
	/** 数据日期
 **/
	@Transient
	@Column(name = "DATA_DATE", unique = false, nullable = true, length = 8)
	private String dataDate;
	
	/** 协议编号
 **/
	@Column(name = "CONTR_NO", unique = false, nullable = true, length = 350)
	private String contrNo;
	
	/** 签约机构
 **/
	@Column(name = "SIGN_BRANCH_NO", unique = false, nullable = true, length = 20)
	private String signBranchNo;
	
	/** 签约柜员
 **/
	@Column(name = "SIGN_TELLER_NO", unique = false, nullable = true, length = 20)
	private String signTellerNo;
	
	/** 签约账号
 **/
	@Column(name = "SIGN_ACCT_NO", unique = false, nullable = true, length = 32)
	private String signAcctNo;
	
	/** 签约卡号
 **/
	@Column(name = "SIGN_CARD_NO", unique = false, nullable = true, length = 32)
	private String signCardNo;
	
	/** 签约类型/产品
 **/
	@Column(name = "SIGN_TYPE", unique = false, nullable = true, length = 20)
	private String signType;
	
	/** 签约渠道
 **/
	@Column(name = "SIGN_KIND", unique = false, nullable = true, length = 20)
	private String signKind;
	
	/** 签约渠道描述
 **/
	@Column(name = "SIGN_KIND_DESC", unique = false, nullable = true, length = 50)
	private String signKindDesc;
	
	/** 签约描述
 **/
	@Column(name = "SIGN_DESC", unique = false, nullable = true, length = 255)
	private String signDesc;
	
	/** 签约状态
 **/
	@Column(name = "SIGN_STAT", unique = false, nullable = true, length = 20)
	private String signStat;
	
	/** 签约状态描述
 **/
	@Column(name = "SIGN_STAT_DESC", unique = false, nullable = true, length = 50)
	private String signStatDesc;
	
	/** 签约日期
 **/
	@Transient
	@Column(name = "SIGN_DT", unique = false, nullable = true, length = 7)
	private Date signDt;
	
	/** 解约日期
 **/
	@Transient
	@Column(name = "SIGNOFF_DT", unique = false, nullable = true, length = 7)
	private Date signoffDt;
	
	/** 生效日期
 **/
	@Transient
	@Column(name = "EFFECTIVE_DT", unique = false, nullable = true, length = 7)
	private Date effectiveDt;
	
	/** 失效日期
 **/
	@Transient
	@Column(name = "EXPIRED_DT", unique = false, nullable = true, length = 7)
	private Date expiredDt;
	
	/** 签约网银账号
 **/
	@Column(name = "SIGN_EBANK_ACCT", unique = false, nullable = true, length = 32)
	private String signEbankAcct;
	
	/** 最后更新渠道
 **/
	@Column(name = "LAST_UPDATE_SYS", unique = false, nullable = true, length = 20)
	private String lastUpdateSys;
	
	/** 最后更新人
 **/
	@Column(name = "LAST_UPDATE_USER", unique = false, nullable = true, length = 20)
	private String lastUpdateUser;
	
	/** 最后更新时间
 **/
	@Column(name = "LAST_UPDATE_TM", unique = false, nullable = true, length = 50)
	private String lastUpdateTm;
	
	/** 交易流水号
 **/
	@Column(name = "TX_SEQ_NO", unique = false, nullable = true, length = 32)
	private String txSeqNo;
	
	/** 用户识别码1
 **/
	@Column(name = "ID1", unique = false, nullable = true, length = 50)
	private String id1;
	
	/** 用户识别码2
 **/
	@Column(name = "ID2", unique = false, nullable = true, length = 50)
	private String id2;
	
	/** 用户识别码3
 **/
	@Column(name = "ID3", unique = false, nullable = true, length = 50)
	private String id3;
	
	/** 用户识别码4
 **/
	@Column(name = "ID4", unique = false, nullable = true, length = 50)
	private String id4;
	
	/** 用户识别码5
 **/
	@Column(name = "ID5", unique = false, nullable = true, length = 50)
	private String id5;
	
	
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
	 * @param dataDate
	 */
	public void setDataDate(String dataDate) {
		this.dataDate = dataDate;
	}
	
    /**
     * @return DataDate
     */	
	public String getDataDate() {
		return this.dataDate;
	}
	
	/**
	 * @param contrNo
	 */
	public void setContrNo(String contrNo) {
		this.contrNo = contrNo == null ? null : contrNo.trim();
	}
	
    /**
     * @return ContrNo
     */	
	public String getContrNo() {
		return this.contrNo;
	}
	
	/**
	 * @param custId
	 */
	public void setCustId(String custId) {
		this.custId = custId == null ? null : custId.trim();
	}
	
    /**
     * @return custId
     */	
	public String getCustId() {
		return this.custId;
	}
	
	/**
	 * @param signBranchNo
	 */
	public void setSignBranchNo(String signBranchNo) {
		this.signBranchNo = signBranchNo == null ? null : signBranchNo.trim();
	}
	
    /**
     * @return SignBranchNo
     */	
	public String getSignBranchNo() {
		return this.signBranchNo;
	}
	
	/**
	 * @param signTellerNo
	 */
	public void setSignTellerNo(String signTellerNo) {
		this.signTellerNo = signTellerNo == null ? null : signTellerNo.trim();
	}
	
    /**
     * @return SignTellerNo
     */	
	public String getSignTellerNo() {
		return this.signTellerNo;
	}
	
	/**
	 * @param signAcctNo
	 */
	public void setSignAcctNo(String signAcctNo) {
		this.signAcctNo = signAcctNo == null ? null : signAcctNo.trim();
	}
	
    /**
     * @return SignAcctNo
     */	
	public String getSignAcctNo() {
		return this.signAcctNo;
	}
	
	/**
	 * @param signCardNo
	 */
	public void setSignCardNo(String signCardNo) {
		this.signCardNo = signCardNo == null ? null : signCardNo.trim();
	}
	
    /**
     * @return SignCardNo
     */	
	public String getSignCardNo() {
		return this.signCardNo;
	}
	
	/**
	 * @param signType
	 */
	public void setSignType(String signType) {
		this.signType = signType == null ? null : signType.trim();
	}
	
    /**
     * @return SignType
     */	
	public String getSignType() {
		return this.signType;
	}
	
	/**
	 * @param signKind
	 */
	public void setSignKind(String signKind) {
		this.signKind = signKind == null ? null : signKind.trim();
	}
	
    /**
     * @return SignKind
     */	
	public String getSignKind() {
		return this.signKind;
	}
	
	/**
	 * @param signKindDesc
	 */
	public void setSignKindDesc(String signKindDesc) {
		this.signKindDesc = signKindDesc == null ? null : signKindDesc.trim();
	}
	
    /**
     * @return SignKindDesc
     */	
	public String getSignKindDesc() {
		return this.signKindDesc;
	}
	
	/**
	 * @param signDesc
	 */
	public void setSignDesc(String signDesc) {
		this.signDesc = signDesc == null ? null : signDesc.trim();
	}
	
    /**
     * @return SignDesc
     */	
	public String getSignDesc() {
		return this.signDesc;
	}
	
	/**
	 * @param signStat
	 */
	public void setSignStat(String signStat) {
		this.signStat = signStat == null ? null : signStat.trim();
	}
	
    /**
     * @return SignStat
     */	
	public String getSignStat() {
		return this.signStat;
	}
	
	/**
	 * @param signStatDesc
	 */
	public void setSignStatDesc(String signStatDesc) {
		this.signStatDesc = signStatDesc == null ? null : signStatDesc.trim();
	}
	
    /**
     * @return SignStatDesc
     */	
	public String getSignStatDesc() {
		return this.signStatDesc;
	}
	
	/**
	 * @param signDt
	 */
	public void setSignDt(Date signDt) {
		this.signDt = signDt;
	}
	
    /**
     * @return SignDt
     */	
	public Date getSignDt() {
		return this.signDt;
	}
	
	/**
	 * @param signoffDt
	 */
	public void setSignoffDt(Date signoffDt) {
		this.signoffDt = signoffDt;
	}
	
    /**
     * @return SignoffDt
     */	
	public Date getSignoffDt() {
		return this.signoffDt;
	}
	
	/**
	 * @param effectiveDt
	 */
	public void setEffectiveDt(Date effectiveDt) {
		this.effectiveDt = effectiveDt;
	}
	
    /**
     * @return EffectiveDt
     */	
	public Date getEffectiveDt() {
		return this.effectiveDt;
	}
	
	/**
	 * @param expiredDt
	 */
	public void setExpiredDt(Date expiredDt) {
		this.expiredDt = expiredDt;
	}
	
    /**
     * @return ExpiredDt
     */	
	public Date getExpiredDt() {
		return this.expiredDt;
	}
	
	/**
	 * @param signEbankAcct
	 */
	public void setSignEbankAcct(String signEbankAcct) {
		this.signEbankAcct = signEbankAcct == null ? null : signEbankAcct.trim();
	}
	
    /**
     * @return SignEbankAcct
     */	
	public String getSignEbankAcct() {
		return this.signEbankAcct;
	}
	
	/**
	 * @param lastUpdateSys
	 */
	public void setLastUpdateSys(String lastUpdateSys) {
		this.lastUpdateSys = lastUpdateSys == null ? null : lastUpdateSys.trim();
	}
	
    /**
     * @return LastUpdateSys
     */	
	public String getLastUpdateSys() {
		return this.lastUpdateSys;
	}
	
	/**
	 * @param lastUpdateUser
	 */
	public void setLastUpdateUser(String lastUpdateUser) {
		this.lastUpdateUser = lastUpdateUser == null ? null : lastUpdateUser.trim();
	}
	
    /**
     * @return LastUpdateUser
     */	
	public String getLastUpdateUser() {
		return this.lastUpdateUser;
	}
	
	/**
	 * @param lastUpdateTm
	 */
	public void setLastUpdateTm(String lastUpdateTm) {
		this.lastUpdateTm = lastUpdateTm == null ? null : lastUpdateTm.trim();
	}
	
    /**
     * @return LastUpdateTm
     */	
	public String getLastUpdateTm() {
		return this.lastUpdateTm;
	}
	
	/**
	 * @param txSeqNo
	 */
	public void setTxSeqNo(String txSeqNo) {
		this.txSeqNo = txSeqNo == null ? null : txSeqNo.trim();
	}
	
    /**
     * @return TxSeqNo
     */	
	public String getTxSeqNo() {
		return this.txSeqNo;
	}
	
	/**
	 * @param id1
	 */
	public void setId1(String id1) {
		this.id1 = id1 == null ? null : id1.trim();
	}
	
    /**
     * @return Id1
     */	
	public String getId1() {
		return this.id1;
	}
	
	/**
	 * @param id2
	 */
	public void setId2(String id2) {
		this.id2 = id2 == null ? null : id2.trim();
	}
	
    /**
     * @return Id2
     */	
	public String getId2() {
		return this.id2;
	}
	
	/**
	 * @param id3
	 */
	public void setId3(String id3) {
		this.id3 = id3 == null ? null : id3.trim();
	}
	
    /**
     * @return Id3
     */	
	public String getId3() {
		return this.id3;
	}
	
	/**
	 * @param id4
	 */
	public void setId4(String id4) {
		this.id4 = id4 == null ? null : id4.trim();
	}
	
    /**
     * @return Id4
     */	
	public String getId4() {
		return this.id4;
	}
	
	/**
	 * @param id5
	 */
	public void setId5(String id5) {
		this.id5 = id5 == null ? null : id5.trim();
	}
	
    /**
     * @return Id5
     */	
	public String getId5() {
		return this.id5;
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
        AcrmFagChlSignBaseInfo other = (AcrmFagChlSignBaseInfo) that;
		return (this.getCorpOrgCode() == null ? other.getCorpOrgCode() == null : this.getCorpOrgCode().equals(other.getCorpOrgCode()))
                	&& (this.getContrNo() == null ? other.getContrNo() == null : this.getContrNo().equals(other.getContrNo()))
        	&& (this.getCustId() == null ? other.getCustId() == null : this.getCustId().equals(other.getCustId()))
        	&& (this.getSignBranchNo() == null ? other.getSignBranchNo() == null : this.getSignBranchNo().equals(other.getSignBranchNo()))
        	&& (this.getSignTellerNo() == null ? other.getSignTellerNo() == null : this.getSignTellerNo().equals(other.getSignTellerNo()))
        	&& (this.getSignAcctNo() == null ? other.getSignAcctNo() == null : this.getSignAcctNo().equals(other.getSignAcctNo()))
        	&& (this.getSignCardNo() == null ? other.getSignCardNo() == null : this.getSignCardNo().equals(other.getSignCardNo()))
        	&& (this.getSignType() == null ? other.getSignType() == null : this.getSignType().equals(other.getSignType()))
        	&& (this.getSignKind() == null ? other.getSignKind() == null : this.getSignKind().equals(other.getSignKind()))
        	&& (this.getSignKindDesc() == null ? other.getSignKindDesc() == null : this.getSignKindDesc().equals(other.getSignKindDesc()))
        	&& (this.getSignDesc() == null ? other.getSignDesc() == null : this.getSignDesc().equals(other.getSignDesc()))
        	&& (this.getSignStat() == null ? other.getSignStat() == null : this.getSignStat().equals(other.getSignStat()))
        	&& (this.getSignStatDesc() == null ? other.getSignStatDesc() == null : this.getSignStatDesc().equals(other.getSignStatDesc()))
                                        	&& (this.getSignEbankAcct() == null ? other.getSignEbankAcct() == null : this.getSignEbankAcct().equals(other.getSignEbankAcct()))
        	&& (this.getLastUpdateSys() == null ? other.getLastUpdateSys() == null : this.getLastUpdateSys().equals(other.getLastUpdateSys()))
        	&& (this.getLastUpdateUser() == null ? other.getLastUpdateUser() == null : this.getLastUpdateUser().equals(other.getLastUpdateUser()))
        	&& (this.getLastUpdateTm() == null ? other.getLastUpdateTm() == null : this.getLastUpdateTm().equals(other.getLastUpdateTm()))
        	&& (this.getTxSeqNo() == null ? other.getTxSeqNo() == null : this.getTxSeqNo().equals(other.getTxSeqNo()))
        	&& (this.getId1() == null ? other.getId1() == null : this.getId1().equals(other.getId1()))
        	&& (this.getId2() == null ? other.getId2() == null : this.getId2().equals(other.getId2()))
        	&& (this.getId3() == null ? other.getId3() == null : this.getId3().equals(other.getId3()))
        	&& (this.getId4() == null ? other.getId4() == null : this.getId4().equals(other.getId4()))
        	&& (this.getId5() == null ? other.getId5() == null : this.getId5().equals(other.getId5()))
        ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCorpOrgCode() == null) ? 0 : getCorpOrgCode().hashCode());
        result = prime * result + ((getContrNo() == null) ? 0 : getContrNo().hashCode());
        result = prime * result + ((getCustId() == null) ? 0 : getCustId().hashCode());
        result = prime * result + ((getSignBranchNo() == null) ? 0 : getSignBranchNo().hashCode());
        result = prime * result + ((getSignTellerNo() == null) ? 0 : getSignTellerNo().hashCode());
        result = prime * result + ((getSignAcctNo() == null) ? 0 : getSignAcctNo().hashCode());
        result = prime * result + ((getSignCardNo() == null) ? 0 : getSignCardNo().hashCode());
        result = prime * result + ((getSignType() == null) ? 0 : getSignType().hashCode());
        result = prime * result + ((getSignKind() == null) ? 0 : getSignKind().hashCode());
        result = prime * result + ((getSignKindDesc() == null) ? 0 : getSignKindDesc().hashCode());
        result = prime * result + ((getSignDesc() == null) ? 0 : getSignDesc().hashCode());
        result = prime * result + ((getSignStat() == null) ? 0 : getSignStat().hashCode());
        result = prime * result + ((getSignStatDesc() == null) ? 0 : getSignStatDesc().hashCode());
        result = prime * result + ((getSignEbankAcct() == null) ? 0 : getSignEbankAcct().hashCode());
        result = prime * result + ((getLastUpdateSys() == null) ? 0 : getLastUpdateSys().hashCode());
        result = prime * result + ((getLastUpdateUser() == null) ? 0 : getLastUpdateUser().hashCode());
        result = prime * result + ((getLastUpdateTm() == null) ? 0 : getLastUpdateTm().hashCode());
        result = prime * result + ((getTxSeqNo() == null) ? 0 : getTxSeqNo().hashCode());
        result = prime * result + ((getId1() == null) ? 0 : getId1().hashCode());
        result = prime * result + ((getId2() == null) ? 0 : getId2().hashCode());
        result = prime * result + ((getId3() == null) ? 0 : getId3().hashCode());
        result = prime * result + ((getId4() == null) ? 0 : getId4().hashCode());
        result = prime * result + ((getId5() == null) ? 0 : getId5().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash = ").append(hashCode());
		sb.append(", corpOrgCode=").append(corpOrgCode);
		sb.append(", dataDate=").append(dataDate);
		sb.append(", contrNo=").append(contrNo);
		sb.append(", CustId=").append(custId);
		sb.append(", signBranchNo=").append(signBranchNo);
		sb.append(", signTellerNo=").append(signTellerNo);
		sb.append(", signAcctNo=").append(signAcctNo);
		sb.append(", signCardNo=").append(signCardNo);
		sb.append(", signType=").append(signType);
		sb.append(", signKind=").append(signKind);
		sb.append(", signKindDesc=").append(signKindDesc);
		sb.append(", signDesc=").append(signDesc);
		sb.append(", signStat=").append(signStat);
		sb.append(", signStatDesc=").append(signStatDesc);
		sb.append(", signDt=").append(signDt);
		sb.append(", signoffDt=").append(signoffDt);
		sb.append(", effectiveDt=").append(effectiveDt);
		sb.append(", expiredDt=").append(expiredDt);
		sb.append(", signEbankAcct=").append(signEbankAcct);
		sb.append(", lastUpdateSys=").append(lastUpdateSys);
		sb.append(", lastUpdateUser=").append(lastUpdateUser);
		sb.append(", lastUpdateTm=").append(lastUpdateTm);
		sb.append(", txSeqNo=").append(txSeqNo);
		sb.append(", id1=").append(id1);
		sb.append(", id2=").append(id2);
		sb.append(", id3=").append(id3);
		sb.append(", id4=").append(id4);
		sb.append(", id5=").append(id5);
        sb.append("]");
        return sb.toString();
    }
}