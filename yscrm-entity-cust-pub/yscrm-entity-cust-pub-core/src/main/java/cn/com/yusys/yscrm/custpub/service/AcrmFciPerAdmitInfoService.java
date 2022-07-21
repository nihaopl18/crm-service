package cn.com.yusys.yscrm.custpub.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.yusys.yscrm.custpub.repository.mapper.AcrmFciPerAdmitInfoMapper;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.service.CommonService;
/**
 * @项目名称: yscrm-entity-cust-pub-core模块
 * @类名称: AcrmFciPerAdmitInfoService
 * @类描述: #服务类
 * @功能描述: 
 * @创建人: hyx
 * @创建时间: 2019-01-31 16:45:04
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class AcrmFciPerAdmitInfoService extends CommonService {
    @Autowired
    private AcrmFciPerAdmitInfoMapper acrmFciPerAdmitInfoMapper;

    @Override
    protected CommonMapper<?> getMapper() {
        return this.acrmFciPerAdmitInfoMapper;
    }

	public int updateBelong(Map<String, String> record) {
		return acrmFciPerAdmitInfoMapper.updateBelong(record);
		// TODO 自动生成的方法存根
		
	}

	public void add(Map<String, Object> perCust) {
		// TODO 自动生成的方法存根
		this.insertSelective(getMapper(), perCust);
	}

}
