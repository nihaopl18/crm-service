package cn.com.yusys.yscrm.pcrm.common.remindInfo.utils;

import cn.com.yusys.yusp.admin.web.rest.util.HeaderUtil;
import cn.com.yusys.yusp.commons.security.SecurityUtils;
import cn.com.yusys.yusp.uaa.client.UaaClient;
import cn.com.yusys.yusp.uaa.client.dto.UserInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.Date;
import java.util.UUID;

public class UtilsTools {


	public static <T>T addUtl(T t) {
		Class<? extends Object> a=t.getClass();  
		try {
			Date da = new Date();
			a.getDeclaredMethod("setCreateDate", Date.class).invoke(t, da);
			a.getDeclaredMethod("setUpdateDate", Date.class).invoke(t, da);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return t;
		
		
	}
	/*
	 * 修改工具类，修改时间，修改人
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
	 * 获取UUID
	 */
	public static String getUUID() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}


}
