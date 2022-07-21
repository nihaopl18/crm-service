package cn.com.yusys.yscrm.sysview.web.rest;

import cn.com.yusys.yscrm.sysview.service.PcustViewHeaderService;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author: sxm
 * @time: 2021/8/11 15:41
 */
@RestController
@RequestMapping("/api/pcustviewheader")
public class PcustViewHeaderResource {
    @Autowired
    private PcustViewHeaderService pCustViewHeaderService;
    /**
     * 客户360视图header
     * @param queryModel
     * @return
     */
    @GetMapping("/querylist")
    public ResultDto<Map<String, Object>> getView(QueryModel queryModel) {
        return new ResultDto(pCustViewHeaderService.getView(queryModel));
    }

    /**
     * 客户自定义标签
     * @param queryModel
     * @return
     */
    @GetMapping("/querylabel")
    public ResultDto<Map<String, Object>> queryLabel(QueryModel queryModel) {
        return new ResultDto(pCustViewHeaderService.queryLabel(queryModel));
    }
    /**
     * 判断是否可跳转360
     * @param queryModel
     * @return
     */
    @GetMapping("/ispcustview")
    public ResultDto<Boolean> ispcustview(QueryModel queryModel) {
        return new ResultDto(pCustViewHeaderService.ispcustview(queryModel));
    }

}
