package cn.com.yusys.yusp.uimp.business.pma.scheme.tools;

import cn.com.yusys.yusp.uaa.client.dto.UserInfoDTO;
import cn.com.yusys.yusp.uimp.base.service.UserInfoService;
import cn.com.yusys.yusp.uimp.base.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;

public class AddCommonFieldTools {


	//新增工具类
	public static  <T>T createCommonFieldFun(T t,UserInfoDTO user) {
		Class<? extends Object> objClass=t.getClass();
		String date = DateUtil.getCurrentDateTimeF();
		try {
			objClass.getDeclaredMethod("setCreateDate", String.class).invoke(t, date);
			objClass.getDeclaredMethod("setCreator", String.class).invoke(t, user.getUserId());
			objClass.getDeclaredMethod("setCreateOrg", String.class).invoke(t, user.getOrg().getId());
			objClass.getDeclaredMethod("setUpdateDate", String.class).invoke(t, date);
			objClass.getDeclaredMethod("setUpdaterId", String.class).invoke(t, user.getUserId());
			objClass.getDeclaredMethod("setUpdateOrg", String.class).invoke(t, user.getOrg().getId());
		} catch (Exception e) {
			throw new RuntimeException("获取用户信息异常");
		} 
		return t;
	}

	//修改工具类
	public static  <T>T updateCommonFieldFun(T t,UserInfoDTO user) {
		Class<? extends Object> objClass=t.getClass();
		String date = DateUtil.getCurrentDateTimeF();
		try {
			objClass.getDeclaredMethod("setUpdateDate", String.class).invoke(t, date);
			objClass.getDeclaredMethod("setUpdaterId", String.class).invoke(t, user.getUserId());
			objClass.getDeclaredMethod("setUpdateOrg", String.class).invoke(t, user.getOrg().getId());
		} catch (Exception e) {
			throw new RuntimeException("获取用户信息异常");
		}
		return t;
	}

}
