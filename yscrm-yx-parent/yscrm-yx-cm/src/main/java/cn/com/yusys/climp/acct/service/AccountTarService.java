package cn.com.yusys.climp.acct.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import cn.com.yusys.climp.acct.repository.mapper.AccountTarMapper;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
/**
 * @项目名称: yusp-climp-acct模块
 * @类名称: AccountTarService
 * @类描述: #服务类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2018-12-27 10:50:42
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class AccountTarService extends CommonService {
    @Autowired
    private AccountTarMapper accountTarMapper;

    @Override
    protected CommonMapper<?> getMapper() {
        return this.accountTarMapper;
    }

	public List<Map<String, Object>> getList(QueryModel model) {
		PageHelper.startPage(model.getPage(), model.getSize());
		return accountTarMapper.getList(model);
	}
}
