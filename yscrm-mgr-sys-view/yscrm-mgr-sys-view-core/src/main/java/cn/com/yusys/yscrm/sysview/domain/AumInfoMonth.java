package cn.com.yusys.yscrm.sysview.domain;

/**
 * @author: sxm
 * @time: 2021/8/18 10:57
 */
public class AumInfoMonth {
    private String balance;
    private String Month;

    public AumInfoMonth(String balance, String month) {
        this.balance = balance;
        Month = month;
    }

    public AumInfoMonth() {
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getMonth() {
        return Month;
    }

    public void setMonth(String month) {
        Month = month;
    }
}
