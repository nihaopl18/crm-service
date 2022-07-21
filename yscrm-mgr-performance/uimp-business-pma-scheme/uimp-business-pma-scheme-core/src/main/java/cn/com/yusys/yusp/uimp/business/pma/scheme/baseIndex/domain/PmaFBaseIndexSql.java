package cn.com.yusys.yusp.uimp.business.pma.scheme.baseIndex.domain;

import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * @项目名称: uimp-business-pma-scheme-core模块
 * @类名称: PmaFBaseIndexSql
 * @类描述: PMA_F_BASE_INDEX_SQL数据实体类
 * @功能描述: 
 * @创建人: asus
 * @创建时间: 2020-01-06 15:54:10
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@Entity
@Table(name = "PMA_F_BASE_INDEX_SQL")
public class PmaFBaseIndexSql extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** 逻辑主键 **/
	@Id
	@Generated(GenerationType.UUID)
	@Column(name = "ID")
	private String id;

	/** 指标号 **/
	@Column(name = "INDEX_ID", unique = false, nullable = true, length = 8)
	private String indexId;
	
	/** SQL内容 **/
	@Column(name = "SQL_CONTENT", unique = false, nullable = true, length = 2000)
	private String sqlContent;
	
	
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
	 * @param sqlContent
	 */
	public void setSqlContent(String sqlContent) {
		this.sqlContent = sqlContent == null ? null : sqlContent.trim();
	}
	
    /**
     * @return SqlContent
     */	
	public String getSqlContent() {
		return this.sqlContent;
	}


}