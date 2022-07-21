package cn.com.yusys.yusp.admin.service;


public interface AccessService {
	
    boolean isAuthorizedContrUrl(String loginCode, String requestUri, Object token);

}
