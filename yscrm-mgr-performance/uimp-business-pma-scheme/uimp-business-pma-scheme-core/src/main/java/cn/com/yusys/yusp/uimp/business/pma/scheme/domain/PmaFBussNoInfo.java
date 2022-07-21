package cn.com.yusys.yusp.uimp.business.pma.scheme.domain;

import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * @项目名称: uimp-business-pma-scheme-core模块
 * @类名称: PmaFBussNoInfo
 * @类描述: PMA_F_BUSS_NO_INFO数据实体类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2020-02-14 15:40:55
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@Entity
@Table(name = "PMA_F_BUSS_NO_INFO")
public class PmaFBussNoInfo extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** 物理主键 **/
	@Id
	@Generated(GenerationType.UUID)
	@Column(name = "ID")
	private String id;

	/** 业务类型：贷款 LN,公司存款 CDP,零售存款 RDP,电子银行 EB,客户 CUST,理财 FNC,基金 FUN,保险 INC,贵金属 PM,信用卡 CC,票据 BILL,贷款清收 LC,表外不良贷款 OBSL **/
	@Column(name = "BUSS_TYPE", unique = false, nullable = true, length = 10)
	private String bussType;
	
	/** 业务编码号 **/
	@Column(name = "BUSS_NO", unique = false, nullable = true, length = 32)
	private String bussNo;
	
	/** 业务编码名 **/
	@Column(name = "BUSS_NAME", unique = false, nullable = true, length = 100)
	private String bussName;
	
	/** 商机业务编码 **/
	@Column(name = "HGR_BUSS_NO", unique = false, nullable = true, length = 32)
	private String hgrBussNo;
	
	/** 业务编码状态：0无效，1有效 **/
	@Column(name = "BUSS_NO_STATE", unique = false, nullable = true, length = 2)
	private String bussNoState;
	
	
	/**
	 * @param bussType
	 */
	public void setBussType(String bussType) {
		this.bussType = bussType == null ? null : bussType.trim();
	}
	
    /**
     * @return BussType
     */	
	public String getBussType() {
		return this.bussType;
	}
	
	/**
	 * @param bussNo
	 */
	public void setBussNo(String bussNo) {
		this.bussNo = bussNo == null ? null : bussNo.trim();
	}
	
    /**
     * @return BussNo
     */	
	public String getBussNo() {
		return this.bussNo;
	}
	
	/**
	 * @param bussName
	 */
	public void setBussName(String bussName) {
		this.bussName = bussName == null ? null : bussName.trim();
	}
	
    /**
     * @return BussName
     */	
	public String getBussName() {
		return this.bussName;
	}
	
	/**
	 * @param hgrBussNo
	 */
	public void setHgrBussNo(String hgrBussNo) {
		this.hgrBussNo = hgrBussNo == null ? null : hgrBussNo.trim();
	}
	
    /**
     * @return HgrBussNo
     */	
	public String getHgrBussNo() {
		return this.hgrBussNo;
	}
	
	/**
	 * @param bussNoState
	 */
	public void setBussNoState(String bussNoState) {
		this.bussNoState = bussNoState == null ? null : bussNoState.trim();
	}
	
    /**
     * @return BussNoState
     */	
	public String getBussNoState() {
		return this.bussNoState;
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