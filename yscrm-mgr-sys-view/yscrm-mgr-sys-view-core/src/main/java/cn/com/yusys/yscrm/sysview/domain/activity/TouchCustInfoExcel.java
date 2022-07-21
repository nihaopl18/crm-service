package cn.com.yusys.yscrm.sysview.domain.activity;

import java.io.Serializable;

/**
 * @author: sxm
 * @time: 2021/9/30 14:36
 */
public class TouchCustInfoExcel implements Serializable,Comparable<TouchCustInfoExcel> {
    private String upOrgId;
    private String upOrgName;
    private String orgId;
    private String orgName;
    private String creatorId;
    private String creatorName;
    private Integer count=0;
    /**
     * 1电话 2线下拜访 3短信
     */
    private String contactType;
    private Integer lastCount=0;
    private String lastContactType;
    private String lastCreatorName;
    /**
     * 接触客户人数
     */
    private Integer number = 0;
    private Integer lastNumber = 0;
    private Double numberQoq = 0.0;
    /**
     * 接触客户次数
     */
    private Integer time = 0;
    private Integer lastTime = 0;
    private Double timeQoq = 0.0;
    /**
     * 拨通电话
     */
    private Integer count1=0;
    private Integer lastCount1=0;
    private Double count1Qoq = 0.0;
    /**
     * 线下拜访
     */
    private Integer count2=0;
    private Integer lastCount2=0;
    private Double count2Qoq = 0.0;

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

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
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

    public String getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId;
    }

    public Integer getLastCount() {
        return lastCount;
    }

    public void setLastCount(Integer lastCount) {
        this.lastCount = lastCount;
    }

    public String getLastContactType() {
        return lastContactType;
    }

    public void setLastContactType(String lastContactType) {
        this.lastContactType = lastContactType;
    }

    public String getLastCreatorName() {
        return lastCreatorName;
    }

    public void setLastCreatorName(String lastCreatorName) {
        this.lastCreatorName = lastCreatorName;
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

    public Integer getLastCount1() {
        return lastCount1;
    }

    public void setLastCount1(Integer lastCount1) {
        this.lastCount1 = lastCount1;
    }

    public Integer getLastCount2() {
        return lastCount2;
    }

    public void setLastCount2(Integer lastCount2) {
        this.lastCount2 = lastCount2;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getLastNumber() {
        return lastNumber;
    }

    public void setLastNumber(Integer lastNumber) {
        this.lastNumber = lastNumber;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public Integer getLastTime() {
        return lastTime;
    }

    public void setLastTime(Integer lastTime) {
        this.lastTime = lastTime;
    }

    public Double getNumberQoq() {
        return numberQoq;
    }

    public void setNumberQoq(Double numberQoq) {
        this.numberQoq = numberQoq;
    }

    public Double getTimeQoq() {
        return timeQoq;
    }

    public void setTimeQoq(Double timeQoq) {
        this.timeQoq = timeQoq;
    }

    public Double getCount1Qoq() {
        return count1Qoq;
    }

    public void setCount1Qoq(Double count1Qoq) {
        this.count1Qoq = count1Qoq;
    }

    public Double getCount2Qoq() {
        return count2Qoq;
    }

    public void setCount2Qoq(Double count2Qoq) {
        this.count2Qoq = count2Qoq;
    }

    @Override
    public int compareTo(TouchCustInfoExcel o) {
        return o.getNumber().compareTo(this.number);
    }
}
