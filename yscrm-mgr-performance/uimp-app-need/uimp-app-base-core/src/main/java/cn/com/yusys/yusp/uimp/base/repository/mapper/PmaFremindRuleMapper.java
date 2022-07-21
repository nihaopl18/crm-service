package cn.com.yusys.yusp.uimp.base.repository.mapper;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.uimp.base.domain.PmaFremindRule;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @项目名称: uimp-app-base-core模块
 * @类名称: PmaFremindRuleMapper
 * @类描述: #信息提醒规则表 Dao类
 * @功能描述: 
 * @创建人: lixt1
 * @创建时间: 2020-07-06 10:02:08
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public interface PmaFremindRuleMapper extends CommonMapper<PmaFremindRule> {

	/**
     * @函数名称:queryList
     * @函数描述:查询对象列表，公共API接口
     * @参数与返回说明:
     * @算法描述:
     */
	List<PmaFremindRule> queryList(QueryModel model);

	void pushSql(@Param("id") String id,@Param("status") String status);
	
}