package cn.com.yusys.yusp.rai.engine.data.vo;

import lombok.Data;

/**
 * 权益入账对象
 * @author zhangchi
 * @date 2021年8月19日 18:42:03
 * @version 1.0.0
 */
@Data
public class EngRaiDetailVo {

    /*活动id*/
    private String actId;

    /*规则id*/
    private String ruleId;

    /*动作id*/
    private String actionId;
    
    /** 账户号 */
    private String  accountNo;

    /*成本分摊id*/
    private String raiCostId;

    /*权益类型*/
    private String raiType;

    /*权益编号，积分池编号/卡券id/游戏id/礼品id*/
    private String raiNo;

    /*权益数量*/
    private Integer raiNum;

    /*有效期类型*/
    private String validType;

    /*有效期*/
    private String validDate;
    
    /** 库存模式 */
    private String limitMode;
    
    /** 封顶模式 */
    private String topType;
    
    /** 封顶值 */
    private String topValue;

    /** 封顶结果 */
    private Integer topNum;
    
    /** 礼品规格id */
    private String modelId;
}
