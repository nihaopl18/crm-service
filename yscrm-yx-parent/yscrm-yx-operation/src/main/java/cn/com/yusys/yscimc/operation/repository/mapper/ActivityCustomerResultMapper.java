package cn.com.yusys.yscimc.operation.repository.mapper;

import cn.com.yusys.yscimc.operation.domain.ActivityCustomerResultEntity;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @Author Lenovo
 * @Data 2022/3/8 12:11
 */
public interface ActivityCustomerResultMapper extends Mapper<ActivityCustomerResultEntity> {

    void saveBatch(@Param("list") List<ActivityCustomerResultEntity> list);

    Integer getCustomerNumber(@Param("tempId") String tempId);

    List<String> getResultList(@Param("tempId") String tempId);
}
