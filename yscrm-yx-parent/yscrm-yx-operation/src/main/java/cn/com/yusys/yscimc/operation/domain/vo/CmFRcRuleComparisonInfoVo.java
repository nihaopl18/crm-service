package cn.com.yusys.yscimc.operation.domain.vo;

import java.io.Serializable;

public class CmFRcRuleComparisonInfoVo implements Serializable {
    private static final long serialVersionUID = 1L;
    //主键id
    private String id;
    //事件id
    private String eventId;
    //变量名
    private String variableName;
    //运算符
    private String operator;
    //比较值
    private String comparisionValue;
    //处理优先级
    private String processOrder;
    //变量类型
    private String variableType;
    //类型(1:规则 2：引用参数 3：连续动作)
    private String comparisionType;
    //内连接
    private String colJoin;
    //外连接
    private String colGjoin;
    //内分组序列号
    private String colOrder;
    //外分组序列号
    private String colGorder;

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

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getComparisionValue() {
        return comparisionValue;
    }

    public void setComparisionValue(String comparisionValue) {
        this.comparisionValue = comparisionValue;
    }

    public String getProcessOrder() {
        return processOrder;
    }

    public void setProcessOrder(String processOrder) {
        this.processOrder = processOrder;
    }

    public String getVariableType() {
        return variableType;
    }

    public void setVariableType(String variableType) {
        this.variableType = variableType;
    }

    public String getComparisionType() {
        return comparisionType;
    }

    public void setComparisionType(String comparisionType) {
        this.comparisionType = comparisionType;
    }

    public String getColJoin() {
        return colJoin;
    }

    public void setColJoin(String colJoin) {
        this.colJoin = colJoin;
    }

    public String getColGjoin() {
        return colGjoin;
    }

    public void setColGjoin(String colGjoin) {
        this.colGjoin = colGjoin;
    }

    public String getColOrder() {
        return colOrder;
    }

    public void setColOrder(String colOrder) {
        this.colOrder = colOrder;
    }

    public String getColGorder() {
        return colGorder;
    }

    public void setColGorder(String colGorder) {
        this.colGorder = colGorder;
    }


}
