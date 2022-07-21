package cn.com.yusys.yusp.admin.web.config;


import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix="web", ignoreUnknownFields=false)
public class WebProperties {
	
	private String ignoreResources;
	
	private String ignoreUrls;

	public String getIgnoreResources() {
		return ignoreResources;
	}

	public void setIgnoreResources(String ignoreResources) {
		this.ignoreResources = ignoreResources;
	}

	public String getIgnoreUrls() {
		return ignoreUrls;
	}

	public void setIgnoreUrls(String ignoreUrls) {
		this.ignoreUrls = ignoreUrls;
	}


}
