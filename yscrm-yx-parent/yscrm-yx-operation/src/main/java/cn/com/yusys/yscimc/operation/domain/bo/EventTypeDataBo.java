package cn.com.yusys.yscimc.operation.domain.bo;

import cn.com.yusys.yusp.cm.cust.domain.AcimFCiCustomer;

import java.util.List;

/**
 * 事件类活动执行时所需的数据封装类
 */
public class EventTypeDataBo {

    private String tempId;
    private AcimFCiCustomer customer;
    private List<String> actionIdList;

    public EventTypeDataBo() {
    }

    public EventTypeDataBo(String tempId, AcimFCiCustomer customer, List<String> actionIdList) {
        this.tempId = tempId;
        this.customer = customer;
        this.actionIdList = actionIdList;
    }

    public String getTempId() {
        return tempId;
    }

    public void setTempId(String tempId) {
        this.tempId = tempId;
    }

    public AcimFCiCustomer getCustomer() {
        return customer;
    }

    public void setCustomer(AcimFCiCustomer customer) {
        this.customer = customer;
    }

    public List<String> getActionIdList() {
        return actionIdList;
    }

    public void setActionIdList(List<String> actionIdList) {
        this.actionIdList = actionIdList;
    }
}
