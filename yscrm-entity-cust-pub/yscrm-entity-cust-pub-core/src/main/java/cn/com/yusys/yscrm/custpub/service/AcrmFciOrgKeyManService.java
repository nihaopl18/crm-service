package cn.com.yusys.yscrm.custpub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yscrm.custpub.domain.AcrmFciOrgKeyMan;
import cn.com.yusys.yscrm.custpub.repository.mapper.AcrmFciOrgKeyManMapper;
/**
 * @项目名称: yscrm-entity-cust-pub-core模块
 * @类名称: AcrmFciOrgKeyManService
 * @类描述: #服务类
 * @功能描述: 
 * @创建人: hyx
 * @创建时间: 2019-03-07 17:02:58
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class AcrmFciOrgKeyManService extends CommonService {
    @Autowired
    private AcrmFciOrgKeyManMapper acrmFciOrgKeyManMapper;

    @Override
    protected CommonMapper<?> getMapper() {
        return acrmFciOrgKeyManMapper;
    }

	public int updatePoten(AcrmFciOrgKeyMan acrmFciOrgKeyMan) {
		// TODO 自动生成的方法存根
		return acrmFciOrgKeyManMapper.updatePoten(acrmFciOrgKeyMan);
	}

}
