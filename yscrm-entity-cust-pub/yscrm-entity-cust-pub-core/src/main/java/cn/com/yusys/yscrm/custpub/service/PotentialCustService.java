package cn.com.yusys.yscrm.custpub.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;

import cn.com.yusys.yscrm.custpub.domain.AcrmFciAddrInfo;
import cn.com.yusys.yscrm.custpub.domain.AcrmFciContactInfo;
import cn.com.yusys.yscrm.custpub.domain.AcrmFciCustAdmitAll;
import cn.com.yusys.yscrm.custpub.domain.AcrmFciCustAll;
import cn.com.yusys.yscrm.custpub.domain.AcrmFciCustIdentInfo;
import cn.com.yusys.yscrm.custpub.domain.AcrmFciOrgCustInfo;
import cn.com.yusys.yscrm.custpub.domain.AcrmFciOrgKeyMan;
import cn.com.yusys.yscrm.custpub.domain.AcrmFciPerAdmitInfo;
import cn.com.yusys.yscrm.custpub.domain.AcrmFciPerCust;
import cn.com.yusys.yscrm.custpub.domain.PotenCustOrg;
import cn.com.yusys.yscrm.custpub.domain.PotenCustPer;
import cn.com.yusys.yscrm.custpub.repository.mapper.PotenCustPerMapper;
import cn.com.yusys.yscrm.custpub.repository.mapper.PotentialCustMapper;
import cn.com.yusys.yusp.admin.web.rest.util.HeaderUtil;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.uaa.client.UaaClient;
import cn.com.yusys.yusp.uaa.client.dto.UserInfoDTO;
import cn.com.yusys.yusp.util.UtilTools;

/**
 * @项目名称: yscrm-entity-cust-pub-core模块
 * @类名称: AcrmFciPerAdmitInfoService
 * @类描述: #服务类
 * @功能描述:
 * @创建人: hyx
 * @创建时间: 2019-01-31 16:45:04
 * @修改备注:
 * @修改记录: 修改时间 修改人员 修改原因
 *        -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class PotentialCustService extends CommonService {

	@Autowired
	private PotentialCustMapper potentialCustMapper;
	/*
	 * 准入客户全量服务
	 */
	@Autowired
	private AcrmFciCustAdmitAllService acrmFciCustAdmitAllService;
	/*
	 * 对公客户（准入，非准入）服务
	 */
	@Autowired
	private AcrmFciOrgCustInfoService acrmFciOrgCustInfoService;
	/*
	 * 准入个人服务
	 */
	@Autowired
	private AcrmFciPerAdmitInfoService acrmFciPerAdmitInfoService;
	/*
	 * 个人服务
	 */
	@Autowired
	private AcrmFciPerCustService acrmFciPerCustService;
	/*
	 * 客户全量服务
	 */
	@Autowired
	private AcrmFciCustAllService acrmFciCustAllService;
	/*
	 * 准入客户归属
	 */
	@Autowired
	private OcrmFciAdmitBelongService ocrmFciAdmitBelongService;

	/*
	 * 客户证件信息
	 */
	@Autowired
	private AcrmFciCustIdentInfoService acrmFciCustIdentInfoService;

	/*
	 * 客户地址信息
	 */
	@Autowired
	private AcrmFciAddrInfoService acrmFciAddrInfoService;

	/*
	 * 客户联系信息
	 */
	@Autowired
	private AcrmFciContactInfoService acrmFciContactInfoService;

	/*
	 * 对公关键人
	 */
	@Autowired
	private AcrmFciOrgKeyManService acrmFciOrgKeyManService;
	/*
	 * 潜在个人客户
	 */
	@Autowired
	private PotenCustPerService potenCustPerService;
	/*
	 * 潜在对公客户
	 */
	@Autowired
	private PotenCustOrgService potenCustOrgService;

	@Autowired
	private UaaClient uaaClient;

	@Override
	protected CommonMapper<?> getMapper() {
		return this.potentialCustMapper;
	}

	/*
	 * 获取当前用户信息userInfoDto
	 */
	public UserInfoDTO getUser() {
		ResponseEntity<UserInfoDTO> dto = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());
		return dto.getBody();
	}

	/*
	 * 客户名称，证件类型，证件号判断是否存在该客户
	 */
	@Transactional(readOnly = true)
	public Map<String, String> custExist(Map<String, String> map) {
		// TODO 自动生成的方法存根
		return potentialCustMapper.custExist(map);
	}

	@Transactional(readOnly = true)
	public List<Map<String, String>> getListByModel(QueryModel model) {
		// TODO 自动生成的方法存根
		PageHelper.startPage(model.getPage(), model.getSize());
		List<Map<String, String>> list = null;
		if (model.getCondition().get("custType") == null) {
			return null;
		} else if (model.getCondition().get("custType").equals("1")) {
			list = potentialCustMapper.getListByModelPer(model);
		} else if (model.getCondition().get("custType").equals("2")) {
			list = potentialCustMapper.getListByModelOrg(model);
		}
		PageHelper.clearPage();
		return list;
	}

	@Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
	public int addOrg(Map<String, String> map) {
		// TODO 自动生成的方法存根
		int num = 0;
		Map<String, String> custAll = new HashMap<>();
		custAll.put("custName", map.get("custName"));
		custAll.put("certType", map.get("certType"));
		custAll.put("certNo", map.get("certNo"));
		if (potentialCustMapper.checkIsCust(custAll) == 0) {
			UserInfoDTO user = getUser();
			Date date = new Date();
			String lastUpdateUser = user.getUserId();
			String lastUpdateOrg = user.getOrg().getCode();
			String custId = potentialCustMapper.getSeq();
			/*
			 * 获取客户来源渠道，保存在最新更新系统字段
			 */
			String sourceChannel = map.get("sourceChannel");
			/*
			 * 准入对公客户信息 ACRM_F_CI_ORG_CUST_INFO
			 */
			AcrmFciOrgCustInfo acrmFciOrgCustInfo = new AcrmFciOrgCustInfo();
			acrmFciOrgCustInfo.setCustId(custId);
			acrmFciOrgCustInfo.setCustName(map.get("custName"));
			acrmFciOrgCustInfo.setCertNo(map.get("certNo"));
			acrmFciOrgCustInfo.setCertType(map.get("certType"));
			acrmFciOrgCustInfo.setIndusCd(map.get("indusCd"));
			acrmFciOrgCustInfo.setRegAddr(map.get("contAddr"));
			acrmFciOrgCustInfo.setContMan(map.get("contMan"));
			acrmFciOrgCustInfo.setContTelNo(map.get("contTelNo"));
			acrmFciOrgCustInfo.setCorpOrgCode("001");
			acrmFciOrgCustInfo.setIsAdmitEnter("1");
			acrmFciOrgCustInfo.setCustStatus("Q1");
			acrmFciOrgCustInfo.setLastUpdateOrg(lastUpdateOrg);
			acrmFciOrgCustInfo.setLastUpdateTm(date);
			acrmFciOrgCustInfo.setLastUpdateUser(lastUpdateUser);
			acrmFciOrgCustInfo.setLastUpdateSys(sourceChannel);
			acrmFciOrgCustInfo.setBusiType("2");
			if (map.get("belongMgr") != null && !map.get("belongMgr").equals("")) {
				acrmFciOrgCustInfo.setBelongBrch(map.get("belongBrch"));
				acrmFciOrgCustInfo.setBelongMgr(map.get("belongMgr"));
			} else if (map.get("belongBrch") != null) {
				acrmFciOrgCustInfo.setBelongMgr("VM" + map.get("belongBrch"));
				acrmFciOrgCustInfo.setBelongBrch(map.get("belongBrch"));
			} else {
				acrmFciOrgCustInfo.setBelongMgr("VM" + user.getOrg().getId());
				acrmFciOrgCustInfo.setBelongBrch(user.getOrg().getId());
			}

			/*
			 * 客户证件信息
			 */

			AcrmFciCustIdentInfo acrmFciCustIdentInfo = new AcrmFciCustIdentInfo();
			acrmFciCustIdentInfo.setId(UtilTools.getUUID());
			acrmFciCustIdentInfo.setCratDt(date);
			acrmFciCustIdentInfo.setCratOrgId(user.getOrg().getCode());
			acrmFciCustIdentInfo.setCratUsr(user.getUserId());
			acrmFciCustIdentInfo.setLastChgSys(user.getLogicSys().getCode());
			acrmFciCustIdentInfo.setLastChgUsr(user.getUserId());
			acrmFciCustIdentInfo.setLastChgDt(date);
			acrmFciCustIdentInfo.setCorpOrgCode("001");
			acrmFciCustIdentInfo.setCustId(acrmFciOrgCustInfo.getCustId());
			acrmFciCustIdentInfo.setCustName(map.get("custName"));
			acrmFciCustIdentInfo.setCustType("2");
			acrmFciCustIdentInfo.setCertNo(map.get("certNo"));
			acrmFciCustIdentInfo.setCertType(map.get("certType"));
			acrmFciCustIdentInfo.setMainIdentFlg("1");
			acrmFciCustIdentInfo.setLastChgUsr(lastUpdateUser);
			acrmFciCustIdentInfo.setLastChgDt(date);
			/*
			 * 客户地址信息
			 */
			AcrmFciAddrInfo acrmFciAddrInfo = new AcrmFciAddrInfo();
			acrmFciAddrInfo.setId(UtilTools.getUUID());
			acrmFciAddrInfo.setCratDt(date);
			acrmFciAddrInfo.setCratOrgId(user.getOrg().getCode());
			acrmFciAddrInfo.setCratUsr(user.getUserId());
			acrmFciAddrInfo.setLastChgSys(user.getLogicSys().getCode());
			acrmFciAddrInfo.setLastChgUsr(user.getUserId());
			acrmFciAddrInfo.setLastChgDt(date);
			acrmFciAddrInfo.setCorpOrgCode("001");
			acrmFciAddrInfo.setCustId(acrmFciOrgCustInfo.getCustId());
			acrmFciAddrInfo.setCustType("2");
			acrmFciAddrInfo.setAddrCommOne(map.get("contAddr"));
			acrmFciAddrInfo.setMainAddrFlg("1");
			/*
			 * 客户联系信息
			 */
			AcrmFciContactInfo acrmFciContactInfo = new AcrmFciContactInfo();
			acrmFciContactInfo.setId(UtilTools.getUUID());
			acrmFciContactInfo.setCratDt(date);
			acrmFciContactInfo.setCratOrgId(user.getOrg().getCode());
			acrmFciContactInfo.setCratUsr(user.getUserId());
			acrmFciContactInfo.setLastChgSys(user.getLogicSys().getCode());
			acrmFciContactInfo.setLastChgUsr(user.getUserId());
			acrmFciContactInfo.setLastChgDt(date);
			acrmFciContactInfo.setCorpOrgCode("001");
			acrmFciContactInfo.setCustId(acrmFciOrgCustInfo.getCustId());
			acrmFciContactInfo.setCustType("2");
			acrmFciContactInfo.setContName(map.get("contMan"));
			acrmFciContactInfo.setMainContFlg("1");

			/*
			 * 准入归属 OCRM_F_CI_ADMIT_BELONG
			 */
			Map<String, String> belong = new HashMap<>();
			belong.put("custId", acrmFciOrgCustInfo.getCustId());
			if (map.get("belongMgr") != null && !map.get("belongMgr").equals("")) {
				belong.put("orgId", map.get("belongBrch"));
				belong.put("mgrId", map.get("belongMgr"));
				belong.put("orgName", map.get("orgName"));
				belong.put("mgrName", map.get("mgrName"));
			} else if (map.get("belongBrch") != null) {
				belong.put("orgId", map.get("belongBrch"));
				belong.put("mgrId", "VM" + map.get("belongBrch"));
				belong.put("orgName", map.get("orgName"));
				belong.put("mgrName", "虚拟客户经理");
			} else {
				belong.put("orgId", user.getOrg().getId());
				belong.put("mgrId", "VM" + user.getOrg().getId());
				belong.put("orgName", user.getOrg().getName());
				belong.put("mgrName", "虚拟客户经理");
			}
			belong.put("mgrType", "1");
			belong.put("orgType", "1");
			/*
			 * 准入客户信息 ACRM_F_CI_CUST_ALL
			 */
			AcrmFciCustAdmitAll acrmFciCustAdmitAll = new AcrmFciCustAdmitAll();
			acrmFciCustAdmitAll.setCustId(acrmFciOrgCustInfo.getCustId());
			acrmFciCustAdmitAll.setCustName(acrmFciOrgCustInfo.getCustName());
			acrmFciCustAdmitAll.setCustType("2");
			acrmFciCustAdmitAll.setCustStatus("Q1");
			acrmFciCustAdmitAll.setCorpOrgCode("001");
			acrmFciCustAdmitAll.setCertNo(map.get("certNo"));
			acrmFciCustAdmitAll.setCertType(map.get("certType"));
			acrmFciCustAdmitAll.setBelongMgr(acrmFciOrgCustInfo.getBelongMgr());
			acrmFciCustAdmitAll.setBelongBrch(acrmFciOrgCustInfo.getBelongBrch());
			acrmFciCustAdmitAll.setLastUpdateTm(date);
			acrmFciCustAdmitAll.setLastUpdateUser(lastUpdateUser);
			acrmFciCustAdmitAll.setLastUpdateSys(sourceChannel);
			acrmFciCustAdmitAll.setBusiType("2");
			acrmFciCustAdmitAll.setIsAdmitEnter("1");
			/*
			 * 客户全量信息
			 */
			// AcrmFciCustAll acrmFciCustAll = new AcrmFciCustAll();
			// acrmFciCustAll.setCustId(acrmFciOrgCustInfo.getCustId());
			// acrmFciCustAll.setCustName(acrmFciOrgCustInfo.getCustName());
			// acrmFciCustAll.setCertNo(map.get("certNo"));
			// acrmFciCustAll.setCertType(map.get("certType"));
			// acrmFciCustAll.setCustType("2");
			// acrmFciCustAll.setCustStatus("Q1");
			// acrmFciCustAll.setCorpOrgCode("001");
			// acrmFciCustAll.setLastUpdateTm(date);
			// acrmFciCustAll.setLastUpdateSys(sourceChannel);
			// acrmFciCustAll.setLastUpdateUser(lastUpdateUser);
			// acrmFciCustAll.setBusiType("2");

			acrmFciAddrInfoService.insertSelective(acrmFciAddrInfoService.getMapper(), acrmFciAddrInfo);
			acrmFciCustIdentInfoService.insertSelective(acrmFciCustIdentInfoService.getMapper(), acrmFciCustIdentInfo);
			acrmFciContactInfoService.insertSelective(acrmFciContactInfoService.getMapper(), acrmFciContactInfo);
			ocrmFciAdmitBelongService.claimAdd(belong);
			// acrmFciCustAllService.insertSelective(acrmFciCustAllService.getMapper(),
			// acrmFciCustAll);
			acrmFciCustAdmitAllService.insertSelective(acrmFciCustAdmitAllService.getMapper(), acrmFciCustAdmitAll);
			num = acrmFciOrgCustInfoService.insertSelective(acrmFciOrgCustInfoService.getMapper(), acrmFciOrgCustInfo);
			Map<String, String> KeyMan = new HashMap<>();
			KeyMan.put("custName", map.get("contMan"));
			KeyMan.put("certType", map.get("contCertType"));
			KeyMan.put("certNo", map.get("contCertNo"));
			// KeyMan = custExist(KeyMan);
			// if (KeyMan == null) {
			// /*
			// * 准入个人客户信息 ACRM_F_CI_PER_ADMIT_INFO
			// */
			// AcrmFciPerAdmitInfo acrmFciPerAdmitInfo = new AcrmFciPerAdmitInfo();
			// acrmFciPerAdmitInfo.setCustStatus("Q1");
			// acrmFciPerAdmitInfo.setCustId(potentialCustMapper.getSeq());
			// acrmFciPerAdmitInfo.setCertNo(map.get("contCertNo"));
			// acrmFciPerAdmitInfo.setCertType(map.get("contCertType"));
			// acrmFciPerAdmitInfo.setCustName(map.get("contMan"));
			// acrmFciPerAdmitInfo.setPhoneNo(map.get("contTelNo"));
			// acrmFciPerAdmitInfo.setLastUpdateOrg(lastUpdateOrg);
			// acrmFciPerAdmitInfo.setLastUpdateTm(date);
			// acrmFciPerAdmitInfo.setLastUpdateUser(lastUpdateUser);
			// acrmFciPerAdmitInfo.setCorpOrgCode("001");
			// acrmFciPerAdmitInfo.setBelongMgr(acrmFciOrgCustInfo.getBelongMgr());
			// acrmFciPerAdmitInfo.setBelongBrch(acrmFciOrgCustInfo.getBelongBrch());
			// acrmFciPerAdmitInfo.setLastUpdateSys(sourceChannel);
			// acrmFciPerAdmitInfo.setIsAdmitEnter("1");
			// /*
			// * 客户证件信息
			// */
			//
			// AcrmFciCustIdentInfo contAcrmFciCustIdentInfo = new AcrmFciCustIdentInfo();
			// contAcrmFciCustIdentInfo.setId(UtilTools.getUUID());
			// contAcrmFciCustIdentInfo.setCratDt(date);
			// contAcrmFciCustIdentInfo.setCratOrgId(user.getOrg().getCode());
			// contAcrmFciCustIdentInfo.setCratUsr(user.getUserId());
			// contAcrmFciCustIdentInfo.setLastChgSys(user.getLogicSys().getCode());
			// contAcrmFciCustIdentInfo.setLastChgUsr(user.getUserId());
			// contAcrmFciCustIdentInfo.setLastChgDt(date);
			// contAcrmFciCustIdentInfo.setCorpOrgCode("001");
			// contAcrmFciCustIdentInfo.setCustId(acrmFciPerAdmitInfo.getCustId());
			// contAcrmFciCustIdentInfo.setCustName(acrmFciPerAdmitInfo.getCustName());
			// contAcrmFciCustIdentInfo.setCustType("1");
			// contAcrmFciCustIdentInfo.setCertNo(acrmFciPerAdmitInfo.getCertNo());
			// contAcrmFciCustIdentInfo.setCertType(acrmFciPerAdmitInfo.getCertType());
			// contAcrmFciCustIdentInfo.setMainIdentFlg("1");
			// contAcrmFciCustIdentInfo.setLastChgUsr(lastUpdateUser);
			// contAcrmFciCustIdentInfo.setLastChgDt(date);
			// /*
			// * 客户地址信息
			// */
			// AcrmFciAddrInfo contacrmFciAddrInfo = new AcrmFciAddrInfo();
			// contacrmFciAddrInfo.setId(UtilTools.getUUID());
			// contacrmFciAddrInfo.setCratDt(date);
			// contacrmFciAddrInfo.setCratOrgId(user.getOrg().getCode());
			// contacrmFciAddrInfo.setCratUsr(user.getUserId());
			// contacrmFciAddrInfo.setLastChgSys(user.getLogicSys().getCode());
			// contacrmFciAddrInfo.setLastChgUsr(user.getUserId());
			// contacrmFciAddrInfo.setLastChgDt(date);
			// contacrmFciAddrInfo.setCorpOrgCode("001");
			// contacrmFciAddrInfo.setCustId(acrmFciPerAdmitInfo.getCustId());
			// contacrmFciAddrInfo.setCustType("1");
			// contacrmFciAddrInfo.setAddrCommOne("");
			// contacrmFciAddrInfo.setMainAddrFlg("1");
			// /*
			// * 客户联系信息
			// */
			// AcrmFciContactInfo contAcrmFciContactInfo = new AcrmFciContactInfo();
			// contAcrmFciContactInfo.setId(UtilTools.getUUID());
			// contAcrmFciContactInfo.setCratDt(date);
			// contAcrmFciContactInfo.setCratOrgId(user.getOrg().getCode());
			// contAcrmFciContactInfo.setCratUsr(user.getUserId());
			// contAcrmFciContactInfo.setLastChgSys(user.getLogicSys().getCode());
			// contAcrmFciContactInfo.setLastChgUsr(user.getUserId());
			// contAcrmFciContactInfo.setLastChgDt(date);
			// contAcrmFciContactInfo.setCorpOrgCode("001");
			// contAcrmFciContactInfo.setCustId(acrmFciPerAdmitInfo.getCustId());
			// contAcrmFciContactInfo.setCustType("1");
			// contAcrmFciContactInfo.setContName("");
			// contAcrmFciContactInfo.setMainContFlg("1");
			// /*
			// * 准入客户全量信息ACRM_F_CI_CUST_ALL
			// */
			// AcrmFciCustAdmitAll contAcrmFciCustAdmitAll = new AcrmFciCustAdmitAll();
			// contAcrmFciCustAdmitAll.setCustId(acrmFciPerAdmitInfo.getCustId());
			// contAcrmFciCustAdmitAll.setCustName(acrmFciPerAdmitInfo.getCustName());
			// contAcrmFciCustAdmitAll.setCustType("1");
			// contAcrmFciCustAdmitAll.setCustStatus("Q1");
			// contAcrmFciCustAdmitAll.setCorpOrgCode("001");
			// contAcrmFciCustAdmitAll.setCertNo(map.get("contCertNo"));
			// contAcrmFciCustAdmitAll.setCertType(map.get("contCertType"));
			// contAcrmFciCustAdmitAll.setBelongBrch(acrmFciPerAdmitInfo.getBelongBrch());
			// contAcrmFciCustAdmitAll.setBelongMgr(acrmFciPerAdmitInfo.getBelongMgr());
			// contAcrmFciCustAdmitAll.setLastUpdateTm(date);
			// contAcrmFciCustAdmitAll.setLastUpdateUser(lastUpdateUser);
			// contAcrmFciCustAdmitAll.setLastUpdateSys(sourceChannel);
			// contAcrmFciCustAdmitAll.setIsAdmitEnter("1");
			// /*
			// * 客户全量信息
			// */
			// // AcrmFciCustAll contAcrmFciCustAll = new AcrmFciCustAll();
			// // contAcrmFciCustAll.setCustId(acrmFciPerAdmitInfo.getCustId());
			// // contAcrmFciCustAll.setCustName(acrmFciPerAdmitInfo.getCustName());
			// // contAcrmFciCustAll.setCustType("1");
			// // contAcrmFciCustAll.setCustStatus("Q1");
			// // contAcrmFciCustAll.setCorpOrgCode("001");
			// // contAcrmFciCustAll.setCertNo(map.get("contCertNo"));
			// // contAcrmFciCustAll.setCertType(map.get("contCertType"));
			// // contAcrmFciCustAll.setLastUpdateTm(date);
			// // contAcrmFciCustAll.setLastUpdateUser(lastUpdateUser);
			// // contAcrmFciCustAll.setLastUpdateSys(sourceChannel);
			// /*
			// * 个人客户全量信息 ACRM_F_CI_PER_ADMIT_INFO
			// */
			// // AcrmFciPerCust contAcrmFciPerCust = new AcrmFciPerCust();
			// // contAcrmFciPerCust.setCustStatus("Q1");
			// // contAcrmFciPerCust.setCustId(acrmFciPerAdmitInfo.getCustId());
			// // contAcrmFciPerCust.setCertNo(acrmFciPerAdmitInfo.getCertNo());
			// // contAcrmFciPerCust.setCertType(acrmFciPerAdmitInfo.getCertType());
			// // contAcrmFciPerCust.setCustName(acrmFciPerAdmitInfo.getCustName());
			// // contAcrmFciPerCust.setPhoneNo(acrmFciPerAdmitInfo.getPhoneNo());
			// // contAcrmFciPerCust.setBelongBrch(acrmFciPerAdmitInfo.getBelongBrch());
			// // contAcrmFciPerCust.setBelongMgr(acrmFciPerAdmitInfo.getBelongMgr());
			// // contAcrmFciPerCust.setLastUpdateUser(lastUpdateUser);
			// // contAcrmFciPerCust.setLastUpdateOrg(lastUpdateOrg);
			// // contAcrmFciPerCust.setLastUpdateTm(date);
			// // contAcrmFciPerCust.setLastUpdateSys(sourceChannel);
			//
			// /*
			// * 准入归属
			// */
			// Map<String, String> contbelong = new HashMap<>();
			// contbelong.put("custId", acrmFciPerAdmitInfo.getCustId());
			// contbelong.put("orgId", belong.get("orgId"));
			// contbelong.put("mgrId", belong.get("mgrId"));
			// contbelong.put("orgName", belong.get("orgName"));
			// contbelong.put("mgrName", belong.get("mgrName"));
			// contbelong.put("mgrType", "1");
			// contbelong.put("orgType", "1");
			//
			// /*
			// * 对公关键人信息
			// */
			// AcrmFciOrgKeyMan acrmFciOrgKeyMan = new AcrmFciOrgKeyMan();
			// acrmFciOrgKeyMan.setId(UtilTools.getUUID());
			// acrmFciOrgKeyMan.setCratDt(date);
			// acrmFciOrgKeyMan.setCratOrgId(user.getOrg().getCode());
			// acrmFciOrgKeyMan.setCratUsr(user.getUserId());
			// acrmFciOrgKeyMan.setLastChgSys(user.getLogicSys().getCode());
			// acrmFciOrgKeyMan.setLastChgUsr(user.getUserId());
			// acrmFciOrgKeyMan.setLastChgDt(date);
			// acrmFciOrgKeyMan.setCorpOrgCode("001");
			// acrmFciOrgKeyMan.setCustId(acrmFciOrgCustInfo.getCustId());
			// acrmFciOrgKeyMan.setCustName(map.get("custName"));
			// acrmFciOrgKeyMan.setKeyCustId(acrmFciPerAdmitInfo.getCustId());
			// acrmFciOrgKeyMan.setCustName(map.get("custName"));
			// acrmFciOrgKeyMan.setCustNameRel(map.get("contMan"));
			// acrmFciOrgKeyMan.setCertNo(map.get("contCertNo"));
			// acrmFciOrgKeyMan.setCertType(map.get("contCertType"));
			// acrmFciOrgKeyMan.setMobileNo(map.get("contTelNo"));
			// acrmFciOrgKeyMan.setContPrio("1");
			// ocrmFciAdmitBelongService.claimAdd(contbelong);
			// acrmFciOrgKeyManService.insertSelective(acrmFciOrgKeyManService.getMapper(),
			// acrmFciOrgKeyMan);
			// acrmFciAddrInfoService.insertSelective(acrmFciAddrInfoService.getMapper(),
			// contacrmFciAddrInfo);
			// acrmFciCustIdentInfoService.insertSelective(acrmFciCustIdentInfoService.getMapper(),
			// contAcrmFciCustIdentInfo);
			// acrmFciContactInfoService.insertSelective(acrmFciContactInfoService.getMapper(),
			// contAcrmFciContactInfo);
			// /*
			// * acrmFciCustAllService.insertSelective(acrmFciCustAllService.getMapper(),
			// * contAcrmFciCustAll);
			// */
			// // acrmFciPerCustService.insertSelective(acrmFciPerCustService.getMapper(),
			// // contAcrmFciPerCust);
			// acrmFciCustAdmitAllService.insertSelective(acrmFciCustAdmitAllService.getMapper(),
			// contAcrmFciCustAdmitAll);
			// acrmFciPerAdmitInfoService.insertSelective(acrmFciPerAdmitInfoService.getMapper(),
			// acrmFciPerAdmitInfo);
			// } else {
			/*
			 * 对公关键人信息
			 */
			AcrmFciOrgKeyMan acrmFciOrgKeyMan = new AcrmFciOrgKeyMan();
			acrmFciOrgKeyMan.setId(UtilTools.getUUID());
			acrmFciOrgKeyMan.setCratDt(date);
			acrmFciOrgKeyMan.setCratOrgId(user.getOrg().getCode());
			acrmFciOrgKeyMan.setCratUsr(user.getUserId());
			acrmFciOrgKeyMan.setLastChgSys(user.getLogicSys().getCode());
			acrmFciOrgKeyMan.setLastChgUsr(user.getUserId());
			acrmFciOrgKeyMan.setLastChgDt(date);
			acrmFciOrgKeyMan.setCorpOrgCode("001");
			acrmFciOrgKeyMan.setCustId(acrmFciOrgCustInfo.getCustId());
			acrmFciOrgKeyMan.setCustName(map.get("custName"));
			acrmFciOrgKeyMan.setKeyCustId(KeyMan.get("custId"));
			acrmFciOrgKeyMan.setCustName(KeyMan.get("custName"));
			acrmFciOrgKeyMan.setCustNameRel(map.get("contMan"));
			acrmFciOrgKeyMan.setCertNo(map.get("contCertNo"));
			acrmFciOrgKeyMan.setCertType(map.get("contCerType"));
			acrmFciOrgKeyMan.setMobileNo(map.get("contTelNo"));
			acrmFciOrgKeyMan.setContPrio("1");
			acrmFciOrgKeyManService.insertSelective(acrmFciOrgKeyManService.getMapper(), acrmFciOrgKeyMan);
			// }
		}
		return num;
	}

	@Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
	public int updateOrg(Map<String, String> map) {
		// TODO 自动生成的方法存根
		UserInfoDTO user = getUser();
		int num = 0;
		Date date = new Date();
		String sourceChannel = map.get("sourceChannel");
		String lastUpdateUser = user.getUserId();
		String lastUpdateOrg = user.getOrg().getCode();
		AcrmFciOrgCustInfo acrmFciOrgCustInfo = new AcrmFciOrgCustInfo();
		acrmFciOrgCustInfo.setCustId(map.get("custId"));
		acrmFciOrgCustInfo.setIndusCd(map.get("indusCd"));
		acrmFciOrgCustInfo.setRegAddr(map.get("contAddr"));
		acrmFciOrgCustInfo.setContTelNo(map.get("contTelNo"));
		acrmFciOrgCustInfo.setCustStatus("Q1");
		acrmFciOrgCustInfo.setLastUpdateOrg(lastUpdateOrg);
		acrmFciOrgCustInfo.setLastUpdateTm(date);
		acrmFciOrgCustInfo.setLastUpdateUser(lastUpdateUser);
		acrmFciOrgCustInfo.setLastUpdateSys(sourceChannel);
		AcrmFciOrgKeyMan acrmFciOrgKeyMan = new AcrmFciOrgKeyMan();
		acrmFciOrgKeyMan.setLastChgDt(date);
		acrmFciOrgKeyMan.setLastChgUsr(lastUpdateUser);
		acrmFciOrgKeyMan.setMobileNo(map.get("contTelNo"));
		acrmFciOrgKeyMan.setId(map.get("keId"));
		acrmFciOrgKeyManService.updateSelective(acrmFciOrgKeyMan);
		/*
		 * 客户地址信息
		 */
		AcrmFciAddrInfo acrmFciAddrInfo = new AcrmFciAddrInfo();
		acrmFciAddrInfo.setLastChgSys(user.getLogicSys().getCode());
		acrmFciAddrInfo.setLastChgUsr(user.getUserId());
		acrmFciAddrInfo.setLastChgDt(date);
		acrmFciAddrInfo.setCustId(acrmFciOrgCustInfo.getCustId());
		acrmFciAddrInfo.setAddrCommOne(map.get("contAddr"));
		acrmFciAddrInfo.setId(map.get("addrId"));
		acrmFciAddrInfoService.updateSelective(acrmFciAddrInfo);
		/*
		 * 客户全量
		 */
		AcrmFciCustAll acrmFciCustAll = new AcrmFciCustAll();
		acrmFciCustAll.setCustId(acrmFciOrgCustInfo.getCustId());
		acrmFciCustAll.setCustName(acrmFciOrgCustInfo.getCustName());
		acrmFciCustAll.setCustType("2");
		acrmFciCustAll.setCustStatus("Q1");
		acrmFciCustAll.setCorpOrgCode("001");
		acrmFciCustAll.setCertNo(map.get("certNo"));
		acrmFciCustAll.setCertType(map.get("certType"));
		acrmFciCustAll.setLastUpdateTm(date);
		acrmFciCustAll.setLastUpdateUser(lastUpdateUser);
		acrmFciCustAll.setLastUpdateSys(sourceChannel);
		acrmFciCustAllService.updateSelective(acrmFciCustAll);
		num = acrmFciOrgCustInfoService.updateSelective(acrmFciOrgCustInfo);

		return num;
	}

	@Transactional(readOnly = true)
	public AcrmFciCustAdmitAll getCustAdminAllBycustId(String custId) {
		// TODO 自动生成的方法存根
		return potentialCustMapper.getCustAdminAllBycustId(custId);
	}

	@Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
	public int addPer(Map<String, String> map) {
		int num = 0;
		Map<String, String> custAll = new HashMap<>();
		custAll.put("custName", map.get("custName"));
		custAll.put("certType", map.get("certType"));
		custAll.put("certNo", map.get("certNo"));
		if (potentialCustMapper.checkIsCust(custAll) == 0) {
			// TODO 自动生成的方法存根
			UserInfoDTO user = getUser();
			Date date = new Date();
			String lastUpdateUser = user.getUserId();
			String lastUpdateOrg = user.getOrg().getCode();
			String sourceChannel = map.get("sourceChannel");
			/*
			 * 准入个人客户信息 ACRM_F_CI_PER_ADMIT_INFO
			 */
			AcrmFciPerAdmitInfo acrmFciPerAdmitInfo = new AcrmFciPerAdmitInfo();
			acrmFciPerAdmitInfo.setCustStatus("Q1");
			acrmFciPerAdmitInfo.setCustId(potentialCustMapper.getSeq());
			acrmFciPerAdmitInfo.setCertNo(map.get("certNo"));
			acrmFciPerAdmitInfo.setCertType(map.get("certType"));
			acrmFciPerAdmitInfo.setCustName(map.get("custName"));
			acrmFciPerAdmitInfo.setIndivOcc(map.get("indivOcc"));
			acrmFciPerAdmitInfo.setContAddr(map.get("contAddr"));
			acrmFciPerAdmitInfo.setPhoneNo(map.get("phoneNo"));
			acrmFciPerAdmitInfo.setWorkUnit(map.get("workUnit"));
			acrmFciPerAdmitInfo.setLastUpdateOrg(lastUpdateOrg);
			acrmFciPerAdmitInfo.setLastUpdateTm(date);
			acrmFciPerAdmitInfo.setIsAdmitEnter("1");
			acrmFciPerAdmitInfo.setLastUpdateUser(lastUpdateUser);
			acrmFciPerAdmitInfo.setLastUpdateSys(sourceChannel);
			acrmFciPerAdmitInfo.setBusiType("1");
			if (map.get("belongMgr") != null && !map.get("belongMgr").equals("")) {
				acrmFciPerAdmitInfo.setBelongBrch(map.get("belongBrch"));
				acrmFciPerAdmitInfo.setBelongMgr(map.get("belongMgr"));
			} else if (map.get("belongBrch") != null) {
				acrmFciPerAdmitInfo.setBelongMgr("VM" + map.get("belongBrch"));
				acrmFciPerAdmitInfo.setBelongBrch(map.get("belongBrch"));
			} else {
				acrmFciPerAdmitInfo.setBelongMgr("VM" + user.getOrg().getId());
				acrmFciPerAdmitInfo.setBelongBrch(user.getOrg().getId());
			}
			acrmFciPerAdmitInfo.setCorpOrgCode("001");

			/*
			 * 客户证件信息
			 */

			AcrmFciCustIdentInfo acrmFciCustIdentInfo = new AcrmFciCustIdentInfo();
			acrmFciCustIdentInfo.setId(UtilTools.getUUID());
			acrmFciCustIdentInfo.setCratDt(date);
			acrmFciCustIdentInfo.setCratOrgId(user.getOrg().getCode());
			acrmFciCustIdentInfo.setCratUsr(user.getUserId());
			acrmFciCustIdentInfo.setLastChgUsr(user.getUserId());
			acrmFciCustIdentInfo.setCorpOrgCode("001");
			acrmFciCustIdentInfo.setCustId(acrmFciPerAdmitInfo.getCustId());
			acrmFciCustIdentInfo.setCustName(map.get("custName"));
			acrmFciCustIdentInfo.setCustType("1");
			acrmFciCustIdentInfo.setCertNo(map.get("certNo"));
			acrmFciCustIdentInfo.setCertType(map.get("certType"));
			acrmFciCustIdentInfo.setMainIdentFlg("1");
			acrmFciCustIdentInfo.setLastChgUsr(lastUpdateUser);
			acrmFciCustIdentInfo.setLastChgDt(date);
			/*
			 * 客户地址信息
			 */
			AcrmFciAddrInfo acrmFciAddrInfo = new AcrmFciAddrInfo();
			acrmFciAddrInfo.setId(UtilTools.getUUID());
			acrmFciAddrInfo.setCratDt(date);
			acrmFciAddrInfo.setCratOrgId(user.getOrg().getCode());
			acrmFciAddrInfo.setCratUsr(user.getUserId());
			acrmFciAddrInfo.setLastChgSys(user.getLogicSys().getCode());
			acrmFciAddrInfo.setLastChgUsr(user.getUserId());
			acrmFciAddrInfo.setLastChgDt(date);
			acrmFciAddrInfo.setCorpOrgCode("001");
			acrmFciAddrInfo.setCustId(acrmFciPerAdmitInfo.getCustId());
			acrmFciAddrInfo.setCustType("1");
			acrmFciAddrInfo.setAddrCommOne(map.get("contAddr"));
			acrmFciAddrInfo.setMainAddrFlg("1");
			/*
			 * 客户联系信息
			 */
			AcrmFciContactInfo acrmFciContactInfo = new AcrmFciContactInfo();
			acrmFciContactInfo.setId(UtilTools.getUUID());
			acrmFciContactInfo.setCratDt(date);
			acrmFciContactInfo.setCratOrgId(user.getOrg().getCode());
			acrmFciContactInfo.setCratUsr(user.getUserId());
			acrmFciContactInfo.setLastChgSys(user.getLogicSys().getCode());
			acrmFciContactInfo.setLastChgUsr(user.getUserId());
			acrmFciContactInfo.setLastChgDt(date);
			acrmFciContactInfo.setCorpOrgCode("001");
			acrmFciContactInfo.setCustId(acrmFciPerAdmitInfo.getCustId());
			acrmFciContactInfo.setCustType("1");
			acrmFciContactInfo.setMainContFlg("1");
			/*
			 * 准入客户全量信息 ACRM_F_CI_CUST_ALL
			 */
			AcrmFciCustAdmitAll acrmFciCustAdmitAll = new AcrmFciCustAdmitAll();
			acrmFciCustAdmitAll.setCustId(acrmFciPerAdmitInfo.getCustId());
			acrmFciCustAdmitAll.setCustName(acrmFciPerAdmitInfo.getCustName());
			acrmFciCustAdmitAll.setCustType("1");
			acrmFciCustAdmitAll.setCustStatus("Q1");
			acrmFciCustAdmitAll.setCorpOrgCode("001");
			acrmFciCustAdmitAll.setCertNo(map.get("certNo"));
			acrmFciCustAdmitAll.setCertType(map.get("certType"));
			acrmFciCustAdmitAll.setBelongBrch(acrmFciPerAdmitInfo.getBelongBrch());
			acrmFciCustAdmitAll.setBelongMgr(acrmFciPerAdmitInfo.getBelongMgr());
			acrmFciCustAdmitAll.setLastUpdateTm(date);
			acrmFciCustAdmitAll.setLastUpdateUser(lastUpdateUser);
			acrmFciCustAdmitAll.setLastUpdateSys(sourceChannel);
			acrmFciCustAdmitAll.setBusiType("1");
			acrmFciCustAdmitAll.setIsAdmitEnter("1");
			/*
			 * 客户全量信息
			 */
			// AcrmFciCustAll acrmFciCustAll = new AcrmFciCustAll();
			// acrmFciCustAll.setCustId(acrmFciPerAdmitInfo.getCustId());
			// acrmFciCustAll.setCustName(acrmFciPerAdmitInfo.getCustName());
			// acrmFciCustAll.setCustType("1");
			// acrmFciCustAll.setCustStatus("Q1");
			// acrmFciCustAll.setCorpOrgCode("001");
			// acrmFciCustAll.setCertNo(map.get("certNo"));
			// acrmFciCustAll.setCertType(map.get("certType"));
			// acrmFciCustAll.setLastUpdateTm(date);
			// acrmFciCustAll.setLastUpdateUser(lastUpdateUser);
			// acrmFciCustAll.setLastUpdateSys(sourceChannel);
			// acrmFciCustAll.setBusiType("1");
			/*
			 * 个人客户全量信息 ACRM_F_CI_PER_ADMIT_INFO
			 */
			// AcrmFciPerCust acrmFciPerCust = new AcrmFciPerCust();
			// acrmFciPerCust.setCustStatus("Q1");
			// acrmFciPerCust.setCustId(acrmFciPerAdmitInfo.getCustId());
			// acrmFciPerCust.setCertNo(acrmFciPerAdmitInfo.getCertNo());
			// acrmFciPerCust.setCertType(acrmFciPerAdmitInfo.getCertType());
			// acrmFciPerCust.setCustName(acrmFciPerAdmitInfo.getCustName());
			// acrmFciPerCust.setIndivOcc(acrmFciPerAdmitInfo.getIndivOcc());
			// acrmFciPerCust.setPhoneNo(acrmFciPerAdmitInfo.getPhoneNo());
			// acrmFciPerCust.setWorkUnit(acrmFciPerAdmitInfo.getWorkUnit());
			// acrmFciPerCust.setBelongBrch(acrmFciPerAdmitInfo.getBelongBrch());
			// acrmFciPerCust.setBelongMgr(acrmFciPerAdmitInfo.getBelongMgr());
			// acrmFciPerCust.setLastUpdateUser(lastUpdateUser);
			// acrmFciPerCust.setLastUpdateOrg(lastUpdateOrg);
			// acrmFciPerCust.setLastUpdateTm(date);
			// acrmFciPerCust.setLastUpdateSys(sourceChannel);
			/*
			 * 准入归属
			 */
			Map<String, String> belong = new HashMap<>();
			belong.put("custId", acrmFciPerAdmitInfo.getCustId());
			if (map.get("belongMgr") != null && !map.get("belongMgr").equals("")) {
				belong.put("orgId", map.get("belongBrch"));
				belong.put("mgrId", map.get("belongMgr"));
				belong.put("orgName", map.get("orgName"));
				belong.put("mgrName", map.get("mgrName"));
			} else if (map.get("belongBrch") != null) {
				belong.put("orgId", map.get("belongBrch"));
				belong.put("mgrId", "VM" + map.get("belongBrch"));
				belong.put("orgName", map.get("orgName"));
				belong.put("mgrName", "虚拟客户经理");
			} else {
				belong.put("orgId", user.getOrg().getId());
				belong.put("mgrId", "VM" + user.getOrg().getId());
				belong.put("orgName", user.getOrg().getName());
				belong.put("mgrName", "虚拟客户经理");
			}
			belong.put("mgrType", "1");
			belong.put("orgType", "1");
			ocrmFciAdmitBelongService.claimAdd(belong);
			acrmFciAddrInfoService.insertSelective(acrmFciAddrInfoService.getMapper(), acrmFciAddrInfo);
			acrmFciCustIdentInfoService.insertSelective(acrmFciCustIdentInfoService.getMapper(), acrmFciCustIdentInfo);
			acrmFciContactInfoService.insertSelective(acrmFciContactInfoService.getMapper(), acrmFciContactInfo);
			// acrmFciCustAllService.insertSelective(acrmFciCustAllService.getMapper(),
			// acrmFciCustAll);
			// acrmFciPerCustService.insertSelective(acrmFciPerCustService.getMapper(),
			// acrmFciPerCust);
			acrmFciCustAdmitAllService.insertSelective(acrmFciCustAdmitAllService.getMapper(), acrmFciCustAdmitAll);
			num = acrmFciPerAdmitInfoService.insertSelective(acrmFciPerAdmitInfoService.getMapper(),
					acrmFciPerAdmitInfo);
		}
		return num;
	}

	@Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
	public int updatePer(Map<String, String> map) {
		// TODO 自动生成的方法存根
		int num = 0;
		UserInfoDTO user = getUser();
		Date date = new Date();
		String lastUpdateUser = user.getUserId();
		String lastUpdateOrg = user.getOrg().getCode();
		String sourceChannel = map.get("sourceChannel");
		/*
		 * 准入个人客户信息
		 */
		AcrmFciPerAdmitInfo acrmFciPerAdmitInfo = new AcrmFciPerAdmitInfo();
		acrmFciPerAdmitInfo.setCustStatus("Q1");
		acrmFciPerAdmitInfo.setCustId(map.get("custId"));
		acrmFciPerAdmitInfo.setCertNo(map.get("certNo"));
		acrmFciPerAdmitInfo.setCertType(map.get("certType"));
		acrmFciPerAdmitInfo.setCustName(map.get("custName"));
		acrmFciPerAdmitInfo.setIndivOcc(map.get("indivOcc"));
		acrmFciPerAdmitInfo.setPhoneNo(map.get("phoneNo"));
		acrmFciPerAdmitInfo.setWorkUnit(map.get("workUnit"));
		acrmFciPerAdmitInfo.setContAddr(map.get("contAddr"));
		// acrmFciPerAdmitInfo.setIsAdmitEnter("1");
		acrmFciPerAdmitInfo.setLastUpdateTm(date);
		acrmFciPerAdmitInfo.setLastUpdateUser(lastUpdateUser);
		acrmFciPerAdmitInfo.setLastUpdateSys(sourceChannel);
		if (checkIsPerUp(acrmFciPerAdmitInfo) == 0) {
			/*
			 * 准入客户
			 */
			/*
			 * AcrmFciCustAdmitAll acrmFciCustAdmitAll = new AcrmFciCustAdmitAll();
			 * acrmFciCustAdmitAll.setCustId(acrmFciPerAdmitInfo.getCustId());
			 * acrmFciCustAdmitAll.setCustType("2");
			 * acrmFciCustAdmitAll.setCustStatus("Q1");
			 * acrmFciCustAdmitAll.setCustName(acrmFciPerAdmitInfo.getCustName());
			 * acrmFciCustAdmitAll.setLastUpdateTm(date);
			 * acrmFciCustAdmitAll.setLastUpdateUser(lastUpdateUser);
			 * acrmFciCustAdmitAll.setLastUpdateSys(sourceChannel);
			 */
			/*
			 * 客户全量
			 */
			AcrmFciCustAll acrmFciCustAll = new AcrmFciCustAll();
			acrmFciCustAll.setCustId(acrmFciPerAdmitInfo.getCustId());
			acrmFciCustAll.setCustName(acrmFciPerAdmitInfo.getCustName());
			acrmFciCustAll.setCustType("1");
			acrmFciCustAll.setCustStatus("Q1");
			acrmFciCustAll.setCorpOrgCode("001");
			acrmFciCustAll.setLastUpdateUser(lastUpdateUser);
			acrmFciCustAll.setLastUpdateTm(date);
			acrmFciCustAll.setLastUpdateSys(sourceChannel);
			// acrmFciCustAll.setIsAdmitEnter("1");
			/*
			 * 个人客户信息 ACRM_F_CI_PER_ADMIT_INFO
			 */
			// AcrmFciPerCust acrmFciPerCust = new AcrmFciPerCust();
			// acrmFciPerCust.setCustStatus("3");
			// acrmFciPerCust.setCustId(acrmFciPerAdmitInfo.getCustId());
			// acrmFciPerCust.setCertNo(acrmFciPerAdmitInfo.getCertNo());
			// acrmFciPerCust.setCertType(acrmFciPerAdmitInfo.getCertType());
			// acrmFciPerCust.setCustName(acrmFciPerAdmitInfo.getCustName());
			// acrmFciPerCust.setIndivOcc(acrmFciPerAdmitInfo.getIndivOcc());
			// acrmFciPerCust.setPhoneNo(acrmFciPerAdmitInfo.getPhoneNo());
			// acrmFciPerCust.setWorkUnit(acrmFciPerAdmitInfo.getWorkUnit());
			// acrmFciPerCust.setBelongBrch(acrmFciPerAdmitInfo.getBelongBrch());
			// acrmFciPerCust.setBelongMgr(acrmFciPerAdmitInfo.getBelongMgr());
			// acrmFciPerCust.setLastUpdateOrg(lastUpdateOrg);
			// acrmFciPerCust.setLastUpdateUser(lastUpdateUser);
			// acrmFciPerCust.setLastUpdateTm(date);
			// acrmFciPerCust.setLastUpdateSys(sourceChannel);
			/*
			 * 客户地址信息
			 */
			AcrmFciAddrInfo acrmFciAddrInfo = new AcrmFciAddrInfo();
			acrmFciAddrInfo.setLastChgSys(user.getLogicSys().getCode());
			acrmFciAddrInfo.setLastChgUsr(user.getUserId());
			acrmFciAddrInfo.setLastChgDt(date);
			acrmFciAddrInfo.setCustId(acrmFciPerAdmitInfo.getCustId());
			acrmFciAddrInfo.setAddrCommOne(map.get("contAddr"));
			acrmFciAddrInfo.setId(map.get("addrId"));
			acrmFciAddrInfoService.updateSelective(acrmFciAddrInfo);
			acrmFciCustAllService.updateSelective(acrmFciCustAll);
			// acrmFciPerCustService.updateSelective(acrmFciPerCust);
			// acrmFciCustAdmitAllService.updateSelective(acrmFciCustAdmitAll);
			num = acrmFciPerAdmitInfoService.updateSelective(acrmFciPerAdmitInfo);
		}
		return num;
	}

	@Transactional(readOnly = true)
	public int checkIsOrg(AcrmFciOrgCustInfo acrmFciOrgCustInfo) {
		return potentialCustMapper.checkIsOrg(acrmFciOrgCustInfo);
	}

	@Transactional(readOnly = true)
	public int checkIsPer(AcrmFciPerAdmitInfo acrmFciOrgCustInfo) {
		return potentialCustMapper.checkIsPer(acrmFciOrgCustInfo);
	}

	@Transactional(readOnly = true)
	public int checkIsOrgUp(AcrmFciOrgCustInfo acrmFciOrgCustInfo) {
		return potentialCustMapper.checkIsOrgUp(acrmFciOrgCustInfo);
	}

	@Transactional(readOnly = true)
	public int checkIsPerUp(AcrmFciPerAdmitInfo acrmFciOrgCustInfo) {
		return potentialCustMapper.checkIsPerUp(acrmFciOrgCustInfo);
	}

	public static Workbook getWorkBook(MultipartFile file) {
		// 获得文件名
		String fileName = file.getOriginalFilename();
		// 创建Workbook工作薄对象，表示整个excel
		Workbook workbook = null;
		try {
			// 获取excel文件的io流
			InputStream inpu = file.getInputStream();

			// POIFSFileSystem is = new POIFSFileSystem(inpu);//构建POIFSFileSystem类对象，用输入流构建
			// 根据文件后缀名不同(xls和xlsx)获得不同的Workbook实现类对象
			if (fileName.endsWith("xls")) {
				// 2003
				POIFSFileSystem is = new POIFSFileSystem(inpu);
				workbook = new HSSFWorkbook(is);
			} else if (fileName.endsWith("xlsx")) {
				// 2007 及2007以上
				// workbook = new HSSFWorkbook(file.getInputStream());
				workbook = new XSSFWorkbook(inpu);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return workbook;
	}

	@Transactional(readOnly = false, rollbackFor = { Exception.class, RuntimeException.class })
	public Map<String, Object> dataImportPer(String flag, MultipartFile file) throws Exception {
		int count = 0;
		int repeatNum = 0;
		int successNum = 0;
		Map<String, Object> reMap = new HashMap<>();
		try {
			// 获得Workbook工作薄对象
			Workbook workbook = getWorkBook(file);
			// 创建返回对象，把每行中的值作为一个数组，所有行作为一个集合返回

			if (workbook != null) {
				UserInfoDTO user = getUser();
				boolean isMgr = false;
				for (int i = 0; i < user.getRoles().size(); i++) {
					if (user.getRoles().get(i).getCode().equals("15")) {
						isMgr = true;
					}
				}
				String lastUpdateUser = user.getUserId();
				Date lastUpdateTm = new Date();
				String lastUpdateOrg = user.getOrg().getCode();
				String lastUpdateSys = user.getLogicSys().getCode();
				String belongBrch = "";
				String belongMgr = "";
				String orgName = "";
				String mgrName = "";
				if (isMgr) {
					belongBrch = user.getOrg().getCode();
					belongMgr = user.getUserId();
					orgName = user.getOrg().getName();
					mgrName = user.getUserName();
				} else {
					belongBrch = user.getOrg().getCode();
					belongMgr = "VM" + user.getOrg().getCode();
					orgName = user.getOrg().getName();
					mgrName = "虚拟客户经理";
				}
				for (int sheetNum = 1; sheetNum < workbook.getNumberOfSheets(); sheetNum++) {
					// 获得当前sheet工作表
					Sheet sheet = workbook.getSheetAt(sheetNum);
					String sheetname = workbook.getSheetName(sheetNum);
					if (sheet == null) {
						continue;
					}
					// 获得当前sheet的开始行
					int firstRowNum = sheet.getFirstRowNum();
					String headStr = "";
					Row headrow = sheet.getRow(firstRowNum);
					// 获得表头行的开始列
					int headfirstCellNum = headrow.getFirstCellNum();
					// 获得表头行的列数
					int headlastCellNum = headrow.getPhysicalNumberOfCells();
					String[] headcells = new String[headrow.getPhysicalNumberOfCells()];
					for (int k = headfirstCellNum; k < headlastCellNum; k++) {
						Cell cell = headrow.getCell(k);
						headcells[k] = cell.toString();
					}
					for (int x = 0; x < headcells.length; x++) {
						headStr += "," + headcells[x].toString();
					}
					headStr = headStr.substring(1);
					boolean topNamePer = headStr.equals("序号,客户名称,证件类型,证件号码,客户类别,职业,手机号码,联系地址,工作单位,客户来源渠道");
					boolean topNameOrg = headStr
							.equals("序号,客户名称,证件类型,证件号码,客户类别,行业,联系地址,联系人,联系人证件类型,联系人证件号,联系人手机号码,客户来源渠道");
					boolean topName = (topNamePer || topNameOrg);
					if (!topName) {
						reMap.put("message", "表格格式不对，请下载模板填写");
						return reMap;
					}

					if (topNamePer) {
						int lastRowNum = sheet.getLastRowNum();
						// 循环除了第一行的所有行
						for (int rowNum = firstRowNum + 1; rowNum <= lastRowNum; rowNum++) {
							count++;
							// 获得当前行
							// String RowData = "";
							Row row = sheet.getRow(rowNum);
							if (row == null) {
								continue;
							}
							// 获得当前行的开始列
							int firstCellNum = row.getFirstCellNum();
							// 获得当前行的列数
							String[] cells = new String[row.getPhysicalNumberOfCells()];
							// 循环当前行
							String identType = "";
							String identNo = "";
							String custName = "";
							String custType = "";
							String indivOcc = "";
							String phoneNo = "";
							String contAddr = "";
							String workUnit = "";
							String sourceChannel = "";
							for (int cellNum = firstCellNum; cellNum < headlastCellNum; cellNum++) {
								Cell cell = null;
								try {
									cell = row.getCell(cellNum);
									cells[cellNum] = getCellValue(cell);
								} catch (Exception e) {
									// TODO: handle exception
									switch (cellNum) {
									case 1:
										custName = getCellValue(cell);// 获取表格中客户名称
										break;
									case 2:
										identType = getCellValue(cell);// 获取表格中证件类型
										break;
									case 3:
										identNo = getCellValue(cell);// 获取表格中证件号
										break;
									case 4:
										custType = getCellValue(cell);// 获取表格中客户类型
										break;
									case 5:
										indivOcc = getCellValue(cell);// 获取表格中职业
										break;
									case 6:
										phoneNo = getCellValue(cell);// 获取表格中手机
										break;
									case 7:
										contAddr = getCellValue(cell);// 获取表格中地址
										break;
									case 8:
										workUnit = getCellValue(cell);// 获取表格中工作单位
										break;
									case 9:
										sourceChannel = getCellValue(cell);// 获取表格中来源渠道
										break;
									default:
										break;
									}
									continue;
								}

								// String colData= cells[cellNum].toString();
								switch (cellNum) {
								case 1:
									custName = getCellValue(cell);// 获取表格中客户名称
									break;
								case 2:
									identType = getCellValue(cell);// 获取表格中证件类型
									break;
								case 3:
									identNo = getCellValue(cell);// 获取表格中证件号
									break;
								case 4:
									custType = getCellValue(cell);// 获取表格中客户类型
									break;
								case 5:
									indivOcc = getCellValue(cell);// 获取表格中职业
									break;
								case 6:
									phoneNo = getCellValue(cell);// 获取表格中手机
									break;
								case 7:
									contAddr = getCellValue(cell);// 获取表格中地址
									break;
								case 8:
									workUnit = getCellValue(cell);// 获取表格中工作单位
									break;
								case 9:
									sourceChannel = getCellValue(cell);// 获取表格中来源渠道
									break;
								default:
									break;
								}

							}
							;
							Map<String, String> custAll = new HashMap<>();
							custAll.put("custName", custName);
							custAll.put("certType", identType);
							custAll.put("certNo", identNo);

							if (potentialCustMapper.checkIsCust(custAll) == 0) {
								PotenCustPer potenCustPer = new PotenCustPer();
								potenCustPer.setCustId("P" + potentialCustMapper.getSeq());
								potenCustPer.setBusiType("1");
								potenCustPer.setAddrId(UtilTools.getUUID());
								potenCustPer.setBelongBrch(belongBrch);
								potenCustPer.setBelongId(UtilTools.getUUID());
								potenCustPer.setBelongMgr(belongMgr);
								potenCustPer.setCertNo(identNo);
								potenCustPer.setCertType(identType);
								potenCustPer.setContAddr(contAddr);
								potenCustPer.setContId(UtilTools.getUUID());
								potenCustPer.setCorpOrgCode("001");
								potenCustPer.setCustName(custName);
								potenCustPer.setCustStatus("Q1");
								potenCustPer.setCustType(custType);
								potenCustPer.setIdentId(UtilTools.getUUID());
								potenCustPer.setIndivOcc(indivOcc);
								potenCustPer.setMgrName(mgrName);
								potenCustPer.setOrgName(orgName);
								potenCustPer.setPhoneNo(phoneNo);
								potenCustPer.setSourceChannel(sourceChannel);
								potenCustPer.setWorkUnit(workUnit);
								potenCustPer.setLastUpdateOrg(lastUpdateOrg);
								potenCustPer.setLastUpdateSys(lastUpdateSys);
								potenCustPer.setLastUpdateTm(lastUpdateTm);
								potenCustPer.setLastUpdateUser(lastUpdateUser);
								successNum += potenCustPerService.insertSelective(potenCustPerService.getMapper(),
										potenCustPer);
							} else {
								repeatNum++;
							}

						}
					} else if (topNameOrg) {
						// 获得当前sheet的结束行
						int lastRowNum = sheet.getLastRowNum();
						// 循环除了第一行的所有行
						for (int rowNum = firstRowNum + 1; rowNum <= lastRowNum; rowNum++) {
							// 获得当前行
							count++;
							Row row = sheet.getRow(rowNum);
							if (row == null) {
								continue;
							}
							// 获得当前行的开始列
							int firstCellNum = row.getFirstCellNum();
							// 获得当前行的列数
							int lastCellNum = row.getPhysicalNumberOfCells();
							String[] cells = new String[row.getPhysicalNumberOfCells()];
							// 循环当前行
							String identType = "";
							String identNo = "";
							String custName = "";
							String custType = "";
							String indusCd = "";
							String contAddr = "";
							String contMan = "";
							String contCertType = "";
							String contCertNo = "";
							String contTelNo = "";
							String sourceChannel = "";
							for (int cellNum = firstCellNum; cellNum < headlastCellNum; cellNum++) {
								Cell cell = null;
								try {
									cell = row.getCell(cellNum);
									cells[cellNum] = getCellValue(cell);
								} catch (Exception e) {
									switch (cellNum) {
									case 1:
										custName = getCellValue(cell);// 获取表格中客户名称
										break;
									case 2:
										identType = getCellValue(cell);// 获取表格中证件类型
										break;
									case 3:
										identNo = getCellValue(cell);// 获取表格中证件号
										break;
									case 4:
										custType = getCellValue(cell);// 获取表格中客户类型
										break;
									case 5:
										indusCd = getCellValue(cell);// 获取表格中行业
										break;
									case 6:
										contAddr = getCellValue(cell);// 获取表格中地址
										break;
									case 7:
										contMan = getCellValue(cell);// 获取表格中联系人
										break;
									case 8:
										contCertType = getCellValue(cell);// 获取表格中联系人证件类型
										break;
									case 9:
										contCertNo = getCellValue(cell);// 获取表格中联系人证件号
										break;
									case 10:
										contTelNo = getCellValue(cell);// 获取表格中联系人手机
										break;
									case 11:
										sourceChannel = getCellValue(cell);// 获取表格中来源渠道
										break;
									default:
										break;
									}
									continue;
								}
								switch (cellNum) {
								case 1:
									custName = getCellValue(cell);// 获取表格中客户名称
									break;
								case 2:
									identType = getCellValue(cell);// 获取表格中证件类型
									break;
								case 3:
									identNo = getCellValue(cell);// 获取表格中证件号
									break;
								case 4:
									custType = getCellValue(cell);// 获取表格中客户类型
									break;
								case 5:
									indusCd = getCellValue(cell);// 获取表格中行业
									break;
								case 6:
									contAddr = getCellValue(cell);// 获取表格中地址
									break;
								case 7:
									contMan = getCellValue(cell);// 获取表格中联系人
									break;
								case 8:
									contCertType = getCellValue(cell);// 获取表格中联系人证件类型
									break;
								case 9:
									contCertNo = getCellValue(cell);// 获取表格中联系人证件号
									break;
								case 10:
									contTelNo = getCellValue(cell);// 获取表格中联系人手机
									break;
								case 11:
									sourceChannel = getCellValue(cell);// 获取表格中来源渠道
									break;
								default:
									break;
								}
							}
							;
							Map<String, String> custAll = new HashMap<>();
							custAll.put("custName", custName);
							custAll.put("certType", identType);
							custAll.put("certNo", identNo);

							if (potentialCustMapper.checkIsCust(custAll) == 0) {
								PotenCustOrg potenCustOrg = new PotenCustOrg();
								potenCustOrg.setCustId(potentialCustMapper.getSeq());
								potenCustOrg.setBusiType("2");
								potenCustOrg.setAddrId(UtilTools.getUUID());
								potenCustOrg.setBelongBrch(belongBrch);
								potenCustOrg.setBelongId(UtilTools.getUUID());
								potenCustOrg.setBelongMgr(belongMgr);
								potenCustOrg.setCertNo(identNo);
								potenCustOrg.setCertType(identType);
								potenCustOrg.setRegAddr(contAddr);
								potenCustOrg.setContId(UtilTools.getUUID());
								potenCustOrg.setCorpOrgCode("001");
								potenCustOrg.setCustName(custName);
								potenCustOrg.setCustStatus("Q1");
								potenCustOrg.setCustType(custType);
								potenCustOrg.setIdentId(UtilTools.getUUID());
								potenCustOrg.setMgrName(mgrName);
								potenCustOrg.setOrgName(orgName);
								potenCustOrg.setContCertType(contCertType);
								potenCustOrg.setContCertNo(contCertNo);
								potenCustOrg.setKeyManId(UtilTools.getUUID());
								potenCustOrg.setIndusCd(indusCd);
								potenCustOrg.setSourceChannel(sourceChannel);
								potenCustOrg.setLastUpdateOrg(lastUpdateOrg);
								potenCustOrg.setLastUpdateSys(lastUpdateSys);
								potenCustOrg.setLastUpdateTm(lastUpdateTm);
								potenCustOrg.setLastUpdateUser(lastUpdateUser);
								successNum += potenCustOrgService.insertSelective(potenCustOrgService.getMapper(),
										potenCustOrg);

								Map<String, String> custAllPer = new HashMap<>();
								custAllPer.put("custName", contMan);
								custAllPer.put("certType", contCertType);
								custAllPer.put("certNo", contCertNo);
								if (potentialCustMapper.checkIsCust(custAllPer) == 0) {
									PotenCustPer potenCustPer = new PotenCustPer();
									potenCustPer.setCustId("P" + potentialCustMapper.getSeq());
									potenCustPer.setBusiType("1");
									potenCustPer.setAddrId(UtilTools.getUUID());
									potenCustPer.setBelongBrch(belongBrch);
									potenCustPer.setBelongId(UtilTools.getUUID());
									potenCustPer.setBelongMgr(belongMgr);
									potenCustPer.setCertNo(contCertNo);
									potenCustPer.setCertType(contCertType);
									potenCustPer.setContAddr("");
									potenCustPer.setContId(UtilTools.getUUID());
									potenCustPer.setCorpOrgCode("001");
									potenCustPer.setCustName(contMan);
									potenCustPer.setCustStatus("Q1");
									potenCustPer.setCustType("1");
									potenCustPer.setIdentId(UtilTools.getUUID());
									potenCustPer.setIndivOcc("");
									potenCustPer.setMgrName(mgrName);
									potenCustPer.setOrgName(orgName);
									potenCustPer.setPhoneNo(contTelNo);
									potenCustPer.setSourceChannel(sourceChannel);
									potenCustPer.setWorkUnit("");
									potenCustPer.setLastUpdateOrg(lastUpdateOrg);
									potenCustPer.setLastUpdateSys(lastUpdateSys);
									potenCustPer.setLastUpdateTm(lastUpdateTm);
									potenCustPer.setLastUpdateUser(lastUpdateUser);
									potenCustPerService.insertSelective(potenCustPerService.getMapper(), potenCustPer);
								}

							} else {
								repeatNum++;
							}
						}
					}
					Map<String, String> mapp = new HashMap<>();
					potentialCustMapper.insertPotenCustPer(mapp);
					potentialCustMapper.cleanPotenCustPer();
					potentialCustMapper.insertPotenCustOrg(mapp);
					potentialCustMapper.cleanPotenCustOrg();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("1");
		}

		reMap.put("message", "succese");
		reMap.put("count", count);
		reMap.put("repeatNum", repeatNum);
		reMap.put("successNum", successNum);
		return reMap;
	}

	public static String getCellValue(Cell cell) {
		String cellValue = "";
		if (cell == null) {
			return cellValue;
		}
		// 把数字当成String来读，避免出现1读成1.0的情况
		if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
			cell.setCellType(Cell.CELL_TYPE_STRING);
		}
		// 判断数据的类型
		switch (cell.getCellType()) {
		case Cell.CELL_TYPE_NUMERIC: // 数字
			cellValue = String.valueOf(cell.getNumericCellValue());
			break;
		case Cell.CELL_TYPE_STRING: // 字符串
			cellValue = String.valueOf(cell.getStringCellValue());
			break;
		case Cell.CELL_TYPE_BOOLEAN: // Boolean
			cellValue = String.valueOf(cell.getBooleanCellValue());
			break;
		case Cell.CELL_TYPE_FORMULA: // 公式
			cellValue = String.valueOf(cell.getCellFormula());
			break;
		case Cell.CELL_TYPE_BLANK: // 空值
			cellValue = "";
			break;
		case Cell.CELL_TYPE_ERROR: // 故障
			cellValue = "非法字符";
			break;
		default:
			cellValue = "未知类型";
			break;
		}
		return cellValue;
	}

	public String dataImportOrg(String flag, MultipartFile file) throws Exception {
		int count = 0;
		try {
			// 获得Workbook工作薄对象
			Workbook workbook = getWorkBook(file);
			// 创建返回对象，把每行中的值作为一个数组，所有行作为一个集合返回

			if (workbook != null) {
				for (int sheetNum = 1; sheetNum < workbook.getNumberOfSheets(); sheetNum++) {
					// 获得当前sheet工作表
					Sheet sheet = workbook.getSheetAt(sheetNum);
					String sheetname = workbook.getSheetName(sheetNum);
					if (sheet == null) {
						continue;
					}
					// 获得当前sheet的开始行
					int firstRowNum = sheet.getFirstRowNum();
					String headStr = "";
					Row headrow = sheet.getRow(firstRowNum);
					// 获得表头行的开始列
					int headfirstCellNum = headrow.getFirstCellNum();
					// 获得表头行的列数
					int headlastCellNum = headrow.getPhysicalNumberOfCells();
					String[] headcells = new String[headrow.getPhysicalNumberOfCells()];
					for (int k = headfirstCellNum; k < headlastCellNum; k++) {
						Cell cell = headrow.getCell(k);
						headcells[k] = cell.toString();
					}
					for (int x = 0; x < headcells.length; x++) {
						headStr += "," + headcells[x].toString();
					}
					headStr = headStr.substring(1);
					boolean topName = headStr.equals(
							"序号(ID),客户名称（CUST_NAME）,证件类型（IDENT_TYPE）,证件号码（IDENT_NO）,客户类别（CUST_TYPE）,行业,固定电话(TELEPHONE_NO),联系地址(COMMU_ADDR),联系人（LINKMAN_NAME）,联系人手机号码,客户来源渠道（SOURCE_CHANNEL）,推荐给机构,推荐给客户经理");
					if (!topName) {
						return "表格格式不对，请下载模板填写";
					}
					Map<String, Object> demap = new HashMap<String, Object>();
					demap.put("tabName", sheetname);
					// 获得当前sheet的结束行
					int lastRowNum = sheet.getLastRowNum();
					// 循环除了第一行的所有行
					for (int rowNum = firstRowNum + 1; rowNum <= lastRowNum; rowNum++) {
						// 获得当前行
						String RowData = "";
						Row row = sheet.getRow(rowNum);
						if (row == null) {
							continue;
						}
						// 获得当前行的开始列
						int firstCellNum = row.getFirstCellNum();
						// 获得当前行的列数
						int lastCellNum = row.getPhysicalNumberOfCells();
						String[] cells = new String[row.getPhysicalNumberOfCells()];
						// 循环当前行
						String custId = "";
						String identType = "";
						String identNo = "";
						String custName = "";
						String custType = "";
						String indusCd = "";
						String telPhoneNo = "";
						String contAddr = "";
						String contMan = "";
						String contTelNo = "";
						String sourceChannel = "";
						String belongBrch = "";
						String belongMgr = "";
						for (int cellNum = firstCellNum; cellNum < lastCellNum; cellNum++) {
							Cell cell = row.getCell(cellNum);
							cells[cellNum] = getCellValue(cell);
							String colData = cells[cellNum].toString();
							switch (cellNum) {
							case 0:
								custId = getCellValue(cell);// 获取表格中客户编号
								break;
							case 1:
								custName = getCellValue(cell);// 获取表格中客户名称
								break;
							case 2:
								identType = getCellValue(cell);// 获取表格中证件类型
								break;
							case 3:
								identNo = getCellValue(cell);// 获取表格中证件号
								break;
							case 4:
								custType = getCellValue(cell);// 获取表格中客户类型
								break;
							case 5:
								indusCd = getCellValue(cell);// 获取表格中行业
								break;
							case 6:
								telPhoneNo = getCellValue(cell);// 获取表格中固定电话
								break;
							case 7:
								contAddr = getCellValue(cell);// 获取表格中地址
								break;
							case 8:
								contMan = getCellValue(cell);// 获取表格中联系人
								break;
							case 9:
								contTelNo = getCellValue(cell);// 获取表格中联系人手机
								break;
							case 10:
								sourceChannel = getCellValue(cell);// 获取表格中来源渠道
								break;
							case 11:
								belongBrch = getCellValue(cell);// 获取表格中推荐给机构
								break;
							case 12:
								belongMgr = getCellValue(cell);// 获取表格中推荐给客户经理
								break;
							default:
								break;
							}
						}
						;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("1");
		}
		return "导入成功" + count;
	}

	public Map<String, String> isCustMgr(String userId) {
		// TODO 自动生成的方法存根
		return potentialCustMapper.isCustMgr(userId);
	}

	public Integer delete(String ids, String custType) {
		int result = 0;
		String[] arrIds = {};
		arrIds = ids.split(",");
		if (custType.equals("1")) {
			potentialCustMapper.deleteBelong(arrIds);
			potentialCustMapper.deleteAddr(arrIds);
			potentialCustMapper.deleteIdent(arrIds);
			potentialCustMapper.deleteContact(arrIds);
			potentialCustMapper.deleteCustAll(arrIds);
			result = potentialCustMapper.deletePerAdmit(arrIds);
		} else if (custType.equals("2")) {
			result = potentialCustMapper.deleteBelong(arrIds);
			potentialCustMapper.deleteAddr(arrIds);
			potentialCustMapper.deleteIdent(arrIds);
			potentialCustMapper.deleteContact(arrIds);
			potentialCustMapper.deleteCustAll(arrIds);
			result = potentialCustMapper.deleteOrgAdmit(arrIds);
			potentialCustMapper.deleteKeyMan(arrIds);
		}
		return 0;
	}
}
