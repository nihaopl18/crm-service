package cn.com.yusys.yscrm.info.remind.repository.mapper;

import java.util.List;
import java.util.Map;

import cn.com.yusys.yscrm.info.remind.domain.AcrmFwpRemind;
import cn.com.yusys.yscrm.info.remind.domain.RemindExcle;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;

/**
 * @项目名称: yscrm-mgr-info-remind-core模块
 * @类名称: AcrmFwpRemindMapper
 * @类描述: #Dao类
 * @功能描述:
 * @创建人: lixt1
 * @创建时间: 2019-02-20 14:09:15
 * @修改备注:
 * @修改记录: 修改时间 修改人员 修改原因
 *        -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public interface AcrmFwpRemindMapper extends CommonMapper<AcrmFwpRemind> {

	List<Map<String, Object>> queryList(QueryModel model);

	int updateStat(AcrmFwpRemind acrmFwpRemind);

    List<RemindExcle> export(QueryModel model);

    List<Map<String, Object>> queryMList(QueryModel model);
}