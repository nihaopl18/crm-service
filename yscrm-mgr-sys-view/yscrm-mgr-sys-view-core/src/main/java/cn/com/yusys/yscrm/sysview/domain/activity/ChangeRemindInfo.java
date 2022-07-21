package cn.com.yusys.yscrm.sysview.domain.activity;

import java.io.Serializable;

/**
 * @author: sxm
 * @time: 2021/9/23 17:49
 */
public class ChangeRemindInfo implements Serializable {

    private static final long serialVersionUID = 2599106614514039391L;
    /**
     * 事件名称
     */
    private String ruleName;
    /**
     * 事件类型
     */
    private String typeName;
    /**
     * 数额
     */
    private String amt;
    /**
     * 重要日期
     */
    private String importDate;
    /**
     * 其他内容
     */
    private String otherContent;
    /**
     * 触发时间
     */
    private String remindCreateDate;
    /**
     * 客户姓名
     */
    private String custName;
    /**
     * ECIF号
     */
    private String custId;
    /**
     * 状态
     */
    private String state;
    /**
     * 客户经理
     */
    private String userName;

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getAmt() {
        return amt;
    }

    public void setAmt(String amt) {
        this.amt = amt;
    }

    public String getImportDate() {
        return importDate;
    }

    public void setImportDate(String importDate) {
        this.importDate = importDate;
    }

    public String getOtherContent() {
        return otherContent;
    }

    public void setOtherContent(String otherContent) {
        this.otherContent = otherContent;
    }

    public String getRemindCreateDate() {
        return remindCreateDate;
    }

    public void setRemindCreateDate(String remindCreateDate) {
        this.remindCreateDate = remindCreateDate;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
