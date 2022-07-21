package cn.com.yusys.climp.acct.web.rest;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import cn.com.yusys.climp.acct.domain.LoyAcScoreAccount;
import cn.com.yusys.climp.acct.service.AccountManagerService;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.security.SecurityUtils;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;

/**
 * @项目名称: yusp-climp-acct模块
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
@RequestMapping("/api/acct")
public class AccountManagerResource extends CommonResource<LoyAcScoreAccount, String> {

	private Logger logger = LoggerFactory.getLogger(AccountManagerResource.class);

	@Autowired
	private AccountManagerService accountManagerService;

	@Override
	protected CommonService getCommonService() {
		return accountManagerService;
	}

	// 账户信息查询
	@GetMapping("/accountList")
	public ResultDto<List<Map<String, Object>>> getList(QueryModel model) {
		return new ResultDto<List<Map<String, Object>>>(accountManagerService.getList(model));
	}

	// 审批页面账户信息查询
	@GetMapping("/approvalaccoutlist")
	public ResultDto<List<Map<String, Object>>> getApprovalList(QueryModel model) {
		return new ResultDto<List<Map<String, Object>>>(accountManagerService.getApprovalList(model));
	}

	// 账户新增
	@PostMapping("/addacct")
	public ResultDto<Object> addAcct(@RequestBody Map<String, Object> map) throws ParseException {
		LoyAcScoreAccount lasa = new LoyAcScoreAccount();
		// 生成 主键ID
		String uuid = UUID.randomUUID().toString().toLowerCase().replace("-", "");
		// 获取当前日期
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		// 获取当前用户code
		String loginCode = SecurityUtils.getCurrentUserLogin();
		lasa.setAccountId(uuid);
		if (map.get("accountName") != null && map.get("accountName") != "") {
			lasa.setAccountName((String) map.get("accountName"));
		}
		lasa.setAccountNo("QYZH" + accountManagerService.getSeq());
		if (map.get("acctPriority") != null && map.get("acctPriority") != "") {
			lasa.setAcctPriority(Long.valueOf(map.get("acctPriority").toString()));
		}
		if (map.get("acctTypeId") != null && map.get("acctTypeId") != "") {
			lasa.setAcctTypeId((String) map.get("acctTypeId"));
		}
		if (map.get("autoChange") != null && map.get("autoChange") != "") {
			lasa.setAutoChange((String) map.get("autoChange"));
		}
		lasa.setCreateDate(new Date());
		if (map.get("createOrg") != null && map.get("createOrg") != "") {
			lasa.setCreateOrg((String) map.get("createOrg"));
			lasa.setUpdateOrg((String) map.get("createOrg"));
		}
		lasa.setCreateUser(loginCode);
		if (map.get("poolNo") != null && map.get("POOL_NO") != "") {
			lasa.setPoolNo((String) map.get("POOL_NO"));
		}
		if (map.get("remark") != null && map.get("remark") != "") {
			lasa.setRemark((String) map.get("remark"));
		}
		if (map.get("scoreType") != null && map.get("scoreType") != "") {
			lasa.setScoreType((String) map.get("scoreType"));
		}
		if (map.get("timeValidType") != null && map.get("timeValidType") != "") {
			lasa.setTimeValidType((String) map.get("timeValidType"));
		}
		lasa.setUpdateDate(new Date());
		if (map.get("acctBType") != null && map.get("acctBType") != "") {
			lasa.setAcctBType((String) map.get("acctBType"));
		}
		if (map.get("acctSType") != null && map.get("acctSType") != "") {
			lasa.setAcctSType((String) map.get("acctSType"));
		}
		lasa.setDeleteSign("0");
		lasa.setUpdateUser(loginCode);
		lasa.setWfApprSts("000");

		ResultDto<Object> result = new ResultDto<Object>();
		try {
			accountManagerService.addAcount(lasa);
		} catch (Exception e) {
			result.setCode(-1);
			result.setMessage("账户新增失败！");
			logger.error(e.getStackTrace().toString());
		}
		return result;
	}

	// 账户调整
	@PostMapping("/updateacct")
	public ResultDto<Object> updateAcct(@RequestBody Map<String, Object> map) throws ParseException {
		LoyAcScoreAccount lasa = new LoyAcScoreAccount();
		// 获取当前日期
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		// 获取当前用户code
		String loginCode = SecurityUtils.getCurrentUserLogin();
		if (map.get("accountId") != null && map.get("accountId") != "") {
			lasa.setAccountId((String) map.get("accountId"));
		}
		if (map.get("accountName") != null && map.get("accountName") != "") {
			lasa.setAccountName((String) map.get("accountName"));
		}
		if (map.get("accountNo") != null && map.get("accountNo") != "") {
			lasa.setAccountNo((String) map.get("accountNo"));
		}
		// if(map.get("acctPriority")!= null && map.get("acctPriority")!="") {
		// lasa.setAcctPriority((long) map.get("acctPriority"));
		// }
		if (map.get("acctTypeId") != null && map.get("acctTypeId") != "") {
			lasa.setAcctTypeId((String) map.get("acctTypeId"));
		}
		if (map.get("autoChange") != null && map.get("autoChange") != "") {
			lasa.setAutoChange((String) map.get("autoChange"));
		}
		// lasa.setCreateDate(df.parse(df.format(new Date())));
		// lasa.setCreateUser(loginCode);
		if (map.get("poolNo") != null && map.get("poolNo") != "") {
			lasa.setPoolNo((String) map.get("poolNo"));
		}
		if (map.get("remark") != null && map.get("remark") != "") {
			lasa.setRemark((String) map.get("remark"));
		}
		if (map.get("scoreType") != null && map.get("scoreType") != "") {
			lasa.setScoreType((String) map.get("scoreType"));
		}
		if (map.get("timeValidType") != null && map.get("timeValidType") != "") {
			lasa.setTimeValidType((String) map.get("timeValidType"));
		}
		if (map.get("updateOrg") != null && map.get("updateOrg") != "") {
			lasa.setUpdateOrg((String) map.get("updateOrg"));
		}
		if (map.get("acctBType") != null && map.get("acctBType") != "") {
			lasa.setAcctBType((String) map.get("acctBType"));
		}
		if (map.get("acctSType") != null && map.get("acctSType") != "") {
			lasa.setAcctSType((String) map.get("acctSType"));
		}
		lasa.setUpdateDate(new Date());
		lasa.setDeleteSign("0");
		lasa.setUpdateUser(loginCode);
		lasa.setWfApprSts("000");

		ResultDto<Object> result = new ResultDto<Object>();
		try {
			accountManagerService.updateAcount(lasa);
		} catch (Exception e) {
			result.setCode(-1);
			result.setMessage("账户调整失败！");
			logger.error(e.getStackTrace().toString());
		}
		return result;
	}
	
	//积分账户删除
	@PostMapping("/delacct")
	public ResultDto<Integer> delAcct(@RequestBody Map<String, Object> map) {
		// List list = (List) map.get("ids");
		String id = (String) map.get("accountId");
		// return new ResultDto<Integer>(this.marketPlanService.deletePlan(ids));
		return accountManagerService.delAcct(id);
	}

	// 更新审批状态
	@PostMapping("/updatests")
	public ResultDto<Integer> updateSts(@RequestBody LoyAcScoreAccount lp) throws URISyntaxException {
		ResultDto<Integer> dto = new ResultDto<Integer>(this.accountManagerService.updateSts(lp));
		int num = accountManagerService.updateSts(lp);
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

	// 校验账户是否被引用
	@PostMapping("/checkacct")
	public ResultDto<List<Map<String, Object>>> checkAcct(@RequestBody Map<String, Object> map) {
		String acctNo = (String) map.get("accountNo");
		return new ResultDto<List<Map<String, Object>>>(accountManagerService.checkAcct(acctNo));
	}

	// 校验账户名字是否重复
	@PostMapping("/checkacctname")
	public ResultDto<List<Map<String, Object>>> checkAcctName(@RequestBody Map<String, Object> map) {
		List<Map<String, Object>> list;
		Map acctMap = new HashMap<>();
		String accountName = (String) map.get("accountName");
		acctMap.put("accountName", accountName);
		if(map.get("accountId") != null && !map.get("accountId").equals("")) {
			acctMap.put("accountId", map.get("accountId").toString());
		}
		return new ResultDto<List<Map<String, Object>>>(accountManagerService.checkAcctName(acctMap));
	}
	// 账户类型查询
	@GetMapping("/acctstsquery")
	public ResultDto<List<Map<String, Object>>> acctStsQuery(@RequestParam(required = false) String acctTypeId){
		return new ResultDto<List<Map<String, Object>>>(accountManagerService.acctStsQuery(acctTypeId));
	}
}
