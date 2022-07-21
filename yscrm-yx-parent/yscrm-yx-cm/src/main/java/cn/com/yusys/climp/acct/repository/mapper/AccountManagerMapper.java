package cn.com.yusys.climp.acct.repository.mapper;

import java.util.List;
import java.util.Map;
import cn.com.yusys.climp.acct.domain.LoyAcScoreAccount;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;

/**
 * @项目名称: yusp-climp-acct模块
 * @类名称: AccountManagerMapper
 * @类描述: #Dao类12
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2018-12-27 10:50:42
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public interface AccountManagerMapper extends CommonMapper<LoyAcScoreAccount> {

	List<Map<String, Object>> getList(QueryModel model);
	List<Map<String, Object>> getApprovalList(QueryModel model);
	ResultDto<Integer> delAcct(String id);
	String getSeq();
	List<Map<String, Object>> checkAcct(String acctNo);
	List<Map<String, Object>> checkAcctName(Map acctMap);
	List<Map<String, Object>> acctStsQuery(String acctTypeId);
}