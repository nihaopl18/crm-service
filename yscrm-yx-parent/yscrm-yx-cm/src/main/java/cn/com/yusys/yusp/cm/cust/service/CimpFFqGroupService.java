package cn.com.yusys.yusp.cm.cust.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.yusys.yusp.cm.cust.domain.CimpFFqGroup;
import cn.com.yusys.yusp.cm.cust.repository.mapper.CimpFFqGroupMapper;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.service.CommonService;
/**
 * 
 * @项目名称: yusp-app-cm
 * @类名称: CimpFFqGroupService
 * @类描述: 
 * @功能描述: 数据集分组
 * @创建人: zhangxs4@yusys.com.cn
 * @创建时间: 2018年11月26日
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */

@Service
public class CimpFFqGroupService extends CommonService{
	@Autowired
	private CimpFFqGroupMapper mapper;
	private final Logger logger = LoggerFactory.getLogger(CimpFFqGroupService.class);

	@Override
	protected CommonMapper getMapper() {
		// TODO Auto-generated method stub
		return this.mapper;
	}
	
	/**
	 * 查询分组
	 * @return
	 */
	public List<CimpFFqGroup> getGroup(String objId){
		return this.mapper.getGroup(objId);
	}
	
}


