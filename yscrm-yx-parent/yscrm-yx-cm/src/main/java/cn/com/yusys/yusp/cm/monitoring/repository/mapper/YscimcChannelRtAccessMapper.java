package cn.com.yusys.yusp.cm.monitoring.repository.mapper;

import cn.com.yusys.yusp.cm.monitoring.Vo.YscimcChannelRtAccessVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;
import java.util.List;

/**
 * @author sandMan
 * @date 2022/4/12 - 14:49
 */
@Mapper
public interface YscimcChannelRtAccessMapper {
    List<YscimcChannelRtAccessVo> getchannelrtaccess(@Param("actId") String actId, @Param("date")LocalDate date);
}

