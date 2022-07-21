package cn.com.yusys.yusp.cm.cust.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.yusys.yusp.cm.cust.domain.AcrmFCiOrg;
import cn.com.yusys.yusp.cm.cust.repository.mapper.AcrmFCiOrgMapper;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.service.CommonService;
@Service
public class AcrmFCiOrgService extends CommonService{
	@Autowired
	private AcrmFCiOrgMapper mapper;
	@Override
	protected CommonMapper getMapper() {
		// TODO 自动生成的方法存根
		return this.mapper;
	}
	public int add(AcrmFCiOrg acrmFCiOrg) {
		return insertSelective(getMapper(), acrmFCiOrg);
	}
}
