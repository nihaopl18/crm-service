package cn.com.yusys.yscrm.custpub.web.rest;

import java.text.SimpleDateFormat;
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

import cn.com.yusys.yusp.admin.web.rest.util.HeaderUtil;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yusp.uaa.client.UaaClient;
import cn.com.yusys.yusp.uaa.client.dto.UserInfoDTO;
import cn.com.yusys.yscrm.custpub.domain.OcrmFciPreGradeApplyInfo;
import cn.com.yusys.yscrm.custpub.service.OcrmFciPreGradeApplyInfoService;

/**
 * @项目名称: yscrm-entity-cust-pub-core模块
 * @类名称: OcrmFciPreGradeApplyInfoResource
 * @类描述: #资源类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2019-02-16 12:50:17
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/ocrmfcipregradeapplyinfo")
public class OcrmFciPreGradeApplyInfoResource extends CommonResource<OcrmFciPreGradeApplyInfo, String> {
    @Autowired
    private OcrmFciPreGradeApplyInfoService ocrmFciPreGradeApplyInfoService;
    @Autowired
  	private UaaClient uaaClient;
    
    @Override
    protected CommonService getCommonService() {
        return this.ocrmFciPreGradeApplyInfoService;
    }
    @GetMapping("/queryservicegradelist/{custId}")
   	public ResultDto<List<Map<String, Object>>> queryServiceGradeList(@PathVariable String custId,QueryModel model) {
    	List<Map<String, Object>> list = ocrmFciPreGradeApplyInfoService.queryServiceGradeList(custId,model);
   		return new ResultDto<List<Map<String, Object>>>(list);
   	}
	/**
	 * 调整评级
	 * @param c
	 * @return
	 */
	@PostMapping("/updateservicegrade")
	public ResultDto<Integer> updateServiceGrade(@RequestBody Map map) {
		ResponseEntity<UserInfoDTO> dto  = uaaClient.getUserSessionInfo( HeaderUtil.getAccessToken());
		String orgCode = dto.getBody().getOrg().getCode();
		String userCode=dto.getBody().getUserCode();
		String corpOrgCode=dto.getBody().getInstu().getCode();
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
		String currDate=df.format(new Date());// new Date()为获取当前系统时间
		ResultDto<Integer> resultDto = null;
		int code=0;
		if(map!=null) {
		
			map.put("appHours",currDate);//申请时间
			map.put("applicant", userCode);//申请人
			map.put("applIns", orgCode);//申请机构
			code=ocrmFciPreGradeApplyInfoService.updateServiceGrade(map);
		}

	    if(code!=0) {
	     	resultDto = new ResultDto<Integer>();
	 		resultDto.setMessage("操作成功");
	 		resultDto.setCode(0);
	    }
			return resultDto;	
		}
}
