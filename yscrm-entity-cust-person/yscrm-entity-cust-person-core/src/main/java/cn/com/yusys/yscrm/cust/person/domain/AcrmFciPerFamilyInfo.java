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
 * @类名称: AcrmFciPerFamilyInfo
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2019-01-29 10:39:35
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "ACRM_F_CI_PER_FAMILY_INFO")
public class AcrmFciPerFamilyInfo extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	/** ID主键
 **/
	@Id
	@Column(name = "CUST_ID", unique = false, nullable = true, length = 40)
	@Generated(GenerationType.UUID)
	private String custId;
	
	/** 数据日期
 **/
	@Column(name = "DATA_DATE", unique = false, nullable = true, length = 8)
	private String dataDate;
	
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
	
	@Column(name = "LAST_CHG_DT", unique = false, nullable = true, length = 11)
	private Date lastChgDt;
	
	/** 法人
 **/
	@Column(name = "CORP_ORG_CODE", unique = false, nullable = true, length = 20)
	private String corpOrgCode;

	/** 调查年份
 **/
	@Column(name = "SUR_YEAR", unique = false, nullable = true, length = 8)
	private String surYear;
	
	/** 家庭地址
 **/
	@Column(name = "FAM_ADDR", unique = false, nullable = true, length = 200)
	private String famAddr;
	
	/** 固定电话
 **/
	@Column(name = "HOME_TEL_NO", unique = false, nullable = true, length = 30)
	private String homeTelNo;
	
	/** 总人口数量
 **/
	@Column(name = "POPU_NUM", unique = false, nullable = true, length = 38)
	private java.math.BigDecimal popuNum;
	
	/** 劳动力人数
 **/
	@Column(name = "LABOR_NUM", unique = false, nullable = true, length = 38)
	private java.math.BigDecimal laborNum;
	
	/** 户主姓名
 **/
	@Column(name = "HOUSEHOLDER_NAME", unique = false, nullable = true, length = 200)
	private String householderName;
	
	/** 住宅情况
 **/
	@Column(name = "HOUSE_STAT", unique = false, nullable = true, length = 20)
	private String houseStat;
	
	/** 是否有私家车
 **/
	@Column(name = "CAR_FLG", unique = false, nullable = true, length = 20)
	private String carFlg;
	
	/** 是否授信
 **/
	@Column(name = "FAM_CREDIT_FLG", unique = false, nullable = true, length = 20)
	private String famCreditFlg;
	
	/** 家庭和睦
 **/
	@Column(name = "HARMONY_DESC", unique = false, nullable = true, length = 100)
	private String harmonyDesc;
	
	/** 授信金额
 **/
	@Column(name = "CREDIT_AMT", unique = false, nullable = true, length = 22)
	private java.math.BigDecimal creditAmt;
	
	/** 信用情况
 **/
	@Column(name = "CREDIT_REC", unique = false, nullable = true, length = 100)
	private String creditRec;
	
	/** 经营项目及规模
 **/
	@Column(name = "ITEM_AND_SCAL", unique = false, nullable = true, length = 100)
	private String itemAndScal;
	
	/** 负债情况
 **/
	@Column(name = "FAM_DEBT_REC", unique = false, nullable = true, length = 200)
	private String famDebtRec;
	
	/** 不良记录
 **/
	@Column(name = "FAM_BAD_REC", unique = false, nullable = true, length = 200)
	private String famBadRec;
	
	/** 国家地区区号
 **/
	@Column(name = "COUNT_AREA_CD", unique = false, nullable = true, length = 20)
	private String countAreaCd;
	
	/** 其他
 **/
	@Column(name = "OTHERS", unique = false, nullable = true, length = 200)
	private String others;
	
	/** 家庭经济实力
 **/
	@Column(name = "FAM_ECON_STAT", unique = false, nullable = true, length = 200)
	private String famEconStat;
	
	/** 村组评价
 **/
	@Column(name = "VILLAGE_EVAL", unique = false, nullable = true, length = 200)
	private String villageEval;
	
	/** 私家车牌号1
 **/
	@Column(name = "PLATE_NO1", unique = false, nullable = true, length = 30)
	private String plateNo1;
	
	/** 私家车牌号2
 **/
	@Column(name = "PLATE_NO2", unique = false, nullable = true, length = 30)
	private String plateNo2;
	
	/** 私家车牌号3
 **/
	@Column(name = "PLATE_NO3", unique = false, nullable = true, length = 30)
	private String plateNo3;
	
	/** 车险到期日1
 **/
	@Column(name = "CAR_INSUR_DT1", unique = false, nullable = true, length = 8)
	private String carInsurDt1;
	
	/** 车险到期日2
 **/
	@Column(name = "CAR_INSUR_DT2", unique = false, nullable = true, length = 8)
	private String carInsurDt2;
	
	/** 车险到期日3
 **/
	@Column(name = "CAR_INSUR_DT3", unique = false, nullable = true, length = 8)
	private String carInsurDt3;
	
	/** 家庭月均收入
 **/
	@Column(name = "FAM_INC_AVG", unique = false, nullable = true, length = 22)
	private java.math.BigDecimal famIncAvg;
	
	/** 个人月均收入
 **/
	@Column(name = "PER_INC_AVG", unique = false, nullable = true, length = 22)
	private java.math.BigDecimal perIncAvg;
	
	/** 个人年收入
 **/
	@Column(name = "PER_INC_Y", unique = false, nullable = true, length = 22)
	private java.math.BigDecimal perIncY;
	
	/** 家庭年收入
 **/
	@Column(name = "FAM_INC_Y", unique = false, nullable = true, length = 22)
	private java.math.BigDecimal famIncY;
	
	/** 备注
 **/
	@Column(name = "REMARK", unique = false, nullable = true, length = 200)
	private String remark;
	
	public String getDataDate() {
		return dataDate;
	}

	public void sette(String dataDate) {
		this.dataDate = dataDate;
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
	 * @param surYear
	 */
	public void setSurYear(String surYear) {
		this.surYear = surYear == null ? null : surYear.trim();
	}
	
    /**
     * @return SurYear
     */	
	public String getSurYear() {
		return this.surYear;
	}
	
	/**
	 * @param famAddr
	 */
	public void setFamAddr(String famAddr) {
		this.famAddr = famAddr == null ? null : famAddr.trim();
	}
	
    /**
     * @return FamAddr
     */	
	public String getFamAddr() {
		return this.famAddr;
	}
	
	/**
	 * @param homeTelNo
	 */
	public void setHomeTelNo(String homeTelNo) {
		this.homeTelNo = homeTelNo == null ? null : homeTelNo.trim();
	}
	
    /**
     * @return HomeTelNo
     */	
	public String getHomeTelNo() {
		return this.homeTelNo;
	}
	
	/**
	 * @param popuNum
	 */
	public void setPopuNum(java.math.BigDecimal popuNum) {
		this.popuNum = popuNum;
	}
	
    /**
     * @return PopuNum
     */	
	public java.math.BigDecimal getPopuNum() {
		return this.popuNum;
	}
	
	/**
	 * @param laborNum
	 */
	public void setLaborNum(java.math.BigDecimal laborNum) {
		this.laborNum = laborNum;
	}
	
    /**
     * @return LaborNum
     */	
	public java.math.BigDecimal getLaborNum() {
		return this.laborNum;
	}
	
	/**
	 * @param householderName
	 */
	public void setHouseholderName(String householderName) {
		this.householderName = householderName == null ? null : householderName.trim();
	}
	
    /**
     * @return HouseholderName
     */	
	public String getHouseholderName() {
		return this.householderName;
	}
	
	/**
	 * @param houseStat
	 */
	public void setHouseStat(String houseStat) {
		this.houseStat = houseStat == null ? null : houseStat.trim();
	}
	
    /**
     * @return HouseStat
     */	
	public String getHouseStat() {
		return this.houseStat;
	}
	
	/**
	 * @param carFlg
	 */
	public void setCarFlg(String carFlg) {
		this.carFlg = carFlg == null ? null : carFlg.trim();
	}
	
    /**
     * @return CarFlg
     */	
	public String getCarFlg() {
		return this.carFlg;
	}
	
	/**
	 * @param famCreditFlg
	 */
	public void setFamCreditFlg(String famCreditFlg) {
		this.famCreditFlg = famCreditFlg == null ? null : famCreditFlg.trim();
	}
	
    /**
     * @return FamCreditFlg
     */	
	public String getFamCreditFlg() {
		return this.famCreditFlg;
	}
	
	/**
	 * @param harmonyDesc
	 */
	public void setHarmonyDesc(String harmonyDesc) {
		this.harmonyDesc = harmonyDesc == null ? null : harmonyDesc.trim();
	}
	
    /**
     * @return HarmonyDesc
     */	
	public String getHarmonyDesc() {
		return this.harmonyDesc;
	}
	
	/**
	 * @param creditAmt
	 */
	public void setCreditAmt(java.math.BigDecimal creditAmt) {
		this.creditAmt = creditAmt;
	}
	
    /**
     * @return CreditAmt
     */	
	public java.math.BigDecimal getCreditAmt() {
		return this.creditAmt;
	}
	
	/**
	 * @param creditRec
	 */
	public void setCreditRec(String creditRec) {
		this.creditRec = creditRec == null ? null : creditRec.trim();
	}
	
    /**
     * @return CreditRec
     */	
	public String getCreditRec() {
		return this.creditRec;
	}
	
	/**
	 * @param itemAndScal
	 */
	public void setItemAndScal(String itemAndScal) {
		this.itemAndScal = itemAndScal == null ? null : itemAndScal.trim();
	}
	
    /**
     * @return ItemAndScal
     */	
	public String getItemAndScal() {
		return this.itemAndScal;
	}
	
	/**
	 * @param famDebtRec
	 */
	public void setFamDebtRec(String famDebtRec) {
		this.famDebtRec = famDebtRec == null ? null : famDebtRec.trim();
	}
	
    /**
     * @return FamDebtRec
     */	
	public String getFamDebtRec() {
		return this.famDebtRec;
	}
	
	/**
	 * @param famBadRec
	 */
	public void setFamBadRec(String famBadRec) {
		this.famBadRec = famBadRec == null ? null : famBadRec.trim();
	}
	
    /**
     * @return FamBadRec
     */	
	public String getFamBadRec() {
		return this.famBadRec;
	}
	
	/**
	 * @param countAreaCd
	 */
	public void setCountAreaCd(String countAreaCd) {
		this.countAreaCd = countAreaCd == null ? null : countAreaCd.trim();
	}
	
    /**
     * @return CountAreaCd
     */	
	public String getCountAreaCd() {
		return this.countAreaCd;
	}
	
	/**
	 * @param others
	 */
	public void setOthers(String others) {
		this.others = others == null ? null : others.trim();
	}
	
    /**
     * @return Others
     */	
	public String getOthers() {
		return this.others;
	}
	
	/**
	 * @param famEconStat
	 */
	public void setFamEconStat(String famEconStat) {
		this.famEconStat = famEconStat == null ? null : famEconStat.trim();
	}
	
    /**
     * @return FamEconStat
     */	
	public String getFamEconStat() {
		return this.famEconStat;
	}
	
	/**
	 * @param villageEval
	 */
	public void setVillageEval(String villageEval) {
		this.villageEval = villageEval == null ? null : villageEval.trim();
	}
	
    /**
     * @return VillageEval
     */	
	public String getVillageEval() {
		return this.villageEval;
	}
	
	/**
	 * @param plateNo1
	 */
	public void setPlateNo1(String plateNo1) {
		this.plateNo1 = plateNo1 == null ? null : plateNo1.trim();
	}
	
    /**
     * @return PlateNo1
     */	
	public String getPlateNo1() {
		return this.plateNo1;
	}
	
	/**
	 * @param plateNo2
	 */
	public void setPlateNo2(String plateNo2) {
		this.plateNo2 = plateNo2 == null ? null : plateNo2.trim();
	}
	
    /**
     * @return PlateNo2
     */	
	public String getPlateNo2() {
		return this.plateNo2;
	}
	
	/**
	 * @param plateNo3
	 */
	public void setPlateNo3(String plateNo3) {
		this.plateNo3 = plateNo3 == null ? null : plateNo3.trim();
	}
	
    /**
     * @return PlateNo3
     */	
	public String getPlateNo3() {
		return this.plateNo3;
	}
	
	/**
	 * @param carInsurDt1
	 */
	public void setCarInsurDt1(String carInsurDt1) {
		this.carInsurDt1 = carInsurDt1 == null ? null : carInsurDt1.trim();
	}
	
    /**
     * @return CarInsurDt1
     */	
	public String getCarInsurDt1() {
		return this.carInsurDt1;
	}
	
	/**
	 * @param carInsurDt2
	 */
	public void setCarInsurDt2(String carInsurDt2) {
		this.carInsurDt2 = carInsurDt2 == null ? null : carInsurDt2.trim();
	}
	
    /**
     * @return CarInsurDt2
     */	
	public String getCarInsurDt2() {
		return this.carInsurDt2;
	}
	
	/**
	 * @param carInsurDt3
	 */
	public void setCarInsurDt3(String carInsurDt3) {
		this.carInsurDt3 = carInsurDt3 == null ? null : carInsurDt3.trim();
	}
	
    /**
     * @return CarInsurDt3
     */	
	public String getCarInsurDt3() {
		return this.carInsurDt3;
	}
	
	/**
	 * @param famIncAvg
	 */
	public void setFamIncAvg(java.math.BigDecimal famIncAvg) {
		this.famIncAvg = famIncAvg;
	}
	
    /**
     * @return FamIncAvg
     */	
	public java.math.BigDecimal getFamIncAvg() {
		return this.famIncAvg;
	}
	
	/**
	 * @param perIncAvg
	 */
	public void setPerIncAvg(java.math.BigDecimal perIncAvg) {
		this.perIncAvg = perIncAvg;
	}
	
    /**
     * @return PerIncAvg
     */	
	public java.math.BigDecimal getPerIncAvg() {
		return this.perIncAvg;
	}
	
	/**
	 * @param perIncY
	 */
	public void setPerIncY(java.math.BigDecimal perIncY) {
		this.perIncY = perIncY;
	}
	
    /**
     * @return PerIncY
     */	
	public java.math.BigDecimal getPerIncY() {
		return this.perIncY;
	}
	
	/**
	 * @param famIncY
	 */
	public void setFamIncY(java.math.BigDecimal famIncY) {
		this.famIncY = famIncY;
	}
	
    /**
     * @return FamIncY
     */	
	public java.math.BigDecimal getFamIncY() {
		return this.famIncY;
	}
	
	/**
	 * @param remark
	 */
	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}
	
    /**
     * @return Remark
     */	
	public String getRemark() {
		return this.remark;
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
        AcrmFciPerFamilyInfo other = (AcrmFciPerFamilyInfo) that;
		return (this.getDataDate() == null ? other.getDataDate() == null : this.getDataDate().equals(other.getDataDate()))
        	&& (this.getLastChgSys() == null ? other.getLastChgSys() == null : this.getLastChgSys().equals(other.getLastChgSys()))
        	&& (this.getLastChgUsr() == null ? other.getLastChgUsr() == null : this.getLastChgUsr().equals(other.getLastChgUsr()))
                	&& (this.getCorpOrgCode() == null ? other.getCorpOrgCode() == null : this.getCorpOrgCode().equals(other.getCorpOrgCode()))
        	&& (this.getCustId() == null ? other.getCustId() == null : this.getCustId().equals(other.getCustId()))
        	&& (this.getSurYear() == null ? other.getSurYear() == null : this.getSurYear().equals(other.getSurYear()))
        	&& (this.getFamAddr() == null ? other.getFamAddr() == null : this.getFamAddr().equals(other.getFamAddr()))
        	&& (this.getHomeTelNo() == null ? other.getHomeTelNo() == null : this.getHomeTelNo().equals(other.getHomeTelNo()))
                        	&& (this.getHouseholderName() == null ? other.getHouseholderName() == null : this.getHouseholderName().equals(other.getHouseholderName()))
        	&& (this.getHouseStat() == null ? other.getHouseStat() == null : this.getHouseStat().equals(other.getHouseStat()))
        	&& (this.getCarFlg() == null ? other.getCarFlg() == null : this.getCarFlg().equals(other.getCarFlg()))
        	&& (this.getFamCreditFlg() == null ? other.getFamCreditFlg() == null : this.getFamCreditFlg().equals(other.getFamCreditFlg()))
        	&& (this.getHarmonyDesc() == null ? other.getHarmonyDesc() == null : this.getHarmonyDesc().equals(other.getHarmonyDesc()))
                	&& (this.getCreditRec() == null ? other.getCreditRec() == null : this.getCreditRec().equals(other.getCreditRec()))
        	&& (this.getItemAndScal() == null ? other.getItemAndScal() == null : this.getItemAndScal().equals(other.getItemAndScal()))
        	&& (this.getFamDebtRec() == null ? other.getFamDebtRec() == null : this.getFamDebtRec().equals(other.getFamDebtRec()))
        	&& (this.getFamBadRec() == null ? other.getFamBadRec() == null : this.getFamBadRec().equals(other.getFamBadRec()))
        	&& (this.getCountAreaCd() == null ? other.getCountAreaCd() == null : this.getCountAreaCd().equals(other.getCountAreaCd()))
        	&& (this.getOthers() == null ? other.getOthers() == null : this.getOthers().equals(other.getOthers()))
        	&& (this.getFamEconStat() == null ? other.getFamEconStat() == null : this.getFamEconStat().equals(other.getFamEconStat()))
        	&& (this.getVillageEval() == null ? other.getVillageEval() == null : this.getVillageEval().equals(other.getVillageEval()))
        	&& (this.getPlateNo1() == null ? other.getPlateNo1() == null : this.getPlateNo1().equals(other.getPlateNo1()))
        	&& (this.getPlateNo2() == null ? other.getPlateNo2() == null : this.getPlateNo2().equals(other.getPlateNo2()))
        	&& (this.getPlateNo3() == null ? other.getPlateNo3() == null : this.getPlateNo3().equals(other.getPlateNo3()))
        	&& (this.getCarInsurDt1() == null ? other.getCarInsurDt1() == null : this.getCarInsurDt1().equals(other.getCarInsurDt1()))
        	&& (this.getCarInsurDt2() == null ? other.getCarInsurDt2() == null : this.getCarInsurDt2().equals(other.getCarInsurDt2()))
        	&& (this.getCarInsurDt3() == null ? other.getCarInsurDt3() == null : this.getCarInsurDt3().equals(other.getCarInsurDt3()))
                                        	&& (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
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
        result = prime * result + ((getSurYear() == null) ? 0 : getSurYear().hashCode());
        result = prime * result + ((getFamAddr() == null) ? 0 : getFamAddr().hashCode());
        result = prime * result + ((getHomeTelNo() == null) ? 0 : getHomeTelNo().hashCode());
        result = prime * result + ((getHouseholderName() == null) ? 0 : getHouseholderName().hashCode());
        result = prime * result + ((getHouseStat() == null) ? 0 : getHouseStat().hashCode());
        result = prime * result + ((getCarFlg() == null) ? 0 : getCarFlg().hashCode());
        result = prime * result + ((getFamCreditFlg() == null) ? 0 : getFamCreditFlg().hashCode());
        result = prime * result + ((getHarmonyDesc() == null) ? 0 : getHarmonyDesc().hashCode());
        result = prime * result + ((getCreditRec() == null) ? 0 : getCreditRec().hashCode());
        result = prime * result + ((getItemAndScal() == null) ? 0 : getItemAndScal().hashCode());
        result = prime * result + ((getFamDebtRec() == null) ? 0 : getFamDebtRec().hashCode());
        result = prime * result + ((getFamBadRec() == null) ? 0 : getFamBadRec().hashCode());
        result = prime * result + ((getCountAreaCd() == null) ? 0 : getCountAreaCd().hashCode());
        result = prime * result + ((getOthers() == null) ? 0 : getOthers().hashCode());
        result = prime * result + ((getFamEconStat() == null) ? 0 : getFamEconStat().hashCode());
        result = prime * result + ((getVillageEval() == null) ? 0 : getVillageEval().hashCode());
        result = prime * result + ((getPlateNo1() == null) ? 0 : getPlateNo1().hashCode());
        result = prime * result + ((getPlateNo2() == null) ? 0 : getPlateNo2().hashCode());
        result = prime * result + ((getPlateNo3() == null) ? 0 : getPlateNo3().hashCode());
        result = prime * result + ((getCarInsurDt1() == null) ? 0 : getCarInsurDt1().hashCode());
        result = prime * result + ((getCarInsurDt2() == null) ? 0 : getCarInsurDt2().hashCode());
        result = prime * result + ((getCarInsurDt3() == null) ? 0 : getCarInsurDt3().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
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
		sb.append(", surYear=").append(surYear);
		sb.append(", famAddr=").append(famAddr);
		sb.append(", homeTelNo=").append(homeTelNo);
		sb.append(", popuNum=").append(popuNum);
		sb.append(", laborNum=").append(laborNum);
		sb.append(", householderName=").append(householderName);
		sb.append(", houseStat=").append(houseStat);
		sb.append(", carFlg=").append(carFlg);
		sb.append(", famCreditFlg=").append(famCreditFlg);
		sb.append(", harmonyDesc=").append(harmonyDesc);
		sb.append(", creditAmt=").append(creditAmt);
		sb.append(", creditRec=").append(creditRec);
		sb.append(", itemAndScal=").append(itemAndScal);
		sb.append(", famDebtRec=").append(famDebtRec);
		sb.append(", famBadRec=").append(famBadRec);
		sb.append(", countAreaCd=").append(countAreaCd);
		sb.append(", others=").append(others);
		sb.append(", famEconStat=").append(famEconStat);
		sb.append(", villageEval=").append(villageEval);
		sb.append(", plateNo1=").append(plateNo1);
		sb.append(", plateNo2=").append(plateNo2);
		sb.append(", plateNo3=").append(plateNo3);
		sb.append(", carInsurDt1=").append(carInsurDt1);
		sb.append(", carInsurDt2=").append(carInsurDt2);
		sb.append(", carInsurDt3=").append(carInsurDt3);
		sb.append(", famIncAvg=").append(famIncAvg);
		sb.append(", perIncAvg=").append(perIncAvg);
		sb.append(", perIncY=").append(perIncY);
		sb.append(", famIncY=").append(famIncY);
		sb.append(", remark=").append(remark);
        sb.append("]");
        return sb.toString();
    }
}