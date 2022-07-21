package cn.com.yusys.yusp.cm.monitoring.repository.mapper;

import cn.com.yusys.yusp.cm.monitoring.Vo.YscimcRightDistributionTrendVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;
import java.util.List;

/**
 * @author sandMan
 * @date 2022/4/13 - 11:16
 */
@Mapper
public interface YscimcRightDistributionTrendMapper {
    List<YscimcRightDistributionTrendVo> getRightDistributionTrend(@Param("actId") String actId, @Param("date") LocalDate date);
}
