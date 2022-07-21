package cn.com.yusys.yscimc.myscore.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.yusys.yscimc.myscore.repository.mapper.LoySrCustScoreMapper;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.service.CommonService;
/**
 * @项目名称: yusp-climp-acct模块
 * @类名称: LoySrCustScoreService
 * @类描述: #用户积分明细查询
 * @功能描述: 
 * @创建人: yangxiao2
 * @创建时间: 2019-05-31 10:50:42
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class LoySrCustScoreService extends CommonService{
	
	@Autowired
	private LoySrCustScoreMapper mapper;
	
	@Override
	protected CommonMapper<?> getMapper() {
		return mapper;
	}

	/**
	 * @功能名称：getCustScore
	 * @功能描述：用户积分明细查询
	 * */
	public Map<String,Object>getCustScore(String custId){
		return mapper.getCustScore(custId);
	}
	
	/**
	 * @功能名称：getCustScoreInfo
	 * @功能描述：用户积分明细查询
	 * */
	public List<Map<String,Object>>getCustScoreInfo(String custId){
		return mapper.getCustScoreInfo(custId);
	}
}
