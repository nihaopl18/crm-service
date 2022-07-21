package cn.com.yusys.yscrm.pcrm.common.remindInfo.domain;

import cn.com.yusys.yscrm.pcrm.common.remindInfo.utils.ExeclTitle;
import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @项目名称: yscrm-pcrm-common-core模块
 * @类名称: AcrmFwpRemindInfo
 * @类描述: #数据实体类
 * @功能描述:
 * @创建人: lufl
 * @创建时间: 2021-11-04 10:31
 * @修改备注:
 * @修改记录: 修改时间 修改人员 修改原因
 *        -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
public class DemoDTO extends BaseDomain implements Serializable {
	private static final long serialVersionUID = 1L;

	/*
	 注解对应表名称，表名与字段通过注解映射，不需要导入的字段不需要加注解
	 */
	@ExeclTitle("序号")
	private String busiId;

	@ExeclTitle("建议设计功能模块建议设计功能模块二级菜单//我的客户")
	private String remindClass;

	@ExeclTitle("建议设计功能模块建议设计功能模块二级菜单//客户查询//客户360视图")
	private String remindType;

	@ExeclTitle("序号3")
	private String receUserId;

	@ExeclTitle("序号4")
	private String receUserName;

	@ExeclTitle("序号5")
	private String infoText;

	@ExeclTitle("序号6")
	private String infoState;

	@ExeclTitle("序号7")
	private Date createDate;

	@ExeclTitle("序号8")
	private Date issueDate;


	private Date lastChgDate;

	public String getBusiId() {
		return busiId;
	}

	public void setBusiId(String busiId) {
		this.busiId = busiId;
	}

	public String getRemindClass() {
		return remindClass;
	}

	public void setRemindClass(String remindClass) {
		this.remindClass = remindClass;
	}

	public String getRemindType() {
		return remindType;
	}

	public void setRemindType(String remindType) {
		this.remindType = remindType;
	}

	public String getReceUserId() {
		return receUserId;
	}

	public void setReceUserId(String receUserId) {
		this.receUserId = receUserId;
	}

	public String getReceUserName() {
		return receUserName;
	}

	public void setReceUserName(String receUserName) {
		this.receUserName = receUserName;
	}

	public String getInfoText() {
		return infoText;
	}

	public void setInfoText(String infoText) {
		this.infoText = infoText;
	}

	public String getInfoState() {
		return infoState;
	}

	public void setInfoState(String infoState) {
		this.infoState = infoState;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public Date getLastChgDate() {
		return lastChgDate;
	}

	public void setLastChgDate(Date lastChgDate) {
		this.lastChgDate = lastChgDate;
	}
}