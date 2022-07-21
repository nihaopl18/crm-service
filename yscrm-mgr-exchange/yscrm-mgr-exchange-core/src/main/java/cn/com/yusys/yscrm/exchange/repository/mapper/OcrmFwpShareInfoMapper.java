package cn.com.yusys.yscrm.exchange.repository.mapper;

import java.util.List;

import cn.com.yusys.yscrm.exchange.domain.OcrmFwpShareInfo;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;

/**
 * @项目名称: yscrm-mgr-exchange-core模块
 * @类名称: OcrmFwpShareInfoMapper
 * @类描述: #Dao类
 * @功能描述: 
 * @创建人: lixt1
 * @创建时间: 2019-02-26 22:10:29
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public interface OcrmFwpShareInfoMapper extends CommonMapper<OcrmFwpShareInfo> {
	
	/**
	 * @方法名称: queryList
	 * @方法描述: 条件列表查询
	 * @参数与返回说明: 
	 * @算法描述: 无
	 */
	List<OcrmFwpShareInfo> queryList(QueryModel model);
	
    /**
     * @方法名称: deleteByShareIds
     * @方法描述: 交流主题 删除  - 根据 主键字段 逻辑删除
     * @参数与返回说明: 
     * @算法描述: 无
     */
    int deleteByShareIds(String[] shareIds);
}