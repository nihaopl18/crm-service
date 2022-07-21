package cn.com.yusys.yscimc.operation.domain.vo;

import java.io.Serializable;

public class CmFRcRuleConComparisonInfoVo implements Serializable {
    private static final long serialVersionUID = 1L;
    //主键id
    private String id;
    //事件id
    private String eventId;
    //变量名
    private String variableName;
    //连续统计方法
    private String statisticalMethod;
    //比较值
    private String comparisionValue;
    //周期类型（默认天）
    private String cycleType;
    //周期
    private String cycle;
    //运算符
    private String operator;
    //变量类型
    private String variableType;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getVariableName() {
        return variableName;
    }

    public void setVariableName(String variableName) {
        this.variableName = variableName;
    }

    public String getStatisticalMethod() {
        return statisticalMethod;
    }

    public void setStatisticalMethod(String statisticalMethod) {
        this.statisticalMethod = statisticalMethod;
    }

    public String getComparisionValue() {
        return comparisionValue;
    }

    public void setComparisionValue(String comparisionValue) {
        this.comparisionValue = comparisionValue;
    }

    public String getCycleType() {
        return cycleType;
    }

    public void setCycleType(String cycleType) {
        this.cycleType = cycleType;
    }

    public String getCycle() {
        return cycle;
    }

    public void setCycle(String cycle) {
        this.cycle = cycle;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getVariableType() {
        return variableType;
    }

    public void setVariableType(String variableType) {
        this.variableType = variableType;
    }
}
