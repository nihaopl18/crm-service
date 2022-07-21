package cn.com.yusys.yusp.uimp.business.pma.statisticalAnalysis.resource;

import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yusp.uimp.business.pma.statisticalAnalysis.domain.form.*;
import cn.com.yusys.yusp.uimp.business.pma.statisticalAnalysis.domain.vo.PmaFSchemeIndexScoreOrgVo;
import cn.com.yusys.yusp.uimp.business.pma.statisticalAnalysis.domain.vo.SchemeScoreInfoVo;
import cn.com.yusys.yusp.uimp.business.pma.statisticalAnalysis.service.PmaFSchemeIndexScoreOrgService;
import cn.com.yusys.yusp.uimp.business.pma.statisticalAnalysis.service.impl.PmaFSchemeIndexScoreMgrServiceImpl;
import cn.com.yusys.yusp.uimp.business.pma.statisticalAnalysis.service.impl.PmaFSchemeIndexScoreOrgServiceImpl;
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
 * @date 2022/5/15 - 15:02
 */
@RestController
@RequestMapping("/api/pmafschemeindexscoreorgresource")
public class PmaFSchemeIndexScoreOrgResource {
    private final PmaFSchemeIndexScoreOrgService service;

    public PmaFSchemeIndexScoreOrgResource(PmaFSchemeIndexScoreOrgService service) {
        this.service = service;
    }
    /**
     * 查询机构的考核评分数据
     * @param
     * @return
     */
    @PostMapping("/orgAssessSelf")
    public ResultDto<List<PmaFSchemeIndexScoreOrgVo>> orgAssessSelf(@RequestBody QueryConditionForm queryConditionForm){

        return new ResultDto<>(service.orgAssessSelf(queryConditionForm));
    }

    /**
     *机构考核评分详情
     * @param queryConditionForm
     * @return
     */
    @PostMapping("/orgAssessIndexInfo")
    public ResultDto<List<SchemeScoreInfoVo>> orgAssessIndexInfo(@RequestBody QueryConditionForm queryConditionForm){
        return new ResultDto<>(service.orgAssessIndexInfo(queryConditionForm));
    }

    /**
     * excel导出机构考核评分
     * @param
     * @return
     */
    @GetMapping("/orgAssessExportExcel")
    public void orgAssessExportExcel(HttpServletRequest request, HttpServletResponse response){
        String exportData = request.getParameter("exportData");

        JSONArray data = JSONArray.parseArray(exportData);
        List<OrgExcleData> orgExcleData = data.toJavaList(OrgExcleData.class);
        //excel的名称
        String fileName ="机构考核评分" + "_"  + FastDateFormat.getInstance("yyyyMMddHHmmssSSS").format(new Date());
        String sheetName = "机构考核评分";
        PmaFSchemeIndexScoreOrgServiceImpl.writeExcel(response, orgExcleData, fileName, sheetName, new OrgExcleData());

    }

    /**
     * Excel导出下属所有机构数据
     * @param request
     * @param response
     */
    @GetMapping("/orgAssessExportExcelAll")
    public void orgAssessExportExcelAll(String startTime, String endTime, String orgId, String schemeId,
                                        String rankMethod, String dataIds,HttpServletRequest request, HttpServletResponse response){
        OrgAssessForm orgAssessForm = new OrgAssessForm();
        orgAssessForm.setRankMethod(rankMethod);
        if (!StringUtils.isEmpty(dataIds) && dataIds.split(",").length > 0) {
            orgAssessForm.setDataIds(dataIds.split(","));
        } else {
            orgAssessForm.setStartTime(startTime);
            orgAssessForm.setEndTime(endTime);
            orgAssessForm.setOrgId(orgId);
            orgAssessForm.setSchemeId(schemeId);
        }
        service.orgAssessExportExcelAll(orgAssessForm, request,response);
//        String userId = request.getParameter("userId");
//        List<String> managerIdList = service.getManagerIdList(userId);
//        List<MgrExcleData> mgrExcleData =new ArrayList<>();
//        if (managerIdList != null &&managerIdList.size()>0){
//            mgrExcleData=service.selectAll(managerIdList);
//        }else {
//            mgrExcleData=service.selectSelf(userId);
//        }
//        //excel的名称
//        String fileName ="机构考核评分" + "_"  + FastDateFormat.getInstance("yyyyMMddHHmmssSSS").format(new Date());
//        String sheetName = "机构考核评分";
//        PmaFSchemeIndexScoreMgrServiceImpl.writeExcel(response, mgrExcleData, fileName, sheetName, new MgrExcleData());

    }

}
