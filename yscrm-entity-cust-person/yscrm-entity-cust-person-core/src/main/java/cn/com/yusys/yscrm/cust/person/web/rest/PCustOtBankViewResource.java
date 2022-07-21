package cn.com.yusys.yscrm.cust.person.web.rest;

import java.math.BigDecimal;
import java.text.ParseException;
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

import cn.com.yusys.yscrm.cust.person.domain.OcrmFciPerFinanceInfo;
import cn.com.yusys.yscrm.cust.person.domain.OcrmFciPerOthbankDep;
import cn.com.yusys.yscrm.cust.person.domain.OcrmFciPerOthbankLoan;
import cn.com.yusys.yscrm.cust.person.domain.OcrmFciPreOtherFin;
import cn.com.yusys.yscrm.cust.person.domain.OcrmFciPreOtherGuar;
import cn.com.yusys.yscrm.cust.person.service.PCustOtBankViewService;
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
 * @类名称: OcrmFciPerOthbankDepResource
 * @类描述: #资源类
 * @功能描述:
 * @创建人: Administrator
 * @创建时间: 2019-02-15 11:01:19
 * @修改备注:
 * @修改记录: 修改时间 修改人员 修改原因
 *        -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/pcustotbankview")
public class PCustOtBankViewResource extends CommonResource<OcrmFciPerOthbankDep, String> {
	@Autowired
	private PCustOtBankViewService pCustOtBankViewService;
	@Autowired
	private UaaClient uaaClient;

	@Override
	protected CommonService getCommonService() {
		return this.pCustOtBankViewService;
	}

	/**
	 * 他行信息查询
	 * 
	 * @param model
	 * @param custId
	 * @return
	 */
	@GetMapping("/queryotherbanklist/{custId}")
	public ResultDto<Map<String, List<Map<Object, String>>>> queryOtherBankList(QueryModel model,
			@PathVariable String custId) {
		List<Map<Object, String>> depInfo = pCustOtBankViewService.getDepList(model, custId);// 存款信息
		List<Map<Object, String>> loanInfo = pCustOtBankViewService.getLoanList(model, custId);// 贷款信息
		List<Map<Object, String>> finInfo = pCustOtBankViewService.getFinList(model, custId);// 理财信息
		List<Map<Object, String>> guarInfo = pCustOtBankViewService.getGuarList(model, custId);// 担保信息

		Map<String, List<Map<Object, String>>> allInfo = new HashMap<String, List<Map<Object, String>>>();
		allInfo.put("depInfo", depInfo);
		allInfo.put("loanInfo", loanInfo);
		allInfo.put("finInfo", finInfo);
		allInfo.put("guarInfo", guarInfo);

		ResultDto<Map<String, List<Map<Object, String>>>> resultDto = new ResultDto<Map<String, List<Map<Object, String>>>>();
		resultDto.setData(allInfo);

		return resultDto;
	}

	/**
	 * 财务信息修改
	 * 
	 * @param model
	 * @param custId
	 * @return
	 */
	@PostMapping("/updateotherbank")
	public ResultDto<Integer> updateOtherBank(@RequestBody Map c) {
		ResponseEntity<UserInfoDTO> dto = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());

		ResultDto<Integer> resultDto = null;
		int code = 0;

		String custId = "";
		if (c.get("custId") != null && !c.get("custId").equals("")) {
			custId = c.get("custId").toString();
		}
		// 存款
		String depString = "";
		OcrmFciPerOthbankDep perdep = new OcrmFciPerOthbankDep();
		if (c.get("depmodel") != null && !c.get("depmodel").equals("")) {
			depString = c.get("depmodel").toString();
			JSONObject depJson = JSONObject.fromObject(depString);
			perdep = (OcrmFciPerOthbankDep) JSONObject.toBean(depJson, OcrmFciPerOthbankDep.class);
			perdep.setCustId(custId);
		}

		// 贷款
		String loanString = "";
		OcrmFciPerOthbankLoan perloan = new OcrmFciPerOthbankLoan();
		if (c.get("loanmodel") != null && !c.get("loanmodel").equals("")) {
			loanString = c.get("loanmodel").toString();
			JSONObject loanJson = JSONObject.fromObject(loanString);
			perloan = (OcrmFciPerOthbankLoan) JSONObject.toBean(loanJson, OcrmFciPerOthbankLoan.class);
			perloan.setCustId(custId);
		}

		// 理财
		String finString = "";
		OcrmFciPreOtherFin perfin = new OcrmFciPreOtherFin();
		if (c.get("finmodel") != null && !c.get("finmodel").equals("")) {
			finString = c.get("finmodel").toString();
			JSONObject finJson = JSONObject.fromObject(finString);
			perfin = (OcrmFciPreOtherFin) JSONObject.toBean(finJson, OcrmFciPreOtherFin.class);
			perfin.setCustId(custId);
		}

		// 担保
		String guarString = "";
		OcrmFciPreOtherGuar perguar = new OcrmFciPreOtherGuar();
		if (c.get("guarmodel") != null && !c.get("guarmodel").equals("")) {
			guarString = c.get("guarmodel").toString();
			JSONObject guarJson = JSONObject.fromObject(guarString);
			perguar = (OcrmFciPreOtherGuar) JSONObject.toBean(guarJson, OcrmFciPreOtherGuar.class);
			perguar.setCustId(custId);
		}
		code = pCustOtBankViewService.uodateInfo(perdep, perloan, perfin, perguar, custId);
		if (code != 0) {// 判断表单数据是否全部提交
			resultDto = new ResultDto<Integer>();
			resultDto.setMessage("操作成功");
			resultDto.setCode(0);
		}
		return resultDto;
	}

	// 存款信息查询
	@GetMapping("/getpedlist/{custId}")
	public ResultDto<List<Map<Object, String>>> getPedList(QueryModel model, @PathVariable String custId) {
		return new ResultDto<List<Map<Object, String>>>(pCustOtBankViewService.getPedList(custId));
	}

	// 存款信息新增修改方法
	@PostMapping("/updatedep/{custId}")
	public ResultDto<Integer> updateDep(@RequestBody Map c, @PathVariable String custId) {
		Map map = (Map) c.get("depmodel");
		map.put("custId", custId);
		return new ResultDto<Integer>(pCustOtBankViewService.updateDep(map));
	}

	// 存款信息删除方法
	@PostMapping("/deldep")
	public ResultDto<Integer> delDep(@RequestBody Map c) {
		String id = (String) c.get("id");
		return new ResultDto<Integer>(pCustOtBankViewService.delDep(id));
	}

	// 贷款信息查询
	@GetMapping("/getloanlist/{custId}")
	public ResultDto<List<Map<Object, String>>> getLoanList(QueryModel model, @PathVariable String custId) {
		return new ResultDto<List<Map<Object, String>>>(pCustOtBankViewService.getLoanList(custId));
	}

	// 贷款信息新增修改方法
	@PostMapping("/updateloan/{custId}")
	public ResultDto<Integer> updateLoan(@RequestBody Map c, @PathVariable String custId) {
		Map map = (Map) c.get("loanmodel");
		map.put("custId", custId);
		return new ResultDto<Integer>(pCustOtBankViewService.updateLoan(map));
	}

	// 贷款信息删除方法
	@PostMapping("/delloan")
	public ResultDto<Integer> delLoan(@RequestBody Map c) {
		String id = (String) c.get("id");
		return new ResultDto<Integer>(pCustOtBankViewService.delLoan(id));
	}

	// 他行理财查询
	@GetMapping("/getfinalist/{custId}")
	public ResultDto<List<Map<Object, String>>> getFinaList(QueryModel model, @PathVariable String custId) {
		return new ResultDto<List<Map<Object, String>>>(pCustOtBankViewService.getFinaList(custId));
	}

	// 他行理财新增修改方法
	@PostMapping("/updatefina/{custId}")
	public ResultDto<Integer> updateFina(@RequestBody Map c, @PathVariable String custId) {
		Map map = (Map) c.get("finamodel");
		map.put("custId", custId);
		try {
			return new ResultDto<Integer>(pCustOtBankViewService.updateFina(map));
		} catch (ParseException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return null;
		}
	}

	// 他行理财删除方法
	@PostMapping("/delfina")
	public ResultDto<Integer> delFina(@RequestBody Map c) {
		String id = (String) c.get("id");
		return new ResultDto<Integer>(pCustOtBankViewService.delFina(id));
	}

	// 他行担保查询
	@GetMapping("/getguarlist/{custId}")
	public ResultDto<List<Map<Object, String>>> getGuarList(QueryModel model, @PathVariable String custId) {
		return new ResultDto<List<Map<Object, String>>>(pCustOtBankViewService.getGuarList(custId));
	}

	// 他行担保新增修改方法
	@PostMapping("/updateguar/{custId}")
	public ResultDto<Integer> updateGuar(@RequestBody Map c, @PathVariable String custId) {
		Map map = (Map) c.get("guarmodel");
		map.put("custId", custId);
		try {
			return new ResultDto<Integer>(pCustOtBankViewService.updateGuar(map));
		} catch (ParseException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return null;
		}
	}

	// 他行担保删除方法
	@PostMapping("/delguar")
	public ResultDto<Integer> delGuar(@RequestBody Map c) {
		String id = (String) c.get("id");
		return new ResultDto<Integer>(pCustOtBankViewService.delGuar(id));
	}
}
