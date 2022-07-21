package cn.com.yusys.yusp.cm.market.service;


import cn.com.yusys.climp.acty.repository.mapper.LoyEngRuleSetMapper;
import cn.com.yusys.climp.acty.repository.mapper.LoyEngTransactionRoutingMapper;
import cn.com.yusys.climp.acty.repository.mapper.LoyRlActivityMapper;
import cn.com.yusys.climp.utils.UserInfoService;
import cn.com.yusys.yusp.cm.market.repository.mapper.EngProcessMapper;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.service.CommonService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
/**
 * @项目名称：yscimc-service
 * @类名称：EngProcessService
 * @类描述：流程中的引擎执行SERVICE
 * @功能描述:
 * @创建人：hujun3 
 * @创建时间：2019-6-13
 */
@Service
public class EngProcessService  extends CommonService{
	
	private static Logger logger = Logger.getLogger(EngProcessService.class ) ;
	@Autowired
	private UserInfoService userInfo; 
	@Autowired
	private EngProcessMapper connMapper;
	@Autowired
    private LoyRlActivityMapper loyRlActivityMapper;
    @Autowired
    private LoyEngRuleSetMapper loyEngRuleSetMapper;
    @Autowired
    private LoyEngTransactionRoutingMapper loyEngTransactionRoutingMapper;
	@Override
	protected CommonMapper<?> getMapper() {
		// TODO 自动生成的方法存根
		return this.connMapper;
	}
	
	
	/**
	 * 
	* @方法名称: executeBatchClimp
	* @方法描述: 执行批量权益引擎
	* @参数与返回说明: 
	* @算法描述:主要是把节点中的规则放到规则路由中去
	 */
	public Map<String, Object>  executeBatchClimp(String nodeId) {
		Map<String, Object> result=new HashMap<String, Object>();
	
		return result;
	}
	
	/**
	 * 
	* @方法名称: executeOnlineClimp
	* @方法描述: 执行实时权益引擎
	* @参数与返回说明: 
	* @算法描述:主要是把节点中的规则放到规则路由中去
	 */
	public Map<String, Object>  executeOnlineClimp(String nodeId) {
		Map<String, Object> result=new HashMap<String, Object>();
		
		return result;
	}
	/**
	 * 
	* @方法名称: executeBatchEvent
	* @方法描述: 执行批量事件引擎
	* @参数与返回说明: 
	* @算法描述:主要是把节点中的规则放到规则路由中去
	 */
	public Map<String, Object>  executeBatchEvent(String nodeId) {
		Map<String, Object> result=new HashMap<String, Object>();
		
		return result;
	}
	/**
	 * 
	* @方法名称: executeOnlineEvent
	* @方法描述: 执行实时事件引擎
	* @参数与返回说明: 
	* @算法描述:调用具体的执行逻辑
	 */
	public Map<String, Object>  executeOnlineEvent(String nodeId) {
		Map<String, Object> result=new HashMap<String, Object>();
		
		return result;
	}
}
