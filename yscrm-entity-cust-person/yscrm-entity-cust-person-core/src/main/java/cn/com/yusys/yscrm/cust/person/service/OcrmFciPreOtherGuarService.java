package cn.com.yusys.yscrm.cust.person.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yscrm.cust.person.domain.OcrmFciPreOtherFin;
import cn.com.yusys.yscrm.cust.person.domain.OcrmFciPreOtherGuar;
import cn.com.yusys.yscrm.cust.person.repository.mapper.OcrmFciPreOtherGuarMapper;
/**
 * @项目名称: yscrm-entity-cust-person-core模块
 * @类名称: OcrmFciPreOtherGuarService
 * @类描述: #服务类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2019-02-27 14:42:33
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class OcrmFciPreOtherGuarService extends CommonService {
    @Autowired
    private OcrmFciPreOtherGuarMapper ocrmFciPreOtherGuarMapper;

    @Override
    protected CommonMapper<?> getMapper() {
        return this.ocrmFciPreOtherGuarMapper;
    }
    /**
     * 理财修改
     * @param model
     * @param 
     * @return
     */
	public int updateguarInfo(OcrmFciPreOtherGuar c) {
		
		return this.updateSelective(c);
	}
	 /**
     * 理财新增
     * @param model
     * @param 
     * @return
     */
	public int insertguarInfo(OcrmFciPreOtherGuar c) {
		
		return this.insertSelective(c);
	}
}
