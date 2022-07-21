package cn.com.yusys.yscrm.sysview.domain;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "OCRM_F_CI_USER_ASSETS")
public class CrmFCiUserAssetsVO implements Serializable{

  private static final long serialVersionUID = 1120957098309067264L;



	/**
	 * 客户号
	 */
    @ApiModelProperty(value = "客户号")
  private String custId;

	/**
	 * 房产数量
	 */
    @ApiModelProperty(value = "房产数量")
  private int houseCount;

    @ApiModelProperty(value = "房产明细")
    private List<CiUserAssetsDTO> ciUserAssetsDTOlist=new ArrayList<>();

    @ApiModelProperty(value = "基础维护信息")
    private CrmFCiUserInformation crmFCiUserInformation;
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

    private String status;

    /**
     * id
     */
    @ApiModelProperty(value = "id")
    private String seqno;
    /**
     * 流程id
     */
    private String instanceid;
    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public int getHouseCount() {
        return houseCount;
    }

    public void setHouseCount(int houseCount) {
        this.houseCount = houseCount;
    }

    public List<CiUserAssetsDTO> getCiUserAssetsDTOlist() {
        return ciUserAssetsDTOlist;
    }

    public void setCiUserAssetsDTOlist(List<CiUserAssetsDTO> ciUserAssetsDTOlist) {
        this.ciUserAssetsDTOlist = ciUserAssetsDTOlist;
    }

    public CrmFCiUserInformation getCrmFCiUserInformation() {
        return crmFCiUserInformation;
    }

    public void setCrmFCiUserInformation(CrmFCiUserInformation crmFCiUserInformation) {
        this.crmFCiUserInformation = crmFCiUserInformation;
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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getSeqno() {
        return seqno;
    }

    public void setSeqno(String seqno) {
        this.seqno = seqno;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getInstanceid() {
        return instanceid;
    }

    public void setInstanceid(String instanceid) {
        this.instanceid = instanceid;
    }
}
