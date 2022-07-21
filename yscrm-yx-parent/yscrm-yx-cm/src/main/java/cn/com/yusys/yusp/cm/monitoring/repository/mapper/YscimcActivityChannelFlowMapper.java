package cn.com.yusys.yusp.cm.monitoring.repository.mapper;

import cn.com.yusys.yusp.cm.monitoring.Vo.YscimcActivityChannelFlowVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * @author sandMan
 * @date 2022/4/11 - 16:10
 */
@Mapper
public interface YscimcActivityChannelFlowMapper {
    List<YscimcActivityChannelFlowVo> getchannel(@Param("activityId")String activityId, @Param("date") Date date);
}
