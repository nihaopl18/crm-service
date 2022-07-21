package cn.com.yusys.climp.acty.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;
/**
 * @项目名称: yusp-climp-single-starter模块
 * @类名称: LoyRLFieldCostList
 * @类描述: #数据实体类
 * @功能描述: 
 * @创建人: yangxiao2@yusys.com.cn
 * @创建时间: 2019-04-23 15:37:27
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Entity
@Table(name = "LOY_RL_FIELD_COST_LIST")
public class LoyRLFieldCostList extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "ID")
	@Generated(GenerationType.UUID)
	private String id;
	
	public String getId() { return id; }
	public void setId(String id) { this.id=id; }
	
	@Column(name = "TABLE_ID")
	private String tableId;
	
	public String getTableId() { return tableId; }
	public void setTableId(String tableId) { this.tableId=tableId; }
	
	@Column(name = "COST_TYPE")
	private String costType;
	
	public String getCostType() { return costType; }
	public void setCostType(String costType) { this.costType=costType; }
	
	@Column(name = "COST_FIELD")
	private String costField;
	
	public String getCostField() { return costField; }
	public void setCostField(String costField) { this.costField=costField; }
}
