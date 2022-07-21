package cn.com.yusys.yscrm.cust.person.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yscrm.cust.person.domain.OcrmFciPerOthbankDep;
import cn.com.yusys.yscrm.cust.person.repository.mapper.OcrmFciPerOthbankDepMapper;
/**
 * @项目名称: yscrm-entity-cust-person-core模块
 * @类名称: OcrmFciPerOthbankDepService
 * @类描述: #服务类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2019-02-27 14:39:33
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class OcrmFciPerOthbankDepService extends CommonService {
    @Autowired
    private OcrmFciPerOthbankDepMapper ocrmFciPerOthbankDepMapper;

    @Override
    protected CommonMapper<?> getMapper() {
        return this.ocrmFciPerOthbankDepMapper;
    }
    /**
     * 存款修改
     * @param model
     * @param 
     * @return
     */
	public int updatedepInfo(OcrmFciPerOthbankDep c) {
		
		return this.updateSelective(c);
	}
	 /**
     * 存款新增
     * @param model
     * @param 
     * @return
     */
	public int insertdepInfo(OcrmFciPerOthbankDep c) {
		
		return this.insertSelective(c);
	}
}
