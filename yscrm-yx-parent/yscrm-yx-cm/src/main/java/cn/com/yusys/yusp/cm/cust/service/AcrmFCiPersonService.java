package cn.com.yusys.yusp.cm.cust.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import cn.com.yusys.yusp.cm.cust.domain.AcrmFCiPerson;
import cn.com.yusys.yusp.cm.cust.repository.mapper.AcrmFCiPersonMapper;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.service.CommonService;
@Service
public class AcrmFCiPersonService extends CommonService{
	@Autowired
	private AcrmFCiPersonMapper mapper;
	@Override
	protected CommonMapper getMapper() {
		// TODO 自动生成的方法存根
		return this.mapper;
	}
	public int add(AcrmFCiPerson acrmFCiPerson) {
		return insertSelective(getMapper(), acrmFCiPerson);
	}
}
