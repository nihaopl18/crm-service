package cn.com.yusys.yscrm.sysview.domain;

/**
 * 产品配置比例信息
 * @author: sxm
 * @time: 2021/8/17 11:01
 */
public class ProdConfRaDetail {
    /**
     * 产品名称
     */
    private String name;
    /**
     * 产品余额
     */
    private String balance;

    public ProdConfRaDetail(String name, String balance) {
        this.name = name;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }
}
