package cn.com.yusys.yscrm.custgrade.service;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import cn.com.yusys.yscrm.custgrade.domain.CustGradeChangeQuery;
import cn.com.yusys.yscrm.custgrade.repository.mapper.CustGradeChangeQueryMapper;
import cn.com.yusys.yscrm.custgrade.util.UtilsCommon;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
/**
 * 
 * @项目名称: crm-service
 * @类名称: CustGradeChangeQueryService
 * @类描述: 
 * @功能描述: 客户等级查询
 * @创建人: zhangcl3@yusys.com.cn
 * @创建时间: 2019年02月11日
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class CustGradeChangeQueryService extends CommonService{
	@Autowired
	private CustGradeChangeQueryMapper mapper;
	private final Logger logger = LoggerFactory.getLogger(CustGradeChangeQueryService.class);

	@Autowired 
	private UtilsCommon util;
	@Override
	protected CommonMapper getMapper() {
		// TODO Auto-generated method stub
		return this.mapper;
	}
	
	/**
	 * 查询分组
	 * @return
	 */
	public List<Map<String, Object>> getAll(QueryModel model){
		//return this.mapper.querylist(model);
		model=util.dealRole(model);
		PageHelper.startPage(model.getPage(), model.getSize());
		List<Map<String, Object>> list = this.mapper.querylist(model);
		for (Map<String, Object> map : list) {
			String custLevel=(String) map.get("custLevel");
			String oldCustLevel=(String) map.get("oldCustLevel");
			int levelChange=custLevel.compareToIgnoreCase(oldCustLevel);
			if(levelChange>0) {
				levelChange=1;
			}else if(levelChange<0) {
				levelChange=2;
			}
			map.put("levelChange", levelChange);
		}
		PageHelper.clearPage();
		return list;
	}
	
	/**
	 * 查询当前客户明细
	 * @return
	 */
	public List<Map<String, Object>> getCurrCust(QueryModel model){
		PageHelper.startPage(model.getPage(), model.getSize());
		List<Map<String, Object>> list = this.mapper.queryDetailList((String) model.getCondition().get("custId"));
		PageHelper.clearPage();
		return list;
	}
}



