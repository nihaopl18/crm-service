package cn.com.yusys.yusp.cm.monitoring.service;

import java.time.LocalDate;

/**
 * @author sandMan
 * @date 2022/4/13 - 11:15
 */
public interface YscimcRightDistributionTrendService {
    String getRightDistributionTrend(String activityId, LocalDate date, String timeArr);
}
