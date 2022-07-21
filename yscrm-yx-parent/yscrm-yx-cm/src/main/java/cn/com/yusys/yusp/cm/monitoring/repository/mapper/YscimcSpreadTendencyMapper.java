package cn.com.yusys.yusp.cm.monitoring.repository.mapper;

import cn.com.yusys.yusp.cm.monitoring.Vo.YscimcSpreadTendencyVo;
import cn.com.yusys.yusp.cm.monitoring.entity.YscimcSpreadTendencyPo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;

/**
 * 传播趋势表
 *
 * @author houyx3
 * @email houyx3@yusys.com.cn
 * @date 2022-04-16 14:15:48
 */
@Mapper
public interface YscimcSpreadTendencyMapper extends BaseMapper<YscimcSpreadTendencyPo> {

    List<YscimcSpreadTendencyVo> getLastDataForMonth(@Param("activityId") String activityId,@Param("month") int month);
}
