package cn.com.yusys.yusp.rai.engine.data.domain;

import lombok.Data;

/**
 * @description 消息基础对象
 * @author chenyx7
 * @date 2019年9月23日 下午2:30:34
 * @version 1.0.0
 * @Copyright (c) yxkj
 */

@Data
public class BaseMsgVo<T> {

	/**
     * 消息ID.
     */
    private String id;
    
    /**
     * 消息标题.
     */
    private String title;

    /**
     * 消息内容
     */
    private T content;
    
    /**
     * 消息类型.
     */
    private Integer type;

    /**
     * 发送时间
     */
    private Long sendTime;
}
