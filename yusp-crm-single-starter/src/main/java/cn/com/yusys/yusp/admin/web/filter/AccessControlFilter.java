package cn.com.yusys.yusp.admin.web.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.authentication.BearerTokenExtractor;
import org.springframework.security.oauth2.provider.authentication.TokenExtractor;
import org.springframework.web.filter.OncePerRequestFilter;

import cn.com.yusys.yusp.admin.service.AccessService;
import cn.com.yusys.yusp.admin.web.config.WebProperties;
import cn.com.yusys.yusp.commons.security.SecurityUtils;

/**
 * 单体应用filter访问权限控制
 * @author Cytus_
 *
 */
public class AccessControlFilter extends OncePerRequestFilter {
	
	private static Logger logger = LoggerFactory.getLogger(AccessControlFilter.class);
	
	private List<String> ignoreResources = new ArrayList<>();
	
	private List<String> ignoreUrls = new ArrayList<>();
	
	public final static String ACCESS_RESOURCES = "resources";
	
	public final static String ACCESS_URLS = "urls";
	
	private TokenExtractor tokenExtractor = new BearerTokenExtractor();
	
	@Resource
	private AccessService accessService;
	
	public AccessControlFilter(WebProperties webProperties) {
		this.webProperties = webProperties;
		
	}
	
	private WebProperties webProperties;
	
	@PostConstruct
	public void init() throws ServletException {
		logger.info("Create access permission interceptor!");
		if (Objects.isNull(webProperties)) return;
		List<String> values = Arrays.asList(webProperties.getIgnoreUrls().split(",")).stream().map(s -> s.trim()).collect(Collectors.toList());
		ignoreUrls.addAll(values);
		values = Arrays.asList(webProperties.getIgnoreResources().split(",")).stream().map(s -> s.trim()).collect(Collectors.toList());
		ignoreResources.addAll(values);
	}

	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws ServletException, IOException {
		/** 请求开始时间 */
		request.setAttribute("starttime", System.currentTimeMillis());
		String requestUri = request.getRequestURI();
		
		logger.info("当期请求的url为:"+ requestUri);
		
		String loginCode = SecurityUtils.getCurrentUserLogin();

		/** 如果authorized-microservices-endpoints配置为空，则所有端点都可访问  2018-5-24修改**/
		if ((Objects.isNull(ignoreResources) || ignoreResources.isEmpty()) && (Objects.isNull(ignoreUrls) || ignoreUrls.isEmpty()) ) {
			if (logger.isDebugEnabled()) {
				logger.debug("当前未配置需要忽略的路径，默认放过所有请求权限，登录人可以任意访问!");
			}
			chain.doFilter(request, response);
			return;
		}

		if (Objects.nonNull(ignoreResources) && !ignoreResources.isEmpty()) {
			for (String str : ignoreResources) {
				if (requestUri.toLowerCase().endsWith(str.toLowerCase())) {
					if (logger.isDebugEnabled()) {
    					logger.debug("当前访问路径[{}]为默认均可访问路径!", requestUri);
                    }
					chain.doFilter(request, response);
					return;
				}
			}
		}
		
		String url = requestUri.substring(requestUri.indexOf("/", 2));
		if (Objects.nonNull(ignoreUrls) && !ignoreUrls.isEmpty()) {
			for (String str : ignoreUrls) {
				if (url.startsWith(str)) {
					if (logger.isDebugEnabled()) {
    					logger.debug("当前访问路径[{}]为默认均可访问路径!", requestUri);
                    }
					chain.doFilter(request, response);
					return;
				}
			}
		}
		boolean haveAuthority = isAuthorizedRequest(request, loginCode,  requestUri.substring(requestUri.indexOf("/", 1)));
		// modify by Cytus_ at 20181026 放出swagger访问权限
		if ("/".equals(url)) {
			haveAuthority = true;
		}
		if (haveAuthority) {
			logger.warn("用户[{}]允许访问[{}]", loginCode, requestUri);
			chain.doFilter(request, response);
			return;
		}
		
		logger.warn("用户[{}]不允许访问[{}]", loginCode, requestUri);
		response.setStatus(HttpStatus.FORBIDDEN.value());
		try {
			response.getWriter().write(HttpStatus.FORBIDDEN.getReasonPhrase());
		} finally {
			if (Objects.nonNull(response.getWriter()))
				response.getWriter().close();
		}
	}
	
	private boolean isAuthorizedRequest(HttpServletRequest request, String loginCode, String requestUri) {
        Authentication authentication = tokenExtractor.extract(request);
        if (authentication == null) {
            logger.error("请求[{}]中未获得用户[{}]token信息,请求未授权", requestUri, loginCode);
        }else{
            String accessToken = authentication.getPrincipal().toString();
			return accessService.isAuthorizedContrUrl(loginCode, requestUri, accessToken);
		}

		return false;

	}


}
