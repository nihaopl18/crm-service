package cn.com.yusys.yusp.cm.market.domain;

import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


/**
 * The persistent class for the CIMP_CM_CHANNEL_RESULT_INFO database table.
 * 
 */
@Entity
@Table(name="CIMP_CM_CHANNEL_RESULT_INFO")
public class CimpCmChannelResultInfo extends BaseDomain implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Generated(GenerationType.UUID)
	@Column(name="RESULT_ID")
	private String resultId;

	@Column(name="CUST_ID")
	private String custId;

	@Column(name="CUST_NAME")
	private String custName;

	@Column(name="FORM_ID")
	private String formId;

	@Column(name="IF_SUCCESS")
	private String ifSuccess;

	@Column(name="MARKET_TYPE")
	private String marketType;

	@Column(name="\"MESSAGE\"")
	private String message;

	@Column(name="PHONE_NUM")
	private String phoneNum;

	@Column(name="PRODUCT_ID")
	private String productId;

	@Column(name="PRODUCT_NAME")
	private String productName;

	public CimpCmChannelResultInfo() {
	}

	public String getResultId() {
		return this.resultId;
	}

	public void setResultId(String resultId) {
		this.resultId = resultId;
	}

	public String getCustId() {
		return this.custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return this.custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getFormId() {
		return this.formId;
	}

	public void setFormId(String formId) {
		this.formId = formId;
	}

	public String getIfSuccess() {
		return this.ifSuccess;
	}

	public void setIfSuccess(String ifSuccess) {
		this.ifSuccess = ifSuccess;
	}

	public String getMarketType() {
		return this.marketType;
	}

	public void setMarketType(String marketType) {
		this.marketType = marketType;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPhoneNum() {
		return this.phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getProductId() {
		return this.productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

}