package cn.com.yusys.yscrm.sysview.domain.activity;

import java.io.Serializable;

/**
 * @author: sxm
 * @time: 2021/10/8 19:38
 */
public class ChangeRemindExcel implements Serializable,Comparable<ChangeRemindExcel> {
    private Integer count = 0;
    /**
     * 类别
     * MT-到期类
     * OD-逾期类
     * TX-交易类
     * UD-升降级类
     */
    private String typeId;
    /**
     * 状态
     * 0-已处理
     * 2-待处理
     */
    private String state;
    /**
     * 平均处理时效
     */
    private Integer aging = 0;
    /**
     * 客户名称
     */
    private String custName;
    /**
     * 理财客户经理
     */
    private String finaningMgrUserName;
    /**
     * 个贷客户经理
     */
    private String loanMgrUserName;

    /**
     * 已处理异动数
     */
    private Integer countOfState0 = 0;
    /**
     * 待处理异动数
     */
    private Integer countOfState1 = 0;
    /**
     * 触发异动数
     */
    private Integer countOfStateTotal = 0;
    /**
     * 已处理异动比例
     */
    private Double  countOfState0Proportion = 0.0;
    /**
     * 待处理异动比例
     */
    private Double  countOfState1Proportion = 0.0;
    /**
     * 到期类异动
     */
    private Integer countMT0 = 0;
    private Double  countMT0Proportion = 0.0;
    private Integer countMT1 = 0;
    private Double  countMT1Proportion = 0.0;
    /**
     * 逾期类异动
     */
    private Integer countOD0 = 0;
    private Double  countOD0Proportion = 0.0;
    private Integer countOD1 = 0;
    private Double  countOD1Proportion = 0.0;
    /**
     * 交易类异动
     */
    private Integer countTX0 = 0;
    private Double  countTX0Proportion = 0.0;
    private Integer countTX1 = 0;
    private Double  countTX1Proportion = 0.0;
    /**
     * 升降级类异动
     */
    private Integer countUD0 = 0;
    private Double  countUD0Proportion = 0.0;
    private Integer countUD1 = 0;
    private Double  countUD1Proportion = 0.0;

    public Integer getAging() {
        return aging;
    }

    public void setAging(Integer aging) {
        this.aging = aging;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getCountOfState0() {
        return countOfState0;
    }

    public void setCountOfState0(Integer countOfState0) {
        this.countOfState0 = countOfState0;
    }

    public Integer getCountOfState1() {
        return countOfState1;
    }

    public void setCountOfState1(Integer countOfState1) {
        this.countOfState1 = countOfState1;
    }

    public Integer getCountMT0() {
        return countMT0;
    }

    public void setCountMT0(Integer countMT0) {
        this.countMT0 = countMT0;
    }

    public Integer getCountMT1() {
        return countMT1;
    }

    public void setCountMT1(Integer countMT1) {
        this.countMT1 = countMT1;
    }

    public Integer getCountOD0() {
        return countOD0;
    }

    public void setCountOD0(Integer countOD0) {
        this.countOD0 = countOD0;
    }

    public Integer getCountOD1() {
        return countOD1;
    }

    public void setCountOD1(Integer countOD1) {
        this.countOD1 = countOD1;
    }

    public Integer getCountTX0() {
        return countTX0;
    }

    public void setCountTX0(Integer countTX0) {
        this.countTX0 = countTX0;
    }

    public Integer getCountTX1() {
        return countTX1;
    }

    public void setCountTX1(Integer countTX1) {
        this.countTX1 = countTX1;
    }

    public Integer getCountUD0() {
        return countUD0;
    }

    public void setCountUD0(Integer countUD0) {
        this.countUD0 = countUD0;
    }

    public Integer getCountUD1() {
        return countUD1;
    }

    public void setCountUD1(Integer countUD1) {
        this.countUD1 = countUD1;
    }

    public Integer getCountOfStateTotal() {
        return countOfStateTotal;
    }

    public void setCountOfStateTotal(Integer countOfStateTotal) {
        this.countOfStateTotal = countOfStateTotal;
    }

    public Double getCountOfState0Proportion() {
        return countOfState0Proportion;
    }

    public void setCountOfState0Proportion(Double countOfState0Proportion) {
        this.countOfState0Proportion = countOfState0Proportion;
    }

    public Double getCountOfState1Proportion() {
        return countOfState1Proportion;
    }

    public void setCountOfState1Proportion(Double countOfState1Proportion) {
        this.countOfState1Proportion = countOfState1Proportion;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getFinaningMgrUserName() {
        return finaningMgrUserName;
    }

    public void setFinaningMgrUserName(String finaningMgrUserName) {
        this.finaningMgrUserName = finaningMgrUserName;
    }

    public String getLoanMgrUserName() {
        return loanMgrUserName;
    }

    public void setLoanMgrUserName(String loanMgrUserName) {
        this.loanMgrUserName = loanMgrUserName;
    }

    public Double getCountMT0Proportion() {
        return countMT0Proportion;
    }

    public void setCountMT0Proportion(Double countMT0Proportion) {
        this.countMT0Proportion = countMT0Proportion;
    }

    public Double getCountMT1Proportion() {
        return countMT1Proportion;
    }

    public void setCountMT1Proportion(Double countMT1Proportion) {
        this.countMT1Proportion = countMT1Proportion;
    }

    public Double getCountOD0Proportion() {
        return countOD0Proportion;
    }

    public void setCountOD0Proportion(Double countOD0Proportion) {
        this.countOD0Proportion = countOD0Proportion;
    }

    public Double getCountOD1Proportion() {
        return countOD1Proportion;
    }

    public void setCountOD1Proportion(Double countOD1Proportion) {
        this.countOD1Proportion = countOD1Proportion;
    }

    public Double getCountTX0Proportion() {
        return countTX0Proportion;
    }

    public void setCountTX0Proportion(Double countTX0Proportion) {
        this.countTX0Proportion = countTX0Proportion;
    }

    public Double getCountTX1Proportion() {
        return countTX1Proportion;
    }

    public void setCountTX1Proportion(Double countTX1Proportion) {
        this.countTX1Proportion = countTX1Proportion;
    }

    public Double getCountUD0Proportion() {
        return countUD0Proportion;
    }

    public void setCountUD0Proportion(Double countUD0Proportion) {
        this.countUD0Proportion = countUD0Proportion;
    }

    public Double getCountUD1Proportion() {
        return countUD1Proportion;
    }

    public void setCountUD1Proportion(Double countUD1Proportion) {
        this.countUD1Proportion = countUD1Proportion;
    }

    @Override
    public int compareTo(ChangeRemindExcel o) {
        return o.getAging().compareTo(this.aging);
    }
}
