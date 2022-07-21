package cn.com.yusys.yscrm.pcrm.common.remindInfo.utils;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

public class selectroleUtils {
    public final static String MGR_ROLE_1 = "R002,R015,R018,R017,R021";
    public final static String MGR_ROLE_2 = "R003,R019,R016,R020";

    public static String getmgrType() {
        String mgrType = "";
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        String selectRole = request.getHeader("selectRole");
        if (StringUtils.isNotEmpty(selectRole)) {
            if (MGR_ROLE_1.contains(selectRole)) {
                mgrType = "1";
            } else if (MGR_ROLE_2.contains(selectRole)) {
                mgrType = "2";
            }
        }
        return mgrType;
    }

    public static String getRole() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        String selectRole = request.getHeader("selectRole");
        return selectRole;
    }
}
