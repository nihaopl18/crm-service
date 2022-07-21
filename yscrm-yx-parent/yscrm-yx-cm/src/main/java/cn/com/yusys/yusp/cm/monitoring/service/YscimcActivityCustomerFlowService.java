package cn.com.yusys.yusp.cm.monitoring.service;

import cn.com.yusys.yusp.cm.monitoring.Vo.YscimcActivityCustomerFlowVo;

import java.util.Date;
import java.util.List;

/**
 * @author sandMan
 * @date 2022/4/11 - 10:43
 */
public interface YscimcActivityCustomerFlowService {
    List<YscimcActivityCustomerFlowVo> getcustomer(String activityId, Date date);
}
