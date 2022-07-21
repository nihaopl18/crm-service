package cn.com.yusys.yscimc.operation.domain.bo;

import cn.com.yusys.yusp.cm.market.domain.CimpCmMarketplan;
import cn.com.yusys.yusp.cm.market.domain.CimpCmNodeinfo;

import java.util.List;

/**
 * 任务开始执行时所需的数据
 * @author zhangyt12
 * @date 2021/12/8 15:54
 */
public class MarketPlanInitialDataBo {
    /**
     * 活动信息
     */
    private final CimpCmMarketplan planInfo;
    /**
     * 活动相关所有节点信息
     */
    private final List<CimpCmNodeinfo> nodesList;

    public MarketPlanInitialDataBo(CimpCmMarketplan planInfo, List<CimpCmNodeinfo> nodesList) {
        this.planInfo = planInfo;
        this.nodesList = nodesList;
    }

    public CimpCmMarketplan getPlanInfo() {
        return planInfo;
    }

    public List<CimpCmNodeinfo> getNodesList() {
        return nodesList;
    }

    public CimpCmNodeinfo composeData(String executingType) {
        CimpCmNodeinfo result = null;
        for (CimpCmNodeinfo nodeInfo : nodesList) {
            if (nodeInfo.getAssemblyId().equals(executingType)) {
                result = nodeInfo;
                break;
            }
        }
        return result;
    }
}
