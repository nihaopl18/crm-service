package cn.com.yusys.yscrm.fiexdstatement.repository.mapper;

import cn.com.yusys.yscrm.fiexdstatement.domain.OcrmFClAumbalance;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;

import java.util.List;
import java.util.Map;

public interface OcrmFClAumbalanceMapper extends CommonMapper<OcrmFClAumbalance> {
    List<Map<String, Object>> getBalanceList(Map<String, Object> map);

    OcrmFClAumbalance queryBybrchNo(Map<String, Object> param);

    OcrmFClAumbalance getAumBalanceSum(Map<String, Object> param);


    OcrmFClAumbalance queryCountBybatchArea(Map<String, Object> param);

    OcrmFClAumbalance queryCountAll(Map<String, Object> param);
}
