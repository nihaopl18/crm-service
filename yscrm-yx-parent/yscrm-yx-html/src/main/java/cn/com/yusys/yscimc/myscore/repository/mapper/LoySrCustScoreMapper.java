package cn.com.yusys.yscimc.myscore.repository.mapper;

import java.util.List;
import java.util.Map;

import cn.com.yusys.yscimc.myscore.domain.LoySrCustScore;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
/**
 * @项目名称: yusp-climp-acct模块
 * @类名称: LoySrCustScoreMapper
 * @类描述: #用户积分表Mapper
 * @功能描述: mapper
 * @创建人: yangxiao2
 * @创建时间: 2019-05-31 10:50:42
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public interface LoySrCustScoreMapper extends CommonMapper<LoySrCustScore> {
	
	/**
	 * @功能描述：用户积分明细查询
	 * */
	Map<String,Object>getCustScore(String custId);
	
	/**
	 * @功能描述：用户积分明细查询
	 * */
	List<Map<String,Object>>getCustScoreInfo(String custId);
}
