package cn.com.yusys.climp.acty.repository.mapper;

import java.util.List;
import java.util.Map;

import cn.com.yusys.climp.acty.domain.LoyRlTableEcName;
import org.apache.ibatis.annotations.Param;

import cn.com.yusys.climp.acty.domain.LoyRlFieldEcName;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;

/**
 * @项目名称: yusp-climp-single-starter模块
 * @类名称: LoyRlFieldEcNameMapper
 * @类描述: 字段汉化Dao类
 * @功能描述:
 * @创建人: chenlin2@yusys.com.cn
 * @创建时间: 2018-12-29 15:08:29
 * @修改备注:
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public interface LoyRlFieldEcNameMapper extends CommonMapper<LoyRlFieldEcName> {

	/**
	 * 根据表id查询表字段
	 * @param model
	 */
	List<LoyRlFieldEcName> getFieldByTableId(@Param("tableId") String tableId);
	/**
	 * 删除字段
	 * @param tableId
	 * @return
	 */
	int updateFieldState(Map<String,String> map);

	/**
	 * 根据表名查询字段
	 * @param tabName
	 * @param tabId
	 * @return
	 */
	List<LoyRlFieldEcName> searchFieldByTabName(@Param("tabName") String tabName,@Param("tabId") String tabId);

	LoyRlTableEcName selectByTransactionCode(@Param("transactionCode") String transactionCode);
}