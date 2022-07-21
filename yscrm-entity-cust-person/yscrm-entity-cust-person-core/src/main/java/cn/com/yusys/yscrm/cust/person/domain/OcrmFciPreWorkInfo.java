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
 * @类名称: OcrmFciPreWorkInfo
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2019-03-01 10:16:09
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "OCRM_F_CI_PER_WORK_INFO")
public class OcrmFciPreWorkInfo extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	/** 主键
 **/
	@Id
	@Generated(GenerationType.UUID)
	@Column(name = "CUST_ID")
	private String custId;

	/** 更新机构
 **/
	@Column(name = "LAST_ORG_ID", unique = false, nullable = true, length = 32)
	private String lastOrgId;
	
	/** 更新人
 **/
	@Column(name = "LAST_CHG_USR", unique = false, nullable = true, length = 32)
	private String lastChgUsr;
	
	/** 更新时间
 **/
	@Transient
	@Column(name = "LAST_CHG_DT", unique = false, nullable = true, length = 7)
	private Date lastChgDt;
	
	/** 现工作单位名称
 **/
	@Column(name = "CUR_WORK_UNIT", unique = false, nullable = true, length = 100)
	private String curWorkUnit;
	
	/** 单位联系人
 **/
	@Column(name = "UNIT_CON_PER", unique = false, nullable = true, length = 50)
	private String unitConPer;
	
	/** 从事职业
 **/
	@Column(name = "ENG_IN_PRO", unique = false, nullable = true, length = 2)
	private String engInPro;
	
	/** 单位性质
 **/
	@Column(name = "UNIT_NAT", unique = false, nullable = true, length = 2)
	private String unitNat;
	
	/** 单位所属行业
 **/
	@Column(name = "IND_OWN_UNIT", unique = false, nullable = true, length = 2)
	private String indOwnUnit;
	
	/** 所在部门
 **/
	@Column(name = "DEPARTMENT", unique = false, nullable = true, length = 50)
	private String department;
	
	/** 职务
 **/
	@Column(name = "DUTIES", unique = false, nullable = true, length = 4)
	private String duties;
	
	/** 职位
 **/
	@Column(name = "POSITION", unique = false, nullable = true, length = 50)
	private String position;
	
	/** 是否企业高管【手工维护】
 **/
	@Column(name = "COR_EXE", unique = false, nullable = true, length = 2)
	private String corExe;
	
	/** 是否董事会成员
 **/
	@Column(name = "BOARD_MEM", unique = false, nullable = true, length = 2)
	private String boardMem;
	
	/** 与实际控制人关系
 **/
	@Column(name = "REL_WITH_ACTUAL_CON", unique = false, nullable = true, length = 2)
	private String relWithActualCon;
	
	/** 职称
 **/
	@Column(name = "TITLE", unique = false, nullable = true, length = 2)
	private String title;
	
	/** 入职日期
 **/
	@Transient
	@Column(name = "ENTRY_DATE", unique = false, nullable = true, length = 7)
	private Date entryDate;
	
	/** 总工龄
 **/
	@Column(name = "TOTAL_LEN_SER", unique = false, nullable = true, length = 10)
	private String totalLenSer;
	
	/** 法人
 **/
	@Column(name = "CORP_ORG_CODE", unique = false, nullable = true, length = 20)
	private String corpOrgCode;
	
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
	 * @param lastOrgId
	 */
	public void setLastOrgId(String lastOrgId) {
		this.lastOrgId = lastOrgId == null ? null : lastOrgId.trim();
	}
	
    /**
     * @return LastOrgId
     */	
	public String getLastOrgId() {
		return this.lastOrgId;
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
	 * @param curWorkUnit
	 */
	public void setCurWorkUnit(String curWorkUnit) {
		this.curWorkUnit = curWorkUnit == null ? null : curWorkUnit.trim();
	}
	
    /**
     * @return CurWorkUnit
     */	
	public String getCurWorkUnit() {
		return this.curWorkUnit;
	}
	
	/**
	 * @param unitConPer
	 */
	public void setUnitConPer(String unitConPer) {
		this.unitConPer = unitConPer == null ? null : unitConPer.trim();
	}
	
    /**
     * @return UnitConPer
     */	
	public String getUnitConPer() {
		return this.unitConPer;
	}
	
	/**
	 * @param engInPro
	 */
	public void setEngInPro(String engInPro) {
		this.engInPro = engInPro == null ? null : engInPro.trim();
	}
	
    /**
     * @return EngInPro
     */	
	public String getEngInPro() {
		return this.engInPro;
	}
	
	/**
	 * @param unitNat
	 */
	public void setUnitNat(String unitNat) {
		this.unitNat = unitNat == null ? null : unitNat.trim();
	}
	
    /**
     * @return UnitNat
     */	
	public String getUnitNat() {
		return this.unitNat;
	}
	
	/**
	 * @param indOwnUnit
	 */
	public void setIndOwnUnit(String indOwnUnit) {
		this.indOwnUnit = indOwnUnit == null ? null : indOwnUnit.trim();
	}
	
    /**
     * @return IndOwnUnit
     */	
	public String getIndOwnUnit() {
		return this.indOwnUnit;
	}
	
	/**
	 * @param department
	 */
	public void setDepartment(String department) {
		this.department = department == null ? null : department.trim();
	}
	
    /**
     * @return Department
     */	
	public String getDepartment() {
		return this.department;
	}
	
	/**
	 * @param duties
	 */
	public void setDuties(String duties) {
		this.duties = duties == null ? null : duties.trim();
	}
	
    /**
     * @return Duties
     */	
	public String getDuties() {
		return this.duties;
	}
	
	/**
	 * @param position
	 */
	public void setPosition(String position) {
		this.position = position == null ? null : position.trim();
	}
	
    /**
     * @return Position
     */	
	public String getPosition() {
		return this.position;
	}
	
	/**
	 * @param corExe
	 */
	public void setCorExe(String corExe) {
		this.corExe = corExe == null ? null : corExe.trim();
	}
	
    /**
     * @return CorExe
     */	
	public String getCorExe() {
		return this.corExe;
	}
	
	/**
	 * @param boardMem
	 */
	public void setBoardMem(String boardMem) {
		this.boardMem = boardMem == null ? null : boardMem.trim();
	}
	
    /**
     * @return BoardMem
     */	
	public String getBoardMem() {
		return this.boardMem;
	}
	
	/**
	 * @param relWithActualCon
	 */
	public void setRelWithActualCon(String relWithActualCon) {
		this.relWithActualCon = relWithActualCon == null ? null : relWithActualCon.trim();
	}
	
    /**
     * @return RelWithActualCon
     */	
	public String getRelWithActualCon() {
		return this.relWithActualCon;
	}
	
	/**
	 * @param title
	 */
	public void setTitle(String title) {
		this.title = title == null ? null : title.trim();
	}
	
    /**
     * @return Title
     */	
	public String getTitle() {
		return this.title;
	}
	
	/**
	 * @param entryDate
	 */
	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}
	
    /**
     * @return EntryDate
     */	
	public Date getEntryDate() {
		return this.entryDate;
	}
	
	/**
	 * @param totalLenSer
	 */
	public void setTotalLenSer(String totalLenSer) {
		this.totalLenSer = totalLenSer == null ? null : totalLenSer.trim();
	}
	
    /**
     * @return TotalLenSer
     */	
	public String getTotalLenSer() {
		return this.totalLenSer;
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
        OcrmFciPreWorkInfo other = (OcrmFciPreWorkInfo) that;
		return ((this.getCustId() == null ? other.getCustId() == null : this.getCustId().equals(other.getCustId()))
        	&& (this.getLastOrgId() == null ? other.getLastOrgId() == null : this.getLastOrgId().equals(other.getLastOrgId()))
        	&& (this.getLastChgUsr() == null ? other.getLastChgUsr() == null : this.getLastChgUsr().equals(other.getLastChgUsr()))
                	&& (this.getCurWorkUnit() == null ? other.getCurWorkUnit() == null : this.getCurWorkUnit().equals(other.getCurWorkUnit()))
        	&& (this.getUnitConPer() == null ? other.getUnitConPer() == null : this.getUnitConPer().equals(other.getUnitConPer()))
        	&& (this.getEngInPro() == null ? other.getEngInPro() == null : this.getEngInPro().equals(other.getEngInPro()))
        	&& (this.getUnitNat() == null ? other.getUnitNat() == null : this.getUnitNat().equals(other.getUnitNat()))
        	&& (this.getIndOwnUnit() == null ? other.getIndOwnUnit() == null : this.getIndOwnUnit().equals(other.getIndOwnUnit()))
        	&& (this.getDepartment() == null ? other.getDepartment() == null : this.getDepartment().equals(other.getDepartment()))
        	&& (this.getDuties() == null ? other.getDuties() == null : this.getDuties().equals(other.getDuties()))
        	&& (this.getPosition() == null ? other.getPosition() == null : this.getPosition().equals(other.getPosition()))
        	&& (this.getCorExe() == null ? other.getCorExe() == null : this.getCorExe().equals(other.getCorExe()))
        	&& (this.getBoardMem() == null ? other.getBoardMem() == null : this.getBoardMem().equals(other.getBoardMem()))
        	&& (this.getRelWithActualCon() == null ? other.getRelWithActualCon() == null : this.getRelWithActualCon().equals(other.getRelWithActualCon()))
        	&& (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
                	&& (this.getTotalLenSer() == null ? other.getTotalLenSer() == null : this.getTotalLenSer().equals(other.getTotalLenSer()))
        	&& (this.getCorpOrgCode() == null ? other.getCorpOrgCode() == null : this.getCorpOrgCode().equals(other.getCorpOrgCode())));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
     
        result = prime * result + ((getCustId() == null) ? 0 : getCustId().hashCode());
        result = prime * result + ((getLastOrgId() == null) ? 0 : getLastOrgId().hashCode());
        result = prime * result + ((getLastChgUsr() == null) ? 0 : getLastChgUsr().hashCode());
        result = prime * result + ((getCurWorkUnit() == null) ? 0 : getCurWorkUnit().hashCode());
        result = prime * result + ((getUnitConPer() == null) ? 0 : getUnitConPer().hashCode());
        result = prime * result + ((getEngInPro() == null) ? 0 : getEngInPro().hashCode());
        result = prime * result + ((getUnitNat() == null) ? 0 : getUnitNat().hashCode());
        result = prime * result + ((getIndOwnUnit() == null) ? 0 : getIndOwnUnit().hashCode());
        result = prime * result + ((getDepartment() == null) ? 0 : getDepartment().hashCode());
        result = prime * result + ((getDuties() == null) ? 0 : getDuties().hashCode());
        result = prime * result + ((getPosition() == null) ? 0 : getPosition().hashCode());
        result = prime * result + ((getCorExe() == null) ? 0 : getCorExe().hashCode());
        result = prime * result + ((getBoardMem() == null) ? 0 : getBoardMem().hashCode());
        result = prime * result + ((getRelWithActualCon() == null) ? 0 : getRelWithActualCon().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getTotalLenSer() == null) ? 0 : getTotalLenSer().hashCode());
        result = prime * result + ((getCorpOrgCode() == null) ? 0 : getCorpOrgCode().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append("[");
        sb.append("Hash = ").append(hashCode());
		
		sb.append(", custId=").append(custId);
		sb.append(", lastOrgId=").append(lastOrgId);
		sb.append(", lastChgUsr=").append(lastChgUsr);
		sb.append(", lastChgDt=").append(lastChgDt);
		sb.append(", curWorkUnit=").append(curWorkUnit);
		sb.append(", unitConPer=").append(unitConPer);
		sb.append(", engInPro=").append(engInPro);
		sb.append(", unitNat=").append(unitNat);
		sb.append(", indOwnUnit=").append(indOwnUnit);
		sb.append(", department=").append(department);
		sb.append(", duties=").append(duties);
		sb.append(", position=").append(position);
		sb.append(", corExe=").append(corExe);
		sb.append(", boardMem=").append(boardMem);
		sb.append(", relWithActualCon=").append(relWithActualCon);
		sb.append(", title=").append(title);
		sb.append(", entryDate=").append(entryDate);
		sb.append(", totalLenSer=").append(totalLenSer);
		sb.append(", corpOrgCode=").append(corpOrgCode);
        sb.append("]");
        return sb.toString();
    }
}