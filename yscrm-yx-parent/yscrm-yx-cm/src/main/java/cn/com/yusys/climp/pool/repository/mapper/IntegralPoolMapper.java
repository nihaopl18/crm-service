package cn.com.yusys.climp.pool.repository.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.data.repository.query.Param;

import cn.com.yusys.climp.pool.domain.LoyAcScorePool;
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
public interface IntegralPoolMapper extends CommonMapper<LoyAcScorePool> {

	List<Map<String, Object>> getList(QueryModel model);
	
	List<Map<String, Object>> getPoolList(QueryModel model);

	ResultDto<Integer> delPool(String id);

	Integer getSeq();

	List<Map<String, Object>> activityPool();

	List<Map<String, Object>> poolParentId();

	int cheackpool(String parentId);
	

	List<Map<String, Object>> unlimit(String parentId);

//	List<Map<String, Object>> limit(@Param("parentId") String parentId,
//			@Param("pSI") String poolScoreInitial,@Param("poolId") String poolId);

	List<Map<String, Object>> limit(Map<String, String> map);

	void updateParentPool(Map<String, Object> map);
	
	void recoveryParentPool(Map<String, Object> map);

	void changeParentPool(Map map);

	List<Map<String, Object>> getPoolScoreInitial(String poolId);
	
	//子积分池删除时恢复父积分池额度
	void returnQuota(Map map);

	List<Map<String, Object>> delCheck(@Param("poolId") String poolId);

	List<Map<String, Object>> getLimitScore(String poolId);

	//新增、修改积分池时校验名字是否重复
	List<Map<String, Object>> checkPoolName(Map poolMap);
	
}