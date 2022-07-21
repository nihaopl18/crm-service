package cn.com.yusys.yscrm.info.remind.repository.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.com.yusys.yscrm.info.remind.domain.AcrmFwpRemindInfo;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;

/**
 * @项目名称: yscrm-mgr-info-remind-core模块
 * @类名称: AcrmFwpRemindMapper
 * @类描述: #Dao类
 * @功能描述:
 * @创建人: lufl
 * @创建时间: 2021-10-22 11:14:59
 * @修改备注:
 * @修改记录: 修改时间 修改人员 修改原因
 *        -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public interface AcrmFwpRemindInfoMapper extends CommonMapper<AcrmFwpRemindInfo> {
	int updateStateByIssuDate(@Param("userId") String userId,@Param("currentDate")String currentDate);

	int updateStateByInfoId(@Param("infoId") String infoId,@Param("currentDate")String currentDate);

	List<Map<String, Object>> queryList(QueryModel queryModel);

    int getIsReadNum(QueryModel queryModel);

	int updateStateByUserId(@Param("userId") String userId,@Param("currentDate")String currentDate);
}
