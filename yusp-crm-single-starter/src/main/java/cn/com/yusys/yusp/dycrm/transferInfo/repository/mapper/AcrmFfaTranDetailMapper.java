package cn.com.yusys.yusp.dycrm.transferInfo.repository.mapper;

import java.util.List;
import java.util.Map;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.dycrm.transferInfo.domain.AcrmFfaTranDetail;
import cn.com.yusys.yusp.dycrm.transferInfo.domain.TransferInfoAG;
import cn.com.yusys.yusp.dycrm.transferInfo.domain.TransferInfoFA;


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
public interface AcrmFfaTranDetailMapper extends CommonMapper<AcrmFfaTranDetail> {
	List<Map<String, Object>> queryMonth(QueryModel queryModel);

	List<Map<String, Object>> queryAll(QueryModel queryModel);

    List<TransferInfoFA> excelMonth(QueryModel model);

	List<TransferInfoFA> excelAll(QueryModel model);
}