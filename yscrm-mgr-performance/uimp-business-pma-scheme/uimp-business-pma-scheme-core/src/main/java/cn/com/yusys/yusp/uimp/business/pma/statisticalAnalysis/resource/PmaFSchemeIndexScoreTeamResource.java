package cn.com.yusys.yusp.uimp.business.pma.statisticalAnalysis.resource;

import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yusp.uimp.business.pma.statisticalAnalysis.domain.form.*;
import cn.com.yusys.yusp.uimp.business.pma.statisticalAnalysis.domain.vo.PmaFSchemeIndexScoreMgrVo;
import cn.com.yusys.yusp.uimp.business.pma.statisticalAnalysis.domain.vo.PmaFSchemeIndexScoreTeamVo;
import cn.com.yusys.yusp.uimp.business.pma.statisticalAnalysis.domain.vo.SchemeScoreInfoVo;
import cn.com.yusys.yusp.uimp.business.pma.statisticalAnalysis.service.PmaFSchemeIndexScoreTeamService;
import cn.com.yusys.yusp.uimp.business.pma.statisticalAnalysis.service.impl.PmaFSchemeIndexScoreMgrServiceImpl;
import cn.com.yusys.yusp.uimp.business.pma.statisticalAnalysis.service.impl.PmaFSchemeIndexScoreTeamServiceImpl;
import com.alibaba.fastjson.JSONArray;
import org.apache.commons.lang.time.FastDateFormat;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author sandMan
 * @date 2022/5/13 - 16:52
 */
@RestController
@RequestMapping("/api/pmafschemeindexscoreteamresource")
public class PmaFSchemeIndexScoreTeamResource {
    private final PmaFSchemeIndexScoreTeamService service;

    public PmaFSchemeIndexScoreTeamResource(PmaFSchemeIndexScoreTeamService pmaFSchemeIndexScoreTeamService) {
        this.service = pmaFSchemeIndexScoreTeamService;
    }
    /**
     * 查询客户团队的考核评分数据
     * @param
     * @return
     */
    @PostMapping("/teamAssessSelf")
    public ResultDto<List<PmaFSchemeIndexScoreTeamVo>> teamAssessSelf(@RequestBody QueryConditionForm queryConditionForm){

        return new ResultDto<>(service.teamAssessSelf(queryConditionForm));
    }
    /**
     *客户团队考核评分详情
     * @param queryConditionForm
     * @return
     */
    @PostMapping("/teamAssessIndexInfo")
    public ResultDto<List<SchemeScoreInfoVo>> teamAssessIndexInfo(@RequestBody QueryConditionForm queryConditionForm){
        return new ResultDto<>(service.teamAssessIndexInfo(queryConditionForm));
    }
    /**
     * excel导出客户团队考核评分
     * @param
     * @return
     */
    @GetMapping("/teamAssessExportExcel")
    public void teamAssessExportExcel(HttpServletRequest request, HttpServletResponse response){
        String exportData = request.getParameter("exportData");

        JSONArray data = JSONArray.parseArray(exportData);
        List<TeamExcleData> teamExcleData = data.toJavaList(TeamExcleData.class);
        //excel的名称
        String fileName ="客户团队考核评分" + "_"  + FastDateFormat.getInstance("yyyyMMddHHmmssSSS").format(new Date());
        String sheetName = "客户团队考核评分";
        PmaFSchemeIndexScoreTeamServiceImpl.writeExcel(response, teamExcleData, fileName, sheetName, new TeamExcleData());

    }

    /**
     * Excel导出所属所有客户经理数据
     * @param request
     * @param response
     */
    @GetMapping("/teamAssessExportExcelAll")
    public void teamAssessExportExcelAll(String startTime, String endTime, String teamId, String schemeId,
                                         String rankMethod, String dataIds, HttpServletRequest request, HttpServletResponse response){
        TeamAssessForm teamAssessForm = new TeamAssessForm();
        teamAssessForm.setRankMethod(rankMethod);
        if (!StringUtils.isEmpty(dataIds) && dataIds.split(",").length > 0) {
            teamAssessForm.setDataIds(dataIds.split(","));
        } else {
            teamAssessForm.setStartTime(startTime);
            teamAssessForm.setEndTime(endTime);
            teamAssessForm.setTeamId(teamId);
            teamAssessForm.setSchemeId(schemeId);
        }
        service.teamAssessExportExcelAll(teamAssessForm, request,response);
//        List<String> teamIdList = service.getTeamIdList(userId);
//
//        List<TeamExcleData> teamExcleData =new ArrayList<>();
//        if (teamIdList != null &&teamIdList.size()>0){
//            teamExcleData=service.selectAll(teamIdList);
//        }else {
//            teamExcleData=service.selectSelf(userId);
//        }
//        //excel的名称
//        String fileName ="客户团队考核评分" + "_"  + FastDateFormat.getInstance("yyyyMMddHHmmssSSS").format(new Date());
//        String sheetName = "客户团队考核评分";
//        PmaFSchemeIndexScoreTeamServiceImpl.writeExcel(response, teamExcleData, fileName, sheetName, new TeamExcleData());

    }
}
