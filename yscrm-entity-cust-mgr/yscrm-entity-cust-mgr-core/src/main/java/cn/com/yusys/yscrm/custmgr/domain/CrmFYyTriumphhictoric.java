package cn.com.yusys.yscrm.custmgr.domain;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
public class CrmFYyTriumphhictoric implements Serializable{

  private static final long serialVersionUID = 1493642054106877440L;

	/**
	 * id
	 */
  private String seqno;

	/**
	 * 指标编号(01:存款日均净增 02:AUM余额净增 03:合格优惠及以上客户数 04:合格优惠及以上客户数净增 05:贷款放款量 06:优质按揭客户数 07:模拟PPOP)
	 */
  private String triumphId;

	/**
	 * 指标名称
	 */
  private String triumphName;

	/**
	 * 层级(0：总行管理 1:总行理财个贷主管  2：分行 3：支行 4：团队 5：客户经理)
	 */
  private String triumphLevel;

	/**
	 * 对象id （层级为0 对象id 为总行机构编码 层级为1,对象id为总行理财个贷主管角色编码 层级为2 对象id为分行机构编码
 层级为3 对象id为支行机构编码 层级为4 对象id为团队编码 层级为5 对象id为客户经理编码）
	 */
  private String targetId;

	/**
	 * 对象名称 （层级为0 对象id 为总行机构名称 层级为1,对象名称为总行理财个贷主管角色名称 层级为2 对象id为分行机构名称
 层级为3 对象id为支行机构名称 层级为4 对象id为团队名称 层级为5 对象id为客户经理名称）
	 */
  private String targetName;

	/**
	 * 数额
	 */
  private String amount;

	/**
	 * 分配所属条线（1 理财 2 个贷）
	 */
  private String triumphLine;


	/**
	 * 更新人
	 */
  private String updateUser;

	/**
	 * 更新时间
	 */
  private java.util.Date updateDate;


  public String getSeqno() {
    return seqno;
  }

  public void setSeqno(String seqno) {
    this.seqno = seqno;
  }


  public String getTriumphId() {
    return triumphId;
  }

  public void setTriumphId(String triumphId) {
    this.triumphId = triumphId;
  }


  public String getTriumphName() {
    return triumphName;
  }

  public void setTriumphName(String triumphName) {
    this.triumphName = triumphName;
  }


  public String getTriumphLevel() {
    return triumphLevel;
  }

  public void setTriumphLevel(String triumphLevel) {
    this.triumphLevel = triumphLevel;
  }


  public String getTargetId() {
    return targetId;
  }

  public void setTargetId(String targetId) {
    this.targetId = targetId;
  }


  public String getTargetName() {
    return targetName;
  }

  public void setTargetName(String targetName) {
    this.targetName = targetName;
  }


  public String getAmount() {
    return amount;
  }

  public void setAmount(String amount) {
    this.amount = amount;
  }


  public String getTriumphLine() {
    return triumphLine;
  }

  public void setTriumphLine(String triumphLine) {
    this.triumphLine = triumphLine;
  }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public java.util.Date getUpdateDate() {
    return updateDate;
  }

  public void setUpdateDate(java.util.Date updateDate) {
    this.updateDate = updateDate;
  }

}
