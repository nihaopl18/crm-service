package cn.com.yusys.yusp.cm.monitoring.repository.mapper;

import cn.com.yusys.yusp.cm.monitoring.Vo.YscimcActReRoiVo;
import cn.com.yusys.yusp.cm.monitoring.entity.YscimcActReRoiPo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.BaseMapper;

import java.time.LocalDateTime;

/**
 * 活动效果ROI
 *
 * @author houyx3
 * @email houyx3@yusys.com.cn
 * @date 2022-04-08 17:10:44
 */
@Mapper
public interface YscimcActReRoiMapper extends BaseMapper<YscimcActReRoiPo> {

    YscimcActReRoiVo getLastDataByDate(@Param("actId") String actId,@Param("date") LocalDateTime date);
}
