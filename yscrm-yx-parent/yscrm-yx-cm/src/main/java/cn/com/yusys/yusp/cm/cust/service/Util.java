package cn.com.yusys.yusp.cm.cust.service;

import cn.com.yusys.yusp.commons.security.SecurityUtils;

import java.util.Date;

public class Util<T> {
	//新增工具类，序号，创建时间，创建人
	public static <T>T addUtl(T t) {
		Class<? extends Object> a=t.getClass();  
		try {
			String loginCode = SecurityUtils.getCurrentUserLogin();
			Date da = new Date();
			a.getDeclaredMethod("setCreateDate", Date.class).invoke(t, da);
			a.getDeclaredMethod("setCreatorId", String.class).invoke(t, loginCode);
			a.getDeclaredMethod("setLastChgDt", Date.class).invoke(t, da);
			a.getDeclaredMethod("setLastChgUsr", String.class).invoke(t, loginCode);
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
			a.getDeclaredMethod("setLastChgDt", Date.class).invoke(t, da);
			a.getDeclaredMethod("setLastChgUsr", String.class).invoke(t, loginCode);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return t;
		
	}
}
