package cn.com.yusys.yscimc.operation.config;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author Lenovo
 * @Data 2022/2/25 15:08
 */
//@Configuration
public class RabbitMQConfig {

    /**
     * 使用 JSON 序列化机制，进行消息转换
     */
    @Bean
    public MessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}
