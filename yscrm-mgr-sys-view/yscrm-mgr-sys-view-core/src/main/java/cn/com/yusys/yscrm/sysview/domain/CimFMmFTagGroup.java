package cn.com.yusys.yscrm.sysview.domain;

import cn.com.yusys.yusp.commons.mapper.domain.BaseDomain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "CIM_F_MM_TAG_GROUP")
public class CimFMmFTagGroup extends BaseDomain implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Column(name = "GROUP_NO")
    private String groupNo;

	@Column(name = "GROUP_NAME")
    private String groupName;

	@Column(name = "PARENT_NO")
    private String parentNo;
	
	@Column(name = "GROUP_DESC")
    private String groupDesc;
	
	@Column(name = "CREATE_USER")
    private String createUser;
	
	@Column(name = "CREATE_ORG")
    private String createOrg;
	
	@Column(name = "CREATE_DATE")
    private Date createDate;
	
	@Column(name = "MODIFY_USER")
    private String modifyUser;
	
	@Column(name = "MODIFY_TIME")
    private Date modifyTime;
	
	@Column(name = "CREATE_SYS")
    private String createSys;

	@Column(name = "SYSTEM_GROUP")
	private String systemGroup;

	private String count;

	private String tagCount;

	public String getSystemGroup() {
		return systemGroup;
	}

	public void setSystemGroup(String systemGroup) {
		this.systemGroup = systemGroup;
	}

	public String getTagCount() {
		return tagCount;
	}

	public void setTagCount(String tagCount) {
		this.tagCount = tagCount;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public String getModifyUser() {
		return modifyUser;
	}

	public void setModifyUser(String modifyUser) {
		this.modifyUser = modifyUser;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public String getCreateSys() {
		return createSys;
	}

	public void setCreateSys(String createSys) {
		this.createSys = createSys;
	}

	public String getGroupNo() {
		return groupNo;
	}

	public void setGroupNo(String groupNo) {
		this.groupNo = groupNo;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getParentNo() {
		return parentNo;
	}

	public void setParentNo(String parentNo) {
		this.parentNo = parentNo;
	}

	public String getGroupDesc() {
		return groupDesc;
	}

	public void setGroupDesc(String groupDesc) {
		this.groupDesc = groupDesc;
	}

	

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public String getCreateOrg() {
		return createOrg;
	}

	public void setCreateOrg(String createOrg) {
		this.createOrg = createOrg;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}