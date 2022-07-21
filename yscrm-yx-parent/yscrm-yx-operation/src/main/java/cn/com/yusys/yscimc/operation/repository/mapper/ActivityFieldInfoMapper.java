package cn.com.yusys.yscimc.operation.repository.mapper;


import cn.com.yusys.yscimc.operation.domain.ActivityFieldInfo;
import cn.com.yusys.yscimc.operation.domain.vo.ActivityFieldInfoVo;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ActivityFieldInfoMapper extends CommonMapper<ActivityFieldInfo> {

    /**
     * 批量插入
     * @param list
     */
    int batchInsert(List<ActivityFieldInfo> list);

    int delByActId(String actId);

    List<Map<String, Object>> getMobileBankingWindows(@Param("date") String date);

    List<ActivityFieldInfoVo> getInfoByTempId(@Param("tempId") String tempId);
}
