package cn.com.yusys.yusp.cm.cust.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;

import cn.com.yusys.yusp.cm.cust.domain.AcimFCiCustomer;
import cn.com.yusys.yusp.cm.cust.repository.mapper.AcimFCiCustomerMapper;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
@Service
public class AcimFCiCustomerService extends CommonService{
	@Autowired
	private AcimFCiCustomerMapper mapper;
	@Override
	public CommonMapper getMapper() {
		// TODO 自动生成的方法存根
		return this.mapper;
	}
	//查询显示，只读
	@Transactional(readOnly = true)
	public List<AcimFCiCustomer> getListByModel(QueryModel model) {
		PageHelper.startPage(model.getPage(), model.getSize());
		List<AcimFCiCustomer> list = mapper.getListByModel(model);
		PageHelper.clearPage();
		return list;
	}
	public List<AcimFCiCustomer> getListCmp(QueryModel model) {
		// TODO 自动生成的方法存根
		String custGroupIds= (String) model.getCondition().get("custGroupIds");
		String[] ids = custGroupIds.split(",");
		List<String> listids = Arrays.asList(ids);
		PageHelper.startPage(model.getPage(), model.getSize());
		List<AcimFCiCustomer> list = mapper.getCmpList(listids);
		PageHelper.clearPage();
		return list;
	}
	
	public List<AcimFCiCustomer> getCustTypeByid(String custId) {
		List<AcimFCiCustomer> list =mapper.getCustTypeByid(custId);
		return list;
	}
}
