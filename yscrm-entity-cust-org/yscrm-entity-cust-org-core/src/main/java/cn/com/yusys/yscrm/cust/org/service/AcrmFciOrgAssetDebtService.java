package cn.com.yusys.yscrm.cust.org.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;

import cn.com.yusys.yscrm.cust.org.repository.mapper.AcrmFciOrgAssetDebtMapper;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
/**
 * @项目名称: yscrm-entity-cust-org-core模块
 * @类名称: AcrmFciOrgAssetDebtService
 * @类描述: #服务类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2019-02-26 10:54:47
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class AcrmFciOrgAssetDebtService extends CommonService {
    @Autowired
    private AcrmFciOrgAssetDebtMapper acrmFciOrgAssetDebtMapper;

    @Override
    protected CommonMapper<?> getMapper() {
        return acrmFciOrgAssetDebtMapper;
    }
    
    /**
 	 * @方法名称: queryList
 	 * @方法描述: 财务报表列表查询
 	 * @参数与返回说明:
 	 * @算法描述:
 	 */
    @Transactional(readOnly = true)
    public List<Map<String, Object>> queryList(QueryModel queryModel,String custId) {
    	queryModel.getCondition().put("custId", custId);
    	PageHelper.startPage(queryModel.getPage(), queryModel.getSize());
    	PageHelper.orderBy(queryModel.getSort());
		List<Map<String, Object>> list = acrmFciOrgAssetDebtMapper.queryList(queryModel);
		PageHelper.clearPage();
		return list;
    }

}
