package cn.com.yusys.yscrm.sysview.domain.activity;

import java.io.Serializable;

/**
 * @author: sxm
 * @time: 2021/9/15 10:49
 */
public class OrgMAUProportion implements Serializable,Comparable<OrgMAUProportion> {
    private static final long serialVersionUID = -5572147005305089927L;
    /**
     * 名次
     */
    private Integer rank;
    /**
     * 近一月机构登录系统人数
     */
    private Integer count = 0;
    /**
     * 机构用户数
     */
    private Integer userCount = 0;
    /**
     * 机构id
     */
    private String orgId;
    /**
     * 机构名称
     */
    private String orgName;
    /**
     *占比
     */
    private Double proportion = 0.0;
    /**
     * 省份
     */
    private String province;

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getUserCount() {
        return userCount;
    }

    public void setUserCount(Integer userCount) {
        this.userCount = userCount;
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

    public Double getProportion() {
        return proportion;
    }

    public void setProportion(Double proportion) {
        this.proportion = proportion;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    @Override
    public int compareTo(OrgMAUProportion o) {
        return o.getProportion().compareTo(this.proportion);
    }
}
