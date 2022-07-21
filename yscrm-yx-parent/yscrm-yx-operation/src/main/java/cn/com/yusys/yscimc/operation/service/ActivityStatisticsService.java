package cn.com.yusys.yscimc.operation.service;

import cn.com.yusys.yscimc.operation.domain.vo.StatisticsVo;
import cn.com.yusys.yscimc.operation.repository.mapper.ActivityFieldInfoMapper;

public interface ActivityStatisticsService {

    void statistics(StatisticsVo vo) throws Exception;

    int saveActAddrForActId(String actId);

    ActivityFieldInfoMapper getFieldInfoMapper();
}
