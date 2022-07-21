package cn.com.yusys.yusp.uimp.business.pma.scheme.postParam.domain;

import cn.com.yusys.yusp.commons.mapper.annotation.Generated;
import cn.com.yusys.yusp.commons.mapper.annotation.GenerationType;
import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * @项目名称: uimp-business-pma-scheme-core模块
 * @类名称: PmaFPersonpostParamMenu
 * @类描述: PMA_F_PERSONPOST_PARAM_MENU数据实体类
 * @功能描述: 
 * @创建人: asus
 * @创建时间: 2020-01-10 10:35:08
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 宇信科技-版权所有
 */
@Entity
@Table(name = "PMA_F_PERSONPOST_PARAM_MENU")
public class PmaFPersonpostParamMenu extends BaseDomain implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/** ID **/
	@Id
	@Generated(GenerationType.UUID)
	@Column(name = "ID")
	private String id;

	/** 目录或类型名称 **/
	@Column(name = "DIR_NAME", unique = false, nullable = true, length = 100)
	private String dirName;
	
	/** 描述 **/
	@Column(name = "REMARK", unique = false, nullable = true, length = 200)
	private String remark;
	
	/** 目录或类型所属机构编号 **/
	@Column(name = "ORG_ID", unique = false, nullable = true, length = 50)
	private String orgId;
	
	/** 约束条件 **/
	@Column(name = "CONSTR", unique = false, nullable = true, length = 30)
	private String constr;
	
	/** 数据删除标志（00-未删除，02已删除） **/
	@Column(name = "STAT_FLAG", unique = false, nullable = true, length = 2)
	private String statFlag;
	
	/** 上级目录编号 **/
	@Column(name = "PARENT_DIR_ID", unique = false, nullable = true, length = 0)
	private String parentDirId;
	
	/** 创建者 **/
	@Column(name = "CREATOR", unique = false, nullable = true, length = 50)
	private String creator;
	
	/** 修改者 **/
	@Column(name = "MODIFY_USER", unique = false, nullable = true, length = 50)
	private String modifyUser;
	
	/** 类型标识 **/
	@Column(name = "DIR_TYPE", unique = false, nullable = true, length = 2)
	private String dirType;
	
	/** 创建时间 **/
	@Column(name = "CREATE_DATE", unique = false, nullable = true, length = 20)
	private String createDate;
	
	/** 修改时间 **/
	@Column(name = "MODIFY_DATE", unique = false, nullable = true, length = 20)
	private String modifyDate;
	
	/** 生效范围(0-本机构,1-辖内机构) **/
	@Column(name = "AREA", unique = false, nullable = true, length = 10)
	private String area;
	
	/** 业务条线 **/
	@Column(name = "BUSS_SYS_NO", unique = false, nullable = true, length = 50)
	private String bussSysNo;
	
	
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
	 * @param dirName
	 */
	public void setDirName(String dirName) {
		this.dirName = dirName == null ? null : dirName.trim();
	}
	
    /**
     * @return DirName
     */	
	public String getDirName() {
		return this.dirName;
	}
	
	/**
	 * @param remark
	 */
	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}
	
    /**
     * @return Remark
     */	
	public String getRemark() {
		return this.remark;
	}
	
	/**
	 * @param orgId
	 */
	public void setOrgId(String orgId) {
		this.orgId = orgId == null ? null : orgId.trim();
	}
	
    /**
     * @return OrgId
     */	
	public String getOrgId() {
		return this.orgId;
	}
	
	/**
	 * @param constr
	 */
	public void setConstr(String constr) {
		this.constr = constr == null ? null : constr.trim();
	}
	
    /**
     * @return Constr
     */	
	public String getConstr() {
		return this.constr;
	}
	
	/**
	 * @param statFlag
	 */
	public void setStatFlag(String statFlag) {
		this.statFlag = statFlag == null ? null : statFlag.trim();
	}
	
    /**
     * @return StatFlag
     */	
	public String getStatFlag() {
		return this.statFlag;
	}
	
	/**
	 * @param parentDirId
	 */
	public void setParentDirId(String parentDirId) {
		this.parentDirId = parentDirId;
	}
	
    /**
     * @return ParentDirId
     */	
	public String getParentDirId() {
		return this.parentDirId;
	}
	
	/**
	 * @param creator
	 */
	public void setCreator(String creator) {
		this.creator = creator == null ? null : creator.trim();
	}
	
    /**
     * @return Creator
     */	
	public String getCreator() {
		return this.creator;
	}
	
	/**
	 * @param modifyUser
	 */
	public void setModifyUser(String modifyUser) {
		this.modifyUser = modifyUser == null ? null : modifyUser.trim();
	}
	
    /**
     * @return ModifyUser
     */	
	public String getModifyUser() {
		return this.modifyUser;
	}
	
	/**
	 * @param dirType
	 */
	public void setDirType(String dirType) {
		this.dirType = dirType == null ? null : dirType.trim();
	}
	
    /**
     * @return DirType
     */	
	public String getDirType() {
		return this.dirType;
	}
	
	/**
	 * @param createDate
	 */
	public void setCreateDate(String createDate) {
		this.createDate = createDate == null ? null : createDate.trim();
	}
	
    /**
     * @return CreateDate
     */	
	public String getCreateDate() {
		return this.createDate;
	}
	
	/**
	 * @param modifyDate
	 */
	public void setModifyDate(String modifyDate) {
		this.modifyDate = modifyDate == null ? null : modifyDate.trim();
	}
	
    /**
     * @return ModifyDate
     */	
	public String getModifyDate() {
		return this.modifyDate;
	}
	
	/**
	 * @param area
	 */
	public void setArea(String area) {
		this.area = area == null ? null : area.trim();
	}
	
    /**
     * @return Area
     */	
	public String getArea() {
		return this.area;
	}
	
	/**
	 * @param bussSysNo
	 */
	public void setBussSysNo(String bussSysNo) {
		this.bussSysNo = bussSysNo == null ? null : bussSysNo.trim();
	}
	
    /**
     * @return BussSysNo
     */	
	public String getBussSysNo() {
		return this.bussSysNo;
	}


}