package cn.com.yusys.yusp.util;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import cn.com.yusys.yusp.admin.web.rest.util.HeaderUtil;
import cn.com.yusys.yusp.commons.security.SecurityUtils;
import cn.com.yusys.yusp.uaa.client.UaaClient;
import cn.com.yusys.yusp.uaa.client.dto.UserInfoDTO;

public class UtilTools {
//	@Autowired
//    private UaaClient uaaClient;
	
	public static <T>T createUtl(T t) {
		Class<? extends Object> a=t.getClass();  
		try {
			String loginCode = SecurityUtils.getCurrentUserLogin();
			Date da = new Date();
			a.getDeclaredMethod("setCreateDate", Date.class).invoke(t, da);
			a.getDeclaredMethod("setCreateUser", String.class).invoke(t, loginCode);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return t;
		
		
	}
	
	/*
	 * 修改工具类，修改时间，修改人 update
	 */
	public static <T>T updateUtl(T t) {
		Class<? extends Object> a=t.getClass();
		try {
			String loginCode = SecurityUtils.getCurrentUserLogin();
			Date da = new Date();
			a.getDeclaredMethod("setUpdateDate", Date.class).invoke(t, da);
			a.getDeclaredMethod("setUpdateUser", String.class).invoke(t, loginCode);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return t;
		
	}
	
	/*
	 * 修改工具类，修改时间，修改人 last
	 */
		public static <T>T lastUtl(T t) {
			Class<? extends Object> a=t.getClass();
			try {
				String loginCode = SecurityUtils.getCurrentUserLogin();
				Date da = new Date();
				a.getDeclaredMethod("lastUpdateDate", Date.class).invoke(t, da);
				a.getDeclaredMethod("lastUpdateUser", String.class).invoke(t, loginCode);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			return t;
			
		}
//		/*
//		 * 获取当前用户信息userInfoDto
//		 */
//		public  UserInfoDTO getUserInfoDTO() {
//			ResponseEntity<UserInfoDTO> dto = uaaClient.getUserSessionInfo( HeaderUtil.getAccessToken());
//			UserInfoDTO user = dto.getBody();
//			return user;
//		}
		
		/*
		 * 获取UUID
		 */
		public static String getUUID() {
			return UUID.randomUUID().toString().replaceAll("-", "");
		}
}
