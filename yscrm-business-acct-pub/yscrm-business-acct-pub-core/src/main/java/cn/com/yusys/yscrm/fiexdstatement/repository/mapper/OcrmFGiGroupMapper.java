package cn.com.yusys.yscrm.fiexdstatement.repository.mapper;

import cn.com.yusys.yscrm.fiexdstatement.domain.OcrmFGiGroup;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;

import java.util.List;
import java.util.Map;

public interface OcrmFGiGroupMapper extends CommonMapper<OcrmFGiGroup> {
    List<Map<String, Object>> queryList(Map<String, Object> map);
}
