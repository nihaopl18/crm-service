package cn.com.yusys.yusp.dycrm.transferInfo.web.rest;

import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yusp.dycrm.transferInfo.domain.AcrmFagTranDetail;
import cn.com.yusys.yusp.dycrm.transferInfo.service.AcrmFagTranDetailService;

import com.codahale.metrics.annotation.Timed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

/**
 * @version 1.0.0
 * @项目名称: dycrm-transferInfo模块
 * @类名称: AcrmFagTranDetailResource
 * @类描述: #资源类
 * @功能描述:
 * @创建人: lufl
 * @创建时间: 2021-09-02 16:47:01
 * @修改备注:
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/acrmfagtrandetail")
public class AcrmFagTranDetailResource extends CommonResource<AcrmFagTranDetail, String> {
    @Autowired
    private AcrmFagTranDetailService acrmFagTranDetailService;

    private final Logger log = LoggerFactory.getLogger(AcrmFagTranDetailResource.class);

    @Override
    protected CommonService getCommonService() {
        return acrmFagTranDetailService;
    }

    @GetMapping("/querylist")
    @Timed
    protected ResultDto<List<Map<String,Object>>> querylist(QueryModel queryModel) {
    	List<Map<String,Object>> list = acrmFagTranDetailService.querylist(queryModel);
        return new ResultDto<List<Map<String,Object>>>(list);
    }
    
    @GetMapping("/queryFlist")
    @Timed
    protected ResultDto<List<Map<String,Object>>> queryFlist(QueryModel queryModel) {
    	List<Map<String,Object>> list = acrmFagTranDetailService.queryFlist(queryModel);
        return new ResultDto<List<Map<String,Object>>>(list);
    }

    /**
     * @方法名称: export
     * @方法描述: 查询结果导出
     * @参数与返回说明:
     * @算法描述:
     */
    @GetMapping("/export")
    @Timed
    public void export(HttpServletResponse response, QueryModel model) throws IOException {
        try {
            acrmFagTranDetailService.export(model, response);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("导出失败");
        }
    }
}
