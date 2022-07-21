/*
 * 代码生成器自动生成的
 * Since 2008 - 2019
 *
 */
package cn.com.yusys.yscrm.custservice.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;

import cn.com.yusys.yusp.admin.web.rest.util.HeaderUtil;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;

import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.uaa.client.UaaClient;
import cn.com.yusys.yusp.uaa.client.dto.ObjBean;
import cn.com.yusys.yusp.uaa.client.dto.UserInfoDTO;
import cn.com.yusys.yscrm.custservice.domain.OcrmFciCustFeedbackInfo;
import cn.com.yusys.yscrm.custservice.repository.mapper.OcrmFciCustFeedbackInfo1Mapper;
import cn.com.yusys.yscrm.custservice.util.DateUtils;

/**
 * @项目名称: demo模块
 * @类名称: OcrmFciCustFeedbackInfoService
 * @类描述: #服务类
 * @功能描述:
 * @创建人: 23378
 * @创建时间: 2019-02-11 16:49:43
 * @修改备注:
 * @修改记录: 修改时间 修改人员 修改原因
 *        -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
@Transactional
public class OcrmFciCustFeedbackInfo1Service extends CommonService {

	@Autowired
	private OcrmFciCustFeedbackInfo1Mapper mapper;

	@Autowired
	private UaaClient uaaClient;

	/**
	 * @方法名称: selectByModel
	 * @方法描述: 条件查询 - 查询进行分页
	 * @参数与返回说明:
	 * @算法描述: 无
	 */
	public List<OcrmFciCustFeedbackInfo> queryAll(QueryModel model) {
//		ResponseEntity<UserInfoDTO> dto = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());
//		List<ObjBean> roleList = dto.getBody().getRoles();
//		String loginCode = dto.getBody().getLoginCode();
//		String orgId = dto.getBody().getOrg().getCode();
//		boolean isCustMgr = false;
//		for (ObjBean obj : roleList) {
//			if ("15".equals(obj.getCode()) && roleList.size() == 1) {
//				isCustMgr = true;
//			}
//		}
//		// 如果不是客户经理，加入业务条线过滤条件
//		if (!isCustMgr) {
//			// 加入业务条线授权
//			if (!"500".equals(orgId)) {
//				model.getCondition().put("uncertain", " AND D.ORG_ID IN (" + queryOrgId(orgId) + ")");
//			}
//		} else {
//			String str = " AND D.MGR_ID=" + "'" + loginCode + "'";
//			model.getCondition().put("uncertain", str);
//		}
		PageHelper.startPage(model.getPage(), model.getSize());
		List<OcrmFciCustFeedbackInfo> list = mapper.queryAll(model);
		PageHelper.clearPage();
		return list;
	}

	public int insertFeedback(OcrmFciCustFeedbackInfo info) {
		int i = mapper.insertSelective(info);
		return i;
	}

	public List<OcrmFciCustFeedbackInfo> queryPer(QueryModel model) {
		PageHelper.startPage(model.getPage(), model.getSize());
		List<OcrmFciCustFeedbackInfo> list = mapper.queryPer(model);
		PageHelper.clearPage();
		return list;
	}

	@Override
	protected CommonMapper getMapper() {
		// TODO 自动生成的方法存根
		return this.mapper;
	}

	@Transactional(readOnly = true)
	public String queryOrgId(String orgId) {
		List<Map<String, String>> list = mapper.queryOrgId(orgId);
		StringBuilder sb = new StringBuilder();
		for (Map<String, String> map : list) {
			sb.append("'" + map.get("orgId") + "'" + ",");
		}
		String id = sb.toString();
		id = id.substring(0, id.lastIndexOf(","));
		return id;
	}
}
