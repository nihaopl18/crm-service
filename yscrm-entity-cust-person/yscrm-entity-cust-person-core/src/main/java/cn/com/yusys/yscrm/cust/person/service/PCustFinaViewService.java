package cn.com.yusys.yscrm.cust.person.service;

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

import cn.com.yusys.yscrm.cust.person.repository.mapper.OcrmFciPerAssetInfoMapper;
import cn.com.yusys.yscrm.cust.person.repository.mapper.OcrmFciPerFamiBalanceMapper;
import cn.com.yusys.yscrm.cust.person.repository.mapper.OcrmFciPerFarmerProdMapper;
import cn.com.yusys.yscrm.cust.person.repository.mapper.OcrmFciPerFinanceInfoMapper;
import cn.com.yusys.yscrm.cust.person.repository.mapper.OcrmFciPerIncomeInfoMapper;
import cn.com.yusys.yscrm.cust.person.repository.mapper.OcrmFciPerInsurInfoMapper;
import cn.com.yusys.yscrm.cust.person.repository.mapper.OcrmFciPerInvInfoMapper;
import cn.com.yusys.yscrm.cust.person.repository.mapper.OcrmFciPerLiabInfoMapper;
import cn.com.yusys.yscrm.cust.person.repository.mapper.OcrmFciPerManageInfoMapper;
import cn.com.yusys.yscrm.cust.person.repository.mapper.OcrmFciPerTaxInfoMapper;
import cn.com.yusys.yscrm.cust.person.repository.mapper.PCustFinaViewMapper;
import cn.com.yusys.yusp.admin.web.rest.util.HeaderUtil;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.uaa.client.UaaClient;
import cn.com.yusys.yusp.uaa.client.dto.UserInfoDTO;

/**
 * @项目名称: yscrm-entity-cust-person-core模块
 * @类名称: OcrmFciPerFinanceInfoService
 * @类描述: #服务类
 * @功能描述:
 * @创建人: Administrator
 * @创建时间: 2019-02-14 10:48:13
 * @修改备注:
 * @修改记录: 修改时间 修改人员 修改原因
 *        -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class PCustFinaViewService extends CommonService {
	@Autowired
	private PCustFinaViewMapper pCustFinaViewMapper;

	@Autowired
	private OcrmFciPerFinanceInfoMapper ocrmFciPerFinanceInfoMapper;

	@Autowired
	private OcrmFciPerInvInfoMapper ocrmFciPerInvInfoMapper;

	@Autowired
	private OcrmFciPerIncomeInfoMapper ocrmFciPerIncomeInfoMapper;

	@Autowired
	private OcrmFciPerFamiBalanceMapper ocrmFciPerFamiBalanceMapper;

	@Autowired
	private OcrmFciPerAssetInfoMapper ocrmFciPerAssetInfoMapper;

	@Autowired
	private OcrmFciPerLiabInfoMapper ocrmFciPerLiabInfoMapper;

	@Autowired
	private OcrmFciPerInsurInfoMapper ocrmFciPerInsurInfoMapper;

	@Autowired
	private OcrmFciPerTaxInfoMapper ocrmFciPerTaxInfoMapper;

	@Autowired
	private OcrmFciPerManageInfoMapper ocrmFciPerManageInfoMapper;

	@Autowired
	private OcrmFciPerFarmerProdMapper ocrmFciPerFarmerProdMapper;

	@Autowired
	private UaaClient uaaClient;

	@Override
	protected CommonMapper<?> getMapper() {
		return this.pCustFinaViewMapper;
	}

	/**
	 * 财务信息
	 * 
	 * @param model
	 * @param custId
	 * @return
	 */
	// @Transactional(readOnly = true)
	// public List<Map<Object, String>> getFinList(QueryModel model, String custId)
	// {
	// Map<String, String> paramMap = new HashMap<String, String>();
	// paramMap.put("custId", custId);
	// // TODO 自动生成的方法存根
	// return pCustFinaViewMapper.getFinList(paramMap);
	// }

	/**
	 * 投资信息
	 * 
	 * @param model
	 * @param custId
	 * @return
	 */
	// @Transactional(readOnly = true)
	// public List<Map<Object, String>> getInvestList(QueryModel model, String
	// custId) {
	// Map<String, String> paramMap = new HashMap<String, String>();
	// paramMap.put("custId", custId);
	// // TODO 自动生成的方法存根
	// return pCustFinaViewMapper.getInvestList(paramMap);
	// }

	/**
	 * 收入信息
	 * 
	 * @param model
	 * @param custId
	 * @return
	 */
	// @Transactional(readOnly = true)
	// public List<Map<Object, String>> getIncomeList(QueryModel model, String
	// custId) {
	// Map<String, String> paramMap = new HashMap<String, String>();
	// paramMap.put("custId", custId);
	// // TODO 自动生成的方法存根
	// return pCustFinaViewMapper.getIncomeList(paramMap);
	// }

	/**
	 * 家庭收支信息
	 * 
	 * @param model
	 * @param custId
	 * @return
	 */
	// @Transactional(readOnly = true)
	// public List<Map<Object, String>> getFamilyincList(QueryModel model, String
	// custId) {
	// Map<String, String> paramMap = new HashMap<String, String>();
	// paramMap.put("custId", custId);
	// // TODO 自动生成的方法存根
	// return pCustFinaViewMapper.getFamilyincList(paramMap);
	// }

	/**
	 * 资产信息
	 * 
	 * @param model
	 * @param custId
	 * @return
	 */
	// @Transactional(readOnly = true)
	// public List<Map<Object, String>> getAssetsList(QueryModel model, String
	// custId) {
	// Map<String, String> paramMap = new HashMap<String, String>();
	// paramMap.put("custId", custId);
	// // TODO 自动生成的方法存根
	// return pCustFinaViewMapper.getAssetsList(paramMap);
	// }

	/**
	 * 负债信息
	 * 
	 * @param model
	 * @param custId
	 * @return
	 */
	@Transactional(readOnly = true)
	public List<Map<Object, String>> getLiabiList(QueryModel model, String custId) {
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("custId", custId);
		// TODO 自动生成的方法存根
		return pCustFinaViewMapper.getLiabiList(paramMap);
	}

	/**
	 * 保险信息
	 * 
	 * @param model
	 * @param custId
	 * @return
	 */
	@Transactional(readOnly = true)
	public List<Map<Object, String>> getInsurList(QueryModel model, String custId) {
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("custId", custId);
		// TODO 自动生成的方法存根
		return pCustFinaViewMapper.getInsurList(paramMap);
	}

	/**
	 * 纳税信息
	 * 
	 * @param model
	 * @param custId
	 * @return
	 */
	@Transactional(readOnly = true)
	public List<Map<Object, String>> getPayList(QueryModel model, String custId) {
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("custId", custId);
		// TODO 自动生成的方法存根
		return pCustFinaViewMapper.getPayList(paramMap);
	}

	/**
	 * 经营信息
	 * 
	 * @param model
	 * @param custId
	 * @return
	 */
	@Transactional(readOnly = true)
	public List<Map<Object, String>> getOperList(QueryModel model, String custId) {
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("custId", custId);
		// TODO 自动生成的方法存根
		return pCustFinaViewMapper.getOperList(paramMap);
	}

	/**
	 * 农户信息
	 * 
	 * @param model
	 * @param custId
	 * @return
	 */
	@Transactional(readOnly = true)
	public List<Map<Object, String>> getFarmerList(QueryModel model, String custId) {
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("custId", custId);
		// TODO 自动生成的方法存根
		return pCustFinaViewMapper.getFarmerList(paramMap);
	}

	/**
	 * 财务信息修改
	 * 
	 * @param model
	 * @param
	 * @return
	 */
	public int updatefinInfo(Map c) {

		return pCustFinaViewMapper.updatefinInfo(c);
	}

	/**
	 * 投资信息修改
	 * 
	 * @param model
	 * @param
	 * @return
	 */
	public int updateInvestInfo(Map c) {

		return pCustFinaViewMapper.updateInvestInfo(c);
	}

	/**
	 * 收入信息修改
	 * 
	 * @param model
	 * @param
	 * @return
	 */
	public int updateIncomeInfo(Map c) {

		return pCustFinaViewMapper.updateIncomeInfo(c);
	}

	/**
	 * 家庭收支信息信息修改
	 * 
	 * @param model
	 * @param
	 * @return
	 */
	public int updateFamInfo(Map c) {

		return pCustFinaViewMapper.updateFamInfo(c);
	}

	/**
	 * 资产信息修改
	 * 
	 * @param model
	 * @param
	 * @return
	 */
	public int updateAssInfo(Map c) {

		return pCustFinaViewMapper.updateAssInfo(c);
	}

	/**
	 * 负债信息修改
	 * 
	 * @param model
	 * @param
	 * @return
	 */
	public int updateLiabiInfo(Map c) {

		return pCustFinaViewMapper.updateLiabiInfo(c);
	}

	/**
	 * 保险信息修改
	 * 
	 * @param model
	 * @param
	 * @return
	 */
	public int updateInsurInfo(Map c) {

		return pCustFinaViewMapper.updateInsurInfo(c);
	}

	/**
	 * 纳税信息修改
	 * 
	 * @param model
	 * @param
	 * @return
	 */
	public int updatePayInfo(Map c) {

		return pCustFinaViewMapper.updatePayInfo(c);
	}

	/**
	 * 经营信息修改
	 * 
	 * @param model
	 * @param
	 * @return
	 */
	public int updateOperInfo(Map c) {

		return pCustFinaViewMapper.updateOperInfo(c);
	}

	/**
	 * 农户信息修改
	 * 
	 * @param model
	 * @param
	 * @return
	 */
	public int updateFarmerInfo(Map c) {

		return pCustFinaViewMapper.updateFarmerInfo(c);
	}

	// 获取id的下一个值
	public String getNextId() {
		return pCustFinaViewMapper.getNextId();
	}

	// 财务信息查询
	public List<Map<Object, String>> queryFin(String custId) {
		QueryModel queryModel = new QueryModel();
		PageHelper.startPage(queryModel.getPage(), queryModel.getSize());
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("custId", custId);
		return pCustFinaViewMapper.getFinList(paramMap);
	}

	// 财务信息新增修改方法
	public int updateFinance(Map map) {
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
			return this.insertSelective(ocrmFciPerFinanceInfoMapper, map);
		} else {
			map.put("lastChgUsr", loginCode);
			map.put("lastChgDt", new Date());
			map.remove("cratDt");
			return this.updateSelective(ocrmFciPerFinanceInfoMapper, map);
		}
	}

	// 财务信息删除
	public Integer delFinance(String id) {
		return this.deleteByIds(ocrmFciPerFinanceInfoMapper, id);
	}

	// 信贷客户投资信息查询
	public List<Map<Object, String>> getInvestList(String custId) {
		QueryModel queryModel = new QueryModel();
		PageHelper.startPage(queryModel.getPage(), queryModel.getSize());
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("custId", custId);
		return pCustFinaViewMapper.getInvestList(paramMap);
	}

	// 信贷客户投资信息新增修改方法
	public int updateInvest(Map map) {
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
			return this.insertSelective(ocrmFciPerInvInfoMapper, map);
		} else {
			map.put("lastChgUsr", loginCode);
			map.put("lastChgDt", new Date());
			map.remove("cratDt");
			return this.updateSelective(ocrmFciPerInvInfoMapper, map);
		}
	}

	// 信贷客户投资信息删除
	public Integer delInvest(String id) {
		return this.deleteByIds(ocrmFciPerInvInfoMapper, id);
	}

	// 收入信息查询
	public List<Map<Object, String>> getIncomeList(String custId) {
		QueryModel queryModel = new QueryModel();
		PageHelper.startPage(queryModel.getPage(), queryModel.getSize());
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("custId", custId);
		return pCustFinaViewMapper.getIncomeList(paramMap);
	}

	// 收入信息新增修改方法
	public int updateIncome(Map map) {
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
			return this.insertSelective(ocrmFciPerIncomeInfoMapper, map);
		} else {
			map.put("lastChgUsr", loginCode);
			map.put("lastChgDt", new Date());
			map.remove("cratDt");
			return this.updateSelective(ocrmFciPerIncomeInfoMapper, map);
		}
	}

	// 收入信息删除
	public Integer delIncome(String id) {
		return this.deleteByIds(ocrmFciPerIncomeInfoMapper, id);
	}

	// 家庭收支信息查询
	public List<Map<Object, String>> getFamilyincList(String custId) {
		QueryModel queryModel = new QueryModel();
		PageHelper.startPage(queryModel.getPage(), queryModel.getSize());
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("custId", custId);
		return pCustFinaViewMapper.getFamilyincList(paramMap);
	}

	// 家庭收支信息新增修改方法
	public int updateFamilyinc(Map map) {
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
			return this.insertSelective(ocrmFciPerFamiBalanceMapper, map);
		} else {
			map.put("lastChgUsr", loginCode);
			map.put("lastChgDt", new Date());
			map.remove("cratDt");
			return this.updateSelective(ocrmFciPerFamiBalanceMapper, map);
		}
	}

	// 家庭收支信息删除
	public Integer delFamilyinc(String id) {
		return this.deleteByIds(ocrmFciPerFamiBalanceMapper, id);
	}

	// 资产信息查询
	public List<Map<Object, String>> getAssetsList(String custId) {
		QueryModel queryModel = new QueryModel();
		PageHelper.startPage(queryModel.getPage(), queryModel.getSize());
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("custId", custId);
		return pCustFinaViewMapper.getAssetsList(paramMap);
	}

	// 资产信息新增修改方法
	public int updateAssets(Map map) {
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
			return this.insertSelective(ocrmFciPerAssetInfoMapper, map);
		} else {
			map.put("lastChgUsr", loginCode);
			map.put("lastChgDt", new Date());
			map.remove("cratDt");
			return this.updateSelective(ocrmFciPerAssetInfoMapper, map);
		}
	}

	// 资产信息删除
	public Integer delAssets(String id) {
		return this.deleteByIds(ocrmFciPerAssetInfoMapper, id);
	}

	// 负债信息查询
	public List<Map<Object, String>> getLiabiList(String custId) {
		QueryModel queryModel = new QueryModel();
		PageHelper.startPage(queryModel.getPage(), queryModel.getSize());
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("custId", custId);
		return pCustFinaViewMapper.getLiabiList(paramMap);
	}

	// 负债信息新增修改方法
	public int updateLiabi(Map map) {
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
			return this.insertSelective(ocrmFciPerLiabInfoMapper, map);
		} else {
			map.put("lastChgUsr", loginCode);
			map.put("lastChgDt", new Date());
			map.remove("cratDt");
			return this.updateSelective(ocrmFciPerLiabInfoMapper, map);
		}
	}

	// 负债信息删除
	public Integer delLiabi(String id) {
		return this.deleteByIds(ocrmFciPerLiabInfoMapper, id);
	}

	// 负债信息查询
	public List<Map<Object, String>> getInsurList(String custId) {
		QueryModel queryModel = new QueryModel();
		PageHelper.startPage(queryModel.getPage(), queryModel.getSize());
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("custId", custId);
		return pCustFinaViewMapper.getInsurList(paramMap);
	}

	// 负债信息新增修改方法
	public int updateInsur(Map map) {
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
			return this.insertSelective(ocrmFciPerInsurInfoMapper, map);
		} else {
			map.put("lastChgUsr", loginCode);
			map.put("lastChgDt", new Date());
			map.remove("cratDt");
			return this.updateSelective(ocrmFciPerInsurInfoMapper, map);
		}
	}

	// 负债信息删除
	public Integer delInsur(String id) {
		return this.deleteByIds(ocrmFciPerInsurInfoMapper, id);
	}

	// 纳税信息查询
	public List<Map<Object, String>> getPayList(String custId) {
		QueryModel queryModel = new QueryModel();
		PageHelper.startPage(queryModel.getPage(), queryModel.getSize());
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("custId", custId);
		return pCustFinaViewMapper.getPayList(paramMap);
	}

	// 纳税信息新增修改方法
	public int updatePay(Map map) {
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
			return this.insertSelective(ocrmFciPerTaxInfoMapper, map);
		} else {
			map.put("lastChgUsr", loginCode);
			map.put("lastChgDt", new Date());
			map.remove("cratDt");
			return this.updateSelective(ocrmFciPerTaxInfoMapper, map);
		}
	}

	// 纳税信息删除
	public Integer delPay(String id) {
		return this.deleteByIds(ocrmFciPerTaxInfoMapper, id);
	}

	// 经营信息查询
	public List<Map<Object, String>> getOperList(String custId) {
		QueryModel queryModel = new QueryModel();
		PageHelper.startPage(queryModel.getPage(), queryModel.getSize());
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("custId", custId);
		return pCustFinaViewMapper.getOperList(paramMap);
	}

	// 经营信息新增修改方法
	public int updateOper(Map map) {
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
			return this.insertSelective(ocrmFciPerManageInfoMapper, map);
		} else {
			map.put("lastChgUsr", loginCode);
			map.put("lastChgDt", new Date());
			map.remove("cratDt");
			return this.updateSelective(ocrmFciPerManageInfoMapper, map);
		}
	}

	// 经营信息删除
	public Integer delOper(String id) {
		return this.deleteByIds(ocrmFciPerManageInfoMapper, id);
	}

	// 经营信息查询
	public List<Map<Object, String>> getFarmerList(String custId) {
		QueryModel queryModel = new QueryModel();
		PageHelper.startPage(queryModel.getPage(), queryModel.getSize());
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("custId", custId);
		return pCustFinaViewMapper.getFarmerList(paramMap);
	}

	// 经营信息新增修改方法
	public int updateFarmer(Map map) {
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
			return this.insertSelective(ocrmFciPerFarmerProdMapper, map);
		} else {
			map.put("lastChgUsr", loginCode);
			map.put("lastChgDt", new Date());
			map.remove("cratDt");
			return this.updateSelective(ocrmFciPerFarmerProdMapper, map);
		}
	}

	// 经营信息删除
	public Integer delFarmer(String id) {
		return this.deleteByIds(ocrmFciPerFarmerProdMapper, id);
	}

}
