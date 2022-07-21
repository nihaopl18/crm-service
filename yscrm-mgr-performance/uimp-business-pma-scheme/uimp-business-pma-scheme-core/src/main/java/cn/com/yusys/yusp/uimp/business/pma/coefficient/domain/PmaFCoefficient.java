package cn.com.yusys.yusp.uimp.business.pma.coefficient.domain;

import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * @项目名称: uimp-business-pma-scheme-core模块
 * @类名称: PmaFCoefficient
 * @类描述: PMA_F_COEFFICIENT数据实体类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2020-07-14 10:20:52
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@Entity
@Table(name = "PMA_F_COEFFICIENT")
public class PmaFCoefficient extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** 主键 **/
	@Id
	@Generated(GenerationType.UUID)
	@Column(name = "ID")
	private String id;
	
	/** 交易代码 **/
	@Column(name = "TRANCODE", unique = false, nullable = true, length = 6)
	private String trancode;
	
	/** 交易类型名称 **/
	@Column(name = "TRANNAME", unique = false, nullable = true, length = 100)
	private String tranname;
	
	/** 折算系数 **/
	@Column(name = "COEFFICIENT", unique = false, nullable = true, length = 0)
	private java.math.BigDecimal coefficient;

	/**
	 * @param trancode
	 */
	public void setTrancode(String trancode) {
		this.trancode = trancode == null ? null : trancode.trim();
	}
	
    /**
     * @return Trancode
     */	
	public String getTrancode() {
		return this.trancode;
	}
	
	/**
	 * @param tranName
	 */
	public void setTranname(String tranname) {
		this.tranname = tranname == null ? null : tranname.trim();
	}
	
    /**
     * @return TranName
     */	
	public String getTranname() {
		return this.tranname;
	}
	
	/**
	 * @param coefficient
	 */
	public void setCoefficient(java.math.BigDecimal coefficient) {
		this.coefficient = coefficient;
	}
	
    /**
     * @return Coefficient
     */	
	public java.math.BigDecimal getCoefficient() {
		return this.coefficient;
	}
	
	/**
	 * @param id
	 */
	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}
	
    /**
     * @return Id
     */	
	public String getId() {
		return this.id;
	}


}