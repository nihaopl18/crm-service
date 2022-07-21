package cn.com.yusys.climp.acty.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.com.yusys.climp.acty.domain.LoyEngRuleSet;
import cn.com.yusys.climp.acty.service.LoyEngRuleSetService;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;

/**
 * @项目名称: yusp-climp-single-starter模块
 * @类名称: LoyEngRuleSetResource
 * @类描述: 规则集资源类
 * @功能描述: 
 * @创建人: chenlin2@yusys.com.cn
 * @创建时间: 2019-01-03 09:40:55
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/loyengruleset")
public class LoyEngRuleSetResource extends CommonResource<LoyEngRuleSet, String> {
    @Autowired
    private LoyEngRuleSetService loyEngRuleSetService;

    @Override
    protected CommonService getCommonService() {
        return loyEngRuleSetService;
    }

}
