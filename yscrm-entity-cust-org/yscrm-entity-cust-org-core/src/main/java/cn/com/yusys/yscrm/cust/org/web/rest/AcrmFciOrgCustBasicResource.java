package cn.com.yusys.yscrm.cust.org.web.rest;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.com.yusys.yscrm.cust.org.domain.AcrmFciOrgCustInfo;
import cn.com.yusys.yscrm.cust.org.service.AcrmFciOrgCustBasicService;
import cn.com.yusys.yusp.admin.web.rest.util.HeaderUtil;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yusp.uaa.client.UaaClient;
import cn.com.yusys.yusp.uaa.client.dto.UserInfoDTO;

/**
 * @项目名称: demo-app-single-starter模块
 * @类名称: AcrmFciOrgCustResource
 * @类描述: #资源类
 * @功能描述: 对公客户基本信息
 * @创建人: 15104
 * @创建时间: 2019-02-21 09:32:23
 * @修改备注:
 * @修改记录: 修改时间 修改人员 修改原因
 *        -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/acrmFciOrgCustBasic")
public class AcrmFciOrgCustBasicResource extends CommonResource<AcrmFciOrgCustInfo, String> {
	@Autowired
	private AcrmFciOrgCustBasicService acrmFciOrgCustService;
	
	@Autowired
  	private UaaClient uaaClient;

	@Override
	protected CommonService getCommonService() {
		return acrmFciOrgCustService;
	}

	/**
	 * @方法名称: querylist
	 * @方法描述: 查询
	 * @param
	 * @return
	 */
	@GetMapping("/querylist/{custId}")
	public ResultDto<Object> querylist(QueryModel model, @PathVariable String custId) {
		List<Map<Object, String>> baseInfo = acrmFciOrgCustService.querylist(model, custId);

		return new ResultDto<Object>(baseInfo);
	}

	@GetMapping("/getlookupItem")
	public ResultDto<List<Map<Object, String>>> querylist() {
		List<Map<Object, String>> lookupCodeMap = acrmFciOrgCustService.getlookupItem();
		return new ResultDto<List<Map<Object, String>>>(lookupCodeMap);
	}
	/**
	 * @方法名称: save
	 * @方法描述: 保存
	 * @param
	 * @return
	 */
	@PostMapping("/save")
	public ResultDto<Object> save(@RequestBody AcrmFciOrgCustInfo acrmFciOrgCust) {
		int result = acrmFciOrgCustService.save(acrmFciOrgCust);
		return new ResultDto<Object>(result);
	}
	
	/**
	 * 保存修改历史信息
	 * @param c
	 * @param custId
	 * @return
	 */
	@PostMapping("/changelist")
	public ResultDto<Integer> changeList(@RequestBody Map c) {
		ResponseEntity<UserInfoDTO> dto  = uaaClient.getUserSessionInfo( HeaderUtil.getAccessToken());
		String orgCode = dto.getBody().getOrg().getCode();
		String loginCode=dto.getBody().getLoginCode();
		ResultDto<Integer> resultDto = null;
		List list = new ArrayList<>();
		String updateName = "";
		String custId="";
		if(c.get("custId")!=null&&!c.get("custId").equals("")) {
			custId=c.get("custId").toString();
		}
		List<Map<String,Object>> baseList= (List<Map<String, Object>>) c.get("baseChange");
		List<Map<String,Object>> importList= (List<Map<String, Object>>) c.get("importChange");
		List<Map<String,Object>> relatList= (List<Map<String, Object>>) c.get("relatChange");
		List<Map<String,Object>> manageList= (List<Map<String, Object>>) c.get("manageChange");
		if(baseList!=null&&baseList.size()>0) {
			for(int i = 0; i < baseList.size();i++) {
				Map relationMap = baseList.get(i);
				String chgEngName = this.humpToUnderLine((String) relationMap.get("chgEngName")); //将驼峰式命名转为字段名
				list.add(chgEngName);
			}
		}
		if(importList!=null&&importList.size()>0) {
		for(int i = 0; i < importList.size();i++) {
			Map relationMap = importList.get(i);
			String chgEngName = this.humpToUnderLine((String) relationMap.get("chgEngName")); //将驼峰式命名转为字段名
			list.add(chgEngName);
		}}
		if(relatList!=null&&relatList.size()>0) {
		for(int i = 0; i < relatList.size();i++) {
			Map relationMap = relatList.get(i);
			String chgEngName = this.humpToUnderLine((String) relationMap.get("chgEngName")); //将驼峰式命名转为字段名
			list.add(chgEngName);
		}
		}
		if(manageList!=null&&manageList.size()>0) {
		for(int i = 0; i < manageList.size();i++) {
			Map relationMap = manageList.get(i);
			String chgEngName = this.humpToUnderLine((String) relationMap.get("chgEngName")); //将驼峰式命名转为字段名
			list.add(chgEngName);
		}}
		for(int i = 0; i<list.size();i++) {
			if(i == 0) {
				updateName = "'"+list.get(i)+"'";
			} else {
				updateName = updateName + ",'"+list.get(i)+"'";
			}
		}
		if(updateName != "") {
			acrmFciOrgCustService.updateIsUse(custId,updateName);
		}
		if(baseList!=null&&baseList.size()>0) {
		for(int i = 0; i < baseList.size();i++) {
			String id = UUID.randomUUID().toString().toLowerCase().replace("-", "");
			Map baseMap = baseList.get(i);
			String chgEngName = this.humpToUnderLine((String) baseMap.get("chgEngName")); //将驼峰式命名转为字段名
			Object dataCode=baseMap.get("dataCode");
			if(dataCode!=null&&!dataCode.toString().equals("")) {
				Map mapCode=new HashMap<String, String>();
				mapCode.put("dataCode", dataCode.toString());
				if(baseMap.get("chgBefValueValue")!=null&&!baseMap.get("chgBefValueValue").equals("")) {
					mapCode.put("itemCode", baseMap.get("chgBefValueValue"));
					String aa=this.acrmFciOrgCustService.getItemName(mapCode);
					baseMap.put("chgBefKeyValue",aa);
				}
				if(baseMap.get("chgAftValueValue")!=null&&!baseMap.get("chgAftValueValue").equals("")) {
					mapCode.put("itemCode", baseMap.get("chgAftValueValue"));
					String aa=this.acrmFciOrgCustService.getItemName(mapCode);
					baseMap.put("chgAftKeyValue",aa);
				}
			}
			baseMap.put("id", id );
			baseMap.put("chgUsr", loginCode);//修改人
			baseMap.put("chgDt", new Date());//修改时间
			baseMap.put("chgOrgId", orgCode);//修改机构
			baseMap.put("custId", custId);
			baseMap.put("chgEngName", chgEngName);
			baseMap.put("tableName", "ACRM_F_CI_ORG_CUST_INFO"); //修改 字段表名
			baseMap.put("chgMod", "orgBaseView");
			baseMap.put("ifUse", "1");
			this.acrmFciOrgCustService.changeList(baseMap);
		}}
		if(importList!=null&&importList.size()>0) {
		for(int i = 0; i < importList.size();i++) {
			String id = UUID.randomUUID().toString().toLowerCase().replace("-", "");
			Map workMap = importList.get(i);
			String chgEngName = this.humpToUnderLine((String) workMap.get("chgEngName")); //将驼峰式命名转为字段名
			Object dataCode=workMap.get("dataCode");
			if(dataCode!=null&&!dataCode.toString().equals("")) {
				Map mapCode=new HashMap<String, String>();
				mapCode.put("dataCode", dataCode.toString());
				if(workMap.get("chgBefValueValue")!=null&&!workMap.get("chgBefValueValue").equals("")) {
					mapCode.put("itemCode", workMap.get("chgBefValueValue"));
					String aa=this.acrmFciOrgCustService.getItemName(mapCode);
					workMap.put("chgBefKeyValue",aa);
				}
				if(workMap.get("chgAftValueValue")!=null&&!workMap.get("chgAftValueValue").equals("")) {
					mapCode.put("itemCode", workMap.get("chgAftValueValue"));
					String aa=this.acrmFciOrgCustService.getItemName(mapCode);
					workMap.put("chgAftKeyValue",aa);
				}
			}
			workMap.put("id", id );
			workMap.put("chgUsr", loginCode);//修改人
			workMap.put("chgDt", new Date());//修改时间
			workMap.put("chgOrgId", orgCode);//修改机构
			workMap.put("custId", custId);
			workMap.put("chgEngName", chgEngName);
			workMap.put("tableName", "ACRM_F_CI_ORG_KEY_FLAG"); //修改 字段表名
			workMap.put("chgMod", "orgBaseView");
			workMap.put("ifUse", "1");
			this.acrmFciOrgCustService.changeList(workMap);
		}}
		if(relatList!=null&&relatList.size()>0) {
		for(int i = 0; i < relatList.size();i++) {
			String id = UUID.randomUUID().toString().toLowerCase().replace("-", "");
			Map relationMap = relatList.get(i);
			String chgEngName = this.humpToUnderLine((String) relationMap.get("chgEngName")); //将驼峰式命名转为字段名
			Object dataCode=relationMap.get("dataCode");
			if(dataCode!=null&&!dataCode.toString().equals("")) {
				Map mapCode=new HashMap<String, String>();
				mapCode.put("dataCode", dataCode.toString());
				if(relationMap.get("chgBefValueValue")!=null&&!relationMap.get("chgBefValueValue").equals("")) {
					mapCode.put("itemCode", relationMap.get("chgBefValueValue"));
					String aa=this.acrmFciOrgCustService.getItemName(mapCode);
					relationMap.put("chgBefKeyValue",aa);
				}
				if(relationMap.get("chgAftValueValue")!=null&&!relationMap.get("chgAftValueValue").equals("")) {
					mapCode.put("itemCode", relationMap.get("chgAftValueValue"));
					String aa=this.acrmFciOrgCustService.getItemName(mapCode);
					relationMap.put("chgAftKeyValue",aa);
				}
			}
			relationMap.put("id", id );
			relationMap.put("chgUsr", loginCode);//修改人
			relationMap.put("chgDt", new Date());//修改时间
			relationMap.put("chgOrgId", orgCode);//修改机构
			relationMap.put("custId", custId);
			relationMap.put("chgEngName", chgEngName);
			relationMap.put("tableName", "ACRM_F_CI_ORG_CUST_INFO"); //修改 字段表名
			relationMap.put("chgMod", "orgBaseView");
			relationMap.put("ifUse", "1");
			this.acrmFciOrgCustService.changeList(relationMap);
		}}
		if(manageList!=null&&manageList.size()>0) {
		for(int i = 0; i < manageList.size();i++) {
			String id = UUID.randomUUID().toString().toLowerCase().replace("-", "");
			Map importMap = manageList.get(i);
			String chgEngName = this.humpToUnderLine((String) importMap.get("chgEngName")); //将驼峰式命名转为字段名
			Object dataCode=importMap.get("dataCode");
			if(dataCode!=null&&!dataCode.toString().equals("")) {
				Map mapCode=new HashMap<String, String>();
				mapCode.put("dataCode", dataCode.toString());
				if(importMap.get("chgBefValueValue")!=null&&!importMap.get("chgBefValueValue").equals("")) {
					mapCode.put("itemCode", importMap.get("chgBefValueValue"));
					String aa=this.acrmFciOrgCustService.getItemName(mapCode);
					importMap.put("chgBefKeyValue",aa);
				}
				if(importMap.get("chgAftValueValue")!=null&&!importMap.get("chgAftValueValue").equals("")) {
					mapCode.put("itemCode", importMap.get("chgAftValueValue"));
					String aa=this.acrmFciOrgCustService.getItemName(mapCode);
					importMap.put("chgAftKeyValue",aa);
				}
			}
			importMap.put("id", id );
			importMap.put("chgUsr", loginCode);//修改人
			importMap.put("chgDt", new Date());//修改时间
			importMap.put("chgOrgId", orgCode);//修改机构
			importMap.put("custId", custId);
			importMap.put("chgEngName", chgEngName);
			importMap.put("tableName", "OCRM_F_CI_ORG_MANAGE_INFO"); //修改 字段表名
			importMap.put("chgMod", "orgBaseView");
			importMap.put("ifUse", "1");
			this.acrmFciOrgCustService.changeList(importMap);
		}}
		return resultDto;
	}
	
	/**
	 * 将驼峰命名转为下划线格式
	 * @param para
	 * @return
	 */
	public String humpToUnderLine(String para) {
		StringBuffer sb = new StringBuffer(para);
		int temp = 0; //定位
		if (!para.contains("_")) {
			for(int i=0;i<para.length();i++) {
				if(Character.isUpperCase(para.charAt(i))) {
					sb.insert(i+temp,"_" );
					temp+=1;
				}
			}
		}
		return sb.toString().toUpperCase();
	}
	
	@GetMapping("/queryCustUpdateHis/{custId}") 
    public ResultDto<List<Map<String,Object>>> queryOrgUpdateHis(QueryModel model,@PathVariable String custId){
		return new ResultDto<List<Map<String,Object>>>(this.acrmFciOrgCustService.queryCustUpdateHis(model,custId));
	}
}
