package cn.com.yusys.yusp.uimp.base.repository.mapper;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.uimp.base.domain.AdminBaseMetaFunPageCfg;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @项目名称: uimp-app-base-core模块
 * @类名称: AdminBaseMetaFunPageCfgMapper
 * @类描述: #Dao类
 * @功能描述:
 * @创建人: Administrator
 * @创建时间: 2019-12-23 15:43:18
 * @修改备注:
 * @修改记录: 修改时间 修改人员 修改原因
 *        -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
public interface AdminBaseMetaFunPageCfgMapper extends CommonMapper<AdminBaseMetaFunPageCfg> {
	void delPageCfgByFunCode(@Param("funCode") String funCode);
	List<Map<String, Object>> queryPageCfg(@Param("funCode") String funCode);
}