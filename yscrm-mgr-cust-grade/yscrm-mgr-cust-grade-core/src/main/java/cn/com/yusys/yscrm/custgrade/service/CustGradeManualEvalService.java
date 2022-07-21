package cn.com.yusys.yscrm.custgrade.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

import cn.com.yusys.yscrm.custgrade.domain.OcrmFciPreGradeApplyInfo;
import cn.com.yusys.yscrm.custgrade.repository.mapper.CustGradeManualEvalMapper;
import cn.com.yusys.yusp.admin.web.rest.util.HeaderUtil;
import cn.com.yusys.yusp.commons.mapper.CommonMapper;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.uaa.client.UaaClient;
import cn.com.yusys.yusp.uaa.client.dto.UserInfoDTO;

/**
 * @项目名称: yscrm-mgr-cust-grade-core模块
 * @类名称: CustGradeManualEvalService
 * @类描述: #服务类
 * @功能描述:
 * @创建人: Administrator
 * @创建时间: 2019-02-20 16:12:28
 * @修改备注:
 * @修改记录: 修改时间 修改人员 修改原因
 *        -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Service
public class CustGradeManualEvalService extends CommonService {
	private Logger logger = LoggerFactory.getLogger(CustGradeManualEvalService.class);
	@Autowired
	private CustGradeManualEvalMapper custGradeManualEvalMapper;

	@Override
	protected CommonMapper<?> getMapper() {
		return custGradeManualEvalMapper;
	}

	@Autowired
	private UaaClient uaaClient;
	
	//private String orgIds;

	/**
	 * 查询分组
	 * 
	 * @return
	 */
	public List<Map<String, Object>> getAll(QueryModel model) {
		PageHelper.startPage(model.getPage(), model.getSize());
		//ResponseEntity<UserInfoDTO> dto = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());
	//	String orgIds = dto.getBody().getOrg().getCode();
	//	String userCode=dto.getBody().getLoginCode();
	//	model.getCondition().put("userCode", userCode);
		List<Map<String, Object>> list = this.custGradeManualEvalMapper.querylist(model);
		PageHelper.clearPage();
		// System.out.println("ceshi ********************");
		return list;
	}
	
	public List<Map<String, Object>> getAll2(QueryModel model) {
		PageHelper.startPage(model.getPage(), model.getSize());
	//	ResponseEntity<UserInfoDTO> dto = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());
	//	String orgIds = dto.getBody().getOrg().getCode();
	//	String userCode=dto.getBody().getLoginCode();
	//	model.getCondition().put("userCode", userCode);
		List<Map<String, Object>> list = this.custGradeManualEvalMapper.querylistSingle(model);
		PageHelper.clearPage();
		// System.out.println("ceshi ********************");
		return list;
	}

	public String insertPreGradeApply(OcrmFciPreGradeApplyInfo record) {
		// 判断流程是否可以发起
		if (this.custGradeManualEvalMapper.queryIsApply(record.getCustId()) >= 1) {
			return "-2";// 流程已经在发起中
		}

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");// 设置日期格式
		Date date = new Date();
		ResponseEntity<UserInfoDTO> dto = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());
		record.setAppHours((date));
		record.setApplicant(dto.getBody().getLoginCode());// 登录ID
		record.setApplIns(dto.getBody().getOrg().getCode());
		record.setApproveStat("1");
		record.setCorpOrgCode("001");
		logger.info("新增数据：【" + record + "】 " + df.format(new Date()));
		if (this.insertSelective(custGradeManualEvalMapper, record) >= 1) {
			String applyFlag = selectApply(record).equals("A") ? "1" : "2";
			String idApplyfalg = record.getId() + "," + applyFlag;
			return idApplyfalg;
		} else
			return "-1";
	}

	public String selectApply(OcrmFciPreGradeApplyInfo record) {
		Map<String, String> currOrgMap = new HashMap();
		ResponseEntity<UserInfoDTO> dto = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());
		String orgIds = dto.getBody().getOrg().getCode();
		currOrgMap.put("custId", record.getCustId());
		currOrgMap.put("orgIds", orgIds);
		// 判断 当前申请的行是否是分行级
		List<Map<String, Object>> currOrglist = this.custGradeManualEvalMapper.queryApplyOrg(currOrgMap);
		if (this.custGradeManualEvalMapper.queryCurrOrg(String.valueOf(currOrglist.get(0).get("orgId"))) >= 1) {
			return "A";
		}
		// 找到申请行的 分行
		String currAppOrg = String.valueOf(currOrglist.get(0).get("orgId"));
		List<Map<String, Object>> upOrgmap = this.custGradeManualEvalMapper.queryUpOrg(currAppOrg);
		String orgLevel = String.valueOf(upOrgmap.get(0).get("orgLevel"));
		String currUpOrg = String.valueOf(upOrgmap.get(0).get("orgId"));
		while (!orgLevel.equals("2")) {
			upOrgmap = this.custGradeManualEvalMapper.queryUpOrg(currUpOrg);
			orgLevel = String.valueOf(upOrgmap.get(0).get("orgLevel"));
			currUpOrg = String.valueOf(upOrgmap.get(0).get("orgId"));
		}

		// 查询当前客户的归属机构
		List<Map<String, Object>> orgList = this.custGradeManualEvalMapper.queryBelongOrg(record.getCustId());
		if (orgList != null && orgList.size() != 0) {
			for (Map<String, Object> map : orgList) {
				String orgId = String.valueOf(map.get("orgId"));
				if (orgId.equals(currAppOrg)) {
					continue;
				} else {
					String upOrg = checkOrg(orgId);
					if (upOrg.equals("A")) {
						return "A";
					} else {
						if (!currUpOrg.equals(upOrg)) {
							return "A";
						}
					}
				}
			}

		}

		return "B";// 发起流程 支行流程

	}

	/**
	 * 检查 是否上级机构是分行
	 * 
	 * @return
	 */

	public String checkOrg(String orgId) {
		/**
		 * 如果当前行是 分行
		 */
		if (this.custGradeManualEvalMapper.queryCurrOrg(orgId) >= 1) {
			return "A";
		}
		List<Map<String, Object>> upOrgmap = this.custGradeManualEvalMapper.queryUpOrg(orgId);
		String orgLevel = String.valueOf(upOrgmap.get(0).get("orgLevel"));
		String currUpOrg = String.valueOf(upOrgmap.get(0).get("orgId"));
		while (!orgLevel.equals("2")) {
			upOrgmap = this.custGradeManualEvalMapper.queryUpOrg(currUpOrg);
			orgLevel = String.valueOf(upOrgmap.get(0).get("orgLevel"));
			currUpOrg = String.valueOf(upOrgmap.get(0).get("orgId"));
		}
		return currUpOrg;
	}

	public List<Map<String, Object>> getBussInfo(QueryModel queryModel) {
		List<Map<String, Object>> list = this.custGradeManualEvalMapper
				.queryBuss(String.valueOf(queryModel.getCondition().get("custId")));
		return list;
	}

	/**
	 * 执行审批操作
	 */

	public void apply(String apply, String applyStatus) {
		Map<String, String> applyMap = new HashMap();
		applyMap.put("id", apply);
		applyMap.put("approveStat", applyStatus);
		// 更新审批状态
		this.custGradeManualEvalMapper.updateApply(applyMap);
		ResponseEntity<UserInfoDTO> dto = uaaClient.getUserSessionInfo(HeaderUtil.getAccessToken());

		if (applyStatus.equals("2")) {// 审批通过执行
			OcrmFciPreGradeApplyInfo applyInfo = this.custGradeManualEvalMapper.selectByPrimaryKey(apply);
			applyMap.clear();
			// SERVICE_LEVEL=#{serviceLevel},
			// EVALUATE_TYPE='2',
			// HAND_SERVICE_LEVEL=#{handServiceLevel},
			// HAND_EVALUATE_DATE=sysdate,
			// HAND_EFFECTIVE_DATE=sysdate,
			// HAND_EXPIRED_DATE=to_date(#{handExpiredDate},'yyyy-MM-dd'),
			// LAST_CHG_USR=#{lastChgUsr},
			// LAST_CHG_DT=sysdate,
			// CORP_ORG_CODE=#{corpOrgCode}
			// WHERE CUST_ID=#{custId}
			applyMap.put("serviceLevel", applyInfo.getAppSerLevel());
			applyMap.put("handServiceLevel", applyInfo.getAppSerLevel());
			applyMap.put("handExpiredDate", applyInfo.getRatVal());
			applyMap.put("custId", applyInfo.getCustId());
			applyMap.put("lastChgUsr", dto.getBody().getLoginCode());
			applyMap.put("corpOrgCode", "001");

			this.custGradeManualEvalMapper.updateCustServal(applyMap);
			this.custGradeManualEvalMapper.updatePerCustser(applyMap);
			this.custGradeManualEvalMapper.updateOrgCustser(applyMap);
			this.custGradeManualEvalMapper.updatePerAdmit(applyMap);
			this.custGradeManualEvalMapper.updateAdmitAll(applyMap);
		}
	}

	/**
	 * 查询的审批列表
	 * 
	 * @param model
	 * @return
	 */
	public List<Map<String, Object>> queryApplyInfo(QueryModel model) {
		// return this.mapper.querylist(model);
		PageHelper.startPage(model.getPage(), model.getSize());
		List<Map<String, Object>> list = this.custGradeManualEvalMapper
				.queryApplyInfo(String.valueOf(model.getCondition().get("applyId")));
		PageHelper.clearPage();
		return list;
	}
	public int deleteApply(String ids) {
		int n=this.deleteByIds(ids);
		return n;
	}
	
	public List<Map<String, Object>> querylistByCustId(QueryModel model){
		return custGradeManualEvalMapper.querylistByCustId(model);
	}
	public String getMgrType(Map<String, String> map){
		Map<String,String> mapResult=custGradeManualEvalMapper.getMgrType(map);
		if(mapResult==null) {
			return "";
		}else {
			return mapResult.get("mgrType");
		}
	}
}
