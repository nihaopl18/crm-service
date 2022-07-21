package cn.com.yusys.yscrm.custpub.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.yusys.yscrm.custpub.repository.mapper.AcrmFciCustAllMapper;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.service.CommonService;
/**
 * @项目名称: yscrm-entity-cust-pub-core模块
 * @类名称: AcrmFciCustAllService
 * @类描述: #服务类
 * @功能描述: 
 * @创建人: hyx
 * @创建时间: 2019-02-21 16:51:19
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class AcrmFciCustAllService extends CommonService {
    @Autowired
    private AcrmFciCustAllMapper acrmFciCustAllMapper;

    @Override
    protected CommonMapper<?> getMapper() {
        return acrmFciCustAllMapper;
    }

	public String getCustByCustId(String custId) {
		// TODO 自动生成的方法存根
		return acrmFciCustAllMapper.getCustByCustId(custId);
	}

	public Map<String, String> getCustTypeByCustId(String custId) {
		// TODO 自动生成的方法存根
		return acrmFciCustAllMapper.getCustTypeByCustId(custId);
	}

}
