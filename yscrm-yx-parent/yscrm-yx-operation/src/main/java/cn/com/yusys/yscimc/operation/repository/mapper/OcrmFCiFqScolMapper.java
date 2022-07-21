package cn.com.yusys.yscimc.operation.repository.mapper;

import cn.com.yusys.yscimc.operation.domain.OcrmFCiFqScol;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface OcrmFCiFqScolMapper extends CommonMapper<OcrmFCiFqScol> {
    List<Map<String, Object>> getScol(String ssId);

    void deletebyssid(String ssId);

    Map<String, String> getUuid(String orgCode);

    /**
     * 通过ssId获取查询信息与数据库对应信息
     */
    List<Map<String, Object>> getScolAndDbcol(String ssId);
}

