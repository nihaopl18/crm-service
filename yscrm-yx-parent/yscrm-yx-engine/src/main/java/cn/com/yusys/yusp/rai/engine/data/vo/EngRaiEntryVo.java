package cn.com.yusys.yusp.rai.engine.data.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * 权益入账对象
 * @author zhangchi
 * @date 2021年8月19日 18:38:22
 * @version 1.0.0
 */
@Data
public class EngRaiEntryVo {

    /** 客户号 */
    private String custId;

    /** 法人号 */
    private String corpNo;

    /** 外部业务号 */
    private String outTradeNo;

    /** 内部事务号 */
    private String transactionNo;
    
    /** 订单金额 */
    private BigDecimal transAmt;
    
    /** 交易时间 */
    private String transTime;
    /** 交易数据 */
    private Map<String, Object> transDataMap;
    
    /** 权益结果集合 */
    private List<EngRaiDetailVo> detailList;
}
