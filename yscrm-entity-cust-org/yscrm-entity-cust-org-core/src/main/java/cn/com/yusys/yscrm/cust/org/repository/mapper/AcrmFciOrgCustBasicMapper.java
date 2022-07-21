package cn.com.yusys.yscrm.cust.org.repository.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.com.yusys.yscrm.cust.org.domain.AcrmFciOrgCustInfo;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;

/**
 * @项目名称: demo-app-single-starter模块
 * @类名称: AcrmFciOrgCustMapper
 * @类描述: #Dao类
 * @功能描述: 对公客户基本信息
 * @创建人: 15104
 * @创建时间: 2019-02-21 09:32:23
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public interface AcrmFciOrgCustBasicMapper extends CommonMapper<AcrmFciOrgCustInfo> {
	
	/**
	* @方法名称: querylist
	* @方法描述: 查询
	* @算法描述:
	 */
	List<Map<Object, String>> querylist(QueryModel model);
	
	List<Map<String, Object>> queryCustUpdateHis(String custId);

	int updateIsUse(@Param("custId") String custId,@Param("updateName") String updateName);

	List<Map<Object, String>> getlookupItem();
	
	String getItemName(Map mapCode);
}