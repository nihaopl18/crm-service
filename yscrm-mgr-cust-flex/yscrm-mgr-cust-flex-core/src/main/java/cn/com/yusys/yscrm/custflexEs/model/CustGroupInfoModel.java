package cn.com.yusys.yscrm.custflexEs.model;

import cn.com.yusys.yscrm.custflexEs.domain.CrmCustGroupRuleInfo;

import java.util.List;

public class CustGroupInfoModel {
	
	/**
	 * 客户群编号
	 */
	private String groupId;
	
	/**
	 * 群成员-客户编号，多客户号逗号分隔
	 */
	private String custIds;
	
	/**
	 * 规则客户群-查询规则list
	 */
	private List<CrmCustGroupRuleInfo> groupRuleInfoList;

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getCustIds() {
		return custIds;
	}

	public void setCustIds(String custIds) {
		this.custIds = custIds;
	}

	public List<CrmCustGroupRuleInfo> getGroupRuleInfoList() {
		return groupRuleInfoList;
	}

	public void setGroupRuleInfoList(List<CrmCustGroupRuleInfo> groupRuleInfoList) {
		this.groupRuleInfoList = groupRuleInfoList;
	}
}
