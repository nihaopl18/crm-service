package cn.com.yusys.yscrm.custflexEs.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

;

@Entity
@Table(name = "OCRM_F_ES_EXPORT_QUERY")
public class EsExportQuerycondition implements Serializable{

  private static final long serialVersionUID = 1650545428142808064L;

	/**
	 * 组件类型
	 */
  private String ssColType;

	/**
	 * 操作符值
	 */
  private String ssColOp;

	/**
	 * 字段名称
	 */
  private String ssColEname;

	/**
	 * 属性值
	 */
  private String ssColValue;

	/**
	 * 理财客户经理编号
	 */
  private String finCustManagerN0;

	/**
	 * 理财客户经理名称
	 */
  private String finCustmanagerName;

	/**
	 * 个贷客户经理编号
	 */
  private String loanCustManagerN0;

	/**
	 * 个贷客户经理名称
	 */
  private String loanCustManagerName;

	/**
	 * 理财机构编码
	 */
  private String finBelongOrgNo;

	/**
	 * 理财机构名称
	 */
  private String finBelongOrgName;

	/**
	 * 个贷机构编码
	 */
  private String loanBelongOrgNo;

	/**
	 * 个贷机构名称
	 */
  private String loanBelongOrgName;

    /**
     * 查询类型（01：业务模式：02：excel导入模式）
     */
    private String conditionType;


    public String getSsColType() {
        return ssColType;
    }

    public void setSsColType(String ssColType) {
        this.ssColType = ssColType;
    }

    public String getSsColOp() {
        return ssColOp;
    }

    public void setSsColOp(String ssColOp) {
        this.ssColOp = ssColOp;
    }

    public String getSsColEname() {
        return ssColEname;
    }

    public void setSsColEname(String ssColEname) {
        this.ssColEname = ssColEname;
    }

    public String getSsColValue() {
        return ssColValue;
    }

    public void setSsColValue(String ssColValue) {
        this.ssColValue = ssColValue;
    }

    public String getFinCustManagerN0() {
        return finCustManagerN0;
    }

    public void setFinCustManagerN0(String finCustManagerN0) {
        this.finCustManagerN0 = finCustManagerN0;
    }

    public String getFinCustmanagerName() {
        return finCustmanagerName;
    }

    public void setFinCustmanagerName(String finCustmanagerName) {
        this.finCustmanagerName = finCustmanagerName;
    }

    public String getLoanCustManagerN0() {
        return loanCustManagerN0;
    }

    public void setLoanCustManagerN0(String loanCustManagerN0) {
        this.loanCustManagerN0 = loanCustManagerN0;
    }

    public String getLoanCustManagerName() {
        return loanCustManagerName;
    }

    public void setLoanCustManagerName(String loanCustManagerName) {
        this.loanCustManagerName = loanCustManagerName;
    }

    public String getFinBelongOrgNo() {
        return finBelongOrgNo;
    }

    public void setFinBelongOrgNo(String finBelongOrgNo) {
        this.finBelongOrgNo = finBelongOrgNo;
    }

    public String getFinBelongOrgName() {
        return finBelongOrgName;
    }

    public void setFinBelongOrgName(String finBelongOrgName) {
        this.finBelongOrgName = finBelongOrgName;
    }

    public String getLoanBelongOrgNo() {
        return loanBelongOrgNo;
    }

    public void setLoanBelongOrgNo(String loanBelongOrgNo) {
        this.loanBelongOrgNo = loanBelongOrgNo;
    }

    public String getLoanBelongOrgName() {
        return loanBelongOrgName;
    }

    public void setLoanBelongOrgName(String loanBelongOrgName) {
        this.loanBelongOrgName = loanBelongOrgName;
    }

    public String getConditionType() {
        return conditionType;
    }

    public void setConditionType(String conditionType) {
        this.conditionType = conditionType;
    }
}
