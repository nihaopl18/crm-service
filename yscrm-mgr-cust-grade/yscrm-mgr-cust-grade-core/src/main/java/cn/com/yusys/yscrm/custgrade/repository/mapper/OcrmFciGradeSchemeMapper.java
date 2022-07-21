package cn.com.yusys.yscrm.custgrade.repository.mapper;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;

import java.util.List;
import java.util.Map;

import cn.com.yusys.yscrm.custgrade.domain.OcrmFciGradeScheme;

/**
 * @项目名称: yscrm-mgr-cust-grade-core模块
 * @类名称: OcrmFciGradeSchemeMapper
 * @类描述: #Dao类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2019-02-18 11:14:46
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public interface OcrmFciGradeSchemeMapper extends CommonMapper<OcrmFciGradeScheme> {
	/**
	 * 查询 评级方案
	 */
	public List<Map<String,Object>> querylist(QueryModel model);
	
	/**
	 * 查询 评级标准 列表
	 */
	public  List<Map<String,Object>> queryperiodlist(String schemeId);
	/**
	 * 查询评级方案 参数列表  区间列表
	 */
	public List<Map<String,Object>> queryGradeLevel(String schemeId);
	/**
	 * 查询详情 
	 */
	public List<Map<String,Object>> queryDetail(String schemeId);
	
	/**
	 * 查询 方案是否可用
	 */
	public int queryEnable(Map<String,Object> map);
	
	/**
	 * 查询评级指标
	 */
	public List<Map<String,Object>> queryBaseIndex(String indexUse);
	
	/**
	 * 删除方案
	 */
	public void deleteById(String schemeId);
	/**
	 * 删除标准
	 */
	public void deleteStandard(String schemeId);
	/**
	 * 删除标准参数
	 */
	public void deleteLevel(String schemeId);
	/**
	 * 启用方案
	 */
	public void enable(Map<String,Object> map);
	/**
	 * 禁用方案 
	 */
	public void disEnable(Map<String,Object> map);
}