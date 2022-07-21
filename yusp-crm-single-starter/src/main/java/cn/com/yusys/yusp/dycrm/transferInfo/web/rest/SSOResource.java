package cn.com.yusys.yusp.dycrm.transferInfo.web.rest;

import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yusp.dycrm.transferInfo.domain.AcrmFCustAcctInfo;
import cn.com.yusys.yusp.dycrm.transferInfo.service.AcrmFCustAcctInfoService;
import cn.com.yusys.yusp.dycrm.transferInfo.service.SSOService;

import com.codahale.metrics.annotation.Timed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.*;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletResponse;

/**
 * @version 1.0.0
 * @项目名称: dycrm-transferInfo模块
 * @类名称: AcrmFCustAcctInfoResource
 * @类描述: #资源类
 * @功能描述:
 * @创建人: lufl
 * @创建时间: 2021-09-02 16:47:01
 * @修改备注:
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @Copyright (c) 2017宇信科技-版权所有
 */
@Controller
@RequestMapping("/api/SSO")
public class SSOResource extends CommonResource{	
	private static final Logger logger = Logger.getLogger(SSOResource.class.getName());

    @Autowired
    private SSOService sSOService;

    @Override
    protected CommonService getCommonService() {
        return sSOService;
    }
    
    @GetMapping("/testssoLogin")
    protected String testssoLogin (Map<String, String> request,Model model,HttpServletResponse response) throws IOException {
    	
    	String _csrf = request.get("_csrf");
    	
    	String samlResponseParam = request.get("SAMLResponse");
    	
    	String username = request.get("username");
    	
    	if(username == null) {
    		username = "admin";
    	}
    	
    	model.addAttribute("ssoUrl", "0;url= http://127.0.0.1:5506?username="+username);
    	
        return "ssologin";
    }

    @PostMapping("/ssoLogin")
    protected String ssologin (@RequestBody Map<String, String> request,Model model,HttpServletResponse response) throws IOException {
    	
    	String _csrf = request.get("_csrf");
    	
    	String samlResponseParam = request.get("SAMLResponse");
    	
    	String username = request.get("username");
    	
    	if(username == null) {
    		username = "admin";
    	}
    	
    	model.addAttribute("ssoUrl", "0;url= http://127.0.0.1:5506?username="+username);
    	
        return "ssologin";
    }

}
