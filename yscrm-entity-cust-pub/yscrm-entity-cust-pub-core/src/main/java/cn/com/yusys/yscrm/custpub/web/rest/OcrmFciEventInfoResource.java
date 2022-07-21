package cn.com.yusys.yscrm.custpub.web.rest;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.com.yusys.yusp.admin.web.rest.util.HeaderUtil;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yusp.uaa.client.UaaClient;
import cn.com.yusys.yusp.uaa.client.dto.UserInfoDTO;

import cn.com.yusys.yscrm.custpub.domain.OcrmFciEventInfo;
import cn.com.yusys.yscrm.custpub.service.OcrmFciEventInfoService;
import cn.com.yusys.yscrm.custpub.service.PCustBelongViewService;

/**
 * @项目名称: yscrm-entity-cust-pub-core模块
 * @类名称: OcrmFciEventInfoResource
 * @类描述: #资源类
 * @功能描述:
 * @创建人: Administrator
 * @创建时间: 2019-02-15 15:57:54
 * @修改备注:
 * @修改记录: 修改时间 修改人员 修改原因
 *        -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/ocrmfcieventinfo")
public class OcrmFciEventInfoResource extends CommonResource<OcrmFciEventInfo, String> {
	@Autowired
	private OcrmFciEventInfoService ocrmFciEventInfoService;
	@Autowired
	private UaaClient uaaClient;
	private static final String MGR_ID = "mgrId";
	@Autowired
	private PCustBelongViewService pCustBelongViewService;

	@Override
	protected CommonService getCommonService() {
		return this.ocrmFciEventInfoService;
	}

	@GetMapping("/queryeventlist/{custId}/{topfive}")
	public ResultDto<Object> queryEventlist(@PathVariable String custId, QueryModel model,
			@PathVariable String topfive) {

		List<Map<String, Object>> list = ocrmFciEventInfoService.queryEventList(custId, model, topfive);
		return new ResultDto<Object>(list);
	}

	@GetMapping("/queryreminddec")
	public ResultDto<Object> queryRemindDec(QueryModel model) {

		List<Map<String, Object>> list = ocrmFciEventInfoService.queryRemindDec(model);
		return new ResultDto<Object>(list);
	}

	@PostMapping("/addevent")
	public ResultDto<Object> addEvent(@RequestBody OcrmFciEventInfo pool) throws URISyntaxException {
		ResponseEntity<UserInfoDTO> dto = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());
		String orgCode = dto.getBody().getOrg().getCode();
		String loginCode = dto.getBody().getLoginCode();
		String corpOrgCode = dto.getBody().getInstu().getCode();
		String returnStr = "";
		pool.setCratDt(new Date());
		pool.setCratOrgId(orgCode);
		pool.setCratUsr(loginCode);
		pool.setLastChgDt(new Date());
		pool.setLastChgSys("CRM");
		pool.setLastChgUsr(loginCode);
		pool.setCorpOrgCode(corpOrgCode);
		pool.setMaintMan(loginCode);
		pool.setRemindRuleType("RO17");// 事件提醒规则
		pool.setMaintDate(new Date());
		// 查询当前客户的归属经理
		QueryModel model = new QueryModel();
		List<Map<String, Object>> belonglist = pCustBelongViewService.queryBelongMgr(pool.getCustId(), model);
		String belongMgr = "";
		if (belonglist.size() > 0) {
			if (belonglist.get(0).get(MGR_ID) != null && !belonglist.get(0).get(MGR_ID).equals("")) {
				belongMgr = belonglist.get(0).get(MGR_ID).toString();
			}
			for (int i = 1; i < belonglist.size(); i++) {
				if (belonglist.get(i).get(MGR_ID) != null && !belonglist.get(i).get(MGR_ID).equals("")) {
					belongMgr = belongMgr + "," + belonglist.get(i).get(MGR_ID).toString();
				}

			}
			pool.setRemindObj(belongMgr);// 提醒对象 为当前客户的所有客户经理
		}

		OcrmFciEventInfo list = ocrmFciEventInfoService.insertEvent(pool);
		returnStr = list.getEventId();

		return new ResultDto<Object>(returnStr);
	}

	@PostMapping("/updateevent")
	public ResultDto<Object> updateEvent(@RequestBody OcrmFciEventInfo pool) throws URISyntaxException {
		ResponseEntity<UserInfoDTO> dto = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());
		String corpOrgCode = dto.getBody().getInstu().getCode();
		String loginCode = dto.getBody().getLoginCode();
		String returnStr = "";
		pool.setLastChgDt(new Date());
		pool.setLastChgSys("CRM");
		pool.setLastChgUsr(loginCode);
		pool.setCorpOrgCode(corpOrgCode);
		pool.setMaintMan(loginCode);
		pool.setMaintDate(new Date());
		int n = ocrmFciEventInfoService.updateEvent(pool);
		returnStr = String.valueOf(n);

		return new ResultDto<Object>(returnStr);
	}

	@PostMapping("/deleteevent")
	public ResultDto<Object> deleteEvent(@RequestBody Map idmap) {
		int n = 0;
		if (idmap != null) {
			// SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd ");//设置日期格式
			String ids = idmap.get("ids").toString();
			String[] idStr = ids.toString().split(",");
			for (int i = 0; i < idStr.length; i++) {
				if (!"".equals(idStr[i])) {
					n = n + this.ocrmFciEventInfoService.deleteEvent(idStr[i]);
				}
			}
			// logger.info("批量删除 【主键："+ids+"】 "+df.format(new Date()));
		}
		return new ResultDto<Object>(n);
	}

	@GetMapping("/selectNotice")
	public ResultDto<List<Map<String, Object>>> queryNotice(QueryModel model) {
		List<Map<String,String>> roles=(List) model.getCondition().get("roles");
		List<String> ids=new ArrayList<>();
		for (Map<String, String> map : roles) {
			ids.add(map.get("id"));
		}
		model.getCondition().put("ids", ids);
		List<Map<String, Object>> list = ocrmFciEventInfoService.selectNotice(model);
		ResultDto dto=new ResultDto<List<Map<String, Object>>>(list);
		dto.setTotal(list.size());
		return dto;
	}
	
	@GetMapping("/queryDate")
	public ResultDto<String> queryDate(){
		String date=ocrmFciEventInfoService.queryDate();
		return new ResultDto<String>(date);
	}

}
