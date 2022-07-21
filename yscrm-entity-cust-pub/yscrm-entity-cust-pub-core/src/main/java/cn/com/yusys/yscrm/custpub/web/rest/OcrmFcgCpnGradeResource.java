package cn.com.yusys.yscrm.custpub.web.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yscrm.custpub.domain.OcrmFcgCpnGrade;
import cn.com.yusys.yscrm.custpub.service.OcrmFcgCpnGradeService;

/**
 * @项目名称: yscrm-entity-cust-pub-core模块
 * @类名称: OcrmFcgCpnGradeResource
 * @类描述: #资源类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2019-02-16 11:10:51
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/ocrmfcgcpngrade")
public class OcrmFcgCpnGradeResource extends CommonResource<OcrmFcgCpnGrade, String> {
    @Autowired
    private OcrmFcgCpnGradeService ocrmFcgCpnGradeService;

    @Override
    protected CommonService getCommonService() {
        return this.ocrmFcgCpnGradeService;
    }
    @GetMapping("/querygradelist/{custId}")
   	public ResultDto<Object> queryGradeList(@PathVariable String custId,QueryModel model) {
   		List<Map<String, Object>> list = ocrmFcgCpnGradeService.queryGradeList(custId,model);
   		return new ResultDto<Object>(list);
   	}
}
