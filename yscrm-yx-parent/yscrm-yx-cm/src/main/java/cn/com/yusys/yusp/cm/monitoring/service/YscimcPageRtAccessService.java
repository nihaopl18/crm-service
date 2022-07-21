package cn.com.yusys.yusp.cm.monitoring.service;

import java.time.LocalDate;

/**
 * @author sandMan
 * @date 2022/4/12 - 10:49
 */
public interface YscimcPageRtAccessService {
    String getpagertaccess(String actId, LocalDate date, String timeArr);
}
