package cn.com.yusys.yscimc.operation.domain.dto;

import cn.com.yusys.yscimc.operation.domain.vo.EventActivityInfoVo;

import java.util.List;

public class EventActivityInfoDto {
    private List<EventActivityInfoVo> EventActivityInfoVoList;

    public List<EventActivityInfoVo> getEventActivityInfoVoList() {
        return EventActivityInfoVoList;
    }

    public EventActivityInfoDto setEventActivityInfoVoList(List<EventActivityInfoVo> eventActivityInfoVoList) {
        EventActivityInfoVoList = eventActivityInfoVoList;
        return this;
    }

    public void addEventActivityInfoVo(EventActivityInfoVo eventActivityInfoVo) {
        this.EventActivityInfoVoList.add(eventActivityInfoVo);
    }

    public void addEventActivityInfoVoList(List<EventActivityInfoVo> eventActivityInfoVoList) {
        this.EventActivityInfoVoList.addAll(eventActivityInfoVoList);
    }

}
