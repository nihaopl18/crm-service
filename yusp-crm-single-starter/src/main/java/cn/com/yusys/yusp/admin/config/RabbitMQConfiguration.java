//package cn.com.yusys.yusp.admin.config;
//
//import org.springframework.amqp.core.Queue;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import cn.com.yusys.yusp.message.service.message.mq.MessageQueueConstants;
//import cn.com.yusys.yusp.message.service.message.mq.MessageSender;
//import cn.com.yusys.yusp.message.service.message.mq.rabbitmq.RabbitMQMessageSender;
//
//@Configuration
//public class RabbitMQConfiguration {
//	@Autowired
//	private RabbitTemplate rabbitTemplate;
//	
//	@Bean
//	public Queue messageQueue() {
//		Queue queue = new Queue(MessageQueueConstants.MESSAGE_QUEUE,true);
//		return queue; 
//	}
//	
//	@Bean
//	public Queue messageDelayQueue() {
//		Queue queue = new Queue(MessageQueueConstants.MESSAGE_DELAY_QUEUE,true);
//		return queue; 
//	}
//	
//	@Bean
//	public MessageSender MessageSender() {
//		MessageSender rabbitMQMessageSender = new RabbitMQMessageSender(rabbitTemplate);
//		return rabbitMQMessageSender;
//	}
//}
