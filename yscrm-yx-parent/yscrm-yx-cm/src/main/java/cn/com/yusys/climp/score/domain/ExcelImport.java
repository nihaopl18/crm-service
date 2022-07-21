package cn.com.yusys.climp.score.domain;

import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "LOY_SR_EXCLE_IMPORT")
public class ExcelImport extends BaseDomain implements Serializable {
    /**
     * 批次号
     */
    @Column(name = "IMPORT_CODE", unique = false, nullable = true, length = 32)
    private String importCode;
    /**
     * 导入人编号
     */
    @Column(name = "IMPORT_USER", unique = false, nullable = true, length = 32)
    private String importUser;
    /**
     * 导入人名称
     */
    @Column(name = "IMPORT_USERNAME", unique = false, nullable = true, length = 32)
    private String importUsername;
    /**
     * 导入时间
     */
    @Column(name = "IMPORT_DATE", unique = false, nullable = true, length = 32)
    private Date importDate;
    /**
     * 导入客户数
     */
    @Column(name = "IMPORT_NUM", unique = false, nullable = true, length = 32)
    private Integer importNum;
    /**
     * 审批状态
     */
    @Column(name = "APP_STATUS", unique = false, nullable = true, length = 32)
    private String appStatus;
    /**
     * 审批人
     */
    @Column(name = "APP_USER", unique = false, nullable = true, length = 32)
    private String appUser;
    /**
     * 审批时间
     */
    @Column(name = "APP_DATE", unique = false, nullable = true, length = 32)
    private Date appDate;

    public String getImportCode() {
        return importCode;
    }

    public void setImportCode(String importCode) {
        this.importCode = importCode;
    }

    public String getImportUser() {
        return importUser;
    }

    public void setImportUser(String importUser) {
        this.importUser = importUser;
    }

    public String getImportUsername() {
        return importUsername;
    }

    public void setImportUsername(String importUsername) {
        this.importUsername = importUsername;
    }

    public Date getImportDate() {
        return importDate;
    }

    public void setImportDate(Date importDate) {
        this.importDate = importDate;
    }

    public Integer getImportNum() {
        return importNum;
    }

    public void setImportNum(Integer importNum) {
        this.importNum = importNum;
    }

    public String getAppStatus() {
        return appStatus;
    }

    public void setAppStatus(String appStatus) {
        this.appStatus = appStatus;
    }

    public String getAppUser() {
        return appUser;
    }

    public void setAppUser(String appUser) {
        this.appUser = appUser;
    }

    public Date getAppDate() {
        return appDate;
    }

    public void setAppDate(Date appDate) {
        this.appDate = appDate;
    }
}
