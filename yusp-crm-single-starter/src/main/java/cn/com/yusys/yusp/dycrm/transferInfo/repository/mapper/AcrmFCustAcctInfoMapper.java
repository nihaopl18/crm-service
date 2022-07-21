package cn.com.yusys.yusp.dycrm.transferInfo.repository.mapper;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.dycrm.transferInfo.domain.AcrmFCustAcctInfo;

import java.util.List;
import java.util.Map;

/**
 * @项目名称: dycrm-transferInfo模块
 * @类名称: AcrmFCustAcctInfoMapper
 * @类描述: #Dao类
 * @功能描述: 
 * @创建人: lufl
 * @创建时间: 2021-09-02 16:47:01
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public interface AcrmFCustAcctInfoMapper extends CommonMapper<AcrmFCustAcctInfo> {

	List<String> querySubAcctNo(QueryModel queryModel);

	List<String> queryMainAcctNo(QueryModel queryModel);

}