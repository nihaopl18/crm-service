package cn.com.yusys.yscrm.cust.person.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;

import cn.com.yusys.yscrm.cust.person.repository.mapper.OcrmFciDiscountProMapper;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
/**
 * @项目名称: demo-app-single-starter模块
 * @类名称: OcrmFciDiscountProService
 * @类描述: #服务类
 * @功能描述: 客户优惠信息
 * @创建人: 15104
 * @创建时间: 2019-02-14 16:33:24
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class OcrmFciDiscountProService extends CommonService {
    @Autowired
    private OcrmFciDiscountProMapper ocrmFciDiscountProMapper;

    @Override
    protected CommonMapper<?> getMapper() {
        return ocrmFciDiscountProMapper;
    }

    @Transactional(readOnly = true)  
   	public List<Map<Object, String>> queryList(QueryModel model, String custId) {
    	PageHelper.startPage(model.getPage(), model.getSize());
    	
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("custId", custId);
		
		List<Map<Object, String>>  list = ocrmFciDiscountProMapper.queryList(paramMap);
		PageHelper.clearPage();
		
		return list;
   	}
}
