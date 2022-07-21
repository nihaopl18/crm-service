package cn.com.yusys.yusp.uimp.business.pma.coefficient.repository.mapper;

import java.util.List;
import java.util.Map;

import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.uimp.business.pma.coefficient.domain.PmaFCashAmountTrancode;

/**
 * @项目名称: uimp-business-pma-scheme-core模块
 * @类名称: PmaFCashAmountTrancodeMapper
 * @类描述: #Dao类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2020-07-14 10:29:34
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
public interface PmaFCashAmountTrancodeMapper extends CommonMapper<PmaFCashAmountTrancode> {

	List<Map<String, Object>> querylist(QueryModel model);

	int insertData(PmaFCashAmountTrancode pmaFCashAmountTrancode);

	int deleteData(PmaFCashAmountTrancode pmaFCashAmountTrancode);

	String selectCount(QueryModel modelNew);
	
}