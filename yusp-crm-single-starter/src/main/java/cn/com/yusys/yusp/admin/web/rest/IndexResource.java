package cn.com.yusys.yusp.admin.web.rest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RequestMapping("/")
@Controller
public class IndexResource {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index()throws IOException { 
		return "login";
	}
	
	@RequestMapping(value = "/api-doc", method = RequestMethod.GET)
	public void apiDoc(HttpServletResponse response, String Authorization) throws IOException {
		System.out.println(Authorization);
		response.setHeader("Authorization", Authorization);
		response.sendRedirect("swagger-ui2.html");
	}
	
}
