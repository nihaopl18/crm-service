package cn.com.yusys.yusp.cm.taskcenter.repository.mapper;

/**
 * 
 * @项目名称: yusp-app-cm-taskcenter
 * @类名称: CimFTcCareMapper
 * @类描述: 
 * @功能描述: 任务中-关怀MAPPER
 * @创建人: yangye@yusys.com.cn
 * @创建时间: 2018年11月09日
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */

import cn.com.yusys.yusp.cm.taskcenter.domain.CimpTcCareInfo;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CimFTcCareMapper extends CommonMapper<CimpTcCareInfo>{
}

