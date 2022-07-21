package cn.com.yusys.yscrm.cust.org.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yscrm.cust.org.domain.AcrmFciOrgFinItem;
import cn.com.yusys.yscrm.cust.org.repository.mapper.AcrmFciOrgFinItemMapper;
/**
 * @项目名称: yscrm-entity-cust-org-core模块
 * @类名称: AcrmFciOrgFinItemService
 * @类描述: #服务类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2019-02-26 10:55:12
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class AcrmFciOrgFinItemService extends CommonService {
    @Autowired
    private AcrmFciOrgFinItemMapper acrmFciOrgFinItemMapper;

    @Override
    protected CommonMapper<?> getMapper() {
        return acrmFciOrgFinItemMapper;
    }

    /**
 	 * @方法名称: queryList
 	 * @方法描述: 财务报表指标列表查询
 	 * @参数与返回说明:
 	 * @算法描述:
 	 */
    @Transactional(readOnly = true)
    public List<Map<String, Object>> queryList(String reportId) {
		List<Map<String, Object>> list = acrmFciOrgFinItemMapper.queryList(reportId);
		return list;
    }
}
