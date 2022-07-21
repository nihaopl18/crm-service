package cn.com.yusys.yscrm.custgrade.repository.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UtilsMapper {
	@Select("	SELECT ATTR.BUSI_TYPE FROM ADMIN_SM_USER USR LEFT JOIN " + 
			"   ADMIN_SM_USER_ATTR ATTR ON USR.LOGIN_CODE = ATTR.LOGIN_CODE "
			+ " WHERE 1=1 AND USR.LOGIN_CODE = #{loginCode,jdbcType=VARCHAR} ")
	public String queryUserBusiType(@Param("loginCode") String loginCode);
	}
