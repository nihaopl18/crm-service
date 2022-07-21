package cn.com.yusys.yscrm.custflexEs.repository.mapper;

import java.util.List;
import java.util.Map;

import cn.com.yusys.yscrm.custflexEs.domain.CrmFCiFqDbcol;
import cn.com.yusys.yscrm.custflexEs.vo.CrmFCiFqObjNodeVo;
import org.apache.ibatis.annotations.Param;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import org.springframework.stereotype.Repository;

/**
 * @项目名称: cmss-cust-mgt-core模块
 * @类名称: CrmFCiFqDbcolMapper
 * @类描述: #数据集-属性表 Dao类
 * @功能描述: 
 * @创建人: lixt1
 * @创建时间: 2020-12-29 11:27:44
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@Repository
public interface CrmFCiFqDbcolMapper extends CommonMapper<CrmFCiFqDbcol> {
    /**
     * 
     * @param objId
     * @param orglevel 为空不控制 为orglevel 控制不查询 手机号，证件号
     * @return
     */
	List<CrmFCiFqObjNodeVo> queryFqDbcolDataByObjId(@Param("objId") String objId, @Param("orglevel") String orglevel);
	
}