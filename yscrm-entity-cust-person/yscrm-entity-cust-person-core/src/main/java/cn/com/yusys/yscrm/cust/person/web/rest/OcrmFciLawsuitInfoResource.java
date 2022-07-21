package cn.com.yusys.yscrm.cust.person.web.rest;

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

import cn.com.yusys.yscrm.cust.person.domain.OcrmFciLawsuitInfo;
import cn.com.yusys.yscrm.cust.person.service.OcrmFciLawsuitInfoService;
import cn.com.yusys.yusp.admin.web.rest.util.HeaderUtil;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yusp.uaa.client.UaaClient;
import cn.com.yusys.yusp.uaa.client.dto.UserInfoDTO;


/**
 * @项目名称: demo-app-single-starter模块
 * @类名称: OcrmFciLawsuitInfoResource
 * @类描述: #资源类
 * @功能描述: 诉讼信息
 * @创建人: 15104
 * @创建时间: 2019-02-13 12:53:27
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/ocrmfcilawsuitinfo")
public class OcrmFciLawsuitInfoResource extends CommonResource<OcrmFciLawsuitInfo, String> {
    @Autowired
    private OcrmFciLawsuitInfoService ocrmFciLawsuitInfoService;

    @Override
    protected CommonService getCommonService() {
        return ocrmFciLawsuitInfoService;
    }

    @Autowired
   	private UaaClient uaaClient;
    
    /**
	 * @方法名称: querylist
	 * @方法描述: 诉讼信息查询
	 * @param
	 * @return
	 */
	@GetMapping("/querylist/{custId}")
	public ResultDto<Object> querylist(QueryModel model, @PathVariable String custId) {
		List<Map<Object, String>> baseInfo = ocrmFciLawsuitInfoService.querylist(model, custId);

		return new ResultDto<Object>(baseInfo);
	}

	/**
	 * @方法名称: ctrate
	 * @方法描述: 诉讼信息新增
	 * @param
	 * @return
	 */
	@PostMapping("/ctrate")
	public ResultDto<Object> ctrate(@RequestBody OcrmFciLawsuitInfo ocrmFciLawsuitInfo) {
		ResponseEntity<UserInfoDTO> dto  = uaaClient.getUserSessionInfo( HeaderUtil.getAccessToken());
		SimpleDateFormat s=new SimpleDateFormat("yyyyMMdd");
		ocrmFciLawsuitInfo.setDataDate(s.format(new Date()));//数据日期
		ocrmFciLawsuitInfo.setCratDt(new Date());//创建日期
		ocrmFciLawsuitInfo.setCratOrgId(dto.getBody().getOrg().getCode());//创建机构编号
		ocrmFciLawsuitInfo.setCratUsr(dto.getBody().getLoginCode());//创建人
		ocrmFciLawsuitInfo.setCorpOrgCode(dto.getBody().getInstu().getCode());//法人机构号
		ocrmFciLawsuitInfo.setSrcSysCd("CRM");//来源系统
		ocrmFciLawsuitInfo.setCustType("1");//客户类型 1-对私 2-对公
		ocrmFciLawsuitInfo.setRegDate(new Date());//登记日期
		ocrmFciLawsuitInfo.setInputId(dto.getBody().getLoginCode());//登记人
		ocrmFciLawsuitInfo.setLastChgSys("CRM");//最近更新系统
		ocrmFciLawsuitInfo.setLastChgUsr(dto.getBody().getLoginCode());//最近更新人ID
		ocrmFciLawsuitInfo.setLastChgDt(new Date());//最近更新日期
		
		int result = ocrmFciLawsuitInfoService.ctrate(ocrmFciLawsuitInfo);
		return new ResultDto<Object>(result);
	}

	/**
	 * @方法名称: modify
	 * @方法描述: 诉讼信息修改
	 * @param
	 * @return
	 */
	@PostMapping("/modify")
	public ResultDto<Object> modify(@RequestBody OcrmFciLawsuitInfo ocrmFciLawsuitInfo) {
		ResponseEntity<UserInfoDTO> dto  = uaaClient.getUserSessionInfo( HeaderUtil.getAccessToken());
		ocrmFciLawsuitInfo.setLastChgSys("CRM");//最近更新系统
		ocrmFciLawsuitInfo.setLastChgUsr(dto.getBody().getLoginCode());//最近更新人ID
		ocrmFciLawsuitInfo.setLastChgDt(new Date());//最近更新日期
		ocrmFciLawsuitInfo.setRegDate(new Date());
		
		int result = ocrmFciLawsuitInfoService.modify(ocrmFciLawsuitInfo);
		return new ResultDto<Object>(result);
	}

	/**
	 * @方法名称: delete
	 * @方法描述: 诉讼信息删除
	 * @param
	 * @return
	 */
	@PostMapping("/delete")
	public ResultDto<Object> delete(@RequestBody Map<String, String> idMap) {
		int n = 0;
		if (idMap != null) {
			String ids = idMap.get("id").toString();
			String[] idStr = ids.toString().split(",");
			for (int i = 0; i < idStr.length; i++) {
				if (!"".equals(idStr[i])) {
					n = n + this.ocrmFciLawsuitInfoService.delete(idStr[i]);
				}
			}
		}

		return new ResultDto<Object>(n);
	}
}
