package cn.com.yusys.yscrm.custmgr.web.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yscrm.custmgr.domain.AcrmAcmBusiSumD;
import cn.com.yusys.yscrm.custmgr.service.AcrmAcmBusiSumDService;

/**
 * @项目名称: yscrm-entity-cust-mgr-core模块
 * @类名称: AcrmAcmBusiSumDResource
 * @类描述: #资源类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2019-02-11 16:47:59
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/acrmacmbusisumd")
public class AcrmAcmBusiSumDResource extends CommonResource<AcrmAcmBusiSumD, String> {
    @Autowired
    private AcrmAcmBusiSumDService acrmAcmBusiSumDService;

    @Override
    protected CommonService getCommonService() {
        return acrmAcmBusiSumDService;
    }
    
    /**
 	 * @方法名称: queryInfo
 	 * @方法描述: 
 	 * @参数与返回说明:
 	 * @算法描述:
 	 */
    @GetMapping("/queryinfo/{mgrId}")
	public ResultDto<List<Map<String, Object>>> queryInfo(@PathVariable String mgrId) {
    	List<Map<String, Object>> list = acrmAcmBusiSumDService.queryInfo(mgrId);
		return new ResultDto<List<Map<String, Object>>>(list);
    }

}
