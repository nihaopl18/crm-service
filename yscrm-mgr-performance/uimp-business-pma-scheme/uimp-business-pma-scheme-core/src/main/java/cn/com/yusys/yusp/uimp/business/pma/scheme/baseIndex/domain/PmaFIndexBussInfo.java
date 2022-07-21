package cn.com.yusys.yusp.uimp.business.pma.scheme.baseIndex.domain;

import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * @项目名称: uimp-business-pma-scheme-core模块
 * @类名称: PmaFIndexBussInfo
 * @类描述: PMA_F_INDEX_BUSS_INFO数据实体类
 * @功能描述: 
 * @创建人: asus
 * @创建时间: 2020-03-16 15:20:38
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@Entity
@Table(name = "PMA_F_INDEX_BUSS_INFO")
public class PmaFIndexBussInfo extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** 逻辑主键 **/
	@Id
	@Generated(GenerationType.UUID)
	@Column(name = "ID")
	private String id;

	/** 业务主键 **/
	@Column(name = "INDEX_ID", unique = false, nullable = true, length = 20)
	private String indexId;
	
	/** 存放科目、产品之类的用于简单指标过滤数据 **/
	@Column(name = "BUSS_NO", unique = false, nullable = true, length = 20)
	private String bussNo;
	
	
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
	 * @param indexId
	 */
	public void setIndexId(String indexId) {
		this.indexId = indexId == null ? null : indexId.trim();
	}
	
    /**
     * @return IndexId
     */	
	public String getIndexId() {
		return this.indexId;
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


}