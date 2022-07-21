package cn.com.yusys.yscimc.operation.repository.mapper;

import cn.com.yusys.yscimc.operation.domain.OcrmAciFqReport;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;

import java.util.List;
import java.util.Map;

/**
 * @version 1.0.0
 * @项目名称: yscrm-mgr-cust-flex
 * @类名称: OcrmAciFqReportMapper
 * @类描述: #Dao类
 * @功能描述:
 * @创建人: zhangxs4
 * @创建时间: 2019-02-12 15:07:22
 * @修改备注:
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @Copyright (c) 2017宇信科技-版权所有
 */
public interface OcrmAciFqReportMapper extends CommonMapper<OcrmAciFqReport> {
    List<Map<String, Object>> getList(Map<String, Object> param);
}