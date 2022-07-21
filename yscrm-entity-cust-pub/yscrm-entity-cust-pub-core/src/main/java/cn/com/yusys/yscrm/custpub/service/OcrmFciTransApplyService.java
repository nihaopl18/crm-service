package cn.com.yusys.yscrm.custpub.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import cn.com.yusys.yusp.admin.web.rest.util.HeaderUtil;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yusp.uaa.client.UaaClient;
import cn.com.yusys.yusp.uaa.client.dto.UserInfoDTO;
import cn.com.yusys.yusp.util.UtilTools;
import cn.com.yusys.yscrm.custpub.domain.OcrmFciBelongHis;
import cn.com.yusys.yscrm.custpub.domain.OcrmFciTransApply;
import cn.com.yusys.yscrm.custpub.domain.OcrmFciTransCustList;
import cn.com.yusys.yscrm.custpub.repository.mapper.OcrmFciLatentApplyMapper;
import cn.com.yusys.yscrm.custpub.repository.mapper.OcrmFciTransApplyMapper;
/**
 * @项目名称: yscrm-entity-cust-pub-core模块
 * @类名称: OcrmFciTransApplyService
 * @类描述: #服务类
 * @功能描述: 
 * @创建人: hyx
 * @创建时间: 2019-02-15 10:38:03
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class OcrmFciTransApplyService extends CommonService {
    @Autowired
    private OcrmFciTransApplyMapper ocrmFciTransApplyMapper;
    
    @Autowired
    private OcrmFciTransCustListService ocrmFciTransCustListService;
    
    
    @Autowired
    private OcrmFciLatentApplyMapper ocrmFciLatentApplyMapper;
    
    @Autowired
    private UaaClient uaaClient;
    @Override
    protected CommonMapper<?> getMapper() {
        return this.ocrmFciTransApplyMapper;
    }

    public  UserInfoDTO getUserInfoDTO() {
		ResponseEntity<UserInfoDTO> dto = uaaClient.getUserSessionInfo( HeaderUtil.getAccessToken());
		UserInfoDTO user = dto.getBody();
		return user;
	}
	public List<Map<String, String>> getListByModel(QueryModel model) {
		// TODO 自动生成的方法存根
		PageHelper.startPage(model.getPage(),model.getSize());
		List<Map<String, String>> list = ocrmFciTransApplyMapper.getListByModel(model);
		PageHelper.clearPage();
		return list;
	}

	public List<Map<String, String>> myCustListByModel(QueryModel model) {
		// TODO 自动生成的方法存根
		PageHelper.startPage(model.getPage(),model.getSize());
		List<Map<String, String>> list = ocrmFciTransApplyMapper.myCustListByModel(model);
		PageHelper.clearPage();
		return list;
	}

	public List<Map<String, String>> OuterCustListByModel(QueryModel model) {
		// TODO 自动生成的方法存根
		 String orgId = (String) model.getCondition().get("orgId");
		 Map<String, String> orgInfo = ocrmFciLatentApplyMapper.getOrgLevel(orgId);
		 int num =  Integer.parseInt(orgInfo.get("orgLevel"));
		 String sql = "SELECT ORG_CODE FROM ADMIN_SM_ORG WHERE ORG_CODE = ";
		 if (num > 2) {
			 
			 for (int i = 0; i < num - 2; i++) {
				 if (i == num - 3) {
					 sql += "( SELECT UP_ORG_ID FROM ADMIN_SM_ORG WHERE ORG_CODE =\'" + orgId +"\'";
					}else {
						sql += "( SELECT UP_ORG_ID FROM ADMIN_SM_ORG WHERE ORG_CODE =";
					}
				}
			 for (int i = 0; i < num - 2; i++) {
					sql += ")";
				}
		}else {
			sql += "\'" + orgId +"\'";
		}
		model.getCondition().put("orgInfo", sql);
		PageHelper.startPage(model.getPage(),model.getSize());
		List<Map<String, String>> list = ocrmFciTransApplyMapper.OuterCustListByModel(model);
		PageHelper.clearPage();
		return list;
	}
	
	public List<Map<String, String>> InnerCustListByModel(QueryModel model) {
		// TODO 自动生成的方法存根
		 String orgId = (String) model.getCondition().get("orgId");
		 Map<String, String> orgInfo = ocrmFciLatentApplyMapper.getOrgLevel(orgId);
		 int num =  Integer.parseInt(orgInfo.get("orgLevel"));
		 String sql = "SELECT ORG_CODE FROM ADMIN_SM_ORG WHERE ORG_CODE = ";
		 if (num > 2) {
			 
			 for (int i = 0; i < num - 2; i++) {
				 if (i == num - 3) {
					 sql += "( SELECT UP_ORG_ID FROM ADMIN_SM_ORG WHERE ORG_CODE =\'" + orgId +"\'";
					}else {
						sql += "( SELECT UP_ORG_ID FROM ADMIN_SM_ORG WHERE ORG_CODE =";
					}
				}
			 for (int i = 0; i < num - 2; i++) {
					sql += ")";
				}
		}else {
			sql += "\'" + orgId +"\'";
		}
		model.getCondition().put("orgInfo", sql);
		PageHelper.startPage(model.getPage(),model.getSize());
		List<Map<String, String>> list = ocrmFciTransApplyMapper.InnerCustListByModel(model);
		PageHelper.clearPage();
		return list;
	}

	public String addPassive(Map<String, String> map) {
		// TODO 自动生成的方法存根
		UserInfoDTO user = getUserInfoDTO();
		String[] custIds = map.get("custId").split(",");
		String[] custNames = map.get("custName").split(",");
		String[] custTypes = map.get("custType").split(",");
		String[] mgrIds = map.get("mgrId").split(",");
		String[] orgIds = map.get("orgId").split(",");
		String tMgrId = user.getUserId();
		String tMgrName = user.getUserName();
		String tOrgId = user.getOrg().getCode();
		String tOrgName =user.getOrg().getName();
		String handOverReason = map.get("handOverReason");
		String uuid = UtilTools.getUUID();
		OcrmFciTransApply apply = new OcrmFciTransApply();
		
		apply.setApplyNo(uuid);
		apply.setCorpOrgCode("001");
		apply.setUserId(user.getUserId());
		apply.setUserName(user.getUserName());
		apply.setTmgrId(tMgrId);
		apply.setTmgrName(tMgrName);
		apply.setTorgId(tOrgId);
		apply.setTorgName(tOrgName);
		apply.setApplyDate(new Date());
		apply.setApproveStat("0");
		apply.setHandOverReason(handOverReason);
		insertSelective(getMapper(), apply);
		if (custIds == null) {
			return "";
		}
		for (int i = 0; i < custTypes.length; i++) {
			String custType = custTypes[i];
			String listId = UtilTools.getUUID();
			if (custType.equals("1")) {
				Map<String, String> perCust = null;
				Map<String, String> pcust = new HashMap<String, String>();
				pcust.put("custId", custIds[i]);
				pcust.put("mgrId", mgrIds[i]);
				pcust.put("orgId", orgIds[i]);
				try {
					perCust = ocrmFciTransApplyMapper.getPerCustByCustId(pcust);
				} catch (Exception e) {
					// TODO: handle exception
					continue;
				}
				OcrmFciTransCustList list = new OcrmFciTransCustList();
				list.setId(listId);
				list.setApplyNo(uuid);
				list.setCustId(custIds[i]);
				list.setCustName(custNames[i]);
				list.setMgrId(perCust.get("mgrId"));
				list.setMgrName(perCust.get("mgrName"));
				list.setInstitution(perCust.get("orgId"));
				list.setInstitutionName(perCust.get("orgName"));
				list.setMainType(perCust.get("mgrType"));
				list.setMainTypeNew(perCust.get("mgrType"));
				list.setIsSmall("0");
				list.setIsGroup("0");
				list.setIsWages(perCust.get("payrollFlg"));
				list.setIsOnlineBank(perCust.get("internetBankFlag"));
				list.setIsLoan(perCust.get("isLoanCust"));
				ocrmFciTransCustListService.insertSelective(ocrmFciTransCustListService.getMapper(), list);
			}else if (custType.equals("2")){
				Map<String, String> orgCust = null;
				Map<String, String> ocust = new HashMap<String, String>();
				ocust.put("custId", custIds[i]);
				ocust.put("mgrId", mgrIds[i]);
				ocust.put("orgId", orgIds[i]);
//				try {
					orgCust = ocrmFciTransApplyMapper.getOrgCustByCustId(ocust);
//				} catch (Exception e) {
//					// TODO: handle exception
//					continue;
//				}
				
				OcrmFciTransCustList list = new OcrmFciTransCustList();
				list.setId(listId);
				list.setApplyNo(uuid);
				list.setCustId(custIds[i]);
				list.setCustName(custNames[i]);
				list.setMgrId(orgCust.get("mgrId"));
				list.setMgrName(orgCust.get("mgrName"));
				list.setInstitution(orgCust.get("orgId"));
				list.setMainType(orgCust.get("mgrType"));
				list.setInstitutionName(orgCust.get("orgName"));
				list.setMainTypeNew(orgCust.get("mgrType"));
				list.setIsSmall(orgCust.get("isSmall"));
				list.setIsGroup(orgCust.get("isGroup"));
				list.setIsWages(orgCust.get("isWages"));
				list.setIsOnlineBank(orgCust.get("isOnlineBank"));
				list.setIsLoan(orgCust.get("isLoan"));
				ocrmFciTransCustListService.insertSelective(ocrmFciTransCustListService.getMapper(), list);
			}
		}
		return uuid;
	}

	public List<Map<String, String>> transferInfo(QueryModel model) {
		return ocrmFciTransApplyMapper.transferInfo(model);
	}

	public String addActive(Map<String, String> map) {
		// TODO 自动生成的方法存根
		UserInfoDTO user = getUserInfoDTO();
		String[] custIds = map.get("custId").split(",");
		String[] custNames = map.get("custName").split(",");
		String[] custTypes = map.get("custType").split(",");
		String handOverReason = map.get("handOverReason");
		String tMgrId = map.get("tMgrId");
		String tMgrName = map.get("tMgrName");
		String tOrgId = map.get("tOrgId");
		String tMgrType = map.get("tMgrType");
		String tOrgName = map.get("tOrgName");
		Date date = new Date();
//		String[] applyType = map.get("applyType").split(",");
//		String uuid = UtilTools.getUUID();
		String uuid = map.get("uuid");
		if(uuid==null||uuid.equals("")) {
			uuid = UtilTools.getUUID();
		}
		OcrmFciTransApply apply = new OcrmFciTransApply();
		apply.setApplyNo(uuid);
		apply.setCorpOrgCode("001");
		apply.setUserId(user.getUserId());
		apply.setUserName(user.getUserName());
		apply.setTmgrId(tMgrId);
		apply.setTmgrName(tMgrName);
		apply.setTorgId(tOrgId);
		apply.setTorgName(tOrgName);
//		apply.setApplyType(applyType[i]);
		apply.setApplyDate(date);
		apply.setWorkInterfixDt(new Date());
		apply.setHandOverReason(handOverReason);
		apply.setApproveStat("1");
		insertSelective(getMapper(), apply);
		if (custIds == null) {
			return "";
		}
		for (int i = 0; i < custTypes.length; i++) {
			String custType = custTypes[i];
			String custId = custIds[i];
			String listId = UtilTools.getUUID();
			Map<String, String> perCust = null;
			if (custType.equals("1")) {
//				try {
				Map<String, String> mapPer = new  HashMap<String, String>();
				mapPer.put("custId", custId);
				mapPer.put("userId", user.getUserId());
					perCust = ocrmFciTransApplyMapper.getMyPerCustByCustId(mapPer);
//				} catch (Exception e) {
//					// TODO: handle exception
//					continue;
//				}
				OcrmFciTransCustList list = new OcrmFciTransCustList();
				list.setId(listId);
				list.setApplyNo(uuid);
				list.setCustId(custId);
				list.setCustName(custNames[i]);
				list.setMgrId(perCust.get("mgrId"));
				list.setMgrName(perCust.get("mgrName"));
				list.setInstitution(perCust.get("orgId"));
				list.setInstitutionName(perCust.get("orgName"));
				list.setMainType(perCust.get("mgrType"));
				list.setMainTypeNew(tMgrType);
				list.setIsSmall("0");
				list.setIsGroup("0");
				list.setIsWages(perCust.get("payrollFlg"));
				list.setIsOnlineBank(perCust.get("internetBankFlag"));
				list.setIsLoan(perCust.get("isLoanCust"));
				ocrmFciTransCustListService.insertSelective(ocrmFciTransCustListService.getMapper(), list);
				
			}else if (custType.equals("2")){
				Map<String, String> mapOrg = new  HashMap<String, String>();
				mapOrg.put("custId", custId);
				mapOrg.put("userId", user.getUserId());
				Map<String, String> orgCust = ocrmFciTransApplyMapper.getMyOrgCustByCustId(mapOrg);
				OcrmFciTransCustList list = new OcrmFciTransCustList();
				list.setId(listId);
				list.setApplyNo(uuid);
				list.setCustId(orgCust.get("custId"));
				list.setCustName(custNames[i]);
				list.setMgrId(orgCust.get("mgrId"));
				list.setMgrName(orgCust.get("mgrName"));
				list.setInstitution(orgCust.get("orgId"));
				list.setInstitutionName(orgCust.get("orgName"));
				list.setMainType(orgCust.get("mgrType"));
				list.setMainTypeNew(tMgrType);
				list.setIsSmall(orgCust.get("miniComFlg"));
				list.setIsGroup(orgCust.get("groupCustFlg"));
				list.setIsWages("0");
				list.setIsOnlineBank("0");
				list.setIsLoan("0");
				ocrmFciTransCustListService.insertSelective(ocrmFciTransCustListService.getMapper(), list);
			}
		}
		return uuid;
	}

	public List<Map<String, String>> getTransInfo(String bizSeqNo) {
		// TODO 自动生成的方法存根
		return ocrmFciTransApplyMapper.getTransInfo(bizSeqNo);
	}

	public int updTransferApproval(QueryModel model) {
		// TODO 自动生成的方法存根
		Map<String, String> map = new HashMap<>();
		String applyNo = (String) model.getCondition().get("applyNo");
		map.put("status", "1");
		map.put("applyNo", applyNo);
		return ocrmFciTransApplyMapper.updTransferApproval(map);
	}
	public int isLevel(Map<String, String> map) {
		String myOrgId = map.get("myOrgId");
		 Map<String, String> orgInfo = ocrmFciLatentApplyMapper.getOrgLevel(myOrgId);
		 int myOrgIdnum =  Integer.parseInt(orgInfo.get("orgLevel"));
		 String orgIdsql = "SELECT ORG_CODE FROM ADMIN_SM_ORG WHERE ORG_CODE = ";
		 if (myOrgIdnum > 3) {
			 
			 for (int i = 0; i < myOrgIdnum - 3; i++) {
				 if (i == myOrgIdnum - 4) {
					 orgIdsql += "( SELECT UP_ORG_ID FROM ADMIN_SM_ORG WHERE ORG_CODE =\'" + myOrgId +"\'";
					}else {
						orgIdsql += "( SELECT UP_ORG_ID FROM ADMIN_SM_ORG WHERE ORG_CODE =";
					}
				}
			 for (int i = 0; i < myOrgIdnum - 3; i++) {
				 orgIdsql += ")";
				}
		}else {
			orgIdsql += "\'" + myOrgId +"\'";
		}
		 
		 String orgId = map.get("orgId");
		 Map<String, String> orgIdInfo = ocrmFciLatentApplyMapper.getOrgLevel(orgId);
		 int orgIdnum =  Integer.parseInt(orgIdInfo.get("orgLevel"));
		 String torgIdsql = "SELECT ORG_CODE FROM ADMIN_SM_ORG WHERE ORG_CODE = ";
		 if (orgIdnum > 3) {
			 
			 for (int i = 0; i < orgIdnum - 3; i++) {
				 if (i == orgIdnum - 4) {
					 torgIdsql += "( SELECT UP_ORG_ID FROM ADMIN_SM_ORG WHERE ORG_CODE =\'" + orgId +"\'";
					}else {
						torgIdsql += "( SELECT UP_ORG_ID FROM ADMIN_SM_ORG WHERE ORG_CODE =";
					}
				}
			 for (int i = 0; i < orgIdnum - 3; i++) {
				 torgIdsql += ")";
				}
		}else{
			torgIdsql += "\'" + orgId +"\'";
		}
		 String sql = "select count(*) from admin_sm_org where (" + torgIdsql +") = ("+ orgIdsql+")";
		 map.put("sql", sql);
//		 map.put("orgIdsql", orgIdsql);
//		 String a = ocrmFciTransApplyMapper.getLevel(map);
//		 String b = ocrmFciTransApplyMapper.getLevel(map);
		 if (ocrmFciTransApplyMapper.getLevel(map) != 0) {
			return 1;
		}
		return 0;
		
	}

	public Map<String, String> belongOrgId(Map<String, String> map) {
		// TODO 自动生成的方法存根 获取主协办的上级机构 myOrgId orgId
		Map<String, String> result=new HashMap<>();
		Map<String, String> mapresult=ocrmFciLatentApplyMapper.belongOrgId(map.get("myOrgId"));
		Map<String, String> mapresult1=ocrmFciLatentApplyMapper.belongOrgId(map.get("orgId"));
		result.put("belongOrgId", mapresult.get("upOrgId"));
		result.put("belongOrgId1", mapresult1.get("upOrgId"));
		return result;
	}

	public Map<String, String> getbelongOrgId(Map<String, String> map) {
		// TODO 自动生成的方法存根
		String formdata=ocrmFciLatentApplyMapper.getbelongOrgId(map).get("formdata");
		String []strs=formdata.split("~");
		Map map2=new HashMap<String, String>();
		for(int i=0;i<strs.length;i++) {
			String ss[]=strs[i].split("=");
			if(ss[0].equals("belongOrgId")) {
				map2.put("belongOrgId", ss[1]);
			}
			if(ss[0].equals("belongOrgId1")) {
				map2.put("belongOrgId1", ss[1]);
			}
		}
		return map2;
	}

	public List<Map<String, String>> mycustmgrByModel(QueryModel model) {
		PageHelper.startPage(model.getPage(),model.getSize());
		List<Map<String, String>> list = ocrmFciTransApplyMapper.mycustmgrByModel(model);
		PageHelper.clearPage();
		return list;
	}

	public List<Map<String, String>> getUsersNode(String applyNo) {
		// TODO 自动生成的方法存根
		return ocrmFciTransApplyMapper.getUsersNode(applyNo);
	}

}
