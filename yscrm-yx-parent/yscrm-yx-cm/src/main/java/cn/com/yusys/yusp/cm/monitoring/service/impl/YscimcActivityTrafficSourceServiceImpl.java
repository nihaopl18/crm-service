package cn.com.yusys.yusp.cm.monitoring.service.impl;

import cn.com.yusys.yusp.cm.monitoring.Vo.YscimcActivityTrafficSourceVo;
import cn.com.yusys.yusp.cm.monitoring.repository.mapper.YscimcActivityTrafficSourceMapper;
import cn.com.yusys.yusp.cm.monitoring.service.YscimcActivityTrafficSourceService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author sandMan
 * @date 2022/4/8 - 17:03
 */
@Service
public class YscimcActivityTrafficSourceServiceImpl implements YscimcActivityTrafficSourceService {
    private final YscimcActivityTrafficSourceMapper mapper;

    public YscimcActivityTrafficSourceServiceImpl(YscimcActivityTrafficSourceMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<YscimcActivityTrafficSourceVo> getflowsource(String activityId, Date date) {
        List<YscimcActivityTrafficSourceVo> yscimcActivityTrafficSourceVoList = mapper.getflowsource(activityId,date);
        return yscimcActivityTrafficSourceVoList;
    }
}
