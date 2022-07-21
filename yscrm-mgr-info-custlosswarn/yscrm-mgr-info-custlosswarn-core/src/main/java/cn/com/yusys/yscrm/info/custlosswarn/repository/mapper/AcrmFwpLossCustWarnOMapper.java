package cn.com.yusys.yscrm.info.custlosswarn.repository.mapper;

import java.util.List;
import java.util.Map;

import cn.com.yusys.yscrm.info.custlosswarn.domain.AcrmFwpLossCustWarnO;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;

/**
 * @项目名称: yscrm-mgr-info-custlosswarn-core模块
 * @类名称: AcrmFwpLossCustWarnOMapper
 * @类描述: #Dao类
 * @功能描述: 
 * @创建人: lixt1
 * @创建时间: 2019-03-12 10:19:05
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public interface AcrmFwpLossCustWarnOMapper extends CommonMapper<AcrmFwpLossCustWarnO> {
	
	/**
     * @方法名称: queryList
     * @方法描述: 条件列表查询
     * @参数与返回说明: 
     * @算法描述: 无
     */
	List<Map<String, Object>> queryList(QueryModel model);
    
    /**
     * @方法名称: selectByLossId
     * @方法描述: 根据 主键 查询
     * @参数与返回说明: 
     * @算法描述: 无
     */
    AcrmFwpLossCustWarnO selectByLossId(String id);
}