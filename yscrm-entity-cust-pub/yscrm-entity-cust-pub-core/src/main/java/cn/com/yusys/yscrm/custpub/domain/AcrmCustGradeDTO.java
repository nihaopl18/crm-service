package cn.com.yusys.yscrm.custpub.domain;

import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;


/**
 * @项目名称: yscrm-entity-cust-pub-core模块
 * @类名称:
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: hyx
 * @创建时间: 2019-03-28 10:18:41
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
public class AcrmCustGradeDTO extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** id **/
	@ApiModelProperty(value = "id")
	private String id;

	private String custId;
	/** 调整前评级级别 **/
	@ApiModelProperty(value = "调整前评级级别")
	private String befModGrade;
	/** 调整后评级级别 **/
	@ApiModelProperty(value = "调整后评级级别")
	private String aftModGrade;

	@ApiModelProperty(value = "状态（保存 01 确认 02）")
	private String status;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBefModGrade() {
		return befModGrade;
	}

	public void setBefModGrade(String befModGrade) {
		this.befModGrade = befModGrade;
	}

	public String getAftModGrade() {
		return aftModGrade;
	}

	public void setAftModGrade(String aftModGrade) {
		this.aftModGrade = aftModGrade;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}
}