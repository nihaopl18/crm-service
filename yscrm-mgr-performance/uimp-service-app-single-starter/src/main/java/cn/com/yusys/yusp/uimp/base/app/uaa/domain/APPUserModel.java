package cn.com.yusys.yusp.uimp.base.app.uaa.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @项目名称: yscrm-base-core模块
 * @类名称: APPUserModel
 * @类描述: # APP用户信息模型，登录返回数据集
 * @功能描述: 
 * @创建人: lixt1
 * @创建时间: 2019-05-11 08:54:01
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
public class APPUserModel implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String userId; // 用户ID
	private String userName; // 用户姓名
	private String loginCode; // 用户登录码
	private String userAvatar; // 用户头像
	private String orgId; // 机构编号
	private String orgName; // 机构名称
	private String upOrgId; // 上级机构编号
	private String upOrgName; // 上级机构名称
	private List<Map<String, Object>> roleList;	// 用户角色信息
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getLoginCode() {
		return loginCode;
	}
	public void setLoginCode(String loginCode) {
		this.loginCode = loginCode;
	}
	public String getUserAvatar() {
		return userAvatar;
	}
	public void setUserAvatar(String userAvatar) {
		this.userAvatar = userAvatar;
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
	public String getUpOrgId() {
		return upOrgId;
	}
	public void setUpOrgId(String upOrgId) {
		this.upOrgId = upOrgId;
	}
	public String getUpOrgName() {
		return upOrgName;
	}
	public void setUpOrgName(String upOrgName) {
		this.upOrgName = upOrgName;
	}
	public List<Map<String, Object>> getRoleList() {
		return roleList;
	}
	public void setRoleList(List<Map<String, Object>> roleList) {
		this.roleList = roleList;
	}
}
