package cn.com.yusys.yscimc.operation.domain.vo;

import java.io.Serializable;

public class CmFRcRiskActionInfoVo implements Serializable {
    private static final long serialVersionUID = 1L;
    //主键
    private String id;
    //动作id
    private String actionId;
    //风险id
    private String riskId;
    //类型（自定义、引用）
    private String tempType;
    //渠道
    private String channel;
    //模板内容
    private String tempContent;
    //动作分类（S单动作、C连续动作）
    private String actionClassify;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getActionId() {
        return actionId;
    }

    public void setActionId(String actionId) {
        this.actionId = actionId;
    }

    public String getRiskId() {
        return riskId;
    }

    public void setRiskId(String riskId) {
        this.riskId = riskId;
    }

    public String getTempType() {
        return tempType;
    }

    public void setTempType(String tempType) {
        this.tempType = tempType;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getTempContent() {
        return tempContent;
    }

    public void setTempContent(String tempContent) {
        this.tempContent = tempContent;
    }

    public String getActionClassify() {
        return actionClassify;
    }

    public void setActionClassify(String actionClassify) {
        this.actionClassify = actionClassify;
    }
}
