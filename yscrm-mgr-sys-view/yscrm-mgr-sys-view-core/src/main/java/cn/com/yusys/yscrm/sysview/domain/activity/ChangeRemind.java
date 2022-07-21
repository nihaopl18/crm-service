package cn.com.yusys.yscrm.sysview.domain.activity;

import java.io.Serializable;

/**
 * 异动提醒情况汇总
 * @author: sxm
 * @time: 2021/9/17 14:21
 */
public class ChangeRemind implements Serializable {
    private static final long serialVersionUID = 7116621506973980913L;
    /**
     * 状态
     * 0-已处理
     * 1-待处理
     */
    private String state;
    /**
     * 类别
     * MT-到期类
     * OD-逾期类
     * TX-交易类
     * UD-升降级类
     */
    private String typeId;
    /**
     * 数量
     */
    private Integer count=0;

    /**
     * 占比
     */
    private Integer rate;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }
}
