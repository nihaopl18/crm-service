package cn.com.yusys.yscrm.custpub.domain;

import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;
import cn.com.yusys.yscrm.custpub.annotation.ColumnConfig;
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
 * @项目名称: yscrm-entity-cust-pub-core模块
 * @类名称: AcrmFciContactInfo
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2019-01-28 15:24:23
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "ACRM_F_CI_CONTACT_INFO")
public class AcrmFciContactInfo extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	/** ID主键 **/
	@Id
	@Column(name = "ID", unique = false, nullable = true, length = 32)
	@Generated(GenerationType.UUID)
	private String id;
	
	/** 数据日期
 **/
	@Column(name = "DATA_DT", unique = false, nullable = true, length = 8)
	private Date dataDt;
	
	/** 创建日期
 **/
	
	@Column(name = "CRAT_DT", unique = false, nullable = true, length = 7)
	private Date cratDt;
	
	/** 创建机构编号
 **/
	@Column(name = "CRAT_ORG_ID", unique = false, nullable = true, length = 20)
	private String cratOrgId;
	
	/** 创建人
 **/
	@Column(name = "CRAT_USR", unique = false, nullable = true, length = 20)
	private String cratUsr;
	
	/** 最新更新系统
 **/
	@Column(name = "LAST_CHG_SYS", unique = false, nullable = true, length = 20)
	private String lastChgSys;
	
	/** 最新更新人
 **/
	@Column(name = "LAST_CHG_USR", unique = false, nullable = true, length = 20)
	private String lastChgUsr;
	
	/** 最新更新时间
 **/
	
	@Column(name = "LAST_CHG_DT", unique = false, nullable = true, length = 7)
	private Date lastChgDt;
	
	/** 法人
 **/
	@Column(name = "CORP_ORG_CODE", unique = false, nullable = true, length = 20)
	private String corpOrgCode;
	
	/** 客户编号
 **/
	@Column(name = "CUST_ID", unique = false, nullable = true, length = 17)
	private String custId;
	
	/** 客户类型
 **/
	@Column(name = "CUST_TYPE", unique = false, nullable = true, length = 30)
	private String custType;
	
	/** 联系方式类型
 **/
	@Column(name = "CONT_TYPE", unique = false, nullable = true, length = 30)
	@ColumnConfig(description = "联系方式类型", lookup = "CD0258", key = true)
	private String contType;
	
	/** 联系人
 **/
	@Column(name = "CONT_NAME", unique = false, nullable = true, length = 200)
	@ColumnConfig(description = "联系人", lookup = "", key = true)
	private String contName;
	
	/** 联系方式
 **/
	@Column(name = "CONT_METH", unique = false, nullable = true, length = 80)
	@ColumnConfig(description = "联系方式", lookup = "", key = true)
	private String contMeth;
	
	/** 主联系标志
 **/
	@Column(name = "MAIN_CONT_FLG", unique = false, nullable = true, length = 30)
	@ColumnConfig(description = "主联系标志", lookup = "CD0238", key = true)
	private String mainContFlg;
	
	/** 主联系标志设置系统
 **/
	@Column(name = "FLG_SET_SYS", unique = false, nullable = true, length = 30)
	private String flgSetSys;
	
	
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
	
	

	public Date getDataDt() {
		return dataDt;
	}

	public void setDataDt(Date dataDt) {
		this.dataDt = dataDt;
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
	 * @param custType
	 */
	public void setCustType(String custType) {
		this.custType = custType == null ? null : custType.trim();
	}
	
    /**
     * @return CustType
     */	
	public String getCustType() {
		return this.custType;
	}
	
	/**
	 * @param contType
	 */
	public void setContType(String contType) {
		this.contType = contType == null ? null : contType.trim();
	}
	
    /**
     * @return ContType
     */	
	public String getContType() {
		return this.contType;
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
	 * @param contMeth
	 */
	public void setContMeth(String contMeth) {
		this.contMeth = contMeth == null ? null : contMeth.trim();
	}
	
    /**
     * @return ContMeth
     */	
	public String getContMeth() {
		return this.contMeth;
	}
	
	/**
	 * @param mainContFlg
	 */
	public void setMainContFlg(String mainContFlg) {
		this.mainContFlg = mainContFlg == null ? null : mainContFlg.trim();
	}
	
    /**
     * @return MainContFlg
     */	
	public String getMainContFlg() {
		return this.mainContFlg;
	}
	
	/**
	 * @param flgSetSys
	 */
	public void setFlgSetSys(String flgSetSys) {
		this.flgSetSys = flgSetSys == null ? null : flgSetSys.trim();
	}
	
    /**
     * @return FlgSetSys
     */	
	public String getFlgSetSys() {
		return this.flgSetSys;
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
        AcrmFciContactInfo other = (AcrmFciContactInfo) that;
		return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
        	&& (this.getDataDt()== null ? other.getDataDt() == null : this.getDataDt().equals(other.getDataDt()))
                	&& (this.getCratOrgId() == null ? other.getCratOrgId() == null : this.getCratOrgId().equals(other.getCratOrgId()))
        	&& (this.getCratUsr() == null ? other.getCratUsr() == null : this.getCratUsr().equals(other.getCratUsr()))
        	&& (this.getLastChgSys() == null ? other.getLastChgSys() == null : this.getLastChgSys().equals(other.getLastChgSys()))
        	&& (this.getLastChgUsr() == null ? other.getLastChgUsr() == null : this.getLastChgUsr().equals(other.getLastChgUsr()))
                	&& (this.getCorpOrgCode() == null ? other.getCorpOrgCode() == null : this.getCorpOrgCode().equals(other.getCorpOrgCode()))
        	&& (this.getCustId() == null ? other.getCustId() == null : this.getCustId().equals(other.getCustId()))
        	&& (this.getCustType() == null ? other.getCustType() == null : this.getCustType().equals(other.getCustType()))
        	&& (this.getContType() == null ? other.getContType() == null : this.getContType().equals(other.getContType()))
        	&& (this.getContName() == null ? other.getContName() == null : this.getContName().equals(other.getContName()))
        	&& (this.getContMeth() == null ? other.getContMeth() == null : this.getContMeth().equals(other.getContMeth()))
        	&& (this.getMainContFlg() == null ? other.getMainContFlg() == null : this.getMainContFlg().equals(other.getMainContFlg()))
        	&& (this.getFlgSetSys() == null ? other.getFlgSetSys() == null : this.getFlgSetSys().equals(other.getFlgSetSys()))
        ;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getDataDt() == null) ? 0 : getDataDt().hashCode());
        result = prime * result + ((getCratOrgId() == null) ? 0 : getCratOrgId().hashCode());
        result = prime * result + ((getCratUsr() == null) ? 0 : getCratUsr().hashCode());
        result = prime * result + ((getLastChgSys() == null) ? 0 : getLastChgSys().hashCode());
        result = prime * result + ((getLastChgUsr() == null) ? 0 : getLastChgUsr().hashCode());
        result = prime * result + ((getCorpOrgCode() == null) ? 0 : getCorpOrgCode().hashCode());
        result = prime * result + ((getCustId() == null) ? 0 : getCustId().hashCode());
        result = prime * result + ((getCustType() == null) ? 0 : getCustType().hashCode());
        result = prime * result + ((getContType() == null) ? 0 : getContType().hashCode());
        result = prime * result + ((getContName() == null) ? 0 : getContName().hashCode());
        result = prime * result + ((getContMeth() == null) ? 0 : getContMeth().hashCode());
        result = prime * result + ((getMainContFlg() == null) ? 0 : getMainContFlg().hashCode());
        result = prime * result + ((getFlgSetSys() == null) ? 0 : getFlgSetSys().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash = ").append(hashCode());
		sb.append(", id=").append(id);
		sb.append(", dataDt=").append(dataDt);
		sb.append(", cratDt=").append(cratDt);
		sb.append(", cratOrgId=").append(cratOrgId);
		sb.append(", cratUsr=").append(cratUsr);
		sb.append(", lastChgSys=").append(lastChgSys);
		sb.append(", lastChgUsr=").append(lastChgUsr);
		sb.append(", lastChgDt=").append(lastChgDt);
		sb.append(", corpOrgCode=").append(corpOrgCode);
		sb.append(", custId=").append(custId);
		sb.append(", custType=").append(custType);
		sb.append(", contType=").append(contType);
		sb.append(", contName=").append(contName);
		sb.append(", contMeth=").append(contMeth);
		sb.append(", mainContFlg=").append(mainContFlg);
		sb.append(", flgSetSys=").append(flgSetSys);
        sb.append("]");
        return sb.toString();
    }
}