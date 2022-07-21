package cn.com.yusys.yscimc.operation.domain.dto;

import cn.com.yusys.yscimc.operation.domain.vo.ChannelInfoVo;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Lenovo
 * @Data 2021/12/16 17:34
 */
public class ChannelInfoDto {

    private final List<ChannelInfoVo> channelInfoVoList = new ArrayList<>();

    public List<ChannelInfoVo> getChannelInfoVoList() {
        return this.channelInfoVoList;
    }

    public ChannelInfoDto addChannelInfoVo(ChannelInfoVo channelInfoVo) {
        this.channelInfoVoList.add(channelInfoVo);
        return this;
    }

    public ChannelInfoDto addChannelInfoVoList(List<ChannelInfoVo> channelInfoVoList) {
        this.channelInfoVoList.addAll(channelInfoVoList);
        return this;
    }
}
