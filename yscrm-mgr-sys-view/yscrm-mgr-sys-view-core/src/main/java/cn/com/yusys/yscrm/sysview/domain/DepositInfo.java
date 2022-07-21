package cn.com.yusys.yscrm.sysview.domain;

/**
 * @author: sxm
 * @time: 2021/8/11 16:09
 */
public class DepositInfo {

    /**
     * 存款余额
     */
    private String dpsBal;
    /**
     * 日期
     */
    private String dataDate;

    public String getDpsBal() {
        return dpsBal;
    }

    public void setDpsBal(String dpsBal) {
        this.dpsBal = dpsBal;
    }

    public String getDataDate() {
        return dataDate;
    }

    public void setDataDate(String dataDate) {
        this.dataDate = dataDate;
    }
}
