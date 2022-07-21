package cn.com.yusys.yscrm.cust.person.repository.mapper;

import java.util.List;
import java.util.Map;

import cn.com.yusys.yscrm.cust.person.domain.AcrmFciBlackListInfo;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;

/**
 * @项目名称: demo-app-single-starter模块
 * @类名称: AcrmFciBlackListInfoMapper
 * @类描述: #Dao类
 * @功能描述: 黑名单信息
 * @创建人: 15104
 * @创建时间: 2019-02-12 16:07:29
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public interface AcrmFciBlackListInfoMapper extends CommonMapper<AcrmFciBlackListInfo> {
	
	/**
	* @方法名称: querylist
	* @方法描述: 黑名单信息查询
	* @算法描述:
	 */
	List<Map<Object, String>> querylist(Map<?, ?> param);
	
	/**
	* @方法名称: delete
	* @方法描述: 黑名单信息删除
	* @算法描述:
	 */
//	int deleteById(QueryModel param);
}