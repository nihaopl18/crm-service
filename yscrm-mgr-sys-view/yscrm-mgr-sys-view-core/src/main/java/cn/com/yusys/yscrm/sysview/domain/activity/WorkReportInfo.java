package cn.com.yusys.yscrm.sysview.domain.activity;

import java.io.Serializable;

/**
 * @author: sxm
 * @time: 2021/9/24 17:50
 */
public class WorkReportInfo implements Serializable {
    private static final long serialVersionUID = 9134814143960674078L;

    private String workReportId;

    private String creatorName;

    private String createDate;
    /**
     * 状态
     * 1-日报
     * 2-周报
     * 3-月报
     */
    private String workReportBusiType;
    /**
     * 类别
     * 1-客户跟进
     * 2-培训/会议
     * 3-外访
     * 4- 商机
     * 5-材料整理
     */
    private String workSummary;

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

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getWorkReportBusiType() {
        return workReportBusiType;
    }

    public void setWorkReportBusiType(String workReportBusiType) {
        this.workReportBusiType = workReportBusiType;
    }

    public String getWorkSummary() {
        return workSummary;
    }

    public void setWorkSummary(String workSummary) {
        this.workSummary = workSummary;
    }
}
