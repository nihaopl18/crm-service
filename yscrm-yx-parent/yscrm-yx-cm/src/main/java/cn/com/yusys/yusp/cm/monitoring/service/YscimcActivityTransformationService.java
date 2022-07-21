package cn.com.yusys.yusp.cm.monitoring.service;

import cn.com.yusys.yusp.cm.monitoring.Vo.YscimcActivityTransformationVo;

import java.util.Date;

/**
 * @author sandMan
 * @date 2022/4/13 - 10:00
 */
public interface YscimcActivityTransformationService {
    YscimcActivityTransformationVo getTransformation(String activityId, Date date);
}
