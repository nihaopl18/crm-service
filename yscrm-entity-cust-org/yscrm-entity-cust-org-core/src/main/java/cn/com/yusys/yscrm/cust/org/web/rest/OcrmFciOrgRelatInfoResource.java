package cn.com.yusys.yscrm.cust.org.web.rest;

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

import cn.com.yusys.yscrm.cust.org.domain.OcrmFciOrgRelatInfo;
import cn.com.yusys.yscrm.cust.org.repository.mapper.OcrmFciOrgRelatInfoMapper;
import cn.com.yusys.yscrm.cust.org.service.OcrmFciOrgRelatInfoService;

import cn.com.yusys.yusp.admin.web.rest.util.HeaderUtil;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yusp.uaa.client.UaaClient;
import cn.com.yusys.yusp.uaa.client.dto.UserInfoDTO;

/**
 * @项目名称: demo-app-single-starter模块
 * @类名称: OcrmFciOrgRelatInfoResource
 * @类描述: #资源类
 * @功能描述: 对公涉农个性标识信息
 * @创建人: 15104
 * @创建时间: 2019-02-21 09:34:04
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/ocrmfciorgrelatinfo")
public class OcrmFciOrgRelatInfoResource extends CommonResource<OcrmFciOrgRelatInfo, String> {
    @Autowired
    private OcrmFciOrgRelatInfoService ocrmFciOrgRelatInfoService;
    @Autowired
  	private UaaClient uaaClient;
    @Autowired
    private OcrmFciOrgRelatInfoMapper crmFciOrgRelatInfoMapper;

	private static final String CUST_ID = "custId";
    @Override
    protected CommonService getCommonService() {
        return ocrmFciOrgRelatInfoService;
    }

    /**
   	 * @方法名称: querylist
   	 * @方法描述: 查询
   	 * @param
   	 * @return
   	 */
   	@GetMapping("/querylist/{custId}")
   	public ResultDto<Object> querylist(QueryModel model, @PathVariable String custId) {
   		List<Map<Object, String>> baseInfo = ocrmFciOrgRelatInfoService.querylist(model, custId);

   		return new ResultDto<Object>(baseInfo);
   	}
   	
   	/**
	 * @方法名称: save
	 * @方法描述: 保存
	 * @param
	 * @return
	 */
	@PostMapping("/save")
	public ResultDto<Object> save(@RequestBody Map c) {
		ResponseEntity<UserInfoDTO> dto  = uaaClient.getUserSessionInfo( HeaderUtil.getAccessToken());
		Map relatmodel=(Map)c.get("relatmodel");
		String custId="";
		if(c.get(CUST_ID)!=null&&!c.get(CUST_ID).equals("")) {
			custId=c.get(CUST_ID).toString();
		}
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
		String currDate=df.format(new Date());// new Date()为获取当前系统时间
		String orgCode = dto.getBody().getOrg().getCode();
		String loginCode=dto.getBody().getLoginCode();
		String corpOrgCode=dto.getBody().getInstu().getCode();
		int result;
		if(relatmodel!=null) {
			relatmodel.put(CUST_ID, custId);
			relatmodel.put("lastChgUsr", loginCode);//最新更新人
			relatmodel.put("lastChgDt", currDate);//最新更新时间
			relatmodel.put("lastOrgId", orgCode);//最新机构
			if(relatmodel.get("relatId")==null || relatmodel.get("relatId").equals("")) {
				result=ocrmFciOrgRelatInfoService.insertRelatInfo(relatmodel);
			} else {
				result=ocrmFciOrgRelatInfoService.updaterelatInfo(relatmodel);
			}
		}else{
			result=0;
		}
//		int result = ocrmFciOrgRelatInfoService.save(ocrmFciOrgRelatInfo);
		return new ResultDto<Object>(result);
	}
	
}
