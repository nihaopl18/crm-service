package cn.com.yusys.yscrm.infocalculator.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import cn.com.yusys.yscrm.infocalculator.repository.mapper.AcrmFpdInterestRateMapper;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
/**
 * @项目名称: yscrm-func-info-calculator-core模块
 * @类名称: AcrmFpdInterestRateService
 * @类描述: #服务类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2019-02-12 16:07:38
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class AcrmFpdInterestRateService extends CommonService {
    @Autowired
    private AcrmFpdInterestRateMapper acrmFpdInterestRateMapper;

    @Override
    protected CommonMapper<?> getMapper() {
        return acrmFpdInterestRateMapper;
    }
  

	
	/**
	 * 查询分组
	 * @return
	 */
	public List<Map<String, Object>> getListDep(QueryModel model){
		//return this.mapper.querylist(model);
		
		PageHelper.startPage(model.getPage(), model.getSize());
		List<Map<String, Object>> list = this.acrmFpdInterestRateMapper.querylistdep(model);
		PageHelper.clearPage();
		return list;
	}
	
	/**
	 * 查询当前客户明细
	 * @return
	 */
	public List<Map<String, Object>> getListLoan(QueryModel model){
		PageHelper.startPage(model.getPage(), model.getSize());
		List<Map<String, Object>> list = this.acrmFpdInterestRateMapper.querylistloan(model);
		PageHelper.clearPage();
		return list;
	}
    
    
}
