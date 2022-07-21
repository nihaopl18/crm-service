package cn.com.yusys.yscrm.sysview.repository.mapper;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.com.yusys.yscrm.sysview.domain.OcrmFsysViewAuth;

/**
 * @项目名称: yscrm-mgr-sys-view模块
 * @类名称: OcrmFsysViewAuthMapper
 * @类描述: 视图授权
 * @功能描述: 
 * @创建人: zhangxs4
 * @创建时间: 2019-01-17 19:08:18
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public interface OcrmFsysViewAuthMapper extends CommonMapper<OcrmFsysViewAuth> {
	/**
	* @方法名称: deleteContrInfo
	* @方法描述: 删除控制点时对应删除授权数据
	* @参数与返回说明: 
	* @算法描述: 
	*/
	int deleteContrInfo(String[] contrId);
	List<Map<String, Object>> getRecoInfo(Map<String, Object> paramMap);
	List<Map<String, Object>> qryViewTree(String sysId);
	/**
	 * 
	* @方法名称: quryParentIdById
	* @方法描述: 根据ID查询所有父节点ID包含本身节点
	* @参数与返回说明: 
	* @算法描述:
	 */
	List<Map<String, Object>> quryParentIdById(List<?> paramMap);
	
	int deleteRelInfo(Map<String, Object> paramMap);
	
	List<Map<String, Object>> selectViewTree(Map<String, Object> paramMap);
	
	List<OcrmFsysViewAuth> qryGrantList(Map<String, Object> paramMap);
	
	List<Map<String, Object>> qryViewList(String[] ids);
	
	List<Map<String, Object>> selectContrList(Map<String, Object> paramMap);
	
	int deleteMenuInfo(String id);
}