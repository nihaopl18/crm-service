package cn.com.yusys.yscrm.product.domain;

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
 * @项目名称: yscrm-entity-product-core模块
 * @类名称: AcrmApdBusiSum
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: yantianyi
 * @创建时间: 2019-02-27 14:20:52
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "ACRM_A_PD_BUSI_SUM")
public class AcrmApdBusiSum extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** 法人 **/
	@Id
	@Column(name = "CORP_ORG_CODE")
	@Generated(GenerationType.UUID)
	private String corpOrgCode;
	
	/** 数据日期 **/
	@Transient
	@Column(name = "DATA_DT", unique = false, nullable = true, length = 7)
	private Date dataDt;
	
	/** 产品编号 **/
	@Column(name = "PROD_ID", unique = false, nullable = true, length = 32)
	private String prodId;
	
	/** 产品名称 **/
	@Column(name = "PROD_NAME", unique = false, nullable = true, length = 80)
	private String prodName;
	
	/** 最近12个月持有产品客户数 **/
	@Column(name = "CUST_NUM_12", unique = false, nullable = true, length = 360)
	private String custNum12;
	
	/** 最近12个月销售规模 **/
	@Column(name = "SALES_AMT_12", unique = false, nullable = true, length = 360)
	private String salesAmt12;
	
	
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
	
	/**
	 * @param prodId
	 */
	public void setProdId(String prodId) {
		this.prodId = prodId == null ? null : prodId.trim();
	}
	
    /**
     * @return ProdId
     */	
	public String getProdId() {
		return this.prodId;
	}
	
	/**
	 * @param prodName
	 */
	public void setProdName(String prodName) {
		this.prodName = prodName == null ? null : prodName.trim();
	}
	
    /**
     * @return ProdName
     */	
	public String getProdName() {
		return this.prodName;
	}
	
	/**
	 * @param custNum12
	 */
	public void setCustNum12(String custNum12) {
		this.custNum12 = custNum12 == null ? null : custNum12.trim();
	}
	
    /**
     * @return CustNum12
     */	
	public String getCustNum12() {
		return this.custNum12;
	}
	
	/**
	 * @param salesAmt12
	 */
	public void setSalesAmt12(String salesAmt12) {
		this.salesAmt12 = salesAmt12 == null ? null : salesAmt12.trim();
	}
	
    /**
     * @return SalesAmt12
     */	
	public String getSalesAmt12() {
		return this.salesAmt12;
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
        AcrmApdBusiSum other = (AcrmApdBusiSum) that;
		return (this.getCorpOrgCode() == null ? other.getCorpOrgCode() == null : this.getCorpOrgCode().equals(other.getCorpOrgCode()))
                	&& (this.getProdId() == null ? other.getProdId() == null : this.getProdId().equals(other.getProdId()))
        	&& (this.getProdName() == null ? other.getProdName() == null : this.getProdName().equals(other.getProdName()))
        	&& (this.getCustNum12() == null ? other.getCustNum12() == null : this.getCustNum12().equals(other.getCustNum12()))
        	&& (this.getSalesAmt12() == null ? other.getSalesAmt12() == null : this.getSalesAmt12().equals(other.getSalesAmt12()))
        ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCorpOrgCode() == null) ? 0 : getCorpOrgCode().hashCode());
        result = prime * result + ((getProdId() == null) ? 0 : getProdId().hashCode());
        result = prime * result + ((getProdName() == null) ? 0 : getProdName().hashCode());
        result = prime * result + ((getCustNum12() == null) ? 0 : getCustNum12().hashCode());
        result = prime * result + ((getSalesAmt12() == null) ? 0 : getSalesAmt12().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash = ").append(hashCode());
		sb.append(", corpOrgCode=").append(corpOrgCode);
		sb.append(", dataDt=").append(dataDt);
		sb.append(", prodId=").append(prodId);
		sb.append(", prodName=").append(prodName);
		sb.append(", custNum12=").append(custNum12);
		sb.append(", salesAmt12=").append(salesAmt12);
        sb.append("]");
        return sb.toString();
    }
}