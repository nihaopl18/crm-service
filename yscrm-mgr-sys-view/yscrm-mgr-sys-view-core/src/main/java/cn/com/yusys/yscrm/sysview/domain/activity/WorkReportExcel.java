package cn.com.yusys.yscrm.sysview.domain.activity;


import java.io.Serializable;

/**
 * @author: sxm
 * @time: 2021/10/8 11:19
 */
public class WorkReportExcel implements Serializable,Comparable<WorkReportExcel> {
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

    private String upOrgId;
    private String upOrgName;
    private String orgId;
    private String orgName;
    private String creatorName;
    /**
     * 日报数量
     */
    private Integer count1=0;
    /**
     * 周报数量
     */
    private Integer count2=0;
    /**
     * 月报数量
     */
    private Integer count3=0;
    private Integer count4=0;
    private Integer count5=0;
    private Integer count6=0;
    private Integer count7=0;
    private Integer count8=0;

    public Integer getCount4() {
        return count4;
    }

    public void setCount4(Integer count4) {
        this.count4 = count4;
    }

    public Integer getCount5() {
        return count5;
    }

    public void setCount5(Integer count5) {
        this.count5 = count5;
    }

    public Integer getCount6() {
        return count6;
    }

    public void setCount6(Integer count6) {
        this.count6 = count6;
    }

    public Integer getCount7() {
        return count7;
    }

    public void setCount7(Integer count7) {
        this.count7 = count7;
    }

    public Integer getCount8() {
        return count8;
    }

    public void setCount8(Integer count8) {
        this.count8 = count8;
    }

    public Integer getCount1() {
        return count1;
    }

    public void setCount1(Integer count1) {
        this.count1 = count1;
    }

    public Integer getCount2() {
        return count2;
    }

    public void setCount2(Integer count2) {
        this.count2 = count2;
    }

    public Integer getCount3() {
        return count3;
    }

    public void setCount3(Integer count3) {
        this.count3 = count3;
    }

    public String getUpOrgId() {
        return upOrgId;
    }

    public void setUpOrgId(String upOrgId) {
        this.upOrgId = upOrgId;
    }

    public String getUpOrgName() {
        return upOrgName;
    }

    public void setUpOrgName(String upOrgName) {
        this.upOrgName = upOrgName;
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

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
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

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public int compareTo(WorkReportExcel o) {
        return o.getCount1().compareTo(this.count1);
    }
}
