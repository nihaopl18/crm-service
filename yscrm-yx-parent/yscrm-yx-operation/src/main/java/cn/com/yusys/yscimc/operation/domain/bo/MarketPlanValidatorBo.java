package cn.com.yusys.yscimc.operation.domain.bo;

import cn.com.yusys.yusp.cm.market.domain.CimpCmMarketplan;
import cn.com.yusys.yusp.cm.market.domain.CimpCmNodeinfo;
import org.springframework.util.ObjectUtils;

import java.util.List;

/**
 * @Author Lenovo
 * @Data 2022/3/28 11:44
 */
public class MarketPlanValidatorBo {

    // 该值用于判断当前活动是否通过了校验器流程，能够正常执行；
    private boolean control;

    // 没有通过的结果是什么
    private StringBuilder resultMessage;

    // 需要被校验的活动
    private CimpCmMarketplan marketPlan;

    // 活动中的组件节点
    private List<CimpCmNodeinfo> nodesList;

    public MarketPlanValidatorBo(CimpCmMarketplan marketPlan, List<CimpCmNodeinfo> nodesList) {
        this.control = true;
        this.marketPlan = marketPlan;
        this.nodesList = nodesList;
    }

    public boolean isPassed() {
        return control;
    }

    public void setControl(boolean control) {
        this.control = control;
    }

    public CimpCmMarketplan getMarketPlan() {
        return marketPlan;
    }

    public void setMarketPlan(CimpCmMarketplan marketPlan) {
        this.marketPlan = marketPlan;
    }

    public List<CimpCmNodeinfo> getNodesList() {
        return nodesList;
    }

    public void setNodesList(List<CimpCmNodeinfo> nodesList) {
        this.nodesList = nodesList;
    }

    public String getResultMessage() {
        if (ObjectUtils.isEmpty(resultMessage)) {
            return null;
        }
        resultMessage.deleteCharAt(resultMessage.length() - 1);
        return resultMessage.toString();
    }

    public void addResultMessage(String message) {
        if (ObjectUtils.isEmpty(resultMessage)) {
            resultMessage = new StringBuilder();
        }
        resultMessage.append(message).append(",");
    }
}
