package cn.com.yusys.yusp.uimp.base.repository.mapper;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.uimp.base.domain.AdminBaseMetaFunTable;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @项目名称: uimp-app-base-core模块
 * @类名称: AdminBaseMetaFunTableMapper
 * @类描述: #Dao类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2019-12-25 10:54:26
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
public interface AdminBaseMetaFunTableMapper extends CommonMapper<AdminBaseMetaFunTable> {
	List<Map<String, Object>> querylist(@Param("funCode") String funCode);
	void delMetaFunByFunCode(@Param("funCode") String funCode);
	AdminBaseMetaFunTable queryFunTableInfo(@Param("funCode") String funCode,@Param("funSubType") String funSubType);
}