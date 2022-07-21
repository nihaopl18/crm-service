package cn.com.yusys.yscrm.fiexdstatement.repository.mapper;

import cn.com.yusys.yscrm.fiexdstatement.domain.OcrmFClBranchtotal;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;

import java.util.List;
import java.util.Map;

public interface OcrmFClBranchtotalMapper extends CommonMapper<OcrmFClBranchtotal> {


    OcrmFClBranchtotal queryStatistics();



    List<Map<String, Object>> queryBranchTotalList(Map<String, Object> map);

    List<Map<String, Object>> queryBranchTotalListUnPeople(Map<String, Object> map);

    Map<String, Object> getSumBrach(Map<String, Object> map);

    Map<String, Object> getSumBrachUnPeople(Map<String, Object> map);
}
