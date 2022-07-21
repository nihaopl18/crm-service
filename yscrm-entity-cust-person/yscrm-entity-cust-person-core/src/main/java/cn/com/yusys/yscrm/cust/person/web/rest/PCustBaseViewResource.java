package cn.com.yusys.yscrm.cust.person.web.rest;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.ibatis.javassist.expr.NewArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.com.yusys.yscrm.cust.person.domain.AcrmFciPerKeyFlag;
import cn.com.yusys.yscrm.cust.person.domain.AcrmFciPerCust;
import cn.com.yusys.yscrm.cust.person.domain.AcrmFciPerResumeInfo;
import cn.com.yusys.yscrm.cust.person.domain.OcrmFciCustUpdateHis;
import cn.com.yusys.yscrm.cust.person.domain.OcrmFciPerOthbankDep;
import cn.com.yusys.yscrm.cust.person.domain.OcrmFciPreRelatInfo;
import cn.com.yusys.yscrm.cust.person.domain.OcrmFciPreWorkInfo;
import cn.com.yusys.yscrm.cust.person.service.PCustBaseViewService;
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
 * @类名称: AcrmFciPerCustResource
 * @类描述: #资源类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2019-01-22 17:20:26
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/pcustbaseview")
public class PCustBaseViewResource extends CommonResource<AcrmFciPerResumeInfo, String> {
    @Autowired
    private PCustBaseViewService pCustBaseViewService;
    @Autowired
  	private UaaClient uaaClient;
    @Override
    protected CommonService getCommonService() {
        return pCustBaseViewService;
    }
    @GetMapping("/querylist/{custId}") 
    public ResultDto<Map<String,List<Map<Object, String>>> > queryList(QueryModel model,@PathVariable String custId){
    	List<Map<Object, String>> baseInfo=pCustBaseViewService.getList(model,custId);//基本信息info
    	List<Map<Object, String>> workInfo=pCustBaseViewService.getworkList(model, custId);//工作信息
    	List<Map<Object, String>> relatInfo=pCustBaseViewService.getrelatList(model, custId);//涉农个性标识信息
    	List<Map<Object, String>> importInfo=pCustBaseViewService.getimportFlagList(model, custId);//重要标志信息
    	//List<Map<Object, String>> resumeInfo=pCustBaseViewService.getresumeList(model, custId);//履历信息
    	
    	Map<String,List<Map<Object, String>>>  allInfo=new HashMap<String,List<Map<Object, String>>>();
    	allInfo.put("baseInfo", baseInfo);
    	allInfo.put("workInfo", workInfo);
    	allInfo.put("relatInfo", relatInfo);
    	allInfo.put("importInfo", importInfo);
    	//allInfo.put("resumeInfo", resumeInfo);
    	ResultDto<Map<String,List<Map<Object, String>>> > resultDto = new ResultDto<Map<String,List<Map<Object, String>>> >();
    	resultDto.setData(allInfo);;
    	
    	
    	return resultDto;
    }
    @GetMapping("/saveImage/{custId}") 
    public ResultDto<Integer> saveImage(QueryModel model,@PathVariable String custId){
    	int map = pCustBaseViewService.saveImage(model,custId);
    	return new ResultDto<Integer>(map);
    }
    /**
     * 
     * 履历信息查询 
     * @param model
     * @param custId
     * @return
     */
    @GetMapping("/queryresumelist/{custId}") 
    public ResultDto<List<Map<Object, String>>> queryResumelist(QueryModel model,@PathVariable String custId){
    	List<Map<Object, String>> list = pCustBaseViewService.getresumeList(model, custId);//履历信息
		return new ResultDto<List<Map<Object, String>>>(list);
    }
	/**
	 * 修改基础信息
	 * @param c
	 * @param custId
	 * @return
	 */
	@PostMapping("/updateinfo")
	public ResultDto<Integer> updateInfo(@RequestBody Map c) {
		ResponseEntity<UserInfoDTO> dto  = uaaClient.getUserSessionInfo( HeaderUtil.getAccessToken());
		String orgCode = dto.getBody().getOrg().getCode();
		String loginCode=dto.getBody().getLoginCode();
		String corpOrgCode=dto.getBody().getInstu().getCode();
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
		String currDate=df.format(new Date());// new Date()为获取当前系统时间
		ResultDto<Integer> resultDto = null;
		String custId="";
		if(c.get("custId")!=null&&!c.get("custId").equals("")) {
			custId=c.get("custId").toString();
		}
	
		Map baseMap=(Map)c.get("baseinfomodel");
		Map workMap=(Map)c.get("workinfomodel");
		Map relationMap=(Map)c.get("relationmodel");
		Map relatMap=(Map)c.get("relatmodel");
		Map importMap=(Map)c.get("importmodel");
		Map resumeMap=(Map)c.get("resumemodel");
		
		
	
		//基本信息ACRMFCIPERADMITINFO
  		String baseString="";
  		AcrmFciPerCust percust=new AcrmFciPerCust();
  		if(c.get("basedata")!=null&&!c.get("basedata").equals("")) {
  			 baseString=c.get("basedata").toString();
  	  		 JSONObject baseJson =   JSONObject.fromObject(baseString);   
  	  		 percust =(AcrmFciPerCust)JSONObject.toBean(baseJson,AcrmFciPerCust.class);
  	  	   
  		}
		//工作信息
  		String workString="";
  		OcrmFciPreWorkInfo perwork=new OcrmFciPreWorkInfo();
  		if(c.get("workdata")!=null&&!c.get("workdata").equals("")) {
  			 workString=c.get("workdata").toString();
  	  		 JSONObject workJson =   JSONObject.fromObject(workString);   
  	  		 perwork =(OcrmFciPreWorkInfo)JSONObject.toBean(workJson,OcrmFciPreWorkInfo.class);
  	  	  
  		}
  		//与我行关系
  		String relString="";
  		AcrmFciPerCust perrel=new AcrmFciPerCust();
  		if(c.get("ralationdata")!=null&&!c.get("ralationdata").equals("")) {
  			 relString=c.get("ralationdata").toString();
  	  		 JSONObject relJson =   JSONObject.fromObject(relString);   
  	  		 perrel =(AcrmFciPerCust)JSONObject.toBean(relJson,AcrmFciPerCust.class);
  	  	  
  		}
  		//涉农标识
  		String farString="";
  		OcrmFciPreRelatInfo perfar=new OcrmFciPreRelatInfo();
  		if(c.get("farmerdata")!=null&&!c.get("farmerdata").equals("")) {
  			farString=c.get("farmerdata").toString();
  	  		 JSONObject farJson =   JSONObject.fromObject(farString);   
  	  		perfar =(OcrmFciPreRelatInfo)JSONObject.toBean(farJson,OcrmFciPreRelatInfo.class);
  	  	  
  		}
  	   //重要标识
  		String impString="";
  		AcrmFciPerKeyFlag perimp=new AcrmFciPerKeyFlag();
  		if(c.get("importdata")!=null&&!c.get("importdata").equals("")) {
  			impString=c.get("importdata").toString();
  	  		 JSONObject impJson =   JSONObject.fromObject(impString);   
  	  		perimp =(AcrmFciPerKeyFlag)JSONObject.toBean(impJson,AcrmFciPerKeyFlag.class);
  	  	  
  		}
		int basecode=0;
		int workcode=0;
		int relationcode=0;
		int relatcode=0;
		int importcode=0;
		int resumecode=0;
		if(baseMap!=null) {
			/*if(baseMap.get("birthDt")!=null) {
				baseMap.put("birthDt", baseMap.get("birthDt").toString().replace("-", ""))	;
			}*/
			 baseMap.put("lastUpdateSys", "CRM");//最新更新系统
			 baseMap.put("lastUpdateUser", loginCode);//最新更新人
			 baseMap.put("lastUpdateTm", currDate);//最新更新时间
			 baseMap.put("lastUpdateOrg", orgCode);//最新机构
			 baseMap.put("custId", custId);
			 basecode=pCustBaseViewService.updatebaseInfo(baseMap);
		}
		if(workMap!=null) {
			if(workMap.get("entryDate")!=null) {
				workMap.put("entryDate", workMap.get("entryDate").toString().replace("-", ""))	;
			}
			workMap.put("custId", custId);
			workMap.put("lastChgUsr", loginCode);//最新更新人
			workMap.put("lastChgDt", currDate);//最新更新时间
			workMap.put("lastOrgId", orgCode);//最新机构
			if(workMap.get("workId") == null || workMap.get("workId").equals("")) {
				workcode = pCustBaseViewService.insertWorkExist(workMap);
			} else {
				workcode=pCustBaseViewService.updateworkInfo(workMap);
			}
		}
		if(relationMap!=null) {
			relationMap.put("custId", custId);
			relationMap.put("lastUpdateSys", "CRM");//最新更新系统
			relationMap.put("lastUpdateUser", loginCode);//最新更新人
			relationMap.put("lastUpdateTm", currDate);//最新更新时间
			relationMap.put("lastUpdateOrg", orgCode);//最新机构
			relationcode=pCustBaseViewService.updaterelationInfo(relationMap);
		}
//		if(relatMap!=null) {
//			relatMap.put("custId", custId);
//			relatMap.put("lastChgUsr", loginCode);//最新更新人
//			relatMap.put("lastChgDt", currDate);//最新更新时间
//			relatMap.put("lastOrgId", orgCode);//最新机构
//			if(relatMap.get("relatId")==null || relatMap.get("relatId").equals("")) {
//				relatcode=pCustBaseViewService.insertRelatInfo(relatMap);
//			} else {
//				relatcode=pCustBaseViewService.updaterelatInfo(relatMap);
//			}
//		}
		if(importMap!=null) {
			importMap.put("custId", custId);
			importMap.put("lastUpdateSys", "CRM");//最新更新系统
			importMap.put("lastUpdateUser", loginCode);//最新更新人
			importMap.put("lastUpdateTm", currDate);//最新更新时间
			if(importMap.get("flagId") == null || importMap.get("flagId").equals("")) {
				importcode=pCustBaseViewService.insertImportInfo(importMap);
			} else {
				importcode=pCustBaseViewService.updateimportInfo(importMap);
			}
		}
		if(resumeMap!=null) {
			Object	mapId=resumeMap.get("id");
			String resumeId="";
		    if(mapId!=null) {
		    	resumeId= resumeMap.get("id").toString();
		    }

			if(resumeId!=null&&!resumeId.equals("")) {//修改
				resumeMap.put("custId", custId);
				resumeMap.put("lastChgSys", "CRM");//最新更新系统
				resumeMap.put("lastChgUsr", loginCode);//最新更新人
				resumeMap.put("lastChgDt", currDate);//最新更新时间
				 resumecode=pCustBaseViewService.updateresumeInfo(resumeMap);
			}else {//新增
				//String id=pCustBaseViewService.getNextId();
				//resumeMap.put("id", id);
				resumeMap.put("custId", custId);
				resumeMap.put("cratUsr", loginCode);//创建人
				resumeMap.put("cratDt", currDate);//创建日期
				resumeMap.put("cratOrgId", orgCode);//创建机构
				resumeMap.put("lastChgSys", "CRM");//最新更新系统
				resumeMap.put("lastChgUsr", loginCode);//最新更新人
				resumeMap.put("lastChgDt", currDate);//最新更新时间
				
				resumecode=pCustBaseViewService.insertresumeInfo(resumeMap);
			}
		}
	  
	
		
	    if(basecode!=0&&workcode!=0&&relationcode!=0&&relatcode!=0&&importcode!=0) {//判断表单数据是否全部提交
	       	resultDto = new ResultDto<Integer>();
	     		resultDto.setMessage("修改成功");
	     		resultDto.setCode(0);
	      }
	    if(resumecode!=0) {
	     	resultDto = new ResultDto<Integer>();
	 		resultDto.setMessage("操作成功");
	 		resultDto.setCode(0);
	    }
			return resultDto;	
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
//		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
//		String currDate=df.format(new Date());// new Date()为获取当前系统时间
		ResultDto<Integer> resultDto = null;
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
		String currDate=df.format(new Date());// new Date()为获取当前系统时间
		List list = new ArrayList<>();
		String updateName = "";
		String custId="";
		if(c.get("custId")!=null&&!c.get("custId").equals("")) {
			custId=c.get("custId").toString();
		}
		List<Map<String,Object>> baseList= (List<Map<String, Object>>) c.get("baseChange");
		List<Map<String,Object>> workList= (List<Map<String, Object>>) c.get("workChange");
		List<Map<String,Object>> relationList= (List<Map<String, Object>>) c.get("relationChange");
		List<Map<String,Object>> importList= (List<Map<String, Object>>) c.get("importChange");
		for(int i = 0; i < baseList.size();i++) {
			Map relationMap = baseList.get(i);
			String chgEngName = this.humpToUnderLine((String) relationMap.get("chgEngName")); //将驼峰式命名转为字段名
			list.add(chgEngName);
		}
		for(int i = 0; i < workList.size();i++) {
			Map relationMap = workList.get(i);
			String chgEngName = this.humpToUnderLine((String) relationMap.get("chgEngName")); //将驼峰式命名转为字段名
			list.add(chgEngName);
		}
		for(int i = 0; i < relationList.size();i++) {
			Map relationMap = relationList.get(i);
			String chgEngName = this.humpToUnderLine((String) relationMap.get("chgEngName")); //将驼峰式命名转为字段名
			list.add(chgEngName);
		}
		for(int i = 0; i < importList.size();i++) {
			Map relationMap = importList.get(i);
			String chgEngName = this.humpToUnderLine((String) relationMap.get("chgEngName")); //将驼峰式命名转为字段名
			list.add(chgEngName);
		}
		for(int i = 0; i<list.size();i++) {
			if(i == 0) {
				updateName = "'"+list.get(i)+"'";
			} else {
				updateName = updateName + ",'"+list.get(i)+"'";
			}
		}
		if(updateName != "") {
			pCustBaseViewService.updateIsUse(custId,updateName);
		}
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
					String aa=this.pCustBaseViewService.getItemName(mapCode);
					baseMap.put("chgBefKeyValue",aa);
				}
				if(baseMap.get("chgAftValueValue")!=null&&!baseMap.get("chgAftValueValue").equals("")) {
					mapCode.put("itemCode", baseMap.get("chgAftValueValue"));
					String aa=this.pCustBaseViewService.getItemName(mapCode);
					baseMap.put("chgAftKeyValue",aa);
				}
			}
			baseMap.put("id", id );
			baseMap.put("chgUsr", loginCode);//修改人
			baseMap.put("chgDt", new Date());//修改时间
			baseMap.put("chgOrgId", orgCode);//修改机构
			baseMap.put("custId", custId);
			baseMap.put("chgEngName", chgEngName);
			baseMap.put("tableName", "ACRM_F_CI_PER_ADMIT_INFO"); //修改 字段表名
			baseMap.put("chgMod", "custBaseView");
			baseMap.put("ifUse", "1");
			this.pCustBaseViewService.changeList(baseMap);
		}
		for(int i = 0; i < workList.size();i++) {
			String id = UUID.randomUUID().toString().toLowerCase().replace("-", "");
			Map workMap = workList.get(i);
			String chgEngName = this.humpToUnderLine((String) workMap.get("chgEngName")); //将驼峰式命名转为字段名
			Object dataCode=workMap.get("dataCode");
			if(dataCode!=null&&!dataCode.toString().equals("")) {
				Map mapCode=new HashMap<String, String>();
				mapCode.put("dataCode", dataCode.toString());
				if(workMap.get("chgBefValueValue")!=null&&!workMap.get("chgBefValueValue").equals("")) {
					mapCode.put("itemCode", workMap.get("chgBefValueValue"));
					String aa=this.pCustBaseViewService.getItemName(mapCode);
						workMap.put("chgBefKeyValue",aa);
				}
				if(workMap.get("chgAftValueValue")!=null&&!workMap.get("chgAftValueValue").equals("")) {
					mapCode.put("itemCode", workMap.get("chgAftValueValue"));
					String aa=this.pCustBaseViewService.getItemName(mapCode);
					workMap.put("chgAftKeyValue",aa);
				}
			}
			workMap.put("id", id );
			workMap.put("chgUsr", loginCode);//修改人
			workMap.put("chgDt", new Date());//修改时间
			workMap.put("chgOrgId", orgCode);//修改机构
			workMap.put("custId", custId);
			workMap.put("chgEngName", chgEngName);
			workMap.put("tableName", "OCRM_F_CI_PER_WORK_INFO"); //修改 字段表名
			workMap.put("chgMod", "custBaseView");
			workMap.put("ifUse", "1");
			this.pCustBaseViewService.changeList(workMap);
		}
		for(int i = 0; i < relationList.size();i++) {
			String id = UUID.randomUUID().toString().toLowerCase().replace("-", "");
			Map relationMap = relationList.get(i);
			String chgEngName = this.humpToUnderLine((String) relationMap.get("chgEngName")); //将驼峰式命名转为字段名
			Object dataCode=relationMap.get("dataCode");
			if(dataCode!=null&&!dataCode.toString().equals("")) {
				Map mapCode=new HashMap<String, String>();
				mapCode.put("dataCode", dataCode.toString());
				if(relationMap.get("chgBefValueValue")!=null&&!relationMap.get("chgBefValueValue").equals("")) {
					mapCode.put("itemCode", relationMap.get("chgBefValueValue"));
					String aa=this.pCustBaseViewService.getItemName(mapCode);
					relationMap.put("chgBefKeyValue",aa);
				}
				if(relationMap.get("chgAftValueValue")!=null&&!relationMap.get("chgAftValueValue").equals("")) {
					mapCode.put("itemCode", relationMap.get("chgAftValueValue"));
					String aa=this.pCustBaseViewService.getItemName(mapCode);
					relationMap.put("chgAftKeyValue",aa);
				}
			}
			relationMap.put("id", id );
			relationMap.put("chgUsr", loginCode);//修改人
			relationMap.put("chgDt", new Date());//修改时间
			relationMap.put("chgOrgId", orgCode);//修改机构
			relationMap.put("custId", custId);
			relationMap.put("chgEngName", chgEngName);
			relationMap.put("tableName", "ACRM_F_CI_PER_ADMIT_INFO"); //修改 字段表名
			relationMap.put("chgMod", "custBaseView");
			relationMap.put("ifUse", "1");
			this.pCustBaseViewService.changeList(relationMap);
		}
		for(int i = 0; i < importList.size();i++) {
			String id = UUID.randomUUID().toString().toLowerCase().replace("-", "");
			Map importMap = importList.get(i);
			String chgEngName = this.humpToUnderLine((String) importMap.get("chgEngName")); //将驼峰式命名转为字段名
			Object dataCode=importMap.get("dataCode");
			if(dataCode!=null&&!dataCode.toString().equals("")) {
				Map mapCode=new HashMap<String, String>();
				mapCode.put("dataCode", dataCode.toString());
				if(importMap.get("chgBefValueValue")!=null&&!importMap.get("chgBefValueValue").equals("")) {
					mapCode.put("itemCode", importMap.get("chgBefValueValue"));
					String aa=this.pCustBaseViewService.getItemName(mapCode);
					importMap.put("chgBefKeyValue",aa);
				}
				if(importMap.get("chgAftValueValue")!=null&&!importMap.get("chgAftValueValue").equals("")) {
					mapCode.put("itemCode", importMap.get("chgAftValueValue"));
					String aa=this.pCustBaseViewService.getItemName(mapCode);
					importMap.put("chgAftKeyValue",aa);
				}
			}
			importMap.put("id", id );
			importMap.put("chgUsr", loginCode);//修改人
			importMap.put("chgDt", new Date());//修改时间
			importMap.put("chgOrgId", orgCode);//修改机构
			importMap.put("custId", custId);
			importMap.put("chgEngName", chgEngName);
			importMap.put("tableName", "ACRM_F_CI_PER_KEY_FLAG"); //修改 字段表名
			importMap.put("chgMod", "custBaseView");
			importMap.put("ifUse", "1");
			this.pCustBaseViewService.changeList(importMap);
		}
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
    public ResultDto<List<Map<String,Object>>> queryCustUpdateHis(QueryModel model,@PathVariable String custId){
		return new ResultDto<List<Map<String,Object>>>(this.pCustBaseViewService.queryCustUpdateHis(model,custId));
	}
}
