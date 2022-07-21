package cn.com.yusys.yscrm.product.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yscrm.product.domain.OcrmFpdCustFitProd;
import cn.com.yusys.yscrm.product.repository.mapper.OcrmFpdCustFitProdMapper;
/**
 * @项目名称: yusp-crm-single-starter模块
 * @类名称: OcrmFpdCustFitProdService
 * @类描述: #服务类
 * @功能描述: 
 * @创建人: yantianyi
 * @创建时间: 2019-02-11 15:25:03
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class OcrmFpdCustFitProdService extends CommonService {
    @Autowired
    private OcrmFpdCustFitProdMapper ocrmFpdCustFitProdMapper;

    @Override
    protected CommonMapper<?> getMapper() {
        return ocrmFpdCustFitProdMapper;
    }

    /**
     * @方法名称: targetCustomersQuery
	 * @方法描述: 目标客户查询
	 * @param 
	 * @return
	 */
	public List<Map<String, Object>> targetCustomersQuery(QueryModel model){
		PageHelper.startPage(model.getPage(), model.getSize());
		List<Map<String, Object>> list = ocrmFpdCustFitProdMapper.targetCustomersQuery(model);
		PageHelper.clearPage();
		return list;	
	}
	
	public List<Map<String, Object>> queryProd(QueryModel model){
		PageHelper.startPage(model.getPage(), model.getSize());
		List<Map<String, Object>> list = ocrmFpdCustFitProdMapper.queryProd(model);
		PageHelper.clearPage();
		return list;	
	}
    
}
