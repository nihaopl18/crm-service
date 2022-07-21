package cn.com.yusys.yusp.cm.monitoring.service;

import cn.com.yusys.yusp.cm.monitoring.Vo.YscimcActReRoiVo;

/**
 * 活动效果ROI
 * @author danyb1
 * @email danyb1@yusys.com.cn
 * @date 2022-04-08 17:10:44
 */
public interface YscimcActReRoiService  {

    //查询活动效果ROI
    YscimcActReRoiVo getRealTimeData(String actId, String date);
}

