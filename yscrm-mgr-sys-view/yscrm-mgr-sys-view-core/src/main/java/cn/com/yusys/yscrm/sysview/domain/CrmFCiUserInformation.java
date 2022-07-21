package cn.com.yusys.yscrm.sysview.domain;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
public class CrmFCiUserInformation implements Serializable{

  private static final long serialVersionUID = 1889591743980977152L;

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
	 * 微信
	 */
    @ApiModelProperty(value = "微信")
  private String wechat;

	/**
	 * 政治面貌
	 */
    @ApiModelProperty(value = "政治面貌")
  private String politicalOutlook;

	/**
	 * 身体状态
	 */
    @ApiModelProperty(value = "身体状态")
  private String physicalState;

	/**
	 * 最后毕业院校
	 */
    @ApiModelProperty(value = "最后毕业院校")
  private String comSch;

	/**
	 * 所学专业
	 */
    @ApiModelProperty(value = "所学专业")
  private String schMajor;
  /**
   * 身体状态
   */
  @ApiModelProperty(value = "身体状态")
  private String hltStat;


  private String polStat;
	/**
	 * 毕业时间
	 */
    @ApiModelProperty(value = "毕业时间")
  private String endDate;

	/**
	 * 维护时间
	 */
    @ApiModelProperty(value = "维护时间")
  private java.util.Date createDate;
    /**
     * 流程id
     */
    private String instanceid;

	/**
	 * 维护人
	 */
    @ApiModelProperty(value = "维护人")
  private String createUser;
    /**
     * 收入来源
     */
    @ApiModelProperty(value = "收入来源")
    private String incomeSrc;
    /**
     * 车辆情况
     */
    @ApiModelProperty(value = "车辆情况")
    private String carFlg;
    /**
     * 状态（01草稿 02审批中 03 退回 04 生效）
     */
    @ApiModelProperty(value = "状态（01草稿 02审批中 03 退回 04 生效）")
    private String status;
    /**
     * 房产信息
     */
    @ApiModelProperty(value = "房产信息")
    private List<CiUserAssetsDTO> list=new ArrayList<>();

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


  public String getWechat() {
    return wechat;
  }

  public void setWechat(String wechat) {
    this.wechat = wechat;
  }


  public String getPoliticalOutlook() {
    return politicalOutlook;
  }

  public void setPoliticalOutlook(String politicalOutlook) {
    this.politicalOutlook = politicalOutlook;
  }


  public String getPhysicalState() {
    return physicalState;
  }

  public void setPhysicalState(String physicalState) {
    this.physicalState = physicalState;
  }


  public String getComSch() {
    return comSch;
  }

  public void setComSch(String comSch) {
    this.comSch = comSch;
  }


  public String getSchMajor() {
    return schMajor;
  }

  public void setSchMajor(String schMajor) {
    this.schMajor = schMajor;
  }


  public String getEndDate() {
    return endDate;
  }

  public void setEndDate(String endDate) {
    this.endDate = endDate;
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

    public String getIncomeSrc() {
        return incomeSrc;
    }

    public void setIncomeSrc(String incomeSrc) {
        this.incomeSrc = incomeSrc;
    }

    public String getCarFlg() {
        return carFlg;
    }

    public void setCarFlg(String carFlg) {
        this.carFlg = carFlg;
    }

    public List<CiUserAssetsDTO> getList() {
        return list;
    }

    public void setList(List<CiUserAssetsDTO> list) {
        this.list = list;
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

  public String getHltStat() {
    return hltStat;
  }

  public void setHltStat(String hltStat) {
    this.hltStat = hltStat;
  }

  public String getPolStat() {
    return polStat;
  }

  public void setPolStat(String polStat) {
    this.polStat = polStat;
  }
}
