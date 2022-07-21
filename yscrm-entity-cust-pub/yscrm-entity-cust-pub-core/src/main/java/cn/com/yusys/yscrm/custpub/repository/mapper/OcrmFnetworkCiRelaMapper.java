package cn.com.yusys.yscrm.custpub.repository.mapper;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.com.yusys.yscrm.custpub.domain.OcrmFnetworkCiRela;

/**
 * @项目名称: yscrm-entity-cust-pub-core模块
 * @类名称: OcrmFnetworkCiRelaMapper
 * @类描述: #Dao类
 * @功能描述: 
 * @创建人: hyx
 * @创建时间: 2019-02-18 16:28:38
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public interface OcrmFnetworkCiRelaMapper extends CommonMapper<OcrmFnetworkCiRela> {

	int delByNetId(@Param("netId")String netId);
	  /**
	 * 
	* @方法名称: getRelaDetailByNetId
	* @方法描述:查询连接信息
	* @参数与返回说明: 
	* @算法描述:
	 */
	List<Map<String,Object>> getRelaDetailByNetId(@Param("networkId")String networkId);
}