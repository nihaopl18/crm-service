package cn.com.yusys.yucrm.custgroup.util;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.github.pagehelper.PageHelper;

import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.security.SecurityUtils;

public class UtilTools {
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
