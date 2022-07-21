package cn.com.yusys.yscrm.sysview.repository.mapper.activity;

import cn.com.yusys.yscrm.sysview.domain.TagAnalysisQuery;
import cn.com.yusys.yscrm.sysview.domain.activity.FunModuleStatsVO;
import cn.com.yusys.yscrm.sysview.domain.activity.LineChart;
import cn.com.yusys.yscrm.sysview.domain.activity.OrgMAUProportion;
import cn.com.yusys.yscrm.sysview.domain.activity.UserInfo;
import cn.com.yusys.yusp.commons.mapper.QueryModel;

import java.util.List;


/**
 * @author: sxm
 * @time: 2021/9/13 10:44
 */
public interface PlatformMonitoringMapper {

    List<FunModuleStatsVO> getFunModuleInfo(TagAnalysisQuery tagAnalysisQuery);

    Integer getCurrentMAU();

    Integer getLastMAU();

    /**
     * 近一个月系统登录次数
     * @return
     */
    Integer getLogins();

    Integer getLastLogins();

    /**
     * 系统用户数
     * @return
     */
    Integer getUsersCount();

    /**
     * 近一年全行MAU波动
     * @return
     */
    List<LineChart> getMAUFlct();
    /**
     * 机构月活用户占比
     * @return
     */
    List<OrgMAUProportion> getOrgMAUProportion();


    List<UserInfo> exportNoLoginUser();
}
