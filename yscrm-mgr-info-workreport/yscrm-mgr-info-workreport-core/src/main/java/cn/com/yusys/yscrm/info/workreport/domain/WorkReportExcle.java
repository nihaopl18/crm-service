package cn.com.yusys.yscrm.info.workreport.domain;

public class WorkReportExcle {
    private String workReportId;
    private String creatorName;
    private String createDate;
    private String workReportBusiType;
    private String startDate;
    private String workContent;
    private String workSummary;
    private String contactCustName;
    private String contactType;
    private String contactGoal;
    private String product;
    private String contactBack;
    private String nextContactDate;
    private String annex;
    private String laterPlan;
    private String endDate;
    private String isDraft;

    public String getWorkReportBusiType() {
        return workReportBusiType;
    }

    public void setWorkReportBusiType(String workReportBusiType) {
        this.workReportBusiType = workReportBusiType;
    }

    public String getWorkContent() {
        return workContent;
    }

    public void setWorkContent(String workContent) {
        String[] workContents = workContent.split(";");
        String content = "";
        for (int i = 0; i < workContents.length; i++){
            String[] items = workContents[i].split(":");
            if (items.length == 2){
                switch (items[0]){
                    case "2":
                        content += "培训/会议:"+items[1];
                        break;
                    case "3":
                        content += "外访:"+items[1];
                        break;
                    case "4":
                        content += "商机:"+items[1];
                        break;
                    case "5":
                        content += "材料整理:"+items[1];
                        break;
                    default:
                        content += workContents[i];
                        break;
                }
                if (i != workContents.length - 1){
                    content += ";";
                }
            }
        }
        this.workContent = content;
    }

    public String getWorkSummary() { return workSummary; }

    public void setWorkSummary(String workSummary) {
        String[] workSummarys = workSummary.split(",");
        String summary = "";
        for (int i = 0; i < workSummarys.length; i++){
            String items = workSummarys[i];
            switch (items){
                case "1":
                    summary += "客户跟进";
                    break;
                case "2":
                    summary += "培训/会议";
                    break;
                case "3":
                    summary += "外访";
                    break;
                case "4":
                    summary += "商机";
                    break;
                case "5":
                    summary += "材料整理";
                    break;
                default:
                    summary += items;
                    break;
            }
            if (i != workSummarys.length - 1){
                summary += ";";
            }
        }
        this.workSummary = summary;
    }

    public String getContactCustName() {
        return contactCustName;
    }

    public void setContactCustName(String contactCustName) {
        this.contactCustName = contactCustName;
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

    public String getNextContactDate() {
        return nextContactDate;
    }

    public void setNextContactDate(String nextContactDate) {
        this.nextContactDate = nextContactDate;
    }

    public String getLaterPlan() {
        return laterPlan;
    }

    public void setLaterPlan(String laterPlan) {
        this.laterPlan = laterPlan;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getWorkReportId() {
        return workReportId;
    }

    public void setWorkReportId(String workReportId) {
        this.workReportId = workReportId;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getContactType() {
        return contactType;
    }

    public void setContactType(String contactType) {
        this.contactType = contactType;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getAnnex() {
        return annex;
    }

    public void setAnnex(String annex) {
        this.annex = annex;
    }

    public String getIsDraft() { return isDraft; }

    public void setIsDraft(String isDraft) {
        this.isDraft = isDraft;
    }
}
