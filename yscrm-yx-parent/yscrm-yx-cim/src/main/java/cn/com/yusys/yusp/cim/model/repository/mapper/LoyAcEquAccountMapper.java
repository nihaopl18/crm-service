package cn.com.yusys.yusp.cim.model.repository.mapper;

import cn.com.yusys.yusp.cim.model.domain.LoyAcEquAccount;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;

import java.util.List;
import java.util.Map;

/**
 * @version 1.0.0
 * @项目名称: yscimc-cust-group模块
 * @类名称: LoyAcEquAccountMapper
 * @类描述: #Dao类
 * @功能描述:
 * @创建人: hyx
 * @创建时间: 2019-05-27 18:17:31
 * @修改备注:
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @Copyright (c) 2017宇信科技-版权所有
 */
public interface LoyAcEquAccountMapper extends CommonMapper<LoyAcEquAccount> {

    List<Map<String, Object>> getListByModel(QueryModel model);

    LoyAcEquAccount getInfoById(String accountId);

    List<Map<String, Object>> getFinanceOrg(QueryModel model);

    String getAccountSeq();

    List<Map<String, Object>> getOrgTreeByInstu(QueryModel model);

}