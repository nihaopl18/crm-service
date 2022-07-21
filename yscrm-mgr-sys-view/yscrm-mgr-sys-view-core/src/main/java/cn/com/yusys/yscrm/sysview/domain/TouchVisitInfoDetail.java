package cn.com.yusys.yscrm.sysview.domain;

/**
 * @author: sxm
 * @time: 2021/8/14 18:04
 */
public class TouchVisitInfoDetail {
    /**
     * 评估时间
     */
    private String contactDate;
    /**
     * 接触类型
     */
    private String contactType;
    /**
     * 管户经理
     */
    private String creatorName;
    /**
     * 接触目的
     */
    private String contactGoal;
    /**
     * 产品
     */
    private String product;
    /**
     * 接触反馈
     */
    private String contactBack;
    /**
     * 工作报告Id
     */
    private String workReportId;
    /**
     * 数据来源
     */
    private String sourceTable;
    /**
     * 数据Id
     */
    private String customerContactId;

    public String getContactDate() {
        return contactDate;
    }

    public void setContactDate(String contactDate) {
        this.contactDate = contactDate;
    }

    public String getContactType() {
        return contactType;
    }

    public void setContactType(String contactType) {
        this.contactType = contactType;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getContactGoal() {
        return contactGoal;
    }

    public void setContactGoal(String contactGoal) {
        this.contactGoal = contactGoal;
    }

    public String getContactBack() {
        return contactBack;
    }

    public void setContactBack(String contactBack) {
        this.contactBack = contactBack;
    }

    public String getWorkReportId() {
        return workReportId;
    }

    public void setWorkReportId(String workReportId) {
        this.workReportId = workReportId;
    }

    public String getSourceTable() { return sourceTable; }

    public void setSourceTable(String sourceTable) { this.sourceTable = sourceTable; }

    public String getCustomerContactId() { return customerContactId; }

    public void setCustomerContactId(String customerContactId) { this.customerContactId = customerContactId; }
}
