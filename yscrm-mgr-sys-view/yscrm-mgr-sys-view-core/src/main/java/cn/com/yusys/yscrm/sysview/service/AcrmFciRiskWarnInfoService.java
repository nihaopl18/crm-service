package cn.com.yusys.yscrm.sysview.service;

import cn.com.yusys.yscrm.sysview.domain.RiskInfo;
import cn.com.yusys.yscrm.sysview.repository.mapper.AcrmRiskWarnInfoMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author: sxm
 * @time: 2021/8/13 11:04
 */
@Service("AcrmRiskWarnInfoService")
public class AcrmFciRiskWarnInfoService {
    @Autowired
    private AcrmRiskWarnInfoMapper acrmRiskWarnInfoMapper;

    @Transactional(readOnly = true)
    public Map<String, Object> getRiskInfo(QueryModel model) {
        Map map = new HashMap();
        Map<String, List<RiskInfo>> riskMap = acrmRiskWarnInfoMapper.getRiskInfo(model).stream().filter(obj -> {
            return obj.getRiskType() != null;
        }).collect(Collectors.groupingBy(RiskInfo::getRiskType));
        map.put("loanInfo", riskMap.get("0"));
        map.put("finInfo", riskMap.get("1"));
        map.put("amlInfo", riskMap.get("2"));
        return map;
    }

}
