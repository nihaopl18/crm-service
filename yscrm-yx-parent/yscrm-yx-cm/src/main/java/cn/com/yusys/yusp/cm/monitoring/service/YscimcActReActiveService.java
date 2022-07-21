package cn.com.yusys.yusp.cm.monitoring.service;

import cn.com.yusys.yusp.cm.monitoring.Vo.YscimcActReActiveVo;

import java.time.LocalDate;

/**
 * @author houyx3
 * @email houyx3@yusys.com.cn
 * @date 2022/4/6 14:20
 */
public interface YscimcActReActiveService {
    /**
     * 用户活跃趋势
     */
    String getUserActive(String actId, LocalDate date, String timeArr);


    YscimcActReActiveVo getLastDataByDate(String actId, String currentDate);
}
