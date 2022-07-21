package cn.com.yusys.yusp.uimp.bonus.model;

import java.util.List;

import cn.com.yusys.yusp.uimp.bonus.domain.PmaFsedBonusAltList;

/**
 * @项目名称: uimp-business-pma-dstr-core模块
 * @类名称: BonusAltListModel
 * @类描述: #员工奖金二次分配明细 model类
 * @功能描述: 
 * @创建人: lixt1
 * @创建时间: 2020-08-06 10:24:27
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public class BonusAltListModel {
	
	/**
	 * 数据日期
	 */
	private String statDate;
	
	/**
	 * 所属机构ID
	 */
	private String orgId;
	
	/**
	 * 分配明细数据集
	 */
	private List<PmaFsedBonusAltList> dataList;

	public String getStatDate() {
		return statDate;
	}

	public void setStatDate(String statDate) {
		this.statDate = statDate;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public List<PmaFsedBonusAltList> getDataList() {
		return dataList;
	}

	public void setDataList(List<PmaFsedBonusAltList> dataList) {
		this.dataList = dataList;
	}
}
