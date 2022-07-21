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
 * @类名称: OcrmFciPerManageInfo
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2019-03-01 10:23:21
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "OCRM_F_CI_PER_MANAGE_INFO")
public class OcrmFciPerManageInfo extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** ID主键 **/
	@Id
	@Column(name = "ID")
	@Generated(GenerationType.UUID)
	private String id;
	/** 数据日期 **/
	@Column(name = "DATA_DATE", unique = false, nullable = true, length = 8)
	private String dataDate;
	
	/** 创建日期 **/
	@Column(name = "CRAT_DT", unique = false, nullable = true, length = 7)
	private Date cratDt;
	
	/** 创建机构编号 **/
	@Column(name = "CRAT_ORG_ID", unique = false, nullable = true, length = 20)
	private String cratOrgId;
	
	/** 创建人 **/
	@Column(name = "CRAT_USR", unique = false, nullable = true, length = 20)
	private String cratUsr;
	
	/** 最近更新系统 **/
	@Column(name = "LAST_CHG_SYS", unique = false, nullable = true, length = 20)
	private String lastChgSys;
	
	/** 最近更新人 **/
	@Column(name = "LAST_CHG_USR", unique = false, nullable = true, length = 20)
	private String lastChgUsr;
	
	/** 最近更新时间 **/
	@Column(name = "LAST_CHG_DT", unique = false, nullable = true, length = 7)
	private Date lastChgDt;
	
	/** 法人 **/
	@Column(name = "CORP_ORG_CODE", unique = false, nullable = true, length = 10)
	private String corpOrgCode;
	
	/** 客户标识 **/
	@Column(name = "CUST_ID", unique = false, nullable = true, length = 40)
	private String custId;
	
	/** 经营实体名称 **/
	@Column(name = "BUSI_NAME", unique = false, nullable = true, length = 200)
	private String busiName;
	
	/** 经营实体客户号 **/
	@Column(name = "BUSI_CUST_ID", unique = false, nullable = true, length = 32)
	private String busiCustId;
	
	/** 负责人 **/
	@Column(name = "PRINCIPAL", unique = false, nullable = true, length = 80)
	private String principal;
	
	/** 负责人联系电话 **/
	@Column(name = "PRIN_TEL_NO", unique = false, nullable = true, length = 60)
	private String prinTelNo;
	
	/** 经营单位类型 **/
	@Column(name = "COM_TYPE", unique = false, nullable = true, length = 30)
	private String comType;
	
	/** 经营企业规模 **/
	@Column(name = "COM_SCALE", unique = false, nullable = true, length = 30)
	private String comScale;
	
	/** 产值 **/
	@Column(name = "COM_VAL", unique = false, nullable = true, length = 22)
	private java.math.BigDecimal comVal;
	
	/** 注册币种 **/
	@Column(name = "REG_CURR_CD", unique = false, nullable = true, length = 30)
	private String regCurrCd;
	
	/** 注册资金 **/
	@Column(name = "REG_AMT", unique = false, nullable = true, length = 22)
	private java.math.BigDecimal regAmt;
	
	/** 股东或合伙人数 **/
	@Column(name = "PARTNER_NUM", unique = false, nullable = true, length = 38)
	private java.math.BigDecimal partnerNum;
	
	/** 员工人数 **/
	@Column(name = "EMP_NUM", unique = false, nullable = true, length = 38)
	private java.math.BigDecimal empNum;
	
	/** 开业时间 **/
	@Column(name = "OPEN_DATE", unique = false, nullable = true, length = 8)
	private String openDate;
	
	/** 主营范围 **/
	@Column(name = "MAIN_RANGE", unique = false, nullable = true, length = 400)
	private String mainRange;
	
	/** 兼营范围 **/
	@Column(name = "PART_RANGE", unique = false, nullable = true, length = 400)
	private String partRange;
	
	/** 单位地址 **/
	@Column(name = "UNIT_ADDR", unique = false, nullable = true, length = 80)
	private String unitAddr;
	
	/** 联系人 **/
	@Column(name = "CONT_NAME", unique = false, nullable = true, length = 80)
	private String contName;
	
	/** 联系人联系电话 **/
	@Column(name = "CONT_TEL_NO", unique = false, nullable = true, length = 40)
	private String contTelNo;
	
	/** 客户职位 **/
	@Column(name = "CUST_POSI", unique = false, nullable = true, length = 80)
	private String custPosi;
	
	/** 客户股份占比 **/
	@Column(name = "CUST_STOCK_PERT", unique = false, nullable = true, length = 22)
	private java.math.BigDecimal custStockPert;
	
	/** 备注 **/
	@Column(name = "REMARKS", unique = false, nullable = true, length = 400)
	private String remarks;
	
	
	
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
	 * @param cratOrgId
	 */
	public void setCratOrgId(String cratOrgId) {
		this.cratOrgId = cratOrgId == null ? null : cratOrgId.trim();
	}
	
    /**
     * @return CratOrgId
     */	
	public String getCratOrgId() {
		return this.cratOrgId;
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
	 * @param busiName
	 */
	public void setBusiName(String busiName) {
		this.busiName = busiName == null ? null : busiName.trim();
	}
	
    /**
     * @return BusiName
     */	
	public String getBusiName() {
		return this.busiName;
	}
	
	/**
	 * @param busiCustId
	 */
	public void setBusiCustId(String busiCustId) {
		this.busiCustId = busiCustId == null ? null : busiCustId.trim();
	}
	
    /**
     * @return BusiCustId
     */	
	public String getBusiCustId() {
		return this.busiCustId;
	}
	
	/**
	 * @param principal
	 */
	public void setPrincipal(String principal) {
		this.principal = principal == null ? null : principal.trim();
	}
	
    /**
     * @return Principal
     */	
	public String getPrincipal() {
		return this.principal;
	}
	
	/**
	 * @param prinTelNo
	 */
	public void setPrinTelNo(String prinTelNo) {
		this.prinTelNo = prinTelNo == null ? null : prinTelNo.trim();
	}
	
    /**
     * @return PrinTelNo
     */	
	public String getPrinTelNo() {
		return this.prinTelNo;
	}
	
	/**
	 * @param comType
	 */
	public void setComType(String comType) {
		this.comType = comType == null ? null : comType.trim();
	}
	
    /**
     * @return ComType
     */	
	public String getComType() {
		return this.comType;
	}
	
	/**
	 * @param comScale
	 */
	public void setComScale(String comScale) {
		this.comScale = comScale == null ? null : comScale.trim();
	}
	
    /**
     * @return ComScale
     */	
	public String getComScale() {
		return this.comScale;
	}
	
	/**
	 * @param comVal
	 */
	public void setComVal(java.math.BigDecimal comVal) {
		this.comVal = comVal;
	}
	
    /**
     * @return ComVal
     */	
	public java.math.BigDecimal getComVal() {
		return this.comVal;
	}
	
	/**
	 * @param regCurrCd
	 */
	public void setRegCurrCd(String regCurrCd) {
		this.regCurrCd = regCurrCd == null ? null : regCurrCd.trim();
	}
	
    /**
     * @return RegCurrCd
     */	
	public String getRegCurrCd() {
		return this.regCurrCd;
	}
	
	/**
	 * @param regAmt
	 */
	public void setRegAmt(java.math.BigDecimal regAmt) {
		this.regAmt = regAmt;
	}
	
    /**
     * @return RegAmt
     */	
	public java.math.BigDecimal getRegAmt() {
		return this.regAmt;
	}
	
	/**
	 * @param partnerNum
	 */
	public void setPartnerNum(java.math.BigDecimal partnerNum) {
		this.partnerNum = partnerNum;
	}
	
    /**
     * @return PartnerNum
     */	
	public java.math.BigDecimal getPartnerNum() {
		return this.partnerNum;
	}
	
	/**
	 * @param empNum
	 */
	public void setEmpNum(java.math.BigDecimal empNum) {
		this.empNum = empNum;
	}
	
    /**
     * @return EmpNum
     */	
	public java.math.BigDecimal getEmpNum() {
		return this.empNum;
	}
	
	/**
	 * @param openDate
	 */
	public void setOpenDate(String openDate) {
		this.openDate = openDate == null ? null : openDate.trim();
	}
	
    /**
     * @return OpenDate
     */	
	public String getOpenDate() {
		return this.openDate;
	}
	
	/**
	 * @param mainRange
	 */
	public void setMainRange(String mainRange) {
		this.mainRange = mainRange == null ? null : mainRange.trim();
	}
	
    /**
     * @return MainRange
     */	
	public String getMainRange() {
		return this.mainRange;
	}
	
	/**
	 * @param partRange
	 */
	public void setPartRange(String partRange) {
		this.partRange = partRange == null ? null : partRange.trim();
	}
	
    /**
     * @return PartRange
     */	
	public String getPartRange() {
		return this.partRange;
	}
	
	/**
	 * @param unitAddr
	 */
	public void setUnitAddr(String unitAddr) {
		this.unitAddr = unitAddr == null ? null : unitAddr.trim();
	}
	
    /**
     * @return UnitAddr
     */	
	public String getUnitAddr() {
		return this.unitAddr;
	}
	
	/**
	 * @param contName
	 */
	public void setContName(String contName) {
		this.contName = contName == null ? null : contName.trim();
	}
	
    /**
     * @return ContName
     */	
	public String getContName() {
		return this.contName;
	}
	
	/**
	 * @param contTelNo
	 */
	public void setContTelNo(String contTelNo) {
		this.contTelNo = contTelNo == null ? null : contTelNo.trim();
	}
	
    /**
     * @return ContTelNo
     */	
	public String getContTelNo() {
		return this.contTelNo;
	}
	
	/**
	 * @param custPosi
	 */
	public void setCustPosi(String custPosi) {
		this.custPosi = custPosi == null ? null : custPosi.trim();
	}
	
    /**
     * @return CustPosi
     */	
	public String getCustPosi() {
		return this.custPosi;
	}
	
	/**
	 * @param custStockPert
	 */
	public void setCustStockPert(java.math.BigDecimal custStockPert) {
		this.custStockPert = custStockPert;
	}
	
    /**
     * @return CustStockPert
     */	
	public java.math.BigDecimal getCustStockPert() {
		return this.custStockPert;
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
        OcrmFciPerManageInfo other = (OcrmFciPerManageInfo) that;
		return (this.getDataDate() == null ? other.getDataDate() == null : this.getDataDate().equals(other.getDataDate()))
                	&& (this.getCratOrgId() == null ? other.getCratOrgId() == null : this.getCratOrgId().equals(other.getCratOrgId()))
        	&& (this.getCratUsr() == null ? other.getCratUsr() == null : this.getCratUsr().equals(other.getCratUsr()))
        	&& (this.getLastChgSys() == null ? other.getLastChgSys() == null : this.getLastChgSys().equals(other.getLastChgSys()))
        	&& (this.getLastChgUsr() == null ? other.getLastChgUsr() == null : this.getLastChgUsr().equals(other.getLastChgUsr()))
                	&& (this.getCorpOrgCode() == null ? other.getCorpOrgCode() == null : this.getCorpOrgCode().equals(other.getCorpOrgCode()))
        	&& (this.getCustId() == null ? other.getCustId() == null : this.getCustId().equals(other.getCustId()))
        	&& (this.getBusiName() == null ? other.getBusiName() == null : this.getBusiName().equals(other.getBusiName()))
        	&& (this.getBusiCustId() == null ? other.getBusiCustId() == null : this.getBusiCustId().equals(other.getBusiCustId()))
        	&& (this.getPrincipal() == null ? other.getPrincipal() == null : this.getPrincipal().equals(other.getPrincipal()))
        	&& (this.getPrinTelNo() == null ? other.getPrinTelNo() == null : this.getPrinTelNo().equals(other.getPrinTelNo()))
        	&& (this.getComType() == null ? other.getComType() == null : this.getComType().equals(other.getComType()))
        	&& (this.getComScale() == null ? other.getComScale() == null : this.getComScale().equals(other.getComScale()))
                	&& (this.getRegCurrCd() == null ? other.getRegCurrCd() == null : this.getRegCurrCd().equals(other.getRegCurrCd()))
                                	&& (this.getOpenDate() == null ? other.getOpenDate() == null : this.getOpenDate().equals(other.getOpenDate()))
        	&& (this.getMainRange() == null ? other.getMainRange() == null : this.getMainRange().equals(other.getMainRange()))
        	&& (this.getPartRange() == null ? other.getPartRange() == null : this.getPartRange().equals(other.getPartRange()))
        	&& (this.getUnitAddr() == null ? other.getUnitAddr() == null : this.getUnitAddr().equals(other.getUnitAddr()))
        	&& (this.getContName() == null ? other.getContName() == null : this.getContName().equals(other.getContName()))
        	&& (this.getContTelNo() == null ? other.getContTelNo() == null : this.getContTelNo().equals(other.getContTelNo()))
        	&& (this.getCustPosi() == null ? other.getCustPosi() == null : this.getCustPosi().equals(other.getCustPosi()))
                	&& (this.getRemarks() == null ? other.getRemarks() == null : this.getRemarks().equals(other.getRemarks()))
        	&& (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
        ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDataDate() == null) ? 0 : getDataDate().hashCode());
        result = prime * result + ((getCratOrgId() == null) ? 0 : getCratOrgId().hashCode());
        result = prime * result + ((getCratUsr() == null) ? 0 : getCratUsr().hashCode());
        result = prime * result + ((getLastChgSys() == null) ? 0 : getLastChgSys().hashCode());
        result = prime * result + ((getLastChgUsr() == null) ? 0 : getLastChgUsr().hashCode());
        result = prime * result + ((getCorpOrgCode() == null) ? 0 : getCorpOrgCode().hashCode());
        result = prime * result + ((getCustId() == null) ? 0 : getCustId().hashCode());
        result = prime * result + ((getBusiName() == null) ? 0 : getBusiName().hashCode());
        result = prime * result + ((getBusiCustId() == null) ? 0 : getBusiCustId().hashCode());
        result = prime * result + ((getPrincipal() == null) ? 0 : getPrincipal().hashCode());
        result = prime * result + ((getPrinTelNo() == null) ? 0 : getPrinTelNo().hashCode());
        result = prime * result + ((getComType() == null) ? 0 : getComType().hashCode());
        result = prime * result + ((getComScale() == null) ? 0 : getComScale().hashCode());
        result = prime * result + ((getRegCurrCd() == null) ? 0 : getRegCurrCd().hashCode());
        result = prime * result + ((getOpenDate() == null) ? 0 : getOpenDate().hashCode());
        result = prime * result + ((getMainRange() == null) ? 0 : getMainRange().hashCode());
        result = prime * result + ((getPartRange() == null) ? 0 : getPartRange().hashCode());
        result = prime * result + ((getUnitAddr() == null) ? 0 : getUnitAddr().hashCode());
        result = prime * result + ((getContName() == null) ? 0 : getContName().hashCode());
        result = prime * result + ((getContTelNo() == null) ? 0 : getContTelNo().hashCode());
        result = prime * result + ((getCustPosi() == null) ? 0 : getCustPosi().hashCode());
        result = prime * result + ((getRemarks() == null) ? 0 : getRemarks().hashCode());
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash = ").append(hashCode());
		sb.append(", dataDate=").append(dataDate);
		sb.append(", cratDt=").append(cratDt);
		sb.append(", cratOrgId=").append(cratOrgId);
		sb.append(", cratUsr=").append(cratUsr);
		sb.append(", lastChgSys=").append(lastChgSys);
		sb.append(", lastChgUsr=").append(lastChgUsr);
		sb.append(", lastChgDt=").append(lastChgDt);
		sb.append(", corpOrgCode=").append(corpOrgCode);
		sb.append(", custId=").append(custId);
		sb.append(", busiName=").append(busiName);
		sb.append(", busiCustId=").append(busiCustId);
		sb.append(", principal=").append(principal);
		sb.append(", prinTelNo=").append(prinTelNo);
		sb.append(", comType=").append(comType);
		sb.append(", comScale=").append(comScale);
		sb.append(", comVal=").append(comVal);
		sb.append(", regCurrCd=").append(regCurrCd);
		sb.append(", regAmt=").append(regAmt);
		sb.append(", partnerNum=").append(partnerNum);
		sb.append(", empNum=").append(empNum);
		sb.append(", openDate=").append(openDate);
		sb.append(", mainRange=").append(mainRange);
		sb.append(", partRange=").append(partRange);
		sb.append(", unitAddr=").append(unitAddr);
		sb.append(", contName=").append(contName);
		sb.append(", contTelNo=").append(contTelNo);
		sb.append(", custPosi=").append(custPosi);
		sb.append(", custStockPert=").append(custStockPert);
		sb.append(", remarks=").append(remarks);
		sb.append(", id=").append(id);
        sb.append("]");
        return sb.toString();
    }
}