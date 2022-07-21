package cn.com.yusys.yusp.cm.monitoring.service;

import java.util.Map;

/**
 * 传播趋势表
 *
 * @author houyx3
 * @email houyx3@yusys.com.cn
 * @date 2022-04-16 14:15:48
 */
public interface YscimcSpreadTendencyService {

    Map<String, Object> getLastDataForMonth(String actId, int month);
}

