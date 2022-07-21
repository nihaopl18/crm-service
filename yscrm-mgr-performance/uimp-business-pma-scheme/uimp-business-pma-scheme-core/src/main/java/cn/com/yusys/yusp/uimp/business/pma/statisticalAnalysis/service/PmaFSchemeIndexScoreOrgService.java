package cn.com.yusys.yusp.uimp.business.pma.statisticalAnalysis.service;

import cn.com.yusys.yusp.uimp.business.pma.statisticalAnalysis.domain.form.OrgAssessForm;
import cn.com.yusys.yusp.uimp.business.pma.statisticalAnalysis.domain.form.QueryConditionForm;
import cn.com.yusys.yusp.uimp.business.pma.statisticalAnalysis.domain.vo.PmaFSchemeIndexScoreOrgVo;
import cn.com.yusys.yusp.uimp.business.pma.statisticalAnalysis.domain.vo.SchemeScoreInfoVo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author sandMan
 * @date 2022/5/15 - 15:03
 */
public interface PmaFSchemeIndexScoreOrgService {
    /**
     * 查询机构的考核评分数据
     */
    List<PmaFSchemeIndexScoreOrgVo> orgAssessSelf(QueryConditionForm queryConditionForm);

    /**
     *机构考核评分详情
     */
    List<SchemeScoreInfoVo> orgAssessIndexInfo(QueryConditionForm queryConditionForm);

    void orgAssessExportExcelAll(OrgAssessForm orgAssessForm, HttpServletRequest request, HttpServletResponse response);
}
