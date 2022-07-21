package cn.com.yusys.yscrm.custmgr.domain;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import java.io.Serializable;

;

@Entity
public class organdmgrVO implements Serializable{

  private static final long serialVersionUID = 1493642054106877440L;

	/**
	 * 客户经理编码
	 */
    @ApiModelProperty(value = "客户经理编码")
  private String loginCode;
    /**
     * 客户经理名称
     */
    @ApiModelProperty(value = "客户经理名称")
    private String userName;

    /**
     * 机构编码
     */
    @ApiModelProperty(value = "机构编码")
    private String orgId;
    /**
     * 机构名称
     */
    @ApiModelProperty(value = "机构名称")
    private String orgName;

    public String getLoginCode() {
        return loginCode;
    }

    public void setLoginCode(String loginCode) {
        this.loginCode = loginCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }
}
