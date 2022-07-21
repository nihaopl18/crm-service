package cn.com.yusys.yscrm.sysview.repository.mapper;

import cn.com.yusys.yscrm.sysview.domain.*;
import cn.com.yusys.yusp.commons.mapper.QueryModel;

import java.util.List;

/**
 * @author: sxm
 * @time: 2021/8/11 17:34
 */
public interface PcustViewHeaderMapper {

    List<EventInfo> getEventInfo(QueryModel model);

    BaseInfo getContactWay(QueryModel model);

    PerInfo getPerInfo(QueryModel model);

    AumInfo getAumDpsInfo(QueryModel model);

    PropertyInfo getPropertyInfo(QueryModel model);

    List<PerLabelInfo> getPerLabelInfo(QueryModel model);

    List<PerLabelInfo> getCustomLabel(QueryModel model);

    int ispcustview(QueryModel model);

    String selectinner(QueryModel queryModel);
}
