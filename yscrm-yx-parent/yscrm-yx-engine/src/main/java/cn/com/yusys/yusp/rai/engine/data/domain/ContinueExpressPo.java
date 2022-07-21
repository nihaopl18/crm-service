package cn.com.yusys.yusp.rai.engine.data.domain;

import cn.com.yusys.yusp.rai.engine.data.enums.ContActionStoreTypeEnum;
import cn.com.yusys.yusp.rai.engine.data.enums.CountCycleTypeEnum;
import cn.com.yusys.yusp.rai.engine.data.enums.CountTypeEnum;
import lombok.Data;


/**
 * 连续表达式信息对象
 * @author zhangchi
 * @date 2021年12月06日 15:03:02
 * @version 1.0.0
 */
@Data
public class ContinueExpressPo {

    /**
     * 统计的字段
     */
    private String fieldName;

    /**
     * 统计类型
     */
    private CountTypeEnum countType;

    /**
     * 统计周期类型
     */
    private CountCycleTypeEnum countCycleType;

    /**
     * 指定天数 ：当@CountCycleType.COUNT_CYCLE_DAY 活动期间的时候
     */
    private Long days;

    /**
     * 开始日期
     */
    private String beginDate;

    /**
     * 结束日期
     */
    private String endDate;

    /**
     * 对比动作操作
     */
    private ContActionStoreTypeEnum contActionStore;

    /**
     * 需要比较的值
     */
    private String compareValue;


}
