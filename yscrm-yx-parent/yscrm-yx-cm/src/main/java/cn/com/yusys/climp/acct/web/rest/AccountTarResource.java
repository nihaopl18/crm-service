package cn.com.yusys.climp.acct.web.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.com.yusys.climp.acct.domain.LoyAcScoreAcctHis;
import cn.com.yusys.climp.acct.service.AccountTarService;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;

/**
 * @项目名称: yusp-climp-acct模块
 * @类名称: AccountTarResource
 * @类描述: #资源类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2018-12-27 10:50:42
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/accttar")
public class AccountTarResource extends CommonResource<LoyAcScoreAcctHis, String> {
    @Autowired
    private AccountTarService accountTarService;

    @Override
    protected CommonService getCommonService() {
        return accountTarService;
    }
    
    //账户轨迹查询
    @GetMapping("/accttarquery")
    public ResultDto<List<Map<String, Object>>> getList(QueryModel model) {
		return new ResultDto<List<Map<String, Object>>>(accountTarService.getList(model));
	}
}
