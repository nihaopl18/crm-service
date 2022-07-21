package cn.com.yusys.yscrm.custpub.service;

import java.text.SimpleDateFormat;
import java.util.*;

import cn.com.yusys.yscrm.custpub.domain.AcrmCustCount;
import cn.com.yusys.yscrm.custpub.domain.AcrmCustCountVO;
import cn.com.yusys.yusp.admin.web.rest.util.HeaderUtil;
import cn.com.yusys.yusp.uaa.client.UaaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;

import cn.com.yusys.yscrm.custpub.repository.mapper.GovernedCustMapper;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.security.SecurityUtils;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.uaa.client.dto.UserInfoDTO;
import co.elastic.apm.shaded.jackson.databind.ObjectMapper;
import net.sf.json.JSONObject;

@Service
public class GovernedCustService extends CommonService {

	@Autowired
	private GovernedCustMapper mapper;
	@Autowired
	private UaaClient uaaClient;
	@Override
	protected CommonMapper getMapper() {
		// TODO 自动生成的方法存根
		return null;
	}
	@Transactional(readOnly = true)
	public List<Map<Object, String>> getListOrg(QueryModel model) {
		// TODO 自动生成的方法存根
		PageHelper.startPage(model.getPage(), model.getSize());
		List<Map<Object, String>> list = null;
		String busiType = (String)model.getCondition().get("busiType");
		if (busiType.equals("6")) {
			list = mapper.getListOrgAll(model);
		}else {
			list = mapper.getListOrg(model);
		}
		PageHelper.clearPage();
		return list;
	}
//	@Transactional(readOnly = true)
//	public List<Map<Object, String>> getListOrgNoAdmit(QueryModel model) {
//		// TODO 自动生成的方法存根
//		PageHelper.startPage(model.getPage(), model.getSize());
//		List<Map<Object, String>> list = null;
//		String busiType = (String)model.getCondition().get("busiType");
//		if (busiType.equals("6")) {
//			list = mapper.getListOrgNoAdmitAll(model);
//		}else {
//			list = mapper.getListOrgNoAdmit(model);
//		}
//		PageHelper.clearPage();
//		return list;
//	}
	@Transactional(readOnly = true)
	public List<Map<String, String>> getListPer(QueryModel model) {
		// TODO 自动生成的方法存根
		PageHelper.startPage(model.getPage(), model.getSize());
		List<Map<String, String>> list = null;
		String busiType = (String)model.getCondition().get("busiType");
		Date newDate=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String dataDate=sdf.format(newDate);
		model.getCondition().put("dataDate", dataDate);
		if (busiType.equals("6")) {
			list = mapper.getListPerAll(model);
		}else {
			list = mapper.getListPer(model);
		}
		PageHelper.clearPage();
		return list;
	}
//	public List<Map<String, String>> getListPerNoAdmit(QueryModel model) {
//		// TODO 自动生成的方法存根
//		PageHelper.startPage(model.getPage(), model.getSize());
//		List<Map<String, String>> list = null;
//		String busiType = (String)model.getCondition().get("busiType");
//		if (busiType.equals("6")) {
//			list = mapper.getListPerNoAdmitAll(model);
//		}else {
//			list = mapper.getListPerNoAdmit(model);
//		}
//		PageHelper.clearPage();
//		return list;
//	}
	public List<Map<String, String>> getListAll(QueryModel model) {
		// TODO 自动生成的方法存根
		PageHelper.startPage(model.getPage(), model.getSize());
		List<Map<String, String>> list = mapper.getListAll(model);
		PageHelper.clearPage();
		return list;
	}
	public Map<String, String> getBusiTypeByUserId(QueryModel model) {
		// TODO 自动生成的方法存根
		List<Map<String, String>> myOrgId = mapper.getOrgIdByUserId(model);
		String MyOrgIds = "";
		if (myOrgId != null ) {
			String orgsql = "";
			if (myOrgId.size() > 0) {
				for (int i = 0; i < myOrgId.size(); i++) {
					String string = myOrgId.get(i).get("orgId");
					if (string.equals("500")) {
						orgsql = "500";
						break;
					}
					 if (i == myOrgId.size() - 1 ){
						 orgsql += "select org_code from sys_org_view where sys_org_view.org_seq like '%' "
								+ "|| \'"+ string+"\' || ',%'";
					}else if (i < myOrgId.size() - 1 ) {
						orgsql += "select org_code from sys_org_view where sys_org_view.org_seq like '%' "
								+ "|| \'"+ string+"\' || ',%'" +" union ";
					}
				}
				if (!orgsql.equals("500")) {
					Map<String, String> map = new HashMap<>();
					map.put("sql", orgsql);
					List<Map<String, String>> list = mapper.getOrgIdBySql(map);
					
					for (int i = 0; i < list.size(); i++) {
						String string = list.get(i).get("orgCode");
						if (i == 0) {
							MyOrgIds += string;
						} else {
							MyOrgIds += "," + string ;
						}
//						if(i == list.size() - 1) {
//							MyOrgIds +=  "" ;
//						}
					}
				}else {
					MyOrgIds = "500";
				}
				
			}
		}
		Map<String, String> myOrgIdAndBusiType = new HashMap<>();
		String loginCode = SecurityUtils.getCurrentUserLogin();
		Map<Object, String> busiType = mapper.getBusiTypeByUserId(loginCode);
		String busisql = "";
		String busiTypeString = busiType.get("busiType");
		myOrgIdAndBusiType.put("userCustType", busiTypeString);
		if (busiTypeString.equals("1,2,3,4,5")) {
			myOrgIdAndBusiType.put("busiType", "6");
		}else {
			if (busiType != null) {
				String[] strs = busiTypeString.split(",");
				for (int i = 0; i < strs.length; i++) {
					String string = strs[i];
					if (i == 0 ){
						busisql += " P.BUSI_TYPE IS NULL OR P.BUSI_TYPE LIKE '%"+string+"%'";
						continue;
					}else if (i < strs.length ) {
						busisql += "  OR P.BUSI_TYPE LIKE '%"+string+"%'";
					}
				}
				myOrgIdAndBusiType.put("busiType", busisql);
			}
		}
		
//		myOrgIdAndBusiType.put("busiType", "");
		myOrgIdAndBusiType.put("orgIdAuth", MyOrgIds);
		return myOrgIdAndBusiType;
	}
	public List<Map<String, String>> getManageCustPerList(QueryModel model) {
		// TODO 自动生成的方法存根
		String busitype = (String) model.getCondition().get("busiType");
		String busisql = "";
		if ( busitype != null && !busitype.equals("")) {
			String[] busiType = busitype.split(",");
			for (int i = 0; i < busiType.length; i++) {
				String string = busiType[i];
				if (i == 0 ){
					busisql += " AND P.BUSI_TYPE IS NULL OR P.BUSI_TYPE LIKE '%"+string+"%'";
					continue;
				}else if (i < busiType.length ) {
					busisql += "  OR P.BUSI_TYPE LIKE '%"+string+"%'";
				}
			}
			model.getCondition().put("busiTypeAuth", busisql);
		}
		PageHelper.startPage(model.getPage(), model.getSize());
		List<Map<String, String>> list = mapper.getManageCustPerList(model);
		PageHelper.clearPage();
		return list;
	}
	public List<Map<String, String>> getManageCustOrgList(QueryModel model) {
		// TODO 自动生成的方法存根
		String busitype = (String) model.getCondition().get("busiType");
		String busisql = "";
		if ( busitype != null && !busitype.equals("")) {
			String[] busiType = busitype.split(",");
			for (int i = 0; i < busiType.length; i++) {
				String string = busiType[i];
				if (i == 0 ){
					busisql += " ( P.BUSI_TYPE IS NULL OR P.BUSI_TYPE LIKE '%"+string+"%'";
					continue;
				}else if (i < busiType.length - 1 ) {
					busisql += "  OR P.BUSI_TYPE LIKE '%"+string+"%'";
				}else if (i == busiType.length - 1) {
					busisql += ")";
				}
			}
			model.getCondition().put("busiTypeAuth", busisql);
		}
		PageHelper.startPage(model.getPage(), model.getSize());
		List<Map<String, String>> list = mapper.getManageCustOrgList(model);
		PageHelper.clearPage();
		return list;
	}

	public List<AcrmCustCountVO> custQueryList(QueryModel model) {
		ResponseEntity<UserInfoDTO> dto = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());
		UserInfoDTO user = dto.getBody();
		Map<String,String> map=new HashMap<>();
		map.put("orgId",user.getOrg().getCode());
		map.put("samId",user.getLoginCode());
		List<AcrmCustCountVO> acrmCustCountVOSlist = mapper.custQueryList(map);
		/*Set<AcrmCustCountVO> set=new TreeSet<AcrmCustCountVO>(new Comparator<AcrmCustCountVO>() {
			@Override
			public int compare(AcrmCustCountVO o1, AcrmCustCountVO o2) {
				return o1.getCustName().compareTo(o2.getCustName());
			}
		});
		set.addAll(acrmCustCountVOS);
		List<AcrmCustCountVO> lists=new ArrayList<AcrmCustCountVO>(set);*/

		return acrmCustCountVOSlist;
	}
}