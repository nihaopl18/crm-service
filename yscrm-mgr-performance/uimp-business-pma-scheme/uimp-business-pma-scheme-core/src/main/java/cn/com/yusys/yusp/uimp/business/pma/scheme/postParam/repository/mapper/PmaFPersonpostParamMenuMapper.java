package cn.com.yusys.yusp.uimp.business.pma.scheme.postParam.repository.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.uimp.business.pma.scheme.postParam.domain.PmaFPersonpostParamMenu;

/**
 * @项目名称: uimp-business-pma-scheme-core模块
 * @类名称: PmaFPersonpostParamMenuMapper
 * @类描述: #Dao类
 * @功能描述: 
 * @创建人: asus
 * @创建时间: 2020-01-10 10:35:08
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
public interface PmaFPersonpostParamMenuMapper extends CommonMapper<PmaFPersonpostParamMenu> {
	List<Map<String, Object>> querymenulist(@Param("sql")String sql);
	Map<String, Object> queryIsMenuCode(String dirId);
}