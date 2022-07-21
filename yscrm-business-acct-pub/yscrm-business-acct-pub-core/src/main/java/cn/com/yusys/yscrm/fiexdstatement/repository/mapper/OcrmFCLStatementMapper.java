package cn.com.yusys.yscrm.fiexdstatement.repository.mapper;

import cn.com.yusys.yscrm.fiexdstatement.domain.OcrmFClStatement;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;

import java.util.List;
import java.util.Map;

public interface OcrmFCLStatementMapper extends CommonMapper<OcrmFClStatement> {
    List<Map<String, Object>> queryBranchList(Map<String, Object> map);

    List<Map<String, Object>> queryBranchListUnPeople(Map<String, Object> map);

    Map<String, Object> getCount(Map<String, Object> map);

    Map<String, Object> getCountUnpeople(Map<String, Object> map);
}
