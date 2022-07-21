package cn.com.yusys.yusp.uimp.base.repository.mapper;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.uimp.base.domain.AdminBaseMetaFunColumn;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @项目名称: uimp-app-base-core模块
 * @类名称: AdminBaseMetaFunColumnMapper
 * @类描述: #Dao类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2019-12-27 15:10:08
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
public interface AdminBaseMetaFunColumnMapper extends CommonMapper<AdminBaseMetaFunColumn> {
	void delFunColumnByTableCode(@Param("tableCode") String tableCode);
	AdminBaseMetaFunColumn queryMetaFunColumn(@Param("tableCode") String tableCode,@Param("columnName") String columnName);
	List<Map<String, Object>> querylist(@Param("tableCode") String tableCode);
	void delColumnInfoByTableCode(@Param("tableCode") String tableCode);
	
	/**
	 * @方法名称: addPeriodPK
	 * @方法描述: 删除分配区间表和分配区间历史表中关联信息表的业务主键字段
	 * @参数与返回说明:
	 * @算法描述:
	 * 后缀大于900的为业务主键字段
	 */
	void delPeriodPK(@Param("tableCode") String tableCode, @Param("columnCode") String columnCode);
}