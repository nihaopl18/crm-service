package cn.com.yusys.yusp.cm.cust.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

/**
 * @author 
 */
@Entity
@Table(name = "CIMP_F_FQ_SSOLUTION")
public class CimpFFqSsolution extends BaseDomain implements Serializable {
	@Id
	@Column(name = "ID")
	private String id;

	@Column(name = "SS_DATE")
    private Date ssDate;

	@Column(name = "SS_NAME")
    private String ssName;

	@Column(name = "SS_RESULT")
    private String ssResult;

	@Column(name = "SS_SORT")
    private String ssSort;

	@Column(name = "SS_TYPE")
    private String ssType;

	@Column(name = "SS_USER")
    private String ssUser;

	@Column(name = "TOP_NUM")
    private BigDecimal topNum;
	
	@Column(name = "CREATE_ORG")
    private String createOrg;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public String getCreateOrg() {
        return createOrg;
    }

    public void setCreateOrg(String createOrg) {
        this.createOrg = createOrg;
    }

    public Date getSsDate() {
        return ssDate;
    }

    public void setSsDate(Date ssDate) {
        this.ssDate = ssDate;
    }

    public String getSsName() {
        return ssName;
    }

    public void setSsName(String ssName) {
        this.ssName = ssName;
    }

    public String getSsResult() {
        return ssResult;
    }

    public void setSsResult(String ssResult) {
        this.ssResult = ssResult;
    }

    public String getSsSort() {
        return ssSort;
    }

    public void setSsSort(String ssSort) {
        this.ssSort = ssSort;
    }

    public String getSsType() {
        return ssType;
    }

    public void setSsType(String ssType) {
        this.ssType = ssType;
    }

    public String getSsUser() {
        return ssUser;
    }

    public void setSsUser(String ssUser) {
        this.ssUser = ssUser;
    }

    public BigDecimal getTopNum() {
        return topNum;
    }

    public void setTopNum(BigDecimal topNum) {
        this.topNum = topNum;
    }
}