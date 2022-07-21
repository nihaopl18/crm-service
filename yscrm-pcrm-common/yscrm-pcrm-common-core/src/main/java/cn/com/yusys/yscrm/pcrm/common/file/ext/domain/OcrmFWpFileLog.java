package cn.com.yusys.yscrm.pcrm.common.file.ext.domain;

import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "ACRM_F_WP_REMIND_INFO")
public class OcrmFWpFileLog extends BaseDomain implements Serializable {
  private static final long serialVersionUID = 1L;

  /** 记录编号 **/
  @Column(name = "LOG_ID", unique = true, nullable = false, length = 50)
  private String logId;

  /** 操作者编号 **/
  @Column(name = "USER_ID", unique = false, nullable = true, length = 50)
  private String userId;

  /** 操作者名称 **/
  @Column(name = "USER_NAME", unique = false, nullable = true, length = 50)
  private String userName;

  /** 操作时间 **/
  @Column(name = "OPER_TIME", unique = false, nullable = true, length = 50)
  private String operTime;

  /** 操作业务ID **/
  @Column(name = "OPER_BUSI_ID", unique = false, nullable = true, length = 50)
  private String operBusiId;

  /** 操作对象ID **/
  @Column(name = "OPER_OBJ_ID", unique = false, nullable = true, length = 50)
  private String operObjId;

  /** 操作类型 **/
  @Column(name = "OPER_FLAG", unique = false, nullable = true, length = 50)
  private String operFlag;

  public String getLogId() {
    return logId;
  }

  public void setLogId(String logId) {
    this.logId = logId == null ? null : logId;
  }


  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId == null ? null : userId;
  }


  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName == null ? null : userName;
  }


  public String getOperTime() {
    return operTime;
  }

  public void setOperTime(String operTime) {
    this.operTime = operTime == null ? null : operTime;
  }


  public String getOperBusiId() {
    return operBusiId;
  }

  public void setOperBusiId(String operBusiId) {
    this.operBusiId = operBusiId == null ? null : operBusiId;
  }


  public String getOperObjId() {
    return operObjId;
  }

  public void setOperObjId(String operObjId) {
    this.operObjId = operObjId == null ? null : operObjId;
  }


  public String getOperFlag() {
    return operFlag;
  }

  public void setOperFlag(String operFlag) {
    this.operFlag = operFlag == null ? null : operFlag;
  }

}
