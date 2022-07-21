package cn.com.yusys.yscrm.cust.person.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;

import cn.com.yusys.yscrm.cust.person.domain.OcrmFciPerOthbankDep;
import cn.com.yusys.yscrm.cust.person.domain.OcrmFciPerOthbankLoan;
import cn.com.yusys.yscrm.cust.person.domain.OcrmFciPreOtherFin;
import cn.com.yusys.yscrm.cust.person.domain.OcrmFciPreOtherGuar;
import cn.com.yusys.yscrm.cust.person.repository.mapper.OcrmFciPerOthbankDepMapper;
import cn.com.yusys.yscrm.cust.person.repository.mapper.OcrmFciPerOthbankLoanMapper;
import cn.com.yusys.yscrm.cust.person.repository.mapper.OcrmFciPreOtherFinMapper;
import cn.com.yusys.yscrm.cust.person.repository.mapper.OcrmFciPreOtherGuarMapper;
import cn.com.yusys.yscrm.cust.person.repository.mapper.PCustOtBankViewMapper;
import cn.com.yusys.yusp.admin.web.rest.util.HeaderUtil;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.uaa.client.UaaClient;
import cn.com.yusys.yusp.uaa.client.dto.UserInfoDTO;

/**
 * @项目名称: yscrm-entity-cust-person-core模块
 * @类名称: OcrmFciPerOthbankDepService
 * @类描述: #服务类
 * @功能描述:
 * @创建人: Administrator
 * @创建时间: 2019-02-15 11:01:19
 * @修改备注:
 * @修改记录: 修改时间 修改人员 修改原因
 *        -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class PCustOtBankViewService extends CommonService {
	@Autowired
	private PCustOtBankViewMapper pCustOtBankViewMapper;
	@Autowired
	private UaaClient uaaClient;

	@Autowired
	private OcrmFciPerOthbankDepService ocrmFciPerOthbankDepService;

	@Autowired
	private OcrmFciPerOthbankLoanService ocrmFciPerOthbankLoanService;

	@Autowired
	private OcrmFciPreOtherFinService ocrmFciPreOtherFinService;

	@Autowired
	private OcrmFciPreOtherGuarService ocrmFciPreOtherGuarService;

	@Autowired
	private OcrmFciPerOthbankDepMapper ocrmFciPerOthbankDepMapper;

	@Autowired
	private OcrmFciPerOthbankLoanMapper ocrmFciPerOthbankLoanMapper;
	
	@Autowired
	private OcrmFciPreOtherGuarMapper ocrmFciPreOtherGuarMapper;
	
	@Autowired
	private OcrmFciPreOtherFinMapper ocrmFciPreOtherFinMapper;

	@Override
	protected CommonMapper<?> getMapper() {
		return this.pCustOtBankViewMapper;
	}

	/**
	 * 存款信息
	 * 
	 * @param model
	 * @param custId
	 * @return
	 */
	@Transactional(readOnly = true)
	public List<Map<Object, String>> getDepList(QueryModel model, String custId) {
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("custId", custId);
		// TODO 自动生成的方法存根
		return pCustOtBankViewMapper.getDepList(paramMap);
	}

	/**
	 * 贷款信息
	 * 
	 * @param model
	 * @param custId
	 * @return
	 */
	@Transactional(readOnly = true)
	public List<Map<Object, String>> getLoanList(QueryModel model, String custId) {
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("custId", custId);
		// TODO 自动生成的方法存根
		return pCustOtBankViewMapper.getLoanList(paramMap);
	}

	/**
	 * 理财信息
	 * 
	 * @param model
	 * @param custId
	 * @return
	 */
	@Transactional(readOnly = true)
	public List<Map<Object, String>> getFinList(QueryModel model, String custId) {
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("custId", custId);
		// TODO 自动生成的方法存根
		return pCustOtBankViewMapper.getFinList(paramMap);
	}

	/**
	 * 担保信息
	 * 
	 * @param model
	 * @param custId
	 * @return
	 */
	@Transactional(readOnly = true)
	public List<Map<Object, String>> getGuarList(QueryModel model, String custId) {
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("custId", custId);
		// TODO 自动生成的方法存根
		return pCustOtBankViewMapper.getGuarList(paramMap);
	}

	/**
	 * 新增修改存款，贷款，理财，担保信息
	 * 
	 * @param c
	 * @return
	 */
	@Transactional
	public int uodateInfo(OcrmFciPerOthbankDep ocrmFciPerOthbankDep, OcrmFciPerOthbankLoan ocrmFciPerOthbankLoan,
			OcrmFciPreOtherFin ocrmFciPreOtherFin, OcrmFciPreOtherGuar ocrmFciPreOtherGuar, String custId) {
		ResponseEntity<UserInfoDTO> dto = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());
		String orgCode = dto.getBody().getOrg().getCode();
		String loginCode = dto.getBody().getLoginCode();
		String corpOrgCode = dto.getBody().getInstu().getCode();
		int returnstr = 0;
		int depcode = 0;
		int loancode = 0;
		int fincode = 0;
		int guarcode = 0;
		QueryModel model = new QueryModel();
		List<Map<Object, String>> depInfo = this.getDepList(model, custId);// 存款信息
		if (depInfo.size() != 0) {
			if (ocrmFciPerOthbankDep.getTdepDueDt() != null && !ocrmFciPerOthbankDep.getTdepDueDt().equals("")) {
				ocrmFciPerOthbankDep.setTdepDueDt(ocrmFciPerOthbankDep.getTdepDueDt());
			}
			ocrmFciPerOthbankDep.setLastChgDt(new Date());
			ocrmFciPerOthbankDep.setLastChgSys("CRM");
			ocrmFciPerOthbankDep.setLastChgUsr(loginCode);
			ocrmFciPerOthbankDep.setCorpOrgCode(corpOrgCode);
			depcode = ocrmFciPerOthbankDepService.updatedepInfo(ocrmFciPerOthbankDep);
		} else {
			if (ocrmFciPerOthbankDep.getTdepDueDt() != null && !ocrmFciPerOthbankDep.getTdepDueDt().equals("")) {
				ocrmFciPerOthbankDep.setTdepDueDt(ocrmFciPerOthbankDep.getTdepDueDt());
			}
			ocrmFciPerOthbankDep.setCratDt(new Date());
			ocrmFciPerOthbankDep.setCratOrgId(orgCode);
			ocrmFciPerOthbankDep.setCratUsr(loginCode);
			ocrmFciPerOthbankDep.setLastChgDt(new Date());
			ocrmFciPerOthbankDep.setLastChgSys("CRM");
			ocrmFciPerOthbankDep.setLastChgUsr(loginCode);
			ocrmFciPerOthbankDep.setCorpOrgCode(corpOrgCode);
			depcode = ocrmFciPerOthbankDepService.insertdepInfo(ocrmFciPerOthbankDep);
		}
		List<Map<Object, String>> loanInfo = this.getLoanList(model, custId);// 贷款信息
		if (loanInfo.size() != 0) {
			if (ocrmFciPerOthbankLoan.getStartDate() != null && !ocrmFciPerOthbankLoan.getStartDate().equals("")) {
				ocrmFciPerOthbankLoan.setStartDate(ocrmFciPerOthbankLoan.getStartDate().replace("-", ""));
			}
			if (ocrmFciPerOthbankLoan.getEndDate() != null && !ocrmFciPerOthbankLoan.getEndDate().equals("")) {
				ocrmFciPerOthbankLoan.setEndDate(ocrmFciPerOthbankLoan.getEndDate().replace("-", ""));
			}
			ocrmFciPerOthbankLoan.setLastChgDt(new Date());
			ocrmFciPerOthbankLoan.setLastChgSys("CRM");
			ocrmFciPerOthbankLoan.setLastChgUsr(loginCode);
			ocrmFciPerOthbankLoan.setCorpOrgCode(corpOrgCode);
			loancode = ocrmFciPerOthbankLoanService.updateloanInfo(ocrmFciPerOthbankLoan);
		} else {
			if (ocrmFciPerOthbankLoan.getStartDate() != null && !ocrmFciPerOthbankLoan.getStartDate().equals("")) {
				ocrmFciPerOthbankLoan.setStartDate(ocrmFciPerOthbankLoan.getStartDate().replace("-", ""));
			}
			if (ocrmFciPerOthbankLoan.getEndDate() != null && !ocrmFciPerOthbankLoan.getEndDate().equals("")) {
				ocrmFciPerOthbankLoan.setEndDate(ocrmFciPerOthbankLoan.getEndDate().replace("-", ""));
			}
			ocrmFciPerOthbankLoan.setCratDt(new Date());
			ocrmFciPerOthbankLoan.setCratOrgId(orgCode);
			ocrmFciPerOthbankLoan.setCratUsr(loginCode);
			ocrmFciPerOthbankLoan.setLastChgDt(new Date());
			ocrmFciPerOthbankLoan.setLastChgSys("CRM");
			ocrmFciPerOthbankLoan.setLastChgUsr(loginCode);
			ocrmFciPerOthbankLoan.setCorpOrgCode(corpOrgCode);
			loancode = ocrmFciPerOthbankLoanService.insertloanInfo(ocrmFciPerOthbankLoan);
		}
		List<Map<Object, String>> finInfo = this.getFinList(model, custId);// 理财信息
		if (finInfo.size() != 0) {
			ocrmFciPreOtherFin.setLastChgDt(new Date());

			ocrmFciPreOtherFin.setLastChgUsr(loginCode);
			ocrmFciPreOtherFin.setCorpOrgCode(corpOrgCode);
			fincode = ocrmFciPreOtherFinService.updatefinInfo(ocrmFciPreOtherFin);
		} else {

			ocrmFciPreOtherFin.setLastChgDt(new Date());

			ocrmFciPreOtherFin.setLastChgUsr(loginCode);
			ocrmFciPreOtherFin.setCorpOrgCode(corpOrgCode);
			fincode = ocrmFciPreOtherFinService.insertfinInfo(ocrmFciPreOtherFin);
		}
		List<Map<Object, String>> guarInfo = this.getGuarList(model, custId);// 担保信息
		if (guarInfo.size() != 0) {
			ocrmFciPreOtherGuar.setLastChgDt(new Date());

			ocrmFciPreOtherGuar.setLastChgUsr(loginCode);
			ocrmFciPreOtherGuar.setCorpOrgCode(corpOrgCode);
			guarcode = ocrmFciPreOtherGuarService.updateguarInfo(ocrmFciPreOtherGuar);
		} else {

			ocrmFciPreOtherGuar.setLastChgDt(new Date());

			ocrmFciPreOtherGuar.setLastChgUsr(loginCode);
			ocrmFciPreOtherGuar.setCorpOrgCode(corpOrgCode);
			guarcode = ocrmFciPreOtherGuarService.insertguarInfo(ocrmFciPreOtherGuar);
		}
		if (depcode != 0 && loancode != 0 && fincode != 0 && guarcode != 0) {
			returnstr = 1;
		} else {
			returnstr = 0;
		}
		return returnstr;
	}

	// 存款信息信息查询
	public List<Map<Object, String>> getPedList(String custId) {
		QueryModel queryModel = new QueryModel();
		PageHelper.startPage(queryModel.getPage(), queryModel.getSize());
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("custId", custId);
		return pCustOtBankViewMapper.getDepList(paramMap);
	}

	// 存款信息新增修改方法
	public int updateDep(Map map) {
		ResponseEntity<UserInfoDTO> dto = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());
		String loginCode = dto.getBody().getLoginCode(); // 获取当前登录人登陆Code
		String corpOrgCode = dto.getBody().getOrg().getCode(); // 获取当前登录人所属机构
		if (map.get("id") == null || map.get("id").equals("")) {
			String id = UUID.randomUUID().toString().toLowerCase().replace("-", "");
			map.put("id", id);
			map.put("cratDt", new Date());
			map.put("cratOrgId", corpOrgCode);
			map.put("cratUsr", loginCode);
			map.put("lastChgSys", "CRM");
			map.put("lastChgUsr", loginCode);
			map.put("lastChgDt", new Date());
			return this.insertSelective(ocrmFciPerOthbankDepMapper, map);
		} else {
			map.put("lastChgUsr", loginCode);
			map.put("lastChgDt", new Date());
			map.remove("cratDt");
			return this.updateSelective(ocrmFciPerOthbankDepMapper, map);
		}
	}

	// 存款信息删除
	public Integer delDep(String id) {
		return this.deleteByIds(ocrmFciPerOthbankDepMapper, id);
	}

	// 贷款信息查询
	public List<Map<Object, String>> getLoanList(String custId) {
		QueryModel queryModel = new QueryModel();
		PageHelper.startPage(queryModel.getPage(), queryModel.getSize());
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("custId", custId);
		return pCustOtBankViewMapper.getLoanList(paramMap);
	}

	// 贷款信息新增修改方法
	public int updateLoan(Map map) {
		ResponseEntity<UserInfoDTO> dto = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());
		String loginCode = dto.getBody().getLoginCode(); // 获取当前登录人登陆Code
		String corpOrgCode = dto.getBody().getOrg().getCode(); // 获取当前登录人所属机构
		if (map.get("id") == null || map.get("id").equals("")) {
			String id = UUID.randomUUID().toString().toLowerCase().replace("-", "");
			map.put("id", id);
			map.put("cratDt", new Date());
			map.put("cratOrgId", corpOrgCode);
			map.put("cratUsr", loginCode);
			map.put("lastChgSys", "CRM");
			map.put("lastChgUsr", loginCode);
			map.put("lastChgDt", new Date());
			return this.insertSelective(ocrmFciPerOthbankLoanMapper, map);
		} else {
			map.put("lastChgUsr", loginCode);
			map.put("lastChgDt", new Date());
			map.remove("cratDt");
			return this.updateSelective(ocrmFciPerOthbankLoanMapper, map);
		}
	}

	// 贷款信息删除
	public Integer delLoan(String id) {
		return this.deleteByIds(ocrmFciPerOthbankLoanMapper, id);
	}

	// 他行理财查询
	public List<Map<Object, String>> getFinaList(String custId) {
		QueryModel queryModel = new QueryModel();
		PageHelper.startPage(queryModel.getPage(), queryModel.getSize());
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("custId", custId);
		return pCustOtBankViewMapper.getFinList(paramMap);
	}

	// 他行理财新增修改方法
	public int updateFina(Map map) throws ParseException {
		ResponseEntity<UserInfoDTO> dto = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());
		String loginCode = dto.getBody().getLoginCode(); // 获取当前登录人登陆Code
		String corpOrgCode = dto.getBody().getOrg().getCode(); // 获取当前登录人所属机构
		if (map.get("id") == null || map.get("id").equals("")) {
			String id = UUID.randomUUID().toString().toLowerCase().replace("-", "");
			map.put("id", id);
			map.put("cratDt", new Date());
			map.put("cratOrgId", corpOrgCode);
			map.put("cratUsr", loginCode);
			map.put("lastChgSys", "CRM");
			map.put("lastChgUsr", loginCode);
			map.put("lastChgDt", new Date());
			/*SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
			if(map.get("purDate").toString()!=null) {
				map.put("purDate", sim.parse(map.get("purDate").toString()));
			}
			if(map.get("expDate").toString()!=null) {
				map.put("expDate", sim.parse(map.get("expDate").toString()));
			}*/
			return this.insertSelective(ocrmFciPreOtherFinMapper, map);
		} else {
			map.put("lastChgUsr", loginCode);
			map.put("lastChgDt", new Date());
//			SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
//			if(map.get("purDate").toString()!=null) {
//				map.put("purDate", sim.parse(map.get("purDate").toString()));
//			}
//			if(map.get("expDate").toString()!=null) {
//				map.put("expDate", sim.parse(map.get("expDate").toString()));
//			}
			map.remove("cratDt");
			return this.updateSelective(ocrmFciPreOtherFinMapper, map);
		}
	}

	// 他行理财删除
	public Integer delFina(String id) {
		return this.deleteByIds(ocrmFciPreOtherFinMapper, id);
	}

	// 他行担保查询
	public List<Map<Object, String>> getGuarList(String custId) {
		QueryModel queryModel = new QueryModel();
		PageHelper.startPage(queryModel.getPage(), queryModel.getSize());
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("custId", custId);
		return pCustOtBankViewMapper.getGuarList(paramMap);
	}

	// 他行担保新增修改方法
	public int updateGuar(Map map) throws ParseException {
		ResponseEntity<UserInfoDTO> dto = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());
		String loginCode = dto.getBody().getLoginCode(); // 获取当前登录人登陆Code
		String corpOrgCode = dto.getBody().getOrg().getCode(); // 获取当前登录人所属机构
		if (map.get("id") == null || map.get("id").equals("")) {
			String id = UUID.randomUUID().toString().toLowerCase().replace("-", "");
			map.put("id", id);
			map.put("cratDt", new Date());
			map.put("cratOrgId", corpOrgCode);
			map.put("cratUsr", loginCode);
			map.put("lastChgSys", "CRM");
			map.put("lastChgUsr", loginCode);
			map.put("lastChgDt", new Date());
//			SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
//			if(map.get("startDate").toString()!=null) {
//				map.put("startDate", sim.parse(map.get("startDate").toString()));
//			}
//			if(map.get("expDate").toString()!=null) {
//				map.put("expDate", sim.parse(map.get("expDate").toString()));
//			}
			return this.insertSelective(ocrmFciPreOtherGuarMapper, map);
		} else {
			map.put("lastChgUsr", loginCode);
			map.put("lastChgDt", new Date());
			/*SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
			if(map.get("startDate").toString()!=null) {
				map.put("startDate", sim.parse(map.get("startDate").toString()));
			}
			if(map.get("expDate").toString()!=null) {
				map.put("expDate", sim.parse(map.get("expDate").toString()));
			}*/
			map.remove("cratDt");
			return this.updateSelective(ocrmFciPreOtherGuarMapper, map);
		}
	}

	// 他行担保删除
	public Integer delGuar(String id) {
		return this.deleteByIds(ocrmFciPreOtherGuarMapper, id);
	}
}
