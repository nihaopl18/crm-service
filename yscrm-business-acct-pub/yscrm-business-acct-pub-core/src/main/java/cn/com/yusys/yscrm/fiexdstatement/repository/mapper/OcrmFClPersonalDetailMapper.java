package cn.com.yusys.yscrm.fiexdstatement.repository.mapper;

import cn.com.yusys.yscrm.fiexdstatement.domain.OcrmFClPersonalDetail;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;

import java.util.List;
import java.util.Map;

public interface OcrmFClPersonalDetailMapper extends CommonMapper<OcrmFClPersonalDetail> {
    List<Map<String, Object>> queryDetailList(Map<String, Object> map);
}
