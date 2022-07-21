package cn.com.yusys.yusp.admin.service;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import cn.com.yusys.yusp.echain.client.message.InstanceMessageProcessor;
/**
 * 后业务处理示例
 * @author figue
 *
 */
@Component
public class BizInstanceMessageProcessorDemo implements InstanceMessageProcessor {

	@Override
	public boolean should(String message) {
		//解析 message获取流程申请类型，判断是否执行 process方法
		
		return true;
	}

	@Override
	public int order() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void process(String message) throws Exception {
		// TODO Auto-generated method stub

	}

}
