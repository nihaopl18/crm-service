package cn.com.yusys.yscrm.entity.cust.org.group.repository.mapper;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.com.yusys.yscrm.entity.cust.org.group.domain.OcrmFciGroupRelaMember;

/**
 * @项目名称: yscrm-entity-cust-org-group-core模块
 * @类名称: OcrmFciGroupRelaMemberMapper
 * @类描述: #Dao类
 * @功能描述: 
 * @创建人: hyx
 * @创建时间: 2019-02-18 19:13:07
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public interface OcrmFciGroupRelaMemberMapper extends CommonMapper<OcrmFciGroupRelaMember> {
	/**
     * @方法名称: delByGroupNo
     * @方法描述: 删除关系成员信息
     * @参数与返回说明: 
     * @算法描述: 无
     */
	int delByGroupNo(String groupNo);
	/**
     * @方法名称: getRelaMemberByGroupNo
     * @方法描述: 查询关系成员信息
     * @参数与返回说明: 
     * @算法描述: 无
     */
	List<Map<String, Object>> getRelaMemberByGroupNo(@Param("groupNo")String groupNo);
	/**
     * @方法名称: getMembersByGroupNo
     * @方法描述: 查询集团成员信息
     * @参数与返回说明: 
     * @算法描述: 查询成员不在关系成员表中的
     */
	List<Map<String, Object>> getMembersByGroupNo(Map<String,String> param);
	
	
}