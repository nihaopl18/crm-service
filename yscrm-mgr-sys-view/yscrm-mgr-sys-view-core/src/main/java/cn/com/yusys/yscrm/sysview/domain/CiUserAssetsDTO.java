package cn.com.yusys.yscrm.sysview.domain;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
public class CiUserAssetsDTO implements Serializable{

  private static final long serialVersionUID = 1120957098309067264L;

    /**
     * 客户号
     */
    @ApiModelProperty(value = "客户号")
    private String custId;
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
     * id
     */
    @ApiModelProperty(value = "id")
    private String seqno;

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

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public String getSeqno() {
        return seqno;
    }

    public void setSeqno(String seqno) {
        this.seqno = seqno;
    }
}
