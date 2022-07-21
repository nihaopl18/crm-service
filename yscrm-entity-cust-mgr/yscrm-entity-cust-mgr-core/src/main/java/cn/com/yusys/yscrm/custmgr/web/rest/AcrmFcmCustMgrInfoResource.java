package cn.com.yusys.yscrm.custmgr.web.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.com.yusys.yscrm.custmgr.domain.AcrmFcmCustMgrInfo;
import cn.com.yusys.yscrm.custmgr.service.AcrmFcmCustMgrInfoService;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;

/**
 * @项目名称: yscrm-entity-cust-mgr-core模块
 * @类名称: AcrmFcmCustMgrInfoResource
 * @类描述: #资源类
 * @功能描述: 
 * @创建人: luhongyan
 * @创建时间: 2019-01-31 22:21:39
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/acrmfcmcustmgrinfo")
public class AcrmFcmCustMgrInfoResource extends CommonResource<AcrmFcmCustMgrInfo, String> {
    @Autowired
    private AcrmFcmCustMgrInfoService acrmFcmCustMgrInfoService;

    @Override
    protected CommonService getCommonService() {
        return acrmFcmCustMgrInfoService;
    }
    
    
    /**
     * 根据客户经理编号获取客户经理表单信息
     * @param queryModel
     * @param mgrId
     * @return
     */
    @GetMapping("/queryinfo/{mgrId}")
	public ResultDto<List<Map<String, Object>>> queryInfo(@PathVariable String mgrId) {
    	List<Map<String, Object>> list = acrmFcmCustMgrInfoService.queryinfo(mgrId);
		return new ResultDto<List<Map<String, Object>>>(list);
    }
    
    /**
     * 修改客户经理基本信息
     * @param acrmFcmCustMgrInfo
     * @return
     */
    @PostMapping("/updateinfo")
    public ResultDto<Object> updateInfo(@RequestBody AcrmFcmCustMgrInfo acrmFcmCustMgrInfo) {
		return new ResultDto<Object>(acrmFcmCustMgrInfoService.updateSelective(acrmFcmCustMgrInfo));
    }

}
