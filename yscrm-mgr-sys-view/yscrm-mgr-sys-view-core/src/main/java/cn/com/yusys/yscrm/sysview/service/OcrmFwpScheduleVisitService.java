package cn.com.yusys.yscrm.sysview.service;

import cn.com.yusys.yscrm.sysview.domain.WealthFunnel;
import cn.com.yusys.yscrm.sysview.repository.mapper.OcrmFwpVisitMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: sxm
 * @time: 2021/8/16 17:51
 */
@Service
public class OcrmFwpScheduleVisitService {
    public static final String VISIT = "1";
    public static final String BUY = "2";
    public static final String ORDER = "3";
    @Autowired
    private OcrmFwpVisitMapper ocrmFwpVisitMapper;

    @Transactional(readOnly = true)
    public Map<String, Object> getWealthFunnel(QueryModel model) {
        Map<String, Object> map = new HashMap<>();

        List<WealthFunnel> list= ocrmFwpVisitMapper.getWealthFunnel(model);
        for (WealthFunnel obj:list) {
        if (VISIT.equals(obj.getBehaviorType())){
            map.put("visitInfo",obj.getBehaviorInfo());
        }
        if (BUY.equals(obj.getBehaviorType())){
            map.put("buyInfo",obj.getBehaviorInfo());
        }
        if (ORDER.equals(obj.getBehaviorType())){
            map.put("placeOrderInfo",obj.getBehaviorInfo());
        }
        }
        map.put("prodClickInfo", ocrmFwpVisitMapper.getProdClickInfo(model));
        return map;
    }
}
