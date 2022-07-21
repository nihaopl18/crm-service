package cn.com.yusys.yscrm.custpub.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yscrm.custpub.domain.OcrmFciGrantList;
import cn.com.yusys.yscrm.custpub.repository.mapper.OcrmFciGrantListMapper;
/**
 * @项目名称: yscrm-entity-cust-pub-core模块
 * @类名称: OcrmFciGrantListService
 * @类描述: #服务类
 * @功能描述: 
 * @创建人: hyx
 * @创建时间: 2019-04-23 10:13:32
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class OcrmFciGrantListService extends CommonService {
    @Autowired
    private OcrmFciGrantListMapper ocrmFciGrantListMapper;

    @Override
    protected CommonMapper<?> getMapper() {
        return ocrmFciGrantListMapper;
    }

	public int add(Object record) {
		// TODO 自动生成的方法存根
		return insertSelective(getMapper(), record);
	}

}
