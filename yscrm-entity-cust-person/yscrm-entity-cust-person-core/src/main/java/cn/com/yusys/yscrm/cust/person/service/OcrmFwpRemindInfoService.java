package cn.com.yusys.yscrm.cust.person.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;

import cn.com.yusys.yscrm.cust.person.repository.mapper.OcrmFwpRemindInfoMapper;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.util.StringTools;
/**
 * @项目名称: demo-app-single-starter模块
 * @类名称: OcrmFwpRemindInfoService
 * @类描述: #服务类
 * @功能描述: 信息提醒
 * @创建人: 15104
 * @创建时间: 2019-02-14 17:31:11
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class OcrmFwpRemindInfoService extends CommonService {
    @Autowired
    private OcrmFwpRemindInfoMapper ocrmFwpRemindInfoMapper;
	private static final String CUST_ID = "custId";
	private static final String TYPE_ID = "typeId";

	@Override
    protected CommonMapper<?> getMapper() {
        return ocrmFwpRemindInfoMapper;
    }

    @Transactional(readOnly = true)  
   	public List<Map<Object, String>> queryList(QueryModel model, String custId) {
		PageHelper.startPage(model.getPage(), model.getSize());
		
		model.getCondition().put(CUST_ID, custId);
		if(!model.getCondition().containsKey(TYPE_ID) || StringTools.isEmpty(model.getCondition().get(TYPE_ID) + ""))
    		model.getCondition().put(TYPE_ID, null);
    	else {
    		String typeIds = model.getCondition().get(TYPE_ID) + "";
    		String[] typeIdArr = typeIds.split(",");
    		model.getCondition().put(TYPE_ID, typeIdArr);
    	}
		List<Map<Object, String>>  list = ocrmFwpRemindInfoMapper.querylist(model);
		
		PageHelper.clearPage();
		
		return list;
   	}
}
