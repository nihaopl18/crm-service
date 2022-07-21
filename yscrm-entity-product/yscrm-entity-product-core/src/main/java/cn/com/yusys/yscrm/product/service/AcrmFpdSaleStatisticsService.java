package cn.com.yusys.yscrm.product.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yscrm.product.domain.AcrmFpdSaleStatistics;
import cn.com.yusys.yscrm.product.repository.mapper.AcrmFpdSaleStatisticsMapper;
/**
 * @项目名称: yusp-crm-single-starter模块
 * @类名称: AcrmFpdSaleStatisticsService
 * @类描述: #服务类
 * @功能描述: 
 * @创建人: yantianyi
 * @创建时间: 2019-02-12 19:11:56
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class AcrmFpdSaleStatisticsService extends CommonService {
    @Autowired
    private AcrmFpdSaleStatisticsMapper acrmFpdSaleStatisticsMapper;

    @Override
    protected CommonMapper<?> getMapper() {
        return acrmFpdSaleStatisticsMapper;
    }

    /**
     * @方法名称: salesSituationQuery
	 * @方法描述: 产品销售情况查询
	 * @param 
	 * @return
	 */
	public List<Map<String, Object>> salesSituationQuery(QueryModel model, String prodId){
		PageHelper.startPage(model.getPage(), model.getSize());
		model.getCondition().put("prodId", prodId);
		List<Map<String, Object>> list = acrmFpdSaleStatisticsMapper.salesSituationQuery(model);
		PageHelper.clearPage();
		return list;	
	}
    
}
