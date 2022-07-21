package cn.com.yusys.yusp.uimp.business.pma.scheme.baseIndex.repository.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.uimp.business.pma.scheme.baseIndex.domain.PmaFBaseIndexType;

/**
 * @项目名称: uimp-business-pma-scheme-core模块
 * @类名称: PmaFBaseIndexTypeMapper
 * @类描述: #Dao类
 * @功能描述: 
 * @创建人: asus
 * @创建时间: 2020-01-02 16:29:22
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
public interface PmaFBaseIndexTypeMapper extends CommonMapper<PmaFBaseIndexType> {
	List<Map<String, Object>> querymenulist(@Param("sql")String sql);
	List<Map<String, Object>> delval(@Param("dirId")String dirId);

	/**
	 * 检查是否存在相同的目录名称
	 *
	 * @param id 目录id
	 * @param typeName 目录名称
	 * @return 存在与否
	 * @author weixy6
	 * @date 2022/6/6
	 */
	List<Map<String, Object>> checkSameName(@Param("id") String id,
											@Param("typeName") String typeName);
}