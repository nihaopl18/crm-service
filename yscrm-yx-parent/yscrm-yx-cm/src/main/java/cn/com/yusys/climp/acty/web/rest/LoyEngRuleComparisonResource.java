package cn.com.yusys.climp.acty.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.com.yusys.climp.acty.domain.LoyEngRuleComparison;
import cn.com.yusys.climp.acty.service.LoyEngRuleComparisonService;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;

/**
 * @项目名称: yusp-climp-single-starter模块
 * @类名称: LoyEngRuleComparisonResource
 * @类描述: 规则比较资源类
 * @功能描述: 
 * @创建人: chenlin2@yusys.com.cn
 * @创建时间: 2018-12-29 15:07:13
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/rulecomparison")
public class LoyEngRuleComparisonResource extends CommonResource<LoyEngRuleComparison, String> {
    @Autowired
    private LoyEngRuleComparisonService loyEngRuleComparisonService;

    @Override
    protected CommonService getCommonService() {
        return loyEngRuleComparisonService;
    }
    /**
    * @方法名称:queryRuleCondition
    * @方法描述:根据规则id查询规则比较
    * @参数与返回说明:
    * @算法描述:
     */
    @GetMapping("/queryrulecondition")
	public ResultDto<List<LoyEngRuleComparison>> queryRuleCondition(String ruleId) {
		List<LoyEngRuleComparison> list = loyEngRuleComparisonService.queryRuleCondition(ruleId);
		return new ResultDto<List<LoyEngRuleComparison>>(list);
	}
}
