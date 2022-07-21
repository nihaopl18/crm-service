package cn.com.yusys.yusp.cm.monitoring.service;

import cn.com.yusys.yusp.cm.monitoring.Vo.YscimcActivityTrafficSourceVo;

import java.util.Date;
import java.util.List;

/**
 * @author sandMan
 * @date 2022/4/8 - 17:03
 */
public interface YscimcActivityTrafficSourceService {
    List<YscimcActivityTrafficSourceVo> getflowsource(String activityId, Date date);
}
