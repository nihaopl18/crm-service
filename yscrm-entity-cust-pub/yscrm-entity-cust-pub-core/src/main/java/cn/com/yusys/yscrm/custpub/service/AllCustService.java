package cn.com.yusys.yscrm.custpub.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;

import cn.com.yusys.yscrm.custpub.repository.mapper.AllCustMapper;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.security.SecurityUtils;
import cn.com.yusys.yusp.commons.service.CommonService;

@Service
public class AllCustService extends CommonService{

	@Autowired
	private AllCustMapper mapper;
	
	@Override
	protected CommonMapper getMapper() {
		// TODO 自动生成的方法存根
		return null;
	}
	@Transactional(readOnly = true) 
	public List<Map<String, String>> getList(QueryModel model) {
		// TODO 自动生成的方法存根
		PageHelper.startPage(model.getPage(), model.getSize());
		List<Map<String, String>> list = mapper.getList(model);
		PageHelper.clearPage();
		return list;
	}
	public int getOrgLev(Map<String, String> map) {
		// TODO 自动生成的方法存根
		return mapper.getOrgLev(map);
	}
	public List<Map<String, String>> getMemberDeposit(QueryModel model) {
		// TODO 自动生成的方法存根
		PageHelper.startPage(model.getPage(), model.getSize());
		List<Map<String, String>> list = mapper.getMemberDeposit(model);
		PageHelper.clearPage();
		return list;
	}

	public List<Map<String, String>> getMemberLoan(QueryModel model) {
		// TODO 自动生成的方法存根
		PageHelper.startPage(model.getPage(), model.getSize());
		List<Map<String, String>> list = mapper.getMemberLoan(model);
		PageHelper.clearPage();
		return list;
	}

	public List<Map<String, String>> getMemberPro(QueryModel model) {
		// TODO 自动生成的方法存根
		PageHelper.startPage(model.getPage(), model.getSize());
		List<Map<String, String>> list = mapper.getMemberPro(model);
		PageHelper.clearPage();
		return list;
	}

	public List<Map<String, String>> getMemberContribution(QueryModel model) {
		// TODO 自动生成的方法存根
		PageHelper.startPage(model.getPage(), model.getSize());
		List<Map<String, String>> list = mapper.getMemberContribution(model);
		PageHelper.clearPage();
		return list;
	}

	public List<Map<String, String>> getFitProduct(QueryModel model) {
		// TODO 自动生成的方法存根
		PageHelper.startPage(model.getPage(), model.getSize());
		List<Map<String, String>> list = mapper.getFitProduct(model);
		PageHelper.clearPage();
		return list;
	}
	
	public Map<String, String> getOrgLevel(String orgId) {
		// TODO 自动生成的方法存根
		return mapper.getOrgLevel(orgId);
	}
	public Map<String, String> getOneOrg(Map<String, String> map) {
		// TODO 自动生成的方法存根
		return mapper.getOneOrg(map);
	}
	public Map<String, String> getMyOrgByUserId(QueryModel model) {
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
		myOrgIdAndBusiType.put("orgIdAuth", MyOrgIds);
		return myOrgIdAndBusiType;
	}
	public Map<String, String> getBusiType() {
		// TODO 自动生成的方法存根
		String loginCode = SecurityUtils.getCurrentUserLogin();
		return mapper.getBusiTypeByUserId(loginCode);
	}
	public Map<String, String> getUserNameByUserId(String lastUser) {
		// TODO 自动生成的方法存根
		return mapper.getUserNameByUserId(lastUser);
	}
	public List<Map<String, String>> getorgtree(QueryModel model) {
		// TODO 自动生成的方法存根
		return mapper.getorgtree(model);
	}
}
