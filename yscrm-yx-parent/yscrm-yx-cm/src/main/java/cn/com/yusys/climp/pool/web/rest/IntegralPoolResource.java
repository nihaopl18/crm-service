package cn.com.yusys.climp.pool.web.rest;

import java.math.BigDecimal;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.com.yusys.climp.pool.domain.LoyAcScorePool;
import cn.com.yusys.climp.pool.service.IntegralPoolService;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.security.SecurityUtils;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;

/**
 * @项目名称: yusp-climp-pool模块
 * @类名称: AccountManagerResource
 * @类描述: #资源类
 * @功能描述:
 * @创建人: Administrator
 * @创建时间: 2018-12-27 10:50:42
 * @修改备注:
 * @修改记录: 修改时间 修改人员 修改原因
 *        -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/pool")
public class IntegralPoolResource extends CommonResource<LoyAcScorePool, String> {

	private Logger logger = LoggerFactory.getLogger(LoyAcScorePool.class);

	@Autowired
	private IntegralPoolService integralPoolService;

	@Override
	protected CommonService getCommonService() {
		return integralPoolService;
	}

	// 账户信息查询
	@GetMapping("/poolquery")
	public ResultDto<List<Map<String, Object>>> getList(QueryModel model) {
		return new ResultDto<List<Map<String, Object>>>(integralPoolService.getList(model));
	}

	// 审批账户信息查询
	@GetMapping("/poollist")
	public ResultDto<List<Map<String, Object>>> getPoolList(QueryModel model) {
		return new ResultDto<List<Map<String, Object>>>(integralPoolService.getPoolList(model));
	}

	// 积分池新增
	@PostMapping("/addpool")
	public ResultDto<Object> addPool(@RequestBody Map<String, Object> map) throws ParseException {
		LoyAcScorePool lasp = new LoyAcScorePool();
		// 生成 主键ID
		String uuid = UUID.randomUUID().toString().toLowerCase().replace("-", "");
		// 获取当前日期
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		// 获取当前用户code
		String loginCode = SecurityUtils.getCurrentUserLogin();
		BigDecimal bd = new BigDecimal("0");

		lasp.setPoolId(uuid);
		lasp.setPoolNo("JFC" + String.format("%1$04d",integralPoolService.getSeq()));
		if (map.get("poolName") != null && map.get("poolName") != "") {
			lasp.setPoolName((String) map.get("poolName"));
		}
		// if(map.get("poolScoreInitial")!= null && map.get("poolScoreInitial")!="") {
		// } else {
		// lasp.setPoolScoreInitial(bd);
		// }
		if (map.get("poolScoreInitial") != null && map.get("poolScoreInitial") != "") {
			lasp.setPoolScoreInitial(new BigDecimal(map.get("poolScoreInitial").toString()));
			lasp.setPoolScoreSurplus(new BigDecimal(map.get("poolScoreInitial").toString()));
		} else {
			lasp.setPoolScoreInitial(bd);
			lasp.setPoolScoreSurplus(bd);
		}
		if (map.get("poolScoreUsed") != null && map.get("poolScoreUsed") != "") {
			lasp.setPoolScoreUsed(new BigDecimal(map.get("poolScoreUsed").toString()));
		} else {
			lasp.setPoolScoreUsed(bd);
		}
		if (map.get("referenceCost") != null && map.get("referenceCost") != "") {
			lasp.setReferenceCost(new BigDecimal(map.get("referenceCost").toString()));
		} else {
			lasp.setReferenceCost(bd);
		}
		if (map.get("warnThreshold") != null && map.get("warnThreshold") != "") {
			lasp.setWarnThreshold((String) map.get("warnThreshold"));
		}
		if (map.get("warnPhoneNo") != null && map.get("warnPhoneNo") != "") {
			lasp.setWarnPhoneNo((String) map.get("warnPhoneNo"));
		}
		if (map.get("upperLimit") != null && map.get("upperLimit") != "") {
			lasp.setUpperLimit((String) map.get("upperLimit"));
		}
		if (map.get("remark") != null && map.get("remark") != "") {
			lasp.setRemark((String) map.get("remark"));
		}
		if (map.get("poolType") != null && map.get("poolType") != "") {
			lasp.setPoolType((String) map.get("poolType"));
		}
		if (map.get("poolParentId") != null && map.get("poolParentId") != "") {
			lasp.setPoolParentId((String) map.get("poolParentId"));
		}
		if (map.get("createOrg") != null && map.get("createOrg") != "") {
			lasp.setCreateOrg((String) map.get("createOrg"));
			lasp.setUpdateOrg((String) map.get("createOrg"));
		}
		lasp.setCreateUser(loginCode);
		lasp.setCreateDate(new Date());
		lasp.setUpdateDate(new Date());
		lasp.setUpdateUser(loginCode);
		lasp.setDeleteSign("0");
		lasp.setWfApprSts("000");

		ResultDto<Object> result = new ResultDto<Object>();
		try {
			integralPoolService.addPool(lasp);
		} catch (Exception e) {
			result.setCode(-1);
			result.setMessage("积分池新增失败！");
			logger.error(e.getStackTrace().toString());
		}
		return result;
	}

	// 积分池调整
	@PostMapping("/updatepool")
	public ResultDto<Object> updateAcct(@RequestBody Map<String, Object> map) throws ParseException {
		LoyAcScorePool lasp = new LoyAcScorePool();
		// 获取当前日期
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		// 获取当前用户code
		String loginCode = SecurityUtils.getCurrentUserLogin();
		if (map.get("poolId") != null && map.get("poolId") != "") {
			lasp.setPoolId((String) map.get("poolId"));
		}
		if (map.get("poolNo") != null && map.get("poolNo") != "") {
			lasp.setPoolNo((String) map.get("poolNo"));
		}
		if (map.get("poolName") != null && map.get("poolName") != "") {
			lasp.setPoolName((String) map.get("poolName"));
		}
		if (map.get("poolScoreInitial") != null && map.get("poolScoreInitial") != "") {
			lasp.setPoolScoreInitial(new BigDecimal(map.get("poolScoreInitial").toString()));
		}
		if (map.get("poolScoreUsed") != null && map.get("poolScoreUsed") != "") {
			lasp.setPoolScoreUsed(new BigDecimal(map.get("poolScoreUsed").toString()));
		}
		if (map.get("poolScoreSurplus") != null && map.get("poolScoreSurplus") != "") {
			lasp.setPoolScoreSurplus(new BigDecimal(map.get("poolScoreSurplus").toString()));
		}
		if (map.get("referenceCost") != null && map.get("referenceCost") != "") {
			lasp.setReferenceCost(new BigDecimal(map.get("referenceCost").toString()));
		}
		// if(map.get("poolNo")!= null && map.get("poolNo")!="") {
		// lasp.setPoolNo((String) map.get("poolNo"));
		// }
		if (map.get("warnThreshold") != null && map.get("warnThreshold") != "") {
			lasp.setWarnThreshold((String) map.get("warnThreshold"));
		}
		if (map.get("warnPhoneNo") != null && map.get("warnPhoneNo") != "") {
			lasp.setWarnPhoneNo((String) map.get("warnPhoneNo"));
		}
		if (map.get("upperLimit") != null && map.get("upperLimit") != "") {
			lasp.setUpperLimit((String) map.get("upperLimit"));
		}
		if (map.get("remark") != null && map.get("remark") != "") {
			lasp.setRemark((String) map.get("remark"));
		}
		if (map.get("poolType") != null && map.get("poolType") != "") {
			lasp.setPoolType((String) map.get("poolType"));
		}
		lasp.setUpdateDate(new Date());
		lasp.setUpdateUser(loginCode);
		if (map.get("updateOrg") != null && map.get("updateOrg") != "") {
			lasp.setUpdateOrg((String) map.get("updateOrg"));
		}
		if (map.get("poolParentId") != null && map.get("poolParentId") != "") {
			lasp.setPoolParentId((String) map.get("poolParentId"));
		} else {
			lasp.setPoolParentId("");
		}
		if (map.get("poolType") != null && map.get("poolType") != "") {
			lasp.setPoolType((String) map.get("poolType"));
		}
		lasp.setDeleteSign("0");
		lasp.setWfApprSts("000");

		ResultDto<Object> result = new ResultDto<Object>();
		try {
			integralPoolService.updatePool(lasp);
		} catch (Exception e) {
			result.setCode(-1);
			result.setMessage("积分池调整失败！");
			logger.error(e.getStackTrace().toString());
		}
		return result;
	}

	// 删除积分池
	@PostMapping("/delpool")
	public ResultDto<Integer> delPool(@RequestBody Map<String, Object> map) {
		String id = (String) map.get("ids");
		return integralPoolService.delPool(id);
	}

	// 活动有效积分池查询
	@GetMapping("/activitypool")
	public ResultDto<List<Map<String, Object>>> activityPool() {
		return new ResultDto<List<Map<String, Object>>>(integralPoolService.activityPool());
	}

	// 父积分池查询
	@GetMapping("/poolparentid")
	public ResultDto<List<Map<String, Object>>> poolParentId() {
		return new ResultDto<List<Map<String, Object>>>(integralPoolService.poolParentId());
	}

	// 校验父积分池额度
	@PostMapping("/checkpool")
	public ResultDto<List<Map<String, Object>>> checkpool(@RequestBody Map<String, Object> map) {
		// 父积分池ID
		String parentId = (String) map.get("poolParentId");
		// 是否存在上限
		String upperLimit = (String) map.get("upperLimit");
		// 积分池额度
		String poolScoreInitial = map.get("poolScoreInitial").toString();
		String poolId = "";
		if (map.get("poolId") != null && map.get("poolId") != "") {
			poolId = (String) map.get("poolId");
		}
		return new ResultDto<List<Map<String, Object>>>(
				integralPoolService.checkpool(parentId, upperLimit, poolScoreInitial, poolId));
	}

	// 更新审批状态
	@PostMapping("/updatests")
	public ResultDto<Integer> updateSts(@RequestBody LoyAcScorePool lp) throws URISyntaxException {
		ResultDto<Integer> dto = new ResultDto<Integer>(this.integralPoolService.updateSts(lp));
		int num = integralPoolService.updateSts(lp);
		logger.info("num=" + num);
		if (num == 0) {
			dto.setMessage("失败！");
			dto.setCode(-1);
		} else {
			dto.setMessage("成功");
			dto.setCode(0);
		}
		return dto;
	}

	// 删除校验积分池是否被引用
	@PostMapping("/delcheck")
	public ResultDto<List<Map<String, Object>>> delCheck(@RequestBody Map<String, Object> map) {
		String poolId = (String) map.get("poolNo");
		return new ResultDto<List<Map<String, Object>>>(integralPoolService.delCheck(poolId));
	}

	// 返回积分池剩余额度和是否有上线
	@PostMapping("/getlimitscore")
	public ResultDto<List<Map<String, Object>>> getLimitScore(@RequestBody Map<String, Object> map) {
		String poolId = (String) map.get("poolId");
		return new ResultDto<List<Map<String, Object>>>(integralPoolService.getLimitScore(poolId));
	}

	// 校验积分池名字是否重复
	@PostMapping("/checkpoolname")
	public ResultDto<List<Map<String, Object>>> checkPoolName(@RequestBody Map<String, Object> map) {
		List<Map<String, Object>> list;
		Map poolMap = new HashMap<>();
		String poolName = (String) map.get("poolName");
		poolMap.put("poolName", poolName);
		if(map.get("poolId") != null && !map.get("poolId").equals("")) {
			poolMap.put("poolId", map.get("poolId").toString());
		}
		return new ResultDto<List<Map<String, Object>>>(integralPoolService.checkPoolName(poolMap));
	}

}
