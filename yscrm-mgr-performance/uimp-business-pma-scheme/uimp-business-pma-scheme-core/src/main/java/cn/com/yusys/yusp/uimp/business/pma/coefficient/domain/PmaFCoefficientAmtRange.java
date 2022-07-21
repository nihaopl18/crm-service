package cn.com.yusys.yusp.uimp.business.pma.coefficient.domain;

import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * @项目名称: uimp-business-pma-scheme-core模块
 * @类名称: PmaFCoefficientAmtRange
 * @类描述: PMA_F_COEFFICIENT_AMT_RANGE数据实体类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2020-07-07 14:53:13
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@Entity
@Table(name = "PMA_F_COEFFICIENT_AMT_RANGE")
public class PmaFCoefficientAmtRange extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** 主键 **/
	@Id
	@Generated(GenerationType.UUID)
	@Column(name = "ID")
	private String id;
	/** 起始金额 **/
	@Column(name = "START_AMT", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal startAmt;
	
	/** 结束金额 **/
	@Column(name = "END_AMT", unique = false, nullable = true, length = 20)
	private java.math.BigDecimal endAmt;
	
	/** 现金折算系数 **/
	@Column(name = "AMT_COEFFICIENT", unique = false, nullable = true, length = 0)
	private java.math.BigDecimal amtCoefficient;
	
	/** 借贷标志(C存D贷) **/
	@Column(name = "CDFLAG", unique = false, nullable = true, length = 1)
	private String cdflag;
	
	
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
	

	
	/**
	 * @param startAmt
	 */
	public void setStartAmt(java.math.BigDecimal startAmt) {
		this.startAmt = startAmt;
	}
	
    /**
     * @return StartAmt
     */	
	public java.math.BigDecimal getStartAmt() {
		return this.startAmt;
	}
	
	/**
	 * @param endAmt
	 */
	public void setEndAmt(java.math.BigDecimal endAmt) {
		this.endAmt = endAmt;
	}
	
    /**
     * @return EndAmt
     */	
	public java.math.BigDecimal getEndAmt() {
		return this.endAmt;
	}
	
	/**
	 * @param amtCoefficient
	 */
	public void setAmtCoefficient(java.math.BigDecimal amtCoefficient) {
		this.amtCoefficient = amtCoefficient;
	}
	
    /**
     * @return AmtCoefficient
     */	
	public java.math.BigDecimal getAmtCoefficient() {
		return this.amtCoefficient;
	}
	
	/**
	 * @param cdflag
	 */
	public void setCdflag(String cdflag) {
		this.cdflag = cdflag == null ? null : cdflag.trim();
	}
	
    /**
     * @return Cdflag
     */	
	public String getCdflag() {
		return this.cdflag;
	}


}