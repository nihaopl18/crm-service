package cn.com.yusys.yscrm.sysview.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Date;

/**
 * @author: sxm
 * @time: 2021/9/7 10:15
 */
@Entity
@Table(name = "CIM_F_TAG_CUST_TAGS_SELF")
public class CimFTagCustTags implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "ID")
    private String id;

    @Column(name = "CUST_ID")
    private String custId;

    @Column(name = "TAG_NO")
    private String tagNo;

    @Column(name = "TAG_NAME")
    private String tagName;

    @Column(name = "AVAILABLE_DATE")
    private Date availableDate;

    @Column(name = "DISABLE_DATE")
    private Date disableDate;

    @Column(name = "CREATE_DATE")
    private Date createDate;

    @Column(name = "CREATE_USER")
    private String createUser;

    @Column(name = "CREATE_ORG")
    private String createOrg;

    @Column(name = "DISPLAY")
    private String display;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public String getTagNo() {
        return tagNo;
    }

    public void setTagNo(String tagNo) {
        this.tagNo = tagNo;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public Date getAvailableDate() {
        return availableDate;
    }

    public void setAvailableDate(Date availableDate) {
        this.availableDate = availableDate;
    }

    public Date getDisableDate() {
        return disableDate;
    }

    public void setDisableDate(Date disableDate) {
        this.disableDate = disableDate;
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

    public String getCreateOrg() {
        return createOrg;
    }

    public void setCreateOrg(String createOrg) {
        this.createOrg = createOrg;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }
}
