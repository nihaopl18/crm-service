package cn.com.yusys.yscrm.sysview.repository.mapper;


import cn.com.yusys.yscrm.sysview.domain.TouchInfo;
import cn.com.yusys.yscrm.sysview.domain.TouchInfoDate;
import cn.com.yusys.yscrm.sysview.domain.TouchVisitInfoDetail;
import cn.com.yusys.yusp.commons.mapper.QueryModel;

import java.util.List;

public interface TouchInfoWorkReportMapper {

    List<TouchInfo> getBaseInfo(QueryModel model);

    List<TouchInfoDate> getVisitInfo(QueryModel model);

    List<TouchVisitInfoDetail> getVisitInfoDetail(QueryModel model);

    List<TouchInfo> getBaseBackInfo(QueryModel model);

    List<String> getVisitBackInfo(QueryModel model);
}
