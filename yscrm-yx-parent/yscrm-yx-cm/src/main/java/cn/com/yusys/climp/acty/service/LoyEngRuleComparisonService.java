package cn.com.yusys.climp.acty.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.yusys.climp.acty.domain.LoyEngRuleComparison;
import cn.com.yusys.climp.acty.repository.mapper.LoyEngRuleComparisonMapper;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.service.CommonService;
/**
 * @项目名称: yusp-climp-single-starter模块
 * @类名称: LoyEngRuleComparisonService
 * @类描述: 规则比较服务类
 * @功能描述: 
 * @创建人: chenlin2@yusys.com.cn
 * @创建时间: 2018-12-29 15:07:13
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class LoyEngRuleComparisonService extends CommonService {
    @Autowired
    private LoyEngRuleComparisonMapper loyEngRuleComparisonMapper;

    @Override
    protected CommonMapper<?> getMapper() {
        return loyEngRuleComparisonMapper;
    }
    /**
    * @方法名称:queryRuleCondition
    * @方法描述:根据规则id查询规则比较
    * @参数与返回说明:
    * @算法描述:
     */
    public List<LoyEngRuleComparison> queryRuleCondition(String ruleId){
    	List<LoyEngRuleComparison> list = loyEngRuleComparisonMapper.queryRuleCondition(BigDecimal.valueOf(Long.parseLong(ruleId)));
    	return list;
    }
}
