package cn.com.yusys.yscrm.cust.person.service;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;

import cn.com.yusys.yscrm.cust.person.repository.mapper.AcrmFagCcdStmtMapper;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;

/**
 * @项目名称: yscrm-entity-cust-person-core模块
 * @类名称: AcrmFagCcdStmtService
 * @类描述: #服务类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2019-02-16 12:13:19
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class AcrmFagCcdStmtService extends CommonService {
    @Autowired
    private AcrmFagCcdStmtMapper acrmFagCcdStmtMapper;

    @Override
    protected CommonMapper<?> getMapper() {
        return this.acrmFagCcdStmtMapper;
    }
    @Transactional(readOnly = true)
  	public List<Map<String, Object>> queryCcdStmtList(String custId,QueryModel model) {
  		   
  		    PageHelper.startPage(model.getPage(),model.getSize());
  			Map<String, String> paramMap=new HashMap<String, String>();
  			paramMap.put("custId", custId);
  			List<Map<String, Object>> list=acrmFagCcdStmtMapper.queryCcdStmtList(paramMap);
  			PageHelper.clearPage();
  			return list;
  	}
}
