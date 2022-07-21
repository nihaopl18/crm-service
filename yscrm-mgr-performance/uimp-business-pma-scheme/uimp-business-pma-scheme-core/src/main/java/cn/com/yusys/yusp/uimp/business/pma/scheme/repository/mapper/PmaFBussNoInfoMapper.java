package cn.com.yusys.yusp.uimp.business.pma.scheme.repository.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.uimp.business.pma.scheme.domain.PmaFBussNoInfo;

/**
 * @项目名称: uimp-business-pma-scheme-core模块
 * @类名称: PmaFBussNoInfoMapper
 * @类描述: #Dao类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2020-02-14 15:40:55
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
public interface PmaFBussNoInfoMapper extends CommonMapper<PmaFBussNoInfo> {
	List<Map<String, Object>> getBusstreeByParam(Map<String, Object> map);
	List<String> queryNames(@Param("bussNo") String[] bussNo);
}