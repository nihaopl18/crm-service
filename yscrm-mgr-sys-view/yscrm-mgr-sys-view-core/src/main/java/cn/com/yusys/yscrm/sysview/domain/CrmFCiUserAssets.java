package cn.com.yusys.yscrm.sysview.domain;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "OCRM_F_CI_USER_ASSETS")
public class CrmFCiUserAssets implements Serializable{

  private static final long serialVersionUID = 1120957098309067264L;

	/**
	 * id
	 */
    @ApiModelProperty(value = "id")
  private String seqno;

	/**
	 * 客户号
	 */
    @ApiModelProperty(value = "客户号")
  private String custId;

	/**
	 * 房产数量
	 */
    @ApiModelProperty(value = "房产数量")
  private String houseCount;

	/**
	 * 房产抵押状况
	 */
    @ApiModelProperty(value = "房产抵押状况")
  private String houseInfo;

	/**
	 * 购置时间
	 */
    @ApiModelProperty(value = "购置时间")
  private String purDt;

	/**
	 * 购置原价
	 */
    @ApiModelProperty(value = "购置原价")
  private String purPrc;

	/**
	 * 收入来源
	 */
    @ApiModelProperty(value = "收入来源")
  private String incomeSrc;

	/**
	 * 年收入
	 */
    @ApiModelProperty(value = "年收入")
  private String incomeY;

	/**
	 * 工资账户开户行
	 */
    @ApiModelProperty(value = "工资账户开户行")
  private String salAcctBank;

	/**
	 * 投资周期
	 */
    @ApiModelProperty(value = "投资周期")
  private String unvCyc;

	/**
	 * 车辆情况
	 */
    @ApiModelProperty(value = "车辆情况")
  private String carFlg;

	/**
	 * 投资偏好
	 */
    @ApiModelProperty(value = "投资偏好")
  private String invCd;

	/**
	 * 是否生效(01 生效 02 已删除)
	 */
    @ApiModelProperty(value = "是否生效(01 生效 02 已删除)")
  private String isFlag;

	/**
	 * 维护时间
	 */
    @ApiModelProperty(value = "维护时间")
  private java.util.Date createDate;

	/**
	 * 维护人
	 */
    @ApiModelProperty(value = "维护人")
  private String createUser;

    /**
     * 状态（01草稿 02审批中 03 退回 04 生效）
     */
    @ApiModelProperty(value = "状态（01草稿 02审批中 03 退回 04 生效）")
    private String status;
  public String getSeqno() {
    return seqno;
  }

  public void setSeqno(String seqno) {
    this.seqno = seqno;
  }


  public String getCustId() {
    return custId;
  }

  public void setCustId(String custId) {
    this.custId = custId;
  }


  public String getHouseCount() {
    return houseCount;
  }

  public void setHouseCount(String houseCount) {
    this.houseCount = houseCount;
  }


  public String getHouseInfo() {
    return houseInfo;
  }

  public void setHouseInfo(String houseInfo) {
    this.houseInfo = houseInfo;
  }


  public String getPurDt() {
    return purDt;
  }

  public void setPurDt(String purDt) {
    this.purDt = purDt;
  }


  public String getPurPrc() {
    return purPrc;
  }

  public void setPurPrc(String purPrc) {
    this.purPrc = purPrc;
  }


  public String getIncomeSrc() {
    return incomeSrc;
  }

  public void setIncomeSrc(String incomeSrc) {
    this.incomeSrc = incomeSrc;
  }


  public String getIncomeY() {
    return incomeY;
  }

  public void setIncomeY(String incomeY) {
    this.incomeY = incomeY;
  }


  public String getSalAcctBank() {
    return salAcctBank;
  }

  public void setSalAcctBank(String salAcctBank) {
    this.salAcctBank = salAcctBank;
  }


  public String getUnvCyc() {
    return unvCyc;
  }

  public void setUnvCyc(String unvCyc) {
    this.unvCyc = unvCyc;
  }


  public String getCarFlg() {
    return carFlg;
  }

  public void setCarFlg(String carFlg) {
    this.carFlg = carFlg;
  }


  public String getInvCd() {
    return invCd;
  }

  public void setInvCd(String invCd) {
    this.invCd = invCd;
  }


  public String getIsFlag() {
    return isFlag;
  }

  public void setIsFlag(String isFlag) {
    this.isFlag = isFlag;
  }


  public java.util.Date getCreateDate() {
    return createDate;
  }

  public void setCreateDate(java.util.Date createDate) {
    this.createDate = createDate;
  }


  public String getCreateUser() {
    return createUser;
  }

  public void setCreateUser(String createUser) {
    this.createUser = createUser;
  }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
