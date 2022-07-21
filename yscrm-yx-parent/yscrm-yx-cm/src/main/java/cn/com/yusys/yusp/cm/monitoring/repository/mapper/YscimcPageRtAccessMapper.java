package cn.com.yusys.yusp.cm.monitoring.repository.mapper;

import cn.com.yusys.yusp.cm.monitoring.Vo.YscimcPageRtAccessVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;
import java.util.List;

/**
 * @author sandMan
 * @date 2022/4/12 - 10:50
 */
@Mapper
public interface YscimcPageRtAccessMapper {
    List<YscimcPageRtAccessVo> getpagertaccess(@Param("actId") String actId, @Param("date") LocalDate date);
}
