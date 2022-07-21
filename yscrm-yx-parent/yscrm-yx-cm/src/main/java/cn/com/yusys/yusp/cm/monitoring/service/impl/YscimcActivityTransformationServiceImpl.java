package cn.com.yusys.yusp.cm.monitoring.service.impl;

import cn.com.yusys.yusp.cm.monitoring.Vo.YscimcActivityTransformationVo;
import cn.com.yusys.yusp.cm.monitoring.repository.mapper.YscimcActivityTransformationMapper;
import cn.com.yusys.yusp.cm.monitoring.service.YscimcActivityTransformationService;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author sandMan
 * @date 2022/4/13 - 10:00
 */
@Service
public class YscimcActivityTransformationServiceImpl implements YscimcActivityTransformationService {
    private final YscimcActivityTransformationMapper mapper;

    public YscimcActivityTransformationServiceImpl(YscimcActivityTransformationMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public YscimcActivityTransformationVo getTransformation(String activityId, Date date) {
        return mapper.getTransformation(activityId,date);
    }
}
