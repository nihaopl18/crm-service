package cn.com.yusys.yusp.cm.monitoring.service;

import cn.com.yusys.yusp.cm.monitoring.Vo.YscimcActivityTrafficStatisticsVo;

import java.util.Date;
import java.util.List;

/**
 * @author sandMan
 * @date 2022/4/8 - 14:29
 */
public interface YscimcActivityTrafficStatisticsService {
    List<YscimcActivityTrafficStatisticsVo> flowStatistics(String activityId, Date date);
}
