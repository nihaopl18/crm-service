package cn.com.yusys.yscrm.cust.person.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yscrm.cust.person.domain.OcrmFciPerOthbankLoan;
import cn.com.yusys.yscrm.cust.person.domain.OcrmFciPreOtherFin;
import cn.com.yusys.yscrm.cust.person.repository.mapper.OcrmFciPreOtherFinMapper;
/**
 * @项目名称: yscrm-entity-cust-person-core模块
 * @类名称: OcrmFciPreOtherFinService
 * @类描述: #服务类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2019-02-27 14:41:29
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class OcrmFciPreOtherFinService extends CommonService {
    @Autowired
    private OcrmFciPreOtherFinMapper ocrmFciPreOtherFinMapper;

    @Override
    protected CommonMapper<?> getMapper() {
        return this.ocrmFciPreOtherFinMapper;
    }
    /**
     * 理财修改
     * @param model
     * @param 
     * @return
     */
	public int updatefinInfo(OcrmFciPreOtherFin c) {
		
		return this.updateSelective(c);
	}
	 /**
     * 理财新增
     * @param model
     * @param 
     * @return
     */
	public int insertfinInfo(OcrmFciPreOtherFin c) {
		
		return this.insertSelective(c);
	}
}
