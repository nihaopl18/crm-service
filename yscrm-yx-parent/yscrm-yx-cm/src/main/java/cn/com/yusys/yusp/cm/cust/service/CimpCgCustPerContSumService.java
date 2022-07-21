package cn.com.yusys.yusp.cm.cust.service;


import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.yusys.yusp.cm.cust.domain.CimpCViewPubRelation;
import cn.com.yusys.yusp.cm.cust.repository.mapper.CimpCgCustPerContSumMapper;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
@Service
public class CimpCgCustPerContSumService extends CommonService{
	private final Logger log = LoggerFactory.getLogger(CimpCViewPubRelation.class);
	@Autowired
	private CimpCgCustPerContSumMapper mapper;
	@Override
	protected CommonMapper getMapper() {
		// TODO 自动生成的方法存根
		return this.mapper;
	}
	public List<Map<String, Object>> getListByModel(QueryModel queryModel) {
		// TODO 自动生成的方法存根
		String  custId = (String) queryModel.getCondition().get("custId");
		List<Map<String, Object>> list = mapper.getListById(custId);
		return list;
	}
}
