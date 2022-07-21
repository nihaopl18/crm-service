package cn.com.yusys.yusp.rai.engine.data.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @description: 营销事件反馈报文
 * @author: Zhan YongQiang
 * @date: 2022/2/28 14:21
 */
public class EngMarketingEntryVo {

    /** 外部业务编号 */
    private String outTradeNo;

    /** 内部事务编号 */
    private String transactionNo;

    /** 法人号 */
    private String corpNo;

    /** 客户号 */
    private String custId;

    /** 交易类型 */
    private String transCode;

    /** 交易数据 */
    private Map<String, Object> transDataMap;

    /** 命中规则动作 */
    private List<ActionPo> actionPoList = new ArrayList<>(16);

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getTransactionNo() {
        return transactionNo;
    }

    public void setTransactionNo(String transactionNo) {
        this.transactionNo = transactionNo;
    }

    public String getCorpNo() {
        return corpNo;
    }

    public void setCorpNo(String corpNo) {
        this.corpNo = corpNo;
    }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public String getTransCode() {
        return transCode;
    }

    public void setTransCode(String transCode) {
        this.transCode = transCode;
    }

    public Map<String, Object> getTransDataMap() {
        return transDataMap;
    }

    public void setTransDataMap(Map<String, Object> transDataMap) {
        this.transDataMap = transDataMap;
    }

    public List<ActionPo> getActionPoList() {
        return actionPoList;
    }

    public void setActionPoList(List<ActionPo> actionPoList) {
        this.actionPoList = actionPoList;
    }
}
