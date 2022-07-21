package cn.com.yusys.yusp.cm.monitoring.service;

import cn.com.yusys.yusp.cm.monitoring.Vo.YscimcActivityChannelFlowVo;

import java.util.Date;
import java.util.List;

/**
 * @author sandMan
 * @date 2022/4/11 - 16:08
 */
public interface YscimcActivityChannelFlowService {
    List<YscimcActivityChannelFlowVo> getchannel(String activityId, Date date);
}
