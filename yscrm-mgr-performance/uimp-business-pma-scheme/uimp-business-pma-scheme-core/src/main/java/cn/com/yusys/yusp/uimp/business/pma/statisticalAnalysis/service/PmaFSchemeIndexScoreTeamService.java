package cn.com.yusys.yusp.uimp.business.pma.statisticalAnalysis.service;

import cn.com.yusys.yusp.uimp.business.pma.statisticalAnalysis.domain.form.QueryConditionForm;
import cn.com.yusys.yusp.uimp.business.pma.statisticalAnalysis.domain.form.TeamAssessForm;
import cn.com.yusys.yusp.uimp.business.pma.statisticalAnalysis.domain.vo.PmaFSchemeIndexScoreTeamVo;
import cn.com.yusys.yusp.uimp.business.pma.statisticalAnalysis.domain.vo.SchemeScoreInfoVo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author sandMan
 * @date 2022/5/13 - 16:52
 */
public interface PmaFSchemeIndexScoreTeamService {
    /**
     * 查询客户团队的考核评分数据
     */
    List<PmaFSchemeIndexScoreTeamVo> teamAssessSelf(QueryConditionForm queryConditionForm);
    /**
     *客户团队考核评分详情
     */
    List<SchemeScoreInfoVo> teamAssessIndexInfo(QueryConditionForm queryConditionForm);

    void teamAssessExportExcelAll(TeamAssessForm teamAssessForm, HttpServletRequest request, HttpServletResponse response);
}
