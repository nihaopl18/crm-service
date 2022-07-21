package cn.com.yusys.yscrm.custmgr.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import cn.com.yusys.yscrm.custmgr.repository.mapper.CustMgrBelonginfoMapper;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;

/**
 * @项目名称: yusp-crm-single-starter模块
 * @类名称: CustMgrBelonginfoService
 * @类描述: #服务类
 * @功能描述:
 * @创建人: Administrator
 * @创建时间: 2019-01-22 17:25:12
 * @修改备注:
 * @修改记录: 修改时间 修改人员 修改原因
 *        -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class CustMgrBelonginfoService extends CommonService {
	@Autowired
	private CustMgrBelonginfoMapper custMgrBelonginfoMapper;

	@Override
	protected CommonMapper<?> getMapper() {
		return custMgrBelonginfoMapper;
	}

	/**
	 * 列表查询
	 * 
	 * @param queryModel
	 * @param mgrId 客户经理编号
	 * @return
	 */
	public List<Map<String, Object>> querylist(QueryModel queryModel,String mgrId) {
		queryModel.getCondition().put("mgrId", mgrId);
		PageHelper.startPage(queryModel.getPage(), queryModel.getSize());
		List<Map<String, Object>> list = custMgrBelonginfoMapper.querylist(queryModel);
		PageHelper.clearPage();
		return list;
	}

}
