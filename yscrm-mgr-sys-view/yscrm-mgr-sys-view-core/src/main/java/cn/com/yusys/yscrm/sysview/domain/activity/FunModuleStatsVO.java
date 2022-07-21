package cn.com.yusys.yscrm.sysview.domain.activity;

import java.io.Serializable;

/**
 * @author: sxm
 * @time: 2021/9/13 11:33
 */
public class FunModuleStatsVO implements Serializable,Comparable<FunModuleStatsVO> {
    private static final long serialVersionUID = 1014790784051228491L;
    /**
     * 排名
     */
    private Integer rank;
    /**
     * 功能模块
     */
    private String module;
    /**
     * 覆盖率
     */
    private Double coverageRate;
    /**
     * 访问次数
     */
    private Integer visitTime = 0;
    /**
     * 访问人数
     */
    private Integer visitCount = 0;
    /**
     * 拥有该模块权限的用户总数
     */
    private Integer userCount = 0;


    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public Double getCoverageRate() {
        return coverageRate;
    }

    public void setCoverageRate(Double coverageRate) {
        this.coverageRate = coverageRate == null ? 0 : coverageRate;
    }

    public Integer getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(Integer visitTime) {
        this.visitTime = visitTime;
    }

    public Integer getVisitCount() {
        return visitCount;
    }

    public void setVisitCount(Integer visitCount) {
        this.visitCount = visitCount;
    }

    public Integer getUserCount() {
        return userCount;
    }

    public void setUserCount(Integer userCount) {
        this.userCount = userCount;
    }

    @Override
    public int compareTo(FunModuleStatsVO o) {
        return o.getCoverageRate().compareTo(this.coverageRate);
    }
}
