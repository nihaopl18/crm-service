package cn.com.yusys.yusp.cm.monitoring.repository.mapper;

import cn.com.yusys.yusp.cm.monitoring.Vo.YscimcActReActiveVo;
import cn.com.yusys.yusp.cm.monitoring.entity.YscimcActReActivePo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.BaseMapper;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 活动效果监控
 *
 * @author houyx3
 * @email houyx3@yusys.com.cn
 * @date 2022-04-08 17:10:44
 */
@Mapper
public interface YscimcActReActiveMapper extends BaseMapper<YscimcActReActivePo> {

   List<YscimcActReActiveVo> getListByActIdAndDate(@Param("actId") String actId,@Param("date") LocalDate date);


   YscimcActReActiveVo getLastDataByDate(@Param("actId") String actId, @Param("currentDate") LocalDateTime currentDate);
}
