package cn.com.yusys.yscrm.sysview.repository.mapper;

import cn.com.yusys.yscrm.sysview.domain.BehaviorInfo;
import cn.com.yusys.yscrm.sysview.domain.WealthFunnel;
import cn.com.yusys.yusp.commons.mapper.QueryModel;

import java.util.List;

/**
 * @author: sxm
 * @time: 2021/8/16 17:52
 */
public interface OcrmFwpVisitMapper {

    List<WealthFunnel> getWealthFunnel(QueryModel model);

    List<BehaviorInfo> getProdClickInfo(QueryModel model);
}
