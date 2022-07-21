package cn.com.yusys.climp.acty.repository.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.com.yusys.climp.acty.domain.LoyRlActivity;
import cn.com.yusys.climp.acty.domain.LoyRlTableEcName;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;

/**
 * @项目名称: yusp-climp-single-starter模块
 * @类名称: LoyRlTableEcNameMapper
 * @类描述: 表汉化Dao类
 * @功能描述:
 * @创建人: chenlin2@yusys.com.cn
 * @创建时间: 2018-12-29 15:46:37
 * @修改备注:
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public interface LoyRlTableEcNameMapper extends CommonMapper<LoyRlTableEcName> {
	/**
	 * 根据表类型id查询表Id
	 * @param typeId
	 * @return
	 */
	List<LoyRlTableEcName> queryTableId(@Param("typeId") String typeId);
	/**
	 * @方法名称:getRuleByTrans
	 * @方法描述:根据交易类型查询积分活动
	 * @参数与返回说明:
	 * @算法描述:
	 */
	List<LoyRlActivity> getRuleByTrans(@Param(value="transCode") String transCode);
	/**
	 * 删除表
	 * @param tableId
	 * @return
	 */
	int updataTabState(Map<String,String> map);

	/**
	 * 根据表类型查询表
	 * @param model
	 */
	List<LoyRlTableEcName> getTableByTypeId(@Param("typeId") String typeId);
}