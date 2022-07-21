package cn.com.yusys.yscrm.cust.person.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;

import cn.com.yusys.yscrm.cust.person.repository.mapper.OcrmFwpOrgScheduleVisitMapper;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
/**
 * @项目名称: demo-app-single-starter模块
 * @类名称: OcrmFwpScheduleVisitService
 * @类描述: #服务类
 * @功能描述: 客户接触信息
 * @创建人: 15104
 * @创建时间: 2019-02-14 17:55:22
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class OcrmFwpOrgScheduleVisitService extends CommonService {
    @Autowired
    private OcrmFwpOrgScheduleVisitMapper ocrmFwpScheduleVisitMapper;

    @Override
    protected CommonMapper<?> getMapper() {
        return ocrmFwpScheduleVisitMapper;
    }

    /**
	 * @方法名称: querylist
	 * @方法描述: 查询
	 * @param
	 * @return
	 */
	@Transactional(readOnly = true)
	public List<Map<Object, String>> querylist(QueryModel model, String custId) {
		PageHelper.startPage(model.getPage(), model.getSize());
		
		model.getCondition().put("custId", custId);
		List<Map<Object, String>>  list = ocrmFwpScheduleVisitMapper.querylist(model);
		
		PageHelper.clearPage();
		
		return list;
	}

}
