package cn.com.yusys.yusp.cm.monitoring.repository.mapper;

import cn.com.yusys.yusp.cm.monitoring.Vo.YscimcActivityTrafficSourceVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * @author sandMan
 * @date 2022/4/8 - 17:04
 */
@Mapper
public interface YscimcActivityTrafficSourceMapper {
    List<YscimcActivityTrafficSourceVo> getflowsource(@Param("activityId")String activityId, @Param("date") Date date);
}
