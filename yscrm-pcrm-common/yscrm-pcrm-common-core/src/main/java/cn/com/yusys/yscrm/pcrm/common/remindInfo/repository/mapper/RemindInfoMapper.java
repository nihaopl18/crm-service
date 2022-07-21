package cn.com.yusys.yscrm.pcrm.common.remindInfo.repository.mapper;

import cn.com.yusys.yscrm.pcrm.common.remindInfo.domain.EchainJoinWorkEndDTO;
import cn.com.yusys.yscrm.pcrm.common.remindInfo.domain.EchainJoinWorkTodoDTO;
import cn.com.yusys.yscrm.pcrm.common.remindInfo.domain.RemindInfo;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;

import java.util.List;

/**
 * @项目名称: yscrm-pcrm-common-core模块
 * @类名称: AcrmFwpRemindMapper
 * @类描述: #Dao类
 * @功能描述:
 * @创建人: lufl
 * @创建时间: 2021-11-04 10:31
 * @修改备注:
 * @修改记录: 修改时间 修改人员 修改原因
 *        -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public interface RemindInfoMapper extends CommonMapper<RemindInfo> {
    List<EchainJoinWorkTodoDTO> selectUserTodos(QueryModel model);

    List<EchainJoinWorkEndDTO> selectUserEnds(QueryModel model);

    List<EchainJoinWorkTodoDTO> selectUserDones(QueryModel model);
}
