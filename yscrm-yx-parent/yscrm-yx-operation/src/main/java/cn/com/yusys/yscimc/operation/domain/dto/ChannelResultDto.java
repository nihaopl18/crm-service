package cn.com.yusys.yscimc.operation.domain.dto;

/**
 * @Author Lenovo
 * @Data 2022/3/11 14:58
 */
public class ChannelResultDto {

    private String channelId;

    private String channelName;

    public ChannelResultDto(String channelId, String channelName) {
        this.channelId = channelId;
        this.channelName = channelName;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }
}
