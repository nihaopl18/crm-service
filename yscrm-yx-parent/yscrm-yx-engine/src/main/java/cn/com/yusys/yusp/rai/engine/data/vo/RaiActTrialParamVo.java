package cn.com.yusys.yusp.rai.engine.data.vo;


import cn.com.yusys.yusp.rai.engine.data.domain.ActivityPo;
import lombok.Data;

/**
 * 试算请求对象
 * @author zhangchi
 * @date 2021年8月03日 09:57:26
 * @version 1.0.0
 */
@Data
public class RaiActTrialParamVo {

    /** 调用方流水号 */
    private String serialNumber;

    /** 试算数据表 */
    private String table;
    
    /** sql条件部分 */
    private String querySql;
    
    /** sql排序部分 */
    private String orderSql;

    /** 活动交易类型 */
    private String transCode;

    private ActivityPo activity;
    /** 法人 */
    private String corpNo;

    private String createUser;
    
}
