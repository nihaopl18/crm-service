package cn.com.yusys.yusp.cm.monitoring.repository.mapper;

import cn.com.yusys.yusp.cm.monitoring.Vo.YscimcActivityCustomerFlowVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * @author sandMan
 * @date 2022/4/11 - 10:44
 */
@Mapper
public interface YscimcActivityCustomerFlowMapper {

    List<YscimcActivityCustomerFlowVo> getcustomer(@Param("activityId")String activityId, @Param("date") Date date);
}
