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
public class AcrmCustCount extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** 客户号 **/
	@ApiModelProperty(value = "客户号")
	private String custId;
	
	/** 客户名称 **/
	@ApiModelProperty(value = "客户名称")
	private String custName;
	
	/** 数据日期 **/
	@ApiModelProperty(value = "数据日期")
	private String dataDate;

	/** 机构号 **/
	@ApiModelProperty(value = "机构号")
	private String orgId;

	/** 客户经理编号 **/
	@ApiModelProperty(value = "客户经理编号")
	private String samId;

	private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getDataDate() {
		return dataDate;
	}

	public void setDataDate(String dataDate) {
		this.dataDate = dataDate;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getSamId() {
		return samId;
	}

	public void setSamId(String samId) {
		this.samId = samId;
	}
}