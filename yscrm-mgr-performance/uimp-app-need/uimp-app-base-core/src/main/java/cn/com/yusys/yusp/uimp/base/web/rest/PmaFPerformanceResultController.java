package cn.com.yusys.yusp.uimp.base.web.rest;

import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yusp.uimp.base.service.PmaFPerformanceResultService;
import io.swagger.annotations.Api;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;


/**
 * 考核指标事实表
 *
 * @author houyx3
 * @date 2022-05-11 15:43:46
 */
@Api("考核指标事实表")
@RestController
@RequestMapping("/api/pmafperformanceresult")
public class PmaFPerformanceResultController {

    private PmaFPerformanceResultService service;

    @Autowired
    private void setPmaFPerformanceResultService(PmaFPerformanceResultService service) {
        this.service = service;
    }

    protected final Log logger = LogFactory.getLog(PmaFPerformanceResultController.class);

    /**
     * 通过考核方案编号与考核对象类型查询指标信息
     * @param model 查询条件
     * @return 指标信息
     */
    @GetMapping("/getIndexList")
    public ResultDto<List<Map<String, Object>>> getIndexList(QueryModel model){
        return new ResultDto<>(service.getIndexList(model));
    }

    /**
     * 通过考核方案查询显示的动态表头
     * @param model 查询条件
     * @return 动态表头
     */
    @GetMapping("/getListTitle")
    public ResultDto<List<Map<String, Object>>> getListTitle(QueryModel model){
        return new ResultDto<>(service.getListTitle(model));
    }

    /**
     * 获取考核指标事实表-客户经理列表
     * @param model 查询条件
     * @return 客户经理考核结果信息
     */
    @GetMapping("/getListByMgr")
    public ResultDto<List<Map<String, Object>>> getListByMgr(QueryModel model){
        return service.getListByMgr(model);
    }

    /**
     * 获取考核指标事实表-团队列表
     * @param model 查询条件
     * @return 团队考核结果信息
     */
    @GetMapping("/getListByTeam")
    public ResultDto<List<Map<String, Object>>> getListByTeam(QueryModel model){
        return service.getListByTeam(model);
    }


    /**
     * 获取考核指标事实表-机构列表
     * @param model 查询条件
     * @return 机构考核结果信息
     */
    @GetMapping("/getListByOrg")
    public ResultDto<List<Map<String, Object>>> getListByOrg(QueryModel model){
        return service.getListByOrg(model);
    }

    /**
     * 导出
     */
    @GetMapping("/exportExcel")
    public void export(QueryModel model, HttpServletResponse resource){
        // 导出Excel
        //System.out.println("导出Excel");
        logger.info("导出Excel");
        service.export(model,resource);
    }

}
