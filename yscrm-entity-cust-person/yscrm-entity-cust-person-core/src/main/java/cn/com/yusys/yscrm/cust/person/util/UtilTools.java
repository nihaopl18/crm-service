package cn.com.yusys.yscrm.cust.person.util;

import java.util.Date;

import cn.com.yusys.yusp.commons.security.SecurityUtils;

public class UtilTools {
	public static <T>T addUtl(T t) {
		Class<? extends Object> a=t.getClass();  
		try {
			String loginCode = SecurityUtils.getCurrentUserLogin();
			Date da = new Date();
			a.getDeclaredMethod("setCreateDate", Date.class).invoke(t, da);
			a.getDeclaredMethod("setCreateUser", String.class).invoke(t, loginCode);
			a.getDeclaredMethod("setUpdateDate", Date.class).invoke(t, da);
			a.getDeclaredMethod("setUpdateUser", String.class).invoke(t, loginCode);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return t;
		
		
	}
	//修改工具类，修改时间，修改人
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
}
