package cn.com.yusys.yscrm.cust.person.web.rest;



import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.com.yusys.yscrm.cust.person.domain.AcrmFagCcdStmt;
import cn.com.yusys.yscrm.cust.person.service.AcrmFagCcdStmtService;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;


/**
 * @项目名称: yscrm-entity-cust-person-core模块
 * @类名称: AcrmFagCcdStmtResource
 * @类描述: #资源类
 * @功能描述: 
 * @创建人: Administrator
 * @创建时间: 2019-02-16 12:13:19
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/acrmfagccdstmt")
public class AcrmFagCcdStmtResource extends CommonResource<AcrmFagCcdStmt, String> {
    @Autowired
    private AcrmFagCcdStmtService acrmFagCcdStmtService;

    @Override
    protected CommonService getCommonService() {
        return this.acrmFagCcdStmtService;
    }
    @GetMapping("/queryccdstmtlist/{custId}")
   	public ResultDto<Object> queryCcdStmtList(@PathVariable String custId,QueryModel model) {
   		List<Map<String, Object>> list = acrmFagCcdStmtService.queryCcdStmtList(custId,model);
   		return new ResultDto<Object>(list);
   	}
}
