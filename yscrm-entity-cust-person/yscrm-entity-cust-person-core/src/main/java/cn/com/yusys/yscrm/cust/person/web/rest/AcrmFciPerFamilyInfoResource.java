package cn.com.yusys.yscrm.cust.person.web.rest;



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

import cn.com.yusys.yscrm.cust.person.domain.AcrmFciPerFamilyInfo;
import cn.com.yusys.yscrm.cust.person.domain.OcrmFciPreRelatInfo;
import cn.com.yusys.yscrm.cust.person.service.AcrmFciPerFamilyInfoService;
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
 * @类名称: AcrmFciPerFamilyInfoResource
 * @类描述: #资源类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2019-01-29 10:39:35
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/acrmfciperfamilyinfo")
public class AcrmFciPerFamilyInfoResource extends CommonResource<AcrmFciPerFamilyInfo, String> {
    @Autowired
    private AcrmFciPerFamilyInfoService acrmFciPerFamilyInfoService;
    @Autowired
  	private UaaClient uaaClient;
    @Override
    protected CommonService getCommonService() {
        return this.acrmFciPerFamilyInfoService;
    }
    @GetMapping("/queryfamilylist/{custId}") 
    public ResultDto<List<Map<Object, String>>> queryFamilyList(QueryModel model,@PathVariable String custId){
    	List<Map<Object, String>> list = acrmFciPerFamilyInfoService.getFamilyList(model,custId);
		return new ResultDto<List<Map<Object, String>>>(list);
    }
	//修改基础信息
	@PostMapping("/updatefamily")
	public ResultDto<Integer> updateFamily(@RequestBody Map c) {
		ResponseEntity<UserInfoDTO> dto  = uaaClient.getUserSessionInfo( HeaderUtil.getAccessToken());
		String orgCode = dto.getBody().getOrg().getCode();
		String loginCode=dto.getBody().getLoginCode();
		String corpOrgCode=dto.getBody().getInstu().getCode(); 
	
		ResultDto<Integer> resultDto = null;
		String custId="";
		if(c.get("custId")!=null&&!c.get("custId").equals("")) {
			custId=c.get("custId").toString();
		}
		//基本
  		String baseString="";
  		AcrmFciPerFamilyInfo perbase=new AcrmFciPerFamilyInfo();
  		if(c.get("basedata")!=null&&!c.get("basedata").equals("")) {
  			 baseString=c.get("basedata").toString();
  	  		 JSONObject baseJson =   JSONObject.fromObject(baseString);   
  	  		 perbase =(AcrmFciPerFamilyInfo)JSONObject.toBean(baseJson,AcrmFciPerFamilyInfo.class);
  	  	  
  		}
  		//更多
  	
  		String moreString="";
  		AcrmFciPerFamilyInfo permore=new AcrmFciPerFamilyInfo();
  		if(c.get("infomoredata")!=null&&!c.get("infomoredata").equals("")) {
  			 moreString=c.get("infomoredata").toString();
  	  		 JSONObject moreJson =   JSONObject.fromObject(moreString);   
  	  		 permore =(AcrmFciPerFamilyInfo)JSONObject.toBean(moreJson,AcrmFciPerFamilyInfo.class);
  	  	  
  		}
  		
		Map baseMap=(Map)c.get("baseinfomodel");
		Map moreMap=(Map)c.get("moreinfomodel");
		int basecode=0;
		int morecode=0;
		
		if(baseMap!=null) {
			 baseMap.put("lastChgSys", "CRM");//最新更新系统
			 baseMap.put("lastChgUsr", loginCode);//最新更新人
			 baseMap.put("corpOrgCode", orgCode);//法人
			 baseMap.put("custId", custId);
			 basecode=acrmFciPerFamilyInfoService.updatebaseInfo(baseMap);
		}
		if(moreMap!=null) {
			moreMap.put("lastChgSys", "CRM");//最新更新系统
			moreMap.put("lastChgUsr", loginCode);//最新更新人
			moreMap.put("corpOrgCode", orgCode);//法人
			moreMap.put("custId", custId);
			morecode=acrmFciPerFamilyInfoService.updatemoreInfo(moreMap,basecode);
		}

	    if(basecode!=0&&morecode!=0) {//判断表单数据是否全部提交
	       	resultDto = new ResultDto<Integer>();
	     		resultDto.setMessage("操作成功");
	     		resultDto.setCode(0);
	      }
	  
			return resultDto;	
		}
}
