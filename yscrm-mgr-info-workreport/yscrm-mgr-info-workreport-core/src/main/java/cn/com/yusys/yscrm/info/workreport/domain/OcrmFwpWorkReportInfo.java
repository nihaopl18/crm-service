package cn.com.yusys.yscrm.info.workreport.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;


/**
 * @项目名称: yscrm-mgr-info-workreport-core模块
 * @类名称: OcrmFwpWorkReportInfo
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: lixt1
 * @创建时间: 2019-01-28 20:33:00
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "OCRM_F_WP_WORK_REPORT_INFO")
public class OcrmFwpWorkReportInfo extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** 记录编号 **/
	@Id
	@Column(name = "ID")
	@Generated(GenerationType.UUID)
	private String id;
	
	/** 报告编号 **/
	@Column(name = "WORK_REPORT_ID", unique = false, nullable = true, length = 32)
	private String workReportId;
	
	/** 维护客户数 **/
	@Column(name = "MAINTEN_CUST_NUM", unique = false, nullable = true, length = 38)
	private java.math.BigDecimal maintenCustNum;
	
	/** 新增客户数 **/
	@Column(name = "ADD_CUST_NUM", unique = false, nullable = true, length = 38)
	private java.math.BigDecimal addCustNum;
	
	/** 新增潜在客户数 **/
	@Column(name = "ADD_LATECUST_NUM", unique = false, nullable = true, length = 38)
	private java.math.BigDecimal addLatecustNum;
	
	/** 提升客户数 **/
	@Column(name = "PRORT_CUST_NUM", unique = false, nullable = true, length = 38)
	private java.math.BigDecimal prortCustNum;
	
	/** 新增销售理财产品金额 **/
	@Column(name = "ADD_SALE_FIN_BAL", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal addSaleFinBal;
	
	/** 新增销售贵金属金额 **/
	@Column(name = "ADD_SALE_METAL_BAL", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal addSaleMetalBal;
	
	/** 新增存款余额 **/
	@Column(name = "WEEK_ADD_DEP_BAL", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal weekAddDepBal;
	
	/** 新增客户贷款余额 **/
	@Column(name = "ADD_ASSETS_BAL", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal addAssetsBal;
	
	/** 主观汇报内容 **/
	@Column(name = "SUB_REPORT_CONT", unique = false, nullable = true, length = 100)
	private String subReportCont;
	
	/** 法人 **/
	@Column(name = "CORP_ORG_CODE", unique = false, nullable = true, length = 20)
	private String corpOrgCode;
	
	
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
	 * @param workReportId
	 */
	public void setWorkReportId(String workReportId) {
		this.workReportId = workReportId == null ? null : workReportId.trim();
	}
	
    /**
     * @return WorkReportId
     */	
	public String getWorkReportId() {
		return this.workReportId;
	}
	
	/**
	 * @param maintenCustNum
	 */
	public void setMaintenCustNum(java.math.BigDecimal maintenCustNum) {
		this.maintenCustNum = maintenCustNum;
	}
	
    /**
     * @return MaintenCustNum
     */	
	public java.math.BigDecimal getMaintenCustNum() {
		return this.maintenCustNum;
	}
	
	/**
	 * @param addCustNum
	 */
	public void setAddCustNum(java.math.BigDecimal addCustNum) {
		this.addCustNum = addCustNum;
	}
	
    /**
     * @return AddCustNum
     */	
	public java.math.BigDecimal getAddCustNum() {
		return this.addCustNum;
	}
	
	/**
	 * @param addLatecustNum
	 */
	public void setAddLatecustNum(java.math.BigDecimal addLatecustNum) {
		this.addLatecustNum = addLatecustNum;
	}
	
    /**
     * @return AddLatecustNum
     */	
	public java.math.BigDecimal getAddLatecustNum() {
		return this.addLatecustNum;
	}
	
	/**
	 * @param prortCustNum
	 */
	public void setPrortCustNum(java.math.BigDecimal prortCustNum) {
		this.prortCustNum = prortCustNum;
	}
	
    /**
     * @return PrortCustNum
     */	
	public java.math.BigDecimal getPrortCustNum() {
		return this.prortCustNum;
	}
	
	/**
	 * @param addSaleFinBal
	 */
	public void setAddSaleFinBal(java.math.BigDecimal addSaleFinBal) {
		this.addSaleFinBal = addSaleFinBal;
	}
	
    /**
     * @return AddSaleFinBal
     */	
	public java.math.BigDecimal getAddSaleFinBal() {
		return this.addSaleFinBal;
	}
	
	/**
	 * @param addSaleMetalBal
	 */
	public void setAddSaleMetalBal(java.math.BigDecimal addSaleMetalBal) {
		this.addSaleMetalBal = addSaleMetalBal;
	}
	
    /**
     * @return AddSaleMetalBal
     */	
	public java.math.BigDecimal getAddSaleMetalBal() {
		return this.addSaleMetalBal;
	}
	
	/**
	 * @param weekAddDepBal
	 */
	public void setWeekAddDepBal(java.math.BigDecimal weekAddDepBal) {
		this.weekAddDepBal = weekAddDepBal;
	}
	
    /**
     * @return WeekAddDepBal
     */	
	public java.math.BigDecimal getWeekAddDepBal() {
		return this.weekAddDepBal;
	}
	
	/**
	 * @param addAssetsBal
	 */
	public void setAddAssetsBal(java.math.BigDecimal addAssetsBal) {
		this.addAssetsBal = addAssetsBal;
	}
	
    /**
     * @return AddAssetsBal
     */	
	public java.math.BigDecimal getAddAssetsBal() {
		return this.addAssetsBal;
	}
	
	/**
	 * @param subReportCont
	 */
	public void setSubReportCont(String subReportCont) {
		this.subReportCont = subReportCont == null ? null : subReportCont.trim();
	}
	
    /**
     * @return SubReportCont
     */	
	public String getSubReportCont() {
		return this.subReportCont;
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
        OcrmFwpWorkReportInfo other = (OcrmFwpWorkReportInfo) that;
		return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
        	&& (this.getWorkReportId() == null ? other.getWorkReportId() == null : this.getWorkReportId().equals(other.getWorkReportId()))
                                                                        	&& (this.getSubReportCont() == null ? other.getSubReportCont() == null : this.getSubReportCont().equals(other.getSubReportCont()))
        	&& (this.getCorpOrgCode() == null ? other.getCorpOrgCode() == null : this.getCorpOrgCode().equals(other.getCorpOrgCode()))
        ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getWorkReportId() == null) ? 0 : getWorkReportId().hashCode());
        result = prime * result + ((getSubReportCont() == null) ? 0 : getSubReportCont().hashCode());
        result = prime * result + ((getCorpOrgCode() == null) ? 0 : getCorpOrgCode().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", workReportId=").append(workReportId);
		sb.append(", maintenCustNum=").append(maintenCustNum);
		sb.append(", addCustNum=").append(addCustNum);
		sb.append(", addLatecustNum=").append(addLatecustNum);
		sb.append(", prortCustNum=").append(prortCustNum);
		sb.append(", addSaleFinBal=").append(addSaleFinBal);
		sb.append(", addSaleMetalBal=").append(addSaleMetalBal);
		sb.append(", weekAddDepBal=").append(weekAddDepBal);
		sb.append(", addAssetsBal=").append(addAssetsBal);
		sb.append(", subReportCont=").append(subReportCont);
		sb.append(", corpOrgCode=").append(corpOrgCode);
        sb.append("]");
        return sb.toString();
    }
}