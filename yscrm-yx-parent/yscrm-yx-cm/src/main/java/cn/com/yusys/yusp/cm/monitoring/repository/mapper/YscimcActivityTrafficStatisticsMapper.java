package cn.com.yusys.yusp.cm.monitoring.repository.mapper;

import cn.com.yusys.yusp.cm.monitoring.Vo.YscimcActivityTrafficStatisticsVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * @author sandMan
 * @date 2022/4/8 - 14:58
 */
@Mapper
public interface YscimcActivityTrafficStatisticsMapper {
    List<YscimcActivityTrafficStatisticsVo> flowStatistics(@Param("activityId")String activityId, @Param("date") Date date);
}
