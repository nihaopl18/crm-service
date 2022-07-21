package cn.com.yusys.yscrm.cust.org.web.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.com.yusys.yscrm.cust.org.domain.AcrmFciOrgKeyFlag;
import cn.com.yusys.yscrm.cust.org.service.AcrmFciOrgKeyFlagService;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;

/**
 * @项目名称: demo-app-single-starter模块
 * @类名称: AcrmFciOrgKeyFlagResource
 * @类描述: #资源类
 * @功能描述: 对公重要标志信息
 * @创建人: 15104
 * @创建时间: 2019-02-21 09:33:24
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/acrmfciorgkeyflag")
public class AcrmFciOrgKeyFlagResource extends CommonResource<AcrmFciOrgKeyFlag, String> {
    @Autowired
    private AcrmFciOrgKeyFlagService acrmFciOrgKeyFlagService;

    @Override
    protected CommonService getCommonService() {
        return acrmFciOrgKeyFlagService;
    }

    /**
   	 * @方法名称: querylist
   	 * @方法描述: 查询
   	 * @param
   	 * @return
   	 */
   	@GetMapping("/querylist/{custId}")
   	public ResultDto<Object> querylist(QueryModel model, @PathVariable String custId) {
   		List<Map<Object, String>> baseInfo = acrmFciOrgKeyFlagService.querylist(model, custId);

   		return new ResultDto<Object>(baseInfo);
   	}
   	
   	/**
	 * @方法名称: save
	 * @方法描述: 保存
	 * @param
	 * @return
	 */
	@PostMapping("/save")
	public ResultDto<Object> save(@RequestBody Map c) {
		int result = acrmFciOrgKeyFlagService.save(c);
		return new ResultDto<Object>(result);
	}
}
