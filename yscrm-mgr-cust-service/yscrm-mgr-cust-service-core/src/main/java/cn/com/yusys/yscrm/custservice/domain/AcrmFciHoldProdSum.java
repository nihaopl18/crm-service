package cn.com.yusys.yscrm.custservice.domain;
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
 * @项目名称: ccccc模块
 * @类名称: AcrmFciHoldProdSum
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2019-02-26 18:08:11
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "ACRM_F_CI_HOLD_PROD_SUM")
public class AcrmFciHoldProdSum extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** 支行编号 **/
	@Id
	@Column(name = "ORG_NO")
	@Generated(GenerationType.UUID)
	private String orgNo;
	/** 数据日期 **/
	@Id
	@Column(name = "DATA_DT")
	@Generated(GenerationType.UUID)
	private Date dataDt;
	
	/** 法人 **/
	@Column(name = "CORP_ORG_CODE", unique = false, nullable = true, length = 3)
	private String corpOrgCode;
	
	/** 一级支行编号 **/
	@Column(name = "ORG1_NO", unique = false, nullable = true, length = 20)
	private String org1No;
	
	/** 一级支行名称 **/
	@Column(name = "ORG1_NAME", unique = false, nullable = true, length = 100)
	private String org1Name;
	
	/** 支行名称 **/
	@Column(name = "ORG_NAME", unique = false, nullable = true, length = 100)
	private String orgName;
	
	/** 持有我行8个产品的客户数 **/
	@Column(name = "HOLD_PROD_8", unique = false, nullable = true, length = 40)
	private String holdProd8;
	
	/** 持有我行7个产品的客户数 **/
	@Column(name = "HOLD_PROD_7", unique = false, nullable = true, length = 100)
	private String holdProd7;
	
	/** 持有我行6个产品的客户数 **/
	@Column(name = "HOLD_PROD_6", unique = false, nullable = true, length = 32)
	private String holdProd6;
	
	/** 持有我行5个产品的客户数 **/
	@Column(name = "HOLD_PROD_5", unique = false, nullable = true, length = 32)
	private String holdProd5;
	
	/** 持有我行4个产品的客户数 **/
	@Column(name = "HOLD_PROD_4", unique = false, nullable = true, length = 1)
	private String holdProd4;
	
	/** 持有我行3个产品的客户数 **/
	@Column(name = "HOLD_PROD_3", unique = false, nullable = true, length = 1)
	private String holdProd3;
	
	/** 持有我行2个产品的客户数 **/
	@Column(name = "HOLD_PROD_2", unique = false, nullable = true, length = 1)
	private String holdProd2;
	
	/** 持有我行1个产品的客户数 **/
	@Column(name = "HOLD_PROD_1", unique = false, nullable = true, length = 1)
	private String holdProd1;
	
	/** 持有我行0个产品的客户数 **/
	@Column(name = "HOLD_PROD_0", unique = false, nullable = true, length = 1)
	private String holdProd0;
	
	/** 持有我行2个(含)以上产品的达标客户数 **/
	@Column(name = "HOLD_PROD_DB", unique = false, nullable = true, length = 1)
	private String holdProdDb;
	
	
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
	 * @param org1No
	 */
	public void setOrg1No(String org1No) {
		this.org1No = org1No == null ? null : org1No.trim();
	}
	
    /**
     * @return Org1No
     */	
	public String getOrg1No() {
		return this.org1No;
	}
	
	/**
	 * @param org1Name
	 */
	public void setOrg1Name(String org1Name) {
		this.org1Name = org1Name == null ? null : org1Name.trim();
	}
	
    /**
     * @return Org1Name
     */	
	public String getOrg1Name() {
		return this.org1Name;
	}
	
	/**
	 * @param orgNo
	 */
	public void setOrgNo(String orgNo) {
		this.orgNo = orgNo == null ? null : orgNo.trim();
	}
	
    /**
     * @return OrgNo
     */	
	public String getOrgNo() {
		return this.orgNo;
	}
	
	/**
	 * @param orgName
	 */
	public void setOrgName(String orgName) {
		this.orgName = orgName == null ? null : orgName.trim();
	}
	
    /**
     * @return OrgName
     */	
	public String getOrgName() {
		return this.orgName;
	}
	
	/**
	 * @param holdProd8
	 */
	public void setHoldProd8(String holdProd8) {
		this.holdProd8 = holdProd8 == null ? null : holdProd8.trim();
	}
	
    /**
     * @return HoldProd8
     */	
	public String getHoldProd8() {
		return this.holdProd8;
	}
	
	/**
	 * @param holdProd7
	 */
	public void setHoldProd7(String holdProd7) {
		this.holdProd7 = holdProd7 == null ? null : holdProd7.trim();
	}
	
    /**
     * @return HoldProd7
     */	
	public String getHoldProd7() {
		return this.holdProd7;
	}
	
	/**
	 * @param holdProd6
	 */
	public void setHoldProd6(String holdProd6) {
		this.holdProd6 = holdProd6 == null ? null : holdProd6.trim();
	}
	
    /**
     * @return HoldProd6
     */	
	public String getHoldProd6() {
		return this.holdProd6;
	}
	
	/**
	 * @param holdProd5
	 */
	public void setHoldProd5(String holdProd5) {
		this.holdProd5 = holdProd5 == null ? null : holdProd5.trim();
	}
	
    /**
     * @return HoldProd5
     */	
	public String getHoldProd5() {
		return this.holdProd5;
	}
	
	/**
	 * @param holdProd4
	 */
	public void setHoldProd4(String holdProd4) {
		this.holdProd4 = holdProd4 == null ? null : holdProd4.trim();
	}
	
    /**
     * @return HoldProd4
     */	
	public String getHoldProd4() {
		return this.holdProd4;
	}
	
	/**
	 * @param holdProd3
	 */
	public void setHoldProd3(String holdProd3) {
		this.holdProd3 = holdProd3 == null ? null : holdProd3.trim();
	}
	
    /**
     * @return HoldProd3
     */	
	public String getHoldProd3() {
		return this.holdProd3;
	}
	
	/**
	 * @param holdProd2
	 */
	public void setHoldProd2(String holdProd2) {
		this.holdProd2 = holdProd2 == null ? null : holdProd2.trim();
	}
	
    /**
     * @return HoldProd2
     */	
	public String getHoldProd2() {
		return this.holdProd2;
	}
	
	/**
	 * @param holdProd1
	 */
	public void setHoldProd1(String holdProd1) {
		this.holdProd1 = holdProd1 == null ? null : holdProd1.trim();
	}
	
    /**
     * @return HoldProd1
     */	
	public String getHoldProd1() {
		return this.holdProd1;
	}
	
	/**
	 * @param holdProd0
	 */
	public void setHoldProd0(String holdProd0) {
		this.holdProd0 = holdProd0 == null ? null : holdProd0.trim();
	}
	
    /**
     * @return HoldProd0
     */	
	public String getHoldProd0() {
		return this.holdProd0;
	}
	
	/**
	 * @param holdProdDb
	 */
	public void setHoldProdDb(String holdProdDb) {
		this.holdProdDb = holdProdDb == null ? null : holdProdDb.trim();
	}
	
    /**
     * @return HoldProdDb
     */	
	public String getHoldProdDb() {
		return this.holdProdDb;
	}
	
	/**
	 * @param dataDt
	 */
	public void setDataDt(Date dataDt) {
		this.dataDt = dataDt;
	}
	
    /**
     * @return DataDt
     */	
	public Date getDataDt() {
		return this.dataDt;
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
        AcrmFciHoldProdSum other = (AcrmFciHoldProdSum) that;
		return (this.getCorpOrgCode() == null ? other.getCorpOrgCode() == null : this.getCorpOrgCode().equals(other.getCorpOrgCode()))
        	&& (this.getOrg1No() == null ? other.getOrg1No() == null : this.getOrg1No().equals(other.getOrg1No()))
        	&& (this.getOrg1Name() == null ? other.getOrg1Name() == null : this.getOrg1Name().equals(other.getOrg1Name()))
        	&& (this.getOrgNo() == null ? other.getOrgNo() == null : this.getOrgNo().equals(other.getOrgNo()))
        	&& (this.getOrgName() == null ? other.getOrgName() == null : this.getOrgName().equals(other.getOrgName()))
        	&& (this.getHoldProd8() == null ? other.getHoldProd8() == null : this.getHoldProd8().equals(other.getHoldProd8()))
        	&& (this.getHoldProd7() == null ? other.getHoldProd7() == null : this.getHoldProd7().equals(other.getHoldProd7()))
        	&& (this.getHoldProd6() == null ? other.getHoldProd6() == null : this.getHoldProd6().equals(other.getHoldProd6()))
        	&& (this.getHoldProd5() == null ? other.getHoldProd5() == null : this.getHoldProd5().equals(other.getHoldProd5()))
        	&& (this.getHoldProd4() == null ? other.getHoldProd4() == null : this.getHoldProd4().equals(other.getHoldProd4()))
        	&& (this.getHoldProd3() == null ? other.getHoldProd3() == null : this.getHoldProd3().equals(other.getHoldProd3()))
        	&& (this.getHoldProd2() == null ? other.getHoldProd2() == null : this.getHoldProd2().equals(other.getHoldProd2()))
        	&& (this.getHoldProd1() == null ? other.getHoldProd1() == null : this.getHoldProd1().equals(other.getHoldProd1()))
        	&& (this.getHoldProd0() == null ? other.getHoldProd0() == null : this.getHoldProd0().equals(other.getHoldProd0()))
        	&& (this.getHoldProdDb() == null ? other.getHoldProdDb() == null : this.getHoldProdDb().equals(other.getHoldProdDb()))
                ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCorpOrgCode() == null) ? 0 : getCorpOrgCode().hashCode());
        result = prime * result + ((getOrg1No() == null) ? 0 : getOrg1No().hashCode());
        result = prime * result + ((getOrg1Name() == null) ? 0 : getOrg1Name().hashCode());
        result = prime * result + ((getOrgNo() == null) ? 0 : getOrgNo().hashCode());
        result = prime * result + ((getOrgName() == null) ? 0 : getOrgName().hashCode());
        result = prime * result + ((getHoldProd8() == null) ? 0 : getHoldProd8().hashCode());
        result = prime * result + ((getHoldProd7() == null) ? 0 : getHoldProd7().hashCode());
        result = prime * result + ((getHoldProd6() == null) ? 0 : getHoldProd6().hashCode());
        result = prime * result + ((getHoldProd5() == null) ? 0 : getHoldProd5().hashCode());
        result = prime * result + ((getHoldProd4() == null) ? 0 : getHoldProd4().hashCode());
        result = prime * result + ((getHoldProd3() == null) ? 0 : getHoldProd3().hashCode());
        result = prime * result + ((getHoldProd2() == null) ? 0 : getHoldProd2().hashCode());
        result = prime * result + ((getHoldProd1() == null) ? 0 : getHoldProd1().hashCode());
        result = prime * result + ((getHoldProd0() == null) ? 0 : getHoldProd0().hashCode());
        result = prime * result + ((getHoldProdDb() == null) ? 0 : getHoldProdDb().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash = ").append(hashCode());
        sb.append("]");
        return sb.toString();
    }
}