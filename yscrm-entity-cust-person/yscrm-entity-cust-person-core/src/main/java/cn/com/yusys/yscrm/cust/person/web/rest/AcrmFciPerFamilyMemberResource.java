package cn.com.yusys.yscrm.cust.person.web.rest;



import java.net.URISyntaxException;
import java.util.Date;
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

import cn.com.yusys.yscrm.cust.person.domain.AcrmFciPerFamilyMember;
import cn.com.yusys.yscrm.cust.person.service.AcrmFciPerFamilyMemberService;
import cn.com.yusys.yusp.admin.web.rest.util.HeaderUtil;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yusp.uaa.client.UaaClient;
import cn.com.yusys.yusp.uaa.client.dto.UserInfoDTO;



/**
 * @项目名称: yscrm-entity-cust-person-core模块
 * @类名称: AcrmFciPerFamilyMemberResource
 * @类描述: #资源类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2019-01-29 16:09:50
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/acrmfciperfamilymember")
public class AcrmFciPerFamilyMemberResource extends CommonResource<AcrmFciPerFamilyMember, String> {
    @Autowired
    private AcrmFciPerFamilyMemberService acrmFciPerFamilyMemberService;
    @Autowired
  	private UaaClient uaaClient;
    @Override
    protected CommonService getCommonService() {
        return this.acrmFciPerFamilyMemberService;
    }
    @GetMapping("/queryfammemlist/{custId}")
	public ResultDto<Object> queryFamMemlist(@PathVariable String custId,QueryModel model) {
		List<Map<String, Object>> list = acrmFciPerFamilyMemberService.queryFamMemList(custId,model);
		return new ResultDto<Object>(list);
	}
	@PostMapping("/addfammem")
	public ResultDto<Object> addFamMem(@RequestBody AcrmFciPerFamilyMember  pool) throws URISyntaxException {
			ResponseEntity<UserInfoDTO> dto  = uaaClient.getUserSessionInfo( HeaderUtil.getAccessToken());
			String orgCode = dto.getBody().getOrg().getCode();
			String loginCode=dto.getBody().getLoginCode();
			String corpOrgCode=dto.getBody().getInstu().getCode();   
			String returnStr="";
	     
	        pool.setCratDt(new Date());
	        pool.setCratOrgId(orgCode);
	        pool.setCratUsr(loginCode);
	        pool.setLastChgDt(new Date());
	        pool.setLastChgSys("CRM");
	        pool.setLastChgUsr(loginCode);
	        pool.setCorpOrgCode(corpOrgCode);
	        //判断新增成员是否为我行客户
	        
	        AcrmFciPerFamilyMember list = acrmFciPerFamilyMemberService.insertFamMem(pool);
			returnStr=list.getId();
		
		
		return new ResultDto<Object>(returnStr);
	}
	@PostMapping("/updatefammem")
	public ResultDto<Object> updateFamMem(@RequestBody AcrmFciPerFamilyMember  pool) throws URISyntaxException {
			ResponseEntity<UserInfoDTO> dto  = uaaClient.getUserSessionInfo( HeaderUtil.getAccessToken());
			String orgCode = dto.getBody().getOrg().getCode();
			String loginCode=dto.getBody().getLoginCode();
			String corpOrgCode=dto.getBody().getInstu().getCode();
		    String returnStr="";
		    pool.setLastChgDt(new Date());
	        pool.setLastChgSys("CRM");
	        pool.setLastChgUsr(loginCode);
	        pool.setCorpOrgCode(corpOrgCode);
			int n = acrmFciPerFamilyMemberService.updateFamMem(pool);
			returnStr=String.valueOf(n);
		
		
		   return new ResultDto<Object>(returnStr);
	}
	@PostMapping("/deletefammem")
	public ResultDto<Object> deleteFamMem(@RequestBody Map idmap) {
		int n=0;
		if(idmap !=null) {
			//SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd ");//设置日期格式
			String ids=idmap.get("id").toString();
			String[] idStr=ids.toString().split(",");
			for(int i=0;i<idStr.length;i++) {
				if(!"".equals(idStr[i])) {
					n=n+this.acrmFciPerFamilyMemberService.deleteFamMem(idStr[i]);
				}
			}
			//logger.info("批量删除  【主键："+ids+"】 "+df.format(new Date()));
		}
		return new ResultDto<Object>(n);
	}

}
