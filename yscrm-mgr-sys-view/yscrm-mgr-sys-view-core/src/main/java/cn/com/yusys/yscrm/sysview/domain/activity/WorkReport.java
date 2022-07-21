package cn.com.yusys.yscrm.sysview.domain.activity;

import java.io.Serializable;

/**
 * @author: sxm
 * @time: 2021/9/17 22:11
 */
public class WorkReport implements Serializable {
    private static final long serialVersionUID = 4585535232504285236L;
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
    /**
     * 数量
     */
    private Integer count=0;

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

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
