package cn.com.yusys.yscrm.custmgr.domain;

public class analyseVO {
    /**
     * 指标编号(01:存款日均净增 02:AUM余额净增 03:合格优惠及以上客户数 04:合格优惠及以上客户数净增 05:贷款放款量 06:优质按揭客户数 07:模拟PPOP
     08:存款日均余额 09:AUM余额 10:合格优惠客户数 11：贷款放款笔数 12：按揭放款笔数 13：人均按揭放款笔数 14：车位贷放款笔数 15：人均车位贷放款笔数
     16：利率、汇率挂钩手续费收入 17：人民币基金手续费收入 18：ODII手续费收入 19：境内结构性产品手续费收入)
     */
    private String triumphId;


    /**
     * 指标名称
     */
    private String triumphName;
    /**
     * 同比
     */
    private String yearOnYear;

    /**
     * 环比
     */
    private String ringRatio;

    /**
     * 余额
     */
    private String balance;

    public String getTriumphId() {
        return triumphId;
    }

    public void setTriumphId(String triumphId) {
        this.triumphId = triumphId;
    }

    public String getTriumphName() {
        return triumphName;
    }

    public void setTriumphName(String triumphName) {
        this.triumphName = triumphName;
    }

    public String getYearOnYear() {
        return yearOnYear;
    }

    public void setYearOnYear(String yearOnYear) {
        this.yearOnYear = yearOnYear;
    }

    public String getRingRatio() {
        return ringRatio;
    }

    public void setRingRatio(String ringRatio) {
        this.ringRatio = ringRatio;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }
}
