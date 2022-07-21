package cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.web.rest;

import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.domain.vo.PmaFAssessTargetVo;
import cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.service.PmaFAssessTargetService;
import cn.com.yusys.yusp.uimp.business.pma.scheme.schememain.service.impl.DownLoadCount;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * 考核目标下发表;考核目标下发表
 *
 * @author houyx3
 * @date 2022-05-19 17:41:11
 */
@Api("考核目标下发表;考核目标下发表接口")
@RestController
@RequestMapping("/api/pmafassesstarget")
public class PmaFAssessTargetResource {

    private PmaFAssessTargetService pmaFAssessTargetService;


    @Autowired
    private void setPmaFAssessTargetService(PmaFAssessTargetService pmaFAssessTargetService) {
        this.pmaFAssessTargetService = pmaFAssessTargetService;
    }

    /**
     * 查询方案下发信息
     * @param model 查询条件
     */
    @GetMapping("/getList")
    public ResultDto<List<PmaFAssessTargetVo>> getList(QueryModel model) {

        return new ResultDto<>(pmaFAssessTargetService.getList(model));
    }

    /**
     * 通过机构获取考核目标关联的考核经理
     * @param model 查询条件
     */
    @GetMapping("/getMgrBySchemeId")
    public ResultDto<List<Map<String, Object>>> getMgrBySchemeId(QueryModel model) {

        return new ResultDto<>(pmaFAssessTargetService.getMgrBySchemeId(model));
    }

    /**
     * 通过机构获取考核目标关联的团队
     * @param model 查询条件
     */
    @GetMapping("/getTemeBySchemeId")
    public ResultDto<List<Map<String, Object>>> getTemeBySchemeId(QueryModel model) {

        return new ResultDto<>(pmaFAssessTargetService.getTemeBySchemeId(model));
    }

    /**
     * 导出下发方案
     * @param id 方案id
     * @param years 年份
     * @param objIds 对象编号
     * @param indexIds 指标编号
     * @param response 响应
     */
    @GetMapping("/exportExcel")
    @DownLoadCount
    public void export(String id, String years,String objIds,String indexIds, HttpServletResponse response) {

        pmaFAssessTargetService.export(id,years,objIds,indexIds, response);

    }

    /**
     * 导入
     * @param file 文件
     */
    @PostMapping("/importExcel")
    @DownLoadCount
    public ResultDto<Integer> importExcel(@RequestBody MultipartFile file) {

        pmaFAssessTargetService.importExcel(file);
        return new ResultDto<>(0);

    }
}
