package cn.com.yusys.yscrm.custpub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yscrm.custpub.domain.OcrmFciTrusteeshipList;
import cn.com.yusys.yscrm.custpub.repository.mapper.OcrmFciTrusteeshipListMapper;
/**
 * @项目名称: yscrm-entity-cust-pub-core模块
 * @类名称: OcrmFciTrusteeshipListService
 * @类描述: #服务类
 * @功能描述: 
 * @创建人: hyx
 * @创建时间: 2019-04-20 16:40:02
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class OcrmFciTrusteeshipListService extends CommonService {
    @Autowired
    private OcrmFciTrusteeshipListMapper ocrmFciTrusteeshipListMapper;

    @Override
    protected CommonMapper<?> getMapper() {
        return ocrmFciTrusteeshipListMapper;
    }

	public int add(Object ocrmFciTrusteeshipList) {
		// TODO 自动生成的方法存根
		return insertSelective(getMapper(), ocrmFciTrusteeshipList);
	}

}
