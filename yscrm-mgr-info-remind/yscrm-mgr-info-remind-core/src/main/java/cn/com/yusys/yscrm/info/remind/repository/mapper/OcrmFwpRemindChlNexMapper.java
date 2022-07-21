package cn.com.yusys.yscrm.info.remind.repository.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.com.yusys.yscrm.info.remind.domain.OcrmFwpRemindChlNex;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;

/**
 * @项目名称: yscrm-mgr-info-remind-core模块
 * @类名称: OcrmFwpRemindChlNexMapper
 * @类描述: #Dao类
 * @功能描述: 
 * @创建人: lixt1
 * @创建时间: 2019-02-19 09:01:31
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public interface OcrmFwpRemindChlNexMapper extends CommonMapper<OcrmFwpRemindChlNex> {
	
	/**
	 * @方法名称: findData
	 * @方法描述: 查询数据
	 * @参数与返回说明: 
	 * @算法描述: 无
	 */
	List<Map<String, Object>> findData(@Param("ruleId") String ruleId, @Param("chlId") String chlId);
	
	/**
	 * @方法名称: insertData
	 * @方法描述: 新增数据
	 * @参数与返回说明: 
	 * @算法描述: 无
	 */
	int insertData(@Param("ruleId") String ruleId, @Param("chlId") String chlId, @Param("messageModel") String messageModel);
	
	/**
	 * @方法名称: updateData
	 * @方法描述: 更新数据
	 * @参数与返回说明: 
	 * @算法描述: 无
	 */
	int updateData(@Param("ruleId") String ruleId, @Param("chlId") String chlId, @Param("messageModel") String messageModel);
	
	/**
	 * @方法名称: deleteData
	 * @方法描述: 删除数据
	 * @参数与返回说明: 
	 * @算法描述: 无
	 */
	int deleteData(@Param("ruleId") String ruleId, @Param("chlId") String chlId);
}