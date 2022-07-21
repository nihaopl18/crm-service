package cn.com.yusys.yscimc.operation.service;

import cn.com.yusys.yscimc.operation.domain.ActivityEventResultEntity;

/**
 * @Author Lenovo
 * @Data 2022/3/17 14:39
 */
public interface ActivityEventResultService {

    void saveResultEntity(ActivityEventResultEntity resultEntity);

    ActivityEventResultEntity getById(String outTradeNo);

    ActivityEventResultEntity getByOutTradeNo(String outTradeNo);

    void delete(ActivityEventResultEntity resultEntity);

    int selectCountByTempId(String tempId);

    String distinctTransCodeByTempId(String tempId);
}
