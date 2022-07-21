package com.yusys.streaminghub.app.domain;

import java.math.BigDecimal;

/**
 * Table: SHUB_APP
 */
public class ShubApp {
    /**
     * Column: APP_ID
     * Type: VARCHAR2(45)
     */
    private String appId;

    /**
     * Column: APP_SECRET
     * Type: VARCHAR2(100)
     */
    private String appSecret;

    /**
     * Column: APP_NAME
     * Type: VARCHAR2(60)
     */
    private String appName;

    /**
     * Column: ISSUER
     * Type: VARCHAR2(45)
     */
    private String issuer;

    /**
     * Column: DEVELOPER
     * Type: VARCHAR2(45)
     */
    private String developer;

    /**
     * Column: CTIME
     * Type: VARCHAR2(17)
     */
    private String ctime;

    /**
     * Column: EXPIRE
     * Type: VARCHAR2(14)
     */
    private String expire;

    /**
     * Column: VALID
     * Type: NUMBER
     */
    private BigDecimal valid;

    /**
     * Column: NOTE
     * Type: VARCHAR2(100)
     */
    private String note;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId == null ? null : appId.trim();
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret == null ? null : appSecret.trim();
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName == null ? null : appName.trim();
    }

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer == null ? null : issuer.trim();
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer == null ? null : developer.trim();
    }

    public String getCtime() {
        return ctime;
    }

    public void setCtime(String ctime) {
        this.ctime = ctime == null ? null : ctime.trim();
    }

    public String getExpire() {
        return expire;
    }

    public void setExpire(String expire) {
        this.expire = expire == null ? null : expire.trim();
    }

    public BigDecimal getValid() {
        return valid;
    }

    public void setValid(BigDecimal valid) {
        this.valid = valid;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }
}