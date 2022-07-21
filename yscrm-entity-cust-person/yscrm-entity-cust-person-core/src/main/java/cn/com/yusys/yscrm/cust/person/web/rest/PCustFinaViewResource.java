package cn.com.yusys.yscrm.cust.person.web.rest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.com.yusys.yscrm.cust.person.domain.OcrmFciPerAssetInfo;
import cn.com.yusys.yscrm.cust.person.domain.OcrmFciPerFamiBalance;
import cn.com.yusys.yscrm.cust.person.domain.OcrmFciPerFarmerProd;
import cn.com.yusys.yscrm.cust.person.domain.OcrmFciPerFinanceInfo;
import cn.com.yusys.yscrm.cust.person.domain.OcrmFciPerIncomeInfo;
import cn.com.yusys.yscrm.cust.person.domain.OcrmFciPerInsurInfo;
import cn.com.yusys.yscrm.cust.person.domain.OcrmFciPerInvInfo;
import cn.com.yusys.yscrm.cust.person.domain.OcrmFciPerLiabInfo;
import cn.com.yusys.yscrm.cust.person.domain.OcrmFciPerManageInfo;
import cn.com.yusys.yscrm.cust.person.domain.OcrmFciPerOthbankDep;
import cn.com.yusys.yscrm.cust.person.domain.OcrmFciPerTaxInfo;
import cn.com.yusys.yscrm.cust.person.service.PCustFinaViewService;
import cn.com.yusys.yusp.admin.web.rest.util.HeaderUtil;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yusp.uaa.client.UaaClient;
import cn.com.yusys.yusp.uaa.client.dto.UserInfoDTO;
import net.sf.json.JSONObject;

/**
 * @项目名称: yscrm-entity-cust-person-core模块
 * @类名称: OcrmFciPerFinanceInfoResource
 * @类描述: #资源类
 * @功能描述:
 * @创建人: Administrator
 * @创建时间: 2019-02-14 10:48:13
 * @修改备注:
 * @修改记录: 修改时间 修改人员 修改原因
 *        -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/pcustfinaview")
public class PCustFinaViewResource extends CommonResource<OcrmFciPerFinanceInfo, String> {
	@Autowired
	private PCustFinaViewService pCustFinaViewService;

	@Autowired
	private UaaClient uaaClient;

	@Override
	protected CommonService getCommonService() {
		return this.pCustFinaViewService;
	}

	/**
	 * 财务信息查询
	 * 
	 * @param model
	 * @param custId
	 * @return
	 */
	@GetMapping("/queryfinlist/{custId}")
	public ResultDto<Map<String, List<Map<Object, String>>>> queryFinList(QueryModel model,
			@PathVariable String custId) {
		// List<Map<Object, String>>
		// finInfo=pCustFinaViewService.getFinList(model,custId);//财务信息
		// List<Map<Object, String>>
		// investInfo=pCustFinaViewService.getInvestList(model, custId);//投资信息
		// List<Map<Object, String>>
		// incomeInfo=pCustFinaViewService.getIncomeList(model, custId);//收入信息
		// List<Map<Object, String>>
		// familyincInfo=pCustFinaViewService.getFamilyincList(model, custId);//家庭收支信息
		// List<Map<Object, String>>
		// assetsInfo=pCustFinaViewService.getAssetsList(model,custId);//资产信息info
		List<Map<Object, String>> liabiInfo = pCustFinaViewService.getLiabiList(model, custId);// 负债信息
		List<Map<Object, String>> insurInfo = pCustFinaViewService.getInsurList(model, custId);// 保险信息
		List<Map<Object, String>> payInfo = pCustFinaViewService.getPayList(model, custId);// 纳税信息
		List<Map<Object, String>> operInfo = pCustFinaViewService.getOperList(model, custId);// 经营信息info
		List<Map<Object, String>> farmerInfo = pCustFinaViewService.getFarmerList(model, custId);// 农户信息

		Map<String, List<Map<Object, String>>> allInfo = new HashMap<String, List<Map<Object, String>>>();
		// allInfo.put("finInfo", finInfo);
		// allInfo.put("investInfo", investInfo);
		// allInfo.put("incomeInfo", incomeInfo);
		// allInfo.put("familyincInfo", familyincInfo);
		// allInfo.put("assetsInfo", assetsInfo);
		allInfo.put("liabiInfo", liabiInfo);
		allInfo.put("insurInfo", insurInfo);
		allInfo.put("payInfo", payInfo);
		allInfo.put("operInfo", operInfo);
		allInfo.put("farmerInfo", farmerInfo);
		ResultDto<Map<String, List<Map<Object, String>>>> resultDto = new ResultDto<Map<String, List<Map<Object, String>>>>();
		resultDto.setData(allInfo);
		;

		return resultDto;
	}

	// 财务信息查询
	@GetMapping("/queryfin/{custId}")
	public ResultDto<List<Map<Object, String>>> queryFin(QueryModel model, @PathVariable String custId) {
		return new ResultDto<List<Map<Object, String>>>(pCustFinaViewService.queryFin(custId));
	}

	// 财务信息新增修改方法
	@PostMapping("/updatefinance/{custId}")
	public ResultDto<Integer> updateFinance(@RequestBody Map c, @PathVariable String custId) {
		Map map = (Map) c.get("finrefomodel");
		map.put("custId", custId);
		return new ResultDto<Integer>(pCustFinaViewService.updateFinance(map));
	}

	// 财务信息删除方法
	@PostMapping("/delfinance")
	public ResultDto<Integer> delFinance(@RequestBody Map c) {
		String id = (String) c.get("id");
		return new ResultDto<Integer>(pCustFinaViewService.delFinance(id));
	}

	// 信贷客户投资信息查询
	@GetMapping("/getinvestlist/{custId}")
	public ResultDto<List<Map<Object, String>>> getInvestList(QueryModel model, @PathVariable String custId) {
		return new ResultDto<List<Map<Object, String>>>(pCustFinaViewService.getInvestList(custId));
	}

	// 信贷客户投资信息新增修改方法
	@PostMapping("/updateinvest/{custId}")
	public ResultDto<Integer> updateInvest(@RequestBody Map c, @PathVariable String custId) {
		Map map = (Map) c.get("investreffomodel");
		map.put("custId", custId);
		return new ResultDto<Integer>(pCustFinaViewService.updateInvest(map));
	}

	// 信贷客户投资信息删除方法
	@PostMapping("/delinvest")
	public ResultDto<Integer> delInvest(@RequestBody Map c) {
		String id = (String) c.get("id");
		return new ResultDto<Integer>(pCustFinaViewService.delInvest(id));
	}

	// 收入信息查询
	@GetMapping("/getincomelist/{custId}")
	public ResultDto<List<Map<Object, String>>> getIncomeList(QueryModel model, @PathVariable String custId) {
		return new ResultDto<List<Map<Object, String>>>(pCustFinaViewService.getIncomeList(custId));
	}

	// 收入信息新增修改方法
	@PostMapping("/updateincome/{custId}")
	public ResultDto<Integer> updateIncome(@RequestBody Map c, @PathVariable String custId) {
		Map map = (Map) c.get("incomefomodel");
		map.put("custId", custId);
		return new ResultDto<Integer>(pCustFinaViewService.updateIncome(map));
	}

	// 收入信息删除方法
	@PostMapping("/delincome")
	public ResultDto<Integer> delIncome(@RequestBody Map c) {
		String id = (String) c.get("id");
		return new ResultDto<Integer>(pCustFinaViewService.delIncome(id));
	}

	// 家庭收支信息查询
	@GetMapping("/getfamilyinclist/{custId}")
	public ResultDto<List<Map<Object, String>>> getFamilyincList(QueryModel model, @PathVariable String custId) {
		return new ResultDto<List<Map<Object, String>>>(pCustFinaViewService.getFamilyincList(custId));
	}

	// 家庭收支信息新增修改方法
	@PostMapping("/updatefamilyinc/{custId}")
	public ResultDto<Integer> updateFamilyinc(@RequestBody Map c, @PathVariable String custId) {
		Map map = (Map) c.get("familyincfomodel");
		map.put("custId", custId);
		return new ResultDto<Integer>(pCustFinaViewService.updateFamilyinc(map));
	}

	// 家庭收支信息删除方法
	@PostMapping("/delfamilyinc")
	public ResultDto<Integer> delFamilyinc(@RequestBody Map c) {
		String id = (String) c.get("id");
		return new ResultDto<Integer>(pCustFinaViewService.delFamilyinc(id));
	}

	// 资产信息查询
	@GetMapping("/getassetslist/{custId}")
	public ResultDto<List<Map<Object, String>>> getAssetsList(QueryModel model, @PathVariable String custId) {
		return new ResultDto<List<Map<Object, String>>>(pCustFinaViewService.getAssetsList(custId));
	}

	// 资产信息新增修改方法
	@PostMapping("/updateassets/{custId}")
	public ResultDto<Integer> updateAssets(@RequestBody Map c, @PathVariable String custId) {
		Map map = (Map) c.get("assetsmodel");
		map.put("custId", custId);
		return new ResultDto<Integer>(pCustFinaViewService.updateAssets(map));
	}

	// 资产信息删除方法
	@PostMapping("/delassets")
	public ResultDto<Integer> delAssets(@RequestBody Map c) {
		String id = (String) c.get("id");
		return new ResultDto<Integer>(pCustFinaViewService.delAssets(id));
	}

	// 负债信息查询
	@GetMapping("/getLiabilist/{custId}")
	public ResultDto<List<Map<Object, String>>> getLiabiList(QueryModel model, @PathVariable String custId) {
		return new ResultDto<List<Map<Object, String>>>(pCustFinaViewService.getLiabiList(custId));
	}

	// 负债信息新增修改方法
	@PostMapping("/updateliabi/{custId}")
	public ResultDto<Integer> updateLiabi(@RequestBody Map c, @PathVariable String custId) {
		Map map = (Map) c.get("liabimodel");
		map.put("custId", custId);
		return new ResultDto<Integer>(pCustFinaViewService.updateLiabi(map));
	}

	// 负债信息删除方法
	@PostMapping("/delliabi")
	public ResultDto<Integer> delLiabi(@RequestBody Map c) {
		String id = (String) c.get("id");
		return new ResultDto<Integer>(pCustFinaViewService.delLiabi(id));
	}

	// 保险信息查询
	@GetMapping("/getinsurlist/{custId}")
	public ResultDto<List<Map<Object, String>>> getInsurList(QueryModel model, @PathVariable String custId) {
		return new ResultDto<List<Map<Object, String>>>(pCustFinaViewService.getInsurList(custId));
	}

	// 保险信息新增修改方法
	@PostMapping("/updateinsur/{custId}")
	public ResultDto<Integer> updateInsur(@RequestBody Map c, @PathVariable String custId) {
		Map map = (Map) c.get("insurmodel");
		map.put("custId", custId);
		return new ResultDto<Integer>(pCustFinaViewService.updateInsur(map));
	}

	// 保险信息删除方法
	@PostMapping("/delinsur")
	public ResultDto<Integer> delInsur(@RequestBody Map c) {
		String id = (String) c.get("id");
		return new ResultDto<Integer>(pCustFinaViewService.delInsur(id));
	}

	// 纳税信息查询
	@GetMapping("/getpaylist/{custId}")
	public ResultDto<List<Map<Object, String>>> getPayList(QueryModel model, @PathVariable String custId) {
		return new ResultDto<List<Map<Object, String>>>(pCustFinaViewService.getPayList(custId));
	}

	// 纳税信息新增修改方法
	@PostMapping("/updatepay/{custId}")
	public ResultDto<Integer> updatePay(@RequestBody Map c, @PathVariable String custId) {
		Map map = (Map) c.get("paymodel");
		map.put("custId", custId);
		return new ResultDto<Integer>(pCustFinaViewService.updatePay(map));
	}

	// 纳税信息删除方法
	@PostMapping("/delpay")
	public ResultDto<Integer> delPay(@RequestBody Map c) {
		String id = (String) c.get("id");
		return new ResultDto<Integer>(pCustFinaViewService.delPay(id));
	}

	// 经营信息查询
	@GetMapping("/getoperlist/{custId}")
	public ResultDto<List<Map<Object, String>>> getOperList(QueryModel model, @PathVariable String custId) {
		return new ResultDto<List<Map<Object, String>>>(pCustFinaViewService.getOperList(custId));
	}

	// 经营信息新增修改方法
	@PostMapping("/updateoper/{custId}")
	public ResultDto<Integer> updateOper(@RequestBody Map c, @PathVariable String custId) {
		Map map = (Map) c.get("opermodel");
		map.put("custId", custId);
		return new ResultDto<Integer>(pCustFinaViewService.updateOper(map));
	}

	// 经营信息删除方法
	@PostMapping("/deloper")
	public ResultDto<Integer> delOper(@RequestBody Map c) {
		String id = (String) c.get("id");
		return new ResultDto<Integer>(pCustFinaViewService.delOper(id));
	}

	// 农户生产情况查询
	@GetMapping("/getfarmerlist/{custId}")
	public ResultDto<List<Map<Object, String>>> getFarmerList(QueryModel model, @PathVariable String custId) {
		return new ResultDto<List<Map<Object, String>>>(pCustFinaViewService.getFarmerList(custId));
	}

	// 农户生产情况新增修改方法
	@PostMapping("/updatefarmer/{custId}")
	public ResultDto<Integer> updateFarmer(@RequestBody Map c, @PathVariable String custId) {
		Map map = (Map) c.get("farmermodel");
		map.put("custId", custId);
		return new ResultDto<Integer>(pCustFinaViewService.updateFarmer(map));
	}

	// 农户生产情况删除方法
	@PostMapping("/delfarmer")
	public ResultDto<Integer> delFarmer(@RequestBody Map c) {
		String id = (String) c.get("id");
		return new ResultDto<Integer>(pCustFinaViewService.delFarmer(id));
	}

	/**
	 * 财务信息修改
	 * 
	 * @param model
	 * @param custId
	 * @return
	 */
	@PostMapping("/updatefina")
	public ResultDto<Integer> updateInfo(@RequestBody Map c) {
		ResponseEntity<UserInfoDTO> dto = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());

		String loginCode = dto.getBody().getLoginCode();
		String corpOrgCode = dto.getBody().getInstu().getCode();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");// 设置日期格式
		String currDate = df.format(new Date());// new Date()为获取当前系统时间
		ResultDto<Integer> resultDto = null;
		int fincode = 0;
		int investcode = 0;
		int incomecode = 0;
		int famcode = 0;
		int asscode = 0;
		int liabicode = 0;
		int insurcode = 0;
		int paycode = 0;
		int opercode = 0;
		int farmercode = 0;
		String custId = "";
		if (c.get("custId") != null && !c.get("custId").equals("")) {
			custId = c.get("custId").toString();
		}
		// 财务
		String finString = "";
		OcrmFciPerFinanceInfo perfin = new OcrmFciPerFinanceInfo();
		if (c.get("financeformdata1") != null && !c.get("financeformdata1").equals("")) {
			finString = c.get("financeformdata1").toString();
			JSONObject finJson = JSONObject.fromObject(finString);
			perfin = (OcrmFciPerFinanceInfo) JSONObject.toBean(finJson, OcrmFciPerFinanceInfo.class);

		}
		// 投资
		String investString = "";
		OcrmFciPerInvInfo perinvest = new OcrmFciPerInvInfo();
		if (c.get("investformdata1") != null && !c.get("investformdata1").equals("")) {
			investString = c.get("investformdata1").toString();
			JSONObject investJson = JSONObject.fromObject(investString);
			perinvest = (OcrmFciPerInvInfo) JSONObject.toBean(investJson, OcrmFciPerInvInfo.class);

		}
		// 收入
		String incomString = "";
		OcrmFciPerIncomeInfo perincome = new OcrmFciPerIncomeInfo();
		if (c.get("incomeformdata1") != null && !c.get("incomeformdata1").equals("")) {
			incomString = c.get("incomeformdata1").toString();
			JSONObject incomeJson = JSONObject.fromObject(incomString);
			perincome = (OcrmFciPerIncomeInfo) JSONObject.toBean(incomeJson, OcrmFciPerIncomeInfo.class);

		}
		// 家庭收支
		String famString = "";
		OcrmFciPerFamiBalance perfam = new OcrmFciPerFamiBalance();
		if (c.get("famformdata1") != null && !c.get("famformdata1").equals("")) {
			famString = c.get("famformdata1").toString();
			JSONObject famJson = JSONObject.fromObject(famString);
			perfam = (OcrmFciPerFamiBalance) JSONObject.toBean(famJson, OcrmFciPerFamiBalance.class);

		}
		// 资产
		String assString = "";
		OcrmFciPerAssetInfo perass = new OcrmFciPerAssetInfo();
		if (c.get("assformdata1") != null && !c.get("assformdata1").equals("")) {
			assString = c.get("assformdata1").toString();
			JSONObject assJson = JSONObject.fromObject(assString);
			perass = (OcrmFciPerAssetInfo) JSONObject.toBean(assJson, OcrmFciPerAssetInfo.class);

		}
		// 负债
		String liaString = "";
		OcrmFciPerLiabInfo perlia = new OcrmFciPerLiabInfo();
		if (c.get("liabiformdata1") != null && !c.get("liabiformdata1").equals("")) {
			liaString = c.get("liabiformdata1").toString();
			JSONObject liaJson = JSONObject.fromObject(liaString);
			perlia = (OcrmFciPerLiabInfo) JSONObject.toBean(liaJson, OcrmFciPerLiabInfo.class);

		}
		// 保险
		String insurString = "";
		OcrmFciPerInsurInfo perinsur = new OcrmFciPerInsurInfo();
		if (c.get("insurformdata1") != null && !c.get("insurformdata1").equals("")) {
			insurString = c.get("insurformdata1").toString();
			JSONObject insurJson = JSONObject.fromObject(insurString);
			perinsur = (OcrmFciPerInsurInfo) JSONObject.toBean(insurJson, OcrmFciPerInsurInfo.class);

		}
		// 纳税
		String payString = "";
		OcrmFciPerTaxInfo perpay = new OcrmFciPerTaxInfo();
		if (c.get("payformdata1") != null && !c.get("payformdata1").equals("")) {
			payString = c.get("payformdata1").toString();
			JSONObject payJson = JSONObject.fromObject(payString);
			perpay = (OcrmFciPerTaxInfo) JSONObject.toBean(payJson, OcrmFciPerTaxInfo.class);

		}
		// 经营
		String operString = "";
		OcrmFciPerManageInfo peroper = new OcrmFciPerManageInfo();
		if (c.get("operformdata1") != null && !c.get("operformdata1").equals("")) {
			operString = c.get("operformdata1").toString();
			JSONObject operJson = JSONObject.fromObject(operString);
			peroper = (OcrmFciPerManageInfo) JSONObject.toBean(operJson, OcrmFciPerManageInfo.class);

		}
		// 农户
		String farmString = "";
		OcrmFciPerFarmerProd perfarm = new OcrmFciPerFarmerProd();
		if (c.get("farmerformdata1") != null && !c.get("farmerformdata1").equals("")) {
			farmString = c.get("farmerformdata1").toString();
			JSONObject farmJson = JSONObject.fromObject(farmString);
			perfarm = (OcrmFciPerFarmerProd) JSONObject.toBean(farmJson, OcrmFciPerFarmerProd.class);

		}
		Map finMap = (Map) c.get("finrefomodel");
		Map investMap = (Map) c.get("investrefmodel");
		Map incomeMap = (Map) c.get("incomerefmodel");
		Map famMap = (Map) c.get("famrefmodel");
		Map assMap = (Map) c.get("assrefmodel");
		Map liabiMap = (Map) c.get("liabirefmodel");
		Map insurMap = (Map) c.get("insurrefmodel");
		Map payMap = (Map) c.get("payrefmodel");
		Map operMap = (Map) c.get("operrefmodel");
		Map farmerMap = (Map) c.get("farmerrefmodel");

		if (finMap != null) {// 财务信息

			finMap.put("custId", custId);// 客户标识
			finMap.put("lastChgSys", "CRM");// 最新更新系统
			finMap.put("lastChgUsr", loginCode);// 最新更新人
			finMap.put("lastChgDt", currDate);// 最新更新时间
			// if(finMap.get("id") == null || finMap.get("id").equals("")) {
			// fincode=pCustFinaViewService.insertFinInfo(finMap);
			// } else {
			fincode = pCustFinaViewService.updatefinInfo(finMap);
			// }
		}

		if (investMap != null) {// 投资信息
			if (investMap.get("invDate") != null) {
				investMap.put("invDate", investMap.get("invDate").toString().replace("-", ""));
			}
			investMap.put("custId", custId);// 客户标识
			investMap.put("lastChgSys", "CRM");// 最新更新系统
			investMap.put("lastChgUsr", loginCode);// 最新更新人
			investMap.put("lastChgDt", currDate);// 最新更新时间
			investcode = pCustFinaViewService.updateInvestInfo(investMap);
		}
		if (incomeMap != null) {// 收入信息

			incomeMap.put("custId", custId);// 客户标识
			incomeMap.put("lastChgSys", "CRM");// 最新更新系统
			incomeMap.put("lastChgUsr", loginCode);// 最新更新人
			incomeMap.put("lastChgDt", currDate);// 最新更新时间
			incomecode = pCustFinaViewService.updateIncomeInfo(incomeMap);
		}
		if (famMap != null) {// 家庭收支

			famMap.put("custId", custId);// 客户标识
			famMap.put("lastChgSys", "CRM");// 最新更新系统
			famMap.put("lastChgUsr", loginCode);// 最新更新人
			famMap.put("lastChgDt", currDate);// 最新更新时间
			famcode = pCustFinaViewService.updateFamInfo(famMap);
		}
		if (assMap != null) {// 资产
			if (assMap.get("evalDate") != null) {
				assMap.put("evalDate", assMap.get("evalDate").toString().replace("-", ""));
			}
			if (assMap.get("assetPurDate") != null) {
				assMap.put("assetPurDate", assMap.get("assetPurDate").toString().replace("-", ""));
			}
			assMap.put("custId", custId);// 客户标识
			assMap.put("lastChgSys", "CRM");// 最新更新系统
			assMap.put("lastChgUsr", loginCode);// 最新更新人
			assMap.put("lastChgDt", currDate);// 最新更新时间
			asscode = pCustFinaViewService.updateAssInfo(assMap);
		}
		if (liabiMap != null) {// 负债信息
			if (liabiMap.get("liabStartDate") != null) {
				liabiMap.put("liabStartDate", liabiMap.get("liabStartDate").toString().replace("-", ""));
			}
			if (liabiMap.get("liabEndDate") != null) {
				liabiMap.put("liabEndDate", liabiMap.get("liabEndDate").toString().replace("-", ""));
			}
			liabiMap.put("custId", custId);// 客户标识
			liabiMap.put("lastChgSys", "CRM");// 最新更新系统
			liabiMap.put("lastChgUsr", loginCode);// 最新更新人
			liabiMap.put("lastChgDt", currDate);// 最新更新时间
			liabicode = pCustFinaViewService.updateLiabiInfo(liabiMap);
		}
		if (insurMap != null) {// 保险信息
			if (insurMap.get("insurStartDate") != null) {
				insurMap.put("insurStartDate", insurMap.get("insurStartDate").toString().replace("-", ""));
			}
			if (insurMap.get("insurEndDate") != null) {
				insurMap.put("insurEndDate", insurMap.get("insurEndDate").toString().replace("-", ""));
			}
			insurMap.put("custId", custId);// 客户标识
			insurMap.put("lastChgSys", "CRM");// 最新更新系统
			insurMap.put("lastChgUsr", loginCode);// 最新更新人
			insurMap.put("lastChgDt", currDate);// 最新更新时间
			insurcode = pCustFinaViewService.updateInsurInfo(insurMap);
		}
		if (payMap != null) {// 纳税信息
			if (payMap.get("taxDate") != null) {
				payMap.put("taxDate", payMap.get("taxDate").toString().replace("-", ""));
			}

			payMap.put("custId", custId);// 客户标识
			payMap.put("lastChgSys", "CRM");// 最新更新系统
			payMap.put("lastChgUsr", loginCode);// 最新更新人
			payMap.put("lastChgDt", currDate);// 最新更新时间
			paycode = pCustFinaViewService.updatePayInfo(payMap);
		}
		if (operMap != null) {// 经营信息
			if (operMap.get("openDate") != null) {
				operMap.put("openDate", operMap.get("openDate").toString().replace("-", ""));
			}

			operMap.put("custId", custId);// 客户标识
			operMap.put("lastChgSys", "CRM");// 最新更新系统
			operMap.put("lastChgUsr", loginCode);// 最新更新人
			operMap.put("lastChgDt", currDate);// 最新更新时间
			opercode = pCustFinaViewService.updateOperInfo(operMap);
		}
		if (farmerMap != null) {// 农户信息

			farmerMap.put("custId", custId);// 客户标识
			farmerMap.put("lastChgSys", "CRM");// 最新更新系统
			farmerMap.put("lastChgUsr", loginCode);// 最新更新人
			farmerMap.put("lastChgDt", currDate);// 最新更新时间
			farmercode = pCustFinaViewService.updateFarmerInfo(farmerMap);
		}
		if (fincode != 0 && investcode != 0 && incomecode != 0 && famcode != 0 && asscode != 0 && liabicode != 0
				&& insurcode != 0 && paycode != 0 && opercode != 0 && farmercode != 0) {// 判断表单数据是否全部提交
			resultDto = new ResultDto<Integer>();
			resultDto.setMessage("修改成功");
			resultDto.setCode(0);
		}

		return resultDto;
	}
}
