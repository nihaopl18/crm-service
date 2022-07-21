package cn.com.yusys.yscrm.sysview.repository.mapper;

import cn.com.yusys.yscrm.sysview.domain.RiskInfo;
import cn.com.yusys.yusp.commons.mapper.QueryModel;

import java.util.List;

/**
 * @author: sxm
 * @time: 2021/8/13 10:59
 */
public interface AcrmRiskWarnInfoMapper {

    List<RiskInfo> getRiskInfo(QueryModel model);
}
