package cn.com.yusys.yscrm.sysview.web.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.codahale.metrics.annotation.Timed;
import cn.com.yusys.yscrm.sysview.domain.OcrmFsysViewContr;
import cn.com.yusys.yscrm.sysview.service.OcrmFsysViewContrService;
import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.service.CommonService;
import cn.com.yusys.yusp.commons.web.rest.CommonResource;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import io.swagger.annotations.ApiParam;

/**
 * @项目名称: yscrm-mgr-sys-view模块
 * @类名称: OcrmFsysViewContrResource
 * @类描述: 视图控制点
 * @功能描述: 
 * @创建人: zhangxs4
 * @创建时间: 2019-01-17 13:50:59
 * @修改备注: 
 * @修改记录: 修改时间    修改人员    修改原因
 * -------------------------------------------------------------
 * @version 1.0.0
 * @Copyright (c) 2017宇信科技-版权所有
 */
@RestController
@RequestMapping("/api/ocrmfsysviewcontr")
public class OcrmFsysViewContrResource extends CommonResource<OcrmFsysViewContr, String> {
    @Autowired
    private OcrmFsysViewContrService ocrmFsysViewContrService;

    @Override
    protected CommonService getCommonService() {
        return ocrmFsysViewContrService;
    }
    
    /**
     * @方法名称:getContrInfo
     * @方法描述:查询控制点信息
     * @参数与返回说明:
     * @算法描述:
     */
    @GetMapping("/getcontrinfo")
    public ResultDto<List<Map<String, Object>>> getContrInfo(QueryModel queryModel) {
        List<Map<String, Object>> list = ocrmFsysViewContrService.getContrInfo(queryModel);
        return new ResultDto<List<Map<String, Object>>>(list);
    }

    /**
     * @方法名称: ifCodeReapt
     * @方法描述: 保存控制点信息前，判断是否已关联相同控制操作代码的控制点
     * @参数与返回说明:
     * @算法描述:
     */
    @GetMapping("/ifcoderepeat")
    public ResultDto<List<Map<String, Object>>> ifCodeReapt(@RequestParam(required = false) String viewItemId,
            @RequestParam(required = false) String contrCode, @RequestParam(required = false) String contrId) {
        List<Map<String, Object>> list = ocrmFsysViewContrService.ifCodeRepeat(viewItemId, contrCode, contrId);
        return new ResultDto<List<Map<String, Object>>>(list);
    }

    /**
     * @方法名称: createContr
     * @方法描述: 新增控制点信息
     * @参数与返回说明:
     * @算法描述:
     */
    @PostMapping("/createcontr")
    public ResultDto<OcrmFsysViewContr> createContr(@RequestBody OcrmFsysViewContr ocrmFsysViewContr) {
        ocrmFsysViewContr = this.ocrmFsysViewContrService.createContr(ocrmFsysViewContr);
		return new ResultDto<OcrmFsysViewContr>(ocrmFsysViewContr);
    }

    /**
     * @方法名称: editContr
     * @方法描述: 修改控制点信息
     * @参数与返回说明:
     * @算法描述:
     */
    @PostMapping("/editcontr")
    public ResultDto<OcrmFsysViewContr> editContr(@RequestBody OcrmFsysViewContr ocrmFsysViewContr) {
    	ocrmFsysViewContr = this.ocrmFsysViewContrService.editContr(ocrmFsysViewContr);
		return new ResultDto<OcrmFsysViewContr>(ocrmFsysViewContr);
    }

    /**
     * @方法名称: deleteContr
     * @方法描述: 删除控制点
     * @参数与返回说明:
     * @算法描述:
     */
    @PostMapping("/deletecontr/{ids}")
    @Timed
    protected ResultDto<Integer> deletecontr(
            @ApiParam(value = "Object Of PK id", required = true) @PathVariable String ids) {
        int result = ocrmFsysViewContrService.deleteContr(ids);
        return new ResultDto<Integer>(result);
    }

    /**
     * @方法名称: getFuncTree
     * @方法描述: 左侧树查询
     * @参数与返回说明:
     * @算法描述:
     */
    @GetMapping("/treequery")
    public ResultDto<List<Map<String, Object>>> getViewTree(QueryModel queryModel) {
        List<Map<String, Object>> list = ocrmFsysViewContrService.getViewTree(queryModel);
        return new ResultDto<List<Map<String, Object>>>(list);
    }

}
