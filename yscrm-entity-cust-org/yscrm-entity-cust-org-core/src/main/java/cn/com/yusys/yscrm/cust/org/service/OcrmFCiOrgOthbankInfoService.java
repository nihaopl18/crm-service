package cn.com.yusys.yscrm.cust.org.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;

import cn.com.yusys.yscrm.cust.org.repository.mapper.OcrmFCiOrgOthbankInfoMapper;
import cn.com.yusys.yusp.admin.web.rest.util.HeaderUtil;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.uaa.client.UaaClient;
import cn.com.yusys.yusp.uaa.client.dto.UserInfoDTO;

/**
 * @项目名称: demo-app-single-starter模块
 * @类名称: OcrmFciOrgBondInfoService
 * @类描述: #服务类
 * @功能描述: 债券信息
 * @创建人: 15104
 * @创建时间: 2019-02-17 00:56:36
 * @修改备注:
 * @修改记录: 修改时间 修改人员 修改原因
 *        -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class OcrmFCiOrgOthbankInfoService extends CommonService {
	@Autowired
	private OcrmFCiOrgOthbankInfoMapper ocrmFCiOrgOthbankInfoMapper;

	@Override
	protected CommonMapper<?> getMapper() {
		return ocrmFCiOrgOthbankInfoMapper;
	}

	@Autowired
	private UaaClient uaaClient;

	// 对公他行信息查询
	public List<Map<Object, String>> getOrgOtherBank(String custId) {
		QueryModel queryModel = new QueryModel();
		PageHelper.startPage(queryModel.getPage(), queryModel.getSize());
		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("custId", custId);
		return ocrmFCiOrgOthbankInfoMapper.getOrgOtherBank(paramMap);
	}

	// 对公他行信息新增修改方法
	public int updateOtherBank(Map map) {
		ResponseEntity<UserInfoDTO> dto = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());
		String loginCode = dto.getBody().getLoginCode(); // 获取当前登录人登陆Code
		String corpOrgCode = dto.getBody().getOrg().getCode(); // 获取当前登录人所属机构
		if (map.get("id") == null || map.get("id").equals("")) {
			String id = UUID.randomUUID().toString().toLowerCase().replace("-", "");
			map.put("id", id);
			map.put("cratDt", new Date());
			map.put("cratOrgId", corpOrgCode);
			map.put("cratUsr", loginCode);
			map.put("lastChgSys", "CRM");
			map.put("lastChgUsr", loginCode);
			map.put("lastChgDt", new Date());
			return this.insertSelective(ocrmFCiOrgOthbankInfoMapper, map);
		} else {
			map.put("lastChgUsr", loginCode);
			map.put("lastChgDt", new Date());
			return this.updateSelective(ocrmFCiOrgOthbankInfoMapper, map);
		}
	}

	// 对公他行信息删除
	public Integer delOtherBank(String id) {
		return this.deleteByIds(ocrmFCiOrgOthbankInfoMapper, id);
	}

}
