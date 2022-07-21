package cn.com.yusys.yusp.cm.monitoring.repository.mapper;

import cn.com.yusys.yusp.cm.monitoring.Vo.YscimcFieldRtAccessVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;
import java.util.List;

/**
 * @author sandMan
 * @date 2022/4/12 - 16:29
 */
@Mapper
public interface YscimcFieldRtAccessMapper {
    List<YscimcFieldRtAccessVo> getchannelrtaccess(@Param("actId") String actId, @Param("date") LocalDate date);
}
