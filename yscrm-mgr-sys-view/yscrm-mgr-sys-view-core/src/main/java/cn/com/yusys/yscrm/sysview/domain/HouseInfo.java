package cn.com.yusys.yscrm.sysview.domain;

/**
 * 资产信息
 *
 * @author: sxm
 * @time: 2021/8/12 15:08
 */
public class HouseInfo {
    /**
     * 房产数量
     */
    private String houseCount;
    /**
     * 房产抵押状况
     */
    private String houseInfo;
    /**
     * 购置时间
     */
    private String purDt;
    /**
     * 购置原价
     */
    private String purPrc;
    /**
     * 收入来源
     */
    private String incomeSrc;
    /**
     * 年收入
     */
    private String incomeY;
    /**
     * 工资账户开户行
     */
    private String salAcctBank;
    /**
     * 投资周期
     */
    private String unvCyc;
    /**
     * 车辆情况
     */
    private String carFlg;
    /**
     * 投资偏好
     */
    private String invCd;

    public String getHouseCount() {
        return houseCount;
    }

    public void setHouseCount(String houseCount) {
        this.houseCount = houseCount;
    }

    public String getHouseInfo() {
        return houseInfo;
    }

    public void setHouseInfo(String houseInfo) {
        this.houseInfo = houseInfo;
    }

    public String getPurDt() {
        return purDt;
    }

    public void setPurDt(String purDt) {
        this.purDt = purDt;
    }

    public String getPurPrc() {
        return purPrc;
    }

    public void setPurPrc(String purPrc) {
        this.purPrc = purPrc;
    }

    public String getIncomeSrc() {
        return incomeSrc;
    }

    public void setIncomeSrc(String incomeSrc) {
        this.incomeSrc = incomeSrc;
    }

    public String getIncomeY() {
        return incomeY;
    }

    public void setIncomeY(String incomeY) {
        this.incomeY = incomeY;
    }

    public String getSalAcctBank() {
        return salAcctBank;
    }

    public void setSalAcctBank(String salAcctBank) {
        this.salAcctBank = salAcctBank;
    }

    public String getUnvCyc() {
        return unvCyc;
    }

    public void setUnvCyc(String unvCyc) {
        this.unvCyc = unvCyc;
    }

    public String getCarFlg() {
        return carFlg;
    }

    public void setCarFlg(String carFlg) {
        this.carFlg = carFlg;
    }

    public String getInvCd() {
        return invCd;
    }

    public void setInvCd(String invCd) {
        this.invCd = invCd;
    }
}
