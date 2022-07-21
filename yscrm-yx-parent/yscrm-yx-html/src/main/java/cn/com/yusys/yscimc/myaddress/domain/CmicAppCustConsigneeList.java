package cn.com.yusys.yscimc.myaddress.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

/**
 * @项目名称: yscimc-app-mobile模块
 * @类名称: CmicAppCustConsigneeList
 * @类描述: #移动端用户地址维护实体类
 * @功能描述: 实体类
 * @创建人: yangxiao2
 * @创建时间: 2019-06-28 14:38:36
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
/** 移动端用户地址维护表 **/
@Table(name = "CMIC_APP_CUST_CONSIGNEE_LIST")
public class CmicAppCustConsigneeList extends BaseDomain implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	/** 收货信息编号 **/
	@Id
	@Column(name = "CONSIGNEE_ID")
	@Generated(GenerationType.UUID)
	private String consigneeId;
	
	public String getConsigneeId() { return consigneeId; }
	public void setConsigneeId(String consigneeId) { this.consigneeId=consigneeId; }
	
	/** 关联用户编号 **/
	@Column(name = "CONSIGNEE_CUST_ID")
	private String consigneeCustId;
	
	public String getConsigneeCustId() { return consigneeCustId; }
	public void setConsigneeCustId(String consigneeCustId) { this.consigneeCustId=consigneeCustId; }
	
	/** 收货人姓名 **/
	@Column(name = "CONSIGNEE_NAME")
	private String consigneeName;
	
	public String getConsigneeName() { return consigneeName; }
	public void setConsigneeName(String consigneeName) { this.consigneeName=consigneeName; }
	
	/** 收货人地址 **/
	@Column(name = "CONSIGNEE_ADDRESS")
	private String consigneeAddress;
	
	public String getConsigneeAddress() { return consigneeAddress; }
	public void setConsigneeAddress(String consigneeAddress) { this.consigneeAddress=consigneeAddress; }
	
	/** 收货人联系方式 **/
	@Column(name = "CONSIGNEE_NUMBER")
	private String consigneeNumber;
	
	public String getConsigneeNumber() { return consigneeNumber; }
	public void setConsigneeNumber(String consigneeNumber) { this.consigneeNumber=consigneeNumber; }
	
	/** 默认地址标识 **/
	@Column(name = "CONSIGNEE_DEFAULT_MARK")
	private String consigneeDefaultMark;
	
	public String getConsigneeDefaultMark() { return consigneeDefaultMark; }
	public void setConsigneeDefaultMark(String consigneeDefaultMark) { this.consigneeDefaultMark=consigneeDefaultMark; }
	
	/** CONSIGNEE_AREA **/
	@Column(name = "CONSIGNEE_AREA")
	private String consigneeArea;
	
	public String getConsigneeArea() { return consigneeArea; }
	public void setConsigneeArea(String consigneeArea) { this.consigneeArea = consigneeArea; }
	
}
