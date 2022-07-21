package cn.com.yusys.yscrm.custflexEs.model;


import cn.com.yusys.yscrm.custflexEs.domain.CrmFCiFqScol;
import cn.com.yusys.yscrm.custflexEs.domain.CrmFCiFqSsolution;

import java.util.List;

public class CrmFCiFqSsolutionModel {

	/**
	 * 灵活查询-方案信息
	 */
	private CrmFCiFqSsolution solutionInfo;
	
	/**
	 * 灵活查询-方案查询条件信息
	 */
	private List<CrmFCiFqScol> solutionScolInfoList;

	public CrmFCiFqSsolution getSolutionInfo() {
		return solutionInfo;
	}

	public void setSolutionInfo(CrmFCiFqSsolution solutionInfo) {
		this.solutionInfo = solutionInfo;
	}

	public List<CrmFCiFqScol> getSolutionScolInfoList() {
		return solutionScolInfoList;
	}

	public void setSolutionScolInfoList(List<CrmFCiFqScol> solutionScolInfoList) {
		this.solutionScolInfoList = solutionScolInfoList;
	}
}
