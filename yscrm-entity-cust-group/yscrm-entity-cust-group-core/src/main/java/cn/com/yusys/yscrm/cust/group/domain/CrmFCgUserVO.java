package cn.com.yusys.yscrm.cust.group.domain;

import cn.com.yusys.yscrm.pcrm.common.remindInfo.utils.ExportEntityMap;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import java.io.Serializable;

;

@Entity
public class CrmFCgUserVO implements Serializable{

  private static final long serialVersionUID = 1350382040939802624L;


	/**
	 * 客户号
	 */
    @ApiModelProperty(value = "客户号")
    @ExportEntityMap(CnName="客户号",EnName="custId")
    private String custId;

	/**
	 * 客户中文姓名
	 */
    @ApiModelProperty(value = "客户中文姓名")
    @ExportEntityMap(CnName="客户中文姓名",EnName="custName")
    private String custName;

	/**
	 * 客户英文姓名
	 */
    @ApiModelProperty(value = "客户英文姓名")
    @ExportEntityMap(CnName="客户英文姓名",EnName="custEngName")
    private String custEngName;

	/**
	 * NDS号
	 */
    @ApiModelProperty(value = "NDS号")
    @ExportEntityMap(CnName="NDS号",EnName="ndsCustNo")
    private String ndsCustNo;

	/**
	 * 地区
	 */
    @ApiModelProperty(value = "地区")
    @ExportEntityMap(CnName="地区",EnName="nationality")
    private String nationality;

    @ApiModelProperty(value = "理财客户经理")
    @ExportEntityMap(CnName="理财客户经理",EnName="mgrNameOne")
    private String mgrNameOne;
    @ApiModelProperty(value = "个贷客户经理")
    @ExportEntityMap(CnName="个贷客户经理",EnName="mgrNameTwo")
    private String mgrNameTwo;
    @ApiModelProperty(value = "理财客户经理手机号")
    private String managePhoneNo;
    @ApiModelProperty(value = "个贷客户经理手机号")
    private String personalLoanPhoneNo;
    @ApiModelProperty(value = "开户机构")
    private String orgName;
    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustEngName() {
        return custEngName;
    }

    public void setCustEngName(String custEngName) {
        this.custEngName = custEngName;
    }

    public String getNdsCustNo() {
        return ndsCustNo;
    }

    public void setNdsCustNo(String ndsCustNo) {
        this.ndsCustNo = ndsCustNo;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getMgrNameOne() {
        return mgrNameOne;
    }

    public void setMgrNameOne(String mgrNameOne) {
        this.mgrNameOne = mgrNameOne;
    }

    public String getMgrNameTwo() {
        return mgrNameTwo;
    }

    public void setMgrNameTwo(String mgrNameTwo) {
        this.mgrNameTwo = mgrNameTwo;
    }

    public String getManagePhoneNo() {
        return managePhoneNo;
    }

    public void setManagePhoneNo(String managePhoneNo) {
        this.managePhoneNo = managePhoneNo;
    }

    public String getPersonalLoanPhoneNo() {
        return personalLoanPhoneNo;
    }

    public void setPersonalLoanPhoneNo(String personalLoanPhoneNo) {
        this.personalLoanPhoneNo = personalLoanPhoneNo;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }
}
