package cn.com.yusys.yscrm.fiexdstatement.repository.mapper;

import cn.com.yusys.yscrm.fiexdstatement.domain.OcrmFClDepositincome;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;

import java.util.List;
import java.util.Map;

public interface OcrmFClDepositincomeMapper extends CommonMapper<OcrmFClDepositincome> {
    List<Map<String, Object>> getIncomeList(Map<String, Object> map);
}
