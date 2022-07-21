package cn.com.yusys.yscrm.fiexdstatement.repository.mapper;

import cn.com.yusys.yscrm.fiexdstatement.domain.OcrmFClDepositincome;
import cn.com.yusys.yscrm.fiexdstatement.domain.OcrmFClNationality;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;

import java.util.List;
import java.util.Map;

public interface OcrmFClNationalityMapper extends CommonMapper<OcrmFClNationality> {
    List<Map<String, Object>> getList(QueryModel queryModel);

    List<OcrmFClNationality> queryByAreaNo(String areaNo);

    List<Map<String, Object>> getNationality();

    int getCountByArea(String lastAreaNo);

    List<Map<String, Object>> getAreaNoList();
}
