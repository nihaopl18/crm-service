package cn.com.yusys.yusp.cm.market.web.rest;

import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.ExecutionException;


/**
 * 
 * @author damit
 * @description 发送kafka消息方法类
 */

@SuppressWarnings("deprecation")
public class KafkaUtils {
	private final static Producer<String, String> producer;
	private static Logger logger ;
	static{
		Properties properties = new Properties();
		try {
			properties.load(KafkaUtils.class.getClassLoader().getResourceAsStream("kafka.properties"));
		} catch (IOException e) {
			logger.error("producer配置数据加载失败");
		}
		System.out.println(properties.getProperty("bootstrap.servers"));
		logger = Logger.getLogger(KafkaUtils.class);
		producer = new KafkaProducer<String, String>(properties);
		System.out.println(producer);
		System.out.print("producer success");
	}
	
	
	public static void asyncSendMsg(String TOPIC,String key,String value) throws InterruptedException, ExecutionException{
		producer.send(new ProducerRecord<>(TOPIC,key, value)).get();
		//producer.send(k);
		logger.debug("消息"+value+"发送成功");
		
	}
	
	@SuppressWarnings({ "rawtypes" })
	private static kafka.javaapi.producer.Producer createProducer() {
		Properties properties = new Properties();
		try {
			properties.load(KafkaUtils.class.getClassLoader().getResourceAsStream("kafka.properties"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
																				
		return new kafka.javaapi.producer.Producer<Integer, String>(new ProducerConfig(properties));
	}
	
	@SuppressWarnings({ "unchecked" })
	public static void mysend(String TOPIC,String value) throws InterruptedException, ExecutionException{
		
		createProducer().send(new KeyedMessage<Integer, String>(TOPIC, value));
	}
}
	