package cn.com.yusys.yscrm.custpub.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yscrm.custpub.domain.OcrmFciCustUpdateHis;
import cn.com.yusys.yscrm.custpub.repository.mapper.OcrmFciCustUpdateHisMapper;
/**
 * @项目名称: yscrm-entity-cust-pub-core模块
 * @类名称: OcrmFciCustUpdateHisService
 * @类描述: #服务类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2019-01-31 15:48:15
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class OcrmFciCustUpdateHisService extends CommonService {
    @Autowired
    private OcrmFciCustUpdateHisMapper ocrmFciCustUpdateHisMapper;

    @Override
    protected CommonMapper<?> getMapper() {
        return this.ocrmFciCustUpdateHisMapper;
    }
    /**
	 * 
	* @方法名称: queryIdentList
	* @方法描述: 根据证件ID查询证件信息
	* @参数与返回说明: 
	* @算法描述:
	 */
	@Transactional(readOnly = true)
	public List<Map<String, Object>> queryHistory(QueryModel model) {
		   
		    PageHelper.startPage(model.getPage(),model.getSize());
			
			List<Map<String, Object>> list=ocrmFciCustUpdateHisMapper.queryHistory(model);
			PageHelper.clearPage();
			return list;
	}
}
