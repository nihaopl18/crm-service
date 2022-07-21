package cn.com.yusys.yscrm.custpub.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.yusys.yscrm.custpub.domain.AcrmFciOrgCustInfo;
import cn.com.yusys.yscrm.custpub.repository.mapper.AcrmFciOrgCustInfoMapper;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.service.CommonService;
/**
 * @项目名称: yscrm-entity-cust-pub-core模块
 * @类名称: AcrmFciOrgCustInfoService
 * @类描述: #服务类
 * @功能描述: 
 * @创建人: hyx
 * @创建时间: 2019-01-31 16:53:57
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class AcrmFciOrgCustInfoService extends CommonService {
    @Autowired
    private AcrmFciOrgCustInfoMapper acrmFciOrgCustInfoMapper;

    @Override
    protected CommonMapper<?> getMapper() {
        return this.acrmFciOrgCustInfoMapper;
    }
    
    public int upd(AcrmFciOrgCustInfo acrmFciOrgCustInfo) {
    	return this.updateSelective(getMapper(),acrmFciOrgCustInfo);
    }

	public int updateBelong(Map<String, String> record) {
		return acrmFciOrgCustInfoMapper.updateBelong(record);
		// TODO 自动生成的方法存根
		
	}

	public Map<String, Object> getCustByCustId(String custId) {
		// TODO 自动生成的方法存根
		return acrmFciOrgCustInfoMapper.getCustByCustId(custId);
	}

}
