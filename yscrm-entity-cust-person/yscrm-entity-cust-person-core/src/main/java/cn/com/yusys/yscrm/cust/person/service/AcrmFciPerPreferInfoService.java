package cn.com.yusys.yscrm.cust.person.service;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.com.yusys.yscrm.cust.person.domain.AcrmFciPerPreferInfo;
import cn.com.yusys.yscrm.cust.person.repository.mapper.AcrmFciPerPreferInfoMapper;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;

/**
 * @项目名称: yscrm-entity-cust-person-core模块
 * @类名称: AcrmFciPerPreferInfoService
 * @类描述: #服务类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2019-02-11 20:34:06
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class AcrmFciPerPreferInfoService extends CommonService {
    @Autowired
    private AcrmFciPerPreferInfoMapper acrmFciPerPreferInfoMapper;

    @Override
    protected CommonMapper<?> getMapper() {
        return this.acrmFciPerPreferInfoMapper;
    }
	@Transactional(readOnly = true) 
	public List<Map<Object, String>> getPerpreList(QueryModel model,String custId) {
		Map<String, String> paramMap=new HashMap<String, String>();
		paramMap.put("custId", custId);
		// TODO 自动生成的方法存根
		return acrmFciPerPreferInfoMapper.getPerpreList(paramMap);
	}
	public int updateperpre(AcrmFciPerPreferInfo acrmFciPerPreferInfo) {
		
	   return	this.updateSelective(acrmFciPerPreferInfo);
	}
	public int insertperpre(AcrmFciPerPreferInfo acrmFciPerPreferInfo) {
		
	   return	this.insertSelective(acrmFciPerPreferInfo);
	}
}
