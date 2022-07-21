package cn.com.yusys.yusp.cm.monitoring.service.impl;

import cn.com.yusys.yusp.cm.monitoring.Vo.YscimcActivityCustomerFlowVo;
import cn.com.yusys.yusp.cm.monitoring.repository.mapper.YscimcActivityCustomerFlowMapper;
import cn.com.yusys.yusp.cm.monitoring.service.YscimcActivityCustomerFlowService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author sandMan
 * @date 2022/4/11 - 10:43
 */
@Service
public class YscimcActivityCustomerFlowServiceImpl implements YscimcActivityCustomerFlowService {
    private final YscimcActivityCustomerFlowMapper mapper;

    public YscimcActivityCustomerFlowServiceImpl(YscimcActivityCustomerFlowMapper mapper) {
        this.mapper = mapper;
    }


    @Override
    public List<YscimcActivityCustomerFlowVo> getcustomer(String activityId, Date date) {
        List<YscimcActivityCustomerFlowVo> yscimcActivityCustomerFlowVo=mapper.getcustomer(activityId,date);
        return yscimcActivityCustomerFlowVo;
    }
}
