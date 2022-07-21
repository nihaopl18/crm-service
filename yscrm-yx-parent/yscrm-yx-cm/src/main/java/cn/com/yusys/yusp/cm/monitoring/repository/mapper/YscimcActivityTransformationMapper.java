package cn.com.yusys.yusp.cm.monitoring.repository.mapper;

import cn.com.yusys.yusp.cm.monitoring.Vo.YscimcActivityTransformationVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

/**
 * @author sandMan
 * @date 2022/4/13 - 10:02
 */
@Mapper
public interface YscimcActivityTransformationMapper {
    YscimcActivityTransformationVo getTransformation(@Param("activityId") String activityId, @Param("date") Date date);
}
