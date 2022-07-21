package cn.com.yusys.yscimc.operation.repository.mapper;

import cn.com.yusys.yscimc.operation.domain.ActivityStatistics;
import cn.com.yusys.yscimc.operation.domain.vo.StatisticsVo;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ActivityStatisticsMapper extends CommonMapper<ActivityStatistics> {

    int virifySignUp(StatisticsVo vo);

    List<StatisticsVo> virifyFission(StatisticsVo vo);
}
