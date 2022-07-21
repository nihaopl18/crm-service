package cn.com.yusys.yusp.cm.monitoring.service.impl;

import cn.com.yusys.yusp.cm.monitoring.Vo.YscimcActivityChannelFlowVo;
import cn.com.yusys.yusp.cm.monitoring.repository.mapper.YscimcActivityChannelFlowMapper;
import cn.com.yusys.yusp.cm.monitoring.service.YscimcActivityChannelFlowService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author sandMan
 * @date 2022/4/11 - 16:08
 */
@Service
public class YscimcActivityChannelFlowServiceImpl implements YscimcActivityChannelFlowService {
    private final YscimcActivityChannelFlowMapper mapper;

    public YscimcActivityChannelFlowServiceImpl(YscimcActivityChannelFlowMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<YscimcActivityChannelFlowVo> getchannel(String activityId, Date date) {
        return mapper.getchannel(activityId,date);
    }
}
