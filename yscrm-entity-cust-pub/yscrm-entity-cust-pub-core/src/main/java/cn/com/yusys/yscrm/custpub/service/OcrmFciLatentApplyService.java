package cn.com.yusys.yscrm.custpub.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;

import cn.com.yusys.yusp.admin.web.rest.util.HeaderUtil;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.uaa.client.UaaClient;
import cn.com.yusys.yusp.uaa.client.dto.UserInfoDTO;
import cn.com.yusys.yusp.util.UtilTools;
import cn.com.yusys.yscrm.custpub.domain.OcrmFciBelongHis;
import cn.com.yusys.yscrm.custpub.domain.OcrmFciLatentApply;
import cn.com.yusys.yscrm.custpub.domain.OcrmFciLatentList;
import cn.com.yusys.yscrm.custpub.repository.mapper.OcrmFciLatentApplyMapper;
/**
 * @项目名称: yscrm-entity-cust-pub-core模块
 * @类名称: OcrmFciLatentApplyService
 * @类描述: #服务类
 * @功能描述: 
 * @创建人: hyx
 * @创建时间: 2019-02-14 19:50:23
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class OcrmFciLatentApplyService extends CommonService {
    @Autowired
    private OcrmFciLatentApplyMapper ocrmFciLatentApplyMapper;
    
    @Autowired
    private OcrmFciLatentListService ocrmFciLatentListService;
    
    @Autowired
    private OcrmFciBelongHisService ocrmFciBelongHisService;
    
    @Autowired
    private UaaClient uaaClient;
    
    @Autowired
    private OcrmFciAdmitBelongService ocrmFciAdmitBelongService;
    
    @Autowired
    private OcrmFciNoadmitBelongService ocrmFciNoadmitBelongService;
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
    
    @Override
    protected CommonMapper<?> getMapper() {
        return ocrmFciLatentApplyMapper;
    }
    
    public  UserInfoDTO getUserInfoDTO() {
		ResponseEntity<UserInfoDTO> dto = uaaClient.getUserSessionInfo( HeaderUtil.getAccessToken());
		UserInfoDTO user = dto.getBody();
		return user;
	}
    @Transactional(readOnly = true)
    public List<Map<String, String>> getListByModel(QueryModel model) {
		// TODO 自动生成的方法存根
		PageHelper.startPage(model.getPage(),model.getSize());
		List<Map<String, String>> list = ocrmFciLatentApplyMapper.getListByModel(model);
		PageHelper.clearPage();
		return list;
	}
    @Transactional(readOnly = true)
	public List<Map<String, String>> potentialListByModel(QueryModel model) {
		// TODO 自动生成的方法存根
		PageHelper.startPage(model.getPage(),model.getSize());
		List<Map<String, String>> list = ocrmFciLatentApplyMapper.potentialListByModel(model);
		PageHelper.clearPage();
		return list;
	}
	@Transactional(readOnly = true)
	public List<Map<String, String>> allCustListByModel(QueryModel model) {
		// TODO 自动生成的方法存根
		PageHelper.startPage(model.getPage(),model.getSize());
		List<Map<String, String>> list = ocrmFciLatentApplyMapper.allCustListByModel(model);
		PageHelper.clearPage();
		return list;
	}
	@Transactional(readOnly = false, rollbackFor = {Exception.class, RuntimeException.class})
	public String addAdmit(Map<String, String> map) {
		String[] custIds = map.get("custId").split(",");
		if (custIds == null) {
			return null;
		}
		UserInfoDTO user = getUserInfoDTO();
		String uuid = UtilTools.getUUID();
		String[] custStatus = map.get("custStatus").split(",");
		String custType = map.get("custType");
		String manType = map.get("manType");
		String[] oldMgrIds = map.get("oldMgrId").split(","); 
		String[] oldMgrNames = map.get("oldMgrName").split(","); 
		String oldOrgId = map.get("oldOrgId");
		String oldOrgName = map.get("oldOrgName");
		String applyReason = map.get("applyReason");
		Date date = new Date();
		String userId = user.getUserId();
		String orgCode = user.getOrg().getCode();
		String orgName = user.getOrg().getName();
		String userName = user.getUserName();
		OcrmFciLatentApply apply = new OcrmFciLatentApply();
		apply.setApplyId(uuid);
		apply.setCorpOrgCode("001");
		apply.setApplyUser(user.getUserId());
		apply.setApplyUsername(user.getUserName());
		apply.setApplyInit(user.getOrg().getCode());
		apply.setApplyInitname(user.getOrg().getName());
		apply.setCreateDate(date);
		apply.setApplyReason(applyReason);
		apply.setDeadLine("99999999");
		insertSelective(getMapper(),apply);
		for (int i = 0; i < custIds.length; i++) {
			String custId = custIds[i];
			String listId = UtilTools.getUUID();
			OcrmFciLatentList list = new OcrmFciLatentList();
			list.setApplyId(uuid);
			list.setCustId(custId);
			list.setCustType(custType);
			list.setManType(manType);
			list.setOldMgrId(oldMgrIds[i]);
			list.setOldMgrName(oldMgrNames[i]);
			list.setOldOrgId(oldOrgId);
			list.setOldOrgName(oldOrgName);
			list.setListId(listId);
			if (manType.equals("2")) {
				Map<String, String> belong = new HashMap<>();
					belong.put("custId", custId);
					belong.put("orgId", orgCode);
					belong.put("mgrId", userId);
					belong.put("orgName", orgName);
					belong.put("mgrName", userName);
					belong.put("mgrType", manType);
					if (!oldOrgId.equals(orgCode)) {
						belong.put("orgType", "2");
				}else {
					belong.put("orgType", "1");
				}
					ocrmFciAdmitBelongService.claimAdd(belong);
			}else {
				Map<String, String> record = new HashMap<>();
				if (custStatus[i].equals("Q1")) {
					record.put("custStatus", "Q2");
				}else {
					record.put("custStatus", custStatus[i]);
				}
				record.put("custId", custId);
				record.put("belongMgr", userId);
				record.put("belongBrch", orgCode);
				if (custType.equals("1")) {
					acrmFciCustAdmitAllService.updateBelong(record);
					acrmFciPerCustService.updateBelong(record);
					acrmFciPerAdmitInfoService.updateBelong(record);
				}else {
					acrmFciCustAdmitAllService.updateBelong(record);
					acrmFciOrgCustInfoService.updateBelong(record);
				}	
				
				if (!oldOrgId.equals(orgCode)) {
						ocrmFciAdmitBelongService.updateHost(custId,oldMgrIds[i],oldOrgId);
				}else {
						ocrmFciAdmitBelongService.delBelongByCustIdMgrIdOrgId(custId,oldMgrIds[i],oldOrgId);
				}
				Map<String, String> belong = new HashMap<>();
				belong.put("custId", custId);
				belong.put("orgId", orgCode);
				belong.put("mgrId", userId);
				belong.put("orgName", orgName);
				belong.put("mgrName", userName);
				belong.put("mgrType", "1");
				belong.put("orgType", "1");
				ocrmFciAdmitBelongService.claimAdd(belong);
				
			OcrmFciBelongHis ocrmFciBelongHis = new OcrmFciBelongHis();
			ocrmFciBelongHis.setHisId(listId);
			ocrmFciBelongHis.setLastUpdateSys(user.getLogicSys().getId());
			ocrmFciBelongHis.setLastUpdateOrg(user.getOrg().getCode());
			ocrmFciBelongHis.setLastUpdateTm(date);
			ocrmFciBelongHis.setLastUpdateUser(user.getUserId());
			ocrmFciBelongHis.setCorpOrgCode("001");
			ocrmFciBelongHis.setCustId(custId);
			ocrmFciBelongHis.setOrgType(map.get("manType"));
			ocrmFciBelongHis.setOrgId(user.getOrg().getCode());
			ocrmFciBelongHis.setOrgName(user.getOrg().getName());
			ocrmFciBelongHis.setMgrType(map.get("manType"));
			ocrmFciBelongHis.setMgrId(user.getUserId());
			ocrmFciBelongHis.setMgrName(user.getUserName());
			ocrmFciBelongHis.setOrgTypePre("1");
			ocrmFciBelongHis.setOrgIdPre(oldOrgId);
			ocrmFciBelongHis.setOrgNamePre(oldOrgName);
			ocrmFciBelongHis.setMgrTypePre("1");
			ocrmFciBelongHis.setMgrIdPre(oldMgrIds[i]);
			ocrmFciBelongHis.setMgrNamePre(oldMgrNames[i]);
			ocrmFciBelongHis.setAssignUser(user.getUserId());
			ocrmFciBelongHis.setAssignDate(date);
			ocrmFciBelongHis.setWorkTranReason(applyReason);
			ocrmFciBelongHis.setWorkTranDate(date);
			ocrmFciBelongHisService.insertSelective(ocrmFciBelongHisService.getMapper(), ocrmFciBelongHis);
			ocrmFciLatentListService.insertSelective(ocrmFciLatentListService.getMapper(),list);
		}
		}
		return uuid;
	}
	@Transactional(readOnly = false, rollbackFor = {Exception.class, RuntimeException.class})
	public String addFor(Map<String, String> map) {
		String[] custIds = map.get("custId").split(",");
		String custType = map.get("custType");
		String[] oldMgrIds = map.get("oldMgrId").split(",");
		String[] oldMgrNames = map.get("oldMgrName").split(",");
		String oldOrgId = map.get("oldOrgId");
		String oldOrgName = map.get("oldOrgName");
		String applyReason = map.get("applyReason");
		Date date = new Date();
		if (custIds == null) {
			return null;
		}
		String uuid = UtilTools.getUUID();
		UserInfoDTO user = getUserInfoDTO();
		OcrmFciLatentApply apply = new OcrmFciLatentApply();
		apply.setApplyId(uuid);
		apply.setCorpOrgCode("001");
		apply.setApplyUser(user.getUserId());
		apply.setApplyUsername(user.getUserName());
		apply.setApplyInit(user.getOrg().getCode());
		apply.setApplyInitname(user.getOrg().getName());
		apply.setCreateDate(date);
		apply.setApplyReason(applyReason);
		apply.setApprovelStatus("0");
		apply.setDeadLine(map.get("deadLine"));
		insertSelective(getMapper(),apply);
		for (int i = 0; i < custIds.length; i++) {
			String custId = custIds[i];
			String listId = UtilTools.getUUID();
			OcrmFciLatentList list = new OcrmFciLatentList();
			list.setApplyId(uuid);
			list.setCustId(custId);
			list.setCustType(custType);
			list.setManType("1");
			list.setOldMgrId(oldMgrIds[i]);
			list.setOldMgrName(oldMgrNames[i]);
			list.setOldOrgId(oldOrgId);
			list.setOldOrgName(oldOrgName);
			list.setListId(listId);
//			OcrmFciBelongHis ocrmFciBelongHis = new OcrmFciBelongHis();
//			ocrmFciBelongHis.setHisId(listId);
//			ocrmFciBelongHis.setLastUpdateSys(user.getLogicSys().getId());
//			ocrmFciBelongHis.setLastUpdateOrg(user.getOrg().getCode());
//			ocrmFciBelongHis.setLastUpdateTm(date);
//			ocrmFciBelongHis.setLastUpdateUser(user.getUserId());
//			ocrmFciBelongHis.setCorpOrgCode("001");
//			ocrmFciBelongHis.setCustId(custId);
//			ocrmFciBelongHis.setOrgType(orgTypes[i]);
//			ocrmFciBelongHis.setOrgId(user.getOrg().getCode());
//			ocrmFciBelongHis.setOrgName(user.getOrg().getName());
//			ocrmFciBelongHis.setMgrType(map.get("manType"));
//			ocrmFciBelongHis.setMgrId(user.getUserId());
//			ocrmFciBelongHis.setMgrName(user.getUserName());
//			ocrmFciBelongHis.setOrgTypePre(orgTypes[i]);
//			ocrmFciBelongHis.setOrgIdPre(oldOrgId);
//			ocrmFciBelongHis.setOrgNamePre(oldOrgName);
//			ocrmFciBelongHis.setMgrTypePre(mgrTypes[i]);
//			ocrmFciBelongHis.setMgrIdPre(oldMgrIds[i]);
//			ocrmFciBelongHis.setMgrNamePre(oldMgrNames[i]);
//			ocrmFciBelongHis.setAssignUser(user.getUserId());
//			ocrmFciBelongHis.setAssignDate(date);
//			ocrmFciBelongHis.setWorkTranReason(applyReason);
//			ocrmFciBelongHis.setWorkTranLevel("");
//			ocrmFciBelongHis.setWorkTranDate(date);
//			ocrmFciBelongHisService.insertSelective(ocrmFciBelongHisService.getMapper(), ocrmFciBelongHis);
			ocrmFciLatentListService.insertSelective(ocrmFciLatentListService.getMapper(),list);
		}
		return uuid;
	}
	 @Transactional(readOnly = false, rollbackFor = {Exception.class, RuntimeException.class})
	public String addNoFor(Map<String, String> map) {
		String[] custIds = map.get("custId").split(",");
		String[] custTypes = map.get("custType").split(",");
		String[] oldMgrIds = map.get("oldMgrId").split(",");
		String[] oldMgrNames = map.get("oldMgrName").split(",");
//		String[] orgTypes = map.get("orgType").split(",");
//		String[] mgrTypes = map.get("mgrType").split(",");
		String manType =map.get("manType");
		String oldOrgId = map.get("oldOrgId");
		String oldOrgName = map.get("oldOrgName");
		String applyReason = map.get("applyReason");
		Date date = new Date();
		if (custIds == null) {
			return "";
		}
		String uuid = UtilTools.getUUID();
		UserInfoDTO user = getUserInfoDTO();
		OcrmFciLatentApply apply = new OcrmFciLatentApply();
		
		apply.setApplyId(uuid);
		apply.setCorpOrgCode("001");
		apply.setApplyUser(user.getUserId());
		apply.setApplyUsername(user.getUserName());
		apply.setApplyInit(user.getOrg().getCode());
		apply.setApplyInitname(user.getOrg().getName());
		apply.setCreateDate(date);
		apply.setApplyReason(applyReason);
		apply.setApprovelStatus("0");
		apply.setDeadLine(map.get("deadLine"));
		insertSelective(getMapper(),apply);
		for (int i = 0; i < custIds.length; i++) {
			String custId = custIds[i];
			String listId = UtilTools.getUUID();
			OcrmFciLatentList list = new OcrmFciLatentList();
			list.setApplyId(uuid);
			list.setListId(listId);
			list.setCustId(custId);
			list.setCustType(custTypes[i]);
			list.setManType(manType);
			list.setOldMgrId(oldMgrIds[i]);
			list.setOldMgrName(oldMgrNames[i]);
			list.setOldOrgId(oldOrgId);
			list.setOldOrgName(oldOrgName);
//			OcrmFciBelongHis ocrmFciBelongHis = new OcrmFciBelongHis();
//			ocrmFciBelongHis.setHisId(listId);
//			ocrmFciBelongHis.setLastUpdateSys(user.getLogicSys().getId());
//			ocrmFciBelongHis.setLastUpdateOrg(user.getOrg().getCode());
//			ocrmFciBelongHis.setLastUpdateTm(date);
//			ocrmFciBelongHis.setLastUpdateUser(user.getUserId());
//			ocrmFciBelongHis.setCorpOrgCode("001");
//			ocrmFciBelongHis.setCustId(custId);
//			ocrmFciBelongHis.setOrgType(orgTypes[i]);
//			ocrmFciBelongHis.setOrgId(user.getOrg().getCode());
//			ocrmFciBelongHis.setOrgName(user.getOrg().getName());
//			ocrmFciBelongHis.setMgrType(map.get("manType"));
//			ocrmFciBelongHis.setMgrId(user.getUserId());
//			ocrmFciBelongHis.setMgrName(user.getUserName());
//			ocrmFciBelongHis.setOrgTypePre(orgTypes[i]);
//			ocrmFciBelongHis.setOrgIdPre(oldOrgId);
//			ocrmFciBelongHis.setOrgNamePre(oldOrgName);
//			ocrmFciBelongHis.setMgrTypePre(mgrTypes[i]);
//			ocrmFciBelongHis.setMgrIdPre(oldMgrIds[i]);
//			ocrmFciBelongHis.setMgrNamePre(oldMgrNames[i]);
//			ocrmFciBelongHis.setAssignUser(user.getUserId());
//			ocrmFciBelongHis.setAssignDate(date);
//			ocrmFciBelongHis.setWorkTranReason(applyReason);
//			ocrmFciBelongHis.setWorkTranLevel("");
//			ocrmFciBelongHis.setWorkTranDate(date);
//			ocrmFciBelongHisService.insertSelective(ocrmFciBelongHisService.getMapper(), ocrmFciBelongHis);
			ocrmFciLatentListService.insertSelective(list);
		}
		return uuid;
	}
	 @Transactional(readOnly = true)
	public List<Map<String, String>> potNoForList(QueryModel model) {
		// TODO 自动生成的方法存根
		PageHelper.startPage(model.getPage(),model.getSize());
		List<Map<String, String>> list = ocrmFciLatentApplyMapper.potNoForList(model);
		PageHelper.clearPage();
		return list;
	}
	 @Transactional(readOnly = true)
	public List<Map<String, String>> noPotNoForList(QueryModel model) {
		// TODO 自动生成的方法存根
		PageHelper.startPage(model.getPage(),model.getSize());
		List<Map<String, String>> list = ocrmFciLatentApplyMapper.noPotNoForList(model);
		PageHelper.clearPage();
		return list;
	}
	 @Transactional(readOnly = true)
	public List<Map<String, String>> potForList(QueryModel model) {
		// TODO 自动生成的方法存根
		PageHelper.startPage(model.getPage(),model.getSize());
		List<Map<String, String>> list = ocrmFciLatentApplyMapper.potForList(model);
		PageHelper.clearPage();
		return list;
	}
	 @Transactional(readOnly = true)
	public List<Map<String, String>> noPotForList(QueryModel model) {
		// TODO 自动生成的方法存根
		PageHelper.startPage(model.getPage(),model.getSize());
		List<Map<String, String>> list = ocrmFciLatentApplyMapper.noPotForList(model);
		PageHelper.clearPage();
		return list;
	}
	 @Transactional(readOnly = true)
	public List<Map<String, String>> getClaimInfo(QueryModel model) {
		// TODO 自动生成的方法存根
		String applyId = (String) model.getCondition().get("applyId");
		return ocrmFciLatentApplyMapper.getClaimInfo(applyId);
	}
	 @Transactional(readOnly = true)
	public List<Map<String, String>> getClaimInfo(String bizSeqNo) {
		// TODO 自动生成的方法存根
		return ocrmFciLatentApplyMapper.getClaimInfo(bizSeqNo);
	}
	 @Transactional(readOnly = false, rollbackFor = {Exception.class, RuntimeException.class})
	public int updClaimApproval(QueryModel model) {
		// TODO 自动生成的方法存根
		String applyId = (String) model.getCondition().get("applyId");
		Map<String, String> map = new HashMap<>();
		map.put("status", "1");
		map.put("applyId", applyId);
		return ocrmFciLatentApplyMapper.updClaimApproval(map);
	}
	 @Transactional(readOnly = false, rollbackFor = {Exception.class, RuntimeException.class})
	public String addNoAdmit(Map<String, String> map) {
		// TODO 自动生成的方法存根
		String custId = map.get("custId");
		if (custId == null) {
			return null;
		}
		UserInfoDTO user = getUserInfoDTO();
		String uuid = UtilTools.getUUID();
		String custStatus = map.get("custStatus");
		String custType = map.get("custType");
		String manType = "1";
		String oldMgrIds = map.get("belongMgr"); 
		String oldMgrNames = map.get("mgrName"); 
		String oldOrgId = map.get("belongBrch");
		String oldOrgName = map.get("orgName");
		String applyReason = map.get("applyReason");
		Date date = new Date();
		String userId = user.getUserId();
		String orgCode = user.getOrg().getCode();
		String orgName = user.getOrg().getName();
		String userName = user.getUserName();
		OcrmFciLatentApply apply = new OcrmFciLatentApply();
		apply.setApplyId(uuid);
		apply.setCorpOrgCode("001");
		apply.setApplyUser(user.getUserId());
		apply.setApplyUsername(user.getUserName());
		apply.setApplyInit(user.getOrg().getCode());
		apply.setApplyInitname(user.getOrg().getName());
		apply.setCreateDate(date);
		apply.setApplyReason(applyReason);
		apply.setDeadLine("40");
		insertSelective(getMapper(),apply);
			String listId = UtilTools.getUUID();
			OcrmFciLatentList list = new OcrmFciLatentList();
			list.setApplyId(uuid);
			list.setCustId(custId);
			list.setCustType(custType);
			list.setManType(manType);
			list.setOldMgrId(oldMgrIds);
			list.setOldMgrName(oldMgrNames);
			list.setOldOrgId(oldOrgId);
			list.setOldOrgName(oldOrgName);
			list.setListId(listId);
				Map<String, String> record = new HashMap<>();
				record.put("custStatus", custStatus);
				record.put("custId", custId);
				record.put("belongMgr", userId);
				record.put("belongBrch", orgCode);
				if (custType.equals("1")) {
					acrmFciPerCustService.updateBelong(record);
				}else {
					acrmFciOrgCustInfoService.updateBelong(record);
				}	
				if (!oldOrgId.equals(orgCode)) {
					ocrmFciNoadmitBelongService.updateHost(custId,oldMgrIds,oldOrgId);
			}else {
				ocrmFciNoadmitBelongService.delBelongByCustIdMgrIdOrgId(custId,oldMgrIds,oldOrgId);
			}
			Map<String, String> belong = new HashMap<>();
			belong.put("custId", custId);
			belong.put("orgId", orgCode);
			belong.put("mgrId", userId);
			belong.put("orgName", orgName);
			belong.put("mgrName", userName);
			belong.put("mgrType", "1");
			belong.put("orgType", "1");
			ocrmFciNoadmitBelongService.claimAdd(belong);	
			OcrmFciBelongHis ocrmFciBelongHis = new OcrmFciBelongHis();
			ocrmFciBelongHis.setHisId(listId);
			ocrmFciBelongHis.setLastUpdateSys(user.getLogicSys().getId());
			ocrmFciBelongHis.setLastUpdateOrg(user.getOrg().getCode());
			ocrmFciBelongHis.setLastUpdateTm(date);
			ocrmFciBelongHis.setLastUpdateUser(user.getUserId());
			ocrmFciBelongHis.setCorpOrgCode("001");
			ocrmFciBelongHis.setCustId(custId);
			ocrmFciBelongHis.setOrgType(map.get("manType"));
			ocrmFciBelongHis.setOrgId(user.getOrg().getCode());
			ocrmFciBelongHis.setOrgName(user.getOrg().getName());
			ocrmFciBelongHis.setMgrType(map.get("manType"));
			ocrmFciBelongHis.setMgrId(user.getUserId());
			ocrmFciBelongHis.setMgrName(user.getUserName());
			ocrmFciBelongHis.setOrgTypePre("1");
			ocrmFciBelongHis.setOrgIdPre(oldOrgId);
			ocrmFciBelongHis.setOrgNamePre(oldOrgName);
			ocrmFciBelongHis.setMgrTypePre("1");
			ocrmFciBelongHis.setMgrIdPre(oldMgrIds);
			ocrmFciBelongHis.setMgrNamePre(oldMgrNames);
			ocrmFciBelongHis.setAssignUser(user.getUserId());
			ocrmFciBelongHis.setAssignDate(date);
			ocrmFciBelongHis.setWorkTranReason(applyReason);
			ocrmFciBelongHis.setWorkTranDate(date);
			ocrmFciBelongHisService.insertSelective(ocrmFciBelongHisService.getMapper(), ocrmFciBelongHis);
			ocrmFciLatentListService.insertSelective(ocrmFciLatentListService.getMapper(),list);
		return uuid;
	}

}
