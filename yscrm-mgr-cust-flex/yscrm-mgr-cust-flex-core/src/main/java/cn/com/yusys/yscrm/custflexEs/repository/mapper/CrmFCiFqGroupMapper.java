package cn.com.yusys.yscrm.custflexEs.repository.mapper;

import java.util.List;
import java.util.Map;

import cn.com.yusys.yscrm.custflexEs.domain.CrmFCiFqGroup;
import cn.com.yusys.yscrm.custflexEs.vo.CrmFCiFqObjNodeVo;
import org.apache.ibatis.annotations.Param;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;

/**
 * @项目名称: cmss-cust-mgt-core模块
 * @类名称: CrmFCiFqGroupMapper
 * @类描述: #数据集—分组 Dao类
 * @功能描述: 
 * @创建人: lixt1
 * @创建时间: 2020-12-29 11:26:27
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
public interface CrmFCiFqGroupMapper extends CommonMapper<CrmFCiFqGroup> {

	List<CrmFCiFqObjNodeVo> queryFqGroupDataByObjId(@Param("objId") String objId);
	
}