package cn.com.yusys.yscrm.custpub.domain;

import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import java.io.Serializable;


/**
 * @项目名称: yscrm-entity-cust-pub-core模块
 * @类名称: AcrmFagPerDpsBal
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: hyx
 * @创建时间: 2019-01-15 11:52:03
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
public class AcrmCustVO extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String effectDate;
	

	private String gradeName;
	

	private String gradeNo;


	private String custId;


	private String expiredDate;

	public String getEffectDate() {
		return effectDate;
	}

	public void setEffectDate(String effectDate) {
		this.effectDate = effectDate;
	}

	public String getGradeName() {
		return gradeName;
	}

	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}

	public String getGradeNo() {
		return gradeNo;
	}

	public void setGradeNo(String gradeNo) {
		this.gradeNo = gradeNo;
	}

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public String getExpiredDate() {
		return expiredDate;
	}

	public void setExpiredDate(String expiredDate) {
		this.expiredDate = expiredDate;
	}
}