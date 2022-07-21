package cn.com.yusys.yusp.cm.monitoring.service;

import java.time.LocalDate;

/**
 * @author sandMan
 * @date 2022/4/12 - 16:28
 */
public interface YscimcFieldRtAccessService {
    String getfieldrtaccess(String activityId, LocalDate date, String timeArr);
}
