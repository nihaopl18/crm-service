package cn.com.yusys.climp.acty.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.yusys.climp.acty.repository.mapper.LoyEngTransactionRoutingMapper;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.service.CommonService;
/**
 * @项目名称: yusp-climp-single-starter模块
 * @类名称: LoyEngTransactionRoutingService
 * @类描述: 交易路由服务类
 * @功能描述: 
 * @创建人: chenlin2@yusys.com.cn
 * @创建时间: 2019-01-03 09:41:08
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class LoyEngTransactionRoutingService extends CommonService {
    @Autowired
    private LoyEngTransactionRoutingMapper loyEngTransactionRoutingMapper;

    @Override
    protected CommonMapper<?> getMapper() {
        return loyEngTransactionRoutingMapper;
    }

}
