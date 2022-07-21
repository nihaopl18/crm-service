package cn.com.yusys.yusp.cm.monitoring.repository.mapper;

import cn.com.yusys.yusp.cm.monitoring.Vo.YscimcSpreadStatisticsVo;
import cn.com.yusys.yusp.cm.monitoring.entity.YscimcSpreadStatisticsPo;
import org.apache.ibatis.annotations.Mapper;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;

/**
 * 传播统计表
 *
 * @author houyx3
 * @email houyx3@yusys.com.cn
 * @date 2022-04-16 14:15:48
 */
@Mapper
public interface YscimcSpreadStatisticsMapper extends BaseMapper<YscimcSpreadStatisticsPo> {

    List<YscimcSpreadStatisticsVo> getListTopten(String activityId);
}
