package cn.com.yusys.yscrm.cust.person.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yscrm.cust.person.domain.OcrmFciPerOthbankDep;
import cn.com.yusys.yscrm.cust.person.domain.OcrmFciPerOthbankLoan;
import cn.com.yusys.yscrm.cust.person.repository.mapper.OcrmFciPerOthbankLoanMapper;
/**
 * @项目名称: yscrm-entity-cust-person-core模块
 * @类名称: OcrmFciPerOthbankLoanService
 * @类描述: #服务类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2019-02-27 14:40:36
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class OcrmFciPerOthbankLoanService extends CommonService {
    @Autowired
    private OcrmFciPerOthbankLoanMapper ocrmFciPerOthbankLoanMapper;

    @Override
    protected CommonMapper<?> getMapper() {
        return this.ocrmFciPerOthbankLoanMapper;
    }
    /**
     * 贷款款修改
     * @param model
     * @param 
     * @return
     */
	public int updateloanInfo(OcrmFciPerOthbankLoan c) {
		
		return this.updateSelective(c);
	}
	 /**
     * 贷款新增
     * @param model
     * @param 
     * @return
     */
	public int insertloanInfo(OcrmFciPerOthbankLoan c) {
		
		return this.insertSelective(c);
	}
}
