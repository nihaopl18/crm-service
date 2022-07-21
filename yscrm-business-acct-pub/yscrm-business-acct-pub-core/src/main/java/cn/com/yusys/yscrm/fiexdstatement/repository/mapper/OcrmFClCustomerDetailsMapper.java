package cn.com.yusys.yscrm.fiexdstatement.repository.mapper;

import cn.com.yusys.yscrm.fiexdstatement.domain.OcrmFClBranchtotal;
import cn.com.yusys.yscrm.fiexdstatement.domain.OcrmFClCustomerDetails;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;

import java.util.List;
import java.util.Map;

public interface OcrmFClCustomerDetailsMapper extends CommonMapper<OcrmFClCustomerDetails> {


    List<OcrmFClCustomerDetails> queryBranchList(Map<String, Object> map);

    List<Map<String, Object>> queryBranchListUnPeople(Map<String, Object> map);
}
