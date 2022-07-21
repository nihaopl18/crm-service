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
import cn.com.yusys.yscrm.custpub.domain.OcrmFcgCpnGrade;
import cn.com.yusys.yscrm.custpub.repository.mapper.OcrmFcgCpnGradeMapper;
/**
 * @项目名称: yscrm-entity-cust-pub-core模块
 * @类名称: OcrmFcgCpnGradeService
 * @类描述: #服务类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2019-02-16 11:10:51
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class OcrmFcgCpnGradeService extends CommonService {
    @Autowired
    private OcrmFcgCpnGradeMapper ocrmFcgCpnGradeMapper;

    @Override
    protected CommonMapper<?> getMapper() {
        return this.ocrmFcgCpnGradeMapper;
    }
    @Transactional(readOnly = true)
   	public List<Map<String, Object>> queryGradeList(String custId,QueryModel model) {
   		   
   		    PageHelper.startPage(model.getPage(),model.getSize());
   			Map<String, String> paramMap=new HashMap<String, String>();
   			paramMap.put("custId", custId);
   			List<Map<String, Object>> list=ocrmFcgCpnGradeMapper.queryGradeList(paramMap);
   			PageHelper.clearPage();
   			return list;
   	}
}
