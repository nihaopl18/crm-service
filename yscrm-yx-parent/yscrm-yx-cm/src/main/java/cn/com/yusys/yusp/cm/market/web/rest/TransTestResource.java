package cn.com.yusys.yusp.cm.market.web.rest;

import cn.com.yusys.yusp.cm.market.service.TransTestService;
import com.alibaba.fastjson.JSON;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ExecutionException;


//@RestController
public class TransTestResource {
	
	private final static KafkaProducer<String, String> producer;
	
	private static Logger logger = Logger.getLogger(TransTestResource.class ) ;
	private static Properties  properties = new Properties();
	
	static{
		
		try {
			 properties.load(TransTestResource.class.getClassLoader().getResourceAsStream("kafka.properties"));
		} catch (IOException e) {
			logger.error("producer读取参数错误");
		}
		System.out.println(properties.getProperty("bootstrap.servers"));
		logger = Logger.getLogger(TransTestResource.class);
		producer = new KafkaProducer<String, String>(properties);
		System.out.println(producer);
		System.out.print("producer success");
	}
	
	@Autowired
	private TransTestService transTestService;
		
	@GetMapping("/api/testtrans")
	public Map<String, Object> getTransParams(@RequestParam("transCode") String transCode){
		
		Map<String, Object> map  =new HashMap<>();
		List<Map<String, Object>> list = transTestService.queryTrans (transCode);
		for (int i=0;i<list.size();i++) {
			if("PU_TRCD".equals(list.get(i).get("field"))) {
				list.get(i).put("paramValue", transCode);
				break;
			}
		}
		Map<String, Object> nummap  =new HashMap<>();
		nummap.put("paramValue", "1");
		nummap.put("field", "SEND_NUM");
		nummap.put("label", "提交次数");
		list.add(nummap);
		map.put("data", list);	
		return map;
	}
	/**
	 * 发送测试交易
	 * @param map
	 * @return
	 * @throws InterruptedException
	 * @throws ExecutionException
	 */
	@PostMapping("/api/transsend")
	public int sendTrans(@RequestBody ArrayList<Map<String, Object>> list) throws InterruptedException, ExecutionException{	
		String topicname =properties.getProperty("topicname");
		String trcd = (String) list.get(0).get("TRANS_CODE");
		String json = JSON.toJSONString(list.get(0));
		producer.send(new ProducerRecord<>(topicname,trcd+"|"+String.valueOf(System.currentTimeMillis())+String.valueOf(0), json)).get();
		return 0;
	}
	
	public String getCurrentDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(new Date());
	}
	
	public String getCurrentTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("HHmmss");
		return sdf.format(new Date());
	}

}
