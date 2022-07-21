package cn.com.yusys.yusp.cm.monitoring.service.impl;

import cn.com.yusys.yusp.cm.monitoring.Vo.YscimcActivityTrafficStatisticsVo;
import cn.com.yusys.yusp.cm.monitoring.repository.mapper.YscimcActivityTrafficStatisticsMapper;
import cn.com.yusys.yusp.cm.monitoring.service.YscimcActivityTrafficStatisticsService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author sandMan
 * @date 2022/4/8 - 14:30
 */
@Service
public class YscimcActivityTrafficStatisticsServiceImpl implements YscimcActivityTrafficStatisticsService {
    private final YscimcActivityTrafficStatisticsMapper mapper;

    public YscimcActivityTrafficStatisticsServiceImpl(YscimcActivityTrafficStatisticsMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<YscimcActivityTrafficStatisticsVo> flowStatistics(String activityId, Date date) {
        List<YscimcActivityTrafficStatisticsVo> yscimcActivityTrafficStatisticsVoList = mapper.flowStatistics(activityId, date);
        return yscimcActivityTrafficStatisticsVoList;
    }
}
