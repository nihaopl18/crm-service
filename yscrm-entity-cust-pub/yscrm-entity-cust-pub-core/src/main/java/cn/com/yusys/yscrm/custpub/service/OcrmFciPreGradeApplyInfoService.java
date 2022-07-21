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
import cn.com.yusys.yscrm.custpub.domain.OcrmFciPreGradeApplyInfo;
import cn.com.yusys.yscrm.custpub.repository.mapper.OcrmFciPreGradeApplyInfoMapper;
/**
 * @项目名称: yscrm-entity-cust-pub-core模块
 * @类名称: OcrmFciPreGradeApplyInfoService
 * @类描述: #服务类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2019-02-16 12:50:17
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class OcrmFciPreGradeApplyInfoService extends CommonService {
    @Autowired
    private OcrmFciPreGradeApplyInfoMapper ocrmFciPreGradeApplyInfoMapper;

    @Override
    protected CommonMapper<?> getMapper() {
        return this.ocrmFciPreGradeApplyInfoMapper;
    }
    @Transactional(readOnly = true)
   	public List<Map<String, Object>> queryServiceGradeList(String custId,QueryModel model) {
   			Map<String, String> paramMap=new HashMap<String, String>();
   			paramMap.put("custId", custId);
   			return ocrmFciPreGradeApplyInfoMapper.queryServiceGradeList(paramMap);
   	}
/**
 * 调级申请
 * @param c
 * @return
 */
	public int updateServiceGrade(Map c) {
		
		return ocrmFciPreGradeApplyInfoMapper.updateServiceGrade(c);
	}
}
