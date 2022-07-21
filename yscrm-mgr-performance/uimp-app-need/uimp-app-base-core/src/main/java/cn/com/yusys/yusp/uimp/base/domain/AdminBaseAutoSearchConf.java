package cn.com.yusys.yusp.uimp.base.domain;

import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


/**
 * @项目名称: uimp-app-base-core模块
 * @类名称: AdminBaseAutoSearchConf
 * @类描述: ADMIN_BASE_AUTO_SEARCH_CONF数据实体类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2020-01-17 10:54:49
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@Entity
@Table(name = "ADMIN_BASE_AUTO_SEARCH_CONF")
public class AdminBaseAutoSearchConf extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** ID **/
	@Id
	@Generated(GenerationType.UUID)
	@Column(name = "ID")
	private String id;

	/** 字段英文名 **/
	@Column(name = "FIELD_EN_NAME", unique = false, nullable = true, length = 50)
	private String fieldEnName;
	
	/** 字段中文名 **/
	@Column(name = "FIELD_CN_NAME", unique = false, nullable = true, length = 50)
	private String fieldCnName;
	
	/** 是否列展示 **/
	@Column(name = "IF_COL_SHOW", unique = false, nullable = true, length = 10)
	private String ifColShow;
	
	/** 格式化方式 **/
	@Column(name = "IF_MONEY", unique = false, nullable = true, length = 10)
	private String ifMoney;
	
	/** 是否查询项 **/
	@Column(name = "IF_SEACHER", unique = false, nullable = true, length = 10)
	private String ifSeacher;
	
	/** 数据字典 **/
	@Column(name = "IF_LOOKUP", unique = false, nullable = true, length = 100)
	private String ifLookup;
	
	/** 放大镜 **/
	@Column(name = "IF_BIG", unique = false, nullable = true, length = 10)
	private String ifBig;
	
	/** 放大镜权限 **/
	@Column(name = "BIG_GRANT", unique = false, nullable = true, length = 10)
	private String bigGrant;
	
	/** 是否主键 **/
	@Column(name = "IF_ID", unique = false, nullable = true, length = 10)
	private String ifId;
	
	/** 自动生成查询表ID **/
	@Column(name = "SEACHER_ID", unique = false, nullable = true, length = 32)
	private String seacherId;
	
	/** 查询选择 **/
	@Column(name = "IF_DATE_SEACHER", unique = false, nullable = true, length = 10)
	private String ifDateSeacher;
	
	/** 是否可排名 **/
	@Column(name = "IF_COL_SORT", unique = false, nullable = true, length = 10)
	private String ifColSort;
	
	/** 列展示顺序 **/
	@Column(name = "COL_SHOW_SORT", unique = false, nullable = true, length = 10)
	private Integer colShowSort;
	
	/** 列下钻属性tab-key**/
	@Column(name = "COL_GOING_DOWN", unique = false, nullable = true, length = 100)
	private String colGoingDown;
	
	/** 列下钻关联字段属性**/
	@Column(name = "COL_GL_PROP", unique = false, nullable = true, length = 50)
	private String colGlProp;
	
	/** 数据字典多选 **/
	@Column(name = "LOOKUP_MULTIPLE", unique = false, nullable = true, length = 10)
	private String lookupMultiple;
	
	/** 列宽度 **/
	@Column(name = "COL_WIDTH", unique = false, nullable = true, length = 10)
	private Integer colWidth;

	public String getColGlProp() {
		return colGlProp;
	}

	public void setColGlProp(String colGlProp) {
		this.colGlProp = colGlProp;
	}

	public String getIfColSort() {
		return ifColSort;
	}

	public void setIfColSort(String ifColSort) {
		this.ifColSort = ifColSort;
	}

	public Integer getColShowSort() {
		return colShowSort;
	}

	public void setColShowSort(Integer colShowSort) {
		this.colShowSort = colShowSort;
	}

	public String getColGoingDown() {
		return colGoingDown;
	}

	public void setColGoingDown(String colGoingDown) {
		this.colGoingDown = colGoingDown;
	}

	public String getLookupMultiple() {
		return lookupMultiple;
	}

	public void setLookupMultiple(String lookupMultiple) {
		this.lookupMultiple = lookupMultiple;
	}

	public Integer getColWidth() {
		return colWidth;
	}

	public void setColWidth(Integer colWidth) {
		this.colWidth = colWidth;
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
	
	/**
	 * @param fieldEnName
	 */
	public void setFieldEnName(String fieldEnName) {
		this.fieldEnName = fieldEnName == null ? null : fieldEnName.trim();
	}
	
    /**
     * @return FieldEnName
     */	
	public String getFieldEnName() {
		return this.fieldEnName;
	}
	
	/**
	 * @param fieldCnName
	 */
	public void setFieldCnName(String fieldCnName) {
		this.fieldCnName = fieldCnName == null ? null : fieldCnName.trim();
	}
	
    /**
     * @return FieldCnName
     */	
	public String getFieldCnName() {
		return this.fieldCnName;
	}
	
	/**
	 * @param ifColShow
	 */
	public void setIfColShow(String ifColShow) {
		this.ifColShow = ifColShow == null ? null : ifColShow.trim();
	}
	
    /**
     * @return IfColShow
     */	
	public String getIfColShow() {
		return this.ifColShow;
	}
	
	/**
	 * @param ifMoney
	 */
	public void setIfMoney(String ifMoney) {
		this.ifMoney = ifMoney == null ? null : ifMoney.trim();
	}
	
    /**
     * @return IfMoney
     */	
	public String getIfMoney() {
		return this.ifMoney;
	}
	
	/**
	 * @param ifSeacher
	 */
	public void setIfSeacher(String ifSeacher) {
		this.ifSeacher = ifSeacher == null ? null : ifSeacher.trim();
	}
	
    /**
     * @return IfSeacher
     */	
	public String getIfSeacher() {
		return this.ifSeacher;
	}
	
	/**
	 * @param ifLookup
	 */
	public void setIfLookup(String ifLookup) {
		this.ifLookup = ifLookup == null ? null : ifLookup.trim();
	}
	
    /**
     * @return IfLookup
     */	
	public String getIfLookup() {
		return this.ifLookup;
	}
	
	/**
	 * @param ifBig
	 */
	public void setIfBig(String ifBig) {
		this.ifBig = ifBig == null ? null : ifBig.trim();
	}
	
    /**
     * @return IfBig
     */	
	public String getIfBig() {
		return this.ifBig;
	}
	
	/**
	 * @param bigGrant
	 */
	public void setBigGrant(String bigGrant) {
		this.bigGrant = bigGrant == null ? null : bigGrant.trim();
	}
	
    /**
     * @return BigGrant
     */	
	public String getBigGrant() {
		return this.bigGrant;
	}
	
	/**
	 * @param ifId
	 */
	public void setIfId(String ifId) {
		this.ifId = ifId == null ? null : ifId.trim();
	}
	
    /**
     * @return IfId
     */	
	public String getIfId() {
		return this.ifId;
	}
	
	/**
	 * @param seacherId
	 */
	public void setSeacherId(String seacherId) {
		this.seacherId = seacherId == null ? null : seacherId.trim();
	}
	
    /**
     * @return SeacherId
     */	
	public String getSeacherId() {
		return this.seacherId;
	}
	
	/**
	 * @param ifDateSeacher
	 */
	public void setIfDateSeacher(String ifDateSeacher) {
		this.ifDateSeacher = ifDateSeacher == null ? null : ifDateSeacher.trim();
	}
	
    /**
     * @return IfDateSeacher
     */	
	public String getIfDateSeacher() {
		return this.ifDateSeacher;
	}


}