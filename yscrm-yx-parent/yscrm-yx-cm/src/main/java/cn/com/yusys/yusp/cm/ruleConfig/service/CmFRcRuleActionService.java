package cn.com.yusys.yusp.cm.ruleConfig.service;


import cn.com.yusys.yusp.cm.ruleConfig.domain.CmFRcRuleAction;
import cn.com.yusys.yusp.cm.ruleConfig.repository.mapper.CmFRcRuleActionMapper;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * 
 * @项目名称: yusp-app-cm
 * @类名称: CmFRcRuleActionService
 * @类描述: 规则配置动作服务类
 * @功能描述: 
 * @创建人: chenlin2@yusys.com.cn
 * @创建时间: 2018-11-8 14:28
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2018宇信科技-版权所有
 */
@Service
public class CmFRcRuleActionService extends CommonService{

	@Autowired
	private CmFRcRuleActionMapper mapper;
	
	@Override
	protected CommonMapper<?> getMapper() {
		// TODO Auto-generated method stub
		return this.mapper;
	}
	/**
	 * 新增规则动作
	 */
	public int insert(Object record) {
		CmFRcRuleAction pool = (CmFRcRuleAction) record;
		return this.insertSelective(pool);
	}
}
