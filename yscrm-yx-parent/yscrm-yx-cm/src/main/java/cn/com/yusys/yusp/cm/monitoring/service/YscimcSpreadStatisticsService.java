package cn.com.yusys.yusp.cm.monitoring.service;

import cn.com.yusys.yusp.cm.monitoring.Vo.YscimcSpreadStatisticsVo;

import java.util.List;

/**
 * 传播统计表
 * @author houyx3
 * @email houyx3@yusys.com.cn
 * @date 2022-04-16 14:15:48
 */
public interface YscimcSpreadStatisticsService  {


    List<YscimcSpreadStatisticsVo> getListTopten(String activityId);
}

