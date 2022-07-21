package cn.com.yusys.yscimc.marketmethod.domain;

import java.io.Serializable;

import javax.persistence.Entity;

import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;
/**
 *
 * @项目名称：yscimc-app-mobile
 * @类名称：CmicAppMarketActyInfo
 * @类描述：
 * @功能描述: 活动信息
 * @创建人：chenlin2@yusys.com.cn
 * @创建时间：2019-06-11
 * @修改备注：
 * @修改日期		修改人员		修改原因
 * --------    --------		----------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2019宇信科技-版权所有
 */
@Entity
public class CmicAppMarketActyInfo  extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	//活动id
	private String actyId;
	//活动标题
	private String avtivityTitle;
	//活动头图
	private String activityStartPic;
	//活动开始时间
	private String startTime;
	//活动结束时间
	private String endTime;
	//拼团人数
	private String assembleNum;
	//拼团价格
	private String assemblePrice;
	//商品类型（票券、商品、产品）
	private String prodType;
	//商品id、虚拟票券id、产品id
	private String prodInfo;
	//商品名称、虚拟票券名称、产品名称
	private String prodName;
	//商品规格ID
	private String modelId;
	//活动规则
	private String acitvityRule;
	// 活动图片
	private String markPic;
	
	public CmicAppMarketActyInfo() {
		
	}
	
	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public String getAssemblePrice() {
		return assemblePrice;
	}

	public void setAssemblePrice(String assemblePrice) {
		this.assemblePrice = assemblePrice;
	}

	public String getActyId() {
		return actyId;
	}
	public void setActyId(String actyId) {
		this.actyId = actyId;
	}
	public String getAvtivityTitle() {
		return avtivityTitle;
	}
	public void setAvtivityTitle(String avtivityTitle) {
		this.avtivityTitle = avtivityTitle;
	}
	public String getActivityStartPic() {
		return activityStartPic;
	}
	public void setActivityStartPic(String activityStartPic) {
		this.activityStartPic = activityStartPic;
	}
	
	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getAssembleNum() {
		return assembleNum;
	}

	public void setAssembleNum(String assembleNum) {
		this.assembleNum = assembleNum;
	}

	public String getProdType() {
		return prodType;
	}

	public void setProdType(String prodType) {
		this.prodType = prodType;
	}

	public String getProdInfo() {
		return prodInfo;
	}

	public void setProdInfo(String prodInfo) {
		this.prodInfo = prodInfo;
	}

	public String getModelId() {
		return modelId;
	}

	public void setModelId(String modelId) {
		this.modelId = modelId;
	}

	public String getAcitvityRule() {
		return acitvityRule;
	}
	public void setAcitvityRule(String acitvityRule) {
		this.acitvityRule = acitvityRule;
	}

	public String getMarkPic() {
		return markPic;
	}

	public void setMarkPic(String markPic) {
		this.markPic = markPic;
	}
}
