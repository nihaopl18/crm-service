package cn.com.yusys.yscrm.custmgr.domain;

public class UserInfo {

	// 用户编号
	private String userCode;

	// 用户名称
	private String userName;

	// 机构编号
	private String orgId;

	// 机构名称
	private String orgName;

	// 部门编号
	private String dptId;

	// 部门名称
	private String dptName;

	// 虚拟客户经理编号
	private String vmMgrId;

	// 虚拟客户经理名称
	private String vmMgrName;

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getVmMgrId() {
		return vmMgrId;
	}

	public void setVmMgrId(String vmMgrId) {
		this.vmMgrId = vmMgrId;
	}

	public String getVmMgrName() {
		return vmMgrName;
	}

	public void setVmMgrName(String vmMgrName) {
		this.vmMgrName = vmMgrName;
	}

	public String getDptId() {
		return dptId;
	}

	public void setDptId(String dptId) {
		this.dptId = dptId;
	}

	public String getDptName() {
		return dptName;
	}

	public void setDptName(String dptName) {
		this.dptName = dptName;
	}

}
