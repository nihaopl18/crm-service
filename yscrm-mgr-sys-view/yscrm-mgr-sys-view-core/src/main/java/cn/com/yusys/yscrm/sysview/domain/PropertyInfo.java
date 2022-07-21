package cn.com.yusys.yscrm.sysview.domain;

/**
 * @author: sxm
 * @time: 2021/8/11 16:11
 */
public class PropertyInfo {
    /**
     * AUM月日均
     */
    private String aumbalanceAvgRmb;
    /**
     * AUM月日均较上月
     */
    private String aumbalanceAvgRmbQoq;
    /**
     * 存款月日均余额
     */
    private String depositBalanceRmb;
    /**
     * 存款余额较上月
     */
    private String depositBalanceRmbQoq;
    /**
     * 贷款月日均余额
     */
    private String loanBalance;
    /**
     * 贷款余额较上月
     */
    private String loanBalanceRmbQoq;

    public String getAumbalanceAvgRmb() {
        return aumbalanceAvgRmb;
    }

    public void setAumbalanceAvgRmb(String aumbalanceAvgRmb) {
        this.aumbalanceAvgRmb = aumbalanceAvgRmb;
    }

    public String getAumbalanceAvgRmbQoq() {
        return aumbalanceAvgRmbQoq;
    }

    public void setAumbalanceAvgRmbQoq(String aumbalanceAvgRmbQoq) {
        this.aumbalanceAvgRmbQoq = aumbalanceAvgRmbQoq;
    }

    public String getDepositBalanceRmb() {
        return depositBalanceRmb;
    }

    public void setDepositBalanceRmb(String depositBalanceRmb) {
        this.depositBalanceRmb = depositBalanceRmb;
    }


    public String getDepositBalanceRmbQoq() {
        return depositBalanceRmbQoq;
    }

    public void setDepositBalanceRmbQoq(String depositBalanceRmbQoq) {
        this.depositBalanceRmbQoq = depositBalanceRmbQoq;
    }

    public String getLoanBalance() {
        return loanBalance;
    }

    public void setLoanBalance(String loanBalance) {
        this.loanBalance = loanBalance;
    }

    public String getLoanBalanceRmbQoq() {
        return loanBalanceRmbQoq;
    }

    public void setLoanBalanceRmbQoq(String loanBalanceRmbQoq) {
        this.loanBalanceRmbQoq = loanBalanceRmbQoq;
    }
}
