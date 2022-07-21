package cn.com.yusys.yusp.cm.monitoring.service;

import cn.com.yusys.yusp.cm.monitoring.Vo.YscimcActReExtensionVo;

import java.util.List;

/**
 * 活动效果推广信息表
 * @author houyx3
 * @email houyx3@yusys.com.cn
 * @date 2022-04-15 16:49:33
 */
public interface YscimcActReExtensionService {

    /**
     * 获取活动效果推广信息表
     * @param actId
     * @return
     */
    List<YscimcActReExtensionVo> getLastData(String actId);
}

