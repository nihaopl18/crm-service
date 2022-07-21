package cn.com.yusys.yscimc.operation.repository.mapper;

import cn.com.yusys.yscimc.operation.domain.ActivityEventResultEntity;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

public interface ActivityEventResultMapper extends Mapper<ActivityEventResultEntity> {

    String distinctTransCodeByTempId(@Param("tempId") String tempId);
}
