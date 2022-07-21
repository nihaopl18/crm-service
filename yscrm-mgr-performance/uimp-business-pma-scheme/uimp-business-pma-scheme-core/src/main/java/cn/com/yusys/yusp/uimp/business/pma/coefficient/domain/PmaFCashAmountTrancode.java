package cn.com.yusys.yusp.uimp.business.pma.coefficient.domain;

import cn.com.yusys.yusp.commons.excel.annotation.ExcelColumn;
import cn.com.yusys.yusp.commons.excel.annotation.ExcelName;
import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * @项目名称: uimp-business-pma-scheme-core模块
 * @类名称: PmaFCashAmountTrancode
 * @类描述: PMA_F_CASH_AMOUNT_TRANCODE数据实体类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2020-07-14 10:29:34
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@Entity
@ExcelName(value = "折算系数", sheet = "工作表")
@Table(name = "PMA_F_CASH_AMOUNT_TRANCODE")
public class PmaFCashAmountTrancode extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** 主键 **/
	@Id
	@Generated(GenerationType.UUID)
	@Column(name = "ID")
	private String id;

	/** 交易代码 **/
	@ExcelColumn(title = "交易代码", index = 1)
//	@ExcelColumnUimp(title = "交易代码", index = 1)
	@Column(name = "TRANCODE", unique = false, nullable = true, length = 6)
	private String trancode;
	
	/** 交易类型名称 **/
	@ExcelColumn(title = "交易类型名称", index = 2)
//	@ExcelColumnUimp(title = "交易类型名称", index = 2)
	@Column(name = "TRANNAME", unique = false, nullable = true, length = 32)
	private String tranname;
	
	
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
	 * @param tranname
	 */
	public void setTranname(String tranname) {
		this.tranname = tranname == null ? null : tranname.trim();
	}
	
    /**
     * @return Tranname
     */	
	public String getTranname() {
		return this.tranname;
	}
	


}