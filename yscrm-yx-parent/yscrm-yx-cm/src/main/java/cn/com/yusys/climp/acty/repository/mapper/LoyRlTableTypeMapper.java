package cn.com.yusys.climp.acty.repository.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.com.yusys.climp.acty.domain.LoyRlActivity;
import cn.com.yusys.climp.acty.domain.LoyRlTableType;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;

/**
 * @项目名称: yusp-climp-single-starter模块
 * @类名称: LoyRlTableTypeMapper
 * @类描述: 表类别Dao类
 * @功能描述: 
 * @创建人: chenlin2@yusys.com.cn
 * @创建时间: 2018-12-29 15:08:57
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public interface LoyRlTableTypeMapper extends CommonMapper<LoyRlTableType> {
	/**
	 * 查询表类别
	 * 
	 * */
	List<LoyRlTableType> getTableType(QueryModel model);
	
	/***根据表类型查询表是否 被实时事件所引用**/
	List<LoyRlActivity> getRuleByType(@Param(value="typeId") String typeId);
	/**
	 * 删除表 类型
	 * @param typeId
	 * @return
	 */
	int updataTabTypeState(Map<String,String> map);
}