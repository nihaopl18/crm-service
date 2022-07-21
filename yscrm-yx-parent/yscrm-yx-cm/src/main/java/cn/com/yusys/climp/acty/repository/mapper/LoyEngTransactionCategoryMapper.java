package cn.com.yusys.climp.acty.repository.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.com.yusys.climp.acty.domain.LoyEngTransactionCategory;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;

/**
 * @项目名称: yusp-climp-single-starter模块
 * @类名称: LoyEngTransactionCategoryMapper
 * @类描述: 交易类型Dao类
 * @功能描述: 
 * @创建人: chenlin2@yusys.com.cn
 * @创建时间: 2018-12-29 15:07:56
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public interface LoyEngTransactionCategoryMapper extends CommonMapper<LoyEngTransactionCategory> {
	/**
	 * 查询交易码
	 * @return
	 */
	List<Map<String, Object>> searchTransCode(@Param("transType") String transType);
	/**
	 * 查询所有码值
	 * @return
	 */
	List<Map<String, Object>> searchLookupCode();
}