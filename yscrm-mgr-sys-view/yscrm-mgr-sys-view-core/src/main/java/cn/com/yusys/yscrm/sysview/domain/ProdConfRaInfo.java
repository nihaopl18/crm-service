package cn.com.yusys.yscrm.sysview.domain;

/**
 * 产品配置比例
 *
 * @author: sxm
 * @time: 2021/8/13 9:48
 */
public class ProdConfRaInfo {
    /**
     * 信托余额
     */
    private String trustBalanceRmb;
    /**
     * 人民币基金余额
     */
    private String rmbFundBalance;
    /**
     * 结构化理财余额
     */
    private String structFinBalanceRmb;
    /**
     * 定期存款余额
     */
    private String timeDepositBalance;

    /**
     * 活期存款余额
     */
    private String demandDepositBalance;

    /**
     * QDII余额
     */
    private String qdiiBalanceRmb;

    /**
     * 总缴保费
     */
    private String insurranceBalance;

    public String getTrustBalanceRmb() {
        return trustBalanceRmb;
    }

    public void setTrustBalanceRmb(String trustBalanceRmb) {
        this.trustBalanceRmb = trustBalanceRmb;
    }

    public String getRmbFundBalance() {
        return rmbFundBalance;
    }

    public void setRmbFundBalance(String rmbFundBalance) {
        this.rmbFundBalance = rmbFundBalance;
    }

    public String getStructFinBalanceRmb() {
        return structFinBalanceRmb;
    }

    public void setStructFinBalanceRmb(String structFinBalanceRmb) {
        this.structFinBalanceRmb = structFinBalanceRmb;
    }

    public String getTimeDepositBalance() {
        return timeDepositBalance;
    }

    public void setTimeDepositBalance(String timeDepositBalance) {
        this.timeDepositBalance = timeDepositBalance;
    }

    public String getDemandDepositBalance() {
        return demandDepositBalance;
    }

    public void setDemandDepositBalance(String demandDepositBalance) {
        this.demandDepositBalance = demandDepositBalance;
    }

    public String getQdiiBalanceRmb() {
        return qdiiBalanceRmb;
    }

    public void setQdiiBalanceRmb(String qdiiBalanceRmb) {
        this.qdiiBalanceRmb = qdiiBalanceRmb;
    }

    public String getInsurranceBalance() {
        return insurranceBalance;
    }

    public void setInsurranceBalance(String insurranceBalance) {
        this.insurranceBalance = insurranceBalance;
    }
}
