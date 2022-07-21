package cn.com.yusys.yscrm.sysview.domain;

/**
 * @author: sxm
 * @time: 2021/8/11 15:54
 */
public class PerInfo {
    /**
     * 头像URL
     */
    private String custPhoto;
    /**
     * 姓名
     */
    private String custName;
    /**
     * 综合价值评分
     */
    private String valueScore;
    /**
     * 上月综合价值评分
     */
    private String lastValueScore;
    /**
     * 综合价值评分较上月
     */
    private String valueScore1;
    /**
     * 客户经理头像URL
     */
    private String headPort;
    /**
     * 理财客户经理
     */
    private String finaningMgrUserName;
    /**
     * 个贷经理
     */
    private String loanMgrUserName;
    /**
     * 性别
     */
    private String sex;
    /**
     * 年龄
     */
    private String age;
    /**
     * 年收入
     */
    private String incomeY;
    /**
     * 职业
     */
    private String indivOcc;
    /**
     * 行业
     */
    private String indOwnUnit;
    /**
     * 手机银行最后登录时间
     */
    private String newLoginDate;

    public String getCustPhoto() {
        return custPhoto;
    }

    public void setCustPhoto(String custPhoto) {
        this.custPhoto = custPhoto;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getValueScore() {
        return valueScore;
    }

    public void setValueScore(String valueScore) {
        this.valueScore = valueScore;
    }

    public String getLastValueScore() {
        return lastValueScore;
    }

    public void setLastValueScore(String lastValueScore) {
        this.lastValueScore = lastValueScore;
    }

    public String getValueScore1() {
        return valueScore1;
    }

    public void setValueScore1(String valueScore1) {
        this.valueScore1 = valueScore1;
    }

    public String getHeadPort() {
        return headPort;
    }

    public void setHeadPort(String headPort) {
        this.headPort = headPort;
    }

    public String getFinaningMgrUserName() { return finaningMgrUserName; }

    public void setFinaningMgrUserName(String finaningMgrUserName) { this.finaningMgrUserName = finaningMgrUserName; }

    public String getLoanMgrUserName() { return loanMgrUserName; }

    public void setLoanMgrUserName(String loanMgrUserName) { this.loanMgrUserName = loanMgrUserName; }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getIncomeY() {
        return incomeY;
    }

    public void setIncomeY(String incomeY) {
        this.incomeY = incomeY;
    }

    public String getIndivOcc() {
        return indivOcc;
    }

    public void setIndivOcc(String indivOcc) {
        this.indivOcc = indivOcc;
    }

    public String getIndOwnUnit() { return indOwnUnit; }

    public void setIndOwnUnit(String indOwnUnit) { this.indOwnUnit = indOwnUnit; }

    public String getNewLoginDate() {
        return newLoginDate;
    }

    public void setNewLoginDate(String newLoginDate) {
        this.newLoginDate = newLoginDate;
    }
}
