package cn.com.yusys.yusp.cm.monitoring.service;

import java.time.LocalDate;

/**
 * @author sandMan
 * @date 2022/4/12 - 14:47
 */
public interface YscimcChannelRtAccessService {
    String getchannelrtaccess(String activityId, LocalDate date, String timeArr);
}
