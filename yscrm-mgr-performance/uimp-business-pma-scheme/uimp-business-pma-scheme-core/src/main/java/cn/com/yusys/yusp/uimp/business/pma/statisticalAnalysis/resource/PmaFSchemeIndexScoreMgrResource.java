package cn.com.yusys.yusp.uimp.business.pma.statisticalAnalysis.resource;

import cn.com.yusys.yusp.commons.mapper.QueryModel;
import cn.com.yusys.yusp.commons.web.rest.dto.ResultDto;
import cn.com.yusys.yusp.uimp.business.pma.statisticalAnalysis.domain.form.ManagerAssessForm;
import cn.com.yusys.yusp.uimp.business.pma.statisticalAnalysis.domain.form.MgrExcleData;
import cn.com.yusys.yusp.uimp.business.pma.statisticalAnalysis.domain.form.QueryConditionForm;
import cn.com.yusys.yusp.uimp.business.pma.statisticalAnalysis.domain.vo.PmaFSchemeIndexScoreMgrVo;
import cn.com.yusys.yusp.uimp.business.pma.statisticalAnalysis.domain.vo.SchemeScoreInfoVo;
import cn.com.yusys.yusp.uimp.business.pma.statisticalAnalysis.service.PmaFSchemeIndexScoreMgrService;
import cn.com.yusys.yusp.uimp.business.pma.statisticalAnalysis.service.impl.PmaFSchemeIndexScoreMgrServiceImpl;
import com.alibaba.fastjson.JSONArray;
import com.grapecity.documents.excel.M;
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
 * @date 2022/5/9 - 17:15
 */
@RestController
@RequestMapping("/api/pmafschemeindexscoremgr")
public class PmaFSchemeIndexScoreMgrResource {
    private final PmaFSchemeIndexScoreMgrService service;

    public PmaFSchemeIndexScoreMgrResource(PmaFSchemeIndexScoreMgrService pmaFSchemeIndexScoreMgrService) {
        this.service = pmaFSchemeIndexScoreMgrService;
    }

    /**
     * 查询客户经理的考核评分数据
     * @param
     * @return
     */
    @PostMapping("/mgrAssessSelf")
    public ResultDto<List<PmaFSchemeIndexScoreMgrVo>> mgrAssessSelf(@RequestBody QueryConditionForm queryConditionForm){

        return new ResultDto<>(service.mgrAssessSelf(queryConditionForm));
    }

    /**
     *客户经理考核评分详情
     * @param queryConditionForm
     * @return
     */
    @PostMapping("/mgrAssessIndexInfo")
    public ResultDto<List<SchemeScoreInfoVo>> mgrAssessIndexInfo(@RequestBody QueryConditionForm queryConditionForm){
        return new ResultDto<>(service.mgrAssessIndexInfo(queryConditionForm));
    }

    /**
     * excel导出客户经理考核评分
     * @param
     * @return
     */
    @GetMapping("/mgrAssessExportExcel")
    public void mgrAssessExportExcel(HttpServletRequest request, HttpServletResponse response){
        String exportData = request.getParameter("exportData");

        JSONArray data = JSONArray.parseArray(exportData);
        List<MgrExcleData> mgrExcleData = data.toJavaList(MgrExcleData.class);
        //excel的名称
        String fileName ="客户经理考核评分" + "_"  + FastDateFormat.getInstance("yyyyMMddHHmmssSSS").format(new Date());
        String sheetName = "客户经理考核评分";
        PmaFSchemeIndexScoreMgrServiceImpl.writeExcel(response, mgrExcleData, fileName, sheetName, new MgrExcleData());

    }

    /**
     * Excel导出所属所有客户经理数据
     * @param request
     * @param response
     */
    @GetMapping("/mgrAssessExportExcelAll")
    public void mgrAssessExportExcelAll(String startTime, String endTime, String managerId, String schemeId,
                                        String rankMethod, String dataIds, HttpServletRequest request, HttpServletResponse response){
        //String userId = request.getParameter("userId");
        ManagerAssessForm managerAssessForm = new ManagerAssessForm();
        managerAssessForm.setRankMethod(rankMethod);
        if (!StringUtils.isEmpty(dataIds) && dataIds.split(",").length > 0) {
            managerAssessForm.setDataIds(dataIds.split(","));
        } else {
            managerAssessForm.setStartTime(startTime);
            managerAssessForm.setEndTime(endTime);
            managerAssessForm.setManagerId(managerId);
            managerAssessForm.setSchemeId(schemeId);
        }
        service.teamAssessExportExcelAll(managerAssessForm, request,response);
//        List<String> managerIdList = service.getManagerIdList(userId);
//
//        if (managerIdList != null &&managerIdList.size()>0){
//            mgrExcleData=service.selectAll(managerIdList);
//        }else {
//            mgrExcleData=service.selectSelf(userId);
//        }
//        //excel的名称

//        PmaFSchemeIndexScoreMgrServiceImpl.

    }

}
