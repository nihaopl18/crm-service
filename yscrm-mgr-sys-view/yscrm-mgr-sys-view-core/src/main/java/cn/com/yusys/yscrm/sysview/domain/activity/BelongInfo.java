package cn.com.yusys.yscrm.sysview.domain.activity;

import java.io.Serializable;

/**
 * 管户信息
 * @author: sxm
 * @time: 2021/9/16 13:49
 */
public class BelongInfo implements Serializable {
    private static final long serialVersionUID = 6052499874673632036L;
    /**
     * 管户数
     */
    private Integer count=0;

    /**
     * 个贷管户数
     */
    private Integer loanCount = 0;

    /**
     * 理财管户数
     */
    private Integer financingCount = 0;

    /**
     * 机构/经理名称
     */
    private String name;

    /**
     * 管户类型
     */
    private String mgrType;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMgrType() {
        return mgrType;
    }

    public void setMgrType(String mgrType) {
        this.mgrType = mgrType;
    }

    public Integer getLoanCount() {
        return loanCount;
    }

    public void setLoanCount(Integer loanCount) {
        this.loanCount = loanCount;
    }

    public Integer getFinancingCount() {
        return financingCount;
    }

    public void setFinancingCount(Integer financingCount) {
        this.financingCount = financingCount;
    }
}
