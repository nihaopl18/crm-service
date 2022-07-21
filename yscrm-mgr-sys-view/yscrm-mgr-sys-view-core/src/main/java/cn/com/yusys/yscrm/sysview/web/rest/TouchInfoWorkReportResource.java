package cn.com.yusys.yscrm.sysview.web.rest;

import cn.com.yusys.yscrm.sysview.domain.TouchVisitInfoDetail;
import cn.com.yusys.yscrm.sysview.service.TouchInfoWorkReportService;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author: sxm
 * @time: 2021/8/14 18:40
 */
@RestController
@RequestMapping("/api/touchinfoworkreport")
public class TouchInfoWorkReportResource {
    @Autowired
    private TouchInfoWorkReportService touchInfoWorkReportService;
    /**
     * 接触历史
     * @param queryModel
     * @return
     */
    @GetMapping("/querylist")
    public ResultDto<Map<String, Object>> getView(QueryModel queryModel) {
        return new ResultDto(touchInfoWorkReportService.getInfo(queryModel));
    }

    @GetMapping("/detail")
    public ResultDto<List<TouchVisitInfoDetail>> detail(QueryModel queryModel) {
        return new ResultDto(touchInfoWorkReportService.getDetail(queryModel));
    }
}
