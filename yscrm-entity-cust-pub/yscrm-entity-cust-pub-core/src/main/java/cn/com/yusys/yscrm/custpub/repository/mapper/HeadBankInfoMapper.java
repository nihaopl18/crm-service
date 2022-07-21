package cn.com.yusys.yscrm.custpub.repository.mapper;

import java.util.List;
import java.util.Map;

/**
 * @项目名称: yscrm-entity-cust-pub-core模块
 * @类名称: HeadBankInfoMapper
 * @类描述: #Dao类
 * @功能描述:
 * @创建人: lufl
 * @创建时间: 2021-10-26 17:49:34
 * @修改备注:
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public interface HeadBankInfoMapper{
    List<Map<String, Object>> getBusiView();

    List<Map<String, Object>> getCustType();

    List<Map<String, Object>> getCustGrade();

    List<Map<String, Object>> getCustOrg();

    List<Map<String, Object>> getCardInfo();

    List<Map<String, Object>> getTableInfo();
}
