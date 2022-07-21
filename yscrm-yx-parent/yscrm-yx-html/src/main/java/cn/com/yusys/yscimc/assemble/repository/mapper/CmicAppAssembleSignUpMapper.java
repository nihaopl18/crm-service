package cn.com.yusys.yscimc.assemble.repository.mapper;

import cn.com.yusys.yscimc.assemble.domain.CmicAppAssembleSignUpEntity;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;

import java.util.List;

/**
 * @version 1.0.0
 * @项目名称: yscimc-app-mobile模块
 * @类名称: CmicAppAssembleSignUpMapper
 * @类描述: #Dao类
 * @功能描述: 客户报名信息
 * @创建人: houyx3
 * @创建时间: 2021-12-30
 * @修改备注:
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @Copyright (c) 2017宇信科技-版权所有
 */
public interface CmicAppAssembleSignUpMapper extends CommonMapper<CmicAppAssembleSignUpEntity> {

    List<CmicAppAssembleSignUpEntity> getInfoByIds(List ids);
}