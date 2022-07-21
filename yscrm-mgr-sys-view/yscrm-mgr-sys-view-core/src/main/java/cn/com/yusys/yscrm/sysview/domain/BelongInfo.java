package cn.com.yusys.yscrm.sysview.domain;

/**
 * 管户信息
 *
 * @author: sxm
 * @time: 2021/8/12 15:10
 */
public class BelongInfo {
    /**
     * 开户位置
     */
    private String opAccPlc;
    /**
     * 管户机构
     */
    private String custManagerOrg;
    /**
     * 归属客户经理
     */
    private String mgrName;
    /**
     * 归属机构
     */
    private String orgName;
    /**
     * 客户经理归属团队
     */
    private String mktTeamName;
    /**
     * 分配时间
     */
    private String joinDate;
    /**
     * 归属客户群名称
     */
    private String custGroupName;
    /**
     * 归属客户群类型
     */
    private String custGroupType;
    /**
     * 群创建人
     */
    private String creatUser;
    /**
     * 群创建时间
     */
    private String creatDate;

    public String getOpAccPlc() {
        return opAccPlc;
    }

    public void setOpAccPlc(String opAccPlc) {
        this.opAccPlc = opAccPlc;
    }

    public String getMgrName() {
        return mgrName;
    }

    public void setMgrName(String mgrName) {
        this.mgrName = mgrName;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getMktTeamName() {
        return mktTeamName;
    }

    public void setMktTeamName(String mktTeamName) {
        this.mktTeamName = mktTeamName;
    }

    public String getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(String joinDate) {
        this.joinDate = joinDate;
    }

    public String getCustGroupName() {
        return custGroupName;
    }

    public void setCustGroupName(String custGroupName) {
        this.custGroupName = custGroupName;
    }

    public String getCustGroupType() {
        return custGroupType;
    }

    public void setCustGroupType(String custGroupType) {
        this.custGroupType = custGroupType;
    }

    public String getCreatUser() {
        return creatUser;
    }

    public void setCreatUser(String creatUser) {
        this.creatUser = creatUser;
    }

    public String getCreatDate() {
        return creatDate;
    }

    public void setCreatDate(String creatDate) {
        this.creatDate = creatDate;
    }

    public String getCustManagerOrg() {
        return custManagerOrg;
    }

    public void setCustManagerOrg(String custManagerOrg) {
        this.custManagerOrg = custManagerOrg;
    }
}
