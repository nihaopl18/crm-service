package cn.com.yusys.yscrm.custpub.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

/**
 * @项目名称：crm-service
 * @类名称：OcrmFciGrantList
 * @类描述：客户授权清单表entity
 * @功能描述:
 * @创建人：yangxiao2
 * @创建时间：2019-01-16
 */
@Entity
@Table(name = "OCRM_F_CI_GRANT_LIST")
public class OcrmFciGrantList extends BaseDomain implements Serializable{
	
	private static final long serialVersionUID = 1L;

	/** 记录编号 **/
	@Id
	@Column(name = "LIST_ID")
	@Generated(GenerationType.UUID)
	private String listId;
	
	/** 申请编号 **/
	@Column(name = "APPLY_NO")
	@Generated(GenerationType.UUID)
	private java.math.BigDecimal applyNo;
	
	/** 客户编号 **/
	@Column(name = "CUST_ID", unique = false, nullable = true, length = 40)
	private String custId;
	
	/** 客户编号 **/
	@Column(name = "CUST_NAME", unique = false, nullable = true, length = 200)
	private String custName;
	
	/**
	 * @param listId
	 */
	public void setListId(String listId) {
		this.listId = listId;
	}
	
    /**
     * @return listId
     */	
	public String getListId() {
		return this.listId;
	}
	
	/**
	 * @param applyNo
	 */
	public void setApplyNo(java.math.BigDecimal applyNo) {
		this.applyNo = applyNo;
	}
	
    /**
     * @return ApplyId
     */	
	public java.math.BigDecimal getApplyNo() {
		return this.applyNo;
	}
	
	/**
	 * @param custId
	 */
	public void setCustId(String custId) {
		this.custId = custId;
	}
	
    /**
     * @return custId
     */	
	public String getCustId() {
		return this.custId;
	}
	
	/**
	 * @param custName
	 */
	public void setCustName(String custName) {
		this.custName = custName;
	}
	
    /**
     * @return custName
     */	
	public String getCustName() {
		return this.custName;
	}
	
}
