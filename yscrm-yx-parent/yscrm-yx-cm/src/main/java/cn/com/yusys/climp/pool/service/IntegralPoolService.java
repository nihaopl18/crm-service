package cn.com.yusys.climp.pool.service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import cn.com.yusys.climp.pool.domain.LoyAcScorePool;
import cn.com.yusys.climp.pool.repository.mapper.IntegralPoolMapper;
import cn.com.yusys.climp.utils.UserInfoService;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.security.SecurityUtils;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;

/**
 * @项目名称: yusp-climp-acct模块
 * @类名称: AccountManagerService
 * @类描述: #服务类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2018-12-27 10:50:42
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class IntegralPoolService extends CommonService {
    @Autowired
    private IntegralPoolMapper integralPoolMapper;

	@Autowired
	private UserInfoService userInfo;  
	
    @Override
    protected CommonMapper<?> getMapper() {
        return this.integralPoolMapper;
    }

	public List<Map<String, Object>> getList(QueryModel model) {
		PageHelper.startPage(model.getPage(), model.getSize());
		return integralPoolMapper.getList(model);
	}
	
	public List<Map<String, Object>> getPoolList(QueryModel model) {
		PageHelper.startPage(model.getPage(), model.getSize());
		return integralPoolMapper.getPoolList(model);
	}

	public LoyAcScorePool addPool(LoyAcScorePool lasp) {
		if(lasp.getPoolParentId() != null && !lasp.getPoolParentId().equals("")) {
			String parentId = lasp.getPoolParentId();
			BigDecimal updateScore = lasp.getPoolScoreInitial();
			Map map = new HashMap<>();
			map.put("parentId", parentId);
			map.put("updateScore", updateScore);
			integralPoolMapper.updateParentPool(map);
			
		}
		if (this.insertSelective(getMapper(), lasp) != 1) {
			return null;
		}
		return lasp;
	}

	public LoyAcScorePool updatePool(LoyAcScorePool lasp) {
		String poolId = lasp.getPoolId();
		 List<Map<String, Object>> lp = integralPoolMapper.getPoolScoreInitial(poolId);
		 BigDecimal relScoreInitial = lasp.getPoolScoreInitial().subtract(new BigDecimal(lp.get(0).get("poolScoreInitial").toString()));
		 BigDecimal poolScoreSurplus = new BigDecimal(lp.get(0).get("poolScoreSurplus").toString());
		 lasp.setPoolScoreSurplus(poolScoreSurplus.add(relScoreInitial));
		 //为修改前父积分池恢复积分
		 if(lp.get(0).get("poolParentId") != null && !lp.get(0).get("poolParentId").equals("")) {
			//修改前额度
			String bparentId = (String) lp.get(0).get("poolParentId");
			BigDecimal updateScore = (BigDecimal) lp.get(0).get("poolScoreInitial");
			Map bmap = new HashMap<>();
			bmap.put("parentId", bparentId);
			bmap.put("updateScore", updateScore);
			integralPoolMapper.recoveryParentPool(bmap);
			 
		 }
		if(lasp.getPoolParentId() != null && !lasp.getPoolParentId().equals("")) {
			String parentId = lasp.getPoolParentId();
			BigDecimal updateScore = lasp.getPoolScoreInitial();
			Map map = new HashMap<>();
			map.put("parentId", parentId);
			map.put("updateScore", updateScore);
			integralPoolMapper.updateParentPool(map);
		}
		if (this.updateSelective(getMapper(), lasp) != 1) {
			return null;
		}
		return lasp;
	}

	public ResultDto<Integer> delPool(String id) {
		// TODO 自动生成的方法存根
		 List<Map<String, Object>> lp = integralPoolMapper.getPoolScoreInitial(id);
		 if(lp.size()>0) {
			 if(lp.get(0).get("poolParentId")!= null && !lp.get(0).get("poolParentId").equals("")) {
				 BigDecimal poolScoreInitial = new BigDecimal(lp.get(0).get("poolScoreInitial").toString());
				 String poolParentId = lp.get(0).get("poolParentId").toString();
				 List<Map<String, Object>> fPool = integralPoolMapper.getPoolScoreInitial(poolParentId);
				 if(fPool.size()>0) {
					 //获取父积分池原已用积分和可用积分
					 BigDecimal poolScoreUsed = new BigDecimal(fPool.get(0).get("poolScoreUsed").toString());
					 BigDecimal poolScoreSurplus = new BigDecimal(fPool.get(0).get("poolScoreSurplus").toString());
					 Map map = new HashMap<>();
					 map.put("poolParentId", poolParentId);
					 map.put("poolScoreInitial", poolScoreInitial);
					 map.put("poolScoreUsed", poolScoreUsed);
					 map.put("poolScoreSurplus", poolScoreSurplus);
					 integralPoolMapper.returnQuota(map);
				 }
			 }
		 }
		return integralPoolMapper.delPool(id);
	}

	public Integer getSeq() {
		// TODO 自动生成的方法存根
		return integralPoolMapper.getSeq();
	}

	public List<Map<String, Object>> activityPool() {
//		PageHelper.startPage(model.getPage(), model.getSize());
		return integralPoolMapper.activityPool();
	}

	public List<Map<String, Object>> poolParentId() {
		// TODO 自动生成的方法存根
		return integralPoolMapper.poolParentId();
	}

	public List<Map<String, Object>> checkpool(String parentId, String upperLimit, String poolScoreInitial, String poolId) {
		List<Map<String, Object>> list;
//		if(upperLimit.equals("0")) {
//			list = integralPoolMapper.unlimit(parentId);
//		} else {
		Map<String,String> map = new HashMap<>();
		map.put("parentId", parentId);
		map.put("poolScoreInitial", poolScoreInitial);
		map.put("poolId", poolId);
		list = integralPoolMapper.limit(map);
//		}
		return list;
	}
	
	 /*
	  * 更新任务状态
	  * */
	public int updateSts(LoyAcScorePool lp) {
		// 获取登录用户的机构号
		String orgCode = userInfo.getOrgCode();
		// 设置最新更新人
		lp.setUpdateUser(SecurityUtils.getCurrentUserLogin());
		lp.setUpdateOrg(orgCode);
		lp.setUpdateDate(new Date());
		return this.updateSelective(getMapper(), lp);
	}
	
	 /*
	  * 审批通过更新任务状态
	  * */
	public void updateStsSs(String BizSeqNo) {
		// 获取登录用户的机构号
		String orgCode = userInfo.getOrgCode();
		// 设置最新更新人
		LoyAcScorePool c = new LoyAcScorePool();
		c.setUpdateUser(SecurityUtils.getCurrentUserLogin());
		c.setWfApprSts("997");
		c.setUpdateOrg(orgCode);
		c.setPoolId(BizSeqNo);
		c.setUpdateDate(new Date());
		this.updateSelective(getMapper(), c);
		}
	
	 /*
	  * 审批退回更新任务状态
	  * */
	public void updateStsBack(String BizSeqNo) {
		// 获取登录用户的机构号
		String orgCode = userInfo.getOrgCode();
		// 设置最新更新人
		LoyAcScorePool c = new LoyAcScorePool();
		c.setUpdateUser(SecurityUtils.getCurrentUserLogin());
		c.setWfApprSts("998");
		c.setUpdateOrg(orgCode);
		c.setPoolId(BizSeqNo);
		c.setUpdateDate(new Date());
		this.updateSelective(getMapper(), c);
		}

	public List<Map<String, Object>> delCheck(String poolId) {
		// TODO 自动生成的方法存根
		return integralPoolMapper.delCheck(poolId);
	}

	public List<Map<String, Object>> getLimitScore(String poolId) {
		// TODO 自动生成的方法存根
		return integralPoolMapper.getLimitScore(poolId);
	}

	public List<Map<String, Object>> checkPoolName(Map poolMap) {
		// TODO 自动生成的方法存根
		return integralPoolMapper.checkPoolName(poolMap);
	}
}
