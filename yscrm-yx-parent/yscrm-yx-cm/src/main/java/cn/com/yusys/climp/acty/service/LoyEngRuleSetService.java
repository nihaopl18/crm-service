package cn.com.yusys.climp.acty.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.yusys.climp.acty.repository.mapper.LoyEngRuleSetMapper;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.service.CommonService;
/**
 * @项目名称: yusp-climp-single-starter模块
 * @类名称: LoyEngRuleSetService
 * @类描述: 规则集服务类
 * @功能描述: 
 * @创建人: chenlin2@yusys.com.cn
 * @创建时间: 2019-01-03 09:40:55
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class LoyEngRuleSetService extends CommonService {
    @Autowired
    private LoyEngRuleSetMapper loyEngRuleSetMapper;

    @Override
    protected CommonMapper<?> getMapper() {
        return loyEngRuleSetMapper;
    }

}
