package cn.com.yusys.climp.acty.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.com.yusys.climp.acty.domain.LoyEngRuleAction;
import cn.com.yusys.climp.acty.service.LoyEngRuleActionService;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;

/**
 * @项目名称: yusp-climp-single-starter模块
 * @类名称: LoyEngRuleActionResource
 * @类描述: 规则动作资源类
 * @功能描述: 
 * @创建人: chenlin2@yusys.com.cn
 * @创建时间: 2018-12-29 15:06:00
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/loyengruleaction")
public class LoyEngRuleActionResource extends CommonResource<LoyEngRuleAction, String> {
    @Autowired
    private LoyEngRuleActionService loyEngRuleActionService;

    @Override
    protected CommonService getCommonService() {
        return loyEngRuleActionService;
    }

}
