package cn.com.yusys.yusp.commons.dto.def;

/**
 * 补充UserInfoDTO中没有的字段，用于前台获取登录人信息
 * @author lixt1
 */
public class UserInfoDTOUimp extends UserInfoDTO {
	private static final long serialVersionUID = -8366929034564774130L;
	
	/**
	 * 用户性别
	 */
	private String userSex;
	
	/**
	 * 手势密码，不直接返回手势密码
	 * 1存在、0不存在
	 */
	private String gesturePassword;

	public String getUserSex() {
		return userSex;
	}

	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}

	public String getGesturePassword() {
		return gesturePassword;
	}

	public void setGesturePassword(String gesturePassword) {
		this.gesturePassword = gesturePassword;
	}
	
}
