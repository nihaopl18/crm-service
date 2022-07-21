package cn.com.yusys.yscrm.sysview.web.rest;

import cn.com.yusys.yscrm.sysview.service.OcrmFwpScheduleVisitService;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author: sxm
 * @time: 2021/8/16 17:36
 */
@RestController
@RequestMapping("/api/ocrmfwpschedulevisit")
public class OcrmFwpScheduleVisitResource {
    @Autowired
    private OcrmFwpScheduleVisitService ocrmFwpScheduleVisitService;
    /**
     * 行为追踪
     * @param queryModel
     * @return
     */
    @GetMapping("/querylist")
    public ResultDto<Map<String, Object>> getView(QueryModel queryModel) {
        return new ResultDto(ocrmFwpScheduleVisitService.getWealthFunnel(queryModel));
    }
}
