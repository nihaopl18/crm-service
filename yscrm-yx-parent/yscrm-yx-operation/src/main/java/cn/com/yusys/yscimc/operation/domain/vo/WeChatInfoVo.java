package cn.com.yusys.yscimc.operation.domain.vo;

import cn.com.yusys.yscimc.operation.constant.ComponentTypeEnum;

public class WeChatInfoVo implements ChannelInfoVo {

    private String nodeId;

    private String beginTime;

    private String endTime;

    private String sendType;

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getSendType() {
        return sendType;
    }

    public void setSendType(String sendType) {
        this.sendType = sendType;
    }

    public String getTimeInterval() {
        String[] bTime = beginTime.split(" ");
        String[] eTime = endTime.split(" ");
        return bTime[1] + " - " + eTime[1];
    }

    @Override
    public String getComponentName() {
        return ComponentTypeEnum.SHORT_MESSAGE.getComponentName();
    }
}
