
package cn.com.yusys.yscrm.custgrade.service;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import cn.com.yusys.yscrm.custgrade.repository.mapper.CustGradeQueryMapper;
import cn.com.yusys.yscrm.custgrade.util.UtilsCommon;
import cn.com.yusys.yusp.admin.web.rest.util.HeaderUtil;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.uaa.client.dto.UserInfoDTO;
/**
 * 
 * @项目名称: crm-service
 * @类名称: CustGradeQueryService
 * @类描述: 
 * @功能描述: 
 * @创建人: zhangcl3@yusys.com.cn
 * @创建时间: 2019年02月11日
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class CustGradeQueryService extends CommonService{
	@Autowired
	private CustGradeQueryMapper mapper;
	private final Logger logger = LoggerFactory.getLogger(CustGradeQueryService.class);
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
//		model=util.dealRole(model);
		PageHelper.startPage(model.getPage(), model.getSize());
		String busiType = (String) model.getCondition().get("busiType");
		String custType = (String) model.getCondition().get("custType");
		List<Map<String, Object>> list = null;
		if (custType.equals("")) {
			return list;
		}
		if (busiType.equals("6")) {
			list = this.mapper.querylistAllBusi(model);
		}else {
			list = this.mapper.querylist(model);
		}
		PageHelper.clearPage();
		return list;
	}
	
}



