package cn.com.yusys.yusp.cm.monitoring.service.impl;

import cn.com.yusys.yusp.cm.monitoring.Vo.YscimcSpreadStatisticsVo;
import cn.com.yusys.yusp.cm.monitoring.repository.mapper.YscimcSpreadStatisticsMapper;
import cn.com.yusys.yusp.cm.monitoring.service.YscimcSpreadStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class YscimcSpreadStatisticsServiceImpl implements YscimcSpreadStatisticsService {

    @Autowired
    private YscimcSpreadStatisticsMapper yscimcSpreadStatisticsMapper;


    @Override
    public List<YscimcSpreadStatisticsVo> getListTopten(String activityId) {
        return yscimcSpreadStatisticsMapper.getListTopten(activityId);
    }
}