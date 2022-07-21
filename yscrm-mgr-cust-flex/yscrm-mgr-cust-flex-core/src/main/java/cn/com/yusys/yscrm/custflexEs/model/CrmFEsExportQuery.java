package cn.com.yusys.yscrm.custflexEs.model;;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "OCRM_F_ES_EXPORT_QUERY")
public class CrmFEsExportQuery implements Serializable{

  private static final long serialVersionUID = 1650545428142808064L;

	/**
	 * id
	 */
  private String seqno;

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
  private String finCustManagerName;

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
	 * 创建人
	 */
  private String createUser;

	/**
	 * 创建时间
	 */
  private String createDate;

	/**
	 * 状态
	 */
  private String status;

	/**
	 * 流程id
	 */
  private String instanceId;
    /**
     * 展示列集合
     */
    private String  spread;

    /**
     * sortType
     */
    private String sortType;

    /**
     * columnEName
     */
    private String columnEName;

    /**
     * fieldType
     */
    private String fieldType;
    /**
     * 密码
     */
    private String password;

    /**
     * 查询类型（01：业务模式：02：excel导入模式）
     */
    private String conditionType;


    public String getFieldType() {
        return fieldType;
    }

    public void setFieldType(String fieldType) {
        this.fieldType = fieldType;
    }

    public String getColumnEName() {
        return columnEName;
    }

    public void setColumnEName(String columnEName) {
        this.columnEName = columnEName;
    }


    public String getSortType() {
        return sortType;
    }

    public void setSortType(String sortType) {
        this.sortType = sortType;
    }


  public String getSeqno() {
    return seqno;
  }

  public void setSeqno(String seqno) {
    this.seqno = seqno;
  }


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


  public String getFinCustManagerName() {
    return finCustManagerName;
  }

  public void setFinCustManagerName(String finCustManagerName) {
    this.finCustManagerName = finCustManagerName;
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

  public String getCreateUser() {
    return createUser;
  }

  public void setCreateUser(String createUser) {
    this.createUser = createUser;
  }


  public String getCreateDate() {
    return createDate;
  }

  public void setCreateDate(String createDate) {
    this.createDate = createDate;
  }


  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }


  public String getInstanceId() {
    return instanceId;
  }

  public void setInstanceId(String instanceId) {
    this.instanceId = instanceId;
  }

    public String getSpread() {
        return spread;
    }

    public void setSpread(String spread) {
        this.spread = spread;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConditionType() {
        return conditionType;
    }

    public void setConditionType(String conditionType) {
        this.conditionType = conditionType;
    }
}
